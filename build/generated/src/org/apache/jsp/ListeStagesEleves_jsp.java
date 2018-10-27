package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ListeStagesEleves_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/menu.jsp");
    _jspx_dependants.add("/footer.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <title>Stages | Recherche</title>\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\r\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\"></script>\r\n");
      out.write("        <link href=\"./css/style.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <!-- Barre de navigation -->\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<nav class=\"navbar navbar-default navbar-fixed-top\" role=\"navigation\" id=\"menu\">\r\n");
      out.write("    <div class=\"container-fluid\">\r\n");
      out.write("        <div clas=\"navbar-header\">\r\n");
      out.write("            <button type=\"button\" class=\"navbar-toggle\" id=\"btnMenuColl\"data-toggle=\"collapse\" data-target=\"#navbar-collapse-main\">\r\n");
      out.write("                <span class=\"icon-bar\"></span>\r\n");
      out.write("                <span class=\"icon-bar\"></span>\r\n");
      out.write("                <span class=\"icon-bar\"></span>\r\n");
      out.write("            </button>\r\n");
      out.write("            <a class=\"navbar-brand\" href=\"http://www.crosemont.qc.ca/\"><img id=\"logo\" src=\"./images/logoCouper.png\"/></a>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"collapse navbar-collapse\" id=\"navbar-collapse-main\">\r\n");
      out.write("            <div id=\"choixMenu\">\r\n");
      out.write("                <ul class=\"nav navbar-nav navbar-left\">\r\n");
      out.write("                    <li><a class=\"#\" href=\"\">Mon profil</a></li>\r\n");
      out.write("                    <li><a class=\"#\" href=\"\">Offres de stage</a></li>\r\n");
      out.write("                    <li><a class=\"#\" href=\"\">Documents</a></li>\r\n");
      out.write("                    <li><a class=\"#\" href=\"\">Recherche Étudiant</a></li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</nav>\r\n");
      out.write("\r\n");
      out.write("        <!-- Fin de la barre de navigation -->\r\n");
      out.write("\r\n");
      out.write("        <!-- Contenu de la page -->\r\n");
      out.write("        <div class=\"container-fluid\" id=\"contenuPage\">\r\n");
      out.write("            <!-- Section de recherche par competences -->\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"col-lg-5\">\r\n");
      out.write("                    <h2>Recherche par compétences</h2>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-lg-7\">\r\n");
      out.write("                    <!-- bouton pour la liste -->\r\n");
      out.write("                    <div class=\"col-lg-2\">\r\n");
      out.write("                        <a class=\"btn btn-primary dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">Comptétences <span class=\"caret\"></span></a>\r\n");
      out.write("                        <ul class=\"dropdown-menu\">\r\n");
      out.write("                            <li class=\"dropdown-item px-2\" onclick=\"ajouterCompetence('php')\">php</li>\r\n");
      out.write("                            <li class=\"dropdown-item px-2\" onclick=\"ajouterCompetence('html')\">html</li>\r\n");
      out.write("                            <li class=\"dropdown-item px-2\" onclick=\"ajouterCompetence('java')\">java</li>\r\n");
      out.write("                            <li class=\"dropdown-item px-2\" onclick=\"ajouterCompetence('c')\">c</li>\r\n");
      out.write("                            <li class=\"dropdown-item px-2\" onclick=\"ajouterCompetence('c++')\">c++</li>\r\n");
      out.write("                            <li class=\"dropdown-item px-2\" onclick=\"ajouterCompetence('c#')\">c#</li>\r\n");
      out.write("                            <li class=\"dropdown-item px-2\" onclick=\"ajouterCompetence('python')\">python</li>\r\n");
      out.write("                            <li class=\"dropdown-item px-2\" onclick=\"ajouterCompetence('VB')\">VB</li>\r\n");
      out.write("                            <li class=\"dropdown-item px-2\" onclick=\"ajouterCompetence('java EE')\">java EE</li>\r\n");
      out.write("                            <li class=\"dropdown-item px-2\" onclick=\"ajouterCompetence('ruby')\">ruby</li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    \r\n");
      out.write("                    <!-- Conteneur de comperence -->\r\n");
      out.write("                    <div class=\"col-lg-10\">\r\n");
      out.write("                        <div class=\"card\">\r\n");
      out.write("                            <div id=\"conteneurCompetences\" class=\"card-body\"></div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- Fin de section de recherche par competances -->\r\n");
      out.write("\r\n");
      out.write("            <!-- Section de recherche des stages -->\r\n");
      out.write("            <div class=\"row\" id=\"rechercheStage\">\r\n");
      out.write("                <div class=\"col-lg-12\">\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("                    <div class=\"col-lg-4\"><h2>Recherche par mots-clés</h2></div>\r\n");
      out.write("                    <!-- Barre de recherche -->\r\n");
      out.write("                    <form class=\"col-lg-7\">\r\n");
      out.write("                        <div class=\"input-group\">\r\n");
      out.write("                            <div class=\"input-group-btn\">\r\n");
      out.write("                                <button class=\"btn btn-default\" type=\"submit\"><i class=\"fas fa-search\"></i></button>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <input id=\"inputRecherche\" type=\"text\" class=\"form-control\" placeholder=\"Search\">\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </form>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <!-- Fin de la barre de recherche -->\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-lg-12\">\r\n");
      out.write("                    <table class=\"table table-striped\">\r\n");
      out.write("                        <thead>\r\n");
      out.write("                            <tr>\r\n");
      out.write("                                <td>Compagnie <a href=\"#\" class=\"fa fa-arrows-alt-v\"></a></td>\r\n");
      out.write("                                <td>Spécialité <a href=\"#\" class=\"fa fa-arrows-alt-v\"></a></td>\r\n");
      out.write("                                <td>Poste <a href=\"#\" class=\"fa fa-arrows-alt-v\"></a></td>\r\n");
      out.write("                                <td>Places <a href=\"#\" class=\"fa fa-arrows-alt-v\"></a></td>\r\n");
      out.write("                                <td>Rémunération <a href=\"#\" class=\"fa fa-arrows-alt-v\"></a></td>\r\n");
      out.write("                                <td>Match <a href=\"#\" class=\"fa fa-arrows-alt-v\"></a></td>\r\n");
      out.write("                                <td>Statut <a href=\"#\" class=\"fa fa-arrows-alt-v\"></a></td>\r\n");
      out.write("                            </tr>\r\n");
      out.write("                        </thead>\r\n");
      out.write("                        <tbody>\r\n");
      out.write("                            <tr>\r\n");
      out.write("                                <td><a href=\"pommes.com\">pomme</a></td>\r\n");
      out.write("                                <td>Programmation</td>\r\n");
      out.write("                                <td>Programmeur Web</td>\r\n");
      out.write("                                <td>1</td>\r\n");
      out.write("                                <td>0$/hr</td>\r\n");
      out.write("                                <td>87%</td>\r\n");
      out.write("                                <td>1</td>\r\n");
      out.write("                            </tr>\r\n");
      out.write("                            <tr>\r\n");
      out.write("                                <td><a href=\"pommes.com\">pomme</a></td>\r\n");
      out.write("                                <td>Programmation</td>\r\n");
      out.write("                                <td>Programmeur Web</td>\r\n");
      out.write("                                <td>1</td>\r\n");
      out.write("                                <td>0$/hr</td>\r\n");
      out.write("                                <td>87%</td>\r\n");
      out.write("                                <td>1</td>\r\n");
      out.write("                            </tr>\r\n");
      out.write("                            <tr>\r\n");
      out.write("                                <td><a href=\"pommes.com\">pomme</a></td>\r\n");
      out.write("                                <td>Programmation</td>\r\n");
      out.write("                                <td>Programmeur Web</td>\r\n");
      out.write("                                <td>1</td>\r\n");
      out.write("                                <td>0$/hr</td>\r\n");
      out.write("                                <td>87%</td>\r\n");
      out.write("                                <td>1</td>\r\n");
      out.write("                            </tr>\r\n");
      out.write("                            <tr>\r\n");
      out.write("                                <td><a href=\"pommes.com\">pomme</a></td>\r\n");
      out.write("                                <td>Programmation</td>\r\n");
      out.write("                                <td>Programmeur Web</td>\r\n");
      out.write("                                <td>1</td>\r\n");
      out.write("                                <td>0$/hr</td>\r\n");
      out.write("                                <td>87%</td>\r\n");
      out.write("                                <td>1</td>\r\n");
      out.write("                            </tr>\r\n");
      out.write("                            <tr>\r\n");
      out.write("                                <td><a href=\"pommes.com\">pomme</a></td>\r\n");
      out.write("                                <td>Programmation</td>\r\n");
      out.write("                                <td>Programmeur Web</td>\r\n");
      out.write("                                <td>1</td>\r\n");
      out.write("                                <td>0$/hr</td>\r\n");
      out.write("                                <td>87%</td>\r\n");
      out.write("                                <td>1</td>\r\n");
      out.write("                            </tr>\r\n");
      out.write("                        </tbody>\r\n");
      out.write("                    </table>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- Fin de la section de recherche des stages -->\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <!-- Footer -->\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<footer id=\"footer\" class=\"container-fluid text-center\">\r\n");
      out.write("    <p>&copy; Copyright 2018, Nom Site.</p>\r\n");
      out.write("</footer>\r\n");
      out.write("\r\n");
      out.write("        <!-- Fin footer -->\r\n");
      out.write("        <script>\r\n");
      out.write("            var nbComp = 0;\r\n");
      out.write("            function ajouterCompetence(nom){\r\n");
      out.write("                document.getElementById(\"conteneurCompetences\").innerHTML += \"<span class='competence' id='competence\"+nbComp+\"'>\"+nom+\" <a class='fas fa-times' onclick='enleverCompetence(\"+nbComp+\")'></a></span>\";\r\n");
      out.write("                $(\".competence\").addClass(\"alert-primary\")\r\n");
      out.write("                        .css(\"padding\",\"5px 8px 5px 8px\");\r\n");
      out.write("                nbComp++;\r\n");
      out.write("            };\r\n");
      out.write("            function enleverCompetence(i){\r\n");
      out.write("                document.getElementById(\"competence\"+i).remove();\r\n");
      out.write("            }\r\n");
      out.write("        </script>\r\n");
      out.write("    </body>\r\n");
      out.write("</html> \r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
