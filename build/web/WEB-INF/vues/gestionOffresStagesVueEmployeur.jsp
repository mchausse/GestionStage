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

<!-- pour eviter les double submits : -->
<c:if test="${ param.action!='afficherGestionOffresStagesVueEmployeur'}" >
    <c:redirect url = "do?action=afficherGestionOffresStagesVueEmployeur"/>
</c:if>

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
        
        <!-- Contenu de la page --> 
        <div class='container-fluid'>
            <div id="contenuPage">
                <!-- Si il y a un message à montrer -->
                <c:if test="${ !empty sessionScope['avertissement']}" >
                    <c:set var = "avert" value = "${sessionScope['avertissement']}"/>
                    <c:remove var="avertissement" scope="session" />
                    <div class="row">
                        <div class="col-lg-1"></div>
                        <div class="col-lg-10">
                            <c:if test="${ avert.getType()=='erreur' && avert!=''}" > <!-- si cest une erreur -->
                                <div class="alert alert-danger">
                                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                                    <strong>Erreur!</strong> ${avert.getMessage()}
                                </div>
                            </c:if>
                            <c:if test="${ avert.getType()=='succes' && avert!=''}" > <!-- si cest un succes -->
                                <div class="alert alert-success">
                                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                                    <strong>Succès!</strong> ${avert.getMessage()}
                                </div>
                            </c:if>
                        </div>
                    </div>
                </c:if>
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
                                   <!--<c:if test="${ !empty sessionScope['avertissement']}" >MARCHE</c:if>-->
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
                        <form action="do?action=createOffre" method="post">
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
                    
                    <!-- Affiche les offres de l'employeur -->
                    <c:forEach items="${listeStages}" var="item">
                        <!-- Debut d'une offre -->
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <!-- Pour afficher un voyant de couleur -->
                                <c:if test="${item.getActive() eq true}">
                                    <span class="label label-success label-as-badge">&#8203 &#8203</span>
                                </c:if>
                                <c:if test="${item.getActive() eq false}">
                                    <span class="label label-danger label-as-badge">&#8203 &#8203</span>
                                </c:if>
                                <div class='row'>
                                    <div class="col-lg-12 dateStage">Publié le ${item.getDate()}</div>
                                    <div class="col-lg-7">
                                        <!-- Affichage titre -->
                                        <div id="${item.getIdOffre()}TitreAff">
                                            <kbd>${comp.getNom()}</kbd> 
                                            <a href="?action=afficherListeCandidatureOffreStage&offreStage=${item.getIdOffre()}">${item.getTitre()}</a>
                                        </div>
                                        <!-- Titre Edit -->
                                        <div id="${item.getIdOffre()}TitreEdit" style="display:none;">
                                            <div class="col-lg-3">
                                                <kbd>${comp.getNom()}</kbd> 
                                            </div>
                                            <div class="col-lg-9">
                                                <input type="text" class="form-control" placeholder="Titre" value="${item.getTitre()}">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-3"> <!--Affiche le Active -->
                                        <div id="${item.getIdOffre()}ActiveAff">
                                            Status : 
                                            <c:if test="${item.getActive() eq true}">
                                                Active
                                            </c:if>
                                            <c:if test="${item.getActive() eq false}">
                                                Inactive
                                            </c:if>
                                        </div>
                                        <!-- Edit le Active et faire que sa change selon le Active de l'item -->
                                        <select class="form-control" id="${item.getIdOffre()}ActiveEdit" name="activeEdit" style="display: none;">
                                            <c:if test="${item.getActive() eq true}">
                                                <option selected>Active</option>
                                                    <option>Inactive</option>
                                            </c:if>
                                            <c:if test="${item.getActive() eq false}">
                                                    <option>Active</option>
                                                    <option selected>Inactive</option>
                                            </c:if>
                                        </select>
                                    </div>
                                    <!-- Les BTNs : -->
                                    <div class="col-lg-2">
                                        <!-- BTN avant de edit -->
                                        <div id="${item.getIdOffre()}BtnAvEdit">
                                            <a onclick="modifOffre('${item.getIdOffre()}')" class="btn btn-default btn-md btnModStage btnAnime">
                                                <span class="glyphicon glyphicon-pencil"></span>
                                            </a>
                                            <a href="do?action=deleteOffre&id=${item.getIdOffre()}" class="btn btn-default btn-md btnModStage btnAnime">
                                                <span class="glyphicon glyphicon-trash"></span>
                                            </a>
                                        </div>
                                        <!-- BTN apres de edit -->
                                        <div id="${item.getIdOffre()}BtnApEdit" style="display:none; margin-top: 0.9em;">
                                            <a onclick="cancelModif('${item.getIdOffre()}')" class="btn btn-default btn-md btnModStage btnAnime">
                                                <span class="glyphicon glyphicon-remove btnAnime"></span>
                                            </a>
                                            <a href="do?action=editOffre&id=${item.getIdOffre()}" class="btn btn-default btn-md btnModStage btnAnime">
                                                <span class="glyphicon glyphicon-ok"></span>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="panel-body">
                                <div class='row'>
                                    <!-- Premiere section de l'offre-->
                                    <div class="col-lg-4">
                                        <!--Document Affichage -->
                                        <a href="${item.getLienDocument()}" id="${item.getIdOffre()}DocAff">
                                            LienDocument.txt
                                        </a>
                                        <!--Document Edit -->
                                        <button type="file" id="${item.getIdOffre()}DocEdit" class="btn btn-primary btnAnime" style="display: none;">
                                            Changer de fichier ...
                                        </button>
                                    </div>
                                    <div class="col-lg-4">
                                        <!--Lien affichage -->
                                        <a href="https://${item.getLienWeb()}" id="${item.getIdOffre()}SiteAff">
                                            ${item.getLienWeb()}
                                        </a>
                                        <!--Lien Edit -->
                                        <input type="text" id="${item.getIdOffre()}SiteEdit" class="form-control" 
                                               placeholder="www.votreLien.ca" value="${item.getLienWeb()}" 
                                               style="display:none;">
                                    </div>
                                    <div class="col-lg-4">
                                        Vue : ${item.getNbVues()}
                                    </div>
                                    <!-- Deuxieme section de l'offre-->
                                    <div class="col-lg-12">
                                        <span onclick="ouvrirDesc()" class='glyphicon glyphicon-triangle-bottom'></span>
                                        Description :
                                        <!--Description Affichage -->
                                        <textarea id="${item.getIdOffre()}DescAff" class="form-control" rows="3" disabled>${item.getDescription()}</textarea>
                                        <!--Description Edit -->
                                        <textarea id="${item.getIdOffre()}DescEdit" class="form-control" rows="3" style="display:none;" Enabled>${item.getDescription()}</textarea>
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
        <script type="text/javascript">
            function modifOffre(idOffre){
                //Active
                document.getElementById((idOffre+"ActiveAff")).style.display = "none";
                document.getElementById((idOffre+"ActiveEdit")).style.display = "block";
                //BTNs
                document.getElementById((idOffre+"BtnAvEdit")).style.display = "none";
                document.getElementById((idOffre+"BtnApEdit")).style.display = "block";
                //Titre
                document.getElementById((idOffre+"TitreAff")).style.display = "none";
                document.getElementById((idOffre+"TitreEdit")).style.display = "block";
                //Description
                document.getElementById((idOffre+"DescAff")).style.display = "none";
                document.getElementById((idOffre+"DescEdit")).style.display = "block";
                //SiteWeb
                document.getElementById((idOffre+"SiteAff")).style.display = "none";
                document.getElementById((idOffre+"SiteEdit")).style.display = "block";
                //Document
                document.getElementById((idOffre+"DocAff")).style.display = "none";
                document.getElementById((idOffre+"DocEdit")).style.display = "block";
            }
            function cancelModif(idOffre){
                //Active
                document.getElementById((idOffre+"ActiveAff")).style.display = "block";
                document.getElementById((idOffre+"ActiveEdit")).style.display = "none";
                //BTNs
                document.getElementById((idOffre+"BtnAvEdit")).style.display = "block";
                document.getElementById((idOffre+"BtnApEdit")).style.display = "none";
                //Titre
                document.getElementById((idOffre+"TitreAff")).style.display = "block";
                document.getElementById((idOffre+"TitreEdit")).style.display = "none";
                //Description
                document.getElementById((idOffre+"DescAff")).style.display = "block";
                document.getElementById((idOffre+"DescEdit")).style.display = "none";
                //SiteWeb
                document.getElementById((idOffre+"SiteAff")).style.display = "block";
                document.getElementById((idOffre+"SiteEdit")).style.display = "none";
                //Document
                document.getElementById((idOffre+"DocAff")).style.display = "block";
                document.getElementById((idOffre+"DocEdit")).style.display = "none";
            }
        </script>
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
