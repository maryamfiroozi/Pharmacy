package PharmacyPack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.print.attribute.standard.RequestingUserName;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;
import org.apache.jasper.tagplugins.jstl.core.Out;

import Manager.DBManager;
import Manager.Drug;
import Manager.Store;

/**
 * Servlet implementation class ShowStoreInfo
 */
@WebServlet("/ShowStoreInfo")
public class ShowStoreInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowStoreInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Store> stores= new ArrayList<>(); 
		response.setContentType("text/html;");  
		 PrintWriter out=response.getWriter();
		 
		 DBManager dbManager=new DBManager();
		 ArrayList<Drug> _drugList=dbManager.showDrug();
		 Store store = new Store();
	
		 out.print("<form action='ShowDrugInfoForUpdate' method='get'>");
		 out.print("<table style='border: 2px solid #6A247A;width: 500px;margin: 50px;'>");
		 out.print("<tr style='background: #FBB80F;'><td>drugId</td><td>name</td><td>price</td><td>count<td></tr>");
		 for(int i=0;i<_drugList.size();i++)
		 {	store = dbManager.showStoreInfo(_drugList.get(i));
			 int drugId= _drugList.get(i).getDrugID();
			 out.print("<tr>");
			 out.print("<td id='drugID'>" +  _drugList.get(i).getDrugID() +"</td>");
			 
			 out.print("<td>" +  _drugList.get(i).getName());
			 out.print("</td>");
			 
			 out.print("<td>" +  _drugList.get(i).getPrice());
			 out.print("</td>");
			 
			 out.print("<td>" + store.getdrugCount());
			 out.print("</td>");
			 
			 
			 
			 
			 
			 
			 out.print("</tr>");
		 }
		 out.print("</table>");
		 out.print("</form>");
		 
		 
	
	
	}

		// TODO Auto-generated method stub
		/*response.setContentType("text/html;");
		PrintWriter writer = response.getWriter();
		Drug drug = new Drug();
		Store drugStore = new Store();
		//drug.setDrugID(Integer.parseInt(request.getParameter("drugId")));
		//drug.setName(request.getParameter("drugname"));
		//drug.setPrice(Integer.parseInt(request.getParameter("price")));
		drugStore = new DBManager().showStoreInfo(drug);
		//System.out.println(drugStore.getNewDrug().getName());
		writer.print("<!DOCTYPE html>");
		writer.print("<html>");
		writer.print("<body>");
		writer.write("<form action='Update' method='get'>");
		writer.write("<table style='height: 150px;'>");
		writer.write("<tr>");
		writer.write("<td>Drug Id : </td>");
		writer.write("<td><INPUT TYPE=TEXT NAME=drugId id=drugId disabled VALUE=" + drugStore.getNewDrug().getDrugID() + "></td>");
		writer.write("</tr>");

		writer.write("<tr>");
		writer.write("<td>Name : </td>");
		writer.write("<td><INPUT TYPE=TEXT NAME=name id=name VALUE=" + drugStore.getNewDrug().getName() + "></td>");
		writer.write("</tr>");

		writer.write("<tr>");
		writer.write("<td>Price : </td>");
		writer.write("<td><INPUT TYPE=TEXT NAME=price VALUE=" + drugStore.getNewDrug().getPrice() + "></td>");
		writer.write("</tr>");
		
		writer.write("<tr>");
		writer.write("<td>Price : </td>");
		writer.write("<td><INPUT TYPE=TEXT NAME=price VALUE=" + drugStore.getdrugCount() + "></td>");
		writer.write("</tr>");

		writer.write("<tr>");
		writer.write("<td colspan='2' ><input style='width: 165px; height: 27px; margin-top: 10px; margin-left: 60px; background-color: #426783; color: white;'  type='submit' value='Update Drug Information'></td>");

		writer.write("</tr>");

		writer.write("</table>");
		writer.write("</form>");
		writer.print("here we go");
		writer.print("<html>");
		writer.print("<body>");*/
		 
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
