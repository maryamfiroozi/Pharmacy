package PharmacyPack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FirstAdminPage
 */
@WebServlet("/FirstAdminPage")
public class FirstAdminPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstAdminPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 response.setContentType("text/html;");  
		 PrintWriter out=response.getWriter();
		 
		 HttpSession session=request.getSession();
		 String username=(String)session.getAttribute("uname");
		
		 out.print("<html>");
		 out.print("<head>");
		 out.print("<title>Insert title here</title>");
		// out.print("<LINK REL='StyleSheet' HREF='<%=request.getContextPath()%>/a.css' TYPE='text/css'> ");
		 out.print("</head>");
		 out.print("<body>");
		 out.print("<h4 style='color: #19415E;'>hello "+ username+ "</h4>" );
		 

		 out.print("<div style='margin: 40px;'>");
		 out.print("<table style='width: 100%;font-family: B Nazanin;font-size: 20px;'>");
		 out.print("<tr>");
		 out.print("<td style='width: 35%;background-color: #C1D4EC;padding-left: 10px;'>");
		 out.print("<a href='ShowDrug' style='color: #1E4766;'>Show Drug List / Update / Delete</a>");
		 out.print("</td>");
		 out.print("<td style='width: 40%;'></td>");
		 out.print("<td style='width: 25%;text-align: right;background-color: #C1D4EC;padding-right: 10px;color: #1E4766;'><a href='#'  style='color: #1E4766;'>Report</a></td>");
		 out.print("</tr>");

		 
		 
		 out.print("<tr>");
		 out.print("<td style='width: 35%;background-color: #C1D4EC;padding-left: 10px;'><a href='#' style='color: #1E4766;'>Delete Patient</a></td>");
		 out.print("<td style='width: 40%;'></td>");
		 out.print("<td style='width: 25%;text-align: right;background-color: #C1D4EC;padding-right: 10px;color: #1E4766;'><a href='#'  style='color: #1E4766;'>Update Insurance</a></td>");
		 out.print("</tr>");
		 
		 
		 out.print("<tr>");
		 out.print("<td style='width: 35%;background-color: #C1D4EC;padding-left: 10px;'><a href='#' style='color: #1E4766;'>Calcute Insurance Money Each Month</a></td>");
		 out.print("<td style='width: 40%;'></td>");
		 out.print("<td style='width: 25%;text-align: right;background-color: #C1D4EC;padding-right: 10px;color: #1E4766;'><a href='#'  style='color: #1E4766;'>Delete Insurance</a></td>");
		 out.print("</tr>");
		 
		 
		 out.print("</table>");
		 out.print("</div>");
		 out.print("</body>");
		 out.print("</html>");
		
	}

}
