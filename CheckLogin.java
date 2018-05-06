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

/**
 * Servlet implementation class checkLogin
 */
@WebServlet("/CheckLogin")
public class CheckLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DBManager _dbManager = new DBManager();

	private PrintWriter out;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//out.print("u r in checklogin");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String username = request.getParameter("username");
		String password = request.getParameter("pass");

		out.println(username);
		HttpSession session = request.getSession();
		session.setAttribute("uname", username);

		int roleState = _dbManager.checkLogin(username, password);

		if (roleState == 1)
			request.getRequestDispatcher("FirstAdminPage").forward(request, response);
		else if (roleState == 2)
			request.getRequestDispatcher("FirstSellerPage").forward(request, response);
		else
			out.println("Either you enter Invalid UserName or Password! Please Try Again");

	}

}
