package edu.ci.util;

import java.util.HashMap;
import java.util.Map;

import edu.ci.model.Login;
import jakarta.servlet.http.HttpServletRequest;

public class ConnexionForm {
	
	private Map<String, String> erreurs = new HashMap<String, String>();
	
	public Login getLogin(HttpServletRequest request) {
		Login login = new Login();
		String username = request.getParameter(Constant.CHAMP_LOGIN);
		String password = request.getParameter(Constant.CHAMP_PASSWORD);
		
		try {
			validateUsername(username);
		} catch (Exception e) {
			erreurs.put(Constant.CHAMP_LOGIN, e.getMessage());
		}
		login.setUsername(username);
		
		try {
			validatePassword(password);
		} catch (Exception e) {
			erreurs.put(Constant.CHAMP_PASSWORD, e.getMessage());
		}
		login.setPassword(password);
		
		return login;
		
	}
	
	
	private void validateUsername(String username) throws Exception {
		if (username!=null && username.trim()!="") {
			if (!username.contains("@") || !username.contains(".")) {
				throw new Exception("Veuillez entrer un email valide.");
			}
		}else {
			throw new Exception("Veuillez renseigner votre email");
		}
	}
	

	private void validatePassword(String password) throws Exception {
		if (password!=null && password.trim()!="") {
			if (password.length()<8) {
				throw new Exception("Le mot de passe est composé d'au moins 8 caracteres");
			}
		}else {
			throw new Exception("Veuillez renseigner votre mot de passe");
		}
	}


	public Map<String, String> getErreus() {
		return erreurs;
	}


	public void setErreus(Map<String, String> erreus) {
		this.erreurs = erreus;
	}

}
