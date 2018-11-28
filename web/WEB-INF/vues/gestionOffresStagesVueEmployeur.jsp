<%-- 
    Document   : OffresStageEmployeur
    Created on : Nov 13, 2018, 7:54:34 PM
    Author     : mchausse
--%>
<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.stageo.dao.UtilisateurDAO" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!-- DAOs : -->
<jsp:useBean id="userDao" class="com.stageo.dao.UtilisateurDAO" scope="page"></jsp:useBean>
<jsp:useBean id="empDao" class="com.stageo.dao.EmployeurDAO" scope="page"></jsp:useBean>
<jsp:useBean id="offreDao" class="com.stageo.dao.OffreStageDAO" scope="page"></jsp:useBean>
<jsp:useBean id="compDao" class="com.stageo.dao.CompagnieDAO" scope="page"></jsp:useBean>

<!-- Var du User : -->
<c:if test="${!empty sessionScope['utilisateur']}">
    <c:set var="user" value="${userDao.findById(sessionScope['utilisateur'].getIdUtilisateur())}" />
    <c:set var="emp" value="${empDao.findById(sessionScope['utilisateur'].getIdUtilisateur())}" />
    <c:set var="comp" value="${compDao.findById(emp.getIdCompagnie())}"/>
</c:if>
<!-- Liste des stages de l'employeur : -->
<c:set var="listeStages" value="${offreDao.findByUserId(user.getIdUtilisateur())}" />


