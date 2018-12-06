<%-- 
    Document   : gestionDocumentsAdministrateur
    Created on : Nov 14, 2018, 8:06:34 AM
    Author     : mchausse && Samuel Laverdure
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- DAOs : -->
<jsp:useBean id="docuDao" class="com.stageo.dao.DocumentDAO" scope="page"></jsp:useBean>

<c:if test="${ param.action!='afficherGestionDocuments'}" >
    <c:redirect url = "do?afficherGestionDocuments"/>
</c:if>
<html>
    <head>
        <title>Stages | Documents</title>
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
        <!-- Liste document : -->
        <c:set var="listeDocu" value="${docuDao.findAllByTypeUser(sessionScope['utilisateur'].getTypeUtilisateur())}" />
        <div class='container-fluid'>
            <div id="contenuPage">
                
                <!-- Titre de la page -->
                <div class="row">
                <div class="col-lg-1"></div><!-- Sert de margin -->
                    <div class="col-lg-4">
                        <div class="panel panel-default">
                            
                            <div class="panel-heading">
                                <c:choose>
                                    <c:when test="${ sessionScope['utilisateur'].getTypeUtilisateur() eq 'Coordonnateur'}">
                                    <h3>
                                        <span id='btnDescTitrePage' class='glyphicon glyphicon-triangle-bottom'></span>
                                        Gestion des documents
                                    </h3>
                                    <p id='descTitrePage'>
                                        Ici, vous pouvez voir vos document que vous avez publiés, 
                                        ainsi qu'en ajouter des nouveaux ou modifier et désactiver ceux déjà existants.
                                    </p>
                                    </c:when>
                                    <c:otherwise>                      
                                    <h3>
                                        <span id='btnDescTitrePage' class='glyphicon glyphicon-triangle-bottom'></span>
                                        Documents
                                    </h3>
                                    <p id='descTitrePage'>
                                        Ici, vous pouvez voir les document publiés par l'administrateur, 
                                    </p>        
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Fin du titre de la page-->
                
                <div class="col-lg-1"></div><!-- Sert de margin -->
                
                <!-- Debut de la section du menu des documents -->
                <div class="col-lg-2">
                    <c:choose>
                        <c:when test="${ sessionScope['utilisateur'].getTypeUtilisateur() eq 'Coordonnateur'}">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    Menu
                                </div>

                                <!-- Liste des options du menu -->
                                <div class="panel-body">
                                    <div class="col-lg-12">
                                        <a href="#" class="btn btn-default btn-lg btnMenu" id='btnAjouterDocument'>
                                            <span class="glyphicon glyphicon-plus"> Ajouter</span>
                                        </a>
                                    </div>
                                </div>
                                <!-- Fin de la liste des options du menu -->

                            </div>
                        </c:when>
                        <c:otherwise>                      
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    Informations
                                </div>

                                <!-- Liste des options du menu -->
                                <div class="panel-body">
                                    <div class="col-lg-12">
                                        <c:choose>
                                            <c:when test="${listeDocu.size() eq 0 || listeDocu.size() eq 1}">
                                                ${listeDocu.size()} document publié
                                            </c:when>
                                            <c:otherwise>
                                                ${listeDocu.size()} documents publiés
                                            </c:otherwise>    
                                        </c:choose>
                                    </div>
                                </div>
                                <!-- Fin de la liste des options du menu -->

                            </div>   
                        </c:otherwise>
                    </c:choose>
                </div>
                <!-- Fin de la section du menu des documents -->
                
                <!-- Debut de la section des documents -->
                <div class="col-lg-7">
                    <c:if test="${ sessionScope['utilisateur'].getTypeUtilisateur() eq 'Coordonnateur'}">
                        <!--  Formulaire d'ajout de document -->
                        <form action="do?action=creeDocument" method="post" enctype="multipart/form-data">
                            <div id="ajouterDocument">
                                <!-- Debut d'une offre -->
                                <div class="panel panel-default">

                                    <div class="panel-heading">
                                        <!-- Pour afficher un voyant de couleur -->
                                        <span class="label label-default label-as-badge">&#8203 &#8203</span>
                                        <div class='row'>
                                            <div class="col-lg-6">
                                                <div class="col-lg-8">
                                                <label>Titre :</label>
                                                <input type="text" class="form-control" id="nom" name="titre" placeholder="Titre"></div>
                                            </div>
                                            <div class="col-lg-3">
                                                <label>Visibilité :</label>
                                                <select class="form-control" id="typeDocu" name="typeDocu">
                                                    <option>Etudiant</option>
                                                    <option>Employeur</option>
                                                    <option>Public</option>
                                                </select>
                                            </div>
                                            <div class="col-lg-3">
                                                <button id='btnUploadDocu' type="submit" class="btn btn-primary">Téléverser <span class="glyphicon glyphicon-open"></span></button>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="panel-body">
                                        <div class='row'>
                                            <!-- Premiere section de document-->
                                            <div class="col-lg-4">
                                            <div class="col-sm-11 input-group">
                                                <label class="input-group-btn">
                                                    <span class="btn btn-primary">
                                                        Ajouter<input type="file" id="file" name="fichierDocu" class="form-control-file" style="display: none;" accept="application/pdf" size="50">
                                                    </span>
                                                </label>
                                                <input type="text" class="form-control" id="docuNom" name="docuNom">
                                            </div>
                                            </div>
                                            <div class="col-lg-4">
                                            </div>
                                            <div class="col-lg-4">
                                                <label>Vue : 0</label>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                                <!-- Fin d'un documents -->
                                <hr />
                            </div>
                        </form>
                    </c:if>
                    <!--  Fin du formulaire d'ajout de document -->
                    <c:forEach items="${listeDocu}"   var="docu">
                        <!-- Debut d'un document -->
                        <div class="panel panel-default">

                            <div class="panel-heading">
                                <!-- Pour afficher un voyant de couleur -->
                                <span class="label label-success label-as-badge">&#8203 &#8203</span>
                                <div class='row'>
                                    <div class="col-lg-12 dateStage">Publié le ${docu.getDate()}</div>
                                    <div class="col-lg-8"> ${docu.getTitre()}</div>
                                    <div class="col-lg-3"><kbd>${docu.getType()}</kbd></div>
                                    <c:choose>
                                        <c:when test="${sessionScope['utilisateur'].getTypeUtilisateur() eq 'Coordonnateur'}">
                                            <form action="do?action=deleteDocument" method="post">
                                                <button class="btn btn-default btn-md btnModDocument" type="submit">
                                                    <input type="text" hidden value="${docu.getIdDocument()}" name="idDocu">
                                                    <span class="glyphicon glyphicon-trash"></span>
                                                </button>
                                            </form>
                                        </c:when>
                                        <c:otherwise>
                                            <form action="do?action=downloadDocument" method="post">
                                                <button class="btn btn-default btn-md btnModDocument" type="submit">
                                                    <input type="text" hidden value="${docu.getIdDocument()}" name="idDocu">
                                                    <span class="glyphicon glyphicon-save"></span>
                                                </button>
                                            </form>
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                            </div>
                            <div class="panel-body">
                                <div class='row'>
                                    <!-- Premiere section du document-->
                                    <div class="col-lg-4">
                                        <a>${docu.getLien()}</a>
                                    </div>
                                    <div class="col-lg-4">
                                    </div>
                                    <div class="col-lg-4">
                                        Vue : ${docu.getNbVues()}
                                    </div>
                                </div>
                            </div> 
                        </div>
                    </c:forEach>
                </div>
                <!-- Fin de la section des documents -->
                
            </div>
        </div>
        <!-- Fin du contenu de la page -->
        
        <!-- Footer -->
        <%@include  file="footer.jsp" %>
        <!-- Fin footer -->
        
        <script>
            $(document).ready(function(){
                // Cacher le formulaire de stage
                $("#ajouterDocument").hide();
                $("#descTitrePage").hide();
                
                // Assigner les actions de clicks
                $("#btnAjouterDocument").click(function(){
                    if(!$("#ajouterDocument").is(":hidden")){
                        $("#ajouterDocument").hide(300);
                        $("#btnAjouterDocument").html("<span class='glyphicon glyphicon-plus'> Ajouter</span>");
                    }else{
                        $("#ajouterDocument").show(300);
                        $("#btnAjouterDocument").html("<span class='glyphicon glyphicon-arrow-left'> Annuler</span>");
                    }
                });
                // Pour le bouton de description du titre
                $("#btnDescTitrePage").click(function(){
                    if($("#btnDescTitrePage").is(".glyphicon-triangle-bottom")){
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
            //Ajout du nom du fichier dans l'input du document
            $('#file').change(function () {
                var fichier = [];
                for(var i = 0; i< $(this).get(0).files.length;++i){
                    fichier.push($(this).get(0).files[i].name);  
                }
                if(fichier.length > 0){
                    if(fichier.length > 1){$('#docuNom').val(fichier.length + " fichiers sélectionnés");}
                    else{$('#docuNom').val(fichier);}        
                }
                else{$('#docuNom').val("");}
            });
        </script>
    </body>
</html>
