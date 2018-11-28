/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stageo.controleur;

import com.stageo.beans.OffreStage;
import com.stageo.dao.OffreStageDAO;
import com.stageo.singleton.Connexion;

/**
 *
 * @author gabri
 */
public class DeleteOffreAction extends AbstractAction {

    @Override
    public String execute() {
        try{       
            OffreStageDAO offreDao = new OffreStageDAO(Connexion.getInstance());
            OffreStage offreTemp = new OffreStage();
            //SÉCURISÉ POUR TCHEKER QUE CEST LE BON USER !!!
            offreTemp.setIdOffre(request.getParameter("id"));
            offreDao.delete(offreTemp);
            return "gestionOffresStagesVueEmployeur";
        }catch(Exception e){
            return "" + e;
        }
    }
}
