<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Fiche Création Commande Client : ${ commande.client.nom } ${ commande.client.prenom }</title>
	</head>
	<body>
		<h1>Commande  créée</h1>
		<ul>
			<li>Date de commande : ${ commande.dateTime }</li> 
			<li>Montant commande : ${ commande.montant }</li> 
			<li>Mode paiement commande : ${ commande.modePaiement }</li> 
			<li>Status paiement commande : ${ commande.statusPaiement }</li> 
			<li>Mode livraison commande : ${ commande.modeLivraison }</li> 
			<li>Status livraison commande : ${ commande.statusLivraison }</li> 
		</ul>
		
		<h2>Client</h2>
		<ul>
			<li>Nom : ${ commande.client.nom }</li>
			<li>Prenom : ${ commande.client.prenom }</li>
			<li>Adresse : ${ commande.client.adresse }</li>
			<li>Téléphone : ${ commande.client.telephone }</li>
			<li>Mail : ${ commande.client.mail }</li>
		</ul>
	</body>
</html>