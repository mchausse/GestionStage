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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Stages | Accueil</title>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.4.1/css/all.css\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
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
      out.write("\n");
      out.write("        <div class=\"container\" id=\"profilEtu\">\n");
      out.write("            <h2>Profil rempli à <span id=\"completionProfil\">0%</span></h2>\n");
      out.write("            <form class=\"form-horizontal\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-lg-5\" id=\"contenuGauche\">\n");
      out.write("                        <div class=\"container-fluid\" id=\"infoBase\">\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"nom\" class=\"col-sm-3 col-form-label\">Nom :</label>\n");
      out.write("                                <div class=\"col-sm-8\">\n");
      out.write("                                  <input type=\"text\" class=\"form-control\" id=\"nom\" placeholder=\"John\">\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"prenom\" class=\"col-sm-3 col-form-label\">Prénom :</label>\n");
      out.write("                                <div class=\"col-sm-8\">\n");
      out.write("                                  <input type=\"text\" class=\"form-control\" id=\"prenom\" placeholder=\"Doe\">\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"tel\" class=\"col-sm-3 col-form-label\">Téléphone :</label>\n");
      out.write("                                <div class=\"col-sm-8\">\n");
      out.write("                                  <input type=\"text\" class=\"form-control\" id=\"tel\" placeholder=\"(514)-389-7630\">\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"email\" class=\"col-sm-3 col-form-label\">Courriel :</label>\n");
      out.write("                                <div class=\"col-sm-8\">\n");
      out.write("                                  <input type=\"email\" class=\"form-control\" id=\"email\" placeholder=\"JDoe06@gmail.com\">\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"cv\" class=\"col-sm-3 col-form-label\">CV :</label>\n");
      out.write("                                <div class=\"col-sm-8 input-group\">\n");
      out.write("                                    <label class=\"input-group-btn\">\n");
      out.write("                                        <span class=\"btn btn-primary\">\n");
      out.write("                                            Ajouter<input type=\"file\" lass=\"form-control-file\" accept=\"application/pdf\" style=\"display: none;\" id=\"cv\">\n");
      out.write("                                        </span>\n");
      out.write("                                    </label>\n");
      out.write("                                    <select class=\"form-control\" id=\"cvListe\" readonly>\n");
      out.write("                                        <option>cv_C#.pdf</option>\n");
      out.write("                                        <option>cvJavaEE.pdf</option>\n");
      out.write("                                    </select>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"relNote\" class=\"col-sm-3 col-form-label\">Relevé de notes :</label>\n");
      out.write("                                <div class=\"col-sm-8 input-group\">\n");
      out.write("                                    <label class=\"input-group-btn\">\n");
      out.write("                                        <span class=\"btn btn-primary\">\n");
      out.write("                                            Ajouter<input type=\"file\" lass=\"form-control-file\" accept=\"application/pdf\" style=\"display: none;\" id=\"relNote\" multiple>\n");
      out.write("                                        </span>\n");
      out.write("                                    </label>\n");
      out.write("                                    <input type=\"text\" class=\"form-control\" readonly id=\"relNoteNom\">\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"lK\" class=\"col-sm-3 col-form-label\">LinkedIn :</label>\n");
      out.write("                                <div class=\"col-sm-8\">\n");
      out.write("                                  <input type=\"text\" class=\"form-control\" id=\"lK\">\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"git\" class=\"col-sm-3 col-form-label\">Github :</label>\n");
      out.write("                                <div class=\"col-sm-8\">\n");
      out.write("                                  <input type=\"text\" class=\"form-control\" id=\"git\" >\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    \n");
      out.write("                    <div class=\"col-lg-5\" id=\"contenuDroit\">\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <table  id=\"competence\" class=\"table table-hover\">\n");
      out.write("                                <thead>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td>Compétences <a href=\"#\" class=\"fa fa-arrows-alt-v\"></a></td>\n");
      out.write("                                        <td>Domaine <a href=\"#\" class=\"fa fa-arrows-alt-v\"></a></td>\n");
      out.write("                                        <td>Niveau <a href=\"#\" class=\"fa fa-arrows-alt-v\"></a></td>\n");
      out.write("                                    </tr>\n");
      out.write("                                </thead>\n");
      out.write("                                <tbody>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td>Java EE</td>\n");
      out.write("                                        <td>BackEnd</td>\n");
      out.write("                                        <td>\n");
      out.write("                                            <select class=\"form-control\">\n");
      out.write("                                                <option>Aucun</option>\n");
      out.write("                                                <option>Débutant</option>\n");
      out.write("                                                <option>Intermédiare</option>\n");
      out.write("                                                <option>Expert</option>\n");
      out.write("                                            </select>\n");
      out.write("                                        </td>\n");
      out.write("                                    </tr>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td>CSS</td>\n");
      out.write("                                        <td>FrontEnd</td>\n");
      out.write("                                        <td>\n");
      out.write("                                            <select class=\"form-control\">\n");
      out.write("                                                <option>Aucun</option>\n");
      out.write("                                                <option>Débutant</option>\n");
      out.write("                                                <option>Intermédiare</option>\n");
      out.write("                                                <option>Expert</option>\n");
      out.write("                                            </select>\n");
      out.write("                                        </td>\n");
      out.write("                                    </tr>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td>Git</td>\n");
      out.write("                                        <td>Versionnage</td>\n");
      out.write("                                        <td>\n");
      out.write("                                            <select class=\"form-control\">\n");
      out.write("                                                <option>Aucun</option>\n");
      out.write("                                                <option>Débutant</option>\n");
      out.write("                                                <option>Intermédiare</option>\n");
      out.write("                                                <option>Expert</option>\n");
      out.write("                                            </select>\n");
      out.write("                                        </td>\n");
      out.write("                                    </tr>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td>C#</td>\n");
      out.write("                                        <td>BackEnd</td>\n");
      out.write("                                        <td>\n");
      out.write("                                            <select class=\"form-control\">\n");
      out.write("                                                <option>Aucun</option>\n");
      out.write("                                                <option>Débutant</option>\n");
      out.write("                                                <option>Intermédiare</option>\n");
      out.write("                                                <option>Expert</option>\n");
      out.write("                                            </select>\n");
      out.write("                                        </td>\n");
      out.write("                                    </tr>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td>Service à la clientèle</td>\n");
      out.write("                                        <td>Autre</td>\n");
      out.write("                                        <td>\n");
      out.write("                                            <select class=\"form-control\">\n");
      out.write("                                                <option>Aucun</option>\n");
      out.write("                                                <option>Débutant</option>\n");
      out.write("                                                <option>Intermédiare</option>\n");
      out.write("                                                <option>Expert</option>\n");
      out.write("                                            </select>\n");
      out.write("                                        </td>\n");
      out.write("                                    </tr>\n");
      out.write("                                </tbody>\n");
      out.write("                            </table>\n");
      out.write("                        </div>\n");
      out.write("                    </div>    \n");
      out.write("                </div>\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <table id=\"stage\" class=\"table table-hover\">\n");
      out.write("                        <thead>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Compagnie <a href=\"#\" class=\"fa fa-arrows-alt-v\"></a></td>\n");
      out.write("                                <td>Poste <a href=\"#\" class=\"fa fa-arrows-alt-v\"></a></td>\n");
      out.write("                                <td>Date de contact <a href=\"#\" class=\"fa fa-arrows-alt-v\"></a></td>\n");
      out.write("                                <td>Statut <a href=\"#\" class=\"fa fa-arrows-alt-v\"></a></td>\n");
      out.write("                            </tr>\n");
      out.write("                        </thead>\n");
      out.write("                        <tbody>\n");
      out.write("                            <tr>\n");
      out.write("                                <td><a href=\"DealerB\">Dealer Breacher</a></td>\n");
      out.write("                                <td>Programmeur Web</td>\n");
      out.write("                                <td>12/10/2018</td>\n");
      out.write("                                <td>En attente</td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td><a href=\"Google\">Google</a></td>\n");
      out.write("                                <td>Soutien Technique</td>\n");
      out.write("                                <td>12/10/2018</td>\n");
      out.write("                                <td>Reçu</td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td><a href=\"HydroQc\">Hydro Québec</a></td>\n");
      out.write("                                <td>Programmation</td>\n");
      out.write("                                <td>12/10/2018</td>\n");
      out.write("                                <td>Reçu</td>\n");
      out.write("                            </tr>\n");
      out.write("                        </tbody>\n");
      out.write("                    </table>\n");
      out.write("                </div>\n");
      out.write("            </form>\n");
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
      out.write("</html>");
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
