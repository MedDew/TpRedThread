package com.meddew.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;

import com.meddew.beans.Client;
import com.meddew.beans.Commande;

public class CreationCommande extends HttpServlet {
	
	private boolean isNomClientNull = false;
	private boolean isAdresseClientNull = false;
	private boolean isTelephoneClientNull = false;
	private Map<String, String> errorMsgs = new HashMap<>();
	private boolean isMontantCommandeNull = false;
	private boolean isModePaiementCommandeNull = false;
	private boolean isModeLivraisonCommandeNull = false;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nomClient = req.getParameter("nomClient");
		String prenomClient = req.getParameter("prenomClient");
		String adresseClient = req.getParameter("adresseClient");
		String telephoneClient = req.getParameter("telephoneClient");
		String emailClient = req.getParameter("emailClient");
		System.out.println("Nom client de la commande : "+nomClient+" Prenom client de la commande : "+prenomClient);
		
		String dateCommande = req.getParameter("dateCommande");
		String montantCommande = req.getParameter("montantCommande");
		String modePaiementCommande = req.getParameter("modePaiementCommande");
		String statutPaiementCommande = req.getParameter("statutPaiementCommande");
		String modeLivraisonCommande = req.getParameter("modeLivraisonCommande");
		String statutLivraisonCommande = req.getParameter("statutLivraisonCommande");
		
		DateTime dateTime = new DateTime();
		int dayOfMonth = dateTime.get(DateTimeFieldType.dayOfMonth());
		int monthOfYear = dateTime.get(DateTimeFieldType.monthOfYear());
		int year = dateTime.get(DateTimeFieldType.year());
		int hour = dateTime.get(DateTimeFieldType.hourOfDay());
		int minute = dateTime.get(DateTimeFieldType.minuteOfHour());
		int second = dateTime.get(DateTimeFieldType.secondOfMinute());
		
		String currentDate = String.valueOf(dayOfMonth)+"-"+String.valueOf(monthOfYear)+"-"+String.valueOf(year)+" "+String.valueOf(hour)+":"+String.valueOf(minute)+":"+String.valueOf(second);
		System.out.println("Current Date : "+currentDate);
		
		req.setAttribute("currenDate", currentDate);
		
		if(nomClient == "") {
			this.isNomClientNull = true;
			errorMsgs.put("nomClient", "Veuillez renseigner un nom");
		}
		
		if(adresseClient == "") {
			isAdresseClientNull = true;
			errorMsgs.put("adresseClient", "Veuillez renseigner une adresse");
		}

		if(telephoneClient == "") {
			isTelephoneClientNull = true;
			errorMsgs.put("telephoneClient", "Veuillez renseigner un telephone");
		}
		
		if(montantCommande == "") {
			isMontantCommandeNull = true;
			errorMsgs.put("montantCommande", "Le montant de la commande est manquant");
		}
		if(modePaiementCommande == "") {
			isModePaiementCommandeNull = true;
			errorMsgs.put("modePaiementCommande", "Le mode de paiement de la commande est manquant");
		}
		if(modeLivraisonCommande == "") {
			isModeLivraisonCommandeNull = true;
			errorMsgs.put("modeLivraisonCommande", "Le mode de livraison de la commande est manquant");
		}
		
		if(!isNomClientNull && !isAdresseClientNull && !isTelephoneClientNull && !isMontantCommandeNull && !isModePaiementCommandeNull && !isModeLivraisonCommandeNull) {
			
			Client client = new Client();
			client.setNom(nomClient);
			client.setPrenom(prenomClient);
			client.setAdresse(adresseClient);
			client.setTelephone(telephoneClient);
			client.setMail(emailClient);
			Commande commande = new Commande();
			commande.setClient(client);
			commande.setDateTime(dateTime);
			commande.setMontant(Double.parseDouble(montantCommande));
			commande.setModePaiement(modePaiementCommande);
			commande.setStatusPaiement(statutPaiementCommande);
			commande.setModeLivraison(modeLivraisonCommande);
			commande.setStatusLivraison(statutLivraisonCommande);
			
			req.setAttribute("commande", commande);
			
			
			this.getServletContext().getRequestDispatcher("/afficherCommande.jsp").forward(req, resp);
		}else {
			req.setAttribute("errorMsgs", errorMsgs);
			this.getServletContext().getRequestDispatcher("/creerCommande.jsp").forward(req, resp);
		}
		
		isNomClientNull = false;
		isAdresseClientNull = false;
		isTelephoneClientNull = false;
		isMontantCommandeNull = false;
		isModePaiementCommandeNull = false;
		isModeLivraisonCommandeNull = false;
		
		errorMsgs.clear();
		req.setAttribute("errorMsgs", errorMsgs);
	}
	

}
