/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stageo.controleur;

import com.stageo.beans.Employeur;
import com.stageo.beans.Etudiant;
import com.stageo.beans.Utilisateur;
import com.stageo.dao.EmployeurDAO;
import com.stageo.dao.EtudiantDAO;
import com.stageo.dao.UtilisateurDAO;
import com.stageo.singleton.Connexion;
import java.util.UUID;
import java.util.logging.Level;

/**
 *
 * @author gabri
 */
public class InscriptionAction extends AbstractAction{
    
    @Override
    public String execute() {
        try{
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(ConnexionAction.class.getName()).log(Level.SEVERE, null, ex);
            }
            Connexion c = new Connexion();
            c.setUrl("jdbc:mysql://localhost/stageo?user=root&password=root&serverTimezone=EST&characterEncoding=UTF-8");
            
            //Obliger de déclarer les variables sinon sa fonctionne pas, verifier plus tard
            UtilisateurDAO userDao = new UtilisateurDAO(c.getInstance());
            String email = request.getParameter("emailInscri");
            String nom = request.getParameter("nomInscri");
            String prenom = request.getParameter("prenomInscri");
            String password = request.getParameter("passwordInscri");
            String typeUser = request.getParameter("typeInscri");
            String idUser = UUID.randomUUID().toString();
            
            if(userDao.findByEmail(email)!=null){
                return "inscription";
            }
            else{
                Utilisateur userTemp = new Utilisateur();
                userTemp.setIdUtilisateur(idUser);
                userTemp.setCourriel(email);
                userTemp.setNom(nom);
                userTemp.setPrenom(prenom);
                userTemp.setMotDePasse(password);
                userTemp.setTypeUtilisateur(typeUser);
                userDao.create(userTemp);
                
                if("Etudiant".equals(typeUser)){
                    Etudiant etuTemp = new Etudiant();
                    EtudiantDAO etuDao = new EtudiantDAO(c.getInstance());
                    
                    etuTemp.setIdEtudiant(idUser);
                    etuTemp.setStatutRecherche("En Recherche");
                    etuDao.create(etuTemp);
                }
                else if("Employeur".equals(typeUser)){
                    String idEntreprise = UUID.randomUUID().toString();
                    Employeur empTemp = new Employeur();
                    EmployeurDAO empDao = new EmployeurDAO(c.getInstance());
                    
                    empTemp.setIdEmployeur(idUser);
                    empTemp.setTel(request.getParameter("telInscri"));
                    empTemp.setIdCompagnie(idEntreprise);
                    empDao.create(empTemp);
                    
                    //Faire que sa créé l'entreprise aussi
                }
                return "messagerie";
            }
        }catch(Exception e){return "inscription";}
    }
}
