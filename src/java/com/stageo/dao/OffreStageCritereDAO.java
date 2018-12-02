/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stageo.dao;


import com.stageo.beans.Offrestagecritere;
import com.stageo.beans.OffrestagecriterePK;
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
 * @author Max
 */
public class OffreStageCritereDAO extends Dao<Offrestagecritere> {
    public OffreStageCritereDAO(){
        super(Connexion.getInstance());
    }
    public OffreStageCritereDAO(Connection cnx) {
        super(cnx);
    }

    @Override
    public boolean create(Offrestagecritere x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Offrestagecritere findById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Offrestagecritere find(Offrestagecritere o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public List<Offrestagecritere> findByIdCritere(String id) {
        try{
            List<Offrestagecritere> liste = new ArrayList();
            String requete = "SELECT * FROM `offrestagecritere` WHERE `ID_CRITERE` = ?";
            PreparedStatement requeteParam = cnx.prepareStatement(requete); 
            
            requeteParam.setString(1, id);
            ResultSet rs = requeteParam.executeQuery();
            while(rs.next()){
                Offrestagecritere o = new Offrestagecritere();
                o.setOffrestagecriterePK(new OffrestagecriterePK(rs.getString("ID_OFFRE"), rs.getString("ID_CRITERE")));
                liste.add(o);
            }
            return liste;
        }
        catch(SQLException e){
             Logger.getLogger(OffreStageCritereDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
    
    public List<Offrestagecritere> findByIdOffre(String id) {
        try{
            List<Offrestagecritere> liste = new ArrayList();
            String requete = "SELECT * FROM `offrestagecritere` WHERE `ID_OFFRE` = ?";
            PreparedStatement requeteParam = cnx.prepareStatement(requete); 
            
            requeteParam.setString(1, id);
            ResultSet rs = requeteParam.executeQuery();
            while(rs.next()){
                Offrestagecritere o = new Offrestagecritere();
                o.setOffrestagecriterePK(new OffrestagecriterePK(rs.getString("ID_OFFRE"), rs.getString("ID_CRITERE")));
                liste.add(o);
            }
            return liste;
        }
        catch(SQLException e){
             Logger.getLogger(OffreStageCritereDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
    @Override
    public boolean update(Offrestagecritere x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Offrestagecritere x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Offrestagecritere> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
