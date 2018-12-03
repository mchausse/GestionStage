/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stageo.controleur;

import com.stageo.beans.Adresse;
import com.stageo.beans.Employeur;
import com.stageo.beans.Etudiant;
import com.stageo.beans.Compagnie;
import com.stageo.beans.Critere;
import com.stageo.beans.Cv;
import com.stageo.beans.EtudiantcriterePK;
import com.stageo.beans.Utilisateur;
import com.stageo.dao.AdresseDAO;
import com.stageo.dao.CompagnieDAO;
import com.stageo.dao.CritereDAO;
import com.stageo.dao.CvDAO;
import com.stageo.dao.EmployeurDAO;
import com.stageo.dao.EtudiantCritereDAO;
import com.stageo.dao.UtilisateurDAO;
import com.stageo.dao.EtudiantDAO;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.http.Part;

/**
 *
 * @author gabri
 */
public class ModifierProfilAction extends AbstractAction{

    @Override
    public String execute() {
        if(request.getSession().getAttribute("utilisateur") == null)
            return "inscription";
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
            //Ajout de compétence
            EtudiantCritereDAO critEtuDao = new EtudiantCritereDAO();
            CritereDAO critDao = new CritereDAO();
            List<Critere> critList = critDao.findAll();
            List<String> parameterNames = new ArrayList<>(request.getParameterMap().keySet());
            for(Critere crit : critList){
                boolean verif = false;
                EtudiantcriterePK etuCrit = new EtudiantcriterePK(currentUser.getIdUtilisateur(),crit.getIdCritere());
                for(String name : parameterNames){
                    if(name.equals(crit.getNom())){
                        if(critEtuDao.find(etuCrit)==null){critEtuDao.create(etuCrit);}
                        verif = true;
                    }
                }
                if(critEtuDao.find(etuCrit)!=null && !verif){critEtuDao.delete(etuCrit);}
            }
            CvDAO cvDao = new CvDAO();
            String cvVerif = request.getParameter("cvNom").trim();
            List<Cv> cvList = cvDao.findAllByIdEtudiant(currentUser.getIdUtilisateur());
            if((cvList.isEmpty()&& !cvVerif.equals("")) || !cvVerif.equals("")){
                Part filePart;
                try {filePart = request.getPart("fichierCV");} catch (IOException | ServletException ex) {
                    return "profil";
                }

                try(InputStream filecontent = filePart.getInputStream();){
                        String idCv = UUID.randomUUID().toString();
                        String nom = "";
                        if(request.getParameter("langueEdit").equals("Anglais")){nom="EN_"+request.getParameter("cvNom");}
                        else{nom="FR_"+request.getParameter("cvNom");}
                        Cv cvCreate = new Cv(idCv,filecontent,nom,request.getParameter("langueEdit"),0,currentUser.getIdUtilisateur(),java.sql.Date.valueOf(LocalDate.now()));
                        cvDao.create(cvCreate);

                    } 
                catch (IOException ex) {return "profil";}
            }
            else{
                boolean verif;
                for(Cv cv : cvList){
                    verif = false;
                    for(String name : parameterNames){
                        if(cv.getLien().equals(name)){verif = true;}
                    }
                    if(!verif){cvDao.delete(cv);}
                }
            }
        }
        
        //Modifier le compte Employeur
        else if("Employeur".equals(currentUser.getTypeUtilisateur())){
            EmployeurDAO empDao = new EmployeurDAO();
            Employeur empTemp = empDao.findById(currentUser.getIdUtilisateur());
            empTemp.setTel(request.getParameter("telEmpEdit"));
            empDao.update(empTemp);
            
            //Modification compagnie
            CompagnieDAO compDao = new CompagnieDAO();
            Compagnie compTemp = compDao.findById(empTemp.getIdCompagnie());
            compTemp.setNom(request.getParameter("nomCompEdit"));
            compTemp.setSiteWeb(request.getParameter("siteCompEdit"));
            compDao.update(compTemp);
            
            //Modification adresse
            AdresseDAO adDao = new AdresseDAO();
            Adresse adTemp = adDao.findById(compTemp.getIdAdresse());
            
            adTemp.setNumeroCivique(request.getParameter("numAdEdit"));
            adTemp.setRue(request.getParameter("rueAdEdit"));
            adTemp.setBureau(request.getParameter("bureauAdEdit"));
            adTemp.setVille(request.getParameter("villeAdEdit"));
            adTemp.setCodePostal(request.getParameter("codePostAdEdit"));
            adTemp.setProvince(request.getParameter("provinceAdEdit"));
            adTemp.setTel(request.getParameter("telAdEdit"));
            adTemp.setPays(request.getParameter("paysAdEdit"));
            adDao.update(adTemp);
        }
        return "profil";
    }
    
}