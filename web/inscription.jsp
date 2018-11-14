<%-- 
    Document   : inscription
    Created on : 2018-11-14, 09:18:18
    Author     : gabri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Stages | Inscription </title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="./css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include  file="menu.jsp" %>
        <h1>Hello World!</h1>
        
        <div class="container" id="contenuInscription">
            <div class="row">
                <div class="col-lg-6"> <!-- Contenu d'inscription-->
                    <div class="panel panel-default">
                        <div class="panel-heading"><h4>Inscription</h4></div>
                        <div class="contenuPan">
                            <div class="input-group"> <!--Nom inscription-->
                                <div class="input-group-addon"><span class="glyphicon glyphicon-user"></span> </div>
                                <input type="text" class="form-control inscriptionInput" placeholder="Nom">
                            </div>
                            <br/>
                            <div class="input-group"> <!--Prénom inscription-->
                                <div class="input-group-addon"><span class="glyphicon glyphicon-user"></span> </div>
                                <input type="text" class="form-control inscriptionInput" placeholder="Prénom">
                            </div>
                            <br/>
                            <div class="input-group"> <!--Email inscription-->
                                <div class="input-group-addon "><span class="glyphicon glyphicon-envelope"></span> </div>
                                <input type="email" class="form-control inscriptionInput" placeholder="Votre@Email.ca">
                            </div>
                            <br/>
                            <div class="input-group"> <!--Password inscription-->
                                <div class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span> </div>
                                <input type="password" class="form-control inscriptionInput" placeholder="Mot De Passe">
                            </div>
                            <br/>
                            <select class="form-control inscriptionInput">
                                <option value="" disabled selected>Je Suis ...</option>
                                <option>Étudiant</option>
                                <option>Employeur</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6"> <!-- Contenu de Connexion-->
                    <div class="panel panel-default">
                        <div class="panel-heading"><h4>Connexion</h4></div>
                        <div class="contenuPan">
                            <form>
                                <div class="form-group">
                                    <div class="input-group">
                                        <div class="input-group-addon" id="iconMailLog"><span class="glyphicon glyphicon-envelope"></span> </div>
                                        <input type="email" class="form-control"  id="emailLog" placeholder="Votre@Email.ca">
                                    </div>
                                    <div class="input-group">
                                        <div class="input-group-addon" id="iconPasslLog"><span class="glyphicon glyphicon-asterisk"></span> </div>
                                        <input type="password" class="form-control" id="paswordLog" placeholder="Mot De Passe">
                                    </div>
                                    <button type="button" class="btn btn-success" id="btnLogin" style="width:100%">Se Connecter</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
