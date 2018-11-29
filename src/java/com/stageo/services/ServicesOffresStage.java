/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stageo.services;

import com.stageo.beans.OffreStage;
import com.stageo.dao.OffreStageDAO;
import com.stageo.singleton.Connexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* ==== INFO ====

 * @author maxime chausse
 * date : 29 novembre 2018
 * cour : Hypermedia II
 * College Rosemont
*/
public class ServicesOffresStage {
    private final Connection CNX = Connexion.getInstance();
    
    public List<OffreStage> findAllByCritere() {
//        try{
//            // Aller chercher toutes les offres de stage
//            OffreStageDAO offreStageDAO = new OffreStageDAO();
//            //List<Offrestage> liste = offreStageDAO.;
//        }
//        catch(SQLException e){
//             Logger.getLogger(OffreStageDAO.class.getName()).log(Level.SEVERE, null, e);
//        }
        return null;
    }
    
}
