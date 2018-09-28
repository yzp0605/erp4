<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>用户管理--角色分配</title>
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
<table id="roleList" lay-filter="roleList"></table>
<!--表格工具条-->
<script type="text/html" id="tableToolBar">
	<a class="layui-btn layui-btn layui-btn" lay-event="saveUserRole">确定分配</a>
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
        //角色列表
        tableIns = table.render({
            elem: '#roleList',
            url : '${ctx }/user/loadUserRole.action?id=${userVo.id}',
            cellMinWidth : 95,
            toolbar: '#tableToolBar',
            defaultToolbar: ['filter'],
            id : "roleListTable",
            cols : [[
                {type: "checkbox", fixed:"left", width:50},
                {field: 'id', title: '角色ID', minWidth:100, align:"center"},
                {field: 'name', title: '角色名称', minWidth:100, align:"center"},
                {field: 'remark', title: '角色备注', minWidth:100, align:"center"}
            ]]
        });

        //监听头工具栏事件
        table.on('toolbar(roleList)', function(obj){
            switch(obj.event){
	            case 'saveUserRole':
	            	saveUserRole();
                	break;
            };
        });
        //保存用户和角色的关系
        function saveUserRole(){
            //得到当前表格里面的checkbox的选中对象集合
            var checkStatus = table.checkStatus('roleListTable'),//选中状态
                data = checkStatus.data;//选中的对象集
            var ids="id=${userVo.id}";
            for (var i in data) {
                ids+="&ids="+data[i].id;
            }
            layer.confirm('确定分配选中的角色？', {icon: 3, title: '提示信息'}, function (index) {
                $.post("${ctx}/user/saveUserRole.action?"+ids,function(obj){
                    //关闭提示框
                    layer.msg(obj.msg);
                    layer.close(index);
                })
            })
        }
    })
    
</script>
</html>