<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>请假单管理</title>
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
<fieldset class="layui-elem-field layui-field-title">
    <legend>查询条件</legend>
</fieldset>
<form class="layui-form" id="searchForm" method="post">
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label" >请假标题:</label>
            <div class="layui-input-inline">
                <input type="text" name="title"  autocomplete="off" class="layui-input">
            </div>
        </div>
         <div class="layui-inline">
            <label class="layui-form-label" >请假内容:</label>
            <div class="layui-input-inline">
                <input type="text" name="content"  autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label" >开始时间:</label>
            <div class="layui-input-inline">
                <input type="text" name="startDate" id="startDate" autocomplete="off" class="layui-input">
            </div>
        </div>
         <div class="layui-inline">
            <label class="layui-form-label" >结束时间:</label>
            <div class="layui-input-inline">
                <input type="text" name="endDate" id="endDate" autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>
     <div class="layui-block" style="text-align: center;">
            <a class="layui-btn search_btn" >查询</a>
        	<button type="reset" class="layui-btn layui-btn-warm">清空</button>
     </div>
     <br>
</form>
<table id="leaveBillList" lay-filter="leaveBillList"></table>
<!--表格工具条-->
<script type="text/html" id="tableToolBar">
	<a class="layui-btn layui-btn layui-btn" lay-event="add">添加</a>
</script>
<!--操作-->
<script type="text/html" id="leaveBillListBar">
  {{#  if(d.state ==0 ){ }}
   	<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="del">删除</a>
    <a class="layui-btn layui-btn-xs layui-btn-normal" lay-event="startProcess">提交申请</a>
  {{#  } else if(d.state ==1) { }}
     <a class="layui-btn layui-btn-xs layui-btn-warm" lay-event="view">审批查询</a>
  {{#  }else if(d.state ==2) { }}
	 <a class="layui-btn layui-btn-xs layui-btn-warm" lay-event="view">审批查询</a>
  {{#  }else if(d.state ==3) { }}
	  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
      <a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="del">删除</a>
	  <a class="layui-btn layui-btn-xs layui-btn-warm" lay-event="view">审批查询</a>
  {{#  } }}	
</script>
<script type="text/javascript" src="${ctx }/resources/layui/layui.js"></script>
</body>
<script type="text/javascript">
    var tableIns;
    layui.use(['form','layer','table','laydate'],function(){
        var form = layui.form,
            layer = parent.layer === undefined ? layui.layer : top.layer,
            $ = layui.jquery,
            laydate=layui.laydate,
            table = layui.table;
        laydate.render({
        	elem:"#startDate"
        })
         laydate.render({
        	elem:"#endDate"
        })
        //请假单列表
        tableIns = table.render({
            elem: '#leaveBillList',
            url : '${ctx }/leaveBill/loadAllLeaveBills.action',
            cellMinWidth : 95,
            toolbar: '#tableToolBar',
            page : true,
            height : "full-220",
            limits : [10,15,20,25],
            defaultToolbar: ['filter'],
            limit : 10,
            id : "leaveBillListTable",
            cols : [[
                {type: "checkbox", fixed:"left", width:50},
                {field: 'id', title: '请假单ID', minWidth:100, align:"center"},
                {field: 'title', title: '请假标题', minWidth:100, align:"center"},
                {field: 'content', title: '请假内容', minWidth:100, align:"center"},
                {field: 'days', title: '请假天数', minWidth:100, align:"center"},
                {field: 'leavetime', title: '请假时间', minWidth:100, align:"center"},
                {field: 'username', title: '请假人',  align:'center'},
                {field: 'state', title: '状态',  align:'center',templet:function(data){
                	var state=data.state;
                	if(state==0){
                		return "<font color=red>未提交</font>";
                	}
                	else if(state==1){
                		return "<font color=green>审批中</font>";
                	}
                	else if(state==2){
                		return "<font color=blue>审批完成</font>";
                	}
                	else if(state==3){
                		return "<font color=gray>已放弃</font>";
                	}else{
                		return "<font color=yellow>未知状态</font>";
                	}
                }},
                {title: '操作', minWidth:325, templet:'#leaveBillListBar',fixed:"right",align:"center"}
            ]]
        });

        //查询
        $(".search_btn").on("click",function(){
            var params=$("#searchForm").serialize();
            table.reload('leaveBillListTable', {
                url: '${ctx }/leaveBill/loadAllLeaveBills.action?'+params
            });
        });
        //监听头工具栏事件
        table.on('toolbar(leaveBillList)', function(obj){
            switch(obj.event){
	            case 'add':
	               	toAddLeaveBill();
                	break;
            };
        });

        //打开  添加请假单的弹出层
        function toAddLeaveBill(){
            var index = layui.layer.open({
                title : "添加请假单",
                type : 2,//ifream层
                area:["800px","500px"],
                content : "${ctx }/leaveBill/toAddLeaveBill.action",
                success : function(layero, index){
                    setTimeout(function(){
                        layui.layer.tips('点击此处返回请假单列表', '.layui-layer-setwin .layui-layer-close', {
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
        //修改请假单
        function updateLeaveBill(data){
            var index = layui.layer.open({
                title : "修改请假单",
                type : 2,
                area:["800px","500px"],
                content : "${ctx }/leaveBill/toUpdateLeaveBill.action?id="+data.id,
                success : function(layero, index){
                    setTimeout(function(){
                        layui.layer.tips('点击此处返回请假单列表', '.layui-layer-setwin .layui-layer-close', {
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
        //列表操作
        table.on('tool(leaveBillList)', function(obj){
            var layEvent = obj.event,
                data = obj.data;
            if(layEvent === 'edit'){ //编辑
                updateLeaveBill(data);//data主当前点击的行
            }else if(layEvent === 'del'){ //删除
                layer.confirm('确定删【'+data.title+'】请假单吗？',{icon:3, title:'提示信息'},function(index){
                    $.post("${ctx}/leaveBill/deleteLeaveBill.action",{
                        id : data.id  //将需要删除的id作为参数传入
                    },function(data){
                        //刷新table
                        tableIns.reload();
                        //关闭提示框
                        layer.close(index);
                    })
                });
            }else if(layEvent==='startProcess'){
            	 layer.confirm('确定是提交【'+data.title+'】请假单吗？',{icon:3, title:'提示信息'},function(index){
            		 $.post("${ctx}/workFlow/startLeaveBillProcess.action",{id:data.id},function(data){
                 		layer.msg(data.msg);
                 		//刷新table
                         tableIns.reload();
                         //关闭提示框
                         layer.close(index);
                 	},"json")
                 });
            }else if(layEvent==="view"){//查看审批进度
            	viewApprovalProgress(data.id) 
            }
        });
        //查看审批进度
        function viewApprovalProgress(id){
            var index = layui.layer.open({
                title : "查看审批进度",
                type : 2,
                area:["800px","600px"],
                content : "${ctx }/workFlow/toViewApprovalProgress.action?id="+id,
                success : function(layero, index){
                    setTimeout(function(){
                        layui.layer.tips('点击此处返回请假单列表', '.layui-layer-setwin .layui-layer-close', {
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