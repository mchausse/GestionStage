/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stageo.dao;

import com.stageo.beans.Coordonnateur;
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
public class CoordonnateurDAO extends Dao<Coordonnateur>{

    public CoordonnateurDAO(Connection cnx) {
        super(cnx);
    }

    @Override
    public boolean create(Coordonnateur o) {
        try{
            String requete = "INSERT INTO `coordonnateur` (`ID_COORDONNATEUR`) VALUES (?)";
            PreparedStatement requeteParam = cnx.prepareStatement(requete); 
            
            requeteParam.setString(1, o.getIdCoordonnateur());
            requeteParam.executeUpdate();
            return true;
        }
        catch(SQLException e){
             Logger.getLogger(CoordonnateurDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return  false;
    }

    @Override
    public Coordonnateur findById(String id) {
        try{
            String requete = "SELECT * FROM `coordonnateur` WHERE `ID_COORDONNATEUR` = ?";
            PreparedStatement requeteParam = cnx.prepareStatement(requete); 
            
            requeteParam.setString(1, id);
            System.out.println(requeteParam);
            ResultSet rs = requeteParam.executeQuery();
            if(rs.next()){
                Coordonnateur c = new Coordonnateur();
                c.setIdCoordonnateur(rs.getString("ID_COORDONNATEUR"));
                return c;
            }
            return null;
        }
        catch(SQLException e){
             Logger.getLogger(CoordonnateurDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    @Override
    public Coordonnateur find(Coordonnateur o) {
        try{
            String requete = "SELECT * FROM `coordonnateur` WHERE `ID_COORDONNATEUR` = ?";
            PreparedStatement requeteParam = cnx.prepareStatement(requete); 
            
            requeteParam.setString(1, o.getIdCoordonnateur());
            ResultSet rs = requeteParam.executeQuery();
            if(rs.next()){
                Coordonnateur c = new Coordonnateur();
                c.setIdCoordonnateur(rs.getString("ID_COORDONNATEUR"));
                return c;
            }
            return null;
        }
        catch(SQLException e){
             Logger.getLogger(CoordonnateurDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    @Override
    public boolean update(Coordonnateur x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Coordonnateur x) {
        try{
            String requete = "DELETE * FROM `coordonnateur` WHERE `ID_COORDINNATEUR` = ?";
            PreparedStatement requeteParam = cnx.prepareStatement(requete); 
            
            requeteParam.setString(1, x.getIdCoordonnateur());
            requeteParam.executeUpdate();
            return true;
        }
        catch(SQLException e){
             Logger.getLogger(CoordonnateurDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return  false;
    }

    @Override
    public List<Coordonnateur> findAll() {
        try{
            List<Coordonnateur> liste = new ArrayList();
             String requete = "SELECT * FROM `coordonnateur`";
             PreparedStatement requeteParam = cnx.prepareStatement(requete); 
             ResultSet rs = requeteParam.executeQuery();
             
             while (rs.next()){
                 Coordonnateur c = new Coordonnateur();
                 c.setIdCoordonnateur(rs.getString("ID_COORDONNATEUR"));
                 liste.add(c);
             }
             return liste;
         }
         catch(SQLException e){
              Logger.getLogger(CoordonnateurDAO.class.getName()).log(Level.SEVERE, null, e);
         }
         return null;
    }
    
}
