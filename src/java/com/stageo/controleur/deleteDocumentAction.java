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
import java.time.LocalDate;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.http.Part;

/**
 *
 * @author Samuel
 */
public class DeleteDocumentAction extends AbstractAction{
    @Override
    public String execute() {
        DocumentDAO docuDao = new DocumentDAO();
        Document deleteDoc = docuDao.findById(request.getParameter("idDocu"));
        docuDao.delete(deleteDoc);
        return "gestionDocuments";
    }
}
