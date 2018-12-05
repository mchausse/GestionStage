/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stageo.controleur;

import com.stageo.beans.Document;
import com.stageo.beans.Utilisateur;
import com.stageo.dao.DocumentDAO;
import com.stageo.dao.UtilisateurDAO;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.http.Part;



/**
 *
 * @author Samuel
 */
public class CreerNouveauDocumentAction extends AbstractAction{
    @Override
    public String execute() {
        Utilisateur currentUser = (Utilisateur)request.getSession().getAttribute("utilisateur");
        DocumentDAO docuDao = new DocumentDAO();
            String docuVerif = request.getParameter("docuNom").trim();
            
            if(!docuVerif.equals("")){
                Part filePart;
                try {filePart = request.getPart("fichierDocu");} catch (IOException | ServletException ex) {
                    return "gestionDocuments";
                }

                try(InputStream filecontent = filePart.getInputStream();){
                        String idDocu = UUID.randomUUID().toString();
                        Document docuCreate = new Document(idDocu,request.getParameter("titre"),filecontent,request.getParameter("docuNom"),request.getParameter("typeDocu"),0,currentUser.getIdUtilisateur(),java.sql.Date.valueOf(LocalDate.now()));
                        docuDao.create(docuCreate);

                    } 
                catch (IOException ex) {return "gestionDocuments";}
            }
        return "gestionDocuments";
    }
}
