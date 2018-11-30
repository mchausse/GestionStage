<%-- 
    Document   : ListeStagesEleves
    Created on : Oct 24, 2018, 10:26:06 AM
    Author     : mchausse
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- Initialiser les dao utiliser dans la page -->
<jsp:useBean id="offreStageDAO" class="com.stageo.dao.OffreStageDAO" scope="page"/>
<jsp:useBean id="utilisateurDAO" class="com.stageo.dao.UtilisateurDAO" scope="page"/>
<jsp:useBean id="employeurDAO" class="com.stageo.dao.EmployeurDAO" scope="page"/>
<jsp:useBean id="compagnieDAO" class="com.stageo.dao.CompagnieDAO" scope="page"/>
<jsp:useBean id="critereDAO" class="com.stageo.dao.CritereDAO" scope="page"/>
<jsp:useBean id="servicesCritere" class="com.stageo.services.ServicesCritere" scope="page"/>

<!DOCTYPE html>
<html>
    <head>
        <title>Stages | Recherche</title>
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
        <!-- Fin de la barre de navigation -->

        <!-- Contenu de la page -->
        <div class="container-fluid" id="contenuPage">
            
            <!-- Titre de la page -->
            <div class="row">
                <div class="col-lg-4">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3>
                                <span id='btnDescTitrePage' class='glyphicon glyphicon-triangle-bottom'></span>
                                Offres de stage
                            </h3>
                            <p id='descTitrePage'>
                                Ici, vous pouvez voir toutes les offre de stage publie par des employeur
                            </p>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Fin du titre de la page-->
                
            <!-- Section de recherche par competences -->
            <div class="row">
                <div class="col-lg-4">
                    <h2>Recherche par compétences</h2>
                </div>
                <div class="col-lg-7" id='sectionCompetences'>
                    <!-- bouton pour la liste -->
                    <div class="col-lg-2">
                        <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Compétences <span class="caret"></span></button>
                        <ul class="dropdown-menu">
                            <c:forEach var="critere" items="${critereDAO.findAll()}">
                                <li onclick='ajouterCompetence("${critere.getNom()}")'><a href="#">${critere.getNom()}</a></li>
                            </c:forEach>
                        </ul>
                    </div>
                    
                    <!-- Conteneur de comperence -->
                    <div class="col-lg-10">
                        <div  class="panel panel-default">
                            <div class="panel-body" id="conteneurCompetences"></div>
                        </div>
                    </div>
                    
                </div>
            </div>
            <!-- Fin de section de recherche par competances -->

            <!-- Section de recherche des stages -->
            <h2>Resultats </h2>
            <c:set var="i" value="${0}"/>
            <c:forEach var="offre" items="${offreStageDAO.findAll()}">
                
                <!-- Afficher les offres inactives seulement si l'utilisateur est un coordonnateur-->
                <c:if test="${(offre.getActive() && sessionScope.utilisateur.getTypeUtilisateur() eq 'Etudiant') || sessionScope.utilisateur.getTypeUtilisateur() eq 'Coordonnateur'}">
                
                    <!-- Debut d'une offre -->
                    <form>
                        <div class='col-lg-6 col-md-6 col-sm-12 uneOffre'>
                            <div class="panel panel-default">

                                <div class="panel-heading">
                                    <!-- Pour afficher un voyant de couleur -->
                                    <c:if test="${offre.getActive()}">
                                        <span class="label label-success label-as-badge">&#8203 &#8203</span>
                                    </c:if>
                                    <c:if test="${not offre.getActive()}">
                                        <span class="label label-default label-as-badge">&#8203 &#8203</span>
                                    </c:if>
                                    <div class='row'>

                                        <!-- Afficher les date dans le haut de l'offre-->
                                        <div class="col-lg-12 dateStage">
                                            Publié: ${offre.getDate().toString().substring(0,10)},
                                            valide du: ${offre.getDateDebut().toString().substring(0,10)} 
                                            au ${offre.getDateFin().toString().substring(0,10)}
                                        </div>

                                        <!-- Afficher la compagnie-->
                                        <div class="col-lg-9 col-md-8 col-sm-8"><kbd>${compagnieDAO.findById(employeurDAO.findById(offre.getIdEmployeur()).getIdCompagnie()).getNom()}</kbd> ${offre.getTitre()}</div>

                                        <!-- Aller chercher tous les critere de loffre et les afficher dans un dropdown list-->
                                        <div class="col-lg-3 col-md-3 col-sm-3">
                                            <div class="dropdown">
                                                <button class="btn btn-default dropdown-toggle btn-md" type="button" data-toggle="dropdown"><span class="glyphicon glyphicon-tags"></span>                                                <span class="caret"></span></button>
                                                <ul class="dropdown-menu">
                                                    <c:forEach var="critere" items="${servicesCritere.findAllCriteresOffre(offre.getIdOffre())}">
                                                        <li><a href="#">${critere.getNom()}</a></li>
                                                    </c:forEach>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="panel-body bodyOffre">
                                    <div class="col-lg-12">
                                        <div class='row'>

                                            <!-- Liens vers le doc-->
                                            <div class="col-lg-9 col-md-6 col-sm-6">
                                                <span class="glyphicon glyphicon-file"><a class="lienOffre"> ${offre.getLienDocument()}</a></span>
                                            </div>
                                            <!-- Rémunération-->
                                            <div class="col-lg-3 col-md-6 col-sm-6">
                                                <c:if test="${offre.getRemunere()}">
                                                    <button class="btn btn-success btn-sm">Rémunéré <span class='glyphicon glyphicon-ok'></span></button>
                                                </c:if>
                                                <c:if test="${not offre.getRemunere()}">
                                                    <button class="btn btn-danger btn-sm">Rémunéré <span class='glyphicon glyphicon-remove'></span></button>
                                                </c:if>
                                            </div>

                                            <!-- Liens vers le site-->
                                            <div class="col-lg-9 col-md-6 col-sm-6">
                                                <span class="glyphicon glyphicon-globe"><a class="lienOffre"> ${offre.getLienWeb()}</a></span>
                                            </div>

                                            <!-- Nombre de vues-->
                                            <div class="col-lg-2 col-md-6 col-sm-6">
                                                Vues : ${offre.getNbVues()}
                                            </div>

                                            <!-- Durée du stage-->
                                            <div class="col-lg-9 col-md-6 col-sm-6">
                                                Duree de ${offre.getDureeEnJours()} jours
                                            </div>


                                        </div>
                                    </div>

                                    <div class="col-lg-12">
                                        <div class="col-lg-10 col-md-9 col-sm-9">
                                                <textarea class="form-control descOffre" rows="4" id='${offre.getIdOffre()}'>${offre.getDescription()}</textarea>
                                        </div>
                                        <div class="col-lg-2 col-md-2 col-sm-2">
                                            <c:if test="${sessionScope.utilisateur.getTypeUtilisateur() eq 'Etudiant'}">
                                                <button class="btn btn-danger dropdown-toggle btn-md btnPostuler" type="button" data-toggle="dropdown">Postuler</button>
                                            </c:if>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                </c:if>
                <!-- Fin d'une offre -->
            </c:forEach>
            <!-- Fin de la section de recherche des stages -->
        </div>

        <!-- Footer -->
        <%@include  file="footer.jsp" %>
        <!-- Fin footer -->
        <script>
            $(document).ready(function(){
                // Chacher le titre
                $("#descTitrePage").hide();
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
                
            var nbComp = 0;
            function ajouterCompetence(nom){
                document.getElementById("conteneurCompetences").innerHTML += "<span class='competence' id='competence"+nbComp+"'>"+nom+" <a class='fas fa-times' onclick='enleverCompetence("+nbComp+")'></a></span>";
                $(".competence").addClass("alert alert-info")
                        .css("padding","5px 8px 5px 8px");
                nbComp++;
            };
            
            function enleverCompetence(i){
                document.getElementById("competence"+i).remove();
            }
        </script>
    </body>
</html> 
