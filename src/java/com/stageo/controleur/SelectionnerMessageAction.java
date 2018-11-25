package com.stageo.controleur;
/* ==== INFO ====

 * @author maxime chausse
 * date : 23 novembre 2018
 * cour : Hypermedia II
 * College Rosemont
*/
public class SelectionnerMessageAction extends AbstractAction{

    @Override
    public String execute() {
        // Ajouter le fonction qui change lattribu LU du message
        if(request.getParameter("messageSelectionner") != null)
            request.getSession().setAttribute("messageSelectionner", request.getParameter("messageSelectionner"));
        return "messagerie";
    }
    
}
