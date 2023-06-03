package edu.ci.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.ci.model.Utilisateur;

public class UtilisateurCollectionDaoImpl implements UtilisateurDAO{
	List<Utilisateur> utilisateurs = new ArrayList<>();
	
	@Override
	public int ajoutUtilisateur(Utilisateur utilisateur) throws SQLException {
		// TODO Auto-generated method stub
		utilisateurs.add(utilisateur);
		return 0;
	}

	@Override
	public void suppressionUtilisateur(Integer utilisateur) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Utilisateur rechercheUtilisateur(Integer id) throws SQLException {
		// TODO Auto-generated method stub

		return utilisateurs
				.stream()
				.filter(utilisateur -> utilisateur.getId().equals(id))
				.findFirst()
				.orElse(null);
	}

	@Override
	public Utilisateur rechercheParMatricule(String matricule) throws SQLException {
		// TODO Auto-generated method stub
		return utilisateurs
				.stream()
				.filter(utilisateur -> utilisateur.getMatricule().equals(matricule))
				.findFirst()
				.orElse(null);
	}

	@Override
	public Utilisateur rechercheParEmail(String email) throws SQLException {
		// TODO Auto-generated method stub
		return utilisateurs
				.stream()
				.filter(utilisateur -> utilisateur.getEmail().equals(email))
				.findFirst()
				.orElse(null);
	}

	@Override
	public List<Utilisateur> rechercheUtilisateurs() throws SQLException {
		// TODO Auto-generated method stub
		return utilisateurs;
	}

}
