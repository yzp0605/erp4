/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-09-22 08:40:09 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view.system.leaveBill;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class leaveBillManager_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <title>请假单管理</title>\r\n");
      out.write("    <meta name=\"renderer\" content=\"webkit\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\">\r\n");
      out.write("    <meta name=\"apple-mobile-web-app-status-bar-style\" content=\"black\">\r\n");
      out.write("    <meta name=\"apple-mobile-web-app-capable\" content=\"yes\">\r\n");
      out.write("    <meta name=\"format-detection\" content=\"telephone=no\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/layui/css/layui.css\" media=\"all\" />\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/css/public.css\" media=\"all\" />\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"childrenBody\">\r\n");
      out.write("<fieldset class=\"layui-elem-field layui-field-title\">\r\n");
      out.write("    <legend>查询条件</legend>\r\n");
      out.write("</fieldset>\r\n");
      out.write("<form class=\"layui-form\" id=\"searchForm\" method=\"post\">\r\n");
      out.write("    <div class=\"layui-form-item\">\r\n");
      out.write("        <div class=\"layui-inline\">\r\n");
      out.write("            <label class=\"layui-form-label\" >请假标题:</label>\r\n");
      out.write("            <div class=\"layui-input-inline\">\r\n");
      out.write("                <input type=\"text\" name=\"title\"  autocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("         <div class=\"layui-inline\">\r\n");
      out.write("            <label class=\"layui-form-label\" >请假内容:</label>\r\n");
      out.write("            <div class=\"layui-input-inline\">\r\n");
      out.write("                <input type=\"text\" name=\"content\"  autocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"layui-inline\">\r\n");
      out.write("            <label class=\"layui-form-label\" >开始时间:</label>\r\n");
      out.write("            <div class=\"layui-input-inline\">\r\n");
      out.write("                <input type=\"text\" name=\"startDate\" id=\"startDate\" autocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("         <div class=\"layui-inline\">\r\n");
      out.write("            <label class=\"layui-form-label\" >结束时间:</label>\r\n");
      out.write("            <div class=\"layui-input-inline\">\r\n");
      out.write("                <input type=\"text\" name=\"endDate\" id=\"endDate\" autocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("     <div class=\"layui-block\" style=\"text-align: center;\">\r\n");
      out.write("            <a class=\"layui-btn search_btn\" >查询</a>\r\n");
      out.write("        \t<button type=\"reset\" class=\"layui-btn layui-btn-warm\">清空</button>\r\n");
      out.write("     </div>\r\n");
      out.write("     <br>\r\n");
      out.write("</form>\r\n");
      out.write("<table id=\"leaveBillList\" lay-filter=\"leaveBillList\"></table>\r\n");
      out.write("<!--表格工具条-->\r\n");
      out.write("<script type=\"text/html\" id=\"tableToolBar\">\r\n");
      out.write("\t<a class=\"layui-btn layui-btn layui-btn\" lay-event=\"add\">添加</a>\r\n");
      out.write("</script>\r\n");
      out.write("<!--操作-->\r\n");
      out.write("<script type=\"text/html\" id=\"leaveBillListBar\">\r\n");
      out.write("  {{#  if(d.state ==0 ){ }}\r\n");
      out.write("   \t<a class=\"layui-btn layui-btn-xs\" lay-event=\"edit\">编辑</a>\r\n");
      out.write("    <a class=\"layui-btn layui-btn-xs layui-btn-danger\" lay-event=\"del\">删除</a>\r\n");
      out.write("    <a class=\"layui-btn layui-btn-xs layui-btn-normal\" lay-event=\"startProcess\">提交申请</a>\r\n");
      out.write("  {{#  } else if(d.state ==1) { }}\r\n");
      out.write("     <a class=\"layui-btn layui-btn-xs layui-btn-warm\" lay-event=\"view\">审批查询</a>\r\n");
      out.write("  {{#  }else if(d.state ==2) { }}\r\n");
      out.write("\t <a class=\"layui-btn layui-btn-xs layui-btn-warm\" lay-event=\"view\">审批查询</a>\r\n");
      out.write("  {{#  }else if(d.state ==3) { }}\r\n");
      out.write("\t  <a class=\"layui-btn layui-btn-xs\" lay-event=\"edit\">编辑</a>\r\n");
      out.write("      <a class=\"layui-btn layui-btn-xs layui-btn-danger\" lay-event=\"del\">删除</a>\r\n");
      out.write("\t  <a class=\"layui-btn layui-btn-xs layui-btn-warm\" lay-event=\"view\">审批查询</a>\r\n");
      out.write("  {{#  } }}\t\r\n");
      out.write("</script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/layui/layui.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("    var tableIns;\r\n");
      out.write("    layui.use(['form','layer','table','laydate'],function(){\r\n");
      out.write("        var form = layui.form,\r\n");
      out.write("            layer = parent.layer === undefined ? layui.layer : top.layer,\r\n");
      out.write("            $ = layui.jquery,\r\n");
      out.write("            laydate=layui.laydate,\r\n");
      out.write("            table = layui.table;\r\n");
      out.write("        laydate.render({\r\n");
      out.write("        \telem:\"#startDate\"\r\n");
      out.write("        })\r\n");
      out.write("         laydate.render({\r\n");
      out.write("        \telem:\"#endDate\"\r\n");
      out.write("        })\r\n");
      out.write("        //请假单列表\r\n");
      out.write("        tableIns = table.render({\r\n");
      out.write("            elem: '#leaveBillList',\r\n");
      out.write("            url : '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/leaveBill/loadAllLeaveBills.action',\r\n");
      out.write("            cellMinWidth : 95,\r\n");
      out.write("            toolbar: '#tableToolBar',\r\n");
      out.write("            page : true,\r\n");
      out.write("            height : \"full-220\",\r\n");
      out.write("            limits : [10,15,20,25],\r\n");
      out.write("            defaultToolbar: ['filter'],\r\n");
      out.write("            limit : 10,\r\n");
      out.write("            id : \"leaveBillListTable\",\r\n");
      out.write("            cols : [[\r\n");
      out.write("                {type: \"checkbox\", fixed:\"left\", width:50},\r\n");
      out.write("                {field: 'id', title: '请假单ID', minWidth:100, align:\"center\"},\r\n");
      out.write("                {field: 'title', title: '请假标题', minWidth:100, align:\"center\"},\r\n");
      out.write("                {field: 'content', title: '请假内容', minWidth:100, align:\"center\"},\r\n");
      out.write("                {field: 'days', title: '请假天数', minWidth:100, align:\"center\"},\r\n");
      out.write("                {field: 'leavetime', title: '请假时间', minWidth:100, align:\"center\"},\r\n");
      out.write("                {field: 'username', title: '请假人',  align:'center'},\r\n");
      out.write("                {field: 'state', title: '状态',  align:'center',templet:function(data){\r\n");
      out.write("                \tvar state=data.state;\r\n");
      out.write("                \tif(state==0){\r\n");
      out.write("                \t\treturn \"<font color=red>未提交</font>\";\r\n");
      out.write("                \t}\r\n");
      out.write("                \telse if(state==1){\r\n");
      out.write("                \t\treturn \"<font color=green>审批中</font>\";\r\n");
      out.write("                \t}\r\n");
      out.write("                \telse if(state==2){\r\n");
      out.write("                \t\treturn \"<font color=blue>审批完成</font>\";\r\n");
      out.write("                \t}\r\n");
      out.write("                \telse if(state==3){\r\n");
      out.write("                \t\treturn \"<font color=gray>已放弃</font>\";\r\n");
      out.write("                \t}else{\r\n");
      out.write("                \t\treturn \"<font color=yellow>未知状态</font>\";\r\n");
      out.write("                \t}\r\n");
      out.write("                }},\r\n");
      out.write("                {title: '操作', minWidth:325, templet:'#leaveBillListBar',fixed:\"right\",align:\"center\"}\r\n");
      out.write("            ]]\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("        //查询\r\n");
      out.write("        $(\".search_btn\").on(\"click\",function(){\r\n");
      out.write("            var params=$(\"#searchForm\").serialize();\r\n");
      out.write("            table.reload('leaveBillListTable', {\r\n");
      out.write("                url: '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/leaveBill/loadAllLeaveBills.action?'+params\r\n");
      out.write("            });\r\n");
      out.write("        });\r\n");
      out.write("        //监听头工具栏事件\r\n");
      out.write("        table.on('toolbar(leaveBillList)', function(obj){\r\n");
      out.write("            switch(obj.event){\r\n");
      out.write("\t            case 'add':\r\n");
      out.write("\t               \ttoAddLeaveBill();\r\n");
      out.write("                \tbreak;\r\n");
      out.write("            };\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("        //打开  添加请假单的弹出层\r\n");
      out.write("        function toAddLeaveBill(){\r\n");
      out.write("            var index = layui.layer.open({\r\n");
      out.write("                title : \"添加请假单\",\r\n");
      out.write("                type : 2,//ifream层\r\n");
      out.write("                area:[\"800px\",\"500px\"],\r\n");
      out.write("                content : \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/leaveBill/toAddLeaveBill.action\",\r\n");
      out.write("                success : function(layero, index){\r\n");
      out.write("                    setTimeout(function(){\r\n");
      out.write("                        layui.layer.tips('点击此处返回请假单列表', '.layui-layer-setwin .layui-layer-close', {\r\n");
      out.write("                            tips: 3\r\n");
      out.write("                        });\r\n");
      out.write("                    },500)\r\n");
      out.write("                }\r\n");
      out.write("            })\r\n");
      out.write("            //layui.layer.full(index);\r\n");
      out.write("            //改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）\r\n");
      out.write("            $(window).on(\"resize\",function(){\r\n");
      out.write("                layui.layer.full(index);\r\n");
      out.write("            })\r\n");
      out.write("        }\r\n");
      out.write("        //修改请假单\r\n");
      out.write("        function updateLeaveBill(data){\r\n");
      out.write("            var index = layui.layer.open({\r\n");
      out.write("                title : \"修改请假单\",\r\n");
      out.write("                type : 2,\r\n");
      out.write("                area:[\"800px\",\"500px\"],\r\n");
      out.write("                content : \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/leaveBill/toUpdateLeaveBill.action?id=\"+data.id,\r\n");
      out.write("                success : function(layero, index){\r\n");
      out.write("                    setTimeout(function(){\r\n");
      out.write("                        layui.layer.tips('点击此处返回请假单列表', '.layui-layer-setwin .layui-layer-close', {\r\n");
      out.write("                            tips: 3\r\n");
      out.write("                        });\r\n");
      out.write("                    },500)\r\n");
      out.write("                }\r\n");
      out.write("            })\r\n");
      out.write("            //layui.layer.full(index);\r\n");
      out.write("            //改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）\r\n");
      out.write("            $(window).on(\"resize\",function(){\r\n");
      out.write("                layui.layer.full(index);\r\n");
      out.write("            })\r\n");
      out.write("        }\r\n");
      out.write("        //列表操作\r\n");
      out.write("        table.on('tool(leaveBillList)', function(obj){\r\n");
      out.write("            var layEvent = obj.event,\r\n");
      out.write("                data = obj.data;\r\n");
      out.write("            if(layEvent === 'edit'){ //编辑\r\n");
      out.write("                updateLeaveBill(data);//data主当前点击的行\r\n");
      out.write("            }else if(layEvent === 'del'){ //删除\r\n");
      out.write("                layer.confirm('确定删【'+data.title+'】请假单吗？',{icon:3, title:'提示信息'},function(index){\r\n");
      out.write("                    $.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/leaveBill/deleteLeaveBill.action\",{\r\n");
      out.write("                        id : data.id  //将需要删除的id作为参数传入\r\n");
      out.write("                    },function(data){\r\n");
      out.write("                        //刷新table\r\n");
      out.write("                        tableIns.reload();\r\n");
      out.write("                        //关闭提示框\r\n");
      out.write("                        layer.close(index);\r\n");
      out.write("                    })\r\n");
      out.write("                });\r\n");
      out.write("            }else if(layEvent==='startProcess'){\r\n");
      out.write("            \t layer.confirm('确定是提交【'+data.title+'】请假单吗？',{icon:3, title:'提示信息'},function(index){\r\n");
      out.write("            \t\t $.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/workFlow/startLeaveBillProcess.action\",{id:data.id},function(data){\r\n");
      out.write("                 \t\tlayer.msg(data.msg);\r\n");
      out.write("                 \t\t//刷新table\r\n");
      out.write("                         tableIns.reload();\r\n");
      out.write("                         //关闭提示框\r\n");
      out.write("                         layer.close(index);\r\n");
      out.write("                 \t},\"json\")\r\n");
      out.write("                 });\r\n");
      out.write("            }else if(layEvent===\"view\"){//查看审批进度\r\n");
      out.write("            \tviewApprovalProgress(data.id) \r\n");
      out.write("            }\r\n");
      out.write("        });\r\n");
      out.write("        //查看审批进度\r\n");
      out.write("        function viewApprovalProgress(id){\r\n");
      out.write("            var index = layui.layer.open({\r\n");
      out.write("                title : \"查看审批进度\",\r\n");
      out.write("                type : 2,\r\n");
      out.write("                area:[\"800px\",\"600px\"],\r\n");
      out.write("                content : \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/workFlow/toViewApprovalProgress.action?id=\"+id,\r\n");
      out.write("                success : function(layero, index){\r\n");
      out.write("                    setTimeout(function(){\r\n");
      out.write("                        layui.layer.tips('点击此处返回请假单列表', '.layui-layer-setwin .layui-layer-close', {\r\n");
      out.write("                            tips: 3\r\n");
      out.write("                        });\r\n");
      out.write("                    },500)\r\n");
      out.write("                }\r\n");
      out.write("            })\r\n");
      out.write("            //layui.layer.full(index);\r\n");
      out.write("            //改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）\r\n");
      out.write("            $(window).on(\"resize\",function(){\r\n");
      out.write("                layui.layer.full(index);\r\n");
      out.write("            })\r\n");
      out.write("        }\r\n");
      out.write("    })\r\n");
      out.write("    \r\n");
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
