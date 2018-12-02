/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stageo.controleur;

import com.stageo.dao.OffreStageDAO;

/**
 *
 * @author Max
 */
public class AfficherListeCandidatureOffreStageAction extends AbstractAction {
    @Override
    public String execute() {
        OffreStageDAO offreStageDAO = new OffreStageDAO();
        request.setAttribute("offreStage", offreStageDAO.findById(request.getParameter("offreStage")));
        return "listeCandidatureOffreStage";
    }
    
}
