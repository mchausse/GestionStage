<%-- 
    Document   : menu
    Created on : 2018-10-25, 13:27:57
    Author     : gabriel
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<nav class="navbar navbar-default navbar-fixed-top" role="navigation" id="menu">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" id="btnMenuColl" data-toggle="collapse" data-target="#navbar-collapse-main">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="http://www.crosemont.qc.ca/"><img id="logo" src="./images/logoCouper.png"/></a>
        </div>
        <div class="collapse navbar-collapse" id="navbar-collapse-main">
            <div id="choixMenu">
                <ul class="nav navbar-nav navbar-left">
                    <c:if test="${ sessionScope['connecte'] eq true }" > <!--si l'utilisateur est connecte -->
                        <c:if test="${ sessionScope['utilisateur'].getTypeUtilisateur() eq 'Employeur'}">
                            <li><a class="#" href="do?action=afficherGestionOffresStagesVueEmployeur">Gestion des offres</a></li>
                            <li><a class="#" href="do?action=afficherListeEtudiantsVueEmployeur">Recherche Étudiants</a></li>
                        </c:if>
                        <c:if test="${ sessionScope['utilisateur'].getTypeUtilisateur() eq 'Etudiant'}">
                            <li><a class="#" href="do?action=afficherListeStagesVueEtudiant">Offres de stage</a></li>
                        </c:if>
                        <c:if test="${ sessionScope['utilisateur'].getTypeUtilisateur() eq 'Coordinateur'}">
                            <li><a class="#" href="">Échanges </a></li>
                        </c:if>
                        <li><a class="#" href="do?action=afficherMessagerie">Messagerie</a></li>
                        <li><a class="#" href="do?action=afficherProfil">Profil</a></li> <!-- changer le nom pour de quoi d'autre -->
                        <li><a class="#" href="do?action=deconnexion">Deconnexion</a></li>
                    </c:if>
                    <c:if test="${ empty sessionScope['connecte'] || sessionScope['connecte'] eq false }" > <!-- il est deco -->
                        <li><a class="#" href="do?action=afficherIncription">Accueil</a></li>
                        <li><a class="#" href="do?action=afficherIncription">Connexion</a></li>
                    </c:if>                     
                </ul>
            </div>
        </div>
        <!-- POUR DÉBUG 
        <c:out value="Compte = ${sessionScope['utilisateur']}" />
        <c:out value="Connecte = ${sessionScope['connecte']}" /> -->
    </div>
</nav>
