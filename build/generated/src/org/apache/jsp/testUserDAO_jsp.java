package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;
import com.stageo.beans.Utilisateur;
import com.stageo.singleton.Connexion;
import com.stageo.dao.UtilisateurDAO;

public final class testUserDAO_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Test de mon DAO</h1>\n");
      out.write("        ");
    
            try { //devrait etre dans le singleton
                Class.forName("com.mysql.jdbc.Driver");
            }catch (ClassNotFoundException ex) {
                Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Connexion c = new Connexion();
            c.setUrl("jdbc:mysql://localhost/stageo?user=root&password=root&serverTimezone=EST&characterEncoding=UTF-8");
            
            UtilisateurDAO dao = new UtilisateurDAO(c.getInstance());
            //Test par ID : 
            Utilisateur test1 = dao.findById("1");
            out.println("Find by ID : " + test1.getIdUtilisateur() + "<br/>");
            
            //Test par Obj
            Utilisateur test2 = new Utilisateur("1");
            Utilisateur temp2 = dao.find(test2);
            out.println("Find by OBJ : " + test2.getIdUtilisateur() + "<br/>");
            
            //Teste creation
            Utilisateur test3 = new Utilisateur();
            test3.setIdUtilisateur("666");
            test3.setCourriel("bob@bob.com");
            test3.setMotDePasse("bob");
            test3.setNom("billy");
            test3.setPrenom("bob");
            test3.setTypeUtilisateur("etudiant");
            out.println("Création : " + dao.create(test3) + "<br/>");
            
            //Test findAll
            List<Utilisateur> listeTemp = dao.findAll();
            out.println("Liste des utilisateurs : <br/>" );
            for(int i=0; i<listeTemp.size(); i++){
                out.println("<hr/>");
                out.println("<b> ID : "+listeTemp.get(i).getIdUtilisateur()+"</b><br/>");
                out.println("Courriel : " +listeTemp.get(i).getCourriel()+"<br/>");
                out.println("Nom : " +listeTemp.get(i).getNom()+"<br/>");
                out.println("Prenom : " +listeTemp.get(i).getPrenom()+"<br/>");
                out.println("Type : " +listeTemp.get(i).getTypeUtilisateur()+"<br/>");
            }
            
            out.println("<hr/>");
            //Test modification
            test3.setNom("Robert");
            out.println("Modifié : "+dao.update(test3)+"<br/>");
            
            //Test Delete
            out.println("Delete : " + dao.delete(test3) + "<br/>");
        
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
