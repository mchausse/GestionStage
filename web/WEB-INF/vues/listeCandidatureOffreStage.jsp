<%-- 
    Document   : listeEtudiantCandidatureStage
    Created on : 2018-12-01, 15:40:10
    Author     : Max
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="compagnieDAO" class="com.stageo.dao.CompagnieDAO" scope="page"/>
<jsp:useBean id="employeurDAO" class="com.stageo.dao.EmployeurDAO" scope="page"/>
<jsp:useBean id="etudiantDAO" class="com.stageo.dao.EtudiantDAO" scope="page"/>
<jsp:useBean id="utilisateurDAO" class="com.stageo.dao.UtilisateurDAO" scope="page"/>
<jsp:useBean id="candidatureDAO" class="com.stageo.dao.CandidatureDAO" scope="page"/>
<jsp:useBean id="etudiantCritereDAO" class="com.stageo.dao.EtudiantCritereDAO" scope="page"/>
<jsp:useBean id="critereDAO" class="com.stageo.dao.CritereDAO" scope="page"/>
<jsp:useBean id="cvDAO" class="com.stageo.dao.CvDAO" scope="page"/>
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
        <%@include  file="menu.jsp" %>
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
                <div id="listeEtu" class="col-lg-12">
                    <div class="row panel panel-default">
                        <div class="panel-heading sousTitre">
                            Liste candidatures
                        </div>
                        <div class="panel-body infoCon">
                            <table class="table table-striped tableCandidature">
                                <c:if test="${candidatureDAO.findByIdOffre(offreStage.getIdOffre()).size()>0}">
                                    <thead class="titreTableCandidature">
                                        <tr>
                                            <td>Nom<a href="#" class="fa fa-arrows-alt-v"></a></td>
                                            <td>Date <a href="#" class="fa fa-arrows-alt-v"></a></td>
                                        </tr>
                                    </thead>
                                    <tbody class="contenuTableCandidature">
                                        <c:forEach var="candidature" items="${candidatureDAO.findByIdOffre(offreStage.getIdOffre())}">
                                            <c:set var="etudiant" value="${utilisateurDAO.findById(candidature.getCandidaturePK().getIdEtudiant())}" />
                                            
                                            <tr onclick="info('${etudiant.getPrenom()}','${etudiant.getNom()}','<c:forEach var="critere" items="${etudiantCritereDAO.findByIdEtudiant(etudiant.getIdUtilisateur())}">${critereDAO.findById(critere.getEtudiantcriterePK().getIdCritere()).getNom()},</c:forEach>','<c:forEach var="cv" items="${cvDAO.findAllByIdEtudiant(candidature.getCandidaturePK().getIdEtudiant())}">${cv.getIdCv()},${cv.getLangue()},</c:forEach>')" id="${candidature.getCandidaturePK().getIdEtudiant()}" class="etu">
                                                <td>${etudiant.getPrenom()} ${etudiant.getNom()}</td>
                                                <td>${candidature.getDate()}</td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </c:if>
                                <c:if test="${candidatureDAO.findByIdOffre(offreStage.getIdOffre()).size()<=0}">
                                    <thead class="titreTableCandidature">
                                        <tr>
                                            <td>Nom<a href="#" class="fa fa-arrows-alt-v"></a></td>
                                            <td>Date <a href="#" class="fa fa-arrows-alt-v"></a></td>
                                        </tr>
                                    </thead>
                                    <tbody class="contenuTableCandidature">
                                        <tr>
                                            <td>Il n'y a pas de candidatures actuellement pour votre offre de stage!</td>
                                            <td></td>
                                        </tr>
                                    </tbody>
                                </c:if>
                            </table>
                        </div>
                    </div>
                </div>
                <div id="infoCan" class="col-lg-6">
                </div>
            </div>
        </div>
    </body>
</html>
<script>

    var header = document.getElementById("listeEtu");
    var etu = header.getElementsByClassName("etu");
    for (var i = 0; i < etu.length; i++) {
        etu[i].addEventListener("click", function() {
        var current = document.getElementsByClassName("selecte");

        if(current.length > 0){
            if(this.id === current[0].id){
                current[0].className = current[0].className.replace(" selecte", "");
                var listeE = document.getElementById("listeEtu");
                listeE.classList.remove("col-lg-6");
                listeE.classList.add("col-lg-12");
                var menuInfo = document.getElementById("infoCan");
                menuInfo.innerHTML = "";
            }
            else{
                current[0].className = current[0].className.replace(" selecte", "");
                this.className += " selecte";

            }
        }
        else{
            this.className += " selecte";
            var listeE = document.getElementById("listeEtu");
                listeE.classList.remove("col-lg-12");
                listeE.classList.add("col-lg-6");

        }
      });
    }
    function info(prenom,nom,competence,cv) {
        var menuInfo = document.getElementById("infoCan");
        var listecomp = competence.split(",");
        var listecv = cv.split(",");
        var text =  '<div id="infoCan" class="col-lg-12">'+
                        '<div class="row panel panel-default">'+
                            '<div class="panel-heading sousTitre">'+
                                'Information'+
                            '</div>'+
                            '<div class="panel-body infoCon">'+
                                '<label class="titreop">Nom étudiant</label>'+
                                '<input type="text" class="form-control" value="'+prenom+' '+nom+'" disabled />'+
                                '<br />'+
                                '<label class="titreop">Compétence de l\'étudiant</label>'+
                                '<div  class="panel panel-default">'+
                                    '<div class="panel-body comptv">';

                                        if(listecomp.length > 1){
                                           for(i =0;i+1<listecomp.length;i++){
                                            text += '<span class="compoff">'+listecomp[i]+'</span>'+' ';
                                           } 
                                        }
                                        else{
                                            text += 'Cette étudiant n\'a pas de critère !';
                                        }
        text +=                     '</div>'+
                                '</div>'+
                                '<label class="titreop">Cv</label>'+
                                '<form method="post" class="form-inline" action="./do">'+
                                    '<input type="hidden" name="Action" value="telechargerCVCandidature"/>'+
                                    '<select class="form-control comptv" name="cvId">'+
                                        '<option value="choisir" id="cacher" selected disabled>Choisir un CV</option>';
                                        if(listecomp.length > 1){
                                            for(i =0;i+1<listecv.length;i+=2){
                                                text += '<option value="'+listecv[i]+'">'+listecv[i+1]+'</option>';
                                            }
                                        }
                                        else{
                                            text += '<option value="aucun">Aucun cv trouvé !</option>';
                                        }
        text +=                     '</select>'+
                                    '      <input type="submit" class="btn btn-primary" value="Télécharger"/>'+
                                '</form>'+
                                '<br /><br />'+
                                '<div class="col-lg-6">'+
                                    '<form method="post" action="./do">'+
                                        '<input type="hidden" name="Action" value="accepterCandidature"/>'+
                                        '<input type="submit" id="acccan" class="btn btn-success" value="Accepter"/>'+
                                    '</form>'+
                                '</div>'+
                                '<div class="col-lg-6">'+
                                    '<form method="post" action="./do">'+
                                        '<input type="hidden" name="Action" value="refuserCandidature"/>'+
                                        '<input type="submit" id="supcan" class="btn btn-danger" value="Refuser"/>'+
                                    '</form>'+
                                '</div>'+
                            '</div>'+
                        '</div>'+
                    '</div>';
        menuInfo.innerHTML = text;
    }
    

</script>