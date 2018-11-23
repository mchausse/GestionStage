<%-- 
    Document   : profil
    Created on : 2018-11-23, 11:57:50
    Author     : gabri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.stageo.dao.UtilisateurDAO" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- DAOs : -->
<jsp:useBean id="userDao" class="com.stageo.dao.UtilisateurDAO" scope="page"></jsp:useBean>
<jsp:useBean id="etuDao" class="com.stageo.dao.EtudiantDAO" scope="page"></jsp:useBean>
<jsp:useBean id="empDao" class="com.stageo.dao.EmployeurDAO" scope="page"></jsp:useBean>
<jsp:useBean id="compDao" class="com.stageo.dao.CompagnieDAO" scope="page"></jsp:useBean>

<!-- Var User : -->
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
        <div class="col-lg-10 offset-lg-1 " style="margin-top: 10em;">
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h2>
                                Profil
                                <a onclick="edit('${user.getTypeUtilisateur()}')">
                                    <span class="glyphicon glyphicon-edit btnProfil" id="edit"></span>
                                </a>
                                <a>
                                    <span class="glyphicon glyphicon-ok btnProfil" id="editConfirm" style="display: none;"></span>
                                </a>
                                <a onclick="cancel('${user.getTypeUtilisateur()}')">
                                    <span class="glyphicon glyphicon-remove btnProfil" id="editCancel" style="display: none;"></span>
                                </a>
                            </h2>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6 ">
                     <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4>Vos Informations</h4>
                        </div>
                        <form>
                            <div class="form-group" style="padding:1em;">
                                <label for="nomUser">Nom : </label>
                                <input type="text" class="form-control" id="nomUser"  value="${user.getNom()}" disabled /> 
                                <input type="text" class="form-control" id="nomUser2"  value="${user.getNom()}" style="display:none"/>  
                                <br/>
                                <label for="prenomUser">Prénom :</label>
                                <input type="text" class="form-control" id="prenomUser"  value="${user.getPrenom()}" disabled />
                                <input type="text" class="form-control" id="prenomUser2"  value="${user.getPrenom()}" style="display:none"/>  
                                <br/>
                                <label for="emailUser">Courriel </label>
                                <input type="email" class="form-control" id="emailUser"  value="${user.getCourriel()}" disabled />
                                <input type="email" class="form-control" id="emailUser2"  value="${user.getCourriel()}" style="display:none"/>   
                                <br/>
                                <label for="typeUser">Type de votre compte : </label>
                                <input type="text" class="form-control" id="typeUser"  value="${user.getTypeUtilisateur()}" disabled />
                            </div>
                        </form>
                     </div>
                </div>
                <div class="col-lg-6 ">
                    <div class="panel panel-default">
                        <c:if test="${user.getTypeUtilisateur() eq 'Etudiant'}">
                            <c:set var="etu" value="${etuDao.findById(sessionScope['utilisateur'].getIdUtilisateur())}"/>
                            <div class="panel-heading">
                                <h4> Info Étudiant</h4>
                            </div>
                            <form>
                                <div class="form-group" style="padding:1em;">
                                    <label for="statutUser">Statut : </label>
                                    <input type="text" class="form-control" id="statutUser"  value="${etu.getStatutRecherche()}" disabled />
                                    <select class="form-control" id="statutUser2" style="display: none;">
                                        <option>En Recherche</option>
                                        <option>Non Disponible</option>
                                    </select>
                                </div>
                            </form>
                        </c:if>
                        <c:if test="${user.getTypeUtilisateur() eq 'Employeur'}">
                            <c:set var="emp" value="${empDao.findById(sessionScope['utilisateur'].getIdUtilisateur())}"/>
                            <div class="panel-heading">
                                <h4> Info Employeur</h4>
                            </div>
                            <form>
                                <div class="form-group" style="padding:1em;">
                                    <label for="statutUser">Téléphone : </label>
                                    <input type="tel" class="form-control" id="telUser"  value="${emp.getTel()}" disabled />
                                    <input type="tel" class="form-control" id="telUser2"  value="${emp.getTel()}" style="display: none;"/>
                                </div>
                            </form>
                        </c:if>
                    </div>
                    <c:if test="${user.getTypeUtilisateur() eq 'Employeur'}">
                        <c:set var="comp" value="${compDao.findById(emp.getIdCompagnie())}"/>
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4>Compagnie</h4>
                            </div>
                            <form>
                                <div class="form-group" style="padding:1em;">
                                    <label for="statutUser">Nom Compagnie : </label>
                                    <input type="text" class="form-control" id="nomComp"  value="${comp.getNom()}" disabled />
                                    <input type="text" class="form-control" id="nomComp2"  value="${comp.getNom()}" style="display: none;"/>
                                    <br/>
                                    <label for="statutUser">Site Web Compagnie : </label>
                                    <input type="text" class="form-control" id="siteComp"  value="${comp.getSiteWeb()}" disabled />
                                    <input type="text" class="form-control" id="siteComp2"  value="${comp.getSiteWeb()}" style="display: none;"/>
                                    <br />
                                    <div class="row" style="text-align: center;">
                                        <a>Afficher adresse ...</a>
                                    </div>
                                </div>
                            </form>
                        </div> 
                    </c:if>
                </div>
            </div>
        </div>
    </body>
</html>
<script type="text/javascript">
    function edit(typeUser){
        //Btn edit 
        document.getElementById("edit").style.display = "none";
        document.getElementById("editConfirm").style.display = "block";
        document.getElementById("editCancel").style.display = "block";
        
        //Info user
        document.getElementById("nomUser").style.display = "none";
        document.getElementById("nomUser2").style.display = "block";
        
        document.getElementById("prenomUser").style.display = "none";
        document.getElementById("prenomUser2").style.display = "block";
        
        document.getElementById("emailUser").style.display = "none";
        document.getElementById("emailUser2").style.display = "block";
        
        if(typeUser === "Etudiant"){
            document.getElementById("statutUser").style.display = "none";
            document.getElementById("statutUser2").style.display = "block";
        }
        if(typeUser === "Employeur"){
            document.getElementById("telUser").style.display = "none";
            document.getElementById("telUser2").style.display = "block";
        }
    }
    function cancel(typeUser){
        //Btn edit 
        document.getElementById("edit").style.display = "block";
        document.getElementById("editConfirm").style.display = "none";
        document.getElementById("editCancel").style.display = "none";
        
        //Info user
        document.getElementById("nomUser").style.display = "block";
        document.getElementById("nomUser2").style.display = "none";
        
        document.getElementById("prenomUser").style.display = "block";
        document.getElementById("prenomUser2").style.display = "none";
        
        document.getElementById("emailUser").style.display = "block";
        document.getElementById("emailUser2").style.display = "none";
        
        if(typeUser === "Etudiant"){
            document.getElementById("statutUser").style.display = "block";
            document.getElementById("statutUser2").style.display = "none";
        }
        if(typeUser === "Employeur"){
            document.getElementById("telUser").style.display = "block";
            document.getElementById("telUser2").style.display = "none";
        }
    }
</script>
