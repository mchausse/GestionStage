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
            String requete = "INSERT INTO `offrestage` (`ID_OFFRE`,`TITRE`,`DESCRIPTION`,`DATE_DEBUT` ,`DATE_FIN` ,`DUREE_EN_JOURS` ,`REMUNERE` ,`LIEN_WEB`, `LIEN_DOCUMENT`, `DATE`, `NB_VUES`, `ACTIVE`, `ID_EMPLOYEUR`, `FICHIER`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement requeteParam = cnx.prepareStatement(requete); 
            
            requeteParam.setString(1, x.getIdOffre());
            requeteParam.setString(2, x.getTitre());
            requeteParam.setString(3, x.getDescription());
            requeteParam.setDate(4, new java.sql.Date(x.getDateDebut().getTime()));
            requeteParam.setDate(5, new java.sql.Date(x.getDateFin().getTime()));
            requeteParam.setInt(6, x.getDureeEnJours());
            requeteParam.setInt(7, (x.getRemunere())?1:0);
            requeteParam.setString(8, x.getLienWeb());
            requeteParam.setBinaryStream(9, x.getLienDocument());
            requeteParam.setDate(10, new java.sql.Date(x.getDate().getTime()));
            requeteParam.setInt(11, x.getNbVues());
            requeteParam.setInt(12, (x.getActive())?1:0);
            requeteParam.setString(13, x.getIdEmployeur());
            requeteParam.setBinaryStream(14, x.getLienDocument());
            requeteParam.executeUpdate();
            return true;
        }
        catch(SQLException e){
             Logger.getLogger(OffreStageDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
    public String createTest(OffreStage x) {
        try{
            String requete = "INSERT INTO `offrestage` (`ID_OFFRE`,`TITRE`,`DESCRIPTION`,`DATE_DEBUT` ,`DATE_FIN` ,`DUREE_EN_JOURS` ,`REMUNERE` ,`LIEN_WEB`, `LIEN_DOCUMENT`, `DATE`, `NB_VUES`, `ACTIVE`, `ID_EMPLOYEUR`, `FICHIER`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement requeteParam = cnx.prepareStatement(requete); 
            
            requeteParam.setString(1, x.getIdOffre());
            requeteParam.setString(2, x.getTitre());
            requeteParam.setString(3, x.getDescription());
            requeteParam.setDate(4, new java.sql.Date(x.getDateDebut().getTime()));
            requeteParam.setDate(5, new java.sql.Date(x.getDateFin().getTime()));
            requeteParam.setInt(6, x.getDureeEnJours());
            requeteParam.setInt(7, (x.getRemunere())?1:0);
            requeteParam.setString(8, x.getLienWeb());
            requeteParam.setString(9, "");
            requeteParam.setDate(10, new java.sql.Date(x.getDate().getTime()));
            requeteParam.setInt(11, x.getNbVues());
            requeteParam.setInt(12, (x.getActive())?1:0);
            requeteParam.setString(13, x.getIdEmployeur());
            requeteParam.setBinaryStream(14, x.getLienDocument());
            requeteParam.executeUpdate();
            return "oui";
        }
        catch(SQLException e){
             Logger.getLogger(OffreStageDAO.class.getName()).log(Level.SEVERE, null, e);
             return ""+e;
        }
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
                o.setDateDebut(rs.getDate("DATE_DEBUT")); 
                o.setDateFin(rs.getDate("DATE_FIN")); 
                o.setDureeEnJours(rs.getInt("DUREE_EN_JOURS")); 
                o.setRemunere(rs.getInt("REMUNERE")==1); 
                o.setLienWeb(rs.getString("LIEN_WEB"));                
                o.setLienDocument(rs.getBinaryStream("FICHIER"));
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
                o.setDateDebut(rs.getDate("DATE_DEBUT")); 
                o.setDateFin(rs.getDate("DATE_FIN")); 
                o.setDureeEnJours(rs.getInt("DUREE_EN_JOURS")); 
                o.setRemunere(rs.getInt("REMUNERE")==1);
                o.setLienWeb(rs.getString("LIEN_WEB"));                
                o.setLienDocument(rs.getBinaryStream("FICHIER"));
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
            String requete = "UPDATE `offrestage` SET `ID_OFFRE` = ?, `TITRE` = ?, "
                    + "`DESCRIPTION` = ?, `DATE_DEBUT` = ?, `DATE_FIN` = "
                    + "?, `DUREE_EN_JOURS` = ?, `REMUNERE` = ?, `LIEN_WEB` = ?, "
                    + "`LIEN_DOCUMENT` = ?, `DATE` = ?, `NB_VUES` = ?, `ACTIVE` = ?, "
                    + "`ID_EMPLOYEUR` = ? WHERE `offrestage`.`ID_OFFRE` = ?";
            PreparedStatement requeteParam = cnx.prepareStatement(requete);
            
            requeteParam.setString(1, x.getIdOffre());
            requeteParam.setString(2, x.getTitre());
            requeteParam.setString(3, x.getDescription());
            requeteParam.setDate(4, new java.sql.Date(x.getDateDebut().getTime()));
            requeteParam.setDate(5, new java.sql.Date(x.getDateFin().getTime()));
            requeteParam.setInt(6, x.getDureeEnJours());
            requeteParam.setInt(7, (x.getRemunere())?1:0);
            requeteParam.setString(8, x.getLienWeb());
            requeteParam.setBinaryStream(9, x.getLienDocument());
            requeteParam.setDate(10, new java.sql.Date(x.getDate().getTime()));
            requeteParam.setInt(11, x.getNbVues());
            requeteParam.setInt(12, (x.getActive())?1:0);
            requeteParam.setString(13, x.getIdEmployeur());
            requeteParam.setString(14, x.getIdOffre());
            
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
                o.setDateDebut(rs.getDate("DATE_DEBUT")); 
                o.setDateFin(rs.getDate("DATE_FIN")); 
                o.setDureeEnJours(rs.getInt("DUREE_EN_JOURS")); 
                o.setRemunere(rs.getInt("REMUNERE")==1);
                o.setLienWeb(rs.getString("LIEN_WEB"));                
                o.setLienDocument(rs.getBinaryStream("FICHIER"));
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
                o.setDateDebut(rs.getDate("DATE_DEBUT")); 
                o.setDateFin(rs.getDate("DATE_FIN")); 
                o.setDureeEnJours(rs.getInt("DUREE_EN_JOURS")); 
                o.setRemunere(rs.getInt("REMUNERE")==1);
                o.setLienWeb(rs.getString("LIEN_WEB"));                
                o.setLienDocument(rs.getBinaryStream("FICHIER"));
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
