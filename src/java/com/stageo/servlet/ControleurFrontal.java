package com.stageo.servlet;

//Action importer pour le controleur frontal
import com.stageo.controleur.AbstractAction;
import com.stageo.controleur.AccepterCandidatureAction;
import com.stageo.controleur.AfficherCandidatureAction;
import com.stageo.controleur.AfficherCommunicationsAction;
import com.stageo.controleur.AfficherGestionDocumentsAction;
import com.stageo.controleur.AfficherInscriptionAction;
import com.stageo.controleur.AfficherListeStagesVueEtudiantAction;
import com.stageo.controleur.AfficherMessagerieAction;
import com.stageo.controleur.AfficherProfilCompagnieVueEtudiantAction;
import com.stageo.controleur.AfficherMessagesEnvoyesAction;
import com.stageo.controleur.AfficherGestionOffresStagesVueEmployeurAction;
import com.stageo.controleur.AfficherListeCandidatureOffreStageAction;
import com.stageo.controleur.AfficherProfilAction;
import com.stageo.controleur.AfficherProfilCompagnieVueCoordonnateurAction;
import com.stageo.controleur.AfficherProfilEtudiantAction;
import com.stageo.controleur.AfficherProfilOffreStageAction;
import com.stageo.controleur.ConnexionAction;
import com.stageo.controleur.CreateOffreAction;
import com.stageo.controleur.CreerNouveauDocumentAction;
import com.stageo.controleur.CreerNouveauMessageAction;
import com.stageo.controleur.DeconnexionAction;
import com.stageo.controleur.DefaultAction;
import com.stageo.controleur.DeleteOffreAction;
import com.stageo.controleur.DownloadDocumentAction;
import com.stageo.controleur.EditOffreAction;
import com.stageo.controleur.ReadStageDocuAction;
import com.stageo.controleur.EnvoyerCandidatureAction;
import com.stageo.controleur.EnvoyerMessageAction;
import com.stageo.controleur.InscriptionAction;
import com.stageo.controleur.ModifierProfilAction;
import com.stageo.controleur.PostulerOffreStageAction;
import com.stageo.controleur.RechercheParCritereAction;
import com.stageo.controleur.RefuserCandidatureAction;
import com.stageo.controleur.SelectionnerMessageAction;
import com.stageo.controleur.DeleteDocumentAction;
import com.stageo.controleur.TelechargerCvAction;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@MultipartConfig    //Nécessaire pour que la servlet puisse accéder au fichier attaché.
public class ControleurFrontal extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        AbstractAction action;
        String vue;
        String actionAFaire = request.getParameter("action");
        if (actionAFaire == null) actionAFaire = "";
        
        switch (actionAFaire) {
            case "afficherGestionDocuments":
                action = new AfficherGestionDocumentsAction();
                break;
            case "creeDocument":
                action = new CreerNouveauDocumentAction();
                break;
            case "deleteDocument":
                action = new DeleteDocumentAction();
                break;
            case "downloadDocument":
                action = new DownloadDocumentAction();
                break;
            case "afficherGestionOffresStagesVueEmployeur":
                action = new AfficherGestionOffresStagesVueEmployeurAction();
                break;
            case "afficherInscription":
                action = new AfficherInscriptionAction();
                break;
            case "afficherListeStagesVueEtudiant":
                action = new AfficherListeStagesVueEtudiantAction();
                break;
            case "afficherProfilEtudiant":
                action = new AfficherProfilEtudiantAction();
                break;
            case "connexion":
                action = new ConnexionAction();
                break;
            case "deconnexion":
                action = new DeconnexionAction();
                break;
            case "inscription":
                action = new InscriptionAction();
                break;
            case "afficherProfil":
                action = new AfficherProfilAction();
                break;
            case "modifierProfil":
                action = new ModifierProfilAction();
                break;
            case "selectionnerMessage":
                action = new SelectionnerMessageAction();
                break;
            case "creerNouveauMessage":
                action = new CreerNouveauMessageAction();
                break;
            case "afficherMessagerie":
                action = new AfficherMessagerieAction();
                break;
            case "envoyerMessage":
                action = new EnvoyerMessageAction();
                break;
            case "afficherProfilCompagnieVueEtudiant":
                action = new AfficherProfilCompagnieVueEtudiantAction();
                break;
            case "afficherProfilCompagnieVueCoordonnateur":
                action = new AfficherProfilCompagnieVueCoordonnateurAction();
                break;
            case "afficherMessagesEnvoyes":
                action = new AfficherMessagesEnvoyesAction();
                break;
            case "afficherCommunications":
                action = new AfficherCommunicationsAction();
                break;
            case "afficherCandidature":
                action = new AfficherCandidatureAction();
                break;
            case "createOffre":
                action = new CreateOffreAction();
                break;
            case "deleteOffre":
                action = new DeleteOffreAction();
                break;
            case "editOffre":
                action = new EditOffreAction();
                break;
            case "readStageDocu":
                action = new ReadStageDocuAction();
                break;
            case "afficherProfilOffreStage":
                action = new AfficherProfilOffreStageAction();
                break;
            case "envoyerCandidature":
                action = new EnvoyerCandidatureAction();
                break;
            case "rechercheParCritere":
                action = new RechercheParCritereAction();
                break;
            case "afficherListeCandidatureOffreStage":
                action = new AfficherListeCandidatureOffreStageAction();
                break;
            case "telechargerCVCandidature":
                action = new TelechargerCvAction();
                break;
            case "postulerOffreStage":
                action = new PostulerOffreStageAction();
                break;
            case "accepterCandidature":
                action = new AccepterCandidatureAction();
                break;
            case "refuserCandidature":
                action = new RefuserCandidatureAction();
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
