package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.stageo.beans.Adresse;
import com.stageo.dao.AdresseDAO;
import com.stageo.dao.CompagnieDAO;
import com.stageo.beans.Compagnie;
import com.stageo.beans.Employeur;
import com.stageo.dao.EmployeurDAO;
import com.stageo.beans.Etudiant;
import com.stageo.dao.EtudiantDAO;
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>JSP Page</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <h1>Test de mon DAO</h1>\r\n");
      out.write("        ");
    
            try { //devrait etre dans le singleton
                Class.forName("com.mysql.jdbc.Driver");
            }catch (ClassNotFoundException ex) {
                Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Connexion c = new Connexion();
            c.setUrl("jdbc:mysql://localhost/stageo?user=root&password=root&serverTimezone=EST&characterEncoding=UTF-8");
            
            //----------------------TEST UTILISATEUR---------------------------//
            out.println("<h3>Test Utilisateur</h3>");
            UtilisateurDAO dao = new UtilisateurDAO(c.getInstance());
            //Test par ID : 
            Utilisateur test1 = dao.findById("1");
            out.println("Find by ID : " + test1.getIdUtilisateur() + "<br/>");
            
            //Test par Obj
            Utilisateur test2 = new Utilisateur("1");
            Utilisateur temp2 = dao.find(test2);
            out.println("Find by OBJ : " + test2.getIdUtilisateur() + "<br/>");
            
            //findByEmail
            Utilisateur user1 = dao.findByEmail("slaver@dure.com");
            out.println("<br/><br/> ID par Email : " + user1.getIdUtilisateur() + "<br/>");
            out.println("Email : " + user1.getCourriel()+"<br/>");
            //Teste creation
            Utilisateur test3 = new Utilisateur();
            test3.setIdUtilisateur("666");
            test3.setCourriel("bob@bob.com");
            test3.setMotDePasse("bob");
            test3.setNom("billy");
            test3.setPrenom("bob");
            test3.setTypeUtilisateur("etudiant");
            out.println("Création : " + dao.create(test3) + "<br/>");
            
            Utilisateur test555 = new Utilisateur();
            test3.setIdUtilisateur("555");
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
            
            //----------------------TEST ETUDIANT-----------------------------//
            out.println("<hr/>");
            out.println("<h3>Test Etudiant</h3>");
            EtudiantDAO daoEtu = new EtudiantDAO(c.getInstance());
            
            //Find
            Etudiant etu1 = new Etudiant();
            etu1.setIdEtudiant("1");
            etu1.setStatutRecherche("En Recherche");
            
            Etudiant etu2 = daoEtu.find(etu1);
            out.println("ID Find : " + etu2.getIdEtudiant() + " " + etu2.getStatutRecherche() + "<br/>");
            
            //FindByID
            Etudiant etu3 = daoEtu.findById("1");
            out.println("ID FindByID : " + etu2.getIdEtudiant() + " " + etu2.getStatutRecherche() + "<br/>");
            
            //Create
            Etudiant etu4 = new Etudiant();
            etu4.setIdEtudiant("2");
            etu4.setStatutRecherche("Engagé");
            out.println("Créé : " + daoEtu.create(etu4));
            
            //FindAll
            List<Etudiant> listeEtu = daoEtu.findAll();
            for(int i=0; i<listeEtu.size(); i++){
                out.println("<hr/>");
                out.println("ID : " + listeEtu.get(i).getIdEtudiant() + "<br/>");
                out.println("Statut : " + listeEtu.get(i).getStatutRecherche() + "<br/>");
            }
            out.println("<br/>");
            
            //Delete
            out.println("Delete : " + daoEtu.delete(etu4) + "<br/>");
            
            //----------------------TEST EMPLOYEUR----------------------------//
            out.println("<hr/><h3>Test Employeur</h3>");
            EmployeurDAO daoEmp = new EmployeurDAO(c.getInstance());
            
            //Find
            Employeur emp1 = new Employeur();
            emp1.setIdEmployeur("3");
            //emp1.setIdEmployeur("2");
            
            Employeur emp2 = daoEmp.find(emp1);
            out.println("ID employeur : " + emp2.getIdEmployeur() + "<br/>");
            out.println("Tel : " + emp2.getTel()+ "<br/>");
            out.println("ID compagnie : " + emp2.getIdCompagnie() + "<br/>");
            
            //FindbyID
            Employeur emp3 = daoEmp.findById("3");
            //Employeur emp3 = daoEmp.findById("2");
            out.println("<br/>");
            out.println("ID employeur : " + emp3.getIdEmployeur() + "<br/>");
            out.println("Tel : " + emp3.getTel()+ "<br/>");
            out.println("ID compagnie : " + emp3.getIdCompagnie() + "<br/>");
            
            //Create
            Employeur emp4 = new Employeur();
            emp4.setIdEmployeur("3");
            emp4.setTel("5147899876");
            emp4.setIdCompagnie("2");
            out.println("<br/><br/>Créer : " + daoEmp.create(emp4));
            out.println("<br/>");
            out.println("ID employeur : " + emp4.getIdEmployeur() + "<br/>");
            out.println("Tel : " + emp4.getTel()+ "<br/>");
            out.println("ID compagnie : " + emp4.getIdCompagnie() + "<br/>");
            
            //Update
            emp4.setTel("66666666");
            out.println("Modifier : " + daoEmp.update(emp4));
            
            //FindAll
            List<Employeur> listeEmp = daoEmp.findAll();
            for(int i=0; i<listeEmp.size(); i++){
                out.println("<hr/>");
                out.println("ID : " + listeEmp.get(i).getIdEmployeur() + "<br/>");
                out.println("Tel : " + listeEmp.get(i).getTel() + "<br/>");
                out.println("IdComp : " + listeEmp.get(i).getIdCompagnie() + "<br/>");
            }
            out.println("<br/>");
            
            //Delete
            //out.println("Delete : " + daoEmp.delete(emp4));
            
            //---------------------------TEST COMPAGNIE-----------------------//
            CompagnieDAO daoComp = new CompagnieDAO(Connexion.getInstance());
            
            //find
            out.println("<hr/> <h3>Find : </h3>");
            Compagnie comp1 = new Compagnie();
            comp1.setIdCompagnie("1");
            Compagnie compFound1 = daoComp.find(comp1);
            out.println("<b>ID COMP : </b>" + compFound1.getIdCompagnie() + "<br/>");
            out.println("<b>NOM COMP : </b>" + compFound1.getNom()+ "<br/>");
            out.println("<b>ADD COMP : </b>" + compFound1.getIdAdresse()+ "<br/>");
            out.println("<b>SITE COMP : </b>" + compFound1.getSiteWeb()+ "<br/>");

            //FindByID
            out.println("<h3>FindByID : </h3>");
            Compagnie compFound2 = daoComp.findById("1");
            out.println("<b>ID COMP : </b>" + compFound2.getIdCompagnie()+ "<br/>");
            out.println("<b>NOM COMP : </b>" + compFound2.getNom()+ "<br/>");
            out.println("<b>ADD COMP : </b>" + compFound2.getIdAdresse()+ "<br/>");
            out.println("<b>SITE COMP : </b>" + compFound2.getSiteWeb()+ "<br/>");
            
            //Create
            out.println("<h3>FindByID : </h3>");
            Compagnie comp2 = new Compagnie();
            comp2.setIdCompagnie("3");
            comp2.setIdAdresse("3");
            comp2.setNom("fuck");
            comp2.setSiteWeb("fuck.com");
            out.println("Comp créé : " + daoComp.create(comp2));
            
            //Update
            out.println("<h3>Update : </h3>");
            comp2.setNom("fuck12");
            comp2.setSiteWeb("fuck12.com");
            out.println("Comp update : " + daoComp.update(comp2));
            
            //FindAll
            out.println("<h3>FindAll : </h3>");
            List<Compagnie> listeComp = daoComp.findAll();
            for(int i=0; i<listeComp.size(); i++){
                out.println("<b>ID COMP : </b>" + listeComp.get(i).getIdCompagnie()+ "<br/>");
                out.println("<b>NOM COMP : </b>" + listeComp.get(i).getNom()+ "<br/>");
                out.println("<b>ADD COMP : </b>" + listeComp.get(i).getIdAdresse()+ "<br/>");
                out.println("<b>SITE COMP : </b>" + listeComp.get(i).getSiteWeb()+ "<br/>");
                out.println("<br/>");
            }
            
            //Delete
            out.println("<h3>Delete : </h3>");
            out.println("Comp delete : " + daoComp.delete(comp2));
            
            //--------------------------TEST ADRESSE---------------------------//
            
            //find
            out.println("<hr/><h3>Find : </h3>");
            AdresseDAO daoAdd = new AdresseDAO(Connexion.getInstance());
            Adresse add1 = new Adresse();
            add1.setIdAdresse("1");
            
            Adresse addFound = daoAdd.find(add1);
            out.println("<b>ID ADD : </b>" + addFound.getIdAdresse() + "<br/>");
            out.println("<b>NUM CIVIQUE ADD : </b>" + addFound.getNumeroCivique()+ "<br/>");
            out.println("<b>RUE ADD : </b>" + addFound.getRue() + "<br/>");
            out.println("<b>BUREAU ADD : </b>" + addFound.getBureau() + "<br/>");
            out.println("<b>VILLE ADD : </b>" + addFound.getVille() + "<br/>");
            out.println("<b>CODE POST ADD : </b>" + addFound.getCodePostal() + "<br/>");
            out.println("<b>PROVINCE ADD : </b>" + addFound.getProvince() + "<br/>");
            out.println("<b>TEL ADD : </b>" + addFound.getTel() + "<br/>");
            out.println("<b>PAYS ADD : </b>" + addFound.getPays() + "<br/>");

            //FindByID
            out.println("<h3>FindByID : </h3>");
            Adresse addFound2 = daoAdd.findById("1");
            out.println("<b>ID ADD : </b>" + addFound2.getIdAdresse() + "<br/>");
            out.println("<b>NUM CIVIQUE ADD : </b>" + addFound2.getNumeroCivique()+ "<br/>");
            out.println("<b>RUE ADD : </b>" + addFound2.getRue() + "<br/>");
            out.println("<b>BUREAU ADD : </b>" + addFound2.getBureau() + "<br/>");
            out.println("<b>VILLE ADD : </b>" + addFound2.getVille() + "<br/>");
            out.println("<b>CODE POST ADD : </b>" + addFound2.getCodePostal() + "<br/>");
            out.println("<b>PROVINCE ADD : </b>" + addFound2.getProvince() + "<br/>");
            out.println("<b>TEL ADD : </b>" + addFound2.getTel() + "<br/>");
            out.println("<b>PAYS ADD : </b>" + addFound2.getPays() + "<br/>");
            
            //Create
            out.println("<h3>Create : </h3>");
            Adresse add2 = new Adresse();
            add2.setIdAdresse("2");
            add2.setNumeroCivique("444");
            add2.setRue("En chine");
            add2.setBureau("666");
            add2.setVille("chikoutimi");
            add2.setCodePostal("j6e6t5");
            add2.setProvince("Alberta");
            add2.setPays("Canada");
            add2.setTel("5146668866");
            out.println("ADD créé : " + daoAdd.create(add2));
            
            //Update
            out.println("<h3>Update : </h3>");
            add2.setNumeroCivique("666");
            add2.setBureau("999");
            out.println("ADD edit : " + daoAdd.update(add2));
            
            //FindAll
            out.println("<h3>FindAll : </h3>");
            
            List<Adresse> listeAdd = daoAdd.findAll();
            for(int i=0; i<listeAdd.size(); i++){
                out.println("<b>ID ADD : </b>" + listeAdd.get(i).getIdAdresse() + "<br/>");
                out.println("<b>NUM CIVIQUE ADD : </b>" + listeAdd.get(i).getNumeroCivique()+ "<br/>");
                out.println("<b>RUE ADD : </b>" + listeAdd.get(i).getRue() + "<br/>");
                out.println("<b>BUREAU ADD : </b>" + listeAdd.get(i).getBureau() + "<br/>");
                out.println("<b>VILLE ADD : </b>" + listeAdd.get(i).getVille() + "<br/>");
                out.println("<b>CODE POST ADD : </b>" + listeAdd.get(i).getCodePostal() + "<br/>");
                out.println("<b>PROVINCE ADD : </b>" + listeAdd.get(i).getProvince() + "<br/>");
                out.println("<b>TEL ADD : </b>" + listeAdd.get(i).getTel() + "<br/>");
                out.println("<b>PAYS ADD : </b>" + listeAdd.get(i).getPays() + "<br/>");
                out.println("<br/>");
            }
            
            //Delete
            out.println("<h3>Delete : </h3>");
            out.println("Add delete : " + daoAdd.delete(add2));
        
      out.write("\r\n");
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
