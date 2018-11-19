/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stageo.dao;

import com.stageo.beans.Employeur;
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
public class EmployeurDAO extends Dao<Employeur>{
     public EmployeurDAO(Connection c) {
        super(c);
    }
    
    @Override
    public Employeur find(Employeur o) {
        try{
            String requete = "SELECT * FROM Employeur WHERE ID_Employeur=?";
            PreparedStatement requeteParam = cnx.prepareStatement(requete);
            requeteParam.setString(1, o.getIdEmployeur());
            ResultSet rs = requeteParam.executeQuery();
            
            if(rs.next()){
                Employeur temp = new Employeur();
                temp.setIdEmployeur(rs.getString("ID_EMPLOYEUR"));
                temp.setTel(rs.getString("TEL"));
                temp.setIdCompagnie(rs.getString("ID_COMPAGNIE"));
                return temp;
            }
            return null;
        }catch(SQLException e){return new Employeur(""+e);} //Pour voir l'erreur
    }

    @Override
    public Employeur findById(String id) {
        try{
            String requete = "SELECT * FROM Employeur WHERE ID_EMPLOYEUR=?";
            PreparedStatement requeteParam = cnx.prepareStatement(requete);
            requeteParam.setString(1, id);
            ResultSet rs = requeteParam.executeQuery();
            
            if(rs.next()){
                Employeur temp = new Employeur();
                temp.setIdEmployeur(rs.getString("ID_EMPLOYEUR"));
                temp.setTel(rs.getString("TEL"));
                temp.setIdCompagnie(rs.getString("ID_COMPAGNIE"));
                return temp;
            }
            return null;
        }catch(SQLException e){return new Employeur(""+e);} //Pour voir l'erreur
    }
    @Override
    public boolean create(Employeur o) {
        if(this.findById(o.getIdEmployeur())==null){ //Si l'utilisateur n'existe pas
            try{
                String requete = "INSERT INTO `employeur`(`ID_EMPLOYEUR`, `TEL`, `ID_COMPAGNIE`) VALUES (?,?,?)";
                PreparedStatement requeteParam = cnx.prepareStatement(requete);

                requeteParam.setString(1, o.getIdEmployeur());
                requeteParam.setString(2, o.getTel());
                requeteParam.setString(3, o.getIdCompagnie());
                requeteParam.executeUpdate();
                return true;
            }catch(SQLException e){return false;}
        }
        return false;
    }

    @Override
    public boolean update(Employeur o) {
        try{
            String requete = "UPDATE `employeur` SET `ID_EMPLOYEUR` = ?, `TEL` = ?, `ID_COMPAGNIE` = ? WHERE `employeur`.`ID_EMPLOYEUR` = ?";
            PreparedStatement requeteParam = cnx.prepareStatement(requete);

            requeteParam.setString(1, o.getIdEmployeur());
            requeteParam.setString(2, o.getTel());
            requeteParam.setString(3, o.getIdCompagnie());
            requeteParam.setString(4, o.getIdEmployeur());

            requeteParam.executeUpdate();
            return true;
        }catch(SQLException e){return false;}
    }

    @Override
    public boolean delete(Employeur o) {
        try{
            String requete = "DELETE FROM `Employeur` WHERE `Employeur`.`ID_Employeur` = ?";
            PreparedStatement requeteParam = cnx.prepareStatement(requete);
            
            requeteParam.setString(1, o.getIdEmployeur());
            requeteParam.executeUpdate();
            return true;
        }catch(SQLException e){return false;}
    }

    @Override
    public List<Employeur> findAll() {
        try{
            List<Employeur> liste = new ArrayList();
            String requete = "SELECT * FROM `Employeur`";
            PreparedStatement requeteParam = cnx.prepareStatement(requete);
            
            ResultSet rs = requeteParam.executeQuery();
            while (rs.next()){
                Employeur temp = new Employeur();
                temp.setIdEmployeur(rs.getString("ID_Employeur"));
                temp.setTel(rs.getString("TEL"));
                temp.setIdCompagnie(rs.getString("ID_COMPAGNIE"));
                liste.add(temp);
            }
            return liste;
        }catch(SQLException e){return null;}
    }
}