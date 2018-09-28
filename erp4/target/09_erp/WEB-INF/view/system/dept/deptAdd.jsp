<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>表单</title>
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
					<div id="pid" name="pid" class="layui-form-select select-tree"></div>
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
			<label class="layui-form-label">部门名称</label>
			<div class="layui-input-block">
				<input type="text" name="name" lay-verify="required" autocomplete="off"
					class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">部门地址</label>
			<div class="layui-input-block">
				<input type="text" name="loc"  autocomplete="off"
					class="layui-input">
			</div>
		</div>
		<div class="layui-form-item layui-form-text">
			<label class="layui-form-label">部门备注</label>
			<div class="layui-input-block">
				<textarea placeholder="请输入内容" name="remark" class="layui-textarea"></textarea>
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">是否展开</label>
				<div class="layui-input-inline">
					<input type="radio" name="open" value="1" title="是" >
					<input type="radio" name="open" value="0" title="否" checked=""> 
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">是否父节点</label>
				<div class="layui-input-inline">
					<input type="radio" name="parent" value="1" lay-filter="parent" title="是" >
					<input type="radio" name="parent" value="0" lay-filter="parent" title="否" checked=""> 
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
			<div class="layui-input-block" style="text-align: center;">
				<!--lay-submit标记当按钮是一个提交按钮   -->
				<a  href="javascript:void(0)" class="layui-btn" lay-submit="" lay-filter="deptSubmit">提交</a>
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
		form.on("submit(deptSubmit)",function(data){
			var params=$("#frm").serialize();
			$.post("${ctx}/dept/addDept.action?"+params,function(obj){
				layer.msg(obj.msg);//弹出添加成功或失败
				parent.tableIns.reload();//刷新表格
				parent.parent.left.initTree();//刷新左边的树
				//关闭窗口
				var index=layer.getFrameIndex(window.name);
				layer.close(index);
			}) 
			
		});
	});
    $(document).ready(function () {
       initDeptTree();
    });
    function initDeptTree(){
    	//加载可用的部门
    	$.post("${ctx}/dept/loadDeptTree.action?available=1",function(zNodes){
    		 initSelectTree("pid",zNodes, false);
             $(".layui-nav-item a").bind("click", function () {
                 if (!$(this).parent().hasClass("layui-nav-itemed") && !$(this).parent().parent().hasClass("layui-nav-child")) {
                     $(".layui-nav-tree").find(".layui-nav-itemed").removeClass("layui-nav-itemed")
                 }
             })
    	});
    }
</script>
</html>