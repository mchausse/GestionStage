/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stageo.controleur;

import com.stageo.beans.Avertissement;
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
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ConnexionAction.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Obliger de déclarer les variables sinon sa fonctionne pas, verifier plus tard
        UtilisateurDAO userDao = new UtilisateurDAO(Connexion.getInstance());
        String idUser = UUID.randomUUID().toString();

        if(userDao.findByEmail(request.getParameter("emailInscri"))!=null){
            Avertissement aver = new Avertissement("Le courriel entré est déjà utilisé.", "erreur");
            request.getSession().setAttribute("avertissement", aver);
            return "inscription";
        }
        else if(!request.getParameter("passwordInscri").equals(request.getParameter("password2Inscri"))){
            Avertissement aver = new Avertissement("Vos mot de passe ne sont pas identique.", "erreur");
            request.getSession().setAttribute("avertissement", aver);
            return "inscription";
        }
        else{
            Utilisateur userTemp = new Utilisateur();
            userTemp.setIdUtilisateur(idUser);
            userTemp.setCourriel(request.getParameter("emailInscri"));
            userTemp.setNom(request.getParameter("nomInscri"));
            userTemp.setPrenom(request.getParameter("prenomInscri"));
            userTemp.setMotDePasse(request.getParameter("passwordInscri"));
            userTemp.setTypeUtilisateur(request.getParameter("typeInscri"));
            userDao.create(userTemp);

            if("Etudiant".equals(request.getParameter("typeInscri"))){
                Etudiant etuTemp = new Etudiant();
                EtudiantDAO etuDao = new EtudiantDAO(Connexion.getInstance());

                etuTemp.setIdEtudiant(idUser);
                etuTemp.setStatutRecherche("En Recherche");
                etuDao.create(etuTemp);
                
                request.getSession().setAttribute("utilisateur", etuTemp);
                request.getSession().setAttribute("connecte", true);
            }
            else if("Employeur".equals(request.getParameter("typeInscri"))){
                String idEntreprise = UUID.randomUUID().toString();
                Employeur empTemp = new Employeur();
                EmployeurDAO empDao = new EmployeurDAO(Connexion.getInstance());

                empTemp.setIdEmployeur(idUser);
                empTemp.setTel(request.getParameter("telInscri"));
                empTemp.setIdCompagnie(idEntreprise);
                empDao.create(empTemp);
                
                request.getSession().setAttribute("utilisateur", empTemp);
                request.getSession().setAttribute("connecte", true);
                //Faire que sa créé l'entreprise aussi
            }
            return "messagerie";
        }
    }
}
