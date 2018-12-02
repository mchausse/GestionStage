<%-- 
    Document   : listeEtudiantCandidatureStage
    Created on : 2018-12-01, 15:40:10
    Author     : Max
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="compagnieDAO" class="com.stageo.dao.CompagnieDAO" scope="page"/>
<jsp:useBean id="employeurDAO" class="com.stageo.dao.EmployeurDAO" scope="page"/>
<jsp:useBean id="utilisateurDAO" class="com.stageo.dao.UtilisateurDAO" scope="page"/>
<jsp:useBean id="candidatureDAO" class="com.stageo.dao.CandidatureDAO" scope="page"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="./css/style.css" rel="stylesheet" type="text/css"/>
        <title>Stagéo | Candidature pour le stage</title>
    </head>
    <body>
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
            <div class="row">
                <div>
                    <c:if test="${ candidatureDAO.findByIdOffre(sessionScope['utilisateur'].getIdUtilisateur())!=null}">
                        <thead class="titreTableCandidature">
                            <tr>
                                <td>Nom<a href="#" class="fa fa-arrows-alt-v"></a></td>
                                <td>Critere <a href="#" class="fa fa-arrows-alt-v"></a></td>
                                <td>Date <a href="#" class="fa fa-arrows-alt-v"></a></td>
                            </tr>
                        </thead>
                        <tbody class="contenuTableCandidature">
                            <c:forEach var="can" items="${candidatureDAO.findByIdOffre(offreStage)}">
                                <c:set var="offre" value="${offreStageDAO.findById(can.getCandidaturePK().getIdOffre())}" />
                                <tr>
                                    <td>${compagnie.getNom()}</td>
                                    <td>${can.getDate()}</td>
                                    <td>${can.getStatut()}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </c:if>
                    <c:if test="${ candidatureDAO.findByIdOffre(sessionScope['utilisateur'].getIdUtilisateur())==null}">
                        <thead class="titreTableCandidature">
                            <tr>
                                <td>Nom<a href="#" class="fa fa-arrows-alt-v"></a></td>
                                <td>Critere <a href="#" class="fa fa-arrows-alt-v"></a></td>
                                <td>Date <a href="#" class="fa fa-arrows-alt-v"></a></td>
                            </tr>
                        </thead>
                        <tbody class="contenuTableCandidature">
                            <tr>
                                <td>Il n'y a pas de candidatures actuellement pour votre offre de stage!</td>
                                <td></td>
                                <td></td>
                            </tr>
                        </tbody>
                    </c:if>
                </div>
            </div>
        </div>
    </body>
</html>
