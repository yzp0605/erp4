<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加用户</title>
<link rel="stylesheet" href="${ctx }/resources/layui/css/layui.css" media="all" />
<link rel="stylesheet" href="${ctx }/resources/css/public.css" media="all" />
<link rel="stylesheet" href="${ctx }/resources/zTree/css/metroStyle/metroStyle.css" type="text/css">
<link rel="stylesheet" type="text/css" href="${ctx }/resources/plugin/css/index.css">
</head>
<body class="childrenBody">
	<form class="layui-form" action="#" method="post" id="frm" lay-filter="frm">
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">选择部门</label>
				<div class="layui-input-inline">
					<div id="deptid" name="deptid" class="layui-form-select select-tree"></div>
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">排序码</label>
				<div class="layui-input-inline">
					<input type="text" name="ordernum" lay-verify="number"
						autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">领导部门</label>
				<div class="layui-input-inline">
					<div id="leaderdeptid" name="leaderdeptid" class="layui-form-select select-tree"></div>
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">选择领导</label>
				<div class="layui-input-inline">
					<select name="mgr" lay-filter="mgr" id="mgr">
				        <option value=""></option>
				      </select>
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">用户姓名</label>
				<div class="layui-input-inline">
					<input type="text" name="name" id="name" lay-verify="required" autocomplete="off"
						class="layui-input">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">登陆名称</label>
				<div class="layui-input-block">
					<input type="text" name="loginname" id="loginname"  autocomplete="off"
						class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-form-item layui-form-text">
			<label class="layui-form-label">用户地址</label>
			<div class="layui-input-block">
				<input type="text" name="address"  autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item layui-form-text">
			<label class="layui-form-label">用户备注</label>
			<div class="layui-input-block">
				<textarea placeholder="请输入内容" name="remark" class="layui-textarea"></textarea>
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">用户性别</label>
				<div class="layui-input-inline">
					<input type="radio" name="sex" value="1" title="男" checked="">
					<input type="radio" name="sex" value="0" title="女" > 
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">是否可用</label>
				<div class="layui-input-inline">
					<input type="radio" name="available" value="1" title="是" checked="">
					<input type="radio" name="available" value="0" title="否"> 
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">入职时间</label>
				<div class="layui-input-inline">
					<input type="text" name="hiredate" id="hiredate"  autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-input-block" style="text-align: center;">
				<!--lay-submit标记当按钮是一个提交按钮   -->
				<a  href="javascript:void(0)" class="layui-btn" lay-submit="" lay-filter="userSubmit">提交</a>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
			</div>
		</div>
	</form>
</body>
<script type="text/javascript" src="${ctx }/resources/layui/layui.js"></script>
<script type="text/javascript" src="${ctx }/resources/zTree/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="${ctx }/resources/zTree/js/jquery.ztree.core.js"></script>
<script type="text/javascript" src="${ctx }/resources/plugin/js/selectTree.js"></script>
<script type="text/javascript">
var form;
	layui.use([ 'form','jquery','layer','laydate' ], function() {
		form=layui.form;//得到form对象
		var $=layui.jquery;
		var laydate=layui.laydate;
		var layer = parent.layer === undefined ? layui.layer : parent.layer;
		
		//时间选择器的绑定
		laydate.render({
			elem:'#hiredate'
		});
		//添加提交事件
		form.on("submit(userSubmit)",function(data){
			var params=$("#frm").serialize();
			$.post("${ctx}/user/addUser.action?"+params,function(obj){
				layer.msg(obj.msg);//弹出添加成功或失败
				parent.tableIns.reload();//刷新表格
				//关闭窗口
				var index=layer.getFrameIndex(window.name);
				layer.close(index);
			}); 
		});
		 //监听用户姓名的失去焦点事件
	    $("#name").on("blur",function(){
	    	//请求后台，把中文转成拼音
		    //var name=$(this).val();
	    	var name=this.value;
	    	$.post("${ctx}/user/initUserLoginNameUseUserName.action",{name:name},function(obj){
	    		$("#loginname").val(obj);
	    	});
	    })
	});
    $(document).ready(function () {
       initDeptTree();
    });
    function initDeptTree(){
    	//加载可用的部门
    	$.post("${ctx}/dept/loadDeptTree.action?available=1",function(zNodes){
    		 initSelectTree("deptid",zNodes, false);
    		 initSelectTree("leaderdeptid",zNodes, false);
             $(".layui-nav-item a").bind("click", function () {
                 if (!$(this).parent().hasClass("layui-nav-itemed") && !$(this).parent().parent().hasClass("layui-nav-child")) {
                     $(".layui-nav-tree").find(".layui-nav-itemed").removeClass("layui-nav-itemed")
                 }
             })
    	});
    };
    //根据部门编号查询部门下面的所有员工
    function initMgr(deptid){
    	//alert(deptid);
    	$.post("${ctx}/user/loadUserByDeptId.action",{deptid:deptid},function(obj){
    		var html="";
    		for(var i=0;i<obj.length;i++){
    			html+=" <option value="+obj[i].id+">"+obj[i].name+"</option>"
    		}
    		$("#mgr").html(html);
    		form.render("select");//重新渲染
    	},"json");
    }
    
   
</script>
</html>