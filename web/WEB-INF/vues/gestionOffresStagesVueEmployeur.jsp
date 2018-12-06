<%-- 
    Document   : gestionOffresStagesVueEmployeur
    Created on : 2018-11-27, 11:57:50
    Author     : gabri
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
<jsp:useBean id="crDao" class="com.stageo.dao.CritereDAO" scope="page"></jsp:useBean>
<jsp:useBean id="offreCritDao" class="com.stageo.dao.OffreStageCritereDAO" scope="page"></jsp:useBean>
<c:set var="listCrit" value="${crDao.findAll()}"/>

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
                <div id="OffreAff">
                <div class="col-lg-7">
                    <!--  Formulaire d'ajout de stage -->
                    <div id="ajouterStage">
                        <form action="do?action=createOffre" method="post" enctype="multipart/form-data">
                            <!-- Debut d'une offre -->
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <!-- Pour afficher un voyant de couleur -->
                                    <span class="label label-default label-as-badge">&#8203 &#8203</span>
                                    <div class='row'>
                                        <div class="col-lg-8">
                                            <div class="col-lg-8">
                                                <input type="text" class="form-control" id="nom" placeholder="Titre" name="titreStage" required>
                                            </div>
                                        </div>
                                        <div class="col-lg-3"><b>Statut :</b> Creation</div>
                                    </div>
                                </div>

                                <div class="panel-body">
                                    <div class='row'>
                                        <!-- Premiere section de l'offre-->
                                        <div class="col-lg-4">
                                            <input type="file" accept="application/pdf" name="docuStage">
                                        </div>
                                        <div class="col-lg-4">
                                            <input type="text" class="form-control" id="nom" placeholder="www.votreLien.ca" name="lienStage">
                                        </div>
                                        <div class="col-lg-4">
                                            <div class="col-lg-6" style="margin-top:0.5em;">
                                                Rémunération :
                                            </div>
                                            <div class="col-lg-6">
                                                <select class="form-control" name="remunere">
                                                    <option>Oui</option>
                                                    <option>Non</option>
                                                </select>
                                            </div>
                                         </div>
                                        <!-- Deuxieme section de l'offre-->
                                        <div class="col-lg-6">
                                            Description
                                            <textarea class="form-control" rows="3" name="descStage"></textarea>
                                        </div>
                                        <div class="col-lg-5 infoEtuRow" style="margin-top:0.5em;">
                                            <label for="conteneurCompetences">Compétences :</label>
                                            <div class="btn-group">
                                                <span class="glyphicon glyphicon-plus dropdown-toggle" data-toggle="dropdown"></span>
                                                <ul class="dropdown-menu" role="menu">
                                                    <c:forEach items="${listCrit}" var="critere">
                                                        <li class="critere"><a href="#" onclick="ajouterComp('${critere.nom}')">${critere.nom}</a></li>
                                                    </c:forEach>
                                                </ul>
                                            </div>
                                            <div class="panel panel-default" id="conteneurCompetencesEdit" style="padding: 1em;"></div>
                                        </div>
                                        <!-- Troisième section de l'offre-->
                                        <div class="col-lg-12" style="margin-top: 1em;">
                                            <div class="col-lg-6">
                                                <div class="col-lg-4 labDate">Date de debut :</div>
                                                <div class="col-lg-8">
                                                    <input type="date" class="form-control datePick" name="dateDebut" required/>
                                                </div>
                                            </div>
                                            <div class="col-lg-6">
                                                <div class="col-lg-4 labDate">Date de fin : </div>
                                                <div class="col-lg-8">
                                                    <input type="date" class="form-control datePick" name="dateFin" required/>
                                                </div>
                                            </div>
                                            <!--Quatrième section-->
                                            <div class="col-lg-12" style="margin-top: 1em;">
                                                <div class="col-lg-4" style="margin-top: 1.4em;"> 
                                                    <input type="submit" value="Créer" class="btn btn-primary btnAnime" style="width: 10em;"/>
                                                </div>
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
                        <form action="do?action=editOffre&id=${item.getIdOffre()}" method="post">
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
                                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 dateStage">Publié le ${item.getDate()}</div>
                                        <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
                                            <!-- Affichage titre -->
                                            <div id="${item.getIdOffre()}TitreAff">
                                                <kbd>${comp.getNom()}</kbd> 
                                                ${item.getTitre()}
                                            </div>
                                            <!-- Titre Edit -->
                                            <div id="${item.getIdOffre()}TitreEdit" style="display:none;">
                                                <div class="col-lg-9 col-md-9 col-sm-9 col-xs-12">
                                                    <input type="text" class="form-control" placeholder="Titre" name="${item.getIdOffre()}TitreEdit" value="${item.getTitre()}">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-lg-2 col-md-2 col-sm-2 col-xs-12"> <!--Affiche le Active -->
                                            <div id="${item.getIdOffre()}ActiveAff">
                                                <b>Statut :</b> 
                                                <c:if test="${item.getActive() eq true}">
                                                    Active
                                                </c:if>
                                                <c:if test="${item.getActive() eq false}">
                                                    Inactive
                                                </c:if>
                                            </div>
                                            <!-- Edit le Active et faire que sa change selon le Active de l'item -->
                                            <select class="form-control" id="${item.getIdOffre()}ActiveEdit" name="${item.getIdOffre()}ActiveEdit" style="display: none;">
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
                                        <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
                                            <!-- Remunerer Affichage -->
                                            <div id="${item.getIdOffre()}RemunereAff">
                                                <c:if test="${item.getRemunere() eq true}">
                                                    <b>Remunéré:</b> Oui
                                                </c:if>
                                                <c:if test="${item.getRemunere() eq false}">
                                                    <b>Remunéré:</b> Non
                                                </c:if>
                                            </div>
                                            <div id="${item.getIdOffre()}RemunereEdit" style="display:none;">
                                            <!-- Remunere Edit-->
                                            <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12" style="margin-top:0.5em; text-align: right;">
                                                <b>Remunéré:</b>
                                            </div>
                                            <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                                <select class="form-control" name="${item.getIdOffre()}RemunereEdit">
                                                    <option>Oui</option>
                                                    <option>Non</option>
                                                </select>
                                            </div>
                                            </div>
                                        </div>
                                        <!-- Les BTNs : -->
                                        <div class="col-lg-2 col-md-2 col-sm-2 col-xs-12">
                                            <!-- BTN avant de edit -->
                                            <div id="${item.getIdOffre()}BtnAvEdit">
                                                <a onclick="modifOffre('${item.getIdOffre()}')" class="btn btn-default btn-md btnModStage btnAnime">
                                                    <span class="glyphicon glyphicon-pencil"></span>
                                                </a>
                                                <a onclick="confirmDelete('${item.getIdOffre()}')"class="btn btn-default btn-md btnModStage btnAnime">
                                                    <span class="glyphicon glyphicon-trash"></span>
                                                </a>
                                                <a href="do?action=afficherListeCandidatureOffreStage&offreStage=${item.getIdOffre()}" class="btn btn-default btn-md btnModStage btnAnime">
                                                    <span class="glyphicon glyphicon-eye-open"></span>
                                                </a>
                                            </div>
                                            <!-- BTN apres de edit -->
                                            <div id="${item.getIdOffre()}BtnApEdit" style="display:none; margin-top: 0.9em;">
                                                <a onclick="cancelModif('${item.getIdOffre()}')" class="btn btn-default btn-md btnModStage btnAnime">
                                                    <span class="glyphicon glyphicon-remove btnAnime"></span>
                                                </a>
                                                <button type="submit" class="btn btn-default btn-md btnModStage btnAnime">
                                                    <span class="glyphicon glyphicon-ok"></span>
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="panel-body">
                                    <div class='row'>
                                        <!-- Premiere section de l'offre-->
                                        <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 alignCenter">
                                            <!--Document Affichage MARCHE PAS !!-->
                                            <a target="_blank" href="do?action=readStageDocu&id=${item.getIdOffre()}" id="${item.getIdOffre()}DocAff">
                                                Ouvrir Document...
                                            </a>
                                            <!--Document Edit -->
                                            <button type="file" id="${item.getIdOffre()}DocEdit" class="btn btn-primary btnAnime" style="display: none;">
                                                Changer de fichier ...
                                            </button>
                                        </div>
                                        <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 alignCenter">
                                            <!--Lien affichage -->
                                            <a target="_blank" href="${item.getLienWeb()}" id="${item.getIdOffre()}SiteAff">
                                                ${item.getLienWeb()}
                                            </a>
                                            <!--Lien Edit -->
                                            <input type="text" id="${item.getIdOffre()}SiteEdit" class="form-control" 
                                                   placeholder="www.votreLien.ca" value="${item.getLienWeb()}" 
                                                   style="display:none;" name="${item.getIdOffre()}LienWebEdit" />
                                        </div>
                                        <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 alignCenter">
                                            Vue : ${item.getNbVues()}
                                        </div>
                                        <!-- Deuxieme section de l'offre-->
                                        <div class="col-lg-6 col-md-6 col-sm-6">
                                            <span onclick="ouvrirDesc()" class='glyphicon glyphicon-triangle-bottom'></span>
                                            Description :
                                            <!--Description Affichage -->
                                            <textarea id="${item.getIdOffre()}DescAff" class="form-control" rows="3" disabled
                                                      >${item.getDescription()} 
                                            </textarea> <!-- Obliger de mettre le > sur la meme ligne sinon affichage Fucked -->
                                            <!--Description Edit -->
                                            <textarea id="${item.getIdOffre()}DescEdit" name="${item.getIdOffre()}DescEdit" class="form-control" rows="3" style="display:none;" Enabled
                                                      >${item.getDescription()}</textarea>
                                        </div>
                                        <!-- Critere Affichage -->
                                        <div id="${item.getIdOffre()}CritAff" class="col-lg-6 col-md-12 col-sm-12 col-xs-12">
                                            <c:set var="listCritByOffre" value="${offreCritDao.findByOffrePK(item.getIdOffre())}"/>
                                            <label for="conteneurCompetences">Compétences : <span class='competence alert alert-info'>${listCritByOffre.size()}</span></label>
                                            <div  class="panel panel-default" id="conteneurCompetences">
                                                <div class="panel-body">
                                                    <c:forEach items="${listCritByOffre}"   var="critOffre">
                                                        <c:set var="critere" value="${crDao.findById(critOffre.getIdCritere())}"/>
                                                        <span class='competence alert alert-info'>${critere.nom}</span>
                                                    </c:forEach> 
                                                </div>
                                            </div>
                                        </div>
                                        <!-- Critere Edit -->
                                        <div id="${item.getIdOffre()}CritEdit" class="col-lg-6 col-md-12 col-sm-12 col-xs-12" style="margin-top:0.5em; display: none;">
                                            <label for="conteneurCompetences">Compétences :</label>
                                            <div class="btn-group">
                                                <span class="glyphicon glyphicon-plus dropdown-toggle btnAddComp" data-toggle="dropdown"></span>
                                                <ul class="dropdown-menu" role="menu">
                                                    <c:forEach items="${listCrit}" var="critere">
                                                        <li class="critere"><a href="#" onclick="ajouterCompEdit('${critere.nom}', '${item.getIdOffre()}')">${critere.nom}</a></li>
                                                    </c:forEach>
                                                </ul>
                                            </div>
                                            <div  class="panel panel-default" id="${item.getIdOffre()}ConteneurCritEdit" style="padding-bottom: 1em;">
                                                <div class="panel-body">
                                                    <c:forEach items="${listCritByOffre}" var="critOffre">
                                                        <c:set var="critere" value="${crDao.findById(critOffre.getIdCritere())}"/>
                                                        <span class='competence alert alert-info' id="${item.getIdOffre()}${critere.nom}">
                                                            ${critere.nom}
                                                            <a class='glyphicon glyphicon-remove btnAnime' onclick='enleverCompetence("${item.getIdOffre()}${critere.nom}")'></a>
                                                            <input class="form-control" type="hidden" id="competence${critere.nom}" name="${critere.nom}">
                                                        </span>
                                                    </c:forEach>
                                                </div>
                                            </div>
                                        </div>
                                        <div>
                                            <!-- Date affichage -->
                                            <div class="col-lg-12 col-md-12 col-sm-12" id="${item.getIdOffre()}DateAff">
                                                <div class="col-lg-4 col-md-4  col-sm-4 dateAff" style="margin-top:1em;">
                                                    <b>Debut :</b> ${item.getDateDebut()}
                                                </div>
                                                <div class="col-lg-4 col-md-4 col-sm-4 dateAff" style="margin-top:1em;">
                                                    <b>Fin :</b> ${item.getDateFin()}
                                                </div>
                                                <div class="col-lg-4 col-md-4 col-sm-4 dateAff">
                                                    <c:if test="${item.getDureeEnJours() > 1}" >
                                                        <b>Nombre de jours :</b> ${item.getDureeEnJours()}
                                                    </c:if>
                                                    <c:if test="${item.getDureeEnJours() < 2}" >
                                                        <b>Nombre de jour :</b> ${item.getDureeEnJours()}
                                                    </c:if>
                                                </div>
                                            </div>
                                            <!-- Date Edit-->
                                            <div class="col-lg-12 col-md-12 col-sm-12" id="${item.getIdOffre()}DateEdit" style="margin-top: 1em; display: none;">
                                                <div class="col-lg-6 col-md-6">
                                                    <div class="col-lg-4 col-md-4 col-sm-4 labDate">Date de debut :</div>
                                                    <div class="col-lg-8 col-md-8 col-sm-8">
                                                        <input type="date" class="form-control datePick" name="${item.getIdOffre()}DateDebutEdit" value="${item.getDateDebut()}"required/>
                                                    </div>
                                                </div>
                                                <div class="col-lg-6 col-md-6 col-sm-6">
                                                    <div class="col-lg-4 col-md-4 labDate">Date de fin : </div>
                                                    <div class="col-lg-8 col-md-8">
                                                        <input type="date" class="form-control datePick" name="${item.getIdOffre()}DateFinEdit" value="${item.getDateFin()}"required/>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </div>
                        <!-- Fin d'une offre -->
                        </form>
                    </c:forEach>
                </div>
                <!-- Fin de la section des stages -->
            </div>
            </div>
        </div>
        <!-- Fin du contenu de la page -->
        
        <!-- Footer -->
        <%@include  file="footer.jsp" %>
        <!-- Fin footer -->
        <script type="text/javascript">
            function confirmDelete(idOffre){
                var question = window.confirm("Êtes-vous sur de vouloir supprimer cette offre?");
                if (question) {
                    window.location.href = "do?action=deleteOffre&id="+idOffre+"";
                }
            }
            function ajouterComp(id){
                if(document.getElementById(id)=== null){
                    document.getElementById("conteneurCompetencesEdit").innerHTML += "<span class='competence' id='"+id+"'>"+id+" <a class='glyphicon glyphicon-remove' onclick='enleverCompetence(" + '"' + id + '"' + ")'></a><input class='form-control' type='hidden' id='competence" + id +"'" +" name='"+id+"'></span>";
                    $(".competence").addClass("alert alert-info");
                }
            }
            function ajouterCompEdit(id, idOffre){
                if(document.getElementById(idOffre+id)=== null){
                    document.getElementById(idOffre+"ConteneurCritEdit").innerHTML += "<span class='competence' id='"+id+"'>"+id+" <a class='glyphicon glyphicon-remove' onclick='enleverCompetence(" + '"' + id + '"' + ")'></a><input class='form-control' type='hidden' id='competence" + id +"'" +" name='"+id+"'></span>";
                    $(".competence").addClass("alert alert-info");
                }
            }
            function enleverCompetence(id){
                document.getElementById(id).remove();   
            }
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
                //Dates
                document.getElementById((idOffre+"DateAff")).style.display = "none";
                document.getElementById((idOffre+"DateEdit")).style.display = "block";
                //Remunere
                document.getElementById((idOffre+"RemunereAff")).style.display = "none";
                document.getElementById((idOffre+"RemunereEdit")).style.display = "block";
                //Critere
                document.getElementById((idOffre+"CritAff")).style.display = "none";
                document.getElementById((idOffre+"CritEdit")).style.display = "block";
                
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
                //Dates
                document.getElementById((idOffre+"DateAff")).style.display = "block";
                document.getElementById((idOffre+"DateEdit")).style.display = "none";
                //Remunere
                document.getElementById((idOffre+"RemunereAff")).style.display = "block";
                document.getElementById((idOffre+"RemunereEdit")).style.display = "none";
                //Critere
                document.getElementById((idOffre+"CritAff")).style.display = "block";
                document.getElementById((idOffre+"CritEdit")).style.display = "none";
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
