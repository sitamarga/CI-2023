package edu.ci.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import edu.ci.dao.UtilisateurDAO;
import edu.ci.dao.UtilisateurDAOImpl;
import edu.ci.model.Utilisateur;
import edu.ci.util.Constant;
import edu.ci.util.InscriptionForm;

/**
 * Servlet implementation class SignInServlet
 */

@WebServlet("/inscription")
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InscriptionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext()
		.getRequestDispatcher(Constant.VIEW_INSCRIPTION)
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		// TODO Auto-generated method stub
		InscriptionForm form = new InscriptionForm();
		Utilisateur utilisateur = form.getUtilisateur(request);
		Map<String, String> erreus = form.getErreus();
		
		if(erreus.size()>0) {
			request.setAttribute(Constant.MESSAGE, "Veuillez renseigner le formulaire correctement");
			request.setAttribute(Constant.ERREURS, erreus);
			request.setAttribute(Constant.UTILISATEUR, utilisateur);
			this.getServletContext()
			.getRequestDispatcher(Constant.VIEW_INSCRIPTION)
			.forward(request, response);
		}else {
			UtilisateurDAO dao = new UtilisateurDAOImpl();
			try {
				dao.ajoutUtilisateur(utilisateur);
				response.sendRedirect(request.getContextPath() + "/connexion");
			} catch (SQLException e) {
				e.printStackTrace();
				request.setAttribute(Constant.MESSAGE, e.getMessage());
				request.setAttribute(Constant.ERREURS, erreus);
				request.setAttribute(Constant.UTILISATEUR, utilisateur);
				this.getServletContext()
				.getRequestDispatcher(Constant.VIEW_INSCRIPTION)
				.forward(request, response);
			}
			
		}
		
		
	}

}
