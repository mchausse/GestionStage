/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stageo.controleur;

import com.stageo.beans.Avertissement;
import com.stageo.beans.Critere;
import com.stageo.beans.OffreStage;
import com.stageo.beans.OffrestagecriterePK;
import com.stageo.beans.Utilisateur;
import com.stageo.dao.CritereDAO;
import com.stageo.dao.OffreStageCritereDAO;
import com.stageo.dao.OffreStageDAO;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gabri
 */
public class EditOffreAction extends AbstractAction{

    @Override
    public String execute() {
        Utilisateur currentUser = (Utilisateur)request.getSession().getAttribute("utilisateur");
        String idOffre = request.getParameter("id");
        OffreStageDAO offreDao = new OffreStageDAO();
        OffreStage offreTemp = offreDao.findById(idOffre);
        if(offreTemp!=null && offreTemp.getIdEmployeur().equals(currentUser.getIdUtilisateur())){ //Pour etre sur que cest le bon user
            //Dates
            DateTimeFormatter dFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate d1 = LocalDate.parse(request.getParameter(idOffre+"DateDebutEdit"), dFormat);
            LocalDate d2 = LocalDate.parse(request.getParameter(idOffre+"DateFinEdit"), dFormat);
            long nbJours = ChronoUnit.DAYS.between(d1, d2);
            if(!d1.isBefore(d2)){
                Avertissement aver = new Avertissement("La date de depart doit être avant la date de fin.", "erreur");
                request.getSession().setAttribute("avertissement", aver);
                return "gestionOffresStagesVueEmployeur";
            }
            //Actif inactif
            switch (request.getParameter(idOffre+"ActiveEdit")) {
                case "Active":
                    offreTemp.setActive(true);
                    break;
                case "Inactive":
                    offreTemp.setActive(false);
                    break;
                default:
                    Avertissement aver = new Avertissement("Valeur de statut invalide.", "erreur");
                    request.getSession().setAttribute("avertissement", aver);
                    return "gestionOffresStagesVueEmployeur";
            }
            //Remuneration
            switch (request.getParameter(idOffre+"RemunereEdit")) {
                case "Oui":
                    offreTemp.setRemunere(true);
                    break;
                case "Non":
                    offreTemp.setRemunere(false);
                    break;
                default:
                    Avertissement aver = new Avertissement("Valeur de rémunération invalide.", "erreur");
                    request.getSession().setAttribute("avertissement", aver);
                    return "gestionOffresStagesVueEmployeur";
            }
            offreTemp.setDureeEnJours(Math.toIntExact(nbJours));
            offreTemp.setDateDebut(java.sql.Date.valueOf(d1));
            offreTemp.setDateFin(java.sql.Date.valueOf(d2));
            
            //Ajout de compétence
            OffreStageCritereDAO critOffreDao = new OffreStageCritereDAO();
            CritereDAO critDao = new CritereDAO();
            List<Critere> critList = critDao.findAll();
            List<String> parameterNames = new ArrayList<>(request.getParameterMap().keySet());
            for(Critere crit : critList){
                boolean verif = false;
                OffrestagecriterePK offreCrit = new OffrestagecriterePK(idOffre,crit.getIdCritere());
                for(String name : parameterNames){
                    if(name.equals(crit.getNom())){
                        if(critOffreDao.findPK(offreCrit)==null){critOffreDao.createPK(offreCrit);}
                        verif = true;
                    }
                }
                if(critOffreDao.findPK(offreCrit)!=null && !verif){critOffreDao.deletePK(offreCrit);}
            }
            
            //Reste
            offreTemp.setLienWeb(request.getParameter(idOffre+"LienWebEdit"));
            offreTemp.setDescription(request.getParameter(idOffre+"DescEdit"));
            offreTemp.setTitre(request.getParameter(idOffre+"TitreEdit"));
            
            offreDao.update(offreTemp);
            return "gestionOffresStagesVueEmployeur";
        }
        else{
            Avertissement aver = new Avertissement("La tâche ne vous appartient pas ou elle n'existe pas.", "erreur");
            request.getSession().setAttribute("avertissement", aver);
            return "gestionOffresStagesVueEmployeur";
        }
    }
    
}

