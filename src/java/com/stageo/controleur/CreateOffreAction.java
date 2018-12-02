/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stageo.controleur;
import com.stageo.beans.Avertissement;
import com.stageo.beans.OffreStage;
import com.stageo.beans.Utilisateur;
import com.stageo.dao.OffreStageDAO;
import com.stageo.singleton.Connexion;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.Part;


/**
 *
 * @author gabri
 */
public class CreateOffreAction extends AbstractAction{
    @Override
    public String execute() {
        try{
            Utilisateur currentUser = (Utilisateur)request.getSession().getAttribute("utilisateur");
            OffreStage offreTemp = new OffreStage();
            String idOffre = UUID.randomUUID().toString();
            OffreStageDAO offreDao = new OffreStageDAO(Connexion.getInstance());

            //Date calcule
            DateTimeFormatter dFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate d1 = LocalDate.parse(request.getParameter("dateDebut"), dFormat);
            LocalDate d2 = LocalDate.parse(request.getParameter("dateFin"), dFormat);
            if(!d1.isBefore(d2)){
                Avertissement aver = new Avertissement("La date de depart doit être avant la date de fin.", "erreur");
                request.getSession().setAttribute("avertissement", aver);
                return "gestionOffresStagesVueEmployeur";
            }
            long nbJours = ChronoUnit.DAYS.between(d1, d2);
            
            offreTemp.setIdOffre(idOffre);
            offreTemp.setDureeEnJours(Math.toIntExact(nbJours));
            offreTemp.setDateDebut(java.sql.Date.valueOf(d1));
            offreTemp.setDateFin(java.sql.Date.valueOf(d2));
            offreTemp.setTitre(request.getParameter("titreStage"));
            offreTemp.setDescription(request.getParameter("descStage"));
            offreTemp.setLienWeb(request.getParameter("lienStage"));
            offreTemp.setDate(java.sql.Date.valueOf(LocalDate.now()));
            offreTemp.setActive(true);
            offreTemp.setNbVues(0);
            offreTemp.setIdEmployeur(currentUser.getIdUtilisateur());
            //Remuneration
            if("Oui".equals(request.getParameter("remunere"))){
                offreTemp.setRemunere(true);
            }
            else{
                offreTemp.setRemunere(false);
            }
            //POUR DOCUMENT
            Part filePart;
            String idDocu = UUID.randomUUID().toString();
            filePart = request.getPart("docuStage");
            InputStream fileContent = filePart.getInputStream();
            offreTemp.setLienDocument(fileContent);
            offreDao.create(offreTemp);
            
            Avertissement aver = new Avertissement("L'offre à été créé.", "succes");
            request.getSession().setAttribute("avertissement", aver);
            return "gestionOffresStagesVueEmployeur";

        } catch (IOException ex) {
            Logger.getLogger(CreateOffreAction.class.getName()).log(Level.SEVERE, null, ex);
            Avertissement aver = new Avertissement(""+ex, "erreur");
            request.getSession().setAttribute("avertissement", aver);
            return ""+ex;
        } catch (ServletException ex) {
            Logger.getLogger(CreateOffreAction.class.getName()).log(Level.SEVERE, null, ex);
            return ""+ex;
        }   
    }
 }
    
