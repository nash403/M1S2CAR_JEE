/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat (TomEE)/7.0.55 (1.7.1)
 * Generated at: 2016-04-26 21:23:42 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import car.tp4.*;
import java.util.List;

public final class list_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t\t<link rel=\"stylesheet\" href=\"css/font-awesome.min.css\">\n");
      out.write("\t\t\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap.min.css\"/>\n");
      out.write("\t</head>\n");
      out.write("\t<body class=\"container text-center\" style=\"margin-top:80px;\">\n");
      out.write("\t\t<h1>Liste des livres\n");
      out.write("\t\t");

		
		List<Book> livres = (List<Book>) request.getAttribute("LIST");
		if ( livres != null ) {
			if (livres.size() == 0) out.print("</h1><b>Bibliothèque vide !</b>");
			else out.print(" <span class=\"badge blue\">("+livres.size()+" livres)</span> </h1>");
		
      out.write("\n");
      out.write("\t\t<div class=\"row text-center\">\n");
      out.write("\t\t\t<div class=\"col col-xs-12 col-md-6 col-md-offset-3\">\n");
      out.write("\t\t\t\t<form action=\"list.jsp\" method=\"post\">\n");
      out.write("\t\t\t\t\t<table class=\"table table-hover table-bordered\">\n");
      out.write("\t\t\t\t\t  <tr>\n");
      out.write("\t\t\t\t\t    <th>Firstname</th>\n");
      out.write("\t\t\t\t\t    <th>Lastname</th>\t\t\n");
      out.write("\t\t\t\t\t    <th>Points</th>\n");
      out.write("\t\t\t\t\t    <th>Ajouter au panier</th>\n");
      out.write("\t\t\t\t\t  </tr>\n");
      out.write("\t\t");

			//out.print("<ul>");
			for(Book b : livres){
		
      out.write("\n");
      out.write("\t\t\t\t\t  <tr>\n");
      out.write("\t\t\t\t\t    <td>Jill <input type=\"text\" name=\"author\" value=\"toto\" class=\"sr-only\"/></td>\n");
      out.write("\t\t\t\t\t    <td>Smith <input type=\"text\" name=\"title\" value=\"toto\" class=\"sr-only\"/></td>\t\t\n");
      out.write("\t\t\t\t\t    <td>50 <input type=\"text\" name=\"id\" value=\"toto\" class=\"sr-only\"/></td>\n");
      out.write("\t\t\t\t\t    <td>\n");
      out.write("\t\t\t\t\t    \t<button type=\"submit\" class=\"btn btn-success\">\n");
      out.write("\t\t\t\t\t\t\t  Ajouter <i class=\"fa fa-plus-square-o\"></i>\n");
      out.write("\t\t\t\t\t\t\t</button>\n");
      out.write("\t\t\t\t\t    </td>\n");
      out.write("\t\t\t\t\t  </tr>\n");
      out.write("\t\t");

				//out.print("<li>"+b+"</li>");
			}
		    //out.print("</ul>");
		}
		else out.print("<b>Bibliothèque injoignable</b>");
		
		
      out.write("\n");
      out.write("\t\t\t\t\t  <tr>\n");
      out.write("\t\t\t\t\t    <td>gzrgz <input type=\"text\" name=\"author\" value=\"toto\" class=\"sr-only\"/></td>\n");
      out.write("\t\t\t\t\t    <td>gzzhe <input type=\"text\" name=\"title\" value=\"toto\" class=\"sr-only\"/></td>\t\t\n");
      out.write("\t\t\t\t\t    <td>hetz <input type=\"text\" name=\"id\" value=\"toto\" class=\"sr-only\"/></td>\n");
      out.write("\t\t\t\t\t    <td>\n");
      out.write("\t\t\t\t\t    \t<button type=\"submit\" class=\"btn btn-success\">\n");
      out.write("\t\t\t\t\t\t\t  Ajouter <i class=\"fa fa-plus-square-o\"></i>\n");
      out.write("\t\t\t\t\t\t\t</button>\n");
      out.write("\t\t\t\t\t    </td>\n");
      out.write("\t\t\t\t\t  </tr>\n");
      out.write("\t\t\t\t\t  <tr>\n");
      out.write("\t\t\t\t\t    <td>hezs <input type=\"text\" name=\"author\" value=\"toto\" class=\"sr-only\"/></td>\n");
      out.write("\t\t\t\t\t    <td>nntedn <input type=\"text\" name=\"title\" value=\"toto\" class=\"sr-only\"/></td>\t\t\n");
      out.write("\t\t\t\t\t    <td>nery <input type=\"text\" name=\"id\" value=\"toto\" class=\"sr-only\"/></td>\n");
      out.write("\t\t\t\t\t    <td>\n");
      out.write("\t\t\t\t\t    \t<button type=\"submit\" class=\"btn btn-success\">\n");
      out.write("\t\t\t\t\t\t\t  Ajouter <i class=\"fa fa-plus-square-o\"></i>\n");
      out.write("\t\t\t\t\t\t\t</button>\n");
      out.write("\t\t\t\t\t    </td>\n");
      out.write("\t\t\t\t\t  </tr>\n");
      out.write("\t\n");
      out.write("\t\t\t\t\t</table>\n");
      out.write("\t\t\t\t</form>\t\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\n");
      out.write("\t\t<a href=\"/index.jsp\">Retour Accueil</a>\n");
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
