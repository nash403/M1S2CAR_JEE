/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat (TomEE)/7.0.55 (1.7.1)
 * Generated at: 2016-04-27 22:37:32 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import car.tp4.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("\t<head>\n");
      out.write("\t\t<meta charset=\"utf-8\" />\n");
      out.write("\t\t<title>CAR TP4 - Exo 2</title>\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"/css/font-awesome.min.css\">\n");
      out.write("\t\t\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"/css/bootstrap.min.css\"/>\n");
      out.write("\t</head>\n");
      out.write("\t<body class=\"container text-center\" style=\"margin-top:80px;\">\n");
      out.write("\t\t");

		
		//String author = request.getParameter("author");
		Book livre = (Book) request.getAttribute("livre");
		if ( livre != null ) {
			//String title = request.getParameter("title");
		    String year = request.getParameter("year");
			//Book livre = new Book(new Author(author),title);
		    out.print("Auteur : "+livre.getAuthor().toString()+"<br/>");
		    out.print("Titre : "+livre.getTitle()+"<br/>");
		    out.print("Ann&eacute; : "+year+"<br/><p/>");
		} else out.print("<b>Pas de livre ajouté récemment.</b>");
		
		
      out.write("\n");
      out.write("\t\t\n");
      out.write("\t\t<h1>Ajout d'un livre</h1>\n");
      out.write("\t\t<a href=\"/car/tp4/list\">Voir la liste des livres et des auteurs</a>\n");
      out.write("\t\t<form action=\"/car/tp4/add\" method=\"GET\">\n");
      out.write("\t\t\tAuteur : <input type=\"text\" name=\"author\"><br/>\n");
      out.write("\t\t\tTitre : <input type=\"text\" name=\"title\"><br/>\n");
      out.write("\t\t\tAnn&eacute;e : <input type=\"text\" name=\"year\"><br/>\n");
      out.write("\t\t\t<input type=\"submit\">\n");
      out.write("\t\t</form>\n");
      out.write("\t</body>\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
