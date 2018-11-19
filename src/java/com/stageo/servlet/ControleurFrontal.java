package com.stageo.servlet;

//Action importer pour le controleur frontal
import com.stageo.controleur.AbstractAction;
import com.stageo.controleur.AfficherGestionDocumentsVueCoordinateurAction;
import com.stageo.controleur.AfficherIncriptionAction;
import com.stageo.controleur.AfficherListeEtudiantsVueEmployeurAction;
import com.stageo.controleur.AfficherListeStagesVueEtudiantAction;
import com.stageo.controleur.AfficherMessagerie;
import com.stageo.controleur.AfficherGestionOffresStagesVueEmployeurAction;
import com.stageo.controleur.AfficherProfilEtudiantAction;
import com.stageo.controleur.DefaultAction;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControleurFrontal extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        AbstractAction action;
        String vue;
        String actionAFaire = request.getParameter("action");
        if (actionAFaire == null) actionAFaire = "";
        
        switch (actionAFaire) {
            case "afficherGestionDocumentsVueCoordinateur":
                action = new AfficherGestionDocumentsVueCoordinateurAction();
                break;
            case "afficherGestionOffresStagesVueEmployeur":
                action = new AfficherGestionOffresStagesVueEmployeurAction();
                break;
            case "afficherIncription":
                action = new AfficherIncriptionAction();
                break;
            case "afficherListeEtudiantsVueEmployeur":
                action = new AfficherListeEtudiantsVueEmployeurAction();
                break;
            case "afficherListeStagesVueEtudiant":
                action = new AfficherListeStagesVueEtudiantAction();
                break;
            case "afficherProfilEtudiant":
                action = new AfficherProfilEtudiantAction();
                break;
            case "afficherMessagerie":
                action = new AfficherMessagerie();
                break;
            default :
                action = new DefaultAction();
        }
        
        action.setRequest(request);
        action.setResponse(response);
        
        vue = action.execute();
        request.getRequestDispatcher("/WEB-INF/vues/"+vue+".jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    public String getServletInfo() {
        return "Servelet du controleurFrontal";
    }// </editor-fold>
}
