package PharmacyPack;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Manager.DBManager;
import Manager.Drug;
import Manager.Prescription;
import Manager.Store;

/**
 * Servlet implementation class InsertDrugPrescriptionToDB
 */
@WebServlet("/InsertDrugPrescriptionToDB")
public class InsertDrugPrescriptionToDB extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertDrugPrescriptionToDB() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DBManager dbmng = new DBManager();
		String name = request.getParameter("DrugName");
		int number = Integer.parseInt(request.getParameter("number"));
		String otherDrug = request.getParameter("OtherDrug");
		Drug theDrug = dbmng.findDrug(name);
		Store store = new Store();
		store = dbmng.showStoreInfo(theDrug);
		Prescription pr = dbmng.findingLastAddedPrescription();
		boolean b = dbmng.InsertDrug_Prescription(pr, store, number);
		System.out.println(b);
		boolean a = dbmng.UpdateStore(store, number);
		System.out.println(a);
		if (a = true) {
			if (otherDrug.equals("Yes")) {
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/InsertDrug");
				dispatcher.forward(request, response);
			}

			else {
				PrintWriter out = response.getWriter();
				out.println("prescription data have been saved successfully");

				System.out.println(InsertPrescriptionDataToDB._insuranceState);
				if (InsertPrescriptionDataToDB._insuranceState == 1) {
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/InsertPatient");
					dispatcher.forward(request, response);
				} else {
				
					 
					 out.println("<a href='https:/CheckLogin'>BackToMenu</a>"); 
					 

				}
			}
		}
		if (a = false) {
			PrintWriter out = response.getWriter();
			out.print("<h>" + "invalid operation...not enough drug in drug store" + "</h>");

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
