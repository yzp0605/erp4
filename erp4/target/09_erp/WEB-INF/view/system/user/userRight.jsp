<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>用户管理--右边的数据表格</title>
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
	      <label class="layui-form-label">用户名称</label>
	      <div class="layui-input-inline">
	        <input type="text" name="name" id="name" autocomplete="off" class="layui-input">
	      </div>
	    </div>
	    <div class="layui-inline">
	      <label class="layui-form-label">用户地址</label>
	      <div class="layui-input-inline">
	        <input type="text" name="address" id="address"  autocomplete="off" class="layui-input">
	      </div>
	    </div>
	    <div class="layui-inline">
	    	 <a href="javascript:void(0)" class="search_btn layui-btn">查询</a>
    		<button type="reset" class="layui-btn layui-btn-warm" >重置</button>
	    </div>
	    
  	</div>
</form>
<!-- 查询条件结束-->
<!-- 数据表格开始-->
	<table id="userList" lay-filter="userList"></table>
	<!--表格工具条-->
	<script type="text/html" id="tableToolBar">
		<a class="layui-btn layui-btn layui-btn" lay-event="add">添加</a>
		<a class="layui-btn layui-btn layui-btn-danger" lay-event="batchDel">批量删除</a>
	</script>
	<!-- 表格数据工条 -->
	<script type="text/html" id="userListBar">
		<a class="layui-btn layui-btn-xs layui-btn-warm" lay-event="update">修改</a>
		<a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="del">删除</a>
		<a class="layui-btn layui-btn-xs" lay-event="resetPwd">重置密码</a>
		<a class="layui-btn layui-btn-xs layui-btn-warm" lay-event="selectRole">分配角色</a>
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
	             address: $("#address").val() ,
	             deptid:id
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
        //用户列表
         tableIns = table.render({
            elem: '#userList',
            url : '${ctx }/user/loadAllUser.action',
            cellMinWidth : 95,
            toolbar: '#tableToolBar',
            page : true,
            height : "full-180",
            limit : 10,
            limits : [10,15,20,25],
            defaultToolbar: ['filter'],
            id : "userListTable",
            cols : [[
                {type: "checkbox", fixed:"left", width:50},
                {field: 'id', title: 'ID', width:60, align:"center"},
                {field: 'name', title: '用户姓名', width:120, align:"center"},
                {field: 'loginname', title: '登陆名称', width:120, align:"center"},
                {field: 'deptname', title: '所在部门', width:150, align:"center"},
                {field: 'leadername', title: '直接领导', width:120, align:"center"},
                {field: 'address', title: '用户地址',align:"center", width:150},
                {field: 'remark', title: '用户备注',align:"center", width:150},
                {field: 'hiredate', title: '入职时间',align:"center", width:150},
                {field: 'sex', title: '性别', align:'center',templet:function(data){
                	return data.sex==1?"<font color=blue>男</font>":"<font color=red>女</font>"
                }},
                {field: 'imgpath', title: '头像', align:'center',templet:function(data){
                	return "<img width=20px height=20px alt=无效地址  src='"+data.imgpath+"'></img>"
                }},
                {field: 'available', title: '是否可用',width:120, align:'center',templet:function(data){
                	return data.available==1?"<font color=blue>是</font>":"<font color=red>否</font>"
                }},
                {field: 'pwd', title: '密码', align:'center',templet:function(data){
                	return "*****"
                }},
                {field: 'ordernum', title: '排序码',align:"center", width:80},
                {title: '操作', width:300, templet:'#userListBar',fixed:"right",align:"center"}
            ]]
        });
         //搜索
         $(".search_btn").on("click",function(){
         	reloadTable(null);
         });

        //监听头工具栏事件
        table.on('toolbar(userList)', function(obj){
            switch(obj.event){
	            case 'add':
	               	toAddUser();
                	break;
                case 'batchDel':
                    var checkStatus = table.checkStatus('userListTable'),
                    data = checkStatus.data;
                    var ids="?a=1";
	                if(data.length > 0) {
	                    for (var i in data) {
	                    	ids+="&ids="+data[i].id;
	                    }
	                    layer.confirm('确定删除选中的用户？', {icon: 3, title: '提示信息'}, function (index) {
	                         $.post("${ctx}/user/batchDeleteUser.action"+ids,function(data){
	                        	layer.msg(data.msg);
	                        	tableIns.reload();
	                        	layer.close(index);
	                         })
	                    })
	                }else{
	                    layer.msg("请选择需要删除的用户");
	                }
                    break;
            };
        });
		
        //打开添加页面
        function toAddUser(){
        	//打开弹出层
            var index = layui.layer.open({
                title : "添加用户",
                type : 2,
                area:['800px','630px'],
                content : "${ctx}/user/toAddUser.action",
                success : function(layero, index){
                    var body = layui.layer.getChildFrame('body', index);
                    setTimeout(function(){
                        layui.layer.tips('点击此处返回用户列表', '.layui-layer-setwin .layui-layer-close', {
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
        table.on('tool(userList)', function(obj){
            var layEvent = obj.event,
                data = obj.data;
            if(layEvent==='update'){
            	toUpdate(data.id);//取出用户ID
            }else if(layEvent === 'del'){ //删除
                layer.confirm('确定删除此用户？',{icon:3, title:'提示信息'},function(index){
                	 $.post("${ctx}/user/deleteUser.action?id="+data.id,function(data){
                		layer.msg(data.msg);
                     	tableIns.reload();
                     	layer.close(index);
                      })
                });
            }else if(layEvent==='resetPwd'){
            	layer.confirm('确定重置【'+data.name+'】用户的密码吗？',{icon:3, title:'提示信息'},function(index){
               	 $.post("${ctx}/user/resetUserPwd.action?id="+data.id,function(data){
               			layer.msg(data.msg);
                    	layer.close(index);
                     })
               });
            }else if(layEvent==='selectRole'){
            	toSelectRole(data);
            }
        });
        //打开修改的弹出层
        function toUpdate(id){
        	//打开弹出层
            var index = layui.layer.open({
                title : "修改用户",
                type : 2,
                area:['800px','630px'],
                content : "${ctx}/user/toUpdateUser.action?id="+id,
                success : function(layero, index){
                    var body = layui.layer.getChildFrame('body', index);
                    setTimeout(function(){
                        layui.layer.tips('点击此处返回用户列表', '.layui-layer-setwin .layui-layer-close', {
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
        //打开分配角色的弹出弹
        function toSelectRole(user){
        	//打开弹出层
            var index = layui.layer.open({
                title : "【"+user.name+"】用户分配角色",
                type : 2,
                area:['800px','630px'],
                content : "${ctx}/user/toSelectUserRole.action?id="+user.id,
                success : function(layero, index){
                    var body = layui.layer.getChildFrame('body', index);
                    setTimeout(function(){
                        layui.layer.tips('点击此处返回用户列表', '.layui-layer-setwin .layui-layer-close', {
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