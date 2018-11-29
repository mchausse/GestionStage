<%-- 
    Document   : candidatures
    Created on : 2018-11-28, 09:31:23
    Author     : usager
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.stageo.beans.Employeur"%>
<%@page import="com.stageo.beans.Compagnie"%>
<%@page import="com.stageo.beans.Utilisateur"%>
<%@page import="com.stageo.beans.OffreStage"%>
<%@page import="com.stageo.beans.Candidature"%>
<jsp:useBean id="candidatureDAO" class="com.stageo.dao.CandidatureDAO" scope="page"/>
<jsp:useBean id="employeurDAO" class="com.stageo.dao.EmployeurDAO" scope="page"/>
<jsp:useBean id="compagnieDAO" class="com.stageo.dao.CompagnieDAO" scope="page"/>
<jsp:useBean id="utilisateurDAO" class="com.stageo.dao.UtilisateurDAO" scope="page"/>
<jsp:useBean id="offreStageDAO" class="com.stageo.dao.OffreStageDAO" scope="page"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="./css/style.css" rel="stylesheet" type="text/css"/>
        <title>Stageo|Candidature</title>
    </head>
    <body>
        <!-- Barre de navigation -->
        <%@include  file="menu.jsp" %>
        <!-- Fin de la barre de navigation -->
        <div class="container-fluid candidature">
            <div class="row">
                <span class="titreCandidature">Mes Candidatures</span>
            </div>
            <br />
            <div class="row">
                <c:if test="${ sessionScope['utilisateur'].getTypeUtilisateur() eq 'Etudiant'}">
                    <form>
                        <div class="sousTitre">
                            Recherche:
                        </div>
                        <span class="">
                            Nom Compagnie  <input type="text" name="Compagnie" />
                        </span>
                        <span class="compC"> 
                            Statut <select>
                                <option>--------</option>
                                <option value="accepter">Accepter</option>
                                <option value="attente">En attente</option>
                                <option value="refuser">Refuser</option>
                            </select>
                        </span>
                        <span class="compC">
                            <input type="submit" name="recherche" value="Rechercher" />
                        </span>
                    </form>
                </c:if>
                <c:if test="${ sessionScope['utilisateur'].getTypeUtilisateur() eq 'Coordonnateur'}">
                    <form>
                        <div class="sousTitre">
                            Recherche:
                        </div>
                        <span class="">
                            Nom Étudiant  <input type="text" name="nomEtudiant" />
                        </span>
                        <span class="compC">
                            Nom Compagnie  <input type="text" name="Compagnie" />
                        </span>
                        <span class="compC">
                            Statut <select>
                                <option>--------</option>
                                <option value="accepter">Accepter</option>
                                <option value="attente">En attente</option>
                                <option value="refuser">Refuser</option>
                            </select>
                        </span>
                        <span class="compC">
                            <input type="submit" name="recherche" value="Rechercher" />
                        </span>
                    </form>
                </c:if>
            </div>
            <br />
            <div class="row">
                <table class="table table-striped tableCandidature">
                    <c:if test="${ sessionScope['utilisateur'].getTypeUtilisateur() eq 'Etudiant'}">
                        <c:if test="${ candidatureDAO.findByIdEtudiant(sessionScope['utilisateur'].getIdUtilisateur())!=null}">
                            <thead class="titreTableCandidature">
                                <tr>
                                    <td>Compagnie <a href="#" class="fa fa-arrows-alt-v"></a></td>
                                    <td>Employeur <a href="#" class="fa fa-arrows-alt-v"></a></td>
                                    <td>Offre <a href="#" class="fa fa-arrows-alt-v"></a></td>
                                    <td>Date <a href="#" class="fa fa-arrows-alt-v"></a></td>
                                    <td>Statut <a href="#" class="fa fa-arrows-alt-v"></a></td>
                                </tr>
                            </thead>
                            <tbody class="contenuTableCandidature">
                                <c:forEach var="can" items="${candidatureDAO.findByIdEtudiant(sessionScope['utilisateur'].getIdUtilisateur())}">
                                    <c:set var="employeur" value="${utilisateurDAO.findById(offreStageDAO.findById(can.getCandidaturePK().getIdOffre()).getIdEmployeur())}" />
                                    <c:set var="offre" value="${offreStageDAO.findById(can.getCandidaturePK().getIdOffre())}" />
                                    <c:set var="compagnie" value="${compagnieDAO.findById(employeurDAO.findById(offreStageDAO.findById(can.getCandidaturePK().getIdOffre()).getIdEmployeur()).getIdCompagnie())}" />
                                    <tr>
                                        <td>${compagnie.getNom()}</td>
                                        <td>${employeur.getNom()} ${employeur.getPrenom()}</td>
                                        <td>${offre.getTitre()}</td>
                                        <td>${can.getDate()}</td>
                                        <td>${can.getStatut()}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </c:if>
                        <c:if test="${ candidatureDAO.findByIdEtudiant(sessionScope['utilisateur'].getIdUtilisateur())==null}">
                            <thead class="titreTableCandidature">
                                <tr>
                                    <td>Compagnie <a href="#" class="fa fa-arrows-alt-v"></a></td>
                                    <td>Employeur <a href="#" class="fa fa-arrows-alt-v"></a></td>
                                    <td>Offre <a href="#" class="fa fa-arrows-alt-v"></a></td>
                                    <td>Date <a href="#" class="fa fa-arrows-alt-v"></a></td>
                                    <td>Statut <a href="#" class="fa fa-arrows-alt-v"></a></td>
                                </tr>
                            </thead>
                            <tbody class="contenuTableCandidature">
                                <tr>
                                    <td>Vous n'avez aucune candidature!</td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                            </tbody>
                        </c:if>
                    </c:if>
                    <c:if test="${ sessionScope['utilisateur'].getTypeUtilisateur() eq 'Coordonnateur'}">
                        <c:if test="${ candidatureDAO.findByIdEtudiant(sessionScope['utilisateur'].getIdUtilisateur())!=null}">
                            <thead class="titreTableCandidature">
                                <tr>
                                    <td>Compagnie <a href="#" class="fa fa-arrows-alt-v"></a></td>
                                    <td>Employeur <a href="#" class="fa fa-arrows-alt-v"></a></td>
                                    <td>Étudiant <a href="#" class="fa fa-arrows-alt-v"></a></td>
                                    <td>Offre <a href="#" class="fa fa-arrows-alt-v"></a></td>
                                    <td>Date <a href="#" class="fa fa-arrows-alt-v"></a></td>
                                    <td>Statut <a href="#" class="fa fa-arrows-alt-v"></a></td>
                                </tr>
                            </thead>
                            <tbody class="contenuTableCandidature">
                                <c:forEach var="can" items="${candidatureDAO.findAll()}">
                                    <c:set var="employeur" value="${utilisateurDAO.findById(offreStageDAO.findById(can.getCandidaturePK().getIdOffre()).getIdEmployeur())}" />
                                    <c:set var="etudiant" value="${utilisateurDAO.findById(can.getCandidaturePK().getIdEtudiant())}" />
                                    <c:set var="offre" value="${offreStageDAO.findById(can.getCandidaturePK().getIdOffre())}" />
                                    <c:set var="compagnie" value="${compagnieDAO.findById(employeurDAO.findById(offreStageDAO.findById(can.getCandidaturePK().getIdOffre()).getIdEmployeur()).getIdCompagnie())}" />
                                    
                                    <tr>
                                        <td>${compagnie.getNom()}</td>
                                        <td>${employeur.getNom()} ${employeur.getPrenom()}</td>
                                        <td>${etudiant.getNom()} ${etudiant.getPrenom()}</td>
                                        <td>${offre.getTitre()}</td>
                                        <td>${can.getDate()}</td>
                                        <td>${can.getStatut()}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </c:if>
                        <c:if test="${ candidatureDAO.findByIdEtudiant(sessionScope['utilisateur'].getIdUtilisateur())==null}">
                            <thead class="titreTableCandidature">
                                <tr>
                                    <td>Compagnie <a href="#" class="fa fa-arrows-alt-v"></a></td>
                                    <td>Employeur <a href="#" class="fa fa-arrows-alt-v"></a></td>
                                    <td>Étudiant <a href="#" class="fa fa-arrows-alt-v"></a></td>
                                    <td>Offre <a href="#" class="fa fa-arrows-alt-v"></a></td>
                                    <td>Date <a href="#" class="fa fa-arrows-alt-v"></a></td>
                                    <td>Statut <a href="#" class="fa fa-arrows-alt-v"></a></td>
                                </tr>
                            </thead>
                            <tbody class="contenuTableCandidature">
                                <tr>
                                    <td>Il n'y a aucune candidature !</td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                            </tbody>
                        </c:if>
                    </c:if>
                </table>
            </div>
        </div>
    </body>
</html>
