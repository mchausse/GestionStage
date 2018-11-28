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
                            <li class="dropdown-header">Programmation</li>
                            <li onclick="ajouterCompetence('php')"><a href="#">php</a></li>
                            <li onclick="ajouterCompetence('html')"><a href="#">html</a></li>
                            <li onclick="ajouterCompetence('java')"><a href="#">java</a></li>
                            <li onclick="ajouterCompetence('c')"><a href="#">c</a></li>
                            <li onclick="ajouterCompetence('c++')"><a href="#">c++</a></li>
                            <li onclick="ajouterCompetence('c#')"><a href="#">c#</a></li>
                            <li onclick="ajouterCompetence('python')"><a href="#">python</a></li>
                            <li onclick="ajouterCompetence('VB')"><a href="#">VB</a></li>
                            <li onclick="ajouterCompetence('java EE')"><a href="#">java EE</a></li>
                            <li onclick="ajouterCompetence('ruby')"><a href="#">ruby</a></li>
                            <li class="divider"></li>
                            <li class="dropdown-header">Réseau</li>
                            <li onclick="ajouterCompetence('CCNA')"><a href="#">CCNA</a></li>
                            <li onclick="ajouterCompetence('CCNT')"><a href="#">CCNT</a></li>
                            <li onclick="ajouterCompetence('Sécurité')"><a href="#">Sécurité</a></li>
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
            <div class="row" id="rechercheStage">
                <div class="col-lg-12">
                    <div class="row">
                        <div class="col-lg-4"><h2>Recherche par mots-clés</h2></div>
                        <!-- Barre de recherche -->
                        <form class="col-lg-7">
                            <div class="input-group">
                                <div class="input-group-btn">
                                    <button class="btn btn-default" type="submit"><i class="fas fa-search"></i></button>
                                </div>
                                <input id="inputRecherche" type="text" class="form-control" placeholder="Search">
                            </div>
                        </form>
                    </div>
                    <!-- Fin de la barre de recherche -->
                </div>
                <div class="row">
                    <div class='col-lg-1'></div>
                    
                    <!-- Debut d'une offre -->
                    <div class='col-lg-5'>
                        <div class="panel panel-default">

                            <div class="panel-heading">
                                <!-- Pour afficher un voyant de couleur -->
                                <span class="label label-success label-as-badge">&#8203 &#8203</span>
                                <div class='row'>
                                    <div class="col-lg-12 dateStage">Publié le 10-18-2018</div>
                                    <div class="col-lg-8"><kbd>Compagnie</kbd> Salut, je suis une tres longue offre de stage</div>
                                    <div class="col-lg-3">Status : Active</div>
                                    <a href="#" class="btn btn-default btn-md btnModStage">
                                        <span class="glyphicon glyphicon-pencil"></span>
                                    </a>
                                </div>
                            </div>

                            <div class="panel-body">
                                <div class='row'>
                                    <!-- Premiere section de l'offre-->
                                    <div class="col-lg-4">
                                        <a>LienDocument.txt</a>
                                    </div>
                                    <div class="col-lg-4">
                                        <a>LienWeb</a>
                                    </div>
                                    <div class="col-lg-4">
                                        Vue : 500
                                    </div>
                                    <!-- Deuxieme section de l'offre-->
                                    <div class="col-lg-12">
                                        <span onclick="ouvrirDesc()" class='glyphicon glyphicon-triangle-bottom'></span>
                                        Description
                                        <!--<pre id='descriptionXX'></pre>-->
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                    <!-- Fin d'une offre -->
                    
                    <div class='col-lg-1'></div>
                </div>
            </div>
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
