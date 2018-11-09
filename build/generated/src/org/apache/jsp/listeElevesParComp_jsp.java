package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class listeElevesParComp_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/menu.jsp");
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
      out.write("        <title>Stages | Liste Élèves</title>\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\r\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\r\n");
      out.write("        <link href=\"./css/style.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<nav class=\"navbar navbar-default navbar-fixed-top\" role=\"navigation\" id=\"menu\">\r\n");
      out.write("    <div class=\"container-fluid\">\r\n");
      out.write("        <div class=\"navbar-header\">\r\n");
      out.write("            <button type=\"button\" class=\"navbar-toggle\" id=\"btnMenuColl\" data-toggle=\"collapse\" data-target=\"#navbar-collapse-main\">\r\n");
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
      out.write("        <div class=\"container\" id=\"contenuListeEleve\">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"col-lg-5\"> <!-- partie gauche de la page -->\r\n");
      out.write("                    <select class=\"form-control\" id=\"selectionStage\">\r\n");
      out.write("                        <option value=\"progWeb\">Programmation web</option>\r\n");
      out.write("                        <option value=\"progC#\">Programmation C#</option>\r\n");
      out.write("                        <option value=\"progJava\">Programmation Java</option>\r\n");
      out.write("                    </select>\r\n");
      out.write("                    <br><!--Faire fonction onChange en JS pour loader les élèves dans les recherches-->\r\n");
      out.write("                    <input type=\"text\" class=\"form-control has-feedback\" id=\"rechercheEleve\" placeHolder=\"Rechercher ...\"style=\"border-radius: 50px;\">\r\n");
      out.write("                    <br>\r\n");
      out.write("                    <table class=\"table table-hover borderTable\">\r\n");
      out.write("                        <thead>\r\n");
      out.write("                          <tr>\r\n");
      out.write("                              <th>Nom <a class=\"sortBy\" href=\"#\"><span class=\"glyphicon glyphicon-sort-by-alphabet\"></span></a></th>\r\n");
      out.write("                              <th>Spécialité <a class=\"sortBy\" href=\"#\"><span class=\"glyphicon glyphicon-sort-by-alphabet\"></span></a></th>\r\n");
      out.write("                              <th>Match <a class=\"sortBy\" href=\"#\"><span class=\"glyphicon glyphicon-sort-by-order\"></span></a></th>\r\n");
      out.write("                              <th>Consulté <a class=\"sortBy\" href=\"#\"><span class=\"glyphicon glyphicon-sort\"></span></a></th>\r\n");
      out.write("                          </tr>\r\n");
      out.write("                        </thead>\r\n");
      out.write("                        <tbody>\r\n");
      out.write("                            <tr>\r\n");
      out.write("                                <td>Billy Bob</td>\r\n");
      out.write("                                <td>Réseau</td>\r\n");
      out.write("                                <td>88%</td>\r\n");
      out.write("                                <td><input type=\"checkbox\" checked disabled></td>\r\n");
      out.write("                            </tr>\r\n");
      out.write("                            <tr>\r\n");
      out.write("                                <td>Georges Dupont</td>\r\n");
      out.write("                                <td>Programmation Web</td>\r\n");
      out.write("                                <td>70%</td>\r\n");
      out.write("                                <td><input type=\"checkbox\" disabled></td>\r\n");
      out.write("                            </tr>\r\n");
      out.write("                            <tr>\r\n");
      out.write("                                <td>Slaver Dure</td>\r\n");
      out.write("                                <td>Gestion</td>\r\n");
      out.write("                                <td>90%</td>\r\n");
      out.write("                                <td><input type=\"checkbox\" checked disabled></td>\r\n");
      out.write("                            </tr>\r\n");
      out.write("                            <tr>\r\n");
      out.write("                                <td>Jeff Jefferson</td>\r\n");
      out.write("                                <td>Programmation Web</td>\r\n");
      out.write("                                <td>99%</td>\r\n");
      out.write("                                <td><input type=\"checkbox\" disabled></td>\r\n");
      out.write("                            </tr>\r\n");
      out.write("                            <tr>\r\n");
      out.write("                                <td>Pablo Esobar</td>\r\n");
      out.write("                                <td>Gestion</td>\r\n");
      out.write("                                <td>100%</td>\r\n");
      out.write("                                <td><input type=\"checkbox\" checked disabled></td>\r\n");
      out.write("                            </tr>\r\n");
      out.write("                        </tbody>\r\n");
      out.write("                    </table>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-lg-7 col-md-12 col-sm-12 divBorder\"> <!--coté droit de la page -->\r\n");
      out.write("                <div class=\"col-lg-6 col-md-6 col-sm-6 colInfoEleve\"> \r\n");
      out.write("                    <br>\r\n");
      out.write("                    <label>Prénom :</label>\r\n");
      out.write("                    <div class=\"divInfoEleve\">\r\n");
      out.write("                        <p>Pablo</p>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <br>\r\n");
      out.write("                    <label>Nom :</label>\r\n");
      out.write("                    <div class=\"divInfoEleve\">\r\n");
      out.write("                        <p>Escobar</p>\r\n");
      out.write("                    </div>\r\n");
      out.write("                                        <br>\r\n");
      out.write("                    <label>Téléphone :</label>\r\n");
      out.write("                    <div class=\"divInfoEleve\">\r\n");
      out.write("                        <p>514-666-9119</p>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <br>\r\n");
      out.write("                    <label>Courriel :</label>\r\n");
      out.write("                    <div class=\"divInfoEleve\">\r\n");
      out.write("                        <p>Pablo@Escobar.col</p>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <br>\r\n");
      out.write("                    <label>Linkedin :</label>\r\n");
      out.write("                    <div class=\"divLinkEleve\">\r\n");
      out.write("                        <a  href=\"#\">linkedin.com/Pablo</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <br>\r\n");
      out.write("                    <label>Github :</label>\r\n");
      out.write("                    <div class=\"divLinkEleve\">\r\n");
      out.write("                        <a href=\"#\">github.com/Pablo</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-lg-6 col-md-6 col-sm-6 colInfoEleve\">\r\n");
      out.write("                    <br>\r\n");
      out.write("                    <label>Spécialité :</label>\r\n");
      out.write("                    <div class=\"divInfoEleve\">\r\n");
      out.write("                        <p>Gestion</p>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <br>\r\n");
      out.write("                    <label>Ce que je recherche :</label>\r\n");
      out.write("                    <div class=\"divInfoEleve\">\r\n");
      out.write("                        <p> \r\n");
      out.write("                            &#xb7; Temps plein <br>\r\n");
      out.write("                            &#xb7; Payé (110$/h et +) <br>\r\n");
      out.write("                            &#xb7; Assurance vie <br>\r\n");
      out.write("                        </p>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <br>\r\n");
      out.write("                    <table class=\"table table-hover borderTable\">\r\n");
      out.write("                        <thead>\r\n");
      out.write("                            <tr>\r\n");
      out.write("                                <th scope=\"col\">Compétences</th>\r\n");
      out.write("                                <th scope=\"col\">Domaine</th>\r\n");
      out.write("                                <th scope=\"col\">Niveau</th>\r\n");
      out.write("                            </tr>\r\n");
      out.write("                        </thead>\r\n");
      out.write("                        <tbody>\r\n");
      out.write("                            <tr>\r\n");
      out.write("                                <td>Gestion</td>\r\n");
      out.write("                                <td>Comptable</td>\r\n");
      out.write("                                <td>Expert</td>\r\n");
      out.write("                            </tr>\r\n");
      out.write("                            <tr>\r\n");
      out.write("                                <td>C#</td>\r\n");
      out.write("                                <td>Prog</td>\r\n");
      out.write("                                <td>Intermediaire</td>\r\n");
      out.write("                            </tr>\r\n");
      out.write("                            <tr>\r\n");
      out.write("                                <td>Java</td>\r\n");
      out.write("                                <td>Prog</td>\r\n");
      out.write("                                <td>Intermediaire</td>\r\n");
      out.write("                            </tr>\r\n");
      out.write("                        </tbody>\r\n");
      out.write("                    </table>\r\n");
      out.write("                    <button type=\"button\" class=\"btn btn-primary btnAccepte\" style=\"width: 100%;\">Accepter Candidature</button>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("         </div>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
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
