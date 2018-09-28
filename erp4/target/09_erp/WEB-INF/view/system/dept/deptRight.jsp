<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>部门管理--右边的数据表格</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" href="${ctx }/resources/layui/css/layui.css" media="all" />
	<link rel="stylesheet" href="${ctx }/resources/css/public.css" media="all" />
</head>
<body class="childrenBody">
<!-- 查询条件开始 -->
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 5px;">
  <legend>查询条件</legend>
</fieldset>
<form class="layui-form" id="searchFrm">
	<div class="layui-form-item">
	    <div class="layui-inline">
	      <label class="layui-form-label">部门名称</label>
	      <div class="layui-input-inline">
	        <input type="text" name="name" id="name" autocomplete="off" class="layui-input">
	      </div>
	    </div>
	    <div class="layui-inline">
	      <label class="layui-form-label">部门地址</label>
	      <div class="layui-input-inline">
	        <input type="text" name="loc" id="loc"  autocomplete="off" class="layui-input">
	      </div>
	    </div>
	    <div class="layui-inline">
	      <label class="layui-form-label">部门备注</label>
	      <div class="layui-input-inline">
	        <input type="text" name="remark" id="remark"  autocomplete="off" class="layui-input">
	      </div>
	    </div>
  	</div>
  	<div class="layui-form-item" style="text-align: center;">
	 	<a href="javascript:void(0)" class="search_btn layui-btn">查询</a>
    	<button type="reset" class="layui-btn layui-btn-warm" >重置</button>
  	</div>
</form>
<!-- 查询条件结束-->
<!-- 数据表格开始-->
	<table id="deptList" lay-filter="deptList"></table>
	<!--表格工具条-->
	
	<script type="text/html" id="tableToolBar">
		<shiro:hasPermission name="dept:create">
			<a class="layui-btn layui-btn layui-btn" lay-event="add">添加</a>
		</shiro:hasPermission>	
		<shiro:hasPermission name="dept:batchdelete">
			<a class="layui-btn layui-btn layui-btn-danger" lay-event="batchDel">批量删除</a>
		</shiro:hasPermission>	
	</script>
	<!-- 表格数据工条 -->
	<script type="text/html" id="deptListBar">
		<shiro:hasPermission name="dept:update">
			<a class="layui-btn layui-btn-xs layui-btn-warm" lay-event="update">修改</a>
		</shiro:hasPermission>	
		<shiro:hasPermission name="dept:delete">
			<a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="del">删除</a>
		</shiro:hasPermission>	
	</script>
