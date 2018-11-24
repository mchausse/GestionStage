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
<jsp:useBean id="adDao" class="com.stageo.dao.AdresseDAO" scope="page"></jsp:useBean>

<!-- Var User : -->
<c:if test="${!empty sessionScope['utilisateur']}">
    <c:set var="user" value="${userDao.findById(sessionScope['utilisateur'].getIdUtilisateur())}" />
</c:if>

<c:if test="${ param.action=='modifierProfil'}" > <!-- eviter des bug -->
    <c:redirect url = "do?action=afficherProfil"/>
</c:if>
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
        <form action="do?action=modifierProfil" method="post">
            <div class="col-lg-1"></div>
            <div class="col-lg-10 offset-lg-1 " style="margin-top: 10em;">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h2>
                                    Votre Profil
                                    <a onclick="edit('${user.getTypeUtilisateur()}')">
                                        <span class="glyphicon glyphicon-edit btnProfil" id="edit"></span>
                                    </a>
                                        <button type="submit" style="background:none; border:none;padding:0; float: right;">
                                        <span class="glyphicon glyphicon-ok btnProfil" id="editConfirm" style="display: none;"></span>
                                    </button>
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
                         <div class="panel panel-default"><!-- partie pour tout les utilisateur -->
                            <div class="panel-heading">
                                <h4>Informations personnels</h4>
                            </div>
                            <div class="form-group" style="padding:1em;">
                                <label for="nomUser">Nom : </label>
                                <input type="text" class="form-control" id="nomUser"  value="${user.getNom()}" disabled /> 
                                <input type="text" class="form-control" id="nomUser2" name="nomEdit" value="${user.getNom()}" style="display:none"/>  
                                <br/>
                                <label for="prenomUser">Prénom :</label>
                                <input type="text" class="form-control" id="prenomUser"  value="${user.getPrenom()}" disabled />
                                <input type="text" class="form-control" id="prenomUser2"  name="prenomEdit" value="${user.getPrenom()}" style="display:none"/>  
                                <br/>
                                <label for="emailUser">Courriel </label>
                                <input type="email" class="form-control" id="emailUser"  value="${user.getCourriel()}" disabled />
                                <input type="email" class="form-control" id="emailUser2"  name="emailEdit" value="${user.getCourriel()}" style="display:none"/>   
                                <br/>
                                <label for="typeUser">Type de votre compte : </label>
                                <input type="text" class="form-control" id="typeUser"  value="${user.getTypeUtilisateur()}" disabled />
                            </div>
                         </div>
                    </div>
                    <div class="col-lg-6 ">
                        <div class="panel panel-default"> <!-- partie pour tout les Etudiants -->
                            <c:if test="${user.getTypeUtilisateur() eq 'Etudiant'}">
                                <c:set var="etu" value="${etuDao.findById(sessionScope['utilisateur'].getIdUtilisateur())}"/>
                                <div class="panel-heading">
                                    <h4> Infomation Étudiant</h4>
                                </div>
                                <div class="form-group" style="padding:1em;">
                                    <label for="statutUser">Statut : </label>
                                    <input type="text" class="form-control" id="statutUser"  value="${etu.getStatutRecherche()}" disabled />
                                    <select class="form-control" id="statutUser2" name="statutEdit" style="display: none;">
                                        <option>En Recherche</option>
                                        <option>Non Disponible</option>
                                    </select>
                                </div>
                            </c:if>
                            <c:if test="${user.getTypeUtilisateur() eq 'Employeur'}"> <!-- partie pour tout les Employeurs -->
                                <c:set var="emp" value="${empDao.findById(sessionScope['utilisateur'].getIdUtilisateur())}"/>
                                <div class="panel-heading">
                                    <h4> Information Employeur</h4>
                                </div>
                                <div class="form-group" style="padding:1em;">
                                    <label for="statutUser">Téléphone : </label>
                                    <input type="tel" class="form-control" id="telUser"  value="${emp.getTel()}" disabled />
                                    <input type="tel" class="form-control" id="telUser2" name="telEmpEdit" value="${emp.getTel()}" style="display: none;"/>
                                </div>
                            </c:if>
                        </div>
                        <c:if test="${user.getTypeUtilisateur() eq 'Employeur'}"> <!-- partie pour la compagnie et adresse -->
                            <c:set var="comp" value="${compDao.findById(emp.getIdCompagnie())}"/>
                            <c:set var="adresse" value="${adDao.findById(comp.getIdAdresse())}" />
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h4>Compagnie</h4>
                                </div>
                                <div class="form-group" style="padding:1em;">
                                    <label for="statutUser">Nom Compagnie : </label>
                                    <input type="text" class="form-control" id="nomComp"  value="${comp.getNom()}" disabled />
                                    <input type="text" class="form-control" id="nomComp2" name="nomCompEdit" value="${comp.getNom()}" style="display: none;"/>
                                    <br/>
                                    <label for="statutUser">Site Web Compagnie : </label>
                                    <input type="text" class="form-control" id="siteComp"  value="${comp.getSiteWeb()}" disabled />
                                    <input type="text" class="form-control" id="siteComp2" name="siteCompEdit" value="${comp.getSiteWeb()}" style="display: none;"/>
                                    <br />
                                    <div class="row" style="text-align: center;">
                                        <button type="button" class="btn btn-light" id="btnAdresse" onclick='afficherAdresse()'>Afficher l'adresse</button>
                                    </div> 
                                    <div id="divAdresse" style="display: none;"> <!-- Début des champs adresse -->
                                        <label for="numAdd">Numero Civique : </label>
                                        <input type="number" class="form-control" id="numAdd"  value="${adresse.getNumeroCivique()}" disabled />
                                        <input type="number" class="form-control" id="numAdd2" name="numAdEdit" value="${adresse.getNumeroCivique()}" style="display:none;" />
                                        <br/>
                                        <label for="rueAdd">Rue : </label>
                                        <input type="text" class="form-control" id="rueAdd"  value="${adresse.getRue()}" disabled />
                                        <input type="text" class="form-control" id="rueAdd2"   name="rueAdEdit" value="${adresse.getRue()}" style="display:none;" />
                                        <br/>
                                        <label for="bureauAdd">Bureau : </label>
                                        <input type="text" class="form-control" id="bureauAdd"  value="${adresse.getBureau()}" disabled />
                                        <input type="text" class="form-control" id="bureauAdd2"  name="bureauAdEdit" value="${adresse.getBureau()}" style="display:none;" />
                                        <br/>
                                        <label for="villeAdd">Ville : </label>
                                        <input type="text" class="form-control" id="villeAdd"  value="${adresse.getVille()}" disabled />
                                        <input type="text" class="form-control" id="villeAdd2"  name="villeAdEdit" value="${adresse.getVille()}" style="display:none;" />
                                        <br/>
                                        <label for="codePostAdd">Code Postal : </label>
                                        <input type="text" class="form-control" id="codePostAdd"  value="${adresse.getCodePostal()}" disabled />
                                        <input type="text" class="form-control" id="codePostAdd2"  name="codePostAdEdit" value="${adresse.getCodePostal()}" style="display:none;" />
                                        <br/>
                                        <label for="proviceAdd">Province : </label>
                                        <input type="text" class="form-control" id="provinceAdd"  value="${adresse.getProvince()}" disabled />
                                        <input type="text" class="form-control" id="provinceAdd2"  name="provinceAdEdit" value="${adresse.getProvince()}" style="display:none;" />
                                        <br/>
                                        <label for="paysAdd">Pays : </label>
                                        <input type="text" class="form-control" id="paysAdd"  value="${adresse.getPays()}" disabled />
                                        <input type="text" class="form-control" id="paysAdd2"  name="paysAdEdit" value="${adresse.getPays()}" style="display:none;" />
                                        <br/>
                                        <label for="telAdd">Téléphone : </label>
                                        <input type="tel" class="form-control" id="telAdd"  value="${adresse.getTel()}" disabled />
                                        <input type="tel" class="form-control" id="telAdd2"  name="telAdEdit" value="${adresse.getTel()}" style="display:none;" />
                                        <br/>
                                    </div>
                                </div>
                            </div> 
                        </c:if>
                    </div>
                </div>
            </div>
        </form>
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
            //Info employeur
            document.getElementById("telUser").style.display = "none";
            document.getElementById("telUser2").style.display = "block";
            //Infos compagnie
            document.getElementById("nomComp").style.display = "none";
            document.getElementById("nomComp2").style.display = "block";
            document.getElementById("siteComp").style.display = "none";
            document.getElementById("siteComp2").style.display = "block";
            //Infos adresse
            document.getElementById("numAdd").style.display = "none";
            document.getElementById("numAdd2").style.display = "block";
            document.getElementById("rueAdd").style.display = "none";
            document.getElementById("rueAdd2").style.display = "block";
            document.getElementById("bureauAdd").style.display = "none";
            document.getElementById("bureauAdd2").style.display = "block";
            document.getElementById("villeAdd").style.display = "none";
            document.getElementById("villeAdd2").style.display = "block";
            document.getElementById("codePostAdd").style.display = "none";
            document.getElementById("codePostAdd2").style.display = "block";
            document.getElementById("provinceAdd").style.display = "none";
            document.getElementById("provinceAdd2").style.display = "block";
            document.getElementById("paysAdd").style.display = "none";
            document.getElementById("paysAdd2").style.display = "block";
            document.getElementById("telAdd").style.display = "none";
            document.getElementById("telAdd2").style.display = "block";
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
            //Info Employeur
            document.getElementById("telUser").style.display = "block";
            document.getElementById("telUser2").style.display = "none";
            //Infos compagnie
            document.getElementById("nomComp").style.display = "block";
            document.getElementById("nomComp2").style.display = "none";
            document.getElementById("siteComp").style.display = "block";
            document.getElementById("siteComp2").style.display = "none";
            //Infos adresse
            document.getElementById("numAdd").style.display = "block";
            document.getElementById("numAdd2").style.display = "none";
            document.getElementById("rueAdd").style.display = "block";
            document.getElementById("rueAdd2").style.display = "none";
            document.getElementById("bureauAdd").style.display = "block";
            document.getElementById("bureauAdd2").style.display = "none";
            document.getElementById("villeAdd").style.display = "block";
            document.getElementById("villeAdd2").style.display = "none";
            document.getElementById("codePostAdd").style.display = "block";
            document.getElementById("codePostAdd2").style.display = "none";
            document.getElementById("provinceAdd").style.display = "block";
            document.getElementById("provinceAdd2").style.display = "none";
            document.getElementById("paysAdd").style.display = "block";
            document.getElementById("paysAdd2").style.display = "none";
            document.getElementById("telAdd").style.display = "block";
            document.getElementById("telAdd2").style.display = "none";
        }
    }
    function afficherAdresse(){
        if(document.getElementById("divAdresse").style.display === "none"){
            document.getElementById("divAdresse").style.display = "block";
            document.getElementById("btnAdresse").innerHTML = "Cacher l'adresse";
        }
        else{
            document.getElementById("divAdresse").style.display = "none";
            document.getElementById("btnAdresse").innerHTML = "Afficher l'adresse";
        }
    }
</script>
