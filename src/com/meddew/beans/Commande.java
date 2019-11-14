package com.meddew.beans;

import org.joda.time.DateTime;

public class Commande {
	private Client client;
	private DateTime dateTime;
	private double montant;
	private String modePaiement;
	private String statusPaiement;
	private String modeLivraison;
	private String statusLivraison;
	
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public DateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(DateTime dateTime) {
		this.dateTime = dateTime;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public String getModePaiement() {
		return modePaiement;
	}
	public void setModePaiement(String modePaiement) {
		this.modePaiement = modePaiement;
	}
	public String getStatusPaiement() {
		return statusPaiement;
	}
	public void setStatusPaiement(String statusPaiement) {
		this.statusPaiement = statusPaiement;
	}
	public String getModeLivraison() {
		return modeLivraison;
	}
	public void setModeLivraison(String modeLivraison) {
		this.modeLivraison = modeLivraison;
	}
	public String getStatusLivraison() {
		return statusLivraison;
	}
	public void setStatusLivraison(String statusLivraison) {
		this.statusLivraison = statusLivraison;
	}
}
