/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-09-15 08:41:28 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view.system.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class userAdd_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>添加用户</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/layui/css/layui.css\" media=\"all\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/css/public.css\" media=\"all\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/zTree/css/metroStyle/metroStyle.css\" type=\"text/css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/plugin/css/index.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"childrenBody\">\r\n");
      out.write("\t<form class=\"layui-form\" action=\"#\" method=\"post\" id=\"frm\" lay-filter=\"frm\">\r\n");
      out.write("\t\t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t<label class=\"layui-form-label\">选择部门</label>\r\n");
      out.write("\t\t\t\t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t\t<div id=\"deptid\" name=\"deptid\" class=\"layui-form-select select-tree\"></div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t<label class=\"layui-form-label\">排序码</label>\r\n");
      out.write("\t\t\t\t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" name=\"ordernum\" lay-verify=\"number\"\r\n");
      out.write("\t\t\t\t\t\tautocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t<label class=\"layui-form-label\">领导部门</label>\r\n");
      out.write("\t\t\t\t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t\t<div id=\"leaderdeptid\" name=\"leaderdeptid\" class=\"layui-form-select select-tree\"></div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t<label class=\"layui-form-label\">选择领导</label>\r\n");
      out.write("\t\t\t\t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t\t<select name=\"mgr\" lay-filter=\"mgr\" id=\"mgr\">\r\n");
      out.write("\t\t\t\t        <option value=\"\"></option>\r\n");
      out.write("\t\t\t\t      </select>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t<label class=\"layui-form-label\">用户姓名</label>\r\n");
      out.write("\t\t\t\t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" name=\"name\" id=\"name\" lay-verify=\"required\" autocomplete=\"off\"\r\n");
      out.write("\t\t\t\t\t\tclass=\"layui-input\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t<label class=\"layui-form-label\">登陆名称</label>\r\n");
      out.write("\t\t\t\t<div class=\"layui-input-block\">\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" name=\"loginname\" id=\"loginname\"  autocomplete=\"off\"\r\n");
      out.write("\t\t\t\t\t\tclass=\"layui-input\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"layui-form-item layui-form-text\">\r\n");
      out.write("\t\t\t<label class=\"layui-form-label\">用户地址</label>\r\n");
      out.write("\t\t\t<div class=\"layui-input-block\">\r\n");
      out.write("\t\t\t\t<input type=\"text\" name=\"address\"  autocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"layui-form-item layui-form-text\">\r\n");
      out.write("\t\t\t<label class=\"layui-form-label\">用户备注</label>\r\n");
      out.write("\t\t\t<div class=\"layui-input-block\">\r\n");
      out.write("\t\t\t\t<textarea placeholder=\"请输入内容\" name=\"remark\" class=\"layui-textarea\"></textarea>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t<label class=\"layui-form-label\">用户性别</label>\r\n");
      out.write("\t\t\t\t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t\t<input type=\"radio\" name=\"sex\" value=\"1\" title=\"男\" checked=\"\">\r\n");
      out.write("\t\t\t\t\t<input type=\"radio\" name=\"sex\" value=\"0\" title=\"女\" > \r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t<label class=\"layui-form-label\">是否可用</label>\r\n");
      out.write("\t\t\t\t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t\t<input type=\"radio\" name=\"available\" value=\"1\" title=\"是\" checked=\"\">\r\n");
      out.write("\t\t\t\t\t<input type=\"radio\" name=\"available\" value=\"0\" title=\"否\"> \r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t<label class=\"layui-form-label\">入职时间</label>\r\n");
      out.write("\t\t\t\t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" name=\"hiredate\" id=\"hiredate\"  autocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t<div class=\"layui-input-block\" style=\"text-align: center;\">\r\n");
      out.write("\t\t\t\t<!--lay-submit标记当按钮是一个提交按钮   -->\r\n");
      out.write("\t\t\t\t<a  href=\"javascript:void(0)\" class=\"layui-btn\" lay-submit=\"\" lay-filter=\"userSubmit\">提交</a>\r\n");
      out.write("\t\t\t\t<button type=\"reset\" class=\"layui-btn layui-btn-primary\">重置</button>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</form>\r\n");
      out.write("</body>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/layui/layui.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/zTree/js/jquery-1.4.4.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/zTree/js/jquery.ztree.core.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/plugin/js/selectTree.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("var form;\r\n");
      out.write("\tlayui.use([ 'form','jquery','layer','laydate' ], function() {\r\n");
      out.write("\t\tform=layui.form;//得到form对象\r\n");
      out.write("\t\tvar $=layui.jquery;\r\n");
      out.write("\t\tvar laydate=layui.laydate;\r\n");
      out.write("\t\tvar layer = parent.layer === undefined ? layui.layer : parent.layer;\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t//时间选择器的绑定\r\n");
      out.write("\t\tlaydate.render({\r\n");
      out.write("\t\t\telem:'#hiredate'\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t//添加提交事件\r\n");
      out.write("\t\tform.on(\"submit(userSubmit)\",function(data){\r\n");
      out.write("\t\t\tvar params=$(\"#frm\").serialize();\r\n");
      out.write("\t\t\t$.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/user/addUser.action?\"+params,function(obj){\r\n");
      out.write("\t\t\t\tlayer.msg(obj.msg);//弹出添加成功或失败\r\n");
      out.write("\t\t\t\tparent.tableIns.reload();//刷新表格\r\n");
      out.write("\t\t\t\t//关闭窗口\r\n");
      out.write("\t\t\t\tvar index=layer.getFrameIndex(window.name);\r\n");
      out.write("\t\t\t\tlayer.close(index);\r\n");
      out.write("\t\t\t}); \r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t //监听用户姓名的失去焦点事件\r\n");
      out.write("\t    $(\"#name\").on(\"blur\",function(){\r\n");
      out.write("\t    \t//请求后台，把中文转成拼音\r\n");
      out.write("\t\t    //var name=$(this).val();\r\n");
      out.write("\t    \tvar name=this.value;\r\n");
      out.write("\t    \t$.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/user/initUserLoginNameUseUserName.action\",{name:name},function(obj){\r\n");
      out.write("\t    \t\t$(\"#loginname\").val(obj);\r\n");
      out.write("\t    \t});\r\n");
      out.write("\t    })\r\n");
      out.write("\t});\r\n");
      out.write("    $(document).ready(function () {\r\n");
      out.write("       initDeptTree();\r\n");
      out.write("    });\r\n");
      out.write("    function initDeptTree(){\r\n");
      out.write("    \t//加载可用的部门\r\n");
      out.write("    \t$.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/dept/loadDeptTree.action?available=1\",function(zNodes){\r\n");
      out.write("    \t\t initSelectTree(\"deptid\",zNodes, false);\r\n");
      out.write("    \t\t initSelectTree(\"leaderdeptid\",zNodes, false);\r\n");
      out.write("             $(\".layui-nav-item a\").bind(\"click\", function () {\r\n");
      out.write("                 if (!$(this).parent().hasClass(\"layui-nav-itemed\") && !$(this).parent().parent().hasClass(\"layui-nav-child\")) {\r\n");
      out.write("                     $(\".layui-nav-tree\").find(\".layui-nav-itemed\").removeClass(\"layui-nav-itemed\")\r\n");
      out.write("                 }\r\n");
      out.write("             })\r\n");
      out.write("    \t});\r\n");
      out.write("    };\r\n");
      out.write("    //根据部门编号查询部门下面的所有员工\r\n");
      out.write("    function initMgr(deptid){\r\n");
      out.write("    \t//alert(deptid);\r\n");
      out.write("    \t$.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/user/loadUserByDeptId.action\",{deptid:deptid},function(obj){\r\n");
      out.write("    \t\tvar html=\"\";\r\n");
      out.write("    \t\tfor(var i=0;i<obj.length;i++){\r\n");
      out.write("    \t\t\thtml+=\" <option value=\"+obj[i].id+\">\"+obj[i].name+\"</option>\"\r\n");
      out.write("    \t\t}\r\n");
      out.write("    \t\t$(\"#mgr\").html(html);\r\n");
      out.write("    \t\tform.render(\"select\");//重新渲染\r\n");
      out.write("    \t},\"json\");\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("   \r\n");
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
