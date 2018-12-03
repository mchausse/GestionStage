/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stageo.controleur;

import com.stageo.beans.Adresse;
import com.stageo.beans.Avertissement;
import com.stageo.beans.Compagnie;
import com.stageo.beans.Employeur;
import com.stageo.beans.Etudiant;
import com.stageo.beans.Utilisateur;
import com.stageo.dao.AdresseDAO;
import com.stageo.dao.CompagnieDAO;
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
        if(request.getSession().getAttribute("utilisateur") == null)
            return "inscription";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ConnexionAction.class.getName()).log(Level.SEVERE, null, ex);
        }
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
                
                //Attributs pour l'étudiant
                etuTemp.setIdEtudiant(idUser);
                etuTemp.setStatutRecherche("En Recherche");
                etuDao.create(etuTemp);
            }
            else if("Employeur".equals(request.getParameter("typeInscri"))){
                String idCompagnie= UUID.randomUUID().toString();
                String idAdresse = UUID.randomUUID().toString();
                
                //Objets pour l'employeur
                Employeur empTemp = new Employeur();
                Compagnie compTemp = new Compagnie();
                Adresse adTemp = new Adresse();
                
                //DAOs pour l'employeur
                EmployeurDAO empDao = new EmployeurDAO(Connexion.getInstance());
                CompagnieDAO compDao = new CompagnieDAO(Connexion.getInstance());
                AdresseDAO adDao = new AdresseDAO(Connexion.getInstance());
                
                //Creation de l'employeur
                empTemp.setIdEmployeur(idUser);
                empTemp.setTel(request.getParameter("telInscri"));
                empTemp.setIdCompagnie(idCompagnie);
                empDao.create(empTemp);
                
                //Creation de la comapgnie
                compTemp.setIdCompagnie(idCompagnie);
                compTemp.setNom(request.getParameter("entrepriseInscri"));
                compTemp.setIdAdresse(idAdresse);
                compTemp.setSiteWeb(""); //rajouter un champs non-obligatoire dans le form
                compDao.create(compTemp);
                
                //Création de l'adresse
                adTemp.setIdAdresse(idAdresse);
                adTemp.setTel(request.getParameter("telInscri"));
                adTemp.setNumeroCivique("");
                adTemp.setRue("");
                adTemp.setBureau("");
                adTemp.setVille("");
                adTemp.setCodePostal("");
                adTemp.setProvince("");
                adTemp.setPays("");
                adTemp.setTel("");
                adDao.create(adTemp); //Le champs vide vont se faire set dans le profil
            }
            //Set l'avertissement
            Avertissement aver = new Avertissement("Votre compte a été créé.", "succes");
            request.getSession().setAttribute("avertissement", aver);
            return "inscription";
        }
    }
}
