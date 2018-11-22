/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stageo.controleur;

/**
 *
 * @author gabri
 */
public class DeconnexionAction extends AbstractAction{
    
    @Override
    public String execute() {
        request.getSession().invalidate();
        return "inscription";
    }
}
