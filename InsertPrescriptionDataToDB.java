package PharmacyPack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.soap.AddressingFeature.Responses;

import Manager.DBManager;
import Manager.Prescription;

/**
 * Servlet implementation class InsertPrescriptionDataToDB
 */
@WebServlet("/InsertPrescriptionDataToDB")
public class InsertPrescriptionDataToDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Prescription pr;
	public static int _insuranceState;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		 _insuranceState = -1;
		DBManager dbMng = new DBManager();
		String PrscptDate = request.getParameter("PrescriptionDate");
		String insuranceState = request.getParameter("insuranceCondition");
		if(insuranceState.equals("NoInsurance")){
			_insuranceState = 0;
		}
		if(insuranceState.equals("HasInsurance"))
			_insuranceState = 1;
		
		pr = new Prescription();
		pr.setSellDate(PrscptDate);
		pr.setState(_insuranceState);
		boolean a = dbMng.InsertPrescriptionToDB(pr);
		System.out.println(a);
		System.out.println(_insuranceState);
		//String state = Integer.toString(_insuranceState);
		out.print("<input type= 'hidden' name='insuranceState' value='"+_insuranceState+"'>"); 
		 RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/InsertDrug");
		  dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
