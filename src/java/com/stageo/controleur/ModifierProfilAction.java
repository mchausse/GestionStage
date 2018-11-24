/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stageo.controleur;

import com.stageo.beans.Utilisateur;
import com.stageo.dao.UtilisateurDAO;

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
        return "profil";
    }
    
}