package edu.ci.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import edu.ci.model.Utilisateur;
import jakarta.servlet.http.HttpServletRequest;

public class InscriptionForm {
	
	private Map<String, String> erreurs = new HashMap<String, String>();
	
	
	public Utilisateur getUtilisateur(HttpServletRequest request) {
	
		Utilisateur utilisateur = new Utilisateur();
		String matricule = request.getParameter(Constant.CHAMP_MATRICULE);
		String nom = request.getParameter(Constant.CHAMP_NOM);
		String date = request.getParameter(Constant.CHAMP_DATE);
		String email = request.getParameter(Constant.CHAMP_EMAIL);
		String password = request.getParameter(Constant.CHAMP_PASSWORD);
		String tel = request.getParameter(Constant.CHAMP_TEL);

		try {
			validateMatricule(matricule);
		} catch (Exception e) {
			erreurs.put(Constant.CHAMP_MATRICULE, e.getMessage());
		}
		utilisateur.setMatricule(matricule);

		try {
			validateNom(nom);
		} catch (Exception e) {
			erreurs.put(Constant.CHAMP_NOM, e.getMessage());
		}
		utilisateur.setNom(nom);
		
		try {
			validateDate(date);
		} catch (Exception e) {
			erreurs.put(Constant.CHAMP_DATE, e.getMessage());
		}
		utilisateur.setDateNaissance(stringToLocalDate(date));
		
		try {
			validateEmail(email);
		} catch (Exception e) {
			erreurs.put(Constant.CHAMP_EMAIL, e.getMessage());
		}
		utilisateur.setEmail(email);
		
		try {
			validateTel(tel);
		} catch (Exception e) {
			erreurs.put(Constant.CHAMP_TEL, e.getMessage());
		}
		utilisateur.setTel(tel);
		
		try {
			validatePassword(password);
		} catch (Exception e) {
			erreurs.put(Constant.CHAMP_PASSWORD, e.getMessage());
		}
		utilisateur.setMotDePasse(password);
		return utilisateur;
	}
	
	
	private void validateMatricule(String matricule) throws Exception {
		if (matricule!=null && matricule.trim()!="") {
			if (matricule.length()!=12) {
				throw new Exception("La taille doit etre egale 12 caracteres.");
			}
		}else {
			throw new Exception("Veuillez saisir le matricule.");
		}
	}
	

	private void validateNom(String nom) throws Exception {
		if (nom!=null && nom.trim()!="") {
			if (nom.length()<2) {
				throw new Exception("Le nom doit avoir au moins 2 caracteres.");
			}
		}else {
			throw new Exception("Veuillez saisir le nom.");
		}
	}
    

	private void validateDate(String value) throws Exception {
		if (value!=null && value.trim()!="") {
			LocalDate date = stringToLocalDate(value);
			if (date.plusYears(18).isAfter(LocalDate.now())) {
				throw new Exception("Vous devez avoir au moins 18 ans.");
			}
		}else {
			throw new Exception("Veuillez renseigner la date de naissance.");
		}
	}
	
	private void validateEmail(String email) throws Exception {
		if (email!=null && email.trim()!="") {
			if (!email.contains("@") || !email.contains(".")) {
				throw new Exception("Veuillez renseigner un email valide.");
			}
		}else {
			throw new Exception("Veuillez renseigner l'email.");
		}
	}
	
	private void validateTel(String tel) throws Exception {
		if (tel!=null && tel.trim()!="") {
			if (tel.length()!=9) {
				throw new Exception("Veuillez saisir un numero de telephone valide.");
			}
		}else {
			throw new Exception("Veuillez renseigner le numéro de telephone.");
		}
	}
	
	private void validatePassword(String password) throws Exception {
		if (password!=null && password.trim()!="") {
			if (password.length()<8) {
				throw new Exception("Le mot de passse doit avoir au moins 8 caracteres.");
			}
			/*if (password.length()>=8 && (!password.contains("@") || !password.contains("#") || password.contains("&"))) {
				throw new Exception("Le mot de passe doit contenir au moins un des caracteres: @,#,&");
			}*/
		}else {
			throw new Exception("Veuillez renseigner le mot de passe.");
		}
	}
	
	private LocalDate stringToLocalDate(String value) {
		if (value!=null && value!="") {
			String format = value.contains("-")?"yyyy-MM-dd":"yyyy/MM/dd";
			return LocalDate.parse(value, DateTimeFormatter.ofPattern(format));
		}
		return null;
	}


	public Map<String, String> getErreus() {
		return erreurs;
	}
}
