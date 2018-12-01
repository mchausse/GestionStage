/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stageo.dao;

import com.stageo.beans.OffreStage;
import com.stageo.singleton.Connexion;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author usager
 */
public class OffreStageDocuDAO extends Dao<OffreStage> {
    public OffreStageDocuDAO(){
        super(Connexion.getInstance());
    }
    public OffreStageDocuDAO(Connection cnx) {
        super(cnx);
    }
    public String create(String idOffre, String idDocu, InputStream fichier) { //string pour mieu debugger
        try {
            String requete = "INSERT INTO `offreStageDocument` (`ID_DOCUMENT`, `FICHIER`, `ID_OFFRE`) VALUES (?, ?, ?)";
            PreparedStatement requeteParam = cnx.prepareStatement(requete);
            
            requeteParam.setString(1, idDocu);
            requeteParam.setBinaryStream(2, fichier);
            requeteParam.setString(3, idOffre);
            requeteParam.executeUpdate();
            return "oui";
            
        } catch (SQLException ex) {
            Logger.getLogger(OffreStageDocuDAO.class.getName()).log(Level.SEVERE, null, ex);
            return "" + ex;
        }
    }
    @Override
    public boolean create(OffreStage x) {

        return false;
    }
    @Override
    public OffreStage findById(String id) {

        return null;
    }
    @Override
    public OffreStage find(OffreStage x) {

        return null;
    }
    @Override
    public boolean update(OffreStage x) {

        return false;
    }
    @Override
    public boolean delete(OffreStage x) {

        return false;
    }
    @Override
    public List<OffreStage> findAll() {

        return null;
    }
}
