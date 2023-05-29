<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!---Coding By CoderGirl | www.codinglabweb.com--->
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Inscription | Java Sevlet&JSP</title>
  <!---Custom CSS File--->
  <link rel="stylesheet" href="/java_servlet_jsp/assets/css/style.css">
</head>
<body>
  <div class="container">
    <input type="checkbox" id="check">
    <div class="form">
      <header>Inscription</header>
      <label >${ message }</label>
      <form action="/java_servlet_jsp/inscription" method="post">
        <input type="text" placeholder="Matricule*" name="matricule" value="${ utilisateur.matricule }">
        <label >${ erreurs.matricule }</label>
        <input type="text" placeholder="Prénom(s) & Nom*" name="nom" value="${ utilisateur.nom }">
        <label >${ erreurs.nom }</label>
        <input type="date" placeholder="Date de naissance*" name="date" value="${ utilisateur.dateNaissance }">
        <label >${ erreurs.dateNaissance }</label>
        <input type="text" placeholder="Email*" name="email" value="${ utilisateur.email }">
        <label >${ erreurs.email }</label>
        <input type="text" placeholder="Télephone*" name="tel" value="${ utilisateur.tel }">
        <label >${ erreurs.tel }</label>
        <input type="password" placeholder="Mot de passe*" name="password">
        <label >${ erreurs.password }</label>
        <input type="submit" class="button" value="Inscription">
      </form>
      <div class="signup">
        <span class="signup">Vous avez déjà un compte?
         <label for="check"><a href="/java_servlet_jsp/connexion">Se connecter</a></label>
        </span>
      </div>
    </div>
  </div>
</body>
</html>