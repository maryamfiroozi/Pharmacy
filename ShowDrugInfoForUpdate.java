package PharmacyPack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Manager.DBManager;
import Manager.Drug;

/**
 * Servlet implementation class ShowInfoForUpdate
 */
@WebServlet("/ShowDrugInfoForUpdate")
public class ShowDrugInfoForUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DBManager dbManager = new DBManager();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowDrugInfoForUpdate() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
	response.setContentType("text/html;");
		PrintWriter writer = response.getWriter();
		int drugId = Integer.parseInt(request.getParameter("drugId"));

		Drug specialDrugInfo = dbManager.showSpecialDrug(drugId);

		writer.write("<!DOCTYPE html>");
		writer.write("<html>");
		writer.write("<body>");
		writer.write("<div style='padding: 30px;background-color: #D5EDDC;height: 300px;'>");
		
		
		if (specialDrugInfo == null) {
			writer.write("<h3 style='color: red;'>This ID does not exist</h3>");
			
			
		} else {
			writer.write("<form action='Update' method='get'>");
			writer.write("<table style='height: 150px;'>");
			writer.write("<tr>");
			writer.write("<td>Drug Id : </td>");
			writer.write("<td><INPUT TYPE=TEXT NAME=drugId id=drugId disabled VALUE=" + specialDrugInfo.getDrugID() + "></td>");
			writer.write("</tr>");

			writer.write("<tr>");
			writer.write("<td>Name : </td>");
			writer.write("<td><INPUT TYPE=TEXT NAME=name id=name VALUE=" + specialDrugInfo.getName() + "></td>");
			writer.write("</tr>");

			writer.write("<tr>");
			writer.write("<td>Price : </td>");
			writer.write("<td><INPUT TYPE=TEXT NAME=price VALUE=" + specialDrugInfo.getPrice() + "></td>");
			writer.write("</tr>");

			writer.write("<tr>");
			writer.write("<td colspan='2' ><input style='width: 165px; height: 27px; margin-top: 10px; margin-left: 60px; background-color: #426783; color: white;'  type='submit' value='Update Drug Information'></td>");

			writer.write("</tr>");

			writer.write("</table>");
			writer.write("</form>");
		}
		writer.write("</body>");
		writer.write("</html>");
		writer.write("</div>");
		
		
		writer.close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// showInfoForUpdate
		// state
		// redirect to update page if found
		// else redirect to Error Message page

	}

}
