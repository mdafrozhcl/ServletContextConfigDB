package ServletContextDB;

import java.io.*;
import java.util.Enumeration;

import javax.servlet.*;
import javax.servlet.http.*;

import org.w3c.dom.html.HTMLButtonElement;
public class DatabaseDemo extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
//		String style = "<style type=text/css>" + "a {"
//				+ "	" + "	font-weight: 200;"
//				+ "	font-style: italic;" + "	font-stretch: condensed;"
//				+ "	color: orange;" + "}" + "th {" + "	text-align: right;"
//				+ "	width: 250px;" + "}" + "td{" + "width: 250px;" + "}"
//				+ ".para {" + "	text-indent: 50px;" + "	float: left;"
//				+ "	margin-left: 10px;" + "}" + "div {" + "	border: thin;"
//				+ "	border-style: solid;" + "	border-color: maroon;"
//				+ "	top: 20px;" + "	width: 380px;" + "	padding: 50px;"
//				+ "	margin-top: 10px;" + "}"+
//				"</script>";
//		out.println(style);
		out.print("<div align=\"center\"></div>");
		out.println("<form action=\"/ServletContextConfigDB/RegisterEmpServlet\" method=\"post\">");
		out.println("<div class=\"para\"><table border=\"1\">");
		out.println("<caption>Form values</caption>");
		Enumeration<String> htmlForm = request.getParameterNames();
		while(htmlForm.hasMoreElements()){
			String name=htmlForm.nextElement();
			out.println("<tr><th>"+name+":</th><td><ul>");
			String[] values = request.getParameterValues(name);
			for(String v:values)
				out.println("<li><input type=\"hidden\" name=\""+name+"\" value=\""+v+"\"/>"+v+"</li> ");
			out.println("</ul></td></tr>");
		}
		out.println("<tr><td align=\"center\" colspan=\"2\"><input type=\"submit\" value=\"Submit\" name=\"submit\"/></td></tr>");
		out.println("</table></div></form>Click <a href=\"EmployeeRegistration.html\" style=\"text-decoration: blink;\">here</a> to go back</body>");
		
	}
}
