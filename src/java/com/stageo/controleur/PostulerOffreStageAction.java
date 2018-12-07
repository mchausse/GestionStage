/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stageo.controleur;

import com.stageo.beans.Candidature;
import com.stageo.beans.CandidaturePK;
import com.stageo.beans.Utilisateur;
import com.stageo.dao.CandidatureDAO;
import com.stageo.dao.OffreStageDAO;
import java.time.LocalDateTime;

/**
 *
 * @author Max
 */
public class PostulerOffreStageAction extends AbstractAction{

    @Override
    public String execute() {
        if(request.getSession().getAttribute("utilisateur") == null)
            return "inscription";
        if(request.getSession().getAttribute("utilisateur") == null)
            return "inscription";
        OffreStageDAO offreStageDAO = new OffreStageDAO();
        request.setAttribute("offreStage", offreStageDAO.findById(request.getParameter("offreStage")));
        // Init les variables
        CandidatureDAO candidatureDAO = new CandidatureDAO();
        Candidature candidature = new Candidature();
        
        // Construire la candidature
        candidature.setCandidaturePK(new CandidaturePK(((Utilisateur)request.getSession().getAttribute("utilisateur")).getIdUtilisateur(),request.getParameter("offreStage")));
        candidature.setDate(java.sql.Timestamp.valueOf(LocalDateTime.now()));
        candidature.setStatut("En attente");
        
        // Cree la candidature dans la bd
        boolean envoye = candidatureDAO.create(candidature);
        
        // Verifier si elle cest bien evoyer
        request.setAttribute("envoye",envoye);
        
        return "profilOffreStage";
    }
    
}
