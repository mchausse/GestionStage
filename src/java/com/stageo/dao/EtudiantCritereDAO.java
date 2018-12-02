/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stageo.dao;

import com.stageo.beans.Etudiantcritere;
import com.stageo.beans.EtudiantcriterePK;
import com.stageo.singleton.Connexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EtudiantCritereDAO extends Dao<EtudiantcriterePK>{
    public EtudiantCritereDAO(){
        super(Connexion.getInstance());
    } 
    
    public EtudiantCritereDAO(Connection c) {
        super(c);
    }
    
    @Override
    public EtudiantcriterePK find(EtudiantcriterePK o) {
        try{
            String requete = "SELECT * FROM etudiantcritere WHERE ID_ETUDIANT=? AND ID_CRITERE=?";
            PreparedStatement requeteParam = cnx.prepareStatement(requete);
            requeteParam.setString(1, o.getIdEtudiant());
            requeteParam.setString(2, o.getIdCritere());
            ResultSet rs = requeteParam.executeQuery();
            
            if(rs.next()){
                EtudiantcriterePK temp = new EtudiantcriterePK();
                temp.setIdEtudiant(rs.getString("ID_ETUDIANT"));
                temp.setIdCritere(rs.getString("ID_CRITERE"));
                return temp;
            }
            return null;
        }catch(SQLException e){return null;}
    }
    @Override
    public EtudiantcriterePK findById(String id) {
        return null;
    }
    //-----------------
    public List<Etudiantcritere> findByIdCritere(String id) {
        try{
            List<Etudiantcritere> liste = new ArrayList();
            String requete = "SELECT * FROM `etudiantcritere` WHERE `ID_CRITERE` = ?";
            PreparedStatement requeteParam = cnx.prepareStatement(requete); 
            
            requeteParam.setString(1, id);
            ResultSet rs = requeteParam.executeQuery();
            while(rs.next()){
                Etudiantcritere e = new Etudiantcritere();
                e.setEtudiantcriterePK(new EtudiantcriterePK(rs.getString("ID_ETUDIANT"), rs.getString("ID_CRITERE")));
                liste.add(e);
            }
            return liste;
        }
        catch(SQLException e){
             Logger.getLogger(EtudiantCritereDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
    
    public List<Etudiantcritere> findByIdEtudiant(String id) {
         try{
            List<Etudiantcritere> liste = new ArrayList();
            String requete = "SELECT * FROM `etudiantcritere` WHERE `ID_ETUDIANT` = ?";
            PreparedStatement requeteParam = cnx.prepareStatement(requete); 
            
            requeteParam.setString(1, id);
            ResultSet rs = requeteParam.executeQuery();
            while(rs.next()){
                Etudiantcritere e = new Etudiantcritere();
                e.setEtudiantcriterePK(new EtudiantcriterePK(rs.getString("ID_ETUDIANT"), rs.getString("ID_CRITERE")));
                liste.add(e);
            }
            return liste;
        }
        catch(SQLException e){
             Logger.getLogger(EtudiantCritereDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
    //-----------------
    @Override
    public boolean create(EtudiantcriterePK o) {
        if(this.find(o)==null){ //Si le critere n'existe pas
            try{
                String requete = "INSERT INTO `etudiantcritere`"
                        + "(`ID_ETUDIANT`, `ID_CRITERE`) "
                        + "VALUES (?, ?)";
                PreparedStatement requeteParam = cnx.prepareStatement(requete);

                requeteParam.setString(1, o.getIdEtudiant());
                requeteParam.setString(2, o.getIdCritere());
                requeteParam.executeUpdate();
                return true;
            }catch(SQLException e){return false;}
        }
        return false;
    }
    @Override
    public boolean update(EtudiantcriterePK o) {
        return false;
    }
    @Override
    public boolean delete(EtudiantcriterePK o) {
        try{
            String requete = "DELETE FROM etudiantcritere WHERE ID_ETUDIANT=? AND ID_CRITERE=?";
            PreparedStatement requeteParam = cnx.prepareStatement(requete);
            
            requeteParam.setString(1,o.getIdEtudiant());
            requeteParam.setString(2,o.getIdCritere());
            requeteParam.executeUpdate();
            return true;
        }catch(SQLException e){return false;}
    }
    @Override
    public List<EtudiantcriterePK> findAll() {
        try{
            List<EtudiantcriterePK> liste = new ArrayList();
            String requete = "SELECT * FROM `etudiantcritere`";
            PreparedStatement requeteParam = cnx.prepareStatement(requete);
            
            ResultSet rs = requeteParam.executeQuery();
            while (rs.next()){
                EtudiantcriterePK temp = new EtudiantcriterePK();
                temp.setIdEtudiant(rs.getString("ID_ETUDIANT"));
                temp.setIdCritere(rs.getString("ID_CRITERE"));

                liste.add(temp);
            }
            return liste;
        }catch(SQLException e){return null;}
    }
    public List<EtudiantcriterePK> findAllByIdEtudiant(String id) {
        try{
            List<EtudiantcriterePK> liste = new ArrayList();
            String requete = "SELECT * FROM `etudiantcritere` WHERE ID_ETUDIANT=?";
            PreparedStatement requeteParam = cnx.prepareStatement(requete);
            requeteParam.setString(1,id);
            ResultSet rs = requeteParam.executeQuery();
            while (rs.next()){
                EtudiantcriterePK temp = new EtudiantcriterePK();
                temp.setIdEtudiant(rs.getString("ID_ETUDIANT"));
                temp.setIdCritere(rs.getString("ID_CRITERE"));

                liste.add(temp);
            }
            return liste;
        }catch(SQLException e){return null;}
    }
}
