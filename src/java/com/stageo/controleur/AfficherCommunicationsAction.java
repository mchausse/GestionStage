package com.stageo.controleur;

import com.stageo.beans.Utilisateur;

/* ==== INFO ====

 * @author maxime chausse
 * date : 27 novembre 2018
 * cour : Hypermedia II
 * College Rosemont
*/
public class AfficherCommunicationsAction extends AbstractAction{

    @Override
    public String execute() {
        // Retourner l'utilisateur a l'inscription si il n'est pas connecter
        if(request.getSession().getAttribute("utilisateur") == null)
            return "inscription";
        
        // Retourner l'utilisateur a l'inscription si il n'est pas un coordonateur
        if(("Coordonnateur".equals(((Utilisateur)request.getSession().getAttribute("utilisateur")).getTypeUtilisateur())))
            return "communications";
        
        return "inscription";
    }
    
}
