/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stageo.controleur;
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
/**SELECT * FROM `offrestagedocument` WHERE `offrestagedocument`.`ID_DOCUMENT` = ?
 *"jdbc:mysql://localhost/stageo?user=root&password=root&serverTimezone=EST"
 * @author gabri
 */
public class ReadStageDocuAction extends AbstractAction{
    @Override
    public String execute() {
        String id = request.getParameter("id");
        if (id == null) {
            return "index";
        }
        InputStream fLecture = null;
        OutputStream fEcriture = null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost/stageo?user=root&password=root&serverTimezone=EST");
                        
            PreparedStatement pstm = cnx.prepareStatement("SELECT * FROM `offrestage` WHERE `offrestage`.`ID_OFFRE` = ?");
            pstm.setString(1, id);
            
            ResultSet res = pstm.executeQuery();
            if (res.next()) {
                fLecture = res.getBinaryStream("FICHIER");
                fEcriture = response.getOutputStream();
                int n;
                byte[] buffer = new byte[1024];
                while ((n=fLecture.read(buffer)) > 0) {
                    fEcriture.write(buffer,0,n);
                }
            }
            else {
               request.setAttribute("MESSAGE", "Fichier "+id+" introuvable dans la BD"); 
            }
            cnx.close();
        } catch (IOException ex) {
            request.setAttribute("MESSAGE", "ERREUR : " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            request.setAttribute("MESSAGE", "ERREUR : " + ex.getMessage());
            //Logger.getLogger(UploadAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            request.setAttribute("MESSAGE", "ERREUR : " + ex.getMessage());
            //Logger.getLogger(UploadAction.class.getName()).log(Level.SEVERE, null, ex);
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
        return "messagerie";        
    }
    
}