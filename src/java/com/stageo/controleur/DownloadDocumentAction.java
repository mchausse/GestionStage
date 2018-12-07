/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stageo.controleur;

import com.stageo.beans.Avertissement;
import com.stageo.beans.Document;
import com.stageo.dao.DocumentDAO;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author Samuel
 */
public class DownloadDocumentAction extends AbstractAction{
    @Override
    public String execute() {
        String id = request.getParameter("idDocu");
        if (id == null) {
            Avertissement aver = new Avertissement("Le ID du document est requis.", "erreur");
            request.getSession().setAttribute("avertissement", aver);
            return "gestionDocuments";
        }
        InputStream fLecture = null;
        OutputStream fEcriture = null;
        try{
            response.setContentType("");
            DocumentDAO docuDao = new DocumentDAO();
            Document docu = docuDao.findById(id);
            docu.setNbVues(docu.getNbVues()+1);
            docuDao.updateNbVue(docu);
            
            if (docu!=null) {
                fLecture = docu.getFichier();
                fEcriture = response.getOutputStream();
                int n;
                byte[] buffer = new byte[1024];
                while ((n=fLecture.read(buffer)) > 0) {
                    fEcriture.write(buffer,0,n);
                }
                
                return "gestionDocuments";
            }
            Avertissement aver = new Avertissement("Le document n'existe pas.", "erreur");
            request.getSession().setAttribute("avertissement", aver);
            return "gestionDocuments";  
        } 
        catch (IOException ex) {
            Avertissement aver = new Avertissement(": " + ex, "erreur");
            request.getSession().setAttribute("avertissement", aver);
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
    }
}