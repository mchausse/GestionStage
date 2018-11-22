<%-- 
    Document   : testUserDAO
    Created on : 2018-11-18, 13:50:06
    Author     : gabri
--%>

<%@page import="com.stageo.dao.CompagnieDAO"%>
<%@page import="com.stageo.beans.Compagnie"%>
<%@page import="com.stageo.beans.Employeur"%>
<%@page import="com.stageo.dao.EmployeurDAO"%>
<%@page import="com.stageo.beans.Etudiant"%>
<%@page import="com.stageo.dao.EtudiantDAO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.logging.Logger"%>
<%@page import="java.util.logging.Level"%>
<%@page import="com.stageo.beans.Utilisateur"%>
<%@page import="com.stageo.singleton.Connexion"%>
<%@page import="com.stageo.dao.UtilisateurDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Test de mon DAO</h1>
        <%    
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
        %>
    </body>
</html>
