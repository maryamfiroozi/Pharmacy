package PharmacyPack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertDrug
 */
@WebServlet("/InsertDrug")
public class InsertDrugRelatedToPrescription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertDrugRelatedToPrescription() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 PrintWriter out = response.getWriter();
		out.print("<form action='InsertDrugPrescriptionToDB' method='get'>");
		 out.print("<table style='border: 2px solid #6A247A;width: 500px;margin: 50px;'>");
		 out.print("<tr>");
		 out.print("<td>");
		 out.print("Drug name:" + "<br>");
		 out.print("<input type = 'text' name = 'DrugName'>");
		 out.print("<br>");
		 out.print("</td>");
		 out.print("</tr>");
		 out.print("<tr>");
		 out.print("<td>");
		 out.print("number:"+"<br>");
		 out.print("<input type = 'text' name = 'number'>" + "<br>");
		 out.print("</td>");
		 out.print("</tr>");
		 out.print("<tr>");
		 out.print("<td>");
		 out.print("<h>" + "do you want to add any other drug?" + "</h>" + "<br>");
		 
		 out.print("</td>");
		 out.print("</tr>");
		 out.print("<tr>");
		 out.print("<td>");
		 out.print( "<input type='radio'  name = 'OtherDrug' value = 'No' checked>NO" + "<br>");
		 out.print( "<input type='radio'  name = 'OtherDrug' value = 'Yes'>Yes" + "<br>");
		 out.print("</td>");
		 out.print("</tr>");
		 out.print("<td>");
		 out.print( "<input type='submit' value='Save'>");
		 out.print("</td>");
		 out.print("</form>");
		 System.out.println(InsertPrescriptionDataToDB._insuranceState);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
