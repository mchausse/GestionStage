/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stageo.controleur;

import com.stageo.beans.Utilisateur;
import com.stageo.dao.UtilisateurDAO;
import com.stageo.singleton.Connexion;
import java.util.logging.Level;

/**
 *
 * @author gabri
 */
public class ConnexionAction extends AbstractAction{
    
    @Override
    public String execute() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ConnexionAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        Connexion c = new Connexion();
        c.setUrl("jdbc:mysql://localhost/stageo?user=root&password=root&serverTimezone=EST&characterEncoding=UTF-8");
        UtilisateurDAO dao = new UtilisateurDAO(c.getInstance());
        
        //Attibut de la page
        String email = request.getParameter("emailLog");
        String password = request.getParameter("passwordLog");
        
        Utilisateur temp = dao.findByEmail(email);
        
        if(temp!=null && email!=null && password!=null){
            if(password.equals(temp.getMotDePasse())){
                request.getSession().setAttribute("connecte", true);
                request.getSession().setAttribute("utilisateur", temp); //faire que sa soit un eleve ou un employeur
                return "messagerie";
            }
        }
        return "inscription";
    }
}
