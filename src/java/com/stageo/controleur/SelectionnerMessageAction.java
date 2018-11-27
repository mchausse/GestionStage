package com.stageo.controleur;

import com.stageo.beans.Utilisateur;
import com.stageo.services.ServicesMessagerie;

/* ==== INFO ====

 * @author maxime chausse
 * date : 23 novembre 2018
 * cour : Hypermedia II
 * College Rosemont
*/
public class SelectionnerMessageAction extends AbstractAction{

    @Override
    public String execute() {
        // Retourner l'utilisateur a l'inscription si il n'est pas connecter
        if(request.getSession().getAttribute("utilisateur") == null)
            return "inscription";
        
        if(request.getParameter("messageSelectionner") != null)
            request.getSession().setAttribute("messageSelectionner", request.getParameter("messageSelectionner"));
        
        // Changer l'attribut Vu et lu du message
        ServicesMessagerie servicesMessagerie = new ServicesMessagerie();
        servicesMessagerie.voirUnMessage(request.getParameter("messageSelectionner"), ((Utilisateur)request.getSession().getAttribute("utilisateur")).getIdUtilisateur());
        
        // Retourne au bon onglet de la page
        if(request.getParameter("messageRecu") != null) request.setAttribute("vuRecus",true);
        if(request.getParameter("messageEnvoye") != null) request.setAttribute("vuEnvoyes",true);
            
        return "messagerie";
    }
    
}