<html>
    <head>
        <title>Stages | Stages</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.2/css/all.css" integrity="sha384-/rXc/GQVaYpyDdyxK+ecHPVYJSN9bmVFBvjA/9eOB+pb3F2w2N6fc5qB9Ew5yIns" crossorigin="anonymous">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="./css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <!-- Barre de navigation -->
        <%@include  file="menu.jsp" %>
        <!-- Fin de la barre de navigation -->
        
        <!-- Contenu de la page --> 
        <div class='container-fluid'>
            <div id="contenuPage">
                
                <!-- Titre de la page -->
                <div class="row">
                    <div class="col-lg-1"></div><!-- Sert de margin -->
                    <div class="col-lg-4">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3>
                                    <span id='btnDescTitrePage' class='glyphicon glyphicon-triangle-bottom'></span>
                                    Gestion des offres de stage
                                   <!-- TEST : <c:out value="${user.getIdUtilisateur()}" /> -->
                                   <!-- TEST : <c:out value="${fn:length(listeStages)}" /> -->
                                </h3>
                                <p id='descTitrePage'>
                                    Ici, vous pouvez voir vos offres que vous avez publiées, 
                                    ainsi qu'en ajouter des nouvelles ou  modifier et désactive ceux déjà existantes.
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Fin du titre de la page-->
                
                <div class="col-lg-1"></div><!-- Sert de margin -->
                
                <!-- Debut de la section du menu des stages -->
                <div class="col-lg-2">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Menu
                        </div>
                        
                        <!-- Liste des options du menu -->
                        <div class="panel-body">
                            <div class="col-lg-12">
                                <a href="#" class="btn btn-default btn-lg btnMenu" id='btnAjouterStage'>
                                    <span class="glyphicon glyphicon-plus"> Ajouter</span>
                                </a>
                            </div>
                        </div>
                        <!-- Fin de la liste des options du menu -->
                        
                    </div>
                </div>
                <!-- Fin de la section du menu des stages -->
                
                <!-- Debut de la section des stages -->
                <div class="col-lg-7">
                    
                    <!--  Formulaire d'ajout de stage -->
                    <div id="ajouterStage">
                        <form action="do?action=createStage" method="post">
                            <!-- Debut d'une offre -->
                            <div class="panel panel-default">

                                <div class="panel-heading">
                                    <!-- Pour afficher un voyant de couleur -->
                                    <span class="label label-default label-as-badge">&#8203 &#8203</span>
                                    <div class='row'>
                                        <div class="col-lg-8">
                                            <div class="col-lg-8">
                                                <input type="text" class="form-control" id="nom" placeholder="Titre" name="titreStage">
                                            </div>
                                        </div>
                                        <div class="col-lg-3">Status : Creation</div>
                                    </div>
                                </div>

                                <div class="panel-body">
                                    <div class='row'>
                                        <!-- Premiere section de l'offre-->
                                        <div class="col-lg-4">
                                            <div class="col-sm-11 input-group">
                                                <label class="input-group-btn">
                                                    <span class="btn btn-primary">
                                                        Ajouter
                                                        <input type="file" lass="form-control-file" accept="application/pdf" style="display: none;" name="docuStage">
                                                    </span>
                                                </label>
                                                <input type="text" class="form-control" readonly id="relNoteNom">
                                            </div>
                                        </div>
                                        <div class="col-lg-4">
                                            <input type="text" class="form-control" id="nom" placeholder="www.votreLien.ca" name="lienStage">
                                        </div>
                                        <div class="col-lg-4">
                                            Vue : 0
                                        </div>
                                        <!-- Deuxieme section de l'offre-->
                                        <div class="col-lg-12">
                                            <span onclick="ouvrirDesc()" class='glyphicon glyphicon-triangle-bottom'></span>
                                            Description
                                            <textarea class="form-control" rows="3" name="descStage"></textarea>
                                        </div>
                                        <!-- Troisième section de l'offre-->
                                        <div class="col-lg-12" style="margin-top: 1em;">
                                            <div class="col-lg-4" style="margin-top: 1.4em;"> 
                                                <input type="submit" value="Créer" class="btn btn-primary btnAnime" style="width: 10em;"/>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- Fin d'une offre -->
                            <hr />
                        </form>
                    </div>
                    <!--  Fin du formulaire d'ajout de stage -->
                    <c:forEach items="${listeStages}" var="item">
                        <!-- Debut d'une offre -->
                        <div class="panel panel-default">

                            <div class="panel-heading">
                                <!-- Pour afficher un voyant de couleur -->
                                <!-- Tester le statut ici -->
                                <span class="label label-success label-as-badge">&#8203 &#8203</span>
                                <div class='row'>
                                    <div class="col-lg-12 dateStage">Publié le ${item.getDate()}</div>
                                    <div class="col-lg-8"><kbd>${comp.getNom()}</kbd> ${item.getTitre()}</div>
                                    <div class="col-lg-3">Status : Active</div>
                                    <a href="#" class="btn btn-default btn-md btnModStage">
                                        <span class="glyphicon glyphicon-pencil"></span>
                                    </a>
                                </div>
                            </div>

                            <div class="panel-body">
                                <div class='row'>
                                    <!-- Premiere section de l'offre-->
                                    <div class="col-lg-4">
                                        <a href="${item.getLienDocument()}">LienDocument.txt</a>
                                    </div>
                                    <div class="col-lg-4">
                                        <a href="https://${item.getLienWeb()}">LienWeb</a>
                                    </div>
                                    <div class="col-lg-4">
                                        Vue : ${item.getNbVues()}
                                    </div>
                                    <!-- Deuxieme section de l'offre-->
                                    <div class="col-lg-12">
                                        <span onclick="ouvrirDesc()" class='glyphicon glyphicon-triangle-bottom'></span>
                                        Description :
                                        <textarea class="form-control" rows="3" disabled>${item.getDescription()}</textarea>
                                        
                                        <!--<pre id='descriptionXX'></pre>-->
                                    </div>
                                </div>
                            </div>

                        </div>
                        <!-- Fin d'une offre -->
                    </c:forEach>
                </div>
                <!-- Fin de la section des stages -->
                
                
            </div>
        </div>
        <!-- Fin du contenu de la page -->
        
        <!-- Footer -->
        <%@include  file="footer.jsp" %>
        <!-- Fin footer -->
        
        <script>
            $(document).ready(function(){
                // Cacher le formulaire de stage
                $("#ajouterStage").hide();
                $("#descTitrePage").hide();
                
                // === Assigner les actions de clicks ===
                // Pour le bouton ajouter
                $("#btnAjouterStage").click(function(){
                    if(!$("#ajouterStage").is(":hidden")){
                        $("#ajouterStage").hide(300);
                        // Changer la classe pour changer le signe du bouton
                        $("#btnAjouterStage").html("<span class='glyphicon glyphicon-plus'> Ajouter</span>");
                    }else{
                        $("#ajouterStage").show(300);
                        // Changer la classe pour changer le signe du bouton
                        $("#btnAjouterStage").html("<span class='glyphicon glyphicon-arrow-left'> Annuler</span>");
                    }
                });
                // Pour le bouton de description du titre
                $("#btnDescTitrePage").click(function(){
                    if($("#btnDescTitrePage").is(".glyphicon-triangle-bottom")){
                        // Faire apparaitre la desc
                        $("#descTitrePage").show(500);
                        // Changer la classe pour changer le signe du bouton
                        $("#btnDescTitrePage").removeClass("glyphicon-triangle-bottom");
                        $("#btnDescTitrePage").addClass('glyphicon-triangle-top');
                    }else{
                        $("#descTitrePage").hide(300);
                        // Changer la classe pour changer le signe du bouton
                        $("#btnDescTitrePage").removeClass("glyphicon-triangle-top");
                        $("#btnDescTitrePage").addClass('glyphicon-triangle-bottom');
                    }
                });
            });
        </script>
    </body>
</html>
