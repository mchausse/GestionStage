/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stageo.dao;

import com.stageo.beans.OffreStage;
import com.stageo.singleton.Connexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usager
 */
public class OffreStageDAO extends Dao<OffreStage> {
    public OffreStageDAO(){
        super(Connexion.getInstance());
    }
    public OffreStageDAO(Connection cnx) {
        super(cnx);
    }

    @Override
    public boolean create(OffreStage x) {
        try{
            String requete = "INSERT INTO `offrestage` (`ID_OFFRE`,`TITRE`,`DESCRIPTION`,`LIEN_WEB`, `LIEN_DOCUMENT`, `DATE`, `NB_VUES`, `ACTIVE`, `ID_EMPLOYEUR`) VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement requeteParam = cnx.prepareStatement(requete); 
            
            requeteParam.setString(1, x.getIdOffre());
            requeteParam.setString(2, x.getTitre());
            requeteParam.setString(3, x.getDescription());
            requeteParam.setString(4, x.getLienWeb());
            requeteParam.setString(5, x.getLienDocument());
            requeteParam.setDate(6, new java.sql.Date(x.getDate().getTime()));
            requeteParam.setInt(7, x.getNbVues());
            requeteParam.setInt(8, (x.getActive())?1:0);
            requeteParam.setString(9, x.getIdEmployeur());
            requeteParam.executeUpdate();
            return true;
        }
        catch(SQLException e){
             Logger.getLogger(OffreStageDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    @Override
    public OffreStage findById(String id) {
        try{
            String requete = "SELECT * FROM `offrestage` WHERE `ID_OFFRE` = ?";
            PreparedStatement requeteParam = cnx.prepareStatement(requete); 
            
            requeteParam.setString(1, id);
            ResultSet rs = requeteParam.executeQuery();
            if(rs.next()){
                OffreStage o = new OffreStage();
                o.setIdOffre(rs.getString("ID_OFFRE"));
                o.setTitre(rs.getString("TITRE"));
                o.setDescription(rs.getString("DESCRIPTION"));
                o.setLienWeb(rs.getString("LIEN_WEB"));                
                o.setLienDocument(rs.getString("LIEN_DOCUMENT"));
                o.setDate(rs.getDate("DATE"));
                o.setNbVues(rs.getInt("NB_VUES"));
                o.setActive(rs.getInt("ACTIVE")==1);
                o.setIdEmployeur(rs.getString("ID_EMPLOYEUR"));
                return o;
            }
            return null;
        }
        catch(SQLException e){
             Logger.getLogger(OffreStageDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    @Override
    public OffreStage find(OffreStage x) {
        try{
            String requete = "SELECT * FROM `offrestage` WHERE `ID_OFFRE` = ?";
            PreparedStatement requeteParam = cnx.prepareStatement(requete); 
            
            requeteParam.setString(1, x.getIdOffre());
            ResultSet rs = requeteParam.executeQuery();
            if(rs.next()){
                OffreStage o = new OffreStage();
                o.setIdOffre(rs.getString("ID_OFFRE"));
                o.setTitre(rs.getString("TITRE"));
                o.setDescription(rs.getString("DESCRIPTION"));
                o.setLienWeb(rs.getString("LIEN_WEB"));                
                o.setLienDocument(rs.getString("LIEN_DOCUMENT"));
                o.setDate(rs.getDate("DATE"));
                o.setNbVues(rs.getInt("NB_VUES"));
                o.setActive(rs.getInt("ACTIVE")==1);
                o.setIdEmployeur(rs.getString("ID_EMPLOYEUR"));
                return o;
            }
            return null;
        }
        catch(SQLException e){
             Logger.getLogger(OffreStageDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    @Override
    public boolean update(OffreStage x) {
        try{
            String requete = "UPDATE `offrestage` SET `TITRE` = ?, `DESCRIPTION` = ?, `LIEN_WEB` = ?, `LIEN_DOCUMENT` = ?, `DATE` = ?, `NB_VUES` = ?, `ACTIVE` = ?, `ID_EMPLOYEUR` = ?"
            + "WHERE `offrestage`.`ID_OFFRE` = ?";
            PreparedStatement requeteParam = cnx.prepareStatement(requete);
            
            requeteParam.setString(1, x.getTitre());
            requeteParam.setString(2, x.getDescription());
            requeteParam.setString(3, x.getLienWeb());
            requeteParam.setString(4, x.getLienDocument());
            requeteParam.setDate(5, new java.sql.Date(x.getDate().getTime()));
            requeteParam.setInt(6, x.getNbVues());
            requeteParam.setInt(7, (x.getActive())?1:0);
            requeteParam.setString(8, x.getIdEmployeur());
            requeteParam.setString(9, x.getIdOffre());
            
            requeteParam.executeUpdate();
            return true;
        }
        catch(SQLException e){
            Logger.getLogger(DocumentDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    @Override
    public boolean delete(OffreStage x) {
        try{
            String requete = "DELETE FROM `offrestage` WHERE `offrestage`.`ID_OFFRE` = ?";
            PreparedStatement requeteParam = cnx.prepareStatement(requete); 
            
            requeteParam.setString(1, x.getIdOffre());
            requeteParam.executeUpdate();

            return true;
        }
        catch(SQLException e){
             Logger.getLogger(OffreStageDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
    public String deleteById(String id) {
        try{
            String requete = "DELETE FROM `offrestage` WHERE `offrestage`.`ID_OFFRE` = ?";
            PreparedStatement requeteParam = cnx.prepareStatement(requete); 
            
            requeteParam.setString(1, id);
            requeteParam.executeUpdate();
            return "Fait";
        }
        catch(SQLException e){
             Logger.getLogger(OffreStageDAO.class.getName()).log(Level.SEVERE, null, e);
             return "" + e;
        }
        
    }

    @Override
    public List<OffreStage> findAll() {
        try{
            List<OffreStage> liste = new ArrayList();
            String requete = "SELECT * FROM `offrestage` ORDER BY OFFRESTAGE.DATE DESC";
            PreparedStatement requeteParam = cnx.prepareStatement(requete); 
            ResultSet rs = requeteParam.executeQuery();
            
            while(rs.next()){
                OffreStage o = new OffreStage();
                o.setIdOffre(rs.getString("ID_OFFRE"));
                o.setTitre(rs.getString("TITRE"));
                o.setDescription(rs.getString("DESCRIPTION"));
                o.setLienWeb(rs.getString("LIEN_WEB"));                
                o.setLienDocument(rs.getString("LIEN_DOCUMENT"));
                o.setDate(rs.getDate("DATE"));
                o.setNbVues(rs.getInt("NB_VUES"));
                o.setActive(rs.getInt("ACTIVE")==1);
                o.setIdEmployeur(rs.getString("ID_EMPLOYEUR"));
                liste.add(o);
            }
            return liste;
        }
        catch(SQLException e){
             Logger.getLogger(OffreStageDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
        public List<OffreStage> findByUserId(String id) {
        try{
            List<OffreStage> liste = new ArrayList();
            String requete = "SELECT * FROM `offrestage` WHERE ID_EMPLOYEUR=?";
            PreparedStatement requeteParam = cnx.prepareStatement(requete); 
            requeteParam.setString(1, id);
            ResultSet rs = requeteParam.executeQuery();
            
            while(rs.next()){
                OffreStage o = new OffreStage();
                o.setIdOffre(rs.getString("ID_OFFRE"));
                o.setTitre(rs.getString("TITRE"));
                o.setDescription(rs.getString("DESCRIPTION"));
                o.setLienWeb(rs.getString("LIEN_WEB"));                
                o.setLienDocument(rs.getString("LIEN_DOCUMENT"));
                o.setDate(rs.getDate("DATE"));
                o.setNbVues(rs.getInt("NB_VUES"));
                o.setActive(rs.getInt("ACTIVE")==1);
                o.setIdEmployeur(rs.getString("ID_EMPLOYEUR"));
                liste.add(o);
            }
            return liste;
        }
        catch(SQLException e){
             Logger.getLogger(OffreStageDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
}
