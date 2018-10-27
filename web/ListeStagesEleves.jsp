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
                <div class="col-lg-12">
                    <div class="table-responsive">
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
