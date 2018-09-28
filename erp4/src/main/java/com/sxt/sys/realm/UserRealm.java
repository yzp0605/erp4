package com.sxt.sys.realm;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.sxt.sys.constast.SYS_Constast;
import com.sxt.sys.domain.Permission;
import com.sxt.sys.domain.Role;
import com.sxt.sys.domain.User;
import com.sxt.sys.service.PermissionService;
import com.sxt.sys.service.RoleService;
import com.sxt.sys.service.UserService;
import com.sxt.sys.utils.ActiverUser;
/**
 * shrio的自定义realm
 * @author LJH
 *
 */
public class UserRealm extends AuthorizingRealm{

	@Autowired
	private UserService userService;
	
	@Autowired
	private PermissionService permissionService;
	
	@Autowired
	private RoleService roleService;
	
	/**
	 * 认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//1,得到身份
		String loginname=token.getPrincipal().toString();
		//2,根据身份查询用户信息
		User user=this.userService.queryUserByLoginName(loginname);
		if(null!=user) {
			String dbPassword=user.getPwd();//数据库加密的密码
			ActiverUser activerUser=new ActiverUser();
			activerUser.setCurUser(user);
			//根据用户ID查询角色
			List<Role> roleList=roleService.queryRoleByUserId(user.getId());
			List<String> roles=new ArrayList<>();
			for (Role role : roleList) {
				roles.add(role.getName());
			}
			//根据用户ID查询权限
			List<Permission> permissionList=this.permissionService.queryPermissionByUserIdForList(SYS_Constast.PERMISSION_TYPE_PERMISSION,user.getId());
			List<String> permissions=new ArrayList<>();
			for (Permission permission : permissionList) {
					permissions.add(permission.getPercode());
			}
			//放到activerUser
			activerUser.setRoles(roles);
			activerUser.setPermissions(permissions);
			//盐
			ByteSource credentialsSalt=ByteSource.Util.bytes(user.getSalt());
			AuthenticationInfo info=new SimpleAuthenticationInfo(activerUser, dbPassword, credentialsSalt, getName());
			return info;
		}else {
			return null;
		}
	}
	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
		//得到activerUser
		ActiverUser activerUser =(ActiverUser) principals.getPrimaryPrincipal();
		if(activerUser.getCurUser().getType()==SYS_Constast.USER_TYPE_SUPER) {
			//如果是系统内置用户，所有的按钮都可以看到
			info.addRole("*");
			info.addStringPermission("*:*");  
		}else {
			if(activerUser.getRoles().size()>0) {
				info.addRoles(activerUser.getRoles());
			}
			if(activerUser.getPermissions().size()>0) {
				info.addStringPermissions(activerUser.getPermissions());
			}
		}
		return info;
	}
}
