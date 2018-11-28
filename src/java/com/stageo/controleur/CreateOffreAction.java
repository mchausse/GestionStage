/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stageo.controleur;
import com.stageo.beans.OffreStage;
import com.stageo.beans.Utilisateur;
import com.stageo.dao.OffreStageDAO;
import com.stageo.singleton.Connexion;
import java.time.LocalDate;
import java.util.UUID;


/**
 *
 * @author gabri
 */
public class CreateOffreAction extends AbstractAction{
    @Override
    public String execute() {
        try{
            Utilisateur currentUser = (Utilisateur)request.getSession().getAttribute("utilisateur");
            OffreStage offreTemp = new OffreStage();
            String idOffre = UUID.randomUUID().toString();
            OffreStageDAO offreDao = new OffreStageDAO(Connexion.getInstance());

            offreTemp.setIdOffre(idOffre);
            offreTemp.setTitre(request.getParameter("titreStage"));
            offreTemp.setDescription(request.getParameter("descStage"));
            offreTemp.setLienWeb(request.getParameter("lienStage"));
            offreTemp.setLienDocument("");
            offreTemp.setDate(java.sql.Date.valueOf(LocalDate.now()));
            offreTemp.setActive(true);
            offreTemp.setNbVues(0);
            offreTemp.setIdEmployeur(currentUser.getIdUtilisateur());
            offreDao.create(offreTemp);

            return "gestionOffresStagesVueEmployeur";
        }catch(Exception e){
            return "" + e; //Changer quand ma ajouter la gestion des erreurs.
        }
    }
    
}