package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class communiquer_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Stages | Communication</title>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.4.2/css/all.css\" integrity=\"sha384-/rXc/GQVaYpyDdyxK+ecHPVYJSN9bmVFBvjA/9eOB+pb3F2w2N6fc5qB9Ew5yIns\" crossorigin=\"anonymous\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n");
      out.write("        <link href=\"./css/style.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <!-- Barre de navigation -->\n");
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
      out.write("\n");
      out.write("        <!-- Fin barre de navigation -->\n");
      out.write("        \n");
      out.write("        <div class='container-fluid'>\n");
      out.write("            <div id=\"contenuPage\">\n");
      out.write("                <div class=\"col-lg-1\"></div><!-- Sert de margin -->\n");
      out.write("                \n");
      out.write("                <!-- Debut de la section du menu des messages -->\n");
      out.write("                <div class=\"col-lg-2\">\n");
      out.write("                    <div class=\"panel panel-default\">\n");
      out.write("                        <div class=\"panel-heading\">\n");
      out.write("                            Menu\n");
      out.write("                        </div>\n");
      out.write("                        \n");
      out.write("                        <!-- Liste des options du menu -->\n");
      out.write("                        <div class=\"panel-body\">\n");
      out.write("                            <div class=\"col-lg-12\">\n");
      out.write("                                <a href=\"#\" class=\"btn btn-default btn-lg btnMenu\">\n");
      out.write("                                    <span class=\"badge\">5</span>\n");
      out.write("                                    <span class=\"glyphicon glyphicon-inbox\"> Reçus</span>\n");
      out.write("                                </a>\n");
      out.write("                                <a href=\"#\" class=\"btn btn-default btn-lg btnMenu\">\n");
      out.write("                                    <span class=\"glyphicon glyphicon-arrow-left\"> Envoyés</span>\n");
      out.write("                                </a>\n");
      out.write("                                <a href=\"#\" class=\"btn btn-default btn-lg btnMenu\">\n");
      out.write("                                    <span class=\"badge\">1</span>\n");
      out.write("                                    <span class=\"glyphicon glyphicon-floppy-disk\"> Sauvegardés</span>\n");
      out.write("                                </a>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <!-- Fin de la liste des options du menu -->\n");
      out.write("                        \n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <!-- Fin de la section du menu des messages -->\n");
      out.write("                \n");
      out.write("                <!-- Debut de la section de la liste de messages -->\n");
      out.write("                <div class=\"col-lg-3\">\n");
      out.write("                    <div class=\"panel panel-default\">\n");
      out.write("                        <div class=\"panel-heading\">\n");
      out.write("                            Messages recus\n");
      out.write("                        </div>\n");
      out.write("                        <div id=\"messages\" class=\"panel-body\">\n");
      out.write("                            <div class=\"panel panel-default\">\n");
      out.write("                                <div class=\"panel-heading\"><kbd>Activix</kbd> Maxime </div>\n");
      out.write("                                <div class=\"panel-body\">Entrevue</div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"panel panel-default\">\n");
      out.write("                                <div class=\"panel-heading\"><kbd>Wal-Mart</kbd> Charles</div>\n");
      out.write("                                <div class=\"panel-body\">Entrevue</div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"panel panel-default\">\n");
      out.write("                                <div class=\"panel-heading\"><kbd>Cosco</kbd> Abdelmounène </div>\n");
      out.write("                                <div class=\"panel-body\">Entrevue</div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"panel panel-default\">\n");
      out.write("                                <div class=\"panel-heading\"><kbd>La belle province</kbd> Anne-Marie </div>\n");
      out.write("                                <div class=\"panel-body\">Entrevue</div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"panel panel-default\">\n");
      out.write("                                <div class=\"panel-heading\"><kbd>Chez Rémi</kbd> Jean-Coutu </div>\n");
      out.write("                                <div class=\"panel-body\">Entrevue</div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <!-- Fin de la section de la liste de messages -->\n");
      out.write("                \n");
      out.write("                <!-- Debut de la section dun message -->\n");
      out.write("                <div class=\"col-lg-5\">\n");
      out.write("                    <div class=\"panel panel-default\">\n");
      out.write("                        <div class=\"panel-heading\">\n");
      out.write("                            Message\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"panel-body message\">\n");
      out.write("                            <div class=\"col-lg-12\" id=\"messageEnvoyeur\">\n");
      out.write("                                <label id=\"messageEnvoyeur\"><b>Envoyeur : </b></label><span> Maxime <kbd>Activix</kbd></span>\n");
      out.write("                                <hr>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-lg-12\" id=\"messageTitre\">\n");
      out.write("                                <label id=\"messageTitre\"><b>Titre : </b></label><span> Entrevue</span>\n");
      out.write("                                <hr>\n");
      out.write("                            </div>\n");
      out.write("                            <pre id='texteMessage'>\n");
      out.write("Text in a pre element\n");
      out.write("is displayed in a fixed-width\n");
      out.write("font, and it preserves\n");
      out.write("both      spaces and\n");
      out.write("line breaks.Text in a pre element\n");
      out.write("is displayed in a fixed-width\n");
      out.write("font, and it preserves\n");
      out.write("both      spaces and\n");
      out.write("line breaks.\n");
      out.write("\n");
      out.write("Text in a pre element\n");
      out.write("is displayed in a fixed-width\n");
      out.write("font, and it preserves\n");
      out.write("both      spaces and\n");
      out.write("line breaks.\n");
      out.write("\n");
      out.write("\n");
      out.write("font, and it preserves\n");
      out.write("both      spaces and\n");
      out.write("line breaks.\n");
      out.write("                            </pre>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <!-- Fin de la section dun message -->\n");
      out.write("                <div class=\"col-lg-1\"></div><!-- Sert de margin -->\n");
      out.write("                \n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        \n");
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
      out.write("        \n");
      out.write("        <script>\n");
      out.write("            \n");
      out.write("            $(document).ready(function(){\n");
      out.write("                $(\"#messages\").hover(function(){\n");
      out.write("                    $(this).css(\"overflow-y\",\"scroll\");\n");
      out.write("                });\n");
      out.write("                $(\"#messages\").mouseleave(function(){\n");
      out.write("                    $(this).css(\"overflow-y\",\"hidden\");\n");
      out.write("                });\n");
      out.write("                $(\"#texteMessage\").hover(function(){\n");
      out.write("                    $(this).css(\"overflow-y\",\"scroll\");\n");
      out.write("                });\n");
      out.write("                $(\"#texteMessage\").mouseleave(function(){\n");
      out.write("                    $(this).css(\"overflow-y\",\"hidden\");\n");
      out.write("                });\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("    \n");
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
