<%-- 
    Document   : ListeStagesEleves
    Created on : Oct 24, 2018, 10:26:06 AM
    Author     : mchausse
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Stages | Recherche</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css">
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
                <div class="col-lg-12">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <td>Compagnie <a href="#" class="fa fa-arrows-alt-v"></a></td>
                                <td>Spécialité <a href="#" class="fa fa-arrows-alt-v"></a></td>
                                <td>Poste <a href="#" class="fa fa-arrows-alt-v"></a></td>
                                <td>Places <a href="#" class="fa fa-arrows-alt-v"></a></td>
                                <td>Rémunération <a href="#" class="fa fa-arrows-alt-v"></a></td>
                                <td>Match <a href="#" class="fa fa-arrows-alt-v"></a></td>
                                <td>Statut <a href="#" class="fa fa-arrows-alt-v"></a></td>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td><a href="pommes.com">pomme</a></td>
                                <td>Programmation</td>
                                <td>Programmeur Web</td>
                                <td>1</td>
                                <td>0$/hr</td>
                                <td>87%</td>
                                <td>1</td>
                            </tr>
                            <tr>
                                <td><a href="pommes.com">pomme</a></td>
                                <td>Programmation</td>
                                <td>Programmeur Web</td>
                                <td>1</td>
                                <td>0$/hr</td>
                                <td>87%</td>
                                <td>1</td>
                            </tr>
                            <tr>
                                <td><a href="pommes.com">pomme</a></td>
                                <td>Programmation</td>
                                <td>Programmeur Web</td>
                                <td>1</td>
                                <td>0$/hr</td>
                                <td>87%</td>
                                <td>1</td>
                            </tr>
                            <tr>
                                <td><a href="pommes.com">pomme</a></td>
                                <td>Programmation</td>
                                <td>Programmeur Web</td>
                                <td>1</td>
                                <td>0$/hr</td>
                                <td>87%</td>
                                <td>1</td>
                            </tr>
                            <tr>
                                <td><a href="pommes.com">pomme</a></td>
                                <td>Programmation</td>
                                <td>Programmeur Web</td>
                                <td>1</td>
                                <td>0$/hr</td>
                                <td>87%</td>
                                <td>1</td>
                            </tr>
                        </tbody>
                    </table>
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
