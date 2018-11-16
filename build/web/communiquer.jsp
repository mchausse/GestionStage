<%-- 
    Document   : Communiquer
    Created on : Nov 9, 2018, 3:07:46 PM
    Author     : mchausse
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Stages | Communication</title>
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
        <!-- Fin barre de navigation -->
        
        <div class='container-fluid'>
            <div id="contenuPage">
                
                <!-- Titre de la page -->
                <div class="row">
                <div class="col-lg-1"></div><!-- Sert de margin -->
                    <div class="col-lg-4">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3>
                                    <span id='btnDescTitrePage' class='glyphicon glyphicon-triangle-bottom'></span>
                                    Communication
                                </h3>
                                <p id='descTitrePage'>
                                    Ici, vous pouvez voir vos messages reçus et envoyés ainsi que les brouillons sauvegardés.
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Fin du titre de la page-->
                
                <div class="col-lg-1"></div><!-- Sert de margin -->
                
                <!-- Debut de la section du menu des messages -->
                <div class="col-lg-2">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Menu
                        </div>
                        
                        <!-- Liste des options du menu -->
                        <div class="panel-body">
                            <div class="col-lg-12">
                                <a href="#" class="btn btn-danger btn-lg btnMenu">
                                    <span class="badge">5</span>
                                    <span class="glyphicon glyphicon-inbox"> Reçus</span>
                                </a>
                                <a href="#" class="btn btn-default btn-lg btnMenu">
                                    <span class="glyphicon glyphicon-arrow-left"> Envoyés</span>
                                </a>
                                <a href="#" class="btn btn-default btn-lg btnMenu">
                                    <span class="badge">1</span>
                                    <span class="glyphicon glyphicon-floppy-disk"> Sauvegardés</span>
                                </a>
                            </div>
                        </div>
                        <!-- Fin de la liste des options du menu -->
                        
                    </div>
                </div>
                <!-- Fin de la section du menu des messages -->
                
                <!-- Debut de la section de la liste de messages -->
                <div class="col-lg-3">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Messages recus
                        </div>
                        <div id="messages" class="panel-body">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <span class="label label-danger label-as-badge">&#8203 &#8203</span>
                                    <kbd>Activix</kbd> 
                                    Maxime 
                                </div>
                                <div class="panel-body">Entrevue</div>
                            </div>
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <span class="label label-danger label-as-badge">&#8203 &#8203</span>
                                    <kbd>Wal-Mart</kbd>
                                    Charles
                                </div>
                                <div class="panel-body">Entrevue</div>
                            </div>
                            <!-- Mettre une separation entre les messages lus et les non-lus-->
                            <hr />
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <span class="label label-default label-as-badge">&#8203 &#8203</span>
                                    <kbd>Cosco</kbd>
                                    Abdelmounène 
                                </div>
                                <div class="panel-body">Entrevue</div>
                            </div>
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <span class="label label-default label-as-badge">&#8203 &#8203</span>
                                    <kbd>La belle province</kbd>
                                    Anne-Marie 
                                </div>
                                <div class="panel-body">Entrevue</div>
                            </div>
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <span class="label label-default label-as-badge">&#8203 &#8203</span>
                                    <kbd>Chez Rémi</kbd>
                                    Jean-Coutu 
                                </div>
                                <div class="panel-body">Entrevue</div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Fin de la section de la liste de messages -->
                
                <!-- Debut de la section dun message -->
                <div class="col-lg-5">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Message
                        </div>
                        <div class="panel-body message">
                            <div class="col-lg-12" id="messageEnvoyeur">
                                <label id="messageEnvoyeur"><b>Envoyeur : </b></label><span> Maxime <kbd>Activix</kbd></span>
                                <hr>
                            </div>
                            <div class="col-lg-12" id="messageTitre">
                                <label id="messageTitre"><b>Titre : </b></label><span> Entrevue</span>
                                <hr>
                            </div>
                            <pre id='texteMessage'>
Text in a pre element
is displayed in a fixed-width
font, and it preserves
both      spaces and
line breaks.Text in a pre element
is displayed in a fixed-width
font, and it preserves
both      spaces and
line breaks.

Text in a pre element
is displayed in a fixed-width
font, and it preserves
both      spaces and
line breaks.


font, and it preserves
both      spaces and
line breaks.
                            </pre>
                        </div>
                    </div>
                </div>
                <!-- Fin de la section dun message -->
                
                <div class="col-lg-1"></div><!-- Sert de margin -->
                
            </div>
        </div>
        
        <!-- Footer -->
        <%@include  file="footer.jsp" %>
        <!-- Fin footer -->
        
        <script>
            
            $(document).ready(function(){
                // Chacher le titre
                $("#descTitrePage").hide();
                
                $("#messages").hover(function(){
                    $(this).css("overflow-y","scroll");
                });
                $("#messages").mouseleave(function(){
                    $(this).css("overflow-y","hidden");
                });
                $("#texteMessage").hover(function(){
                    $(this).css("overflow-y","scroll");
                });
                $("#texteMessage").mouseleave(function(){
                    $(this).css("overflow-y","hidden");
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
