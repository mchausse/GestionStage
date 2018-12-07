/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stageo.controleur;

/**
 *
 * @author usager
 */
public class AfficherProfilCompagnieVueEtudiantAction extends AbstractAction{
    @Override
    public String execute() {
        if(request.getSession().getAttribute("utilisateur") == null)
            return "inscription";
        return "profilCompagnieVueEtudiant";
    }
    
}
