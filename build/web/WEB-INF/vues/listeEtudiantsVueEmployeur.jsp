<%-- 
    Document   : listeElevesParComp
    Created on : 2018-10-25, 13:25:57
    Author     : gab
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Stages | Liste Élèves</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="./css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include  file="menu.jsp" %>
        <div class="container" id="contenuListeEleve">
            <div class="row">
                <div class="col-lg-5"> <!-- partie gauche de la page -->
                    <select class="form-control" id="selectionStage">
                        <option value="progWeb">Programmation web</option>
                        <option value="progC#">Programmation C#</option>
                        <option value="progJava">Programmation Java</option>
                    </select>
                    <br><!--Faire fonction onChange en JS pour loader les élèves dans les recherches-->
                    <input type="text" class="form-control has-feedback" id="rechercheEleve" placeHolder="Rechercher ..." style="border-radius: 50px;">
                    <br>
                    <table class="table table-hover borderTable">
                        <thead>
                          <tr>
                              <th>Nom <a class="sortBy" href="#"><span class="glyphicon glyphicon-sort-by-alphabet"></span></a></th>
                              <th>Spécialité <a class="sortBy" href="#"><span class="glyphicon glyphicon-sort-by-alphabet"></span></a></th>
                              <th>Match <a class="sortBy" href="#"><span class="glyphicon glyphicon-sort-by-order"></span></a></th>
                              <th>Consulté <a class="sortBy" href="#"><span class="glyphicon glyphicon-sort"></span></a></th>
                          </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>Billy Bob</td>
                                <td>Réseau</td>
                                <td>88%</td>
                                <td><input type="checkbox" checked disabled></td>
                            </tr>
                            <tr>
                                <td>Georges Dupont</td>
                                <td>Programmation Web</td>
                                <td>70%</td>
                                <td><input type="checkbox" disabled></td>
                            </tr>
                            <tr>
                                <td>Slaver Dure</td>
                                <td>Gestion</td>
                                <td>90%</td>
                                <td><input type="checkbox" checked disabled></td>
                            </tr>
                            <tr>
                                <td>Jeff Jefferson</td>
                                <td>Programmation Web</td>
                                <td>99%</td>
                                <td><input type="checkbox" disabled></td>
                            </tr>
                            <tr>
                                <td>Pablo Esobar</td>
                                <td>Gestion</td>
                                <td>100%</td>
                                <td><input type="checkbox" checked disabled></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div class="col-lg-7 col-md-12 col-sm-12 divBorder"> <!--coté droit de la page -->
                <div class="col-lg-6 col-md-6 col-sm-6 colInfoEleve"> 
                    <br>
                    <label>Prénom :</label>
                    <div class="divInfoEleve">
                        <p>Pablo</p>
                    </div>
                    <br>
                    <label>Nom :</label>
                    <div class="divInfoEleve">
                        <p>Escobar</p>
                    </div>
                                        <br>
                    <label>Téléphone :</label>
                    <div class="divInfoEleve">
                        <p>514-666-9119</p>
                    </div>
                    <br>
                    <label>Courriel :</label>
                    <div class="divInfoEleve">
                        <p>Pablo@Escobar.col</p>
                    </div>
                    <br>
                    <label>Linkedin :</label>
                    <div class="divLinkEleve">
                        <a  href="#">linkedin.com/Pablo</a>
                    </div>
                    <br>
                    <label>Github :</label>
                    <div class="divLinkEleve">
                        <a href="#">github.com/Pablo</a>
                    </div>
                </div>
                <div class="col-lg-6 col-md-6 col-sm-6 colInfoEleve">
                    <br>
                    <label>Spécialité :</label>
                    <div class="divInfoEleve">
                        <p>Gestion</p>
                    </div>
                    <br>
                    <label>Ce que je recherche :</label>
                    <div class="divInfoEleve">
                        <p> 
                            &#xb7; Temps plein <br>
                            &#xb7; Payé (110$/h et +) <br>
                            &#xb7; Assurance vie <br>
                        </p>
                    </div>
                    <br>
                    <table class="table table-hover borderTable">
                        <thead>
                            <tr>
                                <th scope="col">Compétences</th>
                                <th scope="col">Domaine</th>
                                <th scope="col">Niveau</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>Gestion</td>
                                <td>Comptable</td>
                                <td>Expert</td>
                            </tr>
                            <tr>
                                <td>C#</td>
                                <td>Prog</td>
                                <td>Intermediaire</td>
                            </tr>
                            <tr>
                                <td>Java</td>
                                <td>Prog</td>
                                <td>Intermediaire</td>
                            </tr>
                        </tbody>
                    </table>
                    <button type="button" class="btn btn-primary btnAccepte" style="width: 100%;">Accepter Candidature</button>
                </div>
            </div>
         </div>
    </body>
</html>
