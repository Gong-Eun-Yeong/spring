/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.5
 * Generated at: 2020-11-13 06:30:04 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class receive_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("jar:file:/D:/spring/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/ex07/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("jar:file:/D:/spring/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/ex07/WEB-INF/lib/jstl-1.2.jar!/META-INF/fmt.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1604883826713L));
  }

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
      out.write("     \r\n");
      out.write("     \r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("<script src=\"http://code.jquery.com/jquery-3.1.1.min.js\"></script>\r\n");
      out.write("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js\"></script>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>받은메시지</title>\r\n");
      out.write("<style>\r\n");
      out.write("      .read{color:blue; font-size:15px;}\r\n");
      out.write("      .unread{color:red; font-size:15px;}\r\n");
      out.write("   </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("   <h1>[받은메시지]</h1>\r\n");
      out.write("   <table border=1>\r\n");
      out.write("      <tr>\r\n");
      out.write("         <td width=100>받는이</td>\r\n");
      out.write("         <td width=200>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${vo.uname}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\r\n");
      out.write("         <td width=100>포인트</td>\r\n");
      out.write("         <td width=200><b><span id=\"point\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${vo.point}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</span></b></td>         \r\n");
      out.write("      </tr>\r\n");
      out.write("   </table>\r\n");
      out.write("   <br>\r\n");
      out.write("   <table border=1 id=\"tbl\"></table>\r\n");
      out.write("   <script id=\"temp\" type=\"text/x-handlebars-template\">\r\n");
      out.write("      <tr>\r\n");
      out.write("         <td width=120>보낸이</td>\r\n");
      out.write("         <td width=300>내용</td>\r\n");
      out.write("         <td width=150>보낸날짜</td>\r\n");
      out.write("         <td width=50>읽기</td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      {{#each .}}\r\n");
      out.write("      <tr class=\"row\">\r\n");
      out.write("         <td>{{sender}}-{{uname}}</td>\r\n");
      out.write("         <td>{{message}}</td>\r\n");
      out.write("         <td>{{sendDate}}</td>\r\n");
      out.write("         <td><button class=\"{{confirm readDate}}\" mid=\"{{mid}}\">읽기</button></td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      {{/each}}\r\n");
      out.write("   </script>\r\n");
      out.write("   <script>\r\n");
      out.write("   Handlebars.registerHelper(\"confirm\", function(readDate){\r\n");
      out.write("      if(!readDate) return \"unread\";\r\n");
      out.write("      else return \"read\";\r\n");
      out.write("   });\r\n");
      out.write("   </script> \r\n");
      out.write("   <div id=\"divRead\" style=\"width:700px;background:gray;color:white;padding:10px\">\r\n");
      out.write("   \t\t보낸이:<span id=\"sender\"></span><br>\r\n");
      out.write("   \t\t내용:<span id=\"message\"></span><br>\r\n");
      out.write("   \t\t발신일:<span id=\"sendDate\"></span><br>\r\n");
      out.write("   \t\t수신일:<span id=\"readDate\"></span>\r\n");
      out.write("   </div>\r\n");
      out.write("</body>\r\n");
      out.write("<script>\r\n");
      out.write("   var receiver=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${vo.uid}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\";\r\n");
      out.write("   getList();\r\n");
      out.write("   $(\"#divRead\").hide();\r\n");
      out.write("   \r\n");
      out.write("   $(\"#tbl\").on(\"click\",\".row button\", function(){\r\n");
      out.write("\t   var mid=$(this).attr(\"mid\");\r\n");
      out.write("\t   $(\"#divRead\").show();\r\n");
      out.write("\t   $.ajax({\r\n");
      out.write("\t\t   type:\"get\",\r\n");
      out.write("\t         url:\"readMessage\",\r\n");
      out.write("\t         data:{\"mid\":mid},\r\n");
      out.write("\t         success:function(data){\r\n");
      out.write("\t        \t $(\"#sender\").html(data.uname);\r\n");
      out.write("\t        \t $(\"#message\").html(data.message);\r\n");
      out.write("\t        \t $(\"#sendDate\").html(data.sendDate);\r\n");
      out.write("\t        \t $(\"#readDate\").html(data.readDate);\r\n");
      out.write("\t        \t getList();\r\n");
      out.write("\t        \t getUser();\r\n");
      out.write("\t        \t \r\n");
      out.write("\t         }\r\n");
      out.write("\t   })\r\n");
      out.write("   });\r\n");
      out.write("   function getList(){\r\n");
      out.write("      $.ajax({\r\n");
      out.write("         type:\"get\",\r\n");
      out.write("         url:\"receiveList\",\r\n");
      out.write("         data:{\"receiver\":receiver},\r\n");
      out.write("         success:function(data){\r\n");
      out.write("            var temp = Handlebars.compile($(\"#temp\").html());\r\n");
      out.write("             $(\"#tbl\").html(temp(data));\r\n");
      out.write("         }\r\n");
      out.write("      })\r\n");
      out.write("   }\r\n");
      out.write("      function getUser(){\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\ttype:\"get\",\r\n");
      out.write("\t\t\turl:\"read\",\r\n");
      out.write("\t\t\tdata:{\"uid\": receiver},\r\n");
      out.write("\t\t\tsuccess:function(data){\r\n");
      out.write("\t\t\t\t$(\"#point\").html(data.point);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t})\r\n");
      out.write("   }\r\n");
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
