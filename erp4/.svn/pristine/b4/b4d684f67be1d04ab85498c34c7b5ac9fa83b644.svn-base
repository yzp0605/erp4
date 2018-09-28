<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>角色管理--分配权限</title>
<link rel="stylesheet" href="${ctx }/resources/zTree/css/metroStyle/metroStyle.css" type="text/css">
<link rel="stylesheet" href="${ctx }/resources/layui/css/layui.css" media="all" />
<script type="text/javascript" src="${ctx }/resources/zTree/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="${ctx }/resources/zTree/js/jquery.ztree.core.min.js"></script>
<script type="text/javascript" src="${ctx }/resources/zTree/js/jquery.ztree.excheck.min.js"></script>
</head>
<body class="childrenBody">
	<ul id="treePermission" class="ztree"></ul>
	<div style="text-align: center;">
		<a href="javascript:void(0)" class="layui-btn" onclick="saveRolePermission()" >确认分配</a>
	</div>
	<script type="text/javascript" src="${ctx }/resources/layui/layui.js"></script>
</body>
<script type="text/javascript">
var setting = {
	data: {
		simpleData: {
			enable: true
		}
	},
	check:{
		enable:true
	}
};
$(document).ready(function(){
	initTree();
});
function initTree(){
	$.post("${ctx}/role/loadRolePermission.action?id=${roleVo.id}",function(zNodes){
		$.fn.zTree.init($("#treePermission"), setting, zNodes);
	})
}
var layer
layui.use('layer',function(){
	layer=layui.layer;
})
function saveRolePermission(){
	//得到树对象
	var treeObj = $.fn.zTree.getZTreeObj("treePermission");
	var nodes = treeObj.getCheckedNodes(true);
	var params="?id=${roleVo.id}";
	for(var i=0;i<nodes.length;i++){
		params+="&ids="+nodes[i].id;
	}
	 $.post("${ctx}/role/saveRolePermission.action"+params,function(obj){
		layer.msg(obj.msg);
	});
}



</script>

</html>