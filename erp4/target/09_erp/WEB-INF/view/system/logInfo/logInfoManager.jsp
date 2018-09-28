<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>日志管理</title>
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
	      <label class="layui-form-label">登陆名称</label>
	      <div class="layui-input-inline">
	        <input type="text" name="loginname" id="loginname" autocomplete="off" class="layui-input">
	      </div>
	    </div>
	    <div class="layui-inline">
	      <label class="layui-form-label">登陆IP</label>
	      <div class="layui-input-inline">
	        <input type="text" name="loginip" id="loginip"  autocomplete="off" class="layui-input">
	      </div>
	    </div>
	    <div class="layui-inline">
	      <label class="layui-form-label">开始时间</label>
	      <div class="layui-input-inline">
	        <input type="text" name="startDate" id="startDate"  placeholder="yyyy-MM-dd HH:mm:ss"  autocomplete="off" class="layui-input">
	      </div>
	    </div>
	    <div class="layui-inline">
	      <label class="layui-form-label">结束时间</label>
	      <div class="layui-input-inline">
	        <input type="text" name="endDate" id="endDate" placeholder="yyyy-MM-dd HH:mm:ss" autocomplete="off" class="layui-input">
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
	<table id="logInfoList" lay-filter="logInfoList"></table>
	<!--表格工具条-->
	<script type="text/html" id="tableToolBar">
		<a class="layui-btn layui-btn layui-btn-danger" lay-event="batchDel">批量删除</a>
	</script>
	<!-- 表格数据工条 -->
	<script type="text/html" id="logInfoListBar">
		<a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="del">删除</a>
	</script>
<!-- 数据表格结束-->
<script type="text/javascript" src="${ctx }/resources/layui/layui.js"></script>
<script type="text/javascript">
    layui.use(['form','layer','laydate','table','laytpl'],function(){
        var form = layui.form,
            layer = parent.layer === undefined ? layui.layer : top.layer,
            $ = layui.jquery,
            laydate = layui.laydate,
            laytpl = layui.laytpl,
            table = layui.table;
        
        //绑定时间选择器
        laydate.render({
        	elem:'#startDate',
        	type:'datetime'
        });
        laydate.render({
        	elem:'#endDate',
        	type:'datetime'
        })
        

        //日志列表
        var tableIns = table.render({
            elem: '#logInfoList',
            url : '${ctx }/logInfo/loadAllLogInfo.action',
            cellMinWidth : 95,
            toolbar: '#tableToolBar',
            page : true,
            height : "full-180",
            limit : 10,
            limits : [10,15,20,25],
            defaultToolbar: ['filter'],
            id : "logInfoListTable",
            cols : [[
                {type: "checkbox", fixed:"left", width:50},
                {field: 'id', title: 'ID', width:60, align:"center"},
                {field: 'loginname', title: '登陆名称',align:"center", width:350},
                {field: 'loginip', title: '登陆IP', align:'center'},
                {field: 'logintime', title: '登陆时间',  align:'center'},
                {title: '操作', width:170, templet:'#logInfoListBar',fixed:"right",align:"center"}
            ]]
        });
        //监听头工具栏事件
        table.on('toolbar(logInfoList)', function(obj){
            switch(obj.event){
                case 'batchDel':
                    var checkStatus = table.checkStatus('logInfoListTable'),
                    data = checkStatus.data;
                    var ids="?a=1";
	                if(data.length > 0) {
	                    for (var i in data) {
	                    	ids+="&ids="+data[i].id;
	                    }
	                    layer.confirm('确定删除选中的日志？', {icon: 3, title: '提示信息'}, function (index) {
	                         $.post("${ctx}/logInfo/batchDeleteLogInfo.action"+ids,function(data){
	                        	layer.msg(data.msg);
	                        	tableIns.reload();
	                        	layer.close(index);
	                         })
	                    })
	                }else{
	                    layer.msg("请选择需要删除的日志");
	                }
                    break;
            };
        });

        //搜索
        $(".search_btn").on("click",function(){
              table.reload("logInfoListTable",{
                  page: {
                      curr: 1 //重新从第 1 页开始
                  },
                  where: {
                      loginname: $("#loginname").val() ,
                      loginip: $("#loginip").val() ,
                      startDate: $("#startDate").val() ,
                      endDate: $("#endDate").val() 
                  }
              })
        });

      

        //列表操作
        table.on('tool(logInfoList)', function(obj){
            var layEvent = obj.event,
                data = obj.data;
            if(layEvent === 'del'){ //删除
                layer.confirm('确定删除此日志？',{icon:3, title:'提示信息'},function(index){
                	 $.post("${ctx}/logInfo/deleteLogInfo.action?id="+data.id,function(data){
                		layer.msg(data.msg);
                     	tableIns.reload();
                     	layer.close(index);
                      })
                    tableIns.reload();
                    layer.close(index);
                });
            }
        });

    })

</script>
</body>
</html>