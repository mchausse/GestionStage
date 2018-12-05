/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stageo.controleur;

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
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost/stageo?user=root&password=root&serverTimezone=EST");
                        
            PreparedStatement pstm = cnx.prepareStatement("SELECT * FROM cv WHERE ID_CV=?");
            pstm.setString(1, id);
            
            ResultSet res = pstm.executeQuery();
            if (res.next()) {
                fLecture = res.getBinaryStream("FICHIER");
                fEcriture = response.getOutputStream();
                response.setContentType("");
                int n;
                byte[] buffer = new byte[1024];
                while ((n=fLecture.read(buffer)) > 0) {
                    fEcriture.write(buffer,0,n);
                }
            }
            else {
               request.setAttribute("message", "Fichier "+id+" introuvable dans la BD"); 
            }
            cnx.close();

        } catch (IOException ex) {
            request.setAttribute("MESSAGE", "ERREUR : " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            request.setAttribute("MESSAGE", "ERREUR : " + ex.getMessage());
            Logger.getLogger(TelechargerCvAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            request.setAttribute("MESSAGE", "ERREUR : " + ex.getMessage());
            Logger.getLogger(TelechargerCvAction.class.getName()).log(Level.SEVERE, null, ex);
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
