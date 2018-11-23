<%-- 
    Document   : profil
    Created on : 2018-11-23, 11:57:50
    Author     : gabri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.stageo.dao.UtilisateurDAO" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="userDao" class="com.stageo.dao.UtilisateurDAO" scope="page"></jsp:useBean>
<c:set var="user" value="${userDao.findById(sessionScope['utilisateur'].getIdUtilisateur())}" />
<!DOCTYPE html>
<html>
    <head>
        <title>Stages | Profil </title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="./css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include  file="menu.jsp" %>
       
        <div class="col-lg-1"></div>
        <div class="col-lg-10 offset-lg-1 " style="margin-top: 10em; background-color: lightblue;">
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h2>
                                Profil
                                <a style="float: right;"><span class="glyphicon glyphicon-edit"></span></a>
                            </h2>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6 ">
                     <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4>Vos Informations : </h4>
                        </div>
                        <form>
                            <div class="form-group" style="padding:1em;">
                                <label for="nomUser">Nom : </label>
                                <input type="text" class="form-control" id="nomUser"  value="${user.getNom()}" disabled>
                                <br/>
                                <label for="prenomUser">Prénom :</label>
                                <input type="text" class="form-control" id="prenomUser"  value="${user.getPrenom()}" disabled>
                                <br/>
                                <label for="emailUser">Courriel </label>
                                <input type="text" class="form-control" id="emailUser"  value="${user.getCourriel()}" disabled>
                                <br/>
                                <label for="typeUser">Type de votre compte : </label>
                                <input type="text" class="form-control" id="typeUser"  value="${user.getTypeUtilisateur()}" disabled>
                            </div>
                        </form>
                     </div>
                </div>
                <div class="col-lg-6 ">
                    <c:if test="${user.getTypeUtilisateur() eq 'Etudiant'}">lol</c:if>
                    <h1>gauche</h1>
                </div>
            </div>
        </div>
    </body>
</html>
