<%-- 
    Document   : inscription
    Created on : 2018-11-14, 09:18:18
    Author     : gabri
--%>

<%@page import="com.stageo.beans.Avertissement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <c:if test="${ param.action=='inscription'}" >
            <c:redirect url = "do?action=afficherIncription"/>
        </c:if>
        <%@include  file="menu.jsp" %> 
        <!-- Si il y a une erreur : -->
        <c:if test="${ !empty sessionScope['avertissement']}" >
            <c:set var = "avert" value = "${sessionScope['avertissement']}"/>
            <c:remove var="avertissement" scope="session" />
            <div class="row" style="margin: 10em 0em -10em 0em;">
                <div class="col-lg-2"></div>
                <div class="col-lg-8">
                    <c:if test="${ avert.getType()=='erreur' && avert!=''}" >
                        <div class="alert alert-danger">
                            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                            <strong>Erreur!</strong> ${avert.getMessage()}
                        </div>
                    </c:if>
                </div>
            </div>
        </c:if>
        
        <div class="container" id="contenuInscription">
            <div class="row">
                <div class="col-lg-6"> <!-- Contenu d'inscription-->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4>Inscription</h4> 
                        </div>
                        <div class="contenuPan">
                            <form action="do?action=inscription" method="post">
                                <div class="form-group">
                                    <div class="input-group"> <!--Nom inscription-->
                                        <div class="input-group-addon"><span class="glyphicon glyphicon-user"></span> </div>
                                        <input type="text" name="nomInscri" class="form-control inscriptionInput" placeholder="Nom" required>
                                    </div>
                                    <br/>
                                    <div class="input-group"> <!--Prénom inscription-->
                                        <div class="input-group-addon"><span class="glyphicon glyphicon-user"></span> </div>
                                        <input type="text" name="prenomInscri" class="form-control inscriptionInput" placeholder="Prénom" required>
                                    </div>
                                    <br/>
                                    <div class="input-group"> <!--Email inscription-->
                                        <div class="input-group-addon "><span class="glyphicon glyphicon-envelope"></span> </div>
                                        <input type="email" name="emailInscri" class="form-control inscriptionInput" placeholder="Votre@Email.ca" required>
                                    </div>
                                    <br/>
                                    <div class="input-group"> <!--Password inscription-->
                                        <div class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span> </div>
                                        <input type="password" name="passwordInscri" class="form-control inscriptionInput" placeholder="Mot De Passe" required>
                                    </div>
                                    <br />
                                    <div class="input-group"> <!--Password inscription-->
                                        <div class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span> </div>
                                        <input type="password" name="password2Inscri" class="form-control inscriptionInput" placeholder="Vérification Mot De Passe" required>
                                    </div>
                                    <br/>
                                    <select class="form-control inscriptionInput" name="typeInscri" onChange="afficheInfo()" id="selectRole"> <!--Password inscription-->
                                        <option value="" disabled selected>Je Suis ...</option>
                                        <option>Etudiant</option>
                                        <option>Employeur</option>
                                    </select>
                                </div>
                                <div id="infoEleve" style="display: none">
                                    <input type="submit" class="btn btn-success" id="btnLogin" value="S'Inscrire" style="width:100%">
                                </div>
                                <div id="infoEmployeur" style="display: none">
                                    <div class="input-group"> <!--Telephone inscription-->
                                        <div class="input-group-addon"><span class="glyphicon glyphicon-phone-alt"></span> </div>
                                        <input type="tel" class="form-control inscriptionInput" name="telInscri" id="inputTel" placeholder="Téléphone" required>
                                    </div>
                                    <br/>
                                    <div class="input-group"> <!--Nom Entreprise inscription-->
                                        <div class="input-group-addon"><span class="glyphicon glyphicon-briefcase"></span> </div>
                                        <input type="text" class="form-control inscriptionInput" name="entrepriseInscri" id="inputEntre" placeholder="Nom de votre Entreprise" required>
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
                            <form action="do?action=connexion" method="post">
                                <div class="form-group">
                                    <div class="input-group">
                                        <div class="input-group-addon" id="iconMailLog"><span class="glyphicon glyphicon-envelope"></span> </div>
                                        <input type="email" class="form-control"  id="emailLog" name="emailLog" placeholder="Votre@Email.ca" required>
                                    </div>
                                    <div class="input-group">
                                        <div class="input-group-addon" id="iconPasslLog"><span class="glyphicon glyphicon-asterisk"></span> </div>
                                        <input type="password" class="form-control" id="paswordLog" name="passwordLog" placeholder="Mot De Passe" required>
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
        
        if(role === "Etudiant"){
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
    function deleteAttribut(){
        <% session.removeAttribute("avertissement"); %>
    }
</script>