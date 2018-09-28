<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>我的待办任务管理</title>
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
<table id="taskList" lay-filter="taskList"></table>
<!--操作-->
<script type="text/html" id="taskListBar">
    <a class="layui-btn layui-btn-xs" lay-event="toDoTask">办理任务</a>
    <a class="layui-btn layui-btn-xs layui-btn-warm" lay-event="toViewProcessImage">查看流程图</a>
</script>
<script type="text/javascript" src="${ctx }/resources/layui/layui.js"></script>
</body>
<script type="text/javascript">
    var tableIns;
    layui.use(['form','layer','table'],function(){
        var form = layui.form,
            layer = parent.layer === undefined ? layui.layer : top.layer,
            $ = layui.jquery,
            table = layui.table;
        //我的待办任务列表
        tableIns = table.render({
            elem: '#taskList',
            url : '${ctx }/workFlow/queryCurrentUserTask.action',
            cellMinWidth : 95,
            toolbar: true,
            page : true,
            height : "full-120",
            limits : [10,15,20,25],
            defaultToolbar: ['filter'],
            limit : 10,
            id : "taskListTable",
            cols : [[
                {field: 'id', title: '任务ID', minWidth:100, align:"center"},
                {field: 'name', title: '任务名称', minWidth:100, align:"center"},
                {field: 'createTime', title: '任务创建时间', minWidth:100, align:"center"},
                {field: 'assignee', title: '任务办理人', align:'center'},
                {title: '操作', minWidth:175, templet:'#taskListBar',fixed:"right",align:"center"}
            ]]
        });
        //列表操作
        table.on('tool(taskList)', function(obj){
            var layEvent = obj.event,
                data = obj.data;
            if(layEvent === 'toDoTask'){ //编辑
            	toDoTask(data);//data主当前点击的行
            }else if(layEvent==="toViewProcessImage"){
            	toViewProcessImage(data.id);
            }
        });
        //打开办理任务的弹出层
        function toDoTask(data){
            var index = layui.layer.open({
                title : "办理任务",
                type : 2,//ifream层
                area:["800px","600px"],
                content : "${ctx }/workFlow/toDoTask.action?taskId="+data.id,
                success : function(layero, index){
                    setTimeout(function(){
                        layui.layer.tips('点击此处返回我的待办任务列表', '.layui-layer-setwin .layui-layer-close', {
                            tips: 3
                        });
                    },500)
                }
            })
            //layui.layer.full(index);
            //改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）
            $(window).on("resize",function(){
                layui.layer.full(index);
            })
        }
        //查看流程图
        function  toViewProcessImage(id){
        	var index = layui.layer.open({
                title : "查看办理流程图",
                type : 2,
                area:["800px","600px"],
                content : "${ctx }/workFlow/toViewProcessImageByTaskId.action?taskId="+id,
                success : function(layero, index){
                    setTimeout(function(){
                        layui.layer.tips('点击此处返回我的待办任务列表', '.layui-layer-setwin .layui-layer-close', {
                            tips: 3
                        });
                    },500)
                }
            })
            //layui.layer.full(index);
            //改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）
            $(window).on("resize",function(){
                layui.layer.full(index);
            })
        }
    })
    
   
    
</script>
</html>