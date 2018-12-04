/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stageo.controleur;

import com.stageo.beans.Document;
import com.stageo.dao.DocumentDAO;
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
 * @author Samuel
 */
public class DownloadDocumentAction extends AbstractAction{
    @Override
    public String execute() {
        
        
        String id = request.getParameter("idDocu");
        if (id == null) {
            return "gestionDocuments";
        }
        InputStream fLecture = null;
        OutputStream fEcriture = null;
        try
        {
            DocumentDAO docuDao = new DocumentDAO();
            Document downloadDoc = docuDao.findById(request.getParameter("idDocu"));
            downloadDoc.setNbVues(downloadDoc.getNbVues()+1);
            docuDao.update(downloadDoc);
                fLecture = downloadDoc.getFichier();
                fEcriture = response.getOutputStream();
                int n;
                byte[] buffer = new byte[1024];
                while ((n=fLecture.read(buffer)) > 0) {
                    fEcriture.write(buffer,0,n);
                }

        } catch (IOException ex) {
            return "gestionDocuments";
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
        return "gestionDocuments";    
    }
}