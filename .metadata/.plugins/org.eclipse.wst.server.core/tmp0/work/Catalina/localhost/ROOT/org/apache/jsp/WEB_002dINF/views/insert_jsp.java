/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.5
 * Generated at: 2020-11-19 02:31:10 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class insert_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<script src=\"http://code.jquery.com/jquery-3.1.1.min.js\"></script>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>상품정보</title>\r\n");
      out.write("\t<style>\r\n");
      out.write("\t\t#listFile img {width:150px; margin:5px;}\r\n");
      out.write("\t</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<h1>[상품정보]</h1>\r\n");
      out.write("\t<form name=\"frm\" action=\"insert\" method=\"post\" enctype=\"multipart/form-data\">\r\n");
      out.write("\t\t<table border=1>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td width=100>상품이름</td>\r\n");
      out.write("\t\t\t\t<td width=500><input type=\"text\" name=\"pname\" size=50></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td width=100>상품가격</td>\r\n");
      out.write("\t\t\t\t<td width=500><input type=\"text\" name=\"price\" size=5>원</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td width=100>대표이미지</td>\r\n");
      out.write("\t\t\t\t<td width=500>\r\n");
      out.write("\t\t\t\t\t<img src=\"http://placehold.it/150x120\" id=\"image\" width=150>\r\n");
      out.write("\t\t\t\t\t<input type=\"file\" name=\"file\">\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\t\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td width=100 height=180>\r\n");
      out.write("\t\t\t\t\t<input type=\"button\" id=\"btnImage\" value=\"첨부이미지\">\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t<input type=\"file\" name=\"files\" multiple>\r\n");
      out.write("\t\t\t\t\t<div id=\"listFile\"></div>\r\n");
      out.write("\t\t\t\t</td>\t\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t<input type=\"submit\" value=\"저장\">\r\n");
      out.write("\t\t<input type=\"reset\" value=\"취소\">\r\n");
      out.write("\t</form>\r\n");
      out.write("</body>\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("\t$(frm.file).hide();\r\n");
      out.write("\t$(frm.files).hide();\r\n");
      out.write("\t\r\n");
      out.write("\t$(\"#btnImage\").on(\"click\", function(){\r\n");
      out.write("\t\t$(frm.files).click();\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\t$(\"#image\").on(\"click\", function(){\r\n");
      out.write("\t\t$(frm.file).click();\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\t$(frm.file).on(\"change\",function(){\r\n");
      out.write("\t\tvar file=$(frm.file)[0].files[0];\r\n");
      out.write("\t\t$(\"#image\").attr(\"src\",URL.createObjectURL(file));\r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
      out.write("\t$(frm.files).on(\"change\",function(){\r\n");
      out.write("\t\tvar files=$(frm.files)[0].files;\r\n");
      out.write("\t\tvar str=\"\";\r\n");
      out.write("\t\t$.each(files, function(index, file){\r\n");
      out.write("\t\t\tstr += \"<img src='\" + URL.createObjectURL(file) + \"'>\";\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t$(\"#listFile\").html(str);\r\n");
      out.write("\t});\r\n");
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
