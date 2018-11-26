<%-- 
    Document   : profilCompagnieVueAdministrateur
    Created on : 2018-11-22, 08:23:49
    Author     : usager
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Stages | Compagnie</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.2/css/all.css" integrity="sha384-/rXc/GQVaYpyDdyxK+ecHPVYJSN9bmVFBvjA/9eOB+pb3F2w2N6fc5qB9Ew5yIns" crossorigin="anonymous">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="./css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include  file="menu.jsp" %>
        <div class="container-fluid conteneur" >
            <div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
                <div class="row entete">
                    <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 nomCompagnie">
                        <h1>Max Compagnie</h1>
                    </div>
                    <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                        <div class="infoCon">
                            <div class="row lienSite">
                                    <a>www.max.com</a>
                            </div>
                            <div class="row infoContact">
                                    <span class="nomEmployeur">Gabriel Laverdure </span>
                                    <span class="numeroEmployeur"> 514-990-9921</span>
                            </div>
                            <div class="row AdresseCourriel">
                                    <a>Max@hot.ca</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">

                    <div class="panel panel-default description">
                        <div class="panel-heading sousTitre">
                            Description
                        </div>
                        <div class="panel-body">
                            Cette compagnie ce spécialise en ...
                        </div>
                    </div>
                </div>
                
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                        <div class="panel panel-default ">
                            <div class="panel-heading sousTitre">
                                Stages offerts
                            </div>
                            <div class="stageInfo">
                            <table class="table table-striped">
                                <thead>
                                    <tr>
                                        <td>Compagnie <a href="#" class="fa fa-arrows-alt-v"></a></td>
                                        <td>Spécialité <a href="#" class="fa fa-arrows-alt-v"></a></td>
                                        <td>Poste <a href="#" class="fa fa-arrows-alt-v"></a></td>
                                        <td>Places <a href="#" class="fa fa-arrows-alt-v"></a></td>
                                        <td>Rémunération <a href="#" class="fa fa-arrows-alt-v"></a></td>
                                        <td>Match <a href="#" class="fa fa-arrows-alt-v"></a></td>
                                        <td>Statut <a href="#" class="fa fa-arrows-alt-v"></a></td>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td><a href="pomme.com">pomme</a></td>
                                        <td>Programmation</td>
                                        <td>Programmeur Web</td>
                                        <td>1</td>
                                        <td>0$/hr</td>
                                        <td>87%</td>
                                        <td>1</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 conteneurStageCompagnie">
                <div class="panel panel-default">
                    <div class="panel-heading titreStage">
                            Information stage:
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="panel panel-default comp">
                                <div class="panel-heading">
                                    <div class="row">
                                        <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 sousTitre">
                                            Programmation Web
                                        </div>
                                        <div class="text-right col-lg-4 col-md-4 col-sm-4 col-xs-4 pourcentageCompatible">
                                            87%
                                        </div>
                                    </div>
                                </div>
                                <div class="panel-body informationC">
                                        allo je suis maxime et toi ? sssss ssssss ssssssss ssssss sssss 
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="panel panel-default comp">
                                <div class="panel-heading sousTitre">
                                        Compétences
                                </div>   
                                <div class="panel-body listeCompetence">
                                        css
                                 </div>
                            </div>
                        </div>
                        <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 remuneration">
                            Rémunération: 0$/h
                        </div>
                        <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                            <button class="btn btn-default" value="Postuler">Postuler</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
