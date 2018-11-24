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
        UtilisateurDAO daoUser = new UtilisateurDAO(Connexion.getInstance());
        
        //Attibuts de la page
        String email = request.getParameter("emailLog");
        String password = request.getParameter("passwordLog");
        Utilisateur temp = daoUser.findByEmail(email);
        try{
            if(temp!=null && email!=null && password!=null){
                if(password.equals(temp.getMotDePasse())){
                    //Dependant du type d'utilisateur, va attribuer des attributs en plus
                    if("Employeur".equals(temp.getTypeUtilisateur())){
                        EmployeurDAO daoEmp = new EmployeurDAO(Connexion.getInstance());
                        Employeur empTemp = daoEmp.findById(temp.getIdUtilisateur());
                        Employeur currentUser = new Employeur();
                        //Set les attributs d'utilisateur
                        currentUser.setIdUtilisateur(temp.getIdUtilisateur());
                        currentUser.setMotDePasse(temp.getMotDePasse());
                        currentUser.setCourriel(temp.getCourriel());
                        currentUser.setNom(temp.getNom());
                        currentUser.setPrenom(temp.getPrenom());
                        currentUser.setTypeUtilisateur("Employeur");
                        //Set les attributs d'employeur
                        currentUser.setIdCompagnie(empTemp.getIdCompagnie());
                        currentUser.setTel(empTemp.getTel());
                        currentUser.setIdEmployeur(empTemp.getIdEmployeur());
                        request.getSession().setAttribute("utilisateur", (Employeur)currentUser);
                    }
                    if("Etudiant".equals(temp.getTypeUtilisateur())){
                        EtudiantDAO daoEtu = new EtudiantDAO(Connexion.getInstance());
                        Etudiant etuTemp = daoEtu.findById(temp.getIdUtilisateur());
                        Etudiant currentUser = new Etudiant();
                        //Set les attributs d'utilisateur
                        currentUser.setIdUtilisateur(temp.getIdUtilisateur());
                        currentUser.setMotDePasse(temp.getMotDePasse());
                        currentUser.setCourriel(temp.getCourriel());
                        currentUser.setNom(temp.getNom());
                        currentUser.setPrenom(temp.getPrenom());
                        currentUser.setTypeUtilisateur("Etudiant");
                        //Set les attributs d'un etudiant
                        currentUser.setStatutRecherche(etuTemp.getStatutRecherche());
                        currentUser.setIdEtudiant(etuTemp.getIdEtudiant());
                        request.getSession().setAttribute("utilisateur", (Etudiant)currentUser);
                    }
                    request.getSession().setAttribute("connecte", true);
                    return "messagerie";
                }
                else{
                    Avertissement aver = new Avertissement("Mot de passe ou courriel invalide.", "erreur");
                    request.getSession().setAttribute("avertissement", aver);
                    return "inscription";
                }
            }
            else{
                Avertissement aver = new Avertissement("Mot de passe ou courriel invalide.", "erreur");
                request.getSession().setAttribute("avertissement", aver);
                return "inscription";
            }
        }catch(Exception e){return ""+e;} //Si il y a une erreur
    }
}
