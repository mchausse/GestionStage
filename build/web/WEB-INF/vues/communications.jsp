<%-- 
    Document   : communications
    Created on : Nov 27, 2018, 7:10:25 PM
    Author     : mchausse
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="servicesMessages" class="com.stageo.services.ServicesMessages" scope="page" />
<jsp:useBean id="utilisateurDAO" class="com.stageo.dao.UtilisateurDAO" scope="page"/>
<jsp:useBean id="employeurDAO" class="com.stageo.dao.EmployeurDAO" scope="page"/>
<jsp:useBean id="compagnieDAO" class="com.stageo.dao.CompagnieDAO" scope="page"/>


<!-- Verifier que le user est toujours connecter -->
<c:if test="${empty sessionScope.utilisateur}">
    <c:redirect url="do?action=afficherInscription"/>
</c:if>
    
<!DOCTYPE html>
<html>
    <head>
    <head>
        <title>Stages | Communications</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.2/css/all.css" integrity="sha384-/rXc/GQVaYpyDdyxK+ecHPVYJSN9bmVFBvjA/9eOB+pb3F2w2N6fc5qB9Ew5yIns" crossorigin="anonymous">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="./css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <!-- Barre de navigation -->
        <%@include  file="menu.jsp" %>
        <!-- Fin barre de navigation -->
        
        <div class='container-fluid'>
            <div id="contenuPage">
                
                <!-- Titre de la page -->
                <div class="row">
                    <div class="col-lg-1"></div><!-- Sert de margin -->
                    <div class="col-lg-4">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3>
                                    <span id='btnDescTitrePage' class='glyphicon glyphicon-triangle-bottom'></span>
                                    Comminications
                                </h3>
                                <p id='descTitrePage'>
                                    Ici, vous pouvez voir vos messages reçus et envoyés ainsi que les brouillons sauvegardés.
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Fin du titre de la page-->
                
                <!-- Debut barre de recherche -->
                <div class="row">
                    <div class="col-lg-1"></div><!-- Sert de margin -->
                    <div class="col-lg-5">
                        
                        <!-- Barre de recherche -->
                        <div class="input-group">
                            <div class="col-lg-4">
                                <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">
                                    Rechercher par
                                </button>
                                <ul class="dropdown-menu" id="liste">
                                    <li><a href="#">Destinataire</a></li>
                                    <li><a href="#">Expediteur</a></li>
                                    <li><a href="#">Date</a></li>
                                    <li><a href="#">Titre</a></li>
                                </ul>
                            </div>
                            <div class="col-lg-8">
                                <input id="msg" type="text" class="form-control" name="msg" placeholder="Envoyeur       ">
                            </div>
                        </div>
                        
                    </div>
                    <div class="col-lg-1"></div><!-- Sert de margin -->
                </div>
                <!-- Fin barre de recherche -->
                
                <!-- Debut listes des messages -->
                <div class="row">
                    <div class="col-lg-1"></div><!-- Sert de margin -->
                    <div class="col-lg-10">
                        
                        <!-- Tableau des messages -->
                        <table class="table table-striped table-hover table-responsive">
                        <thead>
                            <tr>
                                <label class="container">
                                    <td>Date </td>
                                    <td>Envoyeur/Receveur </td>
                                    <td>Titre </td>
                                    <td>Message </td>
                                </label>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- Passer au traver de la liste des messages-->
                            <c:set var="i" value="${0}" />
                            <c:forEach  var="message" items="${servicesMessages.messagesEnvoyes()}">
                                <c:set var="expediteur" value="${utilisateurDAO.findById(message.getIdExpediteur())}"/>
                                <c:set var="destinataire" value="${utilisateurDAO.findById(message.getIdDestinataire())}"/>
                                <tr>
                                    <td>${message.getDate()} ${message.getHeure()}</td>
                                    <td>
                                        ${expediteur.getNom()} ${expediteur.getPrenom()} -> 
                                        <c:if test="${destinataire.getTypeUtilisateur() eq 'Employeur'}">
                                            <c:set var="employeur" value="${employeurDAO.findById(destinataire.getIdUtilisateur())}"/>

                                            <!-- Afficher le nom de la compagnie -->
                                            <kbd>${compagnieDAO.findById(employeur.getIdCompagnie()).getNom()}</kbd> 
                                        </c:if>
                                        ${destinataire.getNom()} ${destinataire.getPrenom()}
                                    </td>
                                    
                                    <c:set var='titre' value="${message.getTitre()}"/>
                                    <td id="case${i}" class="caseTitreTableauCommunication" onclick="afficherTitreComplet('${i}','${titre}')">
                                        <c:if test="${titre.length() >= 25}">
                                            ${titre.substring(0,22)}...
                                        </c:if>
                                        <c:if test="${titre.length() < 25}">
                                            ${titre}
                                        </c:if>
                                    </td>
                                    <c:set var="i" value="${i+=1}" />
                                    
                                    <c:set var='texte' value="${message.getMessage()}"/>
                                    <td id="case${i}" class="caseTexteTableauCommunication" onclick="afficherTexteComplet('${i}','${texte}')">
                                        <c:if test="${texte.length() >= 35}">
                                            ${texte.substring(0,32)}...
                                        </c:if>
                                        <c:if test="${texte.length() < 35}">
                                            ${texte}
                                        </c:if>
                                    </td>
                                    <c:set var="i" value="${i+=1}" />
                                    
                                </tr>
                            </c:forEach>
                        </tbody>
                        </table>
                        <!-- Fin du tableau des messages -->
                        
                    </div>
                    <div class="col-lg-1"></div><!-- Sert de margin -->
                </div>
                <!-- Fin listes des messages -->
            </div>
        </div>
        
        <!-- Footer -->
        <%@include  file="footer.jsp" %>
        <!-- Fin footer -->
        <script>
            $(document).ready(function(){
                // Chacher le titre
                $("#descTitrePage").hide();
                $(".td").animate(300);
                
                // Pour le bouton de description du titre
                $("#btnDescTitrePage").click(function(){
                    if($("#btnDescTitrePage").is(".glyphicon-triangle-top")){
                        $("#descTitrePage").hide(300);
                        // Changer la classe pour changer le signe du bouton
                        $("#btnDescTitrePage").removeClass("glyphicon-triangle-top");
                        $("#btnDescTitrePage").addClass('glyphicon-triangle-bottom');
                    }else{
                        // Faire apparaitre la desc
                        $("#descTitrePage").show(500);
                        // Changer la classe pour changer le signe du bouton
                        $("#btnDescTitrePage").removeClass("glyphicon-triangle-bottom");
                        $("#btnDescTitrePage").addClass('glyphicon-triangle-top');
                    }
                });
            });
            
            function afficherTitreComplet(id,texte){
                if(document.getElementById("case"+id).innerHTML !== texte)
                    document.getElementById("case"+id).innerHTML=texte;
                else document.getElementById("case"+id).innerHTML=texte.substring(0,22)+"...";
            }
            function afficherTexteComplet(id,texte){
                if(document.getElementById("case"+id).innerHTML !== texte)
                    document.getElementById("case"+id).innerHTML=texte;
                else document.getElementById("case"+id).innerHTML=texte.substring(0,32)+"...";
            }
        </script>
    </body>
</html>
