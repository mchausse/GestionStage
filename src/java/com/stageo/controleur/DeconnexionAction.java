/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stageo.controleur;

import javax.servlet.http.HttpSession;

/**
 *
 * @author gabri
 */
public class DeconnexionAction extends AbstractAction{
    
    @Override
    public String execute() {
        request.removeAttribute("connecte");
        HttpSession session = request.getSession(true);
        session.invalidate();
        request.getSession().invalidate();
        return "inscription";
    }
}
