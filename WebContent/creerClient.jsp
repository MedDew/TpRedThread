<%@ page pageEncoding="UTF-8" import="java.util.Map" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Création d'un client</title>
        <link type="text/css" rel="stylesheet" href="inc/style.css" />
    </head>
    <body>
        <div>
            <form method="get" action="creationClient">
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
                <input type="submit" value="Valider"  />
                <input type="reset" value="Remettre à zéro" /> <br />
            </form>
            
	            ${ errorMsgs.size() > 0 }
            <%
            	Map<String, String> errorMsgs = (Map<String, String>) request.getAttribute("errorMsgs");
            	if(errorMsgs != null && errorMsgs.size() > 0){
            		out.println("<a href='./creerClient.jsp'>Refresh formulaire de création client</a>");
            	}
            %>
        </div>
    </body>
</html>