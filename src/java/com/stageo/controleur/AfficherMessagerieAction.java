package com.stageo.controleur;
/* ==== INFO ====

 * @author maxime chausse
 * date : 23 novembre 2018
 * cour : Hypermedia II
 * College Rosemont
*/
public class AfficherMessagerieAction extends AbstractAction{
    @Override
    public String execute() {
        // Retourner l'utilisateur a l'inscription si il n'est pas connecter
        if(request.getSession().getAttribute("utilisateur") == null)
            return "inscription";
        
        return "messagerie";
    }
    
}
