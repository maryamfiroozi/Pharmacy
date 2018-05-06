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
 * Servlet implementation class FirstSellerPage
 */
@WebServlet("/FirstSellerPage")
public class FirstSellerPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstSellerPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");  
		 PrintWriter out=response.getWriter();
		 
		 
		 HttpSession session=request.getSession();
		 String username=(String)session.getAttribute("uname");
		 out.print("<h4 style='color: #19415E;'>hello "+ username+ "</h4>" );
		 out.print("<html>");
		 out.println("<head>");
		 out.print("Updating drugs");
		 out.print("</head>");
		 out.println("<body>");
		 out.print("<table>");
		 out.print("<tr>");
		 out.print("<td>");
		 out.print("<a href='ShowStoreInfo' style='color: #	#ADFF2F;'>Show Drug List to update</a>");
		 out.print("</td>");
		 out.print("<tr>");
		 out.print("<a href='InesrtPrescriptionData' style='color: #	#ADFF2F;'>InesrtPrescriptionData'</a>");
		 out.print("</tr>");
		 out.print("</table>");
		 out.println("</body>");
		 out.print("</html>");
		 
	}

}
