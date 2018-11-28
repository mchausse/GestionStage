/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stageo.dao;

import com.stageo.beans.Candidature;
import com.stageo.beans.CandidaturePK;
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
 * @author Max
 */
public class CandidatureDAO extends Dao<Candidature>{
    public CandidatureDAO(){
        super(Connexion.getInstance());
    }
    public CandidatureDAO(Connection cnx) {
        super(cnx);
    }

    @Override
    public boolean create(Candidature x) {
        try{
            String requete = "INSERT INTO `candidature` (`ID_ETUDIANT`,`ID_OFFRE`,`DATE`,`STATUT`) VALUES (?,?,?,?)";
            PreparedStatement requeteParam = cnx.prepareStatement(requete); 
            
            requeteParam.setString(1, x.getCandidaturePK().getIdEtudiant());
            requeteParam.setString(2, x.getCandidaturePK().getIdOffre());
            requeteParam.setTimestamp(3, (Timestamp) x.getDate());
            requeteParam.setString(4, x.getStatut());
            requeteParam.executeUpdate();
            return true;
        }
        catch(SQLException e){
             Logger.getLogger(CandidatureDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return  false;
    }

    @Override
    public Candidature findById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<Candidature> findByIdEtudiant(String id) {
        try{
            List<Candidature> liste = new ArrayList();
            String requete = "SELECT * FROM `candidature` WHERE `ID_ETUDIANT` = ?";
            PreparedStatement requeteParam = cnx.prepareStatement(requete); 
            
            requeteParam.setString(1, id);
            ResultSet rs = requeteParam.executeQuery();
            while(rs.next()){
                Candidature c = new Candidature();
                c.setCandidaturePK(new CandidaturePK(rs.getString("ID_ETUDIANT"), rs.getString("ID_OFFRE")));
                c.setDate(rs.getTimestamp("DATE"));
                c.setStatut(rs.getString("STATUT"));
                liste.add(c);
            }
            return liste;
        }
        catch(SQLException e){
             Logger.getLogger(CandidatureDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
    
    public List<Candidature> findByIdOffre(String id) {
        try{
            List<Candidature> liste = new ArrayList();
            String requete = "SELECT * FROM `candidature` WHERE `ID_OFFRE` = ?";
            PreparedStatement requeteParam = cnx.prepareStatement(requete); 
            
            requeteParam.setString(1, id);
            ResultSet rs = requeteParam.executeQuery();
            while(rs.next()){
                Candidature c = new Candidature();
                c.setCandidaturePK(new CandidaturePK(rs.getString("ID_ETUDIANT"), rs.getString("ID_OFFRE")));
                c.setDate(rs.getTimestamp("DATE"));
                c.setStatut(rs.getString("STATUT"));
                liste.add(c);
            }
            return liste;
        }
        catch(SQLException e){
             Logger.getLogger(CandidatureDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
    
    @Override
    public Candidature find(Candidature o) {
        try{
            String requete = "SELECT * FROM `candidature` WHERE `ID_ETUDIANT` = ? AND `candidature`.`ID_OFFRE` = ?";
            PreparedStatement requeteParam = cnx.prepareStatement(requete); 
            
            requeteParam.setString(1, o.getCandidaturePK().getIdEtudiant());
            requeteParam.setString(2, o.getCandidaturePK().getIdOffre());
            ResultSet rs = requeteParam.executeQuery();
            if(rs.next()){
                Candidature c = new Candidature();
                c.setCandidaturePK(new CandidaturePK(rs.getString("ID_ETUDIANT"), rs.getString("ID_OFFRE")));
                c.setDate(rs.getTimestamp("DATE"));
                c.setStatut(rs.getString("STATUT"));
                return c;
            }
            return null;
        }
        catch(SQLException e){
             Logger.getLogger(CandidatureDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    @Override
    public boolean update(Candidature x) {
        try{
            String requete = "UPDATE `candidature` SET `DATE` = ?, `STATUT` = ?"
            + "WHERE `candidature`.`ID_ETUDIANT` = ? AND `candidature`.`ID_OFFRE` = ?";
            PreparedStatement requeteParam = cnx.prepareStatement(requete);
            
            requeteParam.setTimestamp(1, (Timestamp) x.getDate());
            requeteParam.setString(2, x.getStatut());
            requeteParam.setString(3, x.getCandidaturePK().getIdEtudiant());
            requeteParam.setString(4, x.getCandidaturePK().getIdOffre());
            
            requeteParam.executeUpdate();
            return true;
        }
        catch(SQLException e){
            Logger.getLogger(CandidatureDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    @Override
    public boolean delete(Candidature o) {
        try{
            String requete = "SELECT * FROM `candidature` WHERE `ID_ETUDIANT` = ? AND `candidature`.`ID_OFFRE` = ?";
            PreparedStatement requeteParam = cnx.prepareStatement(requete); 
            
            requeteParam.setString(1, o.getCandidaturePK().getIdEtudiant());
            requeteParam.setString(2, o.getCandidaturePK().getIdOffre());
            requeteParam.executeUpdate();
            return true;
        }
        catch(SQLException e){
             Logger.getLogger(CandidatureDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    @Override
    public List<Candidature> findAll() {
        try{
            List<Candidature> liste = new ArrayList();
            String requete = "SELECT * FROM `candidature`";
            PreparedStatement requeteParam = cnx.prepareStatement(requete); 
            ResultSet rs = requeteParam.executeQuery();

            while (rs.next()){
                Candidature c = new Candidature();
                c.setCandidaturePK(new CandidaturePK(rs.getString("ID_ETUDIANT"), rs.getString("ID_OFFRE")));
                c.setDate(rs.getTimestamp("DATE"));
                c.setStatut(rs.getString("STATUT"));
                liste.add(c);
            }
            return liste;
        }
        catch(SQLException e){
             Logger.getLogger(CandidatureDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
    
}
