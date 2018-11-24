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
import com.stageo.dao.UtilisateurDAO;
import com.stageo.dao.EtudiantDAO;

/**
 *
 * @author gabri
 */
public class ModifierProfilAction extends AbstractAction{

    @Override
    public String execute() {
        //Modifier le compte Utilisateur
        Utilisateur currentUser = (Utilisateur)request.getSession().getAttribute("utilisateur");
        UtilisateurDAO userDao = new UtilisateurDAO();
        Utilisateur userTemp = new Utilisateur();
        
        userTemp.setNom(request.getParameter("nomEdit"));
        userTemp.setPrenom(request.getParameter("prenomEdit"));
        userTemp.setCourriel(request.getParameter("emailEdit"));
        userTemp.setTypeUtilisateur(currentUser.getTypeUtilisateur());
        userTemp.setIdUtilisateur(currentUser.getIdUtilisateur());
        userTemp.setMotDePasse(currentUser.getMotDePasse());
        userDao.update(userTemp);
        
        //Modifier le compte de l'élève
        if("Etudiant".equals(currentUser.getTypeUtilisateur())){
            EtudiantDAO etuDao = new EtudiantDAO();
            Etudiant etuTemp = etuDao.findById(currentUser.getIdUtilisateur());
            etuTemp.setStatutRecherche(request.getParameter("statutEdit"));
            etuDao.update(etuTemp);
        }
        //Modifier le compte Employeur
        else if("Employeur".equals(currentUser.getTypeUtilisateur())){
            EmployeurDAO empDao = new EmployeurDAO();
            Employeur empTemp = empDao.findById(currentUser.getIdUtilisateur());
            empTemp.setTel(request.getParameter("telEmpEdit"));
            empDao.update(empTemp);
            
            //Modification compagnie
        }
        return "profil";
    }
    
}