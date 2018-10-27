package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class profilEtudiant_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <div class=\"container-fluid\" id=\"profilEtu\">\n");
      out.write("            <form>\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-lg-4 col-md-5 col-sm-6\" id=\"contenuGauche\">\n");
      out.write("                        <h2>Profil rempli à <span id=\"completionProfil\">0%</span></h2>\n");
      out.write("                        <div class=\"container-fluid\" id=\"infoBase\">\n");
      out.write("                            <div class=\"form-group row\">\n");
      out.write("                                <label for=\"nom\" class=\"col-sm-4 col-form-label\">Nom :</label>\n");
      out.write("                                <div class=\"col-sm-7\">\n");
      out.write("                                  <input type=\"text\" class=\"form-control\" id=\"nom\" placeholder=\"John\">\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group row\">\n");
      out.write("                                <label for=\"prenom\" class=\"col-sm-3 col-form-label\">Prénom :</label>\n");
      out.write("                                <div class=\"col-sm-7\">\n");
      out.write("                                  <input type=\"text\" class=\"form-control\" id=\"prenom\" placeholder=\"Doe\">\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group row\">\n");
      out.write("                                <label for=\"tel\" class=\"col-sm-3 col-form-label\">Téléphone :</label>\n");
      out.write("                                <div class=\"col-sm-7\">\n");
      out.write("                                  <input type=\"text\" class=\"form-control\" id=\"tel\" placeholder=\"(514)-389-7630\">\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group row\">\n");
      out.write("                                <label for=\"email\" class=\"col-sm-3 col-form-label\">Courriel :</label>\n");
      out.write("                                <div class=\"col-sm-7\">\n");
      out.write("                                  <input type=\"email\" class=\"form-control\" id=\"email\" placeholder=\"JDoe06@gmail.com\">\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group row\">\n");
      out.write("                                <label for=\"cv\" class=\"col-sm-3 col-form-label\">CV :</label>\n");
      out.write("                                <div class=\"col-sm-7\">\n");
      out.write("                                  <input type=\"text\" class=\"form-control\" id=\"cv\">\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group row\">\n");
      out.write("                                <label for=\"relNote\" class=\"col-sm-3 col-form-label\">Relevé de notes :</label>\n");
      out.write("                                <div class=\"col-sm-7\">\n");
      out.write("                                  <input type=\"text\" class=\"form-control\" id=\"relNote\">\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group row\">\n");
      out.write("                                <label for=\"lK\" class=\"col-sm-3 col-form-label\">LinkedIn :</label>\n");
      out.write("                                <div class=\"col-sm-7\">\n");
      out.write("                                  <input type=\"text\" class=\"form-control\" id=\"lK\">\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group row\">\n");
      out.write("                                <label for=\"git\" class=\"col-sm-3 col-form-label\">Github :</label>\n");
      out.write("                                <div class=\"col-sm-7\">\n");
      out.write("                                  <input type=\"text\" class=\"form-control\" id=\"git\" >\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-lg-6\" id=\"contenuDroit\">\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-lg-4\" id=\"contenuDroitOB\">\n");
      out.write("                                <div class=\"form-group row\">\n");
      out.write("                                    <label for=\"spec\" class=\"col-sm-4 col-form-label\">Spécialité :</label>\n");
      out.write("                                    <div class=\"col-sm-8\">\n");
      out.write("                                      <select class=\"form-control\" id=\"spec\">\n");
      out.write("                                        <option>Réseaux</option>\n");
      out.write("                                        <option>Programmation</option>\n");
      out.write("                                      </select>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-lg-6\" id=\"boxStats\">\n");
      out.write("                                <h3><span class=\"couleurStat\">3</span> canditatures envoyées</h3>\n");
      out.write("                                <h3><span class=\"couleurStat\">15 jours</span> de recherche</h3>\n");
      out.write("                                <h3>CV lu:<span class=\"couleurStat\"> 10</span> fois</h3>\n");
      out.write("                                <h3>Consultation du profil:<span class=\"couleurStat\"> 104</span> fois</h3>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-lg-5\">\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label for=\"recherche\">Ce que je recherche:</label>\n");
      out.write("                                    <textarea class=\"form-control\" rows=\"3\" id=\"recherche\"></textarea>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-lg-5\">\n");
      out.write("                            </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </form>\n");
      out.write("            <div class=\"row\">\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<footer id=\"footer\" class=\"container-fluid text-center\">\r\n");
      out.write("    <p>&copy; Copyright 2018, Nom Site.</p>\r\n");
      out.write("</footer>\r\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
