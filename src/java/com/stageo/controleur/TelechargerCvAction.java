/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stageo.controleur;

import com.stageo.beans.Cv;
import com.stageo.dao.CvDAO;
import com.stageo.dao.OffreStageDAO;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Max
 */
public class TelechargerCvAction extends AbstractAction{
    
    @Override
    public String execute() {
        
        if(request.getSession().getAttribute("utilisateur") == null)
            return "inscription";
        String id = request.getParameter("cvId");
        request.setAttribute("idEtu",request.getParameter("idEtu"));
        OffreStageDAO offreStageDAO = new OffreStageDAO();
        request.setAttribute("offreStage", offreStageDAO.findById(request.getParameter("idOffre")));
        if (id == null) {
            return "listeCandidatureOffreStage";
        }
        InputStream fLecture = null;
        OutputStream fEcriture = null;
        try
        {
            response.setContentType("");
            CvDAO cvDAO = new CvDAO();
            Cv cv = cvDAO.findById(id);
            
            if (cv != null) {
                fLecture = cv.getFichier();
                fEcriture = response.getOutputStream();
               
                int n;
                byte[] buffer = new byte[1024];
                while ((n=fLecture.read(buffer)) > 0) {
                    fEcriture.write(buffer,0,n);
                }
            }
            else {
               return "listeCandidatureOffreStage";
            }

        } catch (IOException ex) {
            request.setAttribute("MESSAGE", "ERREUR : " + ex.getMessage());
        } 
        
        finally {
            try {
                if (fLecture != null) {
                    fLecture.close();
                }
                if (fEcriture != null) {
                    fEcriture.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return "listeCandidatureOffreStage";    
    }
           
}
