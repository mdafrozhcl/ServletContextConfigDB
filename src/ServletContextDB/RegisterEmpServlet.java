package ServletContextDB;

import java.sql.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class RegisterEmpServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		String db_connection=context.getInitParameter("db_connection");
		String connection_url=context.getInitParameter("connection_url");
		String username=context.getInitParameter("username");
		String password=context.getInitParameter("password");
		String empfirstname = request.getParameter("empfirstname");
		String emplastname  = request.getParameter("emplastname");
		String dobday = request.getParameter("dobday");
		String dobmonth = request.getParameter("dobmonth"); 
		String dobyear= request.getParameter("dobyear");
		String emprole= request.getParameter("emprole");
		double empsalary = Double.parseDouble(request.getParameter("salary"));
		String dob = dobyear+dobmonth+dobday;
		PrintWriter out=response.getWriter();
		
		try{
			Class.forName(db_connection);
			Connection con = DriverManager.getConnection(connection_url,username,password);
			Statement stmt = con.createStatement();
			String quiery ="insert into Employee values('"+empfirstname+"','"+emplastname+"',to_date('"+dob+"','YYYYMMDD'),'"+emprole+"',"+empsalary+")";
			out.println(quiery);
			int n = stmt.executeUpdate(quiery);
			out.println("successfull...");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
