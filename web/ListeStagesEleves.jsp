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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    </head>
    <body>
        <!-- Barre de navigation -->
        <nav class="navbar navbar-expand-sm bg-light navbar-light fixed-top" id="collapsibleNavbar">
            <!-- Titre de la barre de tache -->
            <a class="navbar-brand lienImageBarre" href="#"></a>
            <a class="navbar-brand lienBarreTitre" href="#">Gestion de stage</a>

            <!-- Toggler/collapsibe Button -->
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
                <span class="navbar-toggler-icon"></span>
            </button>

            <!-- Liste des liens -->
            <div class="collapse navbar-collapse" id="collapsibleNavbar">
                <ul class="navbar-nav" id="barreNav">
                    <li class="nav-item">
                        <a class="nav-link lienBarre" href="#">Mon profil</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link lienBarre" href="#">Offres de stage</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link lienBarre" href="#">Documents</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link lienBarre" href="#">Paramètres</a>
                    </li>
                </ul>
            </div>
        </nav>
        <!-- Fin de la barre de navigation -->

        <!-- Contenu de la page -->
        <div class="container-fluid" id="contenuPage">
            <!-- Section de recherche par competances -->
            <div class="row">
                <div class="col-lg-12">
                    <h2>Recherche par compétences</h2>
                </div>
            </div>
            <!-- Fin de section de recherche par competances -->

            <!-- Section de recherche des stages -->
            <div class="row">
                <div class="col-lg-12">
                    <h2>Recherche par mots-clés</h2>
                </div>
            </div>
        </div>

        <!-- Footer -->
        <%@include  file="footer.jsp" %>
        <!-- Fin footer -->
        <script>
        </script>
    </body>
</html> 
