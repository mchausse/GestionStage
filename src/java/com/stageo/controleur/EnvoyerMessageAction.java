package com.stageo.controleur;
/* ==== INFO ====

 * @author maxime chausse
 * date : 24 novembre 2018
 * cour : Hypermedia II
 * College Rosemont
*/
public class EnvoyerMessageAction extends AbstractAction{

    @Override
    public String execute() {
        // Retourner l'utilisateur a l'inscription si il n'est pas connecter
        if(request.getSession().getAttribute("utilisateur") == null)
            return "inscription";
        
        // Verifier que les champs sont remplis
        
        return "messagerie";
    }
    
}
