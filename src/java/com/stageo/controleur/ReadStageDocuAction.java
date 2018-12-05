/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stageo.controleur;
import com.stageo.beans.Avertissement;
import com.stageo.beans.OffreStage;
import com.stageo.dao.OffreStageDAO;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/*
 *
 * @author gabri
 */
public class ReadStageDocuAction extends AbstractAction{
    @Override
    public String execute() {
        String id = request.getParameter("id");
        if (id == null) {
            Avertissement aver = new Avertissement("Le ID du document est requis.", "erreur");
            request.getSession().setAttribute("avertissement", aver);
            return "gestionOffresStagesVueEmployeur";
        }
        InputStream fLecture = null;
        OutputStream fEcriture = null;
        try{
            response.setContentType("");
            OffreStageDAO offreDao = new OffreStageDAO();
            OffreStage offreTemp = offreDao.findById(id);
            
            if (offreTemp!=null) {
                fLecture = offreTemp.getLienDocument();
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
        } catch (IOException ex) {
            request.setAttribute("MESSAGE", "ERREUR : " + ex.getMessage());
        }
        Avertissement aver = new Avertissement("Le document n'existe pas.", "erreur");
        request.getSession().setAttribute("avertissement", aver);
        return "gestionOffresStagesVueEmployeur";        
    }
}