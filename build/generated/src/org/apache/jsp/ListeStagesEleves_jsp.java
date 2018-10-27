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
    _jspx_dependants.add("/navBar.jsp");
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Stages | Accueil</title>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.4.1/css/all.css\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <!-- Barre de navigation -->\n");
      out.write("        ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<!-- Barre de navigation -->\r\n");
      out.write("<nav class=\"navbar navbar-expand-sm bg-light navbar-light fixed-top\" id=\"collapsibleNavbar\">\r\n");
      out.write("    <!-- Titre de la barre de tache -->\r\n");
      out.write("    <a class=\"navbar-brand lienImageBarre\" href=\"#\"></a>\r\n");
      out.write("    <a class=\"navbar-brand lienBarreTitre\" href=\"#\">Gestion de stage</a>\r\n");
      out.write("\r\n");
      out.write("    <!-- Toggler/collapsibe Button -->\r\n");
      out.write("    <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#collapsibleNavbar\">\r\n");
      out.write("        <span class=\"navbar-toggler-icon\"></span>\r\n");
      out.write("    </button>\r\n");
      out.write("\r\n");
      out.write("    <!-- Liste des liens -->\r\n");
      out.write("    <div class=\"collapse navbar-collapse\" id=\"collapsibleNavbar\">\r\n");
      out.write("        <ul class=\"navbar-nav\" id=\"barreNav\">\r\n");
      out.write("            <li class=\"nav-item\">\r\n");
      out.write("                <a class=\"nav-link lienBarre\" href=\"#\">Mon profil</a>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li class=\"nav-item\">\r\n");
      out.write("                <a class=\"nav-link lienBarre\" href=\"#\">Offres de stage</a>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li class=\"nav-item\">\r\n");
      out.write("                <a class=\"nav-link lienBarre\" href=\"#\">Documents</a>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li class=\"nav-item\">\r\n");
      out.write("                <a class=\"nav-link lienBarre\" href=\"#\">Paramètres</a>\r\n");
      out.write("            </li>\r\n");
      out.write("        </ul>\r\n");
      out.write("    </div>\r\n");
      out.write("</nav>\r\n");
      out.write("<!-- Fin de la barre de navigation -->\r\n");
      out.write("\n");
      out.write("        <!-- Fin de la barre de navigation -->\n");
      out.write("\n");
      out.write("        <!-- Contenu de la page -->\n");
      out.write("        <div class=\"container-fluid\" id=\"contenuPage\">\n");
      out.write("            <!-- Section de recherche par competences -->\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-lg-5\">\n");
      out.write("                    <h2>Recherche par compétences</h2>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-lg-7\">\n");
      out.write("                    <!-- bouton pour la liste -->\n");
      out.write("                    <div class=\"col-lg-2\">\n");
      out.write("                        <a class=\"btn btn-primary dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">Comptétences <span class=\"caret\"></span></a>\n");
      out.write("                        <ul class=\"dropdown-menu\">\n");
      out.write("                            <li class=\"dropdown-item px-2\" onclick=\"ajouterCompetence('php')\">php</li>\n");
      out.write("                            <li class=\"dropdown-item px-2\" onclick=\"ajouterCompetence('html')\">html</li>\n");
      out.write("                            <li class=\"dropdown-item px-2\" onclick=\"ajouterCompetence('java')\">java</li>\n");
      out.write("                            <li class=\"dropdown-item px-2\" onclick=\"ajouterCompetence('c')\">c</li>\n");
      out.write("                            <li class=\"dropdown-item px-2\" onclick=\"ajouterCompetence('c++')\">c++</li>\n");
      out.write("                            <li class=\"dropdown-item px-2\" onclick=\"ajouterCompetence('c#')\">c#</li>\n");
      out.write("                            <li class=\"dropdown-item px-2\" onclick=\"ajouterCompetence('python')\">python</li>\n");
      out.write("                            <li class=\"dropdown-item px-2\" onclick=\"ajouterCompetence('VB')\">VB</li>\n");
      out.write("                            <li class=\"dropdown-item px-2\" onclick=\"ajouterCompetence('java EE')\">java EE</li>\n");
      out.write("                            <li class=\"dropdown-item px-2\" onclick=\"ajouterCompetence('ruby')\">ruby</li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                    \n");
      out.write("                    <!-- Conteneur de comperence -->\n");
      out.write("                    <div class=\"col-lg-10\">\n");
      out.write("                        <div class=\"card\">\n");
      out.write("                            <div id=\"conteneurCompetences\" class=\"card-body\"></div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <!-- Fin de section de recherche par competances -->\n");
      out.write("\n");
      out.write("            <!-- Section de recherche des stages -->\n");
      out.write("            <div class=\"row\" id=\"rechercheStage\">\n");
      out.write("                <div class=\"col-lg-12\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                    <div class=\"col-lg-4\"><h2>Recherche par mots-clés</h2></div>\n");
      out.write("                    <!-- Barre de recherche -->\n");
      out.write("                    <form class=\"col-lg-7\">\n");
      out.write("                        <div class=\"input-group\">\n");
      out.write("                            <div class=\"input-group-btn\">\n");
      out.write("                                <button class=\"btn btn-default\" type=\"submit\"><i class=\"fas fa-search\"></i></button>\n");
      out.write("                            </div>\n");
      out.write("                            <input id=\"inputRecherche\" type=\"text\" class=\"form-control\" placeholder=\"Search\">\n");
      out.write("                        </div>\n");
      out.write("                    </form>\n");
      out.write("                    </div>\n");
      out.write("                    <!-- Fin de la barre de recherche -->\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-lg-12\">\n");
      out.write("                    <table class=\"table table-striped\">\n");
      out.write("                        <thead>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Compagnie <a href=\"#\" class=\"fa fa-arrows-alt-v\"></a></td>\n");
      out.write("                                <td>Spécialité <a href=\"#\" class=\"fa fa-arrows-alt-v\"></a></td>\n");
      out.write("                                <td>Poste <a href=\"#\" class=\"fa fa-arrows-alt-v\"></a></td>\n");
      out.write("                                <td>Places <a href=\"#\" class=\"fa fa-arrows-alt-v\"></a></td>\n");
      out.write("                                <td>Rémunération <a href=\"#\" class=\"fa fa-arrows-alt-v\"></a></td>\n");
      out.write("                                <td>Match <a href=\"#\" class=\"fa fa-arrows-alt-v\"></a></td>\n");
      out.write("                                <td>Statut <a href=\"#\" class=\"fa fa-arrows-alt-v\"></a></td>\n");
      out.write("                            </tr>\n");
      out.write("                        </thead>\n");
      out.write("                        <tbody>\n");
      out.write("                            <tr>\n");
      out.write("                                <td><a href=\"pommes.com\">pomme</a></td>\n");
      out.write("                                <td>Programmation</td>\n");
      out.write("                                <td>Programmeur Web</td>\n");
      out.write("                                <td>1</td>\n");
      out.write("                                <td>0$/hr</td>\n");
      out.write("                                <td>87%</td>\n");
      out.write("                                <td>1</td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td><a href=\"pommes.com\">pomme</a></td>\n");
      out.write("                                <td>Programmation</td>\n");
      out.write("                                <td>Programmeur Web</td>\n");
      out.write("                                <td>1</td>\n");
      out.write("                                <td>0$/hr</td>\n");
      out.write("                                <td>87%</td>\n");
      out.write("                                <td>1</td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td><a href=\"pommes.com\">pomme</a></td>\n");
      out.write("                                <td>Programmation</td>\n");
      out.write("                                <td>Programmeur Web</td>\n");
      out.write("                                <td>1</td>\n");
      out.write("                                <td>0$/hr</td>\n");
      out.write("                                <td>87%</td>\n");
      out.write("                                <td>1</td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td><a href=\"pommes.com\">pomme</a></td>\n");
      out.write("                                <td>Programmation</td>\n");
      out.write("                                <td>Programmeur Web</td>\n");
      out.write("                                <td>1</td>\n");
      out.write("                                <td>0$/hr</td>\n");
      out.write("                                <td>87%</td>\n");
      out.write("                                <td>1</td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td><a href=\"pommes.com\">pomme</a></td>\n");
      out.write("                                <td>Programmation</td>\n");
      out.write("                                <td>Programmeur Web</td>\n");
      out.write("                                <td>1</td>\n");
      out.write("                                <td>0$/hr</td>\n");
      out.write("                                <td>87%</td>\n");
      out.write("                                <td>1</td>\n");
      out.write("                            </tr>\n");
      out.write("                        </tbody>\n");
      out.write("                    </table>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <!-- Fin de la section de recherche des stages -->\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!-- Footer -->\n");
      out.write("        ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<footer id=\"footer\" class=\"container-fluid text-center\">\r\n");
      out.write("    <p>&copy; Copyright 2018, Nom Site.</p>\r\n");
      out.write("</footer>\r\n");
      out.write("\n");
      out.write("        <!-- Fin footer -->\n");
      out.write("        <script>\n");
      out.write("            var nbComp = 0;\n");
      out.write("            function ajouterCompetence(nom){\n");
      out.write("                document.getElementById(\"conteneurCompetences\").innerHTML += \"<span class='competence' id='competence\"+nbComp+\"'>\"+nom+\" <a class='fas fa-times' onclick='enleverCompetence(\"+nbComp+\")'></a></span>\";\n");
      out.write("                $(\".competence\").addClass(\"alert-primary\")\n");
      out.write("                        .css(\"padding\",\"5px 8px 5px 8px\");\n");
      out.write("                nbComp++;\n");
      out.write("            };\n");
      out.write("            function enleverCompetence(i){\n");
      out.write("                document.getElementById(\"competence\"+i).remove();\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html> \n");
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
