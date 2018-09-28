<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改权限</title>
<link rel="stylesheet" href="${ctx }/resources/layui/css/layui.css" media="all" />
<link rel="stylesheet" href="${ctx }/resources/css/public.css" media="all" />
<link rel="stylesheet" href="${ctx }/resources/zTree/css/metroStyle/metroStyle.css" type="text/css">
<link rel="stylesheet" type="text/css" href="${ctx }/resources/plugin/css/index.css">
</head>
<body class="childrenBody">
	<form class="layui-form" action="#" method="post" id="frm" lay-filter="frm">
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">选择菜单</label>
				<div class="layui-input-inline">
					<div id="pid" name="pid"  class="layui-form-select select-tree"></div>
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">排序码</label>
				<div class="layui-input-inline">
					<input type="hidden" name="id" value="${permission.id }">
					<input type="text" name="ordernum" lay-verify="number" value="${permission.ordernum }"
						autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">权限名称</label>
				<div class="layui-input-inline">
					<input type="text" name="name" value="${permission.name }"  autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">权限编码</label>
				<div class="layui-input-inline">
					<input type="text" name="percode"  value="${permission.percode }" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">是否可用</label>
				<div class="layui-input-inline">
					<input type="radio" name="available" value="1" title="是" ${permission.available==1?'checked':'' }>
					<input type="radio" name="available" value="0" title="否" ${permission.available==0?'checked':'' }> 
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-input-block" style="text-align: center;">
				<!--lay-submit标记当按钮是一个提交按钮   -->
				<a  href="javascript:void(0)" class="layui-btn" lay-submit="" lay-filter="permissionSubmit">提交</a>
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
	layui.use([ 'form','jquery','layer' ], function() {
		var form=layui.form;//得到form对象
		var $=layui.jquery;
		var layer = parent.layer === undefined ? layui.layer : parent.layer;
		//添加提交事件
		form.on("submit(permissionSubmit)",function(data){
			var params=$("#frm").serialize();
			 $.post("${ctx}/permission/updatePermission.action?"+params,function(obj){
				layer.msg(obj.msg);//弹出添加成功或失败
				parent.tableIns.reload();//刷新表格
				//关闭窗口
				var index=layer.getFrameIndex(window.name);
				layer.close(index);
			})  
			
		});
	});
    $(document).ready(function () {
       initPermissionTree();
    });
    function initPermissionTree(){
    	//加载可用的权限
    	$.post("${ctx}/menu/loadMenuTree.action?available=1",function(zNodes){
    		 initSelectTree("pid",zNodes, false);
    		 var treeObj = $.fn.zTree.getZTreeObj("pidTree");
             var pid=${permission.pid};
      	     var node = treeObj.getNodeByParam("id", pid);
      	     treeObj.selectNode(node);
      	 	//渲染
     		 onClick(event,"pidTree",node);
             $(".layui-nav-item a").bind("click", function () {
                 if (!$(this).parent().hasClass("layui-nav-itemed") && !$(this).parent().parent().hasClass("layui-nav-child")) {
                     $(".layui-nav-tree").find(".layui-nav-itemed").removeClass("layui-nav-itemed")
                 }
             })
    	});
    }
</script>
</html>