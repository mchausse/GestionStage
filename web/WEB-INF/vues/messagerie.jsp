<%-- 
    Document   : Communiquer
    Created on : Nov 9, 2018, 3:07:46 PM
    Author     : mchausse


--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.stageo.services.ServicesMessagerie"%>
<%@page import="com.stageo.dao.UtilisateurDAO"%>
<%@page import="com.stageo.dao.EmployeurDAO"%>
<%@page import="com.stageo.dao.CompagnieDAO"%>
<%@page import="com.stageo.dao.MessageDAO"%>
<%@page import="com.stageo.singleton.Connexion"%>
<%@page import="com.stageo.beans.Employeur"%>
<%@page import="com.stageo.beans.Message"%>

<!-- Initialiser les dao utiliser dans la page -->
<jsp:useBean id="servicesMessagerie" class="com.stageo.services.ServicesMessagerie" scope="page" />
<jsp:useBean id="utilisateurDAO" class="com.stageo.dao.UtilisateurDAO" scope="page"/>
<jsp:useBean id="employeurDAO" class="com.stageo.dao.EmployeurDAO" scope="page"/>
<jsp:useBean id="compagnieDAO" class="com.stageo.dao.CompagnieDAO" scope="page"/>
<jsp:useBean id="messageDAO" class="com.stageo.dao.MessageDAO" scope="page"/>

<!DOCTYPE html>
<html>
    <head>
        <title>Stages | Messagerie</title>
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
                                    Messagerie de ${sessionScope.utilisateur.getPrenom()}
                                </h3>
                                <p id='descTitrePage'>
                                    Ici, vous pouvez voir vos messages reçus et envoyés ainsi que les brouillons sauvegardés.
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Fin du titre de la page-->
                
                <div class="col-lg-1"></div><!-- Sert de margin -->
                
                <!-- Debut de la section du menu des messages -->
                <div class="col-lg-2">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Menu
                        </div>
                        
                        <!-- Liste des options du menu -->
                        <div class="panel-body">
                            <div class="col-lg-12">
                                <!-- Bouton pour cree un nouveau message -->
                                <a href="do?action=creerNouveauMessage" class="btn ${(not empty requestScope.enCreation?"btn-danger":"btn-default")} btn-lg btnMenu">
                                    <span class="glyphicon glyphicon-plus"> Nouveau</span>
                                </a>
                                <!-- Bouton pour afficher la liste de message recus -->
                                <a href="do?action=afficherMessagerie" class="btn ${(empty requestScope.enCreation?"btn-danger":"btn-default")} btn-lg btnMenu">
                                    <span class="badge">${servicesMessagerie.nbMessagesNonLus(sessionScope.utilisateur.getIdUtilisateur())}</span>
                                    <span class="glyphicon glyphicon-inbox"> Reçus</span>
                                </a>
                                <!-- Bouton pour afficher la liste de message envoyes -->
                                <a href="#" class="btn btn-default btn-lg btnMenu">
                                    <span class="glyphicon glyphicon-arrow-left"> Envoyés</span>
                                </a>
                                <!-- Bouton pour afficher les messages suavegardes -->
                                <a href="#" class="btn btn-default btn-lg btnMenu">
                                    <span class="glyphicon glyphicon-floppy-disk"> Sauvegardés</span>
                                </a>
                            </div>
                        </div>
                        <!-- Fin de la liste des options du menu -->
                        
                    </div>
                </div>
                <!-- Fin de la section du menu des messages -->
                
                <!-- Debut de la section du formulaire pour un nouveau message -->
                <c:if test="${ not empty requestScope.enCreation}">
                    <div class="col-lg-8">
                        <div class="panel panel-default">
                            
                            <!-- Titre du conteneur de message avec la date et l'heure du message -->
                            <div class="panel-heading">Nouveau message</div>
                            
                            <!-- Interieur du message -->
                            <div class="panel-body message">
                                
                                <!-- Section de l'evoyeur du message -->
                                <div class="col-lg-12" id="messageEnvoyeur">
                                    <label id="messageEnvoyeur"><b>Envoyeur : </b></label>
                                    <span> Maxime <kbd>Activix</kbd></span>
                                    <hr>
                                </div>
                                
                                <!-- Section du titre du message -->
                                <div class="col-lg-12" id="messageTitre">
                                    <label id="messageTitre"><b>Titre : </b></label>
                                    <span></span>
                                    <hr>
                                </div>
                                
                                <!-- Contenu du message -->
                                <pre id='texteMessage'></pre>
                            </div>
                        </div>
                    </div>
                </c:if>
                <!-- Fin de la section du formulaire pour un nouveau message -->
                
                <!-- Debut de la section de la liste de messages -->
                <c:if test="${empty requestScope.enCreation}">
                    <div class="col-lg-3">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                Messages recus
                            </div>
                            <div id="messages" class="panel-body">

                                <!-- Messaages non-lus -->
                                <c:forEach var="unMessage" items="${servicesMessagerie.messagesRecusNonLus(sessionScope.utilisateur.getIdUtilisateur())}">
                                    <c:set var="user" value="${utilisateurDAO.findById(unMessage.getIdExpediteur())}"/>
                                    <form method="post" action="./do" class="message${unMessage.getIdMessage()}">
                                        <!-- Informations a envoyer pour le form -->
                                        <input type="hidden" name="messageSelectionner" value="${unMessage.getIdMessage()}">
                                        <input type="hidden" name="action" value="selectionnerMessage"/>

                                        <!-- Cree le message -->
                                        <div class="panel panel-default" onclick="selectionnerUnMessage(${unMessage.getIdMessage()})">
                                            <div class="panel-heading">
                                                <span class="label label-danger label-as-badge">&#8203 &#8203</span>

                                                <!-- Afficher le nom de la compagnie si il est un employeur -->
                                                <c:if test="${user.getTypeUtilisateur() eq 'Employeur'}">
                                                    <jsp:useBean id="employeur" class="com.stageo.beans.Employeur"/>
                                                    <c:set var="employeur" value="${employeurDAO.findById(unMessage.getIdExpediteur())}"/>
                                                    <!-- Afficher le nom de la compagnie -->
                                                    <kbd>${compagnieDAO.findById(employeur.getIdCompagnie()).getNom()}</kbd>
                                                </c:if>

                                                <!-- Aller chercher et afficher le prenom et nom du contact -->
                                                ${utilisateurDAO.findById(unMessage.getIdExpediteur()).getPrenom()}
                                                <div class="dateMessage">${unMessage.getDate()}</div>
                                            </div>
                                            <div class="panel-body">${unMessage.getTitre()}</div>
                                        </div>
                                    </form>
                                </c:forEach>
                                <!--Fin des messages non-lus -->

                                <hr /><!-- Mettre une separation entre les messages lus et les non-lus-->

                                <!-- Messages lus -->
                                <c:forEach var="unMessage" items="${servicesMessagerie.messagesRecusLus(sessionScope.utilisateur.getIdUtilisateur())}">
                                    <c:set var="user" value="${utilisateurDAO.findById(unMessage.getIdExpediteur())}"/>
                                    <form method="post" action="./do" class="message${unMessage.getIdMessage()}">
                                        <!-- Informations a envoyer pour le form -->
                                        <input type="hidden" name="messageSelectionner" value="${unMessage.getIdMessage()}">
                                        <input type="hidden" name="action" value="selectionnerMessage"/>

                                        <!-- Cree le message -->
                                        <div class="panel panel-default" onclick="selectionnerUnMessage(${unMessage.getIdMessage()})">
                                            <div class="panel-heading">
                                                <!-- Mettre le cercle de la couleur grise pour vu -->
                                                <span class="label label-default label-as-badge">&#8203 &#8203</span>
                                                <c:if test="${user.getTypeUtilisateur() eq 'Employeur'}">
                                                    <c:set var="employeur" value="${employeurDAO.findById(unMessage.getIdExpediteur())}"/>

                                                    <!-- Afficher le nom de la compagnie -->
                                                    <kbd>${compagnieDAO.findById(employeur.getIdCompagnie()).getNom()}</kbd> 
                                                </c:if>

                                                <!-- Aller chercher et afficher le prenom et nom du contact -->
                                                ${utilisateurDAO.findById(unMessage.getIdExpediteur()).getPrenom()}
                                                <!-- Afficher la date du message-->
                                                <div class="dateMessage">${unMessage.getDate()}</div>
                                            </div>
                                            <div class="panel-body">${unMessage.getTitre()}</div>
                                        </div>
                                    </form>
                                </c:forEach>
                                <!-- Fin des messages lus -->
                            </div>
                        </div>
                    </div>
                </c:if>
                <!-- Fin de la section de la liste de messages -->
                
                <!-- Debut de la section dun message -->
                <c:if test="${not empty sessionScope.messageSelectionner}">
                    <!-- Assigner la variable de sesion a une variable -->
                    <c:set var="messSelec" value="${messageDAO.findById(sessionScope.messageSelectionner)}"/>
                    <c:set var="user" value="${utilisateurDAO.findById(messSelec.getIdExpediteur())}"/>
                    
                    <div class="col-lg-5">
                        <div class="panel panel-default">
                            
                            <!-- Titre du conteneur de message avec la date et l'heure du message -->
                            <div class="panel-heading">Message</div>
                            <div class="dateMessage"><!--NOTE : Apparait dans le div plus bas-->
                                Envoyé le ${messSelec.getDate()} à ${messSelec.getHeure()}
                            </div>
                            
                            <!-- Interieur du message -->
                            <div class="panel-body message">
                                
                                <!-- Section de l'evoyeur du message -->
                                <div class="col-lg-12" id="messageEnvoyeur">
                                    <label id="messageEnvoyeur"><b>Envoyeur : </b></label>
                                    <span>
                                        <!-- Si le user est un employeur nous affiche le nom de la compagnie-->
                                        <c:if test="${user.getTypeUtilisateur() eq 'Employeur'}">
                                            <c:set var="employeur" value="${employeurDAO.findById(messSelec.getIdExpediteur())}"/>
                                            <kbd>${compagnieDAO.findById(employeur.getIdCompagnie()).getNom()}</kbd>
                                        </c:if>
                                        ${user.getPrenom()} ${user.getNom()} 
                                    </span>
                                    <hr>
                                </div>
                                
                                <!-- Section du titre du message -->
                                <div class="col-lg-12" id="messageTitre">
                                    <label id="messageTitre"><b>Titre : </b></label>
                                    <span>${messSelec.getTitre()}</span>
                                    <hr>
                                </div>
                                
                                <!-- Contenu du message -->
                                <pre id='texteMessage'>${messSelec.getMessage()}</pre>
                            </div>
                        </div>
                    </div>
                </c:if>
                <!-- Fin de la section dun message -->
                
                <div class="col-lg-1"></div><!-- Sert de margin -->
                
            </div>
        </div>
        
        <!-- Footer -->
        <%@include  file="footer.jsp" %>
        <!-- Fin footer -->
        
        <script>
            $(document).ready(function(){
                // Chacher le titre
                $("#descTitrePage").hide();
                
                $("#messages").hover(function(){
                    $(this).css("overflow-y","scroll");
                });
                $("#messages").mouseleave(function(){
                    $(this).css("overflow-y","hidden");
                });
                $("#texteMessage").hover(function(){
                    $(this).css("overflow-y","scroll");
                });
                $("#texteMessage").mouseleave(function(){
                    $(this).css("overflow-y","hidden");
                });
                
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
            
            function selectionnerUnMessage(id){
                 $(".message"+id).submit();
            }
        </script>
    </body>
    
</html>
