/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stageo.controleur;

import com.stageo.beans.OffreStage;
import com.stageo.dao.OffreStageDAO;

/**
 *
 * @author usager
 */
public class AfficherProfilOffreStageAction extends AbstractAction {

    @Override
    public String execute() {
        if(request.getSession().getAttribute("utilisateur") == null)
            return "inscription";
        OffreStageDAO offreStageDAO = new OffreStageDAO();
        OffreStage o = offreStageDAO.findById(request.getParameter("offreStage"));
        o.setNbVues(o.getNbVues()+1);
        offreStageDAO.update(o);
        request.setAttribute("offreStage", o);
        return "profilOffreStage";
    }
    
}
