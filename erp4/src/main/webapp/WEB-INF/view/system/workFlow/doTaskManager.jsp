<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>办理任务</title>
<link rel="stylesheet" href="${ctx }/resources/layui/css/layui.css" media="all" />
<link rel="stylesheet" href="${ctx }/resources/css/public.css" media="all" />
</head>
<body class="childrenBody">
	<form class="layui-form" method="post" id="frm">
		<div class="layui-form-item">
			<label class="layui-form-label">请假标题</label>
			<div class="layui-input-block">
				<input type="text" name="title"  disabled="disabled" lay-verify="title" value="${leaveBill.title }" autocomplete="off"
					placeholder="请输入请假标题" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">请假天数</label>
				<div class="layui-input-inline">
					<input type="text" name="days"  disabled="disabled" placeholder="请输入请假天数" value="${leaveBill.days }" lay-verify="number" autocomplete="off"
						class="layui-input">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">开始时间</label>
				<div class="layui-input-inline">
					<input type="text" name="leavetime"  disabled="disabled" value="<fmt:formatDate value="${leaveBill.leavetime }" pattern="yyyy-MM-dd HH:mm:ss"/>" autocomplete="off"
						class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">请假原因</label>
			<div class="layui-input-block">
				<textarea placeholder="请输入请假原因"  disabled="disabled" name="content" class="layui-textarea">${leaveBill.content }</textarea>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">批注</label>
			<div class="layui-input-block">
				<textarea placeholder="请输入批注信息"  id="comment" name="comment" class="layui-textarea"></textarea>
			</div>
		</div>
	  <div class="layui-form-item" style="text-align: center;">
	  		<c:forEach items="${outcomes }" var="sn" varStatus="n" >
	  			<c:choose>
		  			<c:when test="${n.index==0 }">
		      			<input class="layui-btn mybtn" type="button" value="${sn }" />
		  			</c:when>
		  			<c:otherwise>
		  				<input class="layui-btn layui-btn-warm mybtn" type="button" value="${sn }" />
		  			</c:otherwise>
	  			</c:choose>
	        </c:forEach>
  	  </div>
  </form>
  <table id="commonList" lay-filter="commonList"></table>
  <script type="text/javascript" src="${ctx }/resources/layui/layui.js"></script>
</body>
<script type="text/javascript">
	layui.use(['form','jquery','layer','table'],function(){
		var form=layui.form;
		var $=layui.jquery;
		var table=layui.table;
		//如果父页面有layer就使用父页的  没有就自己导入
		var layer = parent.layer === undefined ? layui.layer : top.layer;
		
		//加载批注信息
		 //请假单列表
       var tableIns = table.render({
            elem: '#commonList',
            url : '${ctx }/workFlow/queryCommonsByTaskId.action?taskId=${workFlowVo.taskId}',
            cellMinWidth : 95,
            toolbar: 'true',
            height : "full-220",
            defaultToolbar: ['filter'],
            id : "commonListTable",
            cols : [[
                {field: 'time', title: '批注时间', minWidth:100, align:"center"},
                {field: 'userId', title: '批注人', minWidth:100, align:"center"},
                {field: 'message', title: '批注内容', minWidth:100, align:"center"}
            ]]
        });
		
		
		//给mybtn添加事件
		$(".mybtn").on("click",function(){
			var outcome=this.value;
			var taskId='${workFlowVo.taskId}';
			var comment=$("#comment").val();
			var id='${leaveBill.id}';
			//发送请求
			$.post("${ctx}/workFlow/completeTask.action",
					{taskId:taskId,outcome:outcome,comment:comment,id:id},function(obj){
				layer.msg(obj.msg);
				var index = parent.layer.getFrameIndex(window.name);  
				window.parent.layer.close(index); 
				parent.tableIns.reload();//刷新父页面任务表格
			},"json")
		})
	});
</script>
</html>