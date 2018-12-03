/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stageo.controleur;

import com.stageo.beans.Avertissement;
import com.stageo.beans.OffreStage;
import com.stageo.beans.Utilisateur;
import com.stageo.dao.OffreStageCritereDAO;
import com.stageo.dao.OffreStageDAO;
import com.stageo.singleton.Connexion;

/**
 *
 * @author gabri
 */
public class DeleteOffreAction extends AbstractAction {

    @Override
    public String execute() {
        if(request.getSession().getAttribute("utilisateur") == null)
            return "inscription";
        try{
            Utilisateur currentUser = (Utilisateur)request.getSession().getAttribute("utilisateur");
            OffreStageDAO offreDao = new OffreStageDAO(Connexion.getInstance());
            OffreStageCritereDAO critDao = new OffreStageCritereDAO();
            OffreStage offreTemp = offreDao.findById(request.getParameter("id"));
            
            if(offreTemp.getIdEmployeur().equals(currentUser.getIdUtilisateur())){
                offreDao.delete(offreTemp);
                critDao.deleteByIdOffre(offreTemp.getIdOffre());
                Avertissement aver = new Avertissement("L'offre à été supprimé.", "succes");
                request.getSession().setAttribute("avertissement", aver);
            }
            else{
                Avertissement aver = new Avertissement("Vous ne pouvez pas supprimer des offres qui ne sont pas à vous.", "erreur");
                request.getSession().setAttribute("avertissement", aver);
            }
            return "gestionOffresStagesVueEmployeur";
        }catch(Exception e){
            Avertissement aver = new Avertissement(""+e, "erreur");
            request.getSession().setAttribute("avertissement", aver);
            return "gestionOffresStagesVueEmployeur";
        }
    }
}
