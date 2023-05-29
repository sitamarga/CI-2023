package edu.ci.model;

import java.time.LocalDate;

public class Utilisateur {
	
	private Integer id;
	private String matricule;
	private String nom;
	private String email;
	private String tel;
	private LocalDate dateNaissance;
	private String motDePasse;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMatricule() {
		return matricule;
	}
	
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTel() {
		return tel;
	}
	
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public LocalDate getDateNaissance() {
		return dateNaissance;
	}
	
	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	
	public String getMotDePasse() {
		return motDePasse;
	}
	
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
}
