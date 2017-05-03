package servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejb.CalculatriceLocal;

/**
 * Servlet implementation class CalculServlet
 */
@WebServlet("/CalculServlet")
public class CalculServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB //injection EJB
	private CalculatriceLocal calcRemote;
	//private CalculatriceRemote calcRemote;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CalculServlet() {
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
		request.setCharacterEncoding("utf-8");
		
		int x = Integer.parseInt(request.getParameter("x"));
		int y = Integer.parseInt(request.getParameter("y"));
		//String action = request.getParameter("action");
		
		int resultat = 0;
		int resultat2 = 0;
		int resultat3 = 0;
		int resultat4 = 0;

			resultat = calcRemote.addition(x, y);
			request.setAttribute("resultat", resultat);
			resultat2 = calcRemote.soustraction(x, y);
			request.setAttribute("resultat2", resultat2);
			resultat3 = calcRemote.division(x, y);
			request.setAttribute("resultat3", resultat3);
			resultat4 = calcRemote.multiplication(x, y);
			request.setAttribute("resultat4", resultat4);
			
			request.getRequestDispatcher("index.jsp").forward(request, response);

		//response.getWriter().append("Served at: ").append(request.getContextPath());
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
