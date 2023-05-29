package edu.ci.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.ci.model.Utilisateur;
import edu.ci.util.Constant;
import edu.ci.util.DateUtils;
import edu.ci.util.DbConnexion;

public class UtilisateurDAOImpl implements UtilisateurDAO{
	
	private Connection connexion;
	
	public UtilisateurDAOImpl() {
		try {
			connexion = DbConnexion.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public int ajoutUtilisateur(Utilisateur utilisateur) throws SQLException {
		String query= "INSERT INTO utilisateur VALUES (null, ?, ?, ?, ?, ?, ?)";
		PreparedStatement statement = connexion.prepareStatement(query);
		statement.setString(1, utilisateur.getMatricule());
		statement.setString(2, utilisateur.getNom());
		statement.setString(3, utilisateur.getEmail());
		statement.setString(4, utilisateur.getTel());
		statement.setDate(5, DateUtils.asDate(utilisateur.getDateNaissance()));
		statement.setString(6, utilisateur.getMotDePasse());
		return statement.executeUpdate();
	}

	@Override
	public void suppressionUtilisateur(Integer id) throws SQLException {
		String query= "DELETE FROM utilisateur WHERE id=?";
		PreparedStatement statement = connexion.prepareStatement(query);
		statement.setInt(1, id);
		statement.executeUpdate();
	}

	@Override
	public Utilisateur rechercheUtilisateur(Integer id) throws SQLException {
		String query= "SELECT * FROM utilisateur WHERE id=?";
		PreparedStatement statement = connexion.prepareStatement(query);
		statement.setInt(1, id);
		ResultSet resultSet = statement.executeQuery();
        boolean check = false;
        Utilisateur utilisateur = new Utilisateur();
        while (resultSet.next() && !check) {
            check = true;
            utilisateur.setId(resultSet.getInt(Constant.COLONNE_ID));
            utilisateur.setMatricule(resultSet.getString(Constant.COLONNE_MATRICULE));
            utilisateur.setNom(resultSet.getString(Constant.COLONNE_NOM));
            utilisateur.setEmail(resultSet.getString(Constant.COLONNE_EMAIL));
            utilisateur.setTel(resultSet.getString(Constant.COLONNE_TEL));
            utilisateur.setMotDePasse(resultSet.getString(Constant.COLONNE_PASSWORD));
            utilisateur.setDateNaissance(DateUtils.asLocalDate(resultSet.getDate(Constant.COLONNE_DATE_NAISSANCE)));
        }
		return utilisateur;
	}

	@Override
	public Utilisateur rechercheParMatricule(String matricule) throws SQLException {
		String query= "SELECT * FROM utilisateur WHERE matricule=?";
		PreparedStatement statement = connexion.prepareStatement(query);
		statement.setString(1, matricule);
		ResultSet resultSet = statement.executeQuery();
        boolean check = false;
        Utilisateur utilisateur = new Utilisateur();
        while (resultSet.next() && !check) {
            check = true;
            utilisateur.setId(resultSet.getInt(Constant.COLONNE_ID));
            utilisateur.setMatricule(resultSet.getString(Constant.COLONNE_MATRICULE));
            utilisateur.setNom(resultSet.getString(Constant.COLONNE_NOM));
            utilisateur.setEmail(resultSet.getString(Constant.COLONNE_EMAIL));
            utilisateur.setTel(resultSet.getString(Constant.COLONNE_TEL));
            utilisateur.setMotDePasse(resultSet.getString(Constant.COLONNE_PASSWORD));
            utilisateur.setDateNaissance(DateUtils.asLocalDate(resultSet.getDate(Constant.COLONNE_DATE_NAISSANCE)));
        }
		return utilisateur;
	}

	@Override
	public Utilisateur rechercheParEmail(String email) throws SQLException {
		String query= "SELECT * FROM utilisateur WHERE email=?";
		PreparedStatement statement = connexion.prepareStatement(query);
		statement.setString(1, email);
		ResultSet resultSet = statement.executeQuery();
        boolean check = false;
        Utilisateur utilisateur = new Utilisateur();
        while (resultSet.next() && !check) {
            check = true;
            utilisateur.setId(resultSet.getInt(Constant.COLONNE_ID));
            utilisateur.setMatricule(resultSet.getString(Constant.COLONNE_MATRICULE));
            utilisateur.setNom(resultSet.getString(Constant.COLONNE_NOM));
            utilisateur.setEmail(resultSet.getString(Constant.COLONNE_EMAIL));
            utilisateur.setTel(resultSet.getString(Constant.COLONNE_TEL));
            utilisateur.setMotDePasse(resultSet.getString(Constant.COLONNE_PASSWORD));
            utilisateur.setDateNaissance(DateUtils.asLocalDate(resultSet.getDate(Constant.COLONNE_DATE_NAISSANCE)));
        }
		return utilisateur;
	}

	@Override
	public List<Utilisateur> rechercheUtilisateurs() throws SQLException {
		String query= "SELECT * FROM utilisateur";
		PreparedStatement statement = connexion.prepareStatement(query);
		statement.setString(0, query);
		ResultSet resultSet = statement.executeQuery();
        List<Utilisateur> utilisateurs = new ArrayList<>();
        while (resultSet.next()) {
        	Utilisateur utilisateur = new Utilisateur();
            utilisateur.setId(resultSet.getInt(Constant.COLONNE_ID));
            utilisateur.setMatricule(resultSet.getString(Constant.COLONNE_MATRICULE));
            utilisateur.setNom(resultSet.getString(Constant.COLONNE_NOM));
            utilisateur.setEmail(resultSet.getString(Constant.COLONNE_EMAIL));
            utilisateur.setTel(resultSet.getString(Constant.COLONNE_TEL));
            utilisateur.setMotDePasse(resultSet.getString(Constant.COLONNE_PASSWORD));
            utilisateur.setDateNaissance(DateUtils.asLocalDate(resultSet.getDate(Constant.COLONNE_DATE_NAISSANCE)));
            utilisateurs.add(utilisateur);
        }
		return utilisateurs;
	}

}
