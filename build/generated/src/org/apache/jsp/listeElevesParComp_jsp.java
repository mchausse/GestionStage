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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Stages | Liste Élèves</title>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n");
      out.write("        <link href=\"./css/style.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<nav class=\"navbar navbar-default navbar-fixed-top\" role=\"navigation\" id=\"menu\">\n");
      out.write("    <div class=\"container-fluid\">\n");
      out.write("        <div clas=\"navbar-header\">\n");
      out.write("            <button type=\"button\" class=\"navbar-toggle\" id=\"btnMenuColl\"data-toggle=\"collapse\" data-target=\"#navbar-collapse-main\">\n");
      out.write("                <span class=\"icon-bar\"></span>\n");
      out.write("                <span class=\"icon-bar\"></span>\n");
      out.write("                <span class=\"icon-bar\"></span>\n");
      out.write("            </button>\n");
      out.write("            <a class=\"navbar-brand\" href=\"http://www.crosemont.qc.ca/\"><img id=\"logo\" src=\"./images/logoCouper.png\"/></a>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"collapse navbar-collapse\" id=\"navbar-collapse-main\">\n");
      out.write("            <div id=\"choixMenu\">\n");
      out.write("                <ul class=\"nav navbar-nav navbar-left\">\n");
      out.write("                    <li><a class=\"#\" href=\"\">Mon profil</a></li>\n");
      out.write("                    <li><a class=\"#\" href=\"\">Offres de stage</a></li>\n");
      out.write("                    <li><a class=\"#\" href=\"\">Documents</a></li>\n");
      out.write("                    <li><a class=\"#\" href=\"\">Recherche Étudiant</a></li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</nav>\n");
      out.write("\n");
      out.write("        <div class=\"container\" id=\"contenuListeEleve\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-lg-4\"> <!-- partie gauche de la page -->\n");
      out.write("                    <select class=\"form-control\" id=\"selectionStage\">\n");
      out.write("                        <option value=\"progWeb\">Programmation web</option>\n");
      out.write("                        <option value=\"progC#\">Programmation C#</option>\n");
      out.write("                        <option value=\"progJava\">Programmation Java</option>\n");
      out.write("                    </select>\n");
      out.write("                    <br><!--Faire fonction onChange en JS pour loader les élèves dans les recherches-->\n");
      out.write("                    <input type=\"text\" class=\"form-control has-feedback\" id=\"rechercheEleve\" style=\"border-radius: 50px;\">\n");
      out.write("                    <br>\n");
      out.write("                    <table class=\"table table-hover\" id=\"rechercheEleveTab\">\n");
      out.write("                        <thead>\n");
      out.write("                          <tr>\n");
      out.write("                            <th>Nom</th>\n");
      out.write("                            <th>Spécialité</th>\n");
      out.write("                            <th>Match</th>\n");
      out.write("                            <th>Consulté</th>\n");
      out.write("                          </tr>\n");
      out.write("                        </thead>\n");
      out.write("                        <tbody>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Billy Bob</td>\n");
      out.write("                                <td>Réseau</td>\n");
      out.write("                                <td>88%</td>\n");
      out.write("                                <td><input type=\"checkbox\" checked disabled></td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Georges Dupont</td>\n");
      out.write("                                <td>Programmation Web</td>\n");
      out.write("                                <td>70%</td>\n");
      out.write("                                <td><input type=\"checkbox\" disabled></td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Slaver Dure</td>\n");
      out.write("                                <td>Gestion</td>\n");
      out.write("                                <td>90%</td>\n");
      out.write("                                <td><input type=\"checkbox\" checked disabled></td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Jeff Jefferson</td>\n");
      out.write("                                <td>Programmation Web</td>\n");
      out.write("                                <td>99%</td>\n");
      out.write("                                <td><input type=\"checkbox\" disabled></td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Pablo Esobar</td>\n");
      out.write("                                <td>Gestion</td>\n");
      out.write("                                <td>100%</td>\n");
      out.write("                                <td><input type=\"checkbox\" checked disabled></td>\n");
      out.write("                            </tr>\n");
      out.write("                        </tbody>\n");
      out.write("                    </table>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-lg-7 divBorder\"> <!--coté droit de la page -->\n");
      out.write("                    <h1>Fuck 12</h1>\n");
      out.write("                    <h1>Fuck 12</h1>\n");
      out.write("                    <h1>Fuck 12</h1>\n");
      out.write("                    <h1>Fuck 12</h1>\n");
      out.write("                    <h1>Fuck 12</h1>\n");
      out.write("                    <h1>Fuck 12</h1>\n");
      out.write("                    <h1>Fuck 12</h1>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("         </div>\n");
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
