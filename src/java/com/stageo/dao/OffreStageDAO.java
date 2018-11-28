/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stageo.dao;

import com.stageo.beans.Offrestage;
import com.stageo.singleton.Connexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usager
 */
public class OffreStageDAO extends Dao<Offrestage> {
    public OffreStageDAO(){
        super(Connexion.getInstance());
    }
    public OffreStageDAO(Connection cnx) {
        super(cnx);
    }

    @Override
    public boolean create(Offrestage x) {
        try{
            String requete = "INSERT INTO `offrestage` (`ID_OFFRE`,`TITRE`,`DESCRIPTION`,`LIEN_WEB`, `LIEN_DOCUMENT`, `DATE`, `NB_VUES`, `ACTIVE`, `ID_EMPLOYEUR`) VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement requeteParam = cnx.prepareStatement(requete); 
            
            requeteParam.setString(1, x.getIdOffre());
            requeteParam.setString(2, x.getTitre());
            requeteParam.setString(3, x.getDescription());
            requeteParam.setString(4, x.getLienWeb());
            requeteParam.setString(5, x.getLienDocument());
            requeteParam.setTimestamp(6, (Timestamp) x.getDate());
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
    public Offrestage findById(String id) {
        try{
            String requete = "SELECT * FROM `offrestage` WHERE `ID_OFFRE` = ?";
            PreparedStatement requeteParam = cnx.prepareStatement(requete); 
            
            requeteParam.setString(1, id);
            ResultSet rs = requeteParam.executeQuery();
            if(rs.next()){
                Offrestage o = new Offrestage();
                o.setIdOffre(rs.getString("ID_OFFRE"));
                o.setTitre(rs.getString("TITRE"));
                o.setDescription(rs.getString("DESCRIPTION"));
                o.setLienWeb(rs.getString("LIEN_WEB"));                
                o.setLienDocument(rs.getString("LIEN_DOCUMENT"));
                o.setDate(rs.getTimestamp("DATE"));
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
    public Offrestage find(Offrestage x) {
        try{
            String requete = "SELECT * FROM `offrestage` WHERE `ID_OFFRE` = ?";
            PreparedStatement requeteParam = cnx.prepareStatement(requete); 
            
            requeteParam.setString(1, x.getIdOffre());
            ResultSet rs = requeteParam.executeQuery();
            if(rs.next()){
                Offrestage o = new Offrestage();
                o.setIdOffre(rs.getString("ID_OFFRE"));
                o.setTitre(rs.getString("TITRE"));
                o.setDescription(rs.getString("DESCRIPTION"));
                o.setLienWeb(rs.getString("LIEN_WEB"));                
                o.setLienDocument(rs.getString("LIEN_DOCUMENT"));
                o.setDate(rs.getTimestamp("DATE"));
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
    public boolean update(Offrestage x) {
        try{
            String requete = "UPDATE `offrestage` SET `TITRE` = ?, `DESCRIPTION` = ?, `LIEN_WEB` = ?, `LIEN_DOCUMENT` = ?, `DATE` = ?, `NB_VUES` = ?, `ACTIVE` = ?, `ID_EMPLOYEUR` = ?"
            + "WHERE `offrestage`.`ID_OFFRE` = ?";
            PreparedStatement requeteParam = cnx.prepareStatement(requete);
            
            requeteParam.setString(1, x.getTitre());
            requeteParam.setString(2, x.getDescription());
            requeteParam.setString(3, x.getLienWeb());
            requeteParam.setString(4, x.getLienDocument());
            requeteParam.setTimestamp(5, (Timestamp) x.getDate());
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
    public boolean delete(Offrestage x) {
        try{
            String requete = "DELETE * FROM `offrestage` WHERE `ID_OFFRE` = ?";
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

    @Override
    public List<Offrestage> findAll() {
        try{
            List<Offrestage> liste = new ArrayList();
            String requete = "SELECT * FROM `offrestage`";
            PreparedStatement requeteParam = cnx.prepareStatement(requete); 
            ResultSet rs = requeteParam.executeQuery();
            
            while(rs.next()){
                Offrestage o = new Offrestage();
                o.setIdOffre(rs.getString("ID_OFFRE"));
                o.setTitre(rs.getString("TITRE"));
                o.setDescription(rs.getString("DESCRIPTION"));
                o.setLienWeb(rs.getString("LIEN_WEB"));                
                o.setLienDocument(rs.getString("LIEN_DOCUMENT"));
                o.setDate(rs.getTimestamp("DATE"));
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
