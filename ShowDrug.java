package PharmacyPack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Manager.DBManager;
import Manager.Drug;

/**
 * Servlet implementation class ShowDrug
 */
@WebServlet("/ShowDrug")
public class ShowDrug extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowDrug() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html;");  
		 PrintWriter out=response.getWriter();
		 
		 DBManager dbManager=new DBManager();
		 ArrayList<Drug> _drugList=dbManager.showDrug();
	
		 out.print("<form action='ShowDrugInfoForUpdate' method='get'>");
		 out.print("<table style='border: 2px solid #6A247A;width: 500px;margin: 50px;'>");
		 out.print("<tr style='background: #FBB80F;'><td>drugId</td><td>name</td><td>price</td></tr>");
		 for(int i=0;i<_drugList.size();i++)
		 {
			 int drugId= _drugList.get(i).getDrugID();
			 out.print("<tr>");
			 out.print("<td id='drugID'>" +  _drugList.get(i).getDrugID() +"</td>");
			 
			 out.print("<td>" +  _drugList.get(i).getName());
			 out.print("</td>");
			 
			 out.print("<td>" +  _drugList.get(i).getPrice());
			 out.print("</td>");
			 
			 
			 out.print("<td><input type='hidden' name='drugId' value='drugId' /></td>");
			 out.print("<td><a href='ShowDrugInfoForUpdate?drugId="+drugId+" '>Edit</a></td>");
			 out.print("<td><a href='DeleteDrug?drugId="+drugId+" '>Delete</a></td>");
			 
			 
			 out.print("</tr>");
		 }
		 out.print("</table>");
		 out.print("</form>");
		 
		 
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
