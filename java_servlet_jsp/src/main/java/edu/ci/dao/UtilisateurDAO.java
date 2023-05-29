package edu.ci.dao;

import java.sql.SQLException;
import java.util.List;

import edu.ci.model.Utilisateur;

public interface UtilisateurDAO {
	
	public int ajoutUtilisateur(Utilisateur utilisateur) throws SQLException;
	public void suppressionUtilisateur(Integer utilisateur) throws SQLException;
	public Utilisateur rechercheUtilisateur(Integer id) throws SQLException;
	public Utilisateur rechercheParMatricule(String matricule) throws SQLException;
	public Utilisateur rechercheParEmail(String email) throws SQLException;
	public List<Utilisateur> rechercheUtilisateurs() throws SQLException;
}
