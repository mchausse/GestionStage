package com.stageo.controleur;

import com.stageo.beans.Critere;
import com.stageo.dao.CritereDAO;
import java.util.ArrayList;
import java.util.List;

/* ==== INFO ====

 * @author maxime chausse
 * date : 29 novembre 2018
 * cour : Hypermedia II
 * College Rosemont
*/
public class RechercheParCritereAction extends AbstractAction{

    @Override
    public String execute() {
        
        // Retourner l'utilisateur a l'inscription si il n'est pas connecter
        if(request.getSession().getAttribute("utilisateur") == null)
            return "inscription";
        
        // Retourner l'utilisateur a l'inscription si il n'est pas connecter
        if("".equals(request.getParameter("listeCriteres"))){
            request.removeAttribute("criteresRecherche");
            return "listeStagesVueEtudiant";
        }
        
        // Touver les criteres entrer selon les ids
        CritereDAO critereDAO = new CritereDAO();
        List<Critere> listeC = new ArrayList<>();
        for(String c : request.getParameter("listeCriteres").split(";"))
            listeC.add(critereDAO.findById(c));
        
        request.setAttribute("criteresRecherche",listeC);
        
        return "listeStagesVueEtudiant";
    }
    
}
