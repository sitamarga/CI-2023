<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Connexion | Java Sevlet&JSP</title>
  <!---Custom CSS File--->
  <link rel="stylesheet" href="/java_servlet_jsp/assets/css/style.css">
</head>
<body>
  <div class="container">
    <input type="checkbox" id="check">
    <div class="login form">
      <header>Connexion</header>
      <label >${ message }</label>
      <form action="/java_servlet_jsp/connexion", method="post">
        <input type="text" placeholder="Entrez votre email" name="login" value="${ login }">
        <input type="password" placeholder="Entrez votre mot de passe" name="password">
        <a href="#">Forgot password?</a>
        <input type="submit" class="button" value="Connexion">
      </form>
      <div class="signup">
        <span class="signup">Pas de compte?
         <label for="check"><a href="/java_servlet_jsp/inscription">S'inscrire</a></label>
        </span>
      </div>
    </div>
  </div>
</body>
</html>
