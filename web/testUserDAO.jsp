<%-- 
    Document   : testUserDAO
    Created on : 2018-11-18, 13:50:06
    Author     : gabri
--%>

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
        %>
    </body>
</html>
