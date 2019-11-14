<%@page import="org.joda.time.DateTime, org.joda.time.DateTimeFieldType, java.util.Map"%>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Création d'une commande</title>
        <link type="text/css" rel="stylesheet" href="inc/style.css" />
    </head>
    <body>
        <div>
            <form method="get" action="creationCommande">
                <fieldset>
                    <legend>Informations client</legend>
    
                    <label for="nomClient">Nom <span class="requis">*</span></label>
                    <input type="text" id="nomClient" name="nomClient" value="" size="20" maxlength="20" />
                    <br />
                    <span class="msgError">${ errorMsgs.nomClient }</span>
                    <br />
                    
                    <label for="prenomClient">Prénom </label>
                    <input type="text" id="prenomClient" name="prenomClient" value="" size="20" maxlength="20" />
                    <br />
    
                    <label for="adresseClient">Adresse de livraison <span class="requis">*</span></label>
                    <input type="text" id="adresseClient" name="adresseClient" value="" size="20" maxlength="20" />
                    <br />
                    <span class="msgError">${ errorMsgs.adresseClient }</span>
                    <br />
    
                    <label for="telephoneClient">Numéro de téléphone <span class="requis">*</span></label>
                    <input type="text" id="telephoneClient" name="telephoneClient" value="" size="20" maxlength="20" />
                    <br />
                    <span class="msgError">${ errorMsgs.telephoneClient }</span>
                    <br />
                    
                    <label for="emailClient">Adresse email</label>
                    <input type="email" id="emailClient" name="emailClient" value="" size="20" maxlength="60" />
                    <br />
                </fieldset>
                <fieldset>
                    <legend>Informations commande</legend>
                    
                    <%
                    	DateTime dateTime = new DateTime();
                   		int dayOfMonth = dateTime.get(DateTimeFieldType.dayOfMonth());
                   		int monthOfYear = dateTime.get(DateTimeFieldType.monthOfYear());
                   		int year = dateTime.get(DateTimeFieldType.year());
                   		int hour = dateTime.get(DateTimeFieldType.hourOfDay());
                   		int minute = dateTime.get(DateTimeFieldType.minuteOfHour());
                   		int second = dateTime.get(DateTimeFieldType.secondOfMinute());
                   		
                   		String currentDate = String.valueOf(dayOfMonth)+"-"+String.valueOf(monthOfYear)+"-"+String.valueOf(year)+" "+String.valueOf(hour)+":"+String.valueOf(minute)+":"+String.valueOf(second);
                    %>
                    <label for="dateCommande">Date <span class="requis">*</span></label>
                    <input type="text" id="dateCommande" name="dateCommande" value="<%= currentDate %>" size="20" maxlength="20" disabled />
                    <br />
                    
                    <label for="montantCommande">Montant <span class="requis">*</span></label>
                    <input type="text" id="montantCommande" name="montantCommande" value="" size="20" maxlength="20" />
                    <br />
                    <span class="msgError">${ errorMsgs.montantCommande }</span>
                    <br />
                    
                    <label for="modePaiementCommande">Mode de paiement <span class="requis">*</span></label>
                    <input type="text" id="modePaiementCommande" name="modePaiementCommande" value="" size="20" maxlength="20" />
                    <br />
                    <span class="msgError">${ errorMsgs.modePaiementCommande }</span>
                    <br />
                    
                    <label for="statutPaiementCommande">Statut du paiement</label>
                    <input type="text" id="statutPaiementCommande" name="statutPaiementCommande" value="" size="20" maxlength="20" />
                    <br />
                    
                    <label for="modeLivraisonCommande">Mode de livraison <span class="requis">*</span></label>
                    <input type="text" id="modeLivraisonCommande" name="modeLivraisonCommande" value="" size="20" maxlength="20" />
                    <br />
                    <span class="msgError">${ errorMsgs.modeLivraisonCommande }</span>
                    <br />
                    
                    <label for="statutLivraisonCommande">Statut de la livraison</label>
                    <input type="text" id="statutLivraisonCommande" name="statutLivraisonCommande" value="" size="20" maxlength="20" />
                    <br />
                </fieldset>
                <input type="submit" value="Valider"  />
                <input type="reset" value="Remettre à zéro" /> <br />
            </form>
            
            ${ errorMsgs.size() > 0 }
            <%
            	Map<String, String> errorMsgs = (Map<String, String>) request.getAttribute("errorMsgs");
            	if(errorMsgs != null && errorMsgs.size() > 0){
            		out.println("<a href='./creerCommande.jsp'>Refresh formulaire de création de commande</a>");
            	}
            %>
        </div>
    </body>
</html>