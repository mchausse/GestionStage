package org.apache.jsp.WEB_002dINF.vues;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class inscription_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/WEB-INF/vues/menu.jsp");
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
      out.write("        <title>Stages | Inscription </title>\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\r\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\r\n");
      out.write("        <link href=\"./css/style.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body onLoad=\"cacherInfo()\">\r\n");
      out.write("        ");
      out.write("\r\n");
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
      out.write("        <div class=\"container\" id=\"contenuInscription\">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"col-lg-6\"> <!-- Contenu d'inscription-->\r\n");
      out.write("                    <div class=\"panel panel-default\">\r\n");
      out.write("                        <div class=\"panel-heading\"><h4>Inscription</h4></div>\r\n");
      out.write("                        <div class=\"contenuPan\">\r\n");
      out.write("                            <form>\r\n");
      out.write("                                <div class=\"form-group\">\r\n");
      out.write("                                    <div class=\"input-group\"> <!--Nom inscription-->\r\n");
      out.write("                                        <div class=\"input-group-addon\"><span class=\"glyphicon glyphicon-user\"></span> </div>\r\n");
      out.write("                                        <input type=\"text\" class=\"form-control inscriptionInput\" placeholder=\"Nom\" required>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <br/>\r\n");
      out.write("                                    <div class=\"input-group\"> <!--Prénom inscription-->\r\n");
      out.write("                                        <div class=\"input-group-addon\"><span class=\"glyphicon glyphicon-user\"></span> </div>\r\n");
      out.write("                                        <input type=\"text\" class=\"form-control inscriptionInput\" placeholder=\"Prénom\" required>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <br/>\r\n");
      out.write("                                    <div class=\"input-group\"> <!--Email inscription-->\r\n");
      out.write("                                        <div class=\"input-group-addon \"><span class=\"glyphicon glyphicon-envelope\"></span> </div>\r\n");
      out.write("                                        <input type=\"email\" class=\"form-control inscriptionInput\" placeholder=\"Votre@Email.ca\" required>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <br/>\r\n");
      out.write("                                    <div class=\"input-group\"> <!--Password inscription-->\r\n");
      out.write("                                        <div class=\"input-group-addon\"><span class=\"glyphicon glyphicon-asterisk\"></span> </div>\r\n");
      out.write("                                        <input type=\"password\" class=\"form-control inscriptionInput\" placeholder=\"Mot De Passe\" required>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <br />\r\n");
      out.write("                                    <div class=\"input-group\"> <!--Password inscription-->\r\n");
      out.write("                                        <div class=\"input-group-addon\"><span class=\"glyphicon glyphicon-asterisk\"></span> </div>\r\n");
      out.write("                                        <input type=\"password\" class=\"form-control inscriptionInput\" placeholder=\"Vérification Mot De Passe\" required>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <br/>\r\n");
      out.write("                                    <select class=\"form-control inscriptionInput\" onChange=\"afficheInfo()\" id=\"selectRole\"> <!--Password inscription-->\r\n");
      out.write("                                        <option value=\"\" disabled selected>Je Suis ...</option>\r\n");
      out.write("                                        <option>Étudiant</option>\r\n");
      out.write("                                        <option>Employeur</option>\r\n");
      out.write("                                    </select>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div id=\"infoEleve\" style=\"display: none\">\r\n");
      out.write("                                    <input type=\"submit\" class=\"btn btn-success\" id=\"btnLogin\" value=\"S'Inscrire\" style=\"width:100%\">\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div id=\"infoEmployeur\" style=\"display: none\">\r\n");
      out.write("                                    <div class=\"input-group\"> <!--Nom inscription-->\r\n");
      out.write("                                        <div class=\"input-group-addon\"><span class=\"glyphicon glyphicon-phone-alt\"></span> </div>\r\n");
      out.write("                                        <input type=\"tel\" class=\"form-control inscriptionInput\" id=\"inputTel\" placeholder=\"Téléphone\" required>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <br/>\r\n");
      out.write("                                    <div class=\"input-group\"> <!--Nom inscription-->\r\n");
      out.write("                                        <div class=\"input-group-addon\"><span class=\"glyphicon glyphicon-briefcase\"></span> </div>\r\n");
      out.write("                                        <input type=\"text\" class=\"form-control inscriptionInput\" id=\"inputEntre\" placeholder=\"Nom de votre Entreprise\" required>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <input type=\"submit\" class=\"btn btn-success\" id=\"btnLogin\" value=\"S'Inscrire\" style=\"width:100%\">\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </form>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-lg-6\"> <!-- Contenu de Connexion-->\r\n");
      out.write("                    <div class=\"panel panel-default\">\r\n");
      out.write("                        <div class=\"panel-heading\"><h4>Connexion</h4></div>\r\n");
      out.write("                        <div class=\"contenuPan\">\r\n");
      out.write("                            <form action=\"do?action=connexion\" method=\"post\">\r\n");
      out.write("                                <div class=\"form-group\">\r\n");
      out.write("                                    <div class=\"input-group\">\r\n");
      out.write("                                        <div class=\"input-group-addon\" id=\"iconMailLog\"><span class=\"glyphicon glyphicon-envelope\"></span> </div>\r\n");
      out.write("                                        <input type=\"email\" class=\"form-control\"  id=\"emailLog\" name=\"emailLog\" placeholder=\"Votre@Email.ca\" required>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"input-group\">\r\n");
      out.write("                                        <div class=\"input-group-addon\" id=\"iconPasslLog\"><span class=\"glyphicon glyphicon-asterisk\"></span> </div>\r\n");
      out.write("                                        <input type=\"password\" class=\"form-control\" id=\"paswordLog\" name=\"passwordLog\" placeholder=\"Mot De Passe\" required>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <input type=\"submit\" class=\"btn btn-primary\" id=\"btnLogin\" value=\"Se Connecter\" style=\"width:100%\">\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </form>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("    function afficheInfo(){\r\n");
      out.write("        var e = document.getElementById(\"selectRole\");\r\n");
      out.write("        var role = e.options[e.selectedIndex].value;\r\n");
      out.write("        \r\n");
      out.write("        if(role === \"Étudiant\"){\r\n");
      out.write("            document.getElementById(\"infoEleve\").style.display = \"block\";\r\n");
      out.write("            document.getElementById(\"infoEmployeur\").style.display = \"none\";\r\n");
      out.write("            document.getElementById(\"inputTel\").required = false;\r\n");
      out.write("            document.getElementById(\"inputEntre\").required = false;\r\n");
      out.write("        }\r\n");
      out.write("        if(role === \"Employeur\"){\r\n");
      out.write("            document.getElementById(\"infoEleve\").style.display = \"none\";\r\n");
      out.write("            document.getElementById(\"infoEmployeur\").style.display = \"block\";\r\n");
      out.write("            document.getElementById(\"inputTel\").required = true;\r\n");
      out.write("            document.getElementById(\"inputEntre\").required = true;\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("    function cacherInfo(){\r\n");
      out.write("        document.getElementById(\"infoEleve\").style.display = \"none\";\r\n");
      out.write("        document.getElementById(\"infoEmployeur\").style.display = \"none\";\r\n");
      out.write("        document.getElementById(\"infoEleve\").style.display = \"none\";\r\n");
      out.write("    }\r\n");
      out.write("</script>");
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
