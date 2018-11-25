/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stageo.dao;

import com.stageo.beans.Compagnie;
import com.stageo.singleton.Connexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gabri
 */
public class CompagnieDAO extends Dao<Compagnie>{
    public CompagnieDAO(){super(Connexion.getInstance());}
    
     public CompagnieDAO(Connection c) {
        super(c);
    }
    
    @Override
    public Compagnie find(Compagnie o) {
        try{
            String requete = "SELECT * FROM Compagnie WHERE ID_Compagnie=?";
            PreparedStatement requeteParam = cnx.prepareStatement(requete);
            requeteParam.setString(1, o.getIdCompagnie());
            ResultSet rs = requeteParam.executeQuery();
            
            if(rs.next()){
                Compagnie temp = new Compagnie();
                temp.setIdCompagnie(rs.getString("ID_COMPAGNIE"));
                temp.setNom(rs.getString("NOM"));
                temp.setSiteWeb(rs.getString("SITE_WEB"));
                temp.setIdAdresse(rs.getString("ID_ADRESSE"));
                return temp;
            }
            return null;
        }catch(SQLException e){return new Compagnie(""+e);} //Pour voir l'erreur
    }

    @Override
    public Compagnie findById(String id) {
        try{
            String requete = "SELECT * FROM Compagnie WHERE ID_Compagnie=?";
            PreparedStatement requeteParam = cnx.prepareStatement(requete);
            requeteParam.setString(1, id);
            ResultSet rs = requeteParam.executeQuery();
            
            if(rs.next()){
                Compagnie temp = new Compagnie();
                temp.setIdCompagnie(rs.getString("ID_COMPAGNIE"));
                temp.setNom(rs.getString("NOM"));
                temp.setSiteWeb(rs.getString("SITE_WEB"));
                temp.setIdAdresse(rs.getString("ID_ADRESSE"));
                return temp;
            }
            return null;
        }catch(SQLException e){return new Compagnie(""+e);} //Pour voir l'erreur
    }
    @Override
    public boolean create(Compagnie o) {
        if(this.findById(o.getIdCompagnie())==null){ //Si l'utilisateur n'existe pas
            try{
                String requete = "INSERT INTO `compagnie` (`ID_COMPAGNIE`, `NOM`, `SITE_WEB`, `ID_ADRESSE`) VALUES (?, ?, ?, ?);";
                PreparedStatement requeteParam = cnx.prepareStatement(requete);

                requeteParam.setString(1, o.getIdCompagnie());
                requeteParam.setString(2, o.getNom());
                requeteParam.setString(3, o.getSiteWeb());
                requeteParam.setString(4, o.getIdAdresse());
                requeteParam.executeUpdate();
                return true;
            }catch(SQLException e){return false;}
        }
        return false;
    }

    @Override
    public boolean update(Compagnie o) {
        try{
            String requete = "UPDATE `compagnie` SET `ID_COMPAGNIE` = ?, `NOM` = ?, "
                    + "`SITE_WEB` = ?, `ID_ADRESSE` = ? "
                    + "WHERE `compagnie`.`ID_COMPAGNIE` = ?";
            PreparedStatement requeteParam = cnx.prepareStatement(requete);

            requeteParam.setString(1, o.getIdCompagnie());
            requeteParam.setString(2, o.getNom());
            requeteParam.setString(3, o.getSiteWeb());
            requeteParam.setString(4, o.getIdAdresse());
            requeteParam.setString(5, o.getIdCompagnie());
            requeteParam.executeUpdate();
            return true;
        }catch(SQLException e){return false;}
    }

    @Override
    public boolean delete(Compagnie o) {
        try{
            String requete = "DELETE FROM `Compagnie` WHERE `Compagnie`.`ID_Compagnie` = ?";
            PreparedStatement requeteParam = cnx.prepareStatement(requete);
            
            requeteParam.setString(1, o.getIdCompagnie());
            requeteParam.executeUpdate();
            return true;
        }catch(SQLException e){return false;}
    }

    @Override
    public List<Compagnie> findAll() {
        try{
            List<Compagnie> liste = new ArrayList();
            String requete = "SELECT * FROM `Compagnie`";
            PreparedStatement requeteParam = cnx.prepareStatement(requete);
            
            ResultSet rs = requeteParam.executeQuery();
            while (rs.next()){
                Compagnie temp = new Compagnie();
                temp.setIdCompagnie(rs.getString("ID_COMPAGNIE"));
                temp.setNom(rs.getString("NOM"));
                temp.setSiteWeb(rs.getString("SITE_WEB"));
                temp.setIdAdresse(rs.getString("ID_ADRESSE"));
                liste.add(temp);
            }
            return liste;
        }catch(SQLException e){return null;}
    }
}