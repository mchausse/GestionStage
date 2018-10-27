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
                    <input type="text" class="form-control has-feedback" id="rechercheEleve" style="border-radius: 50px;">
                    <br>
                    <table class="table table-hover" id="rechercheEleveTab">
                        <thead>
                          <tr>
                            <th>Nom</th>
                            <th>Spécialité</th>
                            <th>Match</th>
                            <th>Consulté</th>
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
                <div class="col-lg-7 divBorder"> <!--coté droit de la page -->
                    <h1>Fuck 12</h1>
                    <h1>Fuck 12</h1>
                    <h1>Fuck 12</h1>
                    <h1>Fuck 12</h1>
                    <h1>Fuck 12</h1>
                    <h1>Fuck 12</h1>
                    <h1>Fuck 12</h1>
                </div>
            </div>
         </div>
    </body>
</html>
