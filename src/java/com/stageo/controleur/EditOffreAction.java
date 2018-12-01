/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stageo.controleur;

import com.stageo.beans.Avertissement;
import com.stageo.beans.OffreStage;
import com.stageo.beans.Utilisateur;
import com.stageo.dao.OffreStageDAO;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

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
            //Actif inactif
            if("Active".equals(request.getParameter(idOffre+"ActiveEdit"))){
                offreTemp.setActive(true);
            }
            else if("Inactive".equals(request.getParameter(idOffre+"ActiveEdit"))){
                offreTemp.setActive(false);
            }
            else{
                Avertissement aver = new Avertissement("Valeur de statut invalide.", "erreur");
                request.getSession().setAttribute("avertissement", aver);
                return "gestionOffresStagesVueEmployeur";
            }
            //Remuneré
            if("Oui".equals(request.getParameter(idOffre+"RemunereEdit"))){
                offreTemp.setRemunere(true);
            }
            else if("Non".equals(request.getParameter(idOffre+"RemunereEdit"))){
                offreTemp.setRemunere(false);
            }            
            else{
                Avertissement aver = new Avertissement("Valeur de rémunération invalide.", "erreur");
                request.getSession().setAttribute("avertissement", aver);
                return "gestionOffresStagesVueEmployeur";
            }
            //Dates
            DateTimeFormatter dFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate d1 = LocalDate.parse(request.getParameter(idOffre+"DateDebutEdit"), dFormat);
            LocalDate d2 = LocalDate.parse(request.getParameter(idOffre+"DateFinEdit"), dFormat);
            long nbJours = ChronoUnit.DAYS.between(d1, d2);
            
            offreTemp.setDureeEnJours(Math.toIntExact(nbJours));
            offreTemp.setDateDebut(java.sql.Date.valueOf(d1));
            offreTemp.setDateFin(java.sql.Date.valueOf(d2));
            
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
