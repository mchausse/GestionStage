<%-- 
    Document   : ListeStagesEleves
    Created on : Oct 24, 2018, 10:26:06 AM
    Author     : mchausse
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Stages | Accueil</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    </head>
    <body>
        <!-- Barre de navigation -->
        <%@include  file="navBar.jsp" %>
        <!-- Fin de la barre de navigation -->

        <!-- Contenu de la page -->
        <div class="container-fluid" id="contenuPage">
            <!-- Section de recherche par competences -->
            <div class="row">
                <div class="col-lg-5">
                    <h2>Recherche par compétences</h2>
                </div>
                <div class="col-lg-7">
                    <!-- bouton pour la liste -->
                    <div class="col-lg-2">
                        <a class="btn btn-primary dropdown-toggle" data-toggle="dropdown" href="#">Comptétences <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li class="dropdown-item px-2" onclick="ajouterCompetence('php')">php</li>
                            <li class="dropdown-item px-2" onclick="ajouterCompetence('html')">html</li>
                            <li class="dropdown-item px-2" onclick="ajouterCompetence('java')">java</li>
                            <li class="dropdown-item px-2" onclick="ajouterCompetence('c')">c</li>
                            <li class="dropdown-item px-2" onclick="ajouterCompetence('c++')">c++</li>
                            <li class="dropdown-item px-2" onclick="ajouterCompetence('c#')">c#</li>
                            <li class="dropdown-item px-2" onclick="ajouterCompetence('python')">python</li>
                            <li class="dropdown-item px-2" onclick="ajouterCompetence('VB')">VB</li>
                            <li class="dropdown-item px-2" onclick="ajouterCompetence('java EE')">java EE</li>
                            <li class="dropdown-item px-2" onclick="ajouterCompetence('ruby')">ruby</li>
                        </ul>
                    </div>
                    
                    <!-- Conteneur de comperence -->
                    <div class="col-lg-10">
                        <div class="card">
                            <div id="conteneurCompetences" class="card-body"></div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Fin de section de recherche par competances -->

            <!-- Section de recherche des stages -->
            <div class="row">
                <div class="col-lg-12">
                    <h2>Recherche par mots-clés</h2>
                </div>
            </div>
            <!-- Fin de la section de recherche des stages -->
        </div>

        <!-- Footer -->
        <%@include  file="footer.jsp" %>
        <!-- Fin footer -->
        <script>
            var nbComp = 0;
            function ajouterCompetence(nom){
                document.getElementById("conteneurCompetences").innerHTML += "<span class='competence' id='competence"+nbComp+"'>"+nom+" <a class='fas fa-times' onclick='enleverCompetence("+nbComp+")'></a></span>";
                $(".competence").addClass("alert-primary")
                        .css("padding","5px 8px 5px 8px");
                nbComp++;
            };
            function enleverCompetence(i){
                document.getElementById("competence"+i).remove();
            }
        </script>
    </body>
</html> 
