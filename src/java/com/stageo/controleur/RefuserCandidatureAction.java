/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stageo.controleur;

import com.stageo.beans.Candidature;
import com.stageo.dao.CandidatureDAO;
import com.stageo.dao.OffreStageDAO;

/**
 *
 * @author Max
 */
public class RefuserCandidatureAction extends AbstractAction{

    @Override
    public String execute() {
        if(request.getSession().getAttribute("utilisateur") == null)
            return "inscription";
        request.setAttribute("idEtu",request.getParameter("idEtu"));
        OffreStageDAO offreStageDAO = new OffreStageDAO();
        CandidatureDAO candidatureDAO = new CandidatureDAO();
        request.setAttribute("offreStage", offreStageDAO.findById(request.getParameter("idOffre")));
        Candidature c = candidatureDAO.findById(request.getParameter("idEtu"),request.getParameter("idOffre"));
        c.setStatut("Refuser");
        candidatureDAO.update(c);
        return "listeCandidatureOffreStage";
    }
    
}
