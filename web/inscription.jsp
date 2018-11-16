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
    <body onLoad="cacherInfo()">
        <%@include  file="menu.jsp" %>
        <div class="container" id="contenuInscription">
            <div class="row">
                <div class="col-lg-6"> <!-- Contenu d'inscription-->
                    <div class="panel panel-default">
                        <div class="panel-heading"><h4>Inscription</h4></div>
                        <div class="contenuPan">
                            <form>
                                <div class="form-group">
                                    <div class="input-group"> <!--Nom inscription-->
                                        <div class="input-group-addon"><span class="glyphicon glyphicon-user"></span> </div>
                                        <input type="text" class="form-control inscriptionInput" placeholder="Nom" required>
                                    </div>
                                    <br/>
                                    <div class="input-group"> <!--Prénom inscription-->
                                        <div class="input-group-addon"><span class="glyphicon glyphicon-user"></span> </div>
                                        <input type="text" class="form-control inscriptionInput" placeholder="Prénom" required>
                                    </div>
                                    <br/>
                                    <div class="input-group"> <!--Email inscription-->
                                        <div class="input-group-addon "><span class="glyphicon glyphicon-envelope"></span> </div>
                                        <input type="email" class="form-control inscriptionInput" placeholder="Votre@Email.ca" required>
                                    </div>
                                    <br/>
                                    <div class="input-group"> <!--Password inscription-->
                                        <div class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span> </div>
                                        <input type="password" class="form-control inscriptionInput" placeholder="Mot De Passe" required>
                                    </div>
                                    <br />
                                    <div class="input-group"> <!--Password inscription-->
                                        <div class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span> </div>
                                        <input type="password" class="form-control inscriptionInput" placeholder="Vérification Mot De Passe" required>
                                    </div>
                                    <br/>
                                    <select class="form-control inscriptionInput" onChange="afficheInfo()" id="selectRole"> <!--Password inscription-->
                                        <option value="" disabled selected>Je Suis ...</option>
                                        <option>Étudiant</option>
                                        <option>Employeur</option>
                                    </select>
                                </div>
                                <div id="infoEleve" style="display: none">
                                    <input type="submit" class="btn btn-success" id="btnLogin" value="S'Inscrire" style="width:100%">
                                </div>
                                <div id="infoEmployeur" style="display: none">
                                    <div class="input-group"> <!--Nom inscription-->
                                        <div class="input-group-addon"><span class="glyphicon glyphicon-phone-alt"></span> </div>
                                        <input type="tel" class="form-control inscriptionInput" id="inputTel" placeholder="Téléphone" required>
                                    </div>
                                    <br/>
                                    <div class="input-group"> <!--Nom inscription-->
                                        <div class="input-group-addon"><span class="glyphicon glyphicon-briefcase"></span> </div>
                                        <input type="text" class="form-control inscriptionInput" id="inputEntre" placeholder="Nom de votre Entreprise" required>
                                    </div>
                                    <input type="submit" class="btn btn-success" id="btnLogin" value="S'Inscrire" style="width:100%">
                                </div>
                            </form>
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
                                        <input type="email" class="form-control"  id="emailLog" placeholder="Votre@Email.ca" required>
                                    </div>
                                    <div class="input-group">
                                        <div class="input-group-addon" id="iconPasslLog"><span class="glyphicon glyphicon-asterisk"></span> </div>
                                        <input type="password" class="form-control" id="paswordLog" placeholder="Mot De Passe" required>
                                    </div>
                                    <input type="submit" class="btn btn-primary" id="btnLogin" value="Se Connecter" style="width:100%">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
<script type="text/javascript">
    function afficheInfo(){
        var e = document.getElementById("selectRole");
        var role = e.options[e.selectedIndex].value;
        
        if(role === "Étudiant"){
            document.getElementById("infoEleve").style.display = "block";
            document.getElementById("infoEmployeur").style.display = "none";
            document.getElementById("inputTel").required = false;
            document.getElementById("inputEntre").required = false;
        }
        if(role === "Employeur"){
            document.getElementById("infoEleve").style.display = "none";
            document.getElementById("infoEmployeur").style.display = "block";
            document.getElementById("inputTel").required = true;
            document.getElementById("inputEntre").required = true;
        }
    }
    function cacherInfo(){
        document.getElementById("infoEleve").style.display = "none";
        document.getElementById("infoEmployeur").style.display = "none";
        document.getElementById("infoEleve").style.display = "none";
    }
</script>