<%-- 
    Document   : profilOffreStage
    Created on : 2018-11-30, 12:56:02
    Author     : usager
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="compagnieDAO" class="com.stageo.dao.CompagnieDAO" scope="page"/>
<jsp:useBean id="employeurDAO" class="com.stageo.dao.EmployeurDAO" scope="page"/>
<jsp:useBean id="utilisateurDAO" class="com.stageo.dao.UtilisateurDAO" scope="page"/>
<jsp:useBean id="candidatureDAO" class="com.stageo.dao.CandidatureDAO" scope="page"/>
<jsp:useBean id="offreStageCritereDAO" class="com.stageo.dao.OffreStageCritereDAO" scope="page"/>
<jsp:useBean id="critereDAO" class="com.stageo.dao.CritereDAO" scope="page"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="./css/style.css" rel="stylesheet" type="text/css"/>
        <title>Stagéo | Profil d'offre de stage</title>
    </head>
    <body>
        <%@include  file="menu.jsp" %>
        <c:if test="${requestScope.offreStage != null}">
            <!-- Titre -->
            <div class="container-fluid candidature">
                <div class="row">
                    <div class="col-lg-6">
                        <h1>Offre: ${offreStage.getTitre()}</h1>
                    </div>
                    <div class="col-lg-6">
                        <div class="text-right">
                            Nombre de vues: ${offreStage.getNbVues()}
                        </div>
                    </div>
                </div>
                <br />
                <div class="row panel panel-default">
                    <div class="panel-heading sousTitre">
                        Information
                    </div>
                    <div class="panel-body infoCon">
                        <c:set var="employeur" value="${utilisateurDAO.findById(offreStage.getIdEmployeur())}" />
                        <c:set var="compagnie" value="${compagnieDAO.findById(employeurDAO.findById(offreStage.getIdEmployeur()).getIdCompagnie())}" />
                        <div class='col-lg-6 col-xs-12'>
                            <label class='titreop'>Nom compagnie:</label>
                            <div class="divInfoEleve2">
                                ${compagnie.getNom()}
                            </div>
                            <label class='titreop'>Nom employeur:</label>
                            <div class="divInfoEleve2">
                                ${employeur.getPrenom()} ${employeur.getNom()}
                            </div>
                            <label class='titreop'>Description:</label>
                            <div class="divInfoEleve2">
                                ${offreStage.getDescription()}
                            </div>
                            <label class='titreop'>Critere:</label>
                            <div class="divInfoEleve2">
                                <c:if test="${offreStageCritereDAO.findByIdOffre(offreStage.getIdOffre()).size() == 0}">
                                    Il n'y a pas de critères qui sont demandé pour cette offre !
                                </c:if>
                                <c:forEach var="offreCritere" items="${offreStageCritereDAO.findByIdOffre(offreStage.getIdOffre())}">
                                    <c:set var="critere" value="${critereDAO.findById(offreCritere.getOffrestagecriterePK().getIdCritere())}" />
                                    <span class='compoff'>${critere.getNom()}</span>
                                </c:forEach>
                            </div>
                        </div>
                        <div class='col-lg-6 col-xs-12 buttonop'>
                            <label class='titreop'>Date de début:</label>
                            <div class="divInfoEleve2">
                                ${offreStage.getDateDebut()}
                            </div>
                            <label class='titreop'>Date de fin:</label>
                            <div class="divInfoEleve2">
                                ${offreStage.getDateFin()}
                            </div>
                            <label class='titreop'>Durée du stage:</label>
                            <div class="divInfoEleve2">
                                ${offreStage.getDureeEnJours()}
                            </div>
                            <label class='titreop'>Rémunere:</label>
                            <div class="divInfoEleve2">
                                ${(offreStage.getRemunere())?"Oui":"Non"}
                            </div>
                            <label class='titreop'>Lien web:</label>
                            <div class="divInfoEleve2">

                                <c:if test="${offreStage.getLienWeb()!=null}">
                                        ${offreStage.getLienWeb()}
                                </c:if>
                                <c:if test="${offreStage.getLienWeb()==null || offreStage.getLienWeb() eq '' }">
                                        Il n'y a pas de document pour cette offre !
                                </c:if>
                            </div>
                            <label class='titreop'>Lien document:</label>
                            <div class="divInfoEleve2">
                                <c:if test="${offreStage.getLienDocument()!=null}">
                                        ${offreStage.getLienDocument()}
                                </c:if>
                                <c:if test="${offreStage.getLienDocument()==null || offreStage.getLienDocument() eq '' }">
                                        Il n'y a pas de document pour cette offre !
                                </c:if>
                            </div>
                        </div>
                        <div class='row'>
                            <div>
                                <c:set var="candidature" value="${candidatureDAO.findById(sessionScope['utilisateur'].getIdUtilisateur(), offreStage.getIdOffre())}" />
                                <c:if test="${sessionScope.utilisateur.getTypeUtilisateur() eq 'Etudiant' && candidature == null}">
                                    <button class="btn btn-danger dropdown-toggle btn-sm btnPostuler" type="button" data-toggle="dropdown">Postuler</button>
                                </c:if>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </c:if>
        <c:if test="${requestScope.offreStage == null}">
            <div class="container-fluid candidature">
               <h1>L'offre de stage que vous tentez d'accès n'existe pas !</h1>
            </div>
        </c:if>
    </body>
</html>
