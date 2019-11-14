<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Fiche Création Client : ${ client.nom } ${ client.prenom }</title>
	</head>
	<body>
		<h1>Client créé</h1>
		<ul>
			<li>Nom : ${ client.nom }</li>
			<li>Prenom : ${ client.prenom }</li>
			<li>Adresse : ${ client.adresse }</li>
			<li>Téléphone : ${ client.telephone }</li>
			<li>Mail : ${ client.mail }</li>
		</ul>
		
		<p>
			<a href="./creerClient.jsp">Retour au formulaire</a>
		</p>
	</body>
</html>