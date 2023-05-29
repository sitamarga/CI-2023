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
import edu.ci.model.Login;
import edu.ci.model.Utilisateur;
import edu.ci.util.ConnexionForm;
import edu.ci.util.Constant;
import edu.ci.util.InscriptionForm;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = {"/connexion", "/"})
public class ConnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnexionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		this.getServletContext()
		.getRequestDispatcher(Constant.VIEW_CONNEXION)
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ConnexionForm form = new ConnexionForm();
		Login login = form.getLogin(request);
		Map<String, String> erreus = form.getErreus();
		
		if(erreus.size()>0) {
			request.setAttribute(Constant.MESSAGE, "Veuillez renseigner le formulaire correctement");
			request.setAttribute(Constant.ERREURS, erreus);
			request.setAttribute(Constant.CHAMP_LOGIN, login.getUsername());
			this.getServletContext()
			.getRequestDispatcher(Constant.VIEW_CONNEXION)
			.forward(request, response);
		}else {
			UtilisateurDAO dao = new UtilisateurDAOImpl();
			try {
				Utilisateur utilisateur = dao.rechercheParEmail(login.getUsername());
				if (utilisateur!=null && utilisateur.getMotDePasse().equals(login.getPassword())) {
					response.sendRedirect(request.getContextPath() + "/accueil");
				}else {
					request.setAttribute(Constant.CHAMP_LOGIN, login.getUsername());
					request.setAttribute(Constant.MESSAGE, "Email ou mot de passe incorrect.");
					this.getServletContext()
					.getRequestDispatcher(Constant.VIEW_CONNEXION)
					.forward(request, response);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				request.setAttribute(Constant.CHAMP_LOGIN, login.getUsername());
				request.setAttribute(Constant.MESSAGE, e.getMessage());
				this.getServletContext()
				.getRequestDispatcher(Constant.VIEW_CONNEXION)
				.forward(request, response);
			}
		}
	}

}
