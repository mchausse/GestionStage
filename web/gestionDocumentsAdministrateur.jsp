<%-- 
    Document   : gestionDocumentsAdministrateur
    Created on : Nov 14, 2018, 8:06:34 AM
    Author     : mchausse
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
        
        <div class='container-fluid'>
            <div id="contenuPage">
                <div class="col-lg-1"></div><!-- Sert de margin -->
                
                <!-- Debut de la section du menu des documents -->
                <div class="col-lg-2">
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
                </div>
                <!-- Fin de la section du menu des documents -->
                
                <!-- Debut de la section des documents -->
                <div class="col-lg-7">
                    
                    <!--  Formulaire d'ajout de document -->
                    <div id="ajouterDocument">
                        <!-- Debut d'une offre -->
                        <div class="panel panel-default">

                            <div class="panel-heading">
                                <!-- Pour afficher un voyant de couleur -->
                                <span class="label label-default label-as-badge">&#8203 &#8203</span>
                                <div class='row'>
                                    <div class="col-lg-8">
                                        <div class="col-lg-8"><input type="text" class="form-control" id="nom" placeholder="Titre"></div>
                                    </div>
                                    <div class="col-lg-3">Status : Creation</div>
                                </div>
                            </div>

                            <div class="panel-body">
                                <div class='row'>
                                    <!-- Premiere section de document-->
                                    <div class="col-lg-4">
                                    <div class="col-sm-11 input-group">
                                        <label class="input-group-btn">
                                            <span class="btn btn-primary">
                                                Ajouter
                                                <input type="file" lass="form-control-file" accept="application/pdf" style="display: none;" id="cv">
                                            </span>
                                        </label>
                                        <input type="text" class="form-control" readonly id="relNoteNom">
                                    </div>
                                    </div>
                                    <div class="col-lg-4">
                                        <input type="text" class="form-control" id="nom" placeholder="www.votreLien.ca">
                                    </div>
                                    <div class="col-lg-4">
                                        Vue : 0
                                    </div>
                                    <!-- Deuxieme section de document-->
                                    <div class="col-lg-12">
                                        <span onclick="ouvrirDesc()" class='glyphicon glyphicon-triangle-bottom'></span>
                                        Description
                                        <textarea class="form-control" rows="3"></textarea>
                                    </div>
                                </div>
                            </div>

                        </div>
                        <!-- Fin d'un documents -->
                        <hr />
                    </div>
                    <!--  Fin du formulaire d'ajout de document -->
                    
                    <!-- Debut d'un document -->
                    <div class="panel panel-default">
                        
                        <div class="panel-heading">
                            <!-- Pour afficher un voyant de couleur -->
                            <span class="label label-success label-as-badge">&#8203 &#8203</span>
                            <div class='row'>
                                <div class="col-lg-4"> Titre du document</div>
                                <div class="col-lg-4">10-18-2018</div>
                                <div class="col-lg-3"><kbd>PUBLIC</kbd></div>
                                <a href="#" class="btn btn-default btn-md btnModDocument">
                                    <span class="glyphicon glyphicon-pencil"></span>
                                </a>
                            </div>
                        </div>
                        
                        <div class="panel-body">
                            <div class='row'>
                                <!-- Premiere section du document-->
                                <div class="col-lg-4">
                                    <a>LienDocument.txt</a>
                                </div>
                                <div class="col-lg-4">
                                    <a>LienWeb</a>
                                </div>
                                <div class="col-lg-4">
                                    Vue : 500
                                </div>
                            </div>
                        </div>
                        
                    </div>
                    <!-- Fin d'un document -->
                    
                    
                    <!-- Debut d'un document -->
                    <div class="panel panel-default">
                        
                        <div class="panel-heading">
                            <!-- Pour afficher un voyant de couleur -->
                            <span class="label label-warning label-as-badge">&#8203 &#8203</span>
                            <div class='row'>
                                <div class="col-lg-4"> Titre du document</div>
                                <div class="col-lg-4">10-18-2018</div>
                                <div class="col-lg-3"><kbd>ETUDIANT</kbd></div>
                                <a href="#" class="btn btn-default btn-md btnModDocument">
                                    <span class="glyphicon glyphicon-pencil"></span>
                                </a>
                            </div>
                        </div>
                        
                        <div class="panel-body">
                            <div class='row'>
                                <!-- Premiere section du document-->
                                <div class="col-lg-4">
                                    <a>LienDocument.txt</a>
                                </div>
                                <div class="col-lg-4">
                                    <a>LienWeb</a>
                                </div>
                                <div class="col-lg-4">
                                    Vue : 500
                                </div>
                            </div>
                        </div>
                        
                    </div>
                    <!-- Fin d'un document -->
                    
                    
                    <!-- Debut d'un document -->
                    <div class="panel panel-default">
                        
                        <div class="panel-heading">
                            <!-- Pour afficher un voyant de couleur -->
                            <span class="label label-info label-as-badge">&#8203 &#8203</span>
                            <div class='row'>
                                <div class="col-lg-4"> Titre du document</div>
                                <div class="col-lg-4">10-18-2018</div>
                                <div class="col-lg-3"><kbd>EMPLOYEUR</kbd></div>
                                <a href="#" class="btn btn-default btn-md btnModDocument">
                                    <span class="glyphicon glyphicon-pencil"></span>
                                </a>
                            </div>
                        </div>
                        
                        <div class="panel-body">
                            <div class='row'>
                                <!-- Premiere section du document-->
                                <div class="col-lg-4">
                                    <a>LienDocument.txt</a>
                                </div>
                                <div class="col-lg-4">
                                    <a>LienWeb</a>
                                </div>
                                <div class="col-lg-4">
                                    Vue : 500
                                </div>
                            </div>
                        </div>
                        
                    </div>
                    <!-- Fin d'un document -->
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
                
                // Assigner les actions de clicks
                $("#btnAjouterDocument").click(function(){
                    if($("#ajouterDocument").show){
                        $("#ajouterDocument").hide(300);
                        $("#btnAjouterDocument").html("<span class='glyphicon glyphicon-plus'> Ajouter</span>");
                    }
                    if($("#ajouterDocument").hide){
                        $("#ajouterDocument").show(300);
                        $("#btnAjouterDocument").html("<span class='glyphicon glyphicon-arrow-left'> Annuler</span>");
                    }
                });
            });
        </script>
    </body>
</html>
