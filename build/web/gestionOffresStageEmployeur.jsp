<%-- 
    Document   : OffresStageEmployeur
    Created on : Nov 13, 2018, 7:54:34 PM
    Author     : mchausse
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
                    <div class="col-lg-8">
                        <div class="jumbotron">
                            <h1>Gestion des offres de stage</h1> 
                            <p>Ici, vous pouvez voir vos offres que vous avez publiées, 
                                ainsi qu'en ajouter des nouvelles ou  modifier et désactive ceux déjà existantes</p> 
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
                                    <!-- Premiere section de l'offre-->
                                    <div class="col-lg-4">
                                    <div class="col-sm-11 input-group">
                                        <label class="input-group-btn">
                                            <span class="btn btn-primary">
                                                Ajouter<input type="file" lass="form-control-file" accept="application/pdf" style="display: none;" id="cv">
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
                                    <!-- Deuxieme section de l'offre-->
                                    <div class="col-lg-12">
                                        <span onclick="ouvrirDesc()" class='glyphicon glyphicon-triangle-bottom'></span>
                                        Description
                                        <textarea class="form-control" rows="3"></textarea>
                                    </div>
                                </div>
                            </div>

                        </div>
                        <!-- Fin d'une offre -->
                        <hr />
                    </div>
                    <!--  Fin du formulaire d'ajout de stage -->
                    
                    <!-- Debut d'une offre -->
                    <div class="panel panel-default">
                        
                        <div class="panel-heading">
                            <!-- Pour afficher un voyant de couleur -->
                            <span class="label label-success label-as-badge">&#8203 &#8203</span>
                            <div class='row'>
                                <div class="col-lg-12">Publié le 10-18-2018</div>
                                <div class="col-lg-8"><kbd>Compagnie</kbd> Salut, je suis une tres longue offre de stage</div>
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
                                    <a>LienDocument.txt</a>
                                </div>
                                <div class="col-lg-4">
                                    <a>LienWeb</a>
                                </div>
                                <div class="col-lg-4">
                                    Vue : 500
                                </div>
                                <!-- Deuxieme section de l'offre-->
                                <div class="col-lg-12">
                                    <span onclick="ouvrirDesc()" class='glyphicon glyphicon-triangle-bottom'></span>
                                    Description
                                    <!--<pre id='descriptionXX'></pre>-->
                                </div>
                            </div>
                        </div>
                        
                    </div>
                    <!-- Fin d'une offre -->
                    
                    <!-- Debut d'une offre -->
                    <div class="panel panel-default">
                        
                        <div class="panel-heading">
                            <!-- Pour afficher un voyant de couleur -->
                            <span class="label label-danger label-as-badge">&#8203 &#8203</span>
                            <div class='row'>
                                <div class="col-lg-12">Publié le 10-18-2018</div>
                                <div class="col-lg-8"><kbd>Compagnie</kbd> Titre de l'offre</div>
                                <div class="col-lg-3">Status : Inactive</div>
                                <a href="#" class="btn btn-default btn-md btnModStage">
                                    <span class="glyphicon glyphicon-pencil"></span>
                                </a>
                            </div>
                        </div>
                        
                        <div class="panel-body">
                            <div class='row'>
                                <!-- Premiere section de l'offre-->
                                <div class="col-lg-4">
                                    <a>LienDocument.txt</a>
                                </div>
                                <div class="col-lg-4">
                                    <a>LienWeb</a>
                                </div>
                                <div class="col-lg-4">
                                    Vue : 50
                                </div>
                                <!-- Deuxieme section de l'offre-->
                                <div class="col-lg-12">
                                    <span onclick="ouvrirDesc()" class='glyphicon glyphicon-triangle-bottom'></span>
                                    Description
                                    <!--<pre id='descriptionXX'></pre>-->
                                </div>
                            </div>
                        </div>
                        
                    </div>
                    <!-- Fin d'une offre -->
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
                
                // Assigner les actions de clicks
                $("#btnAjouterStage").click(function(){
                    if($("#ajouterStage").show){
                        $("#ajouterStage").hide(300);
                        $("#btnAjouterStage").html("<span class='glyphicon glyphicon-plus'> Ajouter</span>");
                    }
                    if($("#ajouterStage").hide){
                        $("#ajouterStage").show(300);
                        $("#btnAjouterStage").html("<span class='glyphicon glyphicon-arrow-left'> Annuler</span>");
                    }
                });
            });
        </script>
    </body>
</html>
