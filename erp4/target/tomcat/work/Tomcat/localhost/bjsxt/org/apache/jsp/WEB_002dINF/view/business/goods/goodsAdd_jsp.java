/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-09-17 01:19:20 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view.business.goods;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class goodsAdd_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>添加商品</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/layui/css/layui.css\"\r\n");
      out.write("\tmedia=\"all\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/css/public.css\"\r\n");
      out.write("\tmedia=\"all\" />\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"childrenBody\">\r\n");
      out.write("\t<form class=\"layui-form\" method=\"post\" id=\"frm\">\r\n");
      out.write("\t\t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t<label class=\"layui-form-label\">选择供应商</label>\r\n");
      out.write("\t\t\t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t<select name=\"providerid\" lay-filter=\"providerid\">\r\n");
      out.write("\t\t\t\t\t<option value=\"0\">--请选择供应商--</option>\r\n");
      out.write("\t\t\t\t\t");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t</select>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t<label class=\"layui-form-label\">商品名称</label>\r\n");
      out.write("\t\t\t\t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" name=\"goodsname\" lay-verify=\"required\"\r\n");
      out.write("\t\t\t\t\t\tautocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t<label class=\"layui-form-label\">产地</label>\r\n");
      out.write("\t\t\t\t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" name=\"produceplace\" placeholder=\"产地\"\r\n");
      out.write("\t\t\t\t\t\tautocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t<label class=\"layui-form-label\">规格</label>\r\n");
      out.write("\t\t\t\t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t\t<input type=\"tel\" name=\"size\" placeholder=\"规格\" autocomplete=\"off\"\r\n");
      out.write("\t\t\t\t\t\tclass=\"layui-input\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t<label class=\"layui-form-label\">包装</label>\r\n");
      out.write("\t\t\t\t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" name=\"goodspackage\" autocomplete=\"off\"\r\n");
      out.write("\t\t\t\t\t\tclass=\"layui-input\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t<label class=\"layui-form-label\">生产批号</label>\r\n");
      out.write("\t\t\t\t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" name=\"productcode\" placeholder=\"生产批号\"\r\n");
      out.write("\t\t\t\t\t\tautocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t<label class=\"layui-form-label\">批准文号</label>\r\n");
      out.write("\t\t\t\t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t\t<input type=\"tel\" name=\"promitcode\" placeholder=\"批准文号\"\r\n");
      out.write("\t\t\t\t\t\tautocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t<label class=\"layui-form-label\">销售参考价格</label>\r\n");
      out.write("\t\t\t\t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" name=\"price\" lay-verify=\"required\"\r\n");
      out.write("\t\t\t\t\t\tautocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t<label class=\"layui-form-label\">是否可用</label>\r\n");
      out.write("\t\t\t\t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t\t<input type=\"radio\" name=\"available\" value=\"1\" title=\"是\" checked=\"\">\r\n");
      out.write("\t\t\t\t\t<input type=\"radio\" name=\"available\" value=\"0\" title=\"否\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t<label class=\"layui-form-label\">库存</label>\r\n");
      out.write("\t\t\t\t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" name=\"number\" placeholder=\"库存\"\r\n");
      out.write("\t\t\t\t\t\tlay-verify=\"required|number\" autocomplete=\"off\"\r\n");
      out.write("\t\t\t\t\t\tclass=\"layui-input\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t<label class=\"layui-form-label\">预警库存</label>\r\n");
      out.write("\t\t\t\t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t\t<input type=\"tel\" name=\"dangernum\" placeholder=\"预警库存\"\r\n");
      out.write("\t\t\t\t\t\tlay-verify=\"required|number\" autocomplete=\"off\"\r\n");
      out.write("\t\t\t\t\t\tclass=\"layui-input\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"layui-form-item layui-form-text\">\r\n");
      out.write("\t\t\t<label class=\"layui-form-label\">商品描述</label>\r\n");
      out.write("\t\t\t<div class=\"layui-input-block\">\r\n");
      out.write("\t\t\t\t<textarea placeholder=\"请输入商品描述\" name=\"description\"\r\n");
      out.write("\t\t\t\t\tclass=\"layui-textarea\"></textarea>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"layui-form-item layui-form-text\">\r\n");
      out.write("\t\t\t<label class=\"layui-form-label\">商品图片</label>\r\n");
      out.write("\t\t\t<div class=\"layui-upload\">\r\n");
      out.write("\t\t\t\t<img class=\"layui-upload-img\" width=\"100px\" height=\"80px\" id=\"goodsimg_img\">\r\n");
      out.write("\t\t\t\t<button type=\"button\" class=\"layui-btn\" id=\"goodspath\">上传图片</button>\r\n");
      out.write("\t\t\t\t<span id=\"goodsText\"></span>\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" name=\"goodsimg\" id=\"goodsimg\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"layui-form-item\" style=\"text-align: center;\">\r\n");
      out.write("\t\t\t<button class=\"layui-btn\" lay-submit=\"\" lay-filter=\"addGoods\">提交</button>\r\n");
      out.write("\t\t\t<button type=\"reset\" class=\"layui-btn layui-btn-warm\">重置</button>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</form>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/layui/layui.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tlayui.use([ 'form', 'jquery', 'layer', 'upload' ],\r\n");
      out.write("\t\t\t\t\tfunction() {\r\n");
      out.write("\t\t\t\t\t\tvar form = layui.form;\r\n");
      out.write("\t\t\t\t\t\tvar $ = layui.jquery;\r\n");
      out.write("\t\t\t\t\t\tvar upload = layui.upload;\r\n");
      out.write("\t\t\t\t\t\t//如果父页面有layer就使用父页的  没有就自己导入\r\n");
      out.write("\t\t\t\t\t\tvar layer = parent.layer === undefined ? layui.layer\r\n");
      out.write("\t\t\t\t\t\t\t\t: top.layer;\r\n");
      out.write("\t\t\t\t\t\t//监听提交\r\n");
      out.write("\t\t\t\t\t\tform.on('submit(addGoods)', function(data) {\r\n");
      out.write("\t\t\t\t\t\t\tvar data = $(\"#frm\").serialize();\r\n");
      out.write("\t\t\t\t\t\t\t//使用ajax提交\r\n");
      out.write("\t\t\t\t\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\t\t\t\t\turl : '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/goods/addGoods.action',\r\n");
      out.write("\t\t\t\t\t\t\t\ttype : 'POST',\r\n");
      out.write("\t\t\t\t\t\t\t\tasync : true, //或false,是否异步\r\n");
      out.write("\t\t\t\t\t\t\t\tdata : data,\r\n");
      out.write("\t\t\t\t\t\t\t\ttimeout : 5000, //超时时间\r\n");
      out.write("\t\t\t\t\t\t\t\tdataType : 'json', //返回的数据格式：json/xml/html/script/jsonp/text\r\n");
      out.write("\t\t\t\t\t\t\t\tsuccess : function(data) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t//关闭弹出层\r\n");
      out.write("\t\t\t\t\t\t\t\t\t//关闭添加的弹出层\r\n");
      out.write("\t\t\t\t\t\t\t\t\tvar addIndex = parent.layer\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t.getFrameIndex(window.name);\r\n");
      out.write("\t\t\t\t\t\t\t\t\twindow.parent.layer.close(addIndex);\r\n");
      out.write("\t\t\t\t\t\t\t\t\t//刷新父页面的table\r\n");
      out.write("\t\t\t\t\t\t\t\t\twindow.parent.tableIns.reload();\r\n");
      out.write("\t\t\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\t\t\terror : function(xhr, textStatus) {\r\n");
      out.write("\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t})\r\n");
      out.write("\t\t\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t//普通图片上传\r\n");
      out.write("\t\t\t\t\t\tvar uploadInst = upload\r\n");
      out.write("\t\t\t\t\t\t\t\t.render({\r\n");
      out.write("\t\t\t\t\t\t\t\t\telem : '#goodspath',\r\n");
      out.write("\t\t\t\t\t\t\t\t\turl : '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/upload/uploadFile.action',\r\n");
      out.write("\t\t\t\t\t\t\t\t\taccept:'images',\r\n");
      out.write("\t\t\t\t\t\t\t\t\tacceptMime:'image/*',\r\n");
      out.write("\t\t\t\t\t\t\t\t\tfield:'mf',\r\n");
      out.write("\t\t\t\t\t\t\t\t\tbefore : function(obj) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t//预读本地文件示例，不支持ie8\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tobj.preview(function(index, file,\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tresult) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t$('#goodsimg_img').attr('src', result); //图片链接（base64）\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\t\t\t\tdone : function(res) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t//如果上传失败\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tif (res.code > 0) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\treturn layer.msg('上传失败');\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t//上传成功\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t$('#goodsimg_img').attr('src', res.data.src); //图片链接（base64）\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t$('#goodsimg').val(res.data.src);\r\n");
      out.write("\t\t\t\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\t\t\t\terror : function() {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t//演示失败状态，并实现重传\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tvar goodsText = $('#goodsText');\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tgoodsText.html('<span style=\"color: #FF5722;\">上传失败</span> <a class=\"layui-btn layui-btn-xs goods-reload\">重试</a>');\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tgoodsText.find('.goods-reload').on(\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t'click', function() {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\tuploadInst.upload();\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t});\r\n");
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

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /WEB-INF/view/business/goods/goodsAdd.jsp(21,5) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("sn");
    // /WEB-INF/view/business/goods/goodsAdd.jsp(21,5) name = items type = java.lang.Object reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${providers }", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t<option value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sn.id }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sn.providername }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</option>\r\n");
          out.write("\t\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }
}