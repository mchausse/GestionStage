/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stageo.dao;

import com.stageo.beans.Critere;
import com.stageo.singleton.Connexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Samuel
 */
public class CritereDAO extends Dao<Critere>{
    public CritereDAO(){
        super(Connexion.getInstance());
    } 
    
    public CritereDAO(Connection c) {
        super(c);
    }
    @Override
    public Critere find(Critere o) {
        try{
            String requete = "SELECT * FROM critere WHERE ID_CRITERE=?";
            PreparedStatement requeteParam = cnx.prepareStatement(requete);
            requeteParam.setString(1, o.getIdCritere());
            ResultSet rs = requeteParam.executeQuery();
            
            if(rs.next()){
                Critere temp = new Critere();
                temp.setIdCritere(rs.getString("ID_CRITERE"));
                temp.setNom(rs.getString("NOM"));
                return temp;
            }
            return null;
        }catch(SQLException e){return new Critere(""+e);} //Pour voir l'erreur
    }
    @Override
    public Critere findById(String id) {
        try{
            String requete = "SELECT * FROM critere WHERE ID_CRITERE=?";
            PreparedStatement requeteParam = cnx.prepareStatement(requete);
            requeteParam.setString(1, id);
            ResultSet rs = requeteParam.executeQuery();
            
            if(rs.next()){
                Critere temp = new Critere();
                temp.setIdCritere(rs.getString("ID_CRITERE"));
                temp.setNom(rs.getString("NOM"));
                return temp;
            }
            return null;
        }catch(SQLException e){return new Critere(""+e);} //Pour voir l'erreur
    }
    public Critere findByName(String name) {
        try{
            String requete = "SELECT * FROM `critere` WHERE `NOM`=?";
            PreparedStatement requeteParam = cnx.prepareStatement(requete);
            requeteParam.setString(1, name);
            ResultSet rs = requeteParam.executeQuery();
            
            if(rs.next()){
                Critere temp = new Critere();
                temp.setIdCritere(rs.getString("ID_CRITERE"));
                temp.setNom(rs.getString("NOM"));
                return temp;
            }
            return null;
        }catch(SQLException e){return new Critere(""+e);} //Pour voir l'erreur
    }
    @Override
    public boolean create(Critere o) {
        if(this.findById(o.getIdCritere())==null){ //Si le critere n'existe pas
            try{
                String requete = "INSERT INTO `critere` "
                        + "(`ID_CRITERE`, `NOM`) "
                        + "VALUES (?, ?)";
                PreparedStatement requeteParam = cnx.prepareStatement(requete);

                requeteParam.setString(1, o.getIdCritere());
                requeteParam.setString(2, o.getNom());
                requeteParam.executeUpdate();
                return true;
            }catch(SQLException e){return false;}
        }
        return false;
    }
    @Override
    public boolean update(Critere o) {
        try{
            String requete = "UPDATE `critere` "
                    + "SET `ID_CRITERE` = ?, `NOM` = ?";
            PreparedStatement requeteParam = cnx.prepareStatement(requete);

            requeteParam.setString(1, o.getIdCritere());
            requeteParam.setString(2, o.getNom());
            requeteParam.executeUpdate();
            return true;
        }catch(SQLException e){return false;}
    }
    @Override
    public boolean delete(Critere o) {
        try{
            String requete = "DELETE FROM `critere` WHERE `ID_CRITERE` = ?";
            PreparedStatement requeteParam = cnx.prepareStatement(requete);
            
            requeteParam.setString(1,o.getIdCritere());
            requeteParam.executeUpdate();
            return true;
        }catch(SQLException e){return false;}
    }
    @Override
    public List<Critere> findAll() {
        try{
            List<Critere> liste = new ArrayList();
            String requete = "SELECT * FROM `critere` ORDER BY CRITERE.NOM";
            PreparedStatement requeteParam = cnx.prepareStatement(requete);
            
            ResultSet rs = requeteParam.executeQuery();
            while (rs.next()){
                Critere temp = new Critere();
                temp.setIdCritere(rs.getString("ID_CRITERE"));
                temp.setNom(rs.getString("NOM"));

                liste.add(temp);
            }
            return liste;
        }catch(SQLException e){return null;}
    }
     public List<Critere> findAllById(String id) {
        try{
            List<Critere> liste = new ArrayList();
            String requete = "SELECT * FROM `critere`WHERE ID_CRITERE=?";
            PreparedStatement requeteParam = cnx.prepareStatement(requete);
            requeteParam.setString(1,id);
            ResultSet rs = requeteParam.executeQuery();
            while (rs.next()){
                Critere temp = new Critere();
                temp.setIdCritere(rs.getString("ID_CRITERE"));
                temp.setNom(rs.getString("NOM"));

                liste.add(temp);
            }
            return liste;
        }catch(SQLException e){return null;}
    }
}