<!-- 数据表格结束-->
<script type="text/javascript" src="${ctx }/resources/layui/layui.js"></script>
<script type="text/javascript" src="${ctx }/resources/zTree/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript">
	var tableIns;
	function reloadTable(id){
		tableIns.reload({
			 where: {
	             name: $("#name").val() ,
	             loc: $("#loc").val() ,
	             remark: $("#remark").val(),
	             id:id
	         }
			  ,page: {
			    curr: 1 
			  }
		});
	}

    layui.use(['form','layer','laydate','table','laytpl'],function(){
        var form = layui.form,
            layer = parent.layer === undefined ? layui.layer : parent.layer,
            $ = layui.jquery,
            laydate = layui.laydate,
            laytpl = layui.laytpl,
            table = layui.table;
        //部门列表
         tableIns = table.render({
            elem: '#deptList',
            url : '${ctx }/dept/loadAllDept.action',
            cellMinWidth : 95,
            toolbar: '#tableToolBar',
            page : true,
            height : "full-180",
            limit : 10,
            limits : [10,15,20,25],
            defaultToolbar: ['filter'],
            id : "deptListTable",
            cols : [[
                {type: "checkbox", fixed:"left", width:50},
                {field: 'id', title: 'ID', width:60, align:"center"},
                {field: 'pid', title: '父级部门ID', width:120, align:"center"},
                {field: 'name', title: '部门名称', width:180, align:"center"},
                {field: 'remark', title: '部门备注', width:180, align:"center"},
                {field: 'loc', title: '部门地址',align:"center", width:150},
                {field: 'available', title: '是否可用', align:'center',templet:function(data){
                	return data.available==1?"<font color=blue>可用</font>":"<font color=red>不可用</font>"
                }},
                {field: 'open', title: '是否展开', align:'center',templet:function(data){
                	return data.open==1?"<font color=blue>展开</font>":"<font color=red>不展开</font>"
                }},
                {field: 'parent', title: '是否父节点',width:120, align:'center',templet:function(data){
                	return data.parent==1?"<font color=blue>是</font>":"<font color=red>否</font>"
                }},
                {field: 'ordernum', title: '排序码',align:"center", width:80},
                {title: '操作', width:170, templet:'#deptListBar',fixed:"right",align:"center"}
            ]]
        });
         //搜索
         $(".search_btn").on("click",function(){
         	reloadTable(null);
         });

        //监听头工具栏事件
        table.on('toolbar(deptList)', function(obj){
            switch(obj.event){
	            case 'add':
	               	toAddDept();
                	break;
                case 'batchDel':
                    var checkStatus = table.checkStatus('deptListTable'),
                    data = checkStatus.data;
                    var ids="?a=1";
	                if(data.length > 0) {
	                    for (var i in data) {
	                    	ids+="&ids="+data[i].id;
	                    }
	                    layer.confirm('确定删除选中的部门？', {icon: 3, title: '提示信息'}, function (index) {
	                         $.post("${ctx}/dept/batchDeleteDept.action"+ids,function(data){
	                        	layer.msg(data.msg);
	                        	tableIns.reload();
	                        	parent.left.initTree();
	                        	layer.close(index);
	                         })
	                    })
	                }else{
	                    layer.msg("请选择需要删除的日志");
	                }
                    break;
            };
        });
		
        //打开添加页面
        function toAddDept(){
        	//打开弹出层
            var index = layui.layer.open({
                title : "添加部门",
                type : 2,
                area:['800px','600px'],
                content : "${ctx}/dept/toAddDept.action",
                success : function(layero, index){
                    var body = layui.layer.getChildFrame('body', index);
                    setTimeout(function(){
                        layui.layer.tips('点击此处返回部门列表', '.layui-layer-setwin .layui-layer-close', {
                            tips: 3
                        });
                    },500)
                }
            })
            //默认最大化窗口
            //layui.layer.full(index);
            //改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）
            $(window).on("resize",function(){
                layui.layer.full(index);
            })
        }

        //列表操作
        table.on('tool(deptList)', function(obj){
            var layEvent = obj.event,
                data = obj.data;
            if(layEvent==='update'){
            	toUpdate(data.id);//取出部门ID
            }else if(layEvent === 'del'){ //删除
                layer.confirm('确定删除此部门？',{icon:3, title:'提示信息'},function(index){
                	 $.post("${ctx}/dept/deleteDept.action?id="+data.id,function(data){
                		layer.msg(data.msg);
                     	tableIns.reload();
                     	parent.left.initTree();
                     	layer.close(index);
                      })
                    tableIns.reload();
                    layer.close(index);
                });
            }
        });
        //打开修改的弹出层
        function toUpdate(id){
        	//打开弹出层
            var index = layui.layer.open({
                title : "修改部门",
                type : 2,
                area:['800px','600px'],
                content : "${ctx}/dept/toUpdateDept.action?id="+id,
                success : function(layero, index){
                    var body = layui.layer.getChildFrame('body', index);
                    setTimeout(function(){
                        layui.layer.tips('点击此处返回部门列表', '.layui-layer-setwin .layui-layer-close', {
                            tips: 3
                        });
                    },500)
                }
            })
            //默认最大化窗口
            //layui.layer.full(index);
            //改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）
            $(window).on("resize",function(){
                layui.layer.full(index);
            })
        }
        
    })
    
   

</script>
</body>
</html>