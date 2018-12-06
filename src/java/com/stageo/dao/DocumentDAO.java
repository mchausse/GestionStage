/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stageo.dao;

import com.stageo.beans.Document;
import com.stageo.singleton.Connexion;
import java.sql.Connection;
import java.sql.Date;
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
 * @author Max
 */
public class DocumentDAO extends Dao<Document>{
    public DocumentDAO(){
        super(Connexion.getInstance());
    }
    public DocumentDAO(Connection cnx) {
        super(cnx);
    }

    @Override
    public boolean create(Document x) {
        try{
            String requete = "INSERT INTO `document` (`ID_DOCUMENT`,`TITRE`,`FICHIER`,`LIEN`,`TYPE`, `NB_VUES`, `ID_COORDONNATEUR`, `DATE`) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement requeteParam = cnx.prepareStatement(requete); 
            
            requeteParam.setString(1, x.getIdDocument());
            requeteParam.setString(2, x.getTitre());
            requeteParam.setBinaryStream(3, x.getFichier());
            requeteParam.setString(4, x.getLien());
            requeteParam.setString(5, x.getType());
            requeteParam.setInt(6, x.getNbVues());
            requeteParam.setString(7, x.getIdCoordonnateur());
            requeteParam.setDate(8, (Date) x.getDate());
            requeteParam.executeUpdate();
            return true;
        }
        catch(SQLException e){
             Logger.getLogger(DocumentDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return  false;
    }

    @Override
    public Document findById(String id) {
        try{
            String requete = "SELECT * FROM `document` WHERE `ID_DOCUMENT` = ?";
            PreparedStatement requeteParam = cnx.prepareStatement(requete); 
            
            requeteParam.setString(1, id);
            ResultSet rs = requeteParam.executeQuery();
            if(rs.next()){
                Document d = new Document();
                d.setIdDocument(rs.getString("ID_DOCUMENT"));
                d.setTitre(rs.getString("TITRE"));
                d.setFichier(rs.getBinaryStream("FICHIER"));
                d.setLien(rs.getString("LIEN"));
                d.setType(rs.getString("TYPE"));                
                d.setNbVues(rs.getInt("NB_VUES"));
                d.setIdCoordonnateur(rs.getString("ID_COORDONNATEUR"));
                d.setDate(rs.getDate("DATE"));
                return d;
            }
            return null;
        }
        catch(SQLException e){
             Logger.getLogger(DocumentDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    @Override
    public Document find(Document o) {
        try{
            String requete = "SELECT * FROM `document` WHERE `ID_DOCUMENT` = ?";
            PreparedStatement requeteParam = cnx.prepareStatement(requete); 
            
            requeteParam.setString(1, o.getIdDocument());
            ResultSet rs = requeteParam.executeQuery();
            if(rs.next()){
                Document d = new Document();
                d.setIdDocument(rs.getString("ID_DOCUMENT"));
                d.setTitre(rs.getString("TITRE"));
                d.setFichier(rs.getBinaryStream("FICHIER"));
                d.setLien(rs.getString("LIEN"));
                d.setType(rs.getString("TYPE"));                
                d.setNbVues(rs.getInt("NB_VUES"));
                d.setIdCoordonnateur(rs.getString("ID_COORDONNATEUR"));
                d.setDate(rs.getTimestamp("DATE"));
                return d;
            }
            return null;
        }
        catch(SQLException e){
             Logger.getLogger(DocumentDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    @Override
    public boolean update(Document x) {
        try{
            String requete = "UPDATE `document` SET `TITRE` = ?, `FICHIER` = ?,`LIEN` = ?, `TYPE` = ?, `NB_VUES` = ?, `ID_COORDONNATEUR` = ?, `DATE` = ? "
            + "WHERE `document`.`ID_DOCUMENT` = ?";
            PreparedStatement requeteParam = cnx.prepareStatement(requete);
            
            requeteParam.setString(1, x.getTitre());
            requeteParam.setBinaryStream(2, x.getFichier());
            requeteParam.setString(3, x.getLien());
            requeteParam.setString(4, x.getType());
            requeteParam.setInt(5, x.getNbVues());
            requeteParam.setString(6, x.getIdCoordonnateur());
            requeteParam.setDate(7, (Date) x.getDate());
            requeteParam.setString(8, x.getIdDocument());
            
            requeteParam.executeUpdate();
            return true;
        }
        catch(SQLException e){
            Logger.getLogger(DocumentDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
    public boolean updateNbVue(Document x) {
        try{
            String requete = "UPDATE `document` SET `NB_VUES` = ? WHERE `document`.`ID_DOCUMENT` = ?";
            PreparedStatement requeteParam = cnx.prepareStatement(requete);
            
            requeteParam.setInt(1, x.getNbVues());
            requeteParam.setString(2, x.getIdDocument());
            
            requeteParam.executeUpdate();
            return true;
        }
        catch(SQLException e){
            Logger.getLogger(DocumentDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    @Override
    public boolean delete(Document x) {
        try{
            String requete = "DELETE FROM `document` WHERE `ID_DOCUMENT` = ?";
            PreparedStatement requeteParam = cnx.prepareStatement(requete); 
            
            requeteParam.setString(1, x.getIdDocument());
            requeteParam.executeUpdate();
            return true;
        }
        catch(SQLException e){
             Logger.getLogger(DocumentDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    @Override
    public List<Document> findAll() {
        try{
            List<Document> liste = new ArrayList();
            String requete = "SELECT * FROM `document`";
            PreparedStatement requeteParam = cnx.prepareStatement(requete); 
            ResultSet rs = requeteParam.executeQuery();

            while (rs.next()){
                Document d = new Document();
                d.setIdDocument(rs.getString("ID_DOCUMENT"));
                d.setTitre(rs.getString("TITRE"));
                d.setFichier(rs.getBinaryStream("FICHIER"));
                d.setLien(rs.getString("LIEN"));
                d.setType(rs.getString("TYPE"));                
                d.setNbVues(rs.getInt("NB_VUES"));
                d.setIdCoordonnateur(rs.getString("ID_COORDONNATEUR"));
                d.setDate(rs.getDate("DATE"));
                liste.add(d);
            }
            return liste;
        }
        catch(SQLException e){
             Logger.getLogger(DocumentDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
    public List<Document> findAllByTypeUser(String type) {
        try{
            List<Document> liste = new ArrayList();
            if(type.equals("Coordonnateur")){return findAll();}
            String requete = "SELECT * FROM `document` WHERE `TYPE` = ? OR `TYPE` = ?";
            PreparedStatement requeteParam = cnx.prepareStatement(requete); 
            requeteParam.setString(1, type.toUpperCase());
            requeteParam.setString(2, "PUBLIC");
            ResultSet rs = requeteParam.executeQuery();

            while (rs.next()){
                Document d = new Document();
                d.setIdDocument(rs.getString("ID_DOCUMENT"));
                d.setTitre(rs.getString("TITRE"));
                d.setFichier(rs.getBinaryStream("FICHIER"));
                d.setLien(rs.getString("LIEN"));
                d.setType(rs.getString("TYPE"));                
                d.setNbVues(rs.getInt("NB_VUES"));
                d.setIdCoordonnateur(rs.getString("ID_COORDONNATEUR"));
                d.setDate(rs.getDate("DATE"));
                liste.add(d);
            }
            return liste;
        }
        catch(SQLException e){
             Logger.getLogger(DocumentDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
    
}
