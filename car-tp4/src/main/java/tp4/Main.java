package tp4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Main extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		System.out.println("on passe ici");
		response.setContentType("text/html");
		PrintWriter out =  response.getWriter();
		out.print("<html><body>");
		out.print("<h1>LOLILOL</h1>");
		out.print("</body></html>");
	}
}
