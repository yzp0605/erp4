/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-09-17 01:06:13 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view.business.customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class customerManager_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<title>客户管理</title>\r\n");
      out.write("<meta name=\"renderer\" content=\"webkit\">\r\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\">\r\n");
      out.write("<meta name=\"apple-mobile-web-app-status-bar-style\" content=\"black\">\r\n");
      out.write("<meta name=\"apple-mobile-web-app-capable\" content=\"yes\">\r\n");
      out.write("<meta name=\"format-detection\" content=\"telephone=no\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/layui/css/layui.css\" media=\"all\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/css/public.css\" media=\"all\" />\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"childrenBody\">\r\n");
      out.write("\t\t<fieldset class=\"layui-elem-field layui-field-title\">\r\n");
      out.write(" \t\t <legend>查询条件</legend>\r\n");
      out.write("\t\t</fieldset>\r\n");
      out.write("\t\t<form class=\"layui-form\" id=\"searchForm\" method=\"post\">\r\n");
      out.write("\t\t\t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t    <div class=\"layui-inline\">\r\n");
      out.write("\t\t\t      <label class=\"layui-form-label\" >客户名称:</label>\r\n");
      out.write("\t\t\t      <div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t        <input type=\"text\" name=\"customername\"  autocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("\t\t\t      </div>\r\n");
      out.write("\t\t\t    </div>\r\n");
      out.write("\t\t\t    <div class=\"layui-inline\">\r\n");
      out.write("\t\t\t      <label class=\"layui-form-label\"  >客户电话:</label>\r\n");
      out.write("\t\t\t      <div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t        <input type=\"text\" name=\"phone\"  autocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("\t\t\t      </div>\r\n");
      out.write("\t\t\t    </div>\r\n");
      out.write("\t\t\t    <div class=\"layui-inline\">\r\n");
      out.write("\t\t\t      <label class=\"layui-form-label\" >联系人:</label>\r\n");
      out.write("\t\t\t      <div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t        <input type=\"tel\" name=\"connectionperson\" autocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("\t\t\t      </div>\r\n");
      out.write("\t\t\t    </div>\r\n");
      out.write("\t\t\t    <div class=\"layui-inline\">\r\n");
      out.write("\t\t\t      \t <a class=\"layui-btn search_btn\" >查询</a>\r\n");
      out.write("\t\t\t\t\t <button type=\"reset\" class=\"layui-btn layui-btn-warm\">清空</button>\r\n");
      out.write("\t\t\t    </div>\r\n");
      out.write("\t\t\t  </div>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t\t<table id=\"customerList\" lay-filter=\"customerList\"></table>\r\n");
      out.write("\t\t<script type=\"text/html\" id=\"tableToolBar\">\r\n");
      out.write("\t\t\t<a class=\"layui-btn layui-btn layui-btn\" lay-event=\"add\">添加</a>\r\n");
      out.write("\t\t\t<a class=\"layui-btn layui-btn layui-btn-danger\" lay-event=\"batchDel\">批量删除</a>\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t\t<!--操作-->\r\n");
      out.write("\t\t<script type=\"text/html\" id=\"customerListBar\">\r\n");
      out.write("\t\t\t<a class=\"layui-btn layui-btn-xs\" lay-event=\"edit\">编辑</a>\r\n");
      out.write("\t\t\t<a class=\"layui-btn layui-btn-xs layui-btn-danger\" lay-event=\"del\">删除</a>\r\n");
      out.write("\t</script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/layui/layui.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("var tableIns;\r\n");
      out.write("layui.use(['form','layer','table','laytpl'],function(){\r\n");
      out.write("    var form = layui.form,\r\n");
      out.write("        layer = parent.layer === undefined ? layui.layer : top.layer,\r\n");
      out.write("        $ = layui.jquery,\r\n");
      out.write("        laytpl = layui.laytpl,\r\n");
      out.write("        table = layui.table;\r\n");
      out.write("\r\n");
      out.write("    //客户列表\r\n");
      out.write("     tableIns = table.render({\r\n");
      out.write("        elem: '#customerList',\r\n");
      out.write("        url : '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/customer/loadCustomers.action',\r\n");
      out.write("        cellMinWidth : 95,\r\n");
      out.write("        page : true,\r\n");
      out.write("        height : \"full-200\",\r\n");
      out.write("        limits : [10,15,20,25],\r\n");
      out.write("        limit : 10,\r\n");
      out.write("        toolbar: '#tableToolBar',\r\n");
      out.write("        defaultToolbar: ['filter'],\r\n");
      out.write("        id : \"customerListTable\",\r\n");
      out.write("        cols : [[\r\n");
      out.write("            {type: \"checkbox\", fixed:\"left\", width:50},\r\n");
      out.write("            {field: 'id', title: '客户ID', minWidth:100, align:\"center\"},\r\n");
      out.write("            {field: 'customername', title: '客户名称', minWidth:100, align:\"center\"},\r\n");
      out.write("            {field: 'zip', title: '客户邮编', minWidth:100, align:\"center\"},\r\n");
      out.write("            {field: 'address', title: '客户地址', minWidth:100, align:\"center\"},\r\n");
      out.write("            {field: 'telephone', title: '客户电话', minWidth:100, align:\"center\"},\r\n");
      out.write("            {field: 'connectionperson', title: '联系人', minWidth:100, align:\"center\"},\r\n");
      out.write("            {field: 'phone', title: '联系人电话', minWidth:100, align:\"center\"},\r\n");
      out.write("            {field: 'bank', title: '开户行', minWidth:100, align:\"center\"},\r\n");
      out.write("            {field: 'account', title: '账户', minWidth:100, align:\"center\"},\r\n");
      out.write("            {field: 'email', title: '邮编', minWidth:100, align:\"center\"},\r\n");
      out.write("            {field: 'fax', title: '传真', minWidth:100, align:\"center\"},\r\n");
      out.write("            {field: 'available', title: '是否可用',  align:'center',templet:function(d){\r\n");
      out.write("                return d.available ==1 ? \"<font color=blue>可用</font>\" : \"<font color=red>不可用</font>\";\r\n");
      out.write("            }},\r\n");
      out.write("            {title: '操作', minWidth:175, templet:'#customerListBar',fixed:\"right\",align:\"center\"}\r\n");
      out.write("        ]]\r\n");
      out.write("    });\r\n");
      out.write("\r\n");
      out.write("     //监听头工具栏事件\r\n");
      out.write("     table.on('toolbar(customerList)', function(obj){\r\n");
      out.write("         switch(obj.event){\r\n");
      out.write("\t            case 'add':\r\n");
      out.write("\t            \ttoAddCustomer();\r\n");
      out.write("             \tbreak;\r\n");
      out.write("             \tcase 'batchDel':\r\n");
      out.write("            \t\t batchDelete();\r\n");
      out.write("                 break;\r\n");
      out.write("         };\r\n");
      out.write("     });\r\n");
      out.write("    //查询\r\n");
      out.write("    $(\".search_btn\").on(\"click\",function(){\r\n");
      out.write("    \tvar params=$(\"#searchForm\").serialize();\r\n");
      out.write("    \ttable.reload('customerListTable', {\r\n");
      out.write("    \t\t  url: '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/customer/loadCustomers.action?'+params\r\n");
      out.write("    \t});\r\n");
      out.write("    });\r\n");
      out.write("   \r\n");
      out.write("    //添加客户\r\n");
      out.write("    function toAddCustomer(){\r\n");
      out.write("        var index = layui.layer.open({\r\n");
      out.write("            title : \"添加客户\",\r\n");
      out.write("            type : 2,//ifream层\r\n");
      out.write("            area:[\"800px\",\"520px\"],\r\n");
      out.write("            content : \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/customer/toAddCustomer.action\",\r\n");
      out.write("            success : function(layero, index){\r\n");
      out.write("                setTimeout(function(){\r\n");
      out.write("                    layui.layer.tips('点击此处返回客户列表', '.layui-layer-setwin .layui-layer-close', {\r\n");
      out.write("                        tips: 3\r\n");
      out.write("                    });\r\n");
      out.write("                },500)\r\n");
      out.write("            }\r\n");
      out.write("        })\r\n");
      out.write("        //layui.layer.full(index);\r\n");
      out.write("        //改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）\r\n");
      out.write("        $(window).on(\"resize\",function(){\r\n");
      out.write("            layui.layer.full(index);\r\n");
      out.write("        })\r\n");
      out.write("    }\r\n");
      out.write("    //修改客户\r\n");
      out.write("    function updateCustomer(data){\r\n");
      out.write("    \tvar index = layui.layer.open({\r\n");
      out.write("            title : \"修改客户\",\r\n");
      out.write("            type : 2,\r\n");
      out.write("            area:[\"800px\",\"520px\"],\r\n");
      out.write("            content : \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/customer/toUpdateCustomer.action?id=\"+data.id,\r\n");
      out.write("            success : function(layero, index){\r\n");
      out.write("                setTimeout(function(){\r\n");
      out.write("                    layui.layer.tips('点击此处返回客户列表', '.layui-layer-setwin .layui-layer-close', {\r\n");
      out.write("                        tips: 3\r\n");
      out.write("                    });\r\n");
      out.write("                },500)\r\n");
      out.write("            }\r\n");
      out.write("        })\r\n");
      out.write("        //layui.layer.full(index);\r\n");
      out.write("        //改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）\r\n");
      out.write("        $(window).on(\"resize\",function(){\r\n");
      out.write("            layui.layer.full(index);\r\n");
      out.write("        })\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("    //列表操作\r\n");
      out.write("    table.on('tool(customerList)', function(obj){\r\n");
      out.write("        var layEvent = obj.event,\r\n");
      out.write("            data = obj.data;\r\n");
      out.write("        if(layEvent === 'edit'){ //编辑\r\n");
      out.write("        \tupdateCustomer(data);//data主当前点击的行\r\n");
      out.write("        }else if(layEvent === 'del'){ //删除\r\n");
      out.write("            layer.confirm('确定删【'+data.customername+'】客户吗？',{icon:3, title:'提示信息'},function(index){\r\n");
      out.write("                 $.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/customer/deleteCustomer.action\",{\r\n");
      out.write("                     id : data.id  //将需要删除的id作为参数传入\r\n");
      out.write("                 },function(data){\r\n");
      out.write("                \t //刷新table\r\n");
      out.write("                    tableIns.reload();\r\n");
      out.write("                \t //关闭提示框\r\n");
      out.write("                    layer.close(index);\r\n");
      out.write("                 })\r\n");
      out.write("            });\r\n");
      out.write("        }\r\n");
      out.write("    });\r\n");
      out.write("    //批量删除\r\n");
      out.write("   function  batchDelete(){\r\n");
      out.write("    \t//得到当前表格里面的checkbox的选中对象集合\r\n");
      out.write("        var checkStatus = table.checkStatus('customerListTable'),//选中状态\r\n");
      out.write("            data = checkStatus.data;//选中的对象集\r\n");
      out.write("            var ids=\"a=1\";\r\n");
      out.write("        if(data.length > 0) {\r\n");
      out.write("            for (var i in data) {\r\n");
      out.write("            \tids+=\"&ids=\"+data[i].id;\r\n");
      out.write("            }\r\n");
      out.write("            layer.confirm('确定删除选中的客户？', {icon: 3, title: '提示信息'}, function (index) {\r\n");
      out.write("                 $.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/customer/batchDeleteCustomer.action?\"+ids,function(data){\r\n");
      out.write("                \t //刷新table\r\n");
      out.write("                     tableIns.reload();\r\n");
      out.write("                 \t //关闭提示框\r\n");
      out.write("                \tlayer.close(index);\r\n");
      out.write("                })\r\n");
      out.write("            })\r\n");
      out.write("        }else{\r\n");
      out.write("            layer.msg(\"请选择需要删除的客户\");\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("})\r\n");
      out.write("</script>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
