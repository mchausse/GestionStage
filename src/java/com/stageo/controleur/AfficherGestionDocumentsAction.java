/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stageo.controleur;

/**
 *
 * @author Max
 */
public class AfficherGestionDocumentsAction extends AbstractAction{
    
    @Override
    public String execute() {
<<<<<<< HEAD:src/java/com/stageo/controleur/AfficherGestionDocumentsAction.java
        return "gestionDocuments";
=======
        if(request.getSession().getAttribute("utilisateur") == null)
            return "inscription";
        return "gestionDocumentsVueCoordonnateur";
>>>>>>> 25b31c978c5c87708e4d317db7520cff23c08ef6:src/java/com/stageo/controleur/AfficherGestionDocumentsVueCoordonnateurAction.java
    }
    
}
