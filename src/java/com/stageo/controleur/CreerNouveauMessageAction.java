package com.stageo.controleur;
/* ==== INFO ====

 * @author maxime chausse
 * date : 23 novembre 2018
 * cour : Hypermedia II
 * College Rosemont
*/
public class CreerNouveauMessageAction extends AbstractAction{
    @Override
    public String execute() {
        // Retourner l'utilisateur a l'inscription si il n'est pas connecter
        if(request.getSession().getAttribute("utilisateur") == null)
            return "inscription";
        
        // Effacer le id du message selectionner enregistrer dans la session
        if(request.getSession().getAttribute("messageSelectionner") != null)
            request.getSession().removeAttribute("messageSelectionner");
        
        request.setAttribute("enCreation", true);
        return "messagerie";
    }
}
