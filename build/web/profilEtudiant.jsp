<%-- 
    Document   : profilEtudiant
    Created on : 2018-10-25, 10:17:32
    Author     : usager
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Stages | Accueil</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        <%@include  file="navBar.jsp" %>
        <div class="container-fluid" id="profilEtu">
            <h2>Profil rempli à <span id="completionProfil">0%</span></h2>
            <form class="form-horizontal">
                <div class="row">
                    <div class="col-lg-5" id="contenuGauche">
                        <div class="container-fluid" id="infoBase">
                            <div class="form-group">
                                <label for="nom" class="col-sm-3 col-form-label">Nom :</label>
                                <div class="col-sm-8">
                                  <input type="text" class="form-control" id="nom" placeholder="John">
                                </div>
                            </div>
                            <div class="form-group has-error has-feedback">
                                <label for="prenom" class="col-sm-3 col-form-label">Prénom :</label>
                                <div class="col-sm-8">
                                  <input type="text" class="form-control" id="prenom" placeholder="Doe">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="tel" class="col-sm-3 col-form-label">Téléphone :</label>
                                <div class="col-sm-8">
                                  <input type="text" class="form-control" id="tel" placeholder="(514)-389-7630">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="email" class="col-sm-3 col-form-label">Courriel :</label>
                                <div class="col-sm-8">
                                  <input type="email" class="form-control" id="email" placeholder="JDoe06@gmail.com">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="cv" class="col-sm-3 col-form-label">CV :</label>
                                <div class="col-sm-8">
                                  <input type="text" class="form-control" id="cv">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="relNote" class="col-sm-3 col-form-label">Relevé de notes :</label>
                                <div class="col-sm-8">
                                  <input type="text" class="form-control" id="relNote">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="lK" class="col-sm-3 col-form-label">LinkedIn :</label>
                                <div class="col-sm-8">
                                  <input type="text" class="form-control" id="lK">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="git" class="col-sm-3 col-form-label">Github :</label>
                                <div class="col-sm-8">
                                  <input type="text" class="form-control" id="git" >
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-5" id="contenuDroit">
                        <div class="row">
                            <div class="col-lg-6" id="contenuDroitOB">
                                <div class="form-group">
                                    <label for="spec" class="col-sm-5 col-form-label">Spécialité :</label>
                                    <div class="col-sm-8">
                                      <select class="form-control" id="spec">
                                        <option>Réseaux</option>
                                        <option>Programmation</option>
                                      </select>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-4" id="boxStats">
                                <label><span class="couleurStat">3</span> canditatures envoyées</label>
                                <label><span class="couleurStat">15 jours</span> de recherche</label>
                                <label>CV lu:<span class="couleurStat"> 10</span> fois</label>
                                <label>Consultation du profil:<span class="couleurStat"> 104</span> fois</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-5">
                                <div class="form-group">
                                    <label for="recherche">Ce que je recherche:</label>
                                    <textarea class="form-control" rows="3" id="recherche"></textarea>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <td>Compagnie <a href="#" class="fa fa-arrows-alt-v"></a></td>
                                <td>Poste <a href="#" class="fa fa-arrows-alt-v"></a></td>
                                <td>Date de contact <a href="#" class="fa fa-arrows-alt-v"></a></td>
                                <td>Statut <a href="#" class="fa fa-arrows-alt-v"></a></td>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td><a href="DealerB">Dealer Breacher</a></td>
                                <td>Programmeur Web</td>
                                <td>12/10/2018</td>
                                <td>En attente</td>
                            </tr>
                            <tr>
                                <td><a href="Google">Google</a></td>
                                <td>Soutien Technique</td>
                                <td>12/10/2018</td>
                                <td>Reçu</td>
                            </tr>
                            <tr>
                                <<td><a href="HydroQc">Hydro Québec</a></td>
                                <td>Programmation</td>
                                <td>12/10/2018</td>
                                <td>Reçu</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </form>
        </div>
        <%@include  file="footer.jsp" %>
    </body>
</html>
