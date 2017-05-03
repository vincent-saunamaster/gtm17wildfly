package servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Produit;
import session.ProduitLocal;

/**
 * Servlet implementation class GestionProduit
 */
@WebServlet("/GestionProduit")
public class GestionProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private ProduitLocal ejb;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GestionProduit() {
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

		if (request.getParameter("ajouter") != null && !request.getParameter("nom").equals("")) {
			String nom = request.getParameter("nom");
			int quantite = Integer.parseInt(request.getParameter("quantite"));
			double prix = Double.parseDouble(request.getParameter("prix"));
			Produit p = new Produit();
			p.setNom(nom);
			p.setQuantite(quantite);
			p.setPrix(prix);
			ejb.ajouterProduit(p);
		}

		if (request.getParameter("modifier") != null && !request.getParameter("id").equals("")) {
			String nom = request.getParameter("nom");
			int quantite = Integer.parseInt(request.getParameter("quantite"));
			double prix = Double.parseDouble(request.getParameter("prix"));
			Produit p = ejb.getProduit(Integer.parseInt(request.getParameter("id")));
			p.setNom(nom);
			p.setQuantite(quantite);
			p.setPrix(prix);
			ejb.modifierProduit(p);
		}

		if (request.getParameter("supprimer") != null && !request.getParameter("id").equals("")) {
			ejb.supprimerProduit(ejb.getProduit(Integer.parseInt(request.getParameter("id"))));
		}

		request.setAttribute("listProduit", ejb.findAll());

		request.getRequestDispatcher("index.jsp").forward(request, response);
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
