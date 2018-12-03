package com.stageo.controleur;

import com.stageo.beans.Candidature;
import com.stageo.beans.CandidaturePK;
import com.stageo.beans.Utilisateur;
import com.stageo.dao.CandidatureDAO;
import java.time.LocalDateTime;

/* ==== INFO ====

 * @author maxime chausse
 * date : 29 novembre 2018
 * cour : Hypermedia II
 * College Rosemont
*/
public class EnvoyerCandidatureAction extends AbstractAction{
    @Override
    public String execute() {
        // Retourner l'utilisateur a l'inscription si il n'est pas connecter
        if(request.getSession().getAttribute("utilisateur") == null)
            return "inscription";
        
        // Init les variables
        CandidatureDAO candidatureDAO = new CandidatureDAO();
        Candidature candidature = new Candidature();
        
        // Construire la candidature
        candidature.setCandidaturePK(new CandidaturePK(((Utilisateur)request.getSession().getAttribute("utilisateur")).getIdUtilisateur(),request.getParameter("idOffre")));
        candidature.setDate(java.sql.Timestamp.valueOf(LocalDateTime.now()));
        candidature.setStatut("En attente");
        
        // Cree la candidature dans la bd
        boolean envoye = candidatureDAO.create(candidature);
        
        // Verifier si elle cest bien evoyer
        request.setAttribute("envoye",envoye);
        
        return "listeStagesVueEtudiant";
    }
    
}
