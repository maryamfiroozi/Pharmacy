package PharmacyPack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.fabric.Response;

/**
 * Servlet implementation class InesrtPrescriptionData
 */
@WebServlet("/InesrtPrescriptionData")
public class InesrtPrescriptionData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InesrtPrescriptionData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		out.print("<form action='InsertPrescriptionDataToDB' method='get'>");
		 out.print("<table style='border: 2px solid #6A247A;width: 500px;margin: 50px;'>");
		 out.print("<tr>");
		 out.print("<td>");
		 out.print("Prescription Date:" + "<br>");
		 out.print("<input type = 'text' name = 'PrescriptionDate'>");
		 out.print("<br>");
		 out.print("</td>");
		 out.print("</tr>");
		 out.print("<tr>");
		 out.println("<td>");
		 out.println("<h>");
		 out.println("Choose one of the options below:" + "<br>");
		 out.println("</h>");
		 out.print( "<input type='radio'  name = 'insuranceCondition' value = 'NoInsurance' checked>does not have insurance" + "<br>");
		 out.print( "<input type='radio'  name = 'insuranceCondition' value='HasInsurance'>has insurance");
		 out.print("</td>");
		 out.print("<td>" + "<br>");
		 out.print( "<input type='submit' value='save'>");
		 out.print("</td>");
		 out.print("</form>");
	}
		
		 
		 
		 
		 
		 
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
