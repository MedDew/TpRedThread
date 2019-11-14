package com.meddew.servlet;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meddew.beans.Client;

public class CreationClient extends HttpServlet {
	
	private boolean isNomClientNull = false;
	private boolean isAdresseClientNull = false;
	private boolean isTelephoneClientNull = false;
	private Map<String, String> errorMsgs = new HashMap<>();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String nomClient = req.getParameter("nomClient");
		String prenomClient = req.getParameter("prenomClient");
		String adresseClient = req.getParameter("adresseClient");
		String telephoneClient = req.getParameter("telephoneClient");
		String emailClient = req.getParameter("emailClient");
		System.out.println("Nom client : "+nomClient+" Prenom client : "+prenomClient);
		
		boolean test = nomClient == "";
		System.out.println("Nom client : "+nomClient.length());
		System.out.println("Nom client : "+test);
		
		
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
		
		if(!isNomClientNull && !isAdresseClientNull && !isTelephoneClientNull) {
			
			Client client = new Client();
			client.setNom(nomClient);
			client.setPrenom(prenomClient);
			client.setAdresse(adresseClient);
			client.setTelephone(telephoneClient);
			client.setMail(emailClient);
			
			req.setAttribute("client", client);
			
			this.getServletContext().getRequestDispatcher("/afficherClient.jsp").forward(req, resp);
		} else {
			

			req.setAttribute("errorMsgs", errorMsgs);
			
			this.getServletContext().getRequestDispatcher("/creerClient.jsp").forward(req, resp);
		}
		
		//Re initialize error message and boolean
		isNomClientNull = false;
		isAdresseClientNull = false;
		isTelephoneClientNull = false;
		
		errorMsgs.clear();
		req.setAttribute("errorMsgs", errorMsgs);
		
	}
}
