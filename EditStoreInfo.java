package PharmacyPack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Manager.DBManager;
import Manager.Drug;
import Manager.Store;

/**
 * Servlet implementation class EditStoreInfo
 */
@WebServlet("/EditStoreInfo")
public class EditStoreInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditStoreInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		DBManager db = new DBManager();
		Drug drug = new Drug();
		Store store = new Store();
		int drugId = Integer.parseInt(request.getParameter("drugId"));
		
		drug = db.showInfoForUpdate(drugId);
		store = db.showStoreInfo(drug);
		// out.print("<form method='get'>");
		//out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.print("<body>");
		 out.print("<table style='border: 2px solid #6A247A;width: 500px;margin: 50px;'>");
		 out.print("<tr style='background: #FBB80F;'><td>drugId</td><td>name</td><td>price</td></tr>");
		 out.print("<tr>");
		 out.print("<td>" +  drug.getDrugID());
		 out.print("</td>");
		 
		 out.print("<td>" +  drug.getName());
		 out.print("</td>");
		 
		 out.print("<td>" +  drug.getPrice());
		 out.print("</td>");
		 out.print("<td>" +  store.getdrugCount());
		 out.print("</td>");
		 
		 out.print("</tr>");
		 out.print("</body>");
		 out.print("</html>");
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
