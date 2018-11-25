/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stageo.dao;

import com.stageo.beans.Adresse;
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
public class AdresseDAO extends Dao<Adresse>{
    public AdresseDAO(){
        super(Connexion.getInstance());
    } 
    
    public AdresseDAO(Connection c) {
        super(c);
    }
    
    @Override
    public Adresse find(Adresse o) {
        try{
            String requete = "SELECT * FROM Adresse WHERE ID_Adresse=?";
            PreparedStatement requeteParam = cnx.prepareStatement(requete);
            requeteParam.setString(1, o.getIdAdresse());
            ResultSet rs = requeteParam.executeQuery();
            
            if(rs.next()){
                Adresse temp = new Adresse();
                temp.setIdAdresse(rs.getString("ID_Adresse"));
                temp.setNumeroCivique(rs.getString("NUMERO_CIVIQUE"));
                temp.setRue(rs.getString("RUE"));
                temp.setBureau(rs.getString("BUREAU"));
                temp.setVille(rs.getString("VILLE"));
                temp.setCodePostal(rs.getString("CODE_POSTAL"));
                temp.setProvince(rs.getString("PROVINCE"));
                temp.setPays(rs.getString("PAYS"));
                temp.setTel(rs.getString("TEL"));
                return temp;
            }
            return null;
        }catch(SQLException e){return new Adresse(""+e);} //Pour voir l'erreur
    }

    @Override
    public Adresse findById(String id) {
        try{
            String requete = "SELECT * FROM Adresse WHERE ID_Adresse=?";
            PreparedStatement requeteParam = cnx.prepareStatement(requete);
            requeteParam.setString(1, id);
            ResultSet rs = requeteParam.executeQuery();
            
            if(rs.next()){
                Adresse temp = new Adresse();
                temp.setIdAdresse(rs.getString("ID_Adresse"));
                temp.setNumeroCivique(rs.getString("NUMERO_CIVIQUE"));
                temp.setRue(rs.getString("RUE"));
                temp.setBureau(rs.getString("BUREAU"));
                temp.setVille(rs.getString("VILLE"));
                temp.setCodePostal(rs.getString("CODE_POSTAL"));
                temp.setProvince(rs.getString("PROVINCE"));
                temp.setPays(rs.getString("PAYS"));
                temp.setTel(rs.getString("TEL"));
                return temp;
            }
            return null;
        }catch(SQLException e){return new Adresse(""+e);} //Pour voir l'erreur
    }
    @Override
    public boolean create(Adresse o) {
        if(this.findById(o.getIdAdresse())==null){ //Si l'utilisateur n'existe pas
            try{
                String requete = "INSERT INTO `adresse` "
                        + "(`ID_ADRESSE`, `NUMERO_CIVIQUE`, `RUE`, `BUREAU`, `VILLE`, `CODE_POSTAL`, `PROVINCE`, `PAYS`, `TEL`) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement requeteParam = cnx.prepareStatement(requete);

                requeteParam.setString(1, o.getIdAdresse());
                requeteParam.setString(2, o.getNumeroCivique());
                requeteParam.setString(3, o.getRue());
                requeteParam.setString(4, o.getBureau());
                requeteParam.setString(5, o.getVille());
                requeteParam.setString(6, o.getCodePostal());
                requeteParam.setString(7, o.getProvince());
                requeteParam.setString(8, o.getPays());
                requeteParam.setString(9, o.getTel());
                requeteParam.executeUpdate();
                return true;
            }catch(SQLException e){return false;}
        }
        return false;
    }

    @Override
    public boolean update(Adresse o) {
        try{
            String requete = "UPDATE `adresse` "
                    + "SET `ID_ADRESSE` = ?, `NUMERO_CIVIQUE` = ?, "
                    + "`RUE` = ?, `BUREAU` = ?, `VILLE` = ?, "
                    + "`CODE_POSTAL` = ?, `PROVINCE` = ?, "
                    + "`PAYS` = ?, `TEL` = ? "
                    + "WHERE `adresse`.`ID_ADRESSE` = ?";
            PreparedStatement requeteParam = cnx.prepareStatement(requete);

            requeteParam.setString(1, o.getIdAdresse());
            requeteParam.setString(2, o.getNumeroCivique());
            requeteParam.setString(3, o.getRue());
            requeteParam.setString(4, o.getBureau());
            requeteParam.setString(5, o.getVille());
            requeteParam.setString(6, o.getCodePostal());
            requeteParam.setString(7, o.getProvince());
            requeteParam.setString(8, o.getPays());
            requeteParam.setString(9, o.getTel());
            requeteParam.setString(10, o.getIdAdresse());
            requeteParam.executeUpdate();
            return true;
        }catch(SQLException e){return false;}
    }

    @Override
    public boolean delete(Adresse o) {
        try{
            String requete = "DELETE FROM `Adresse` WHERE `Adresse`.`ID_Adresse` = ?";
            PreparedStatement requeteParam = cnx.prepareStatement(requete);
            
            requeteParam.setString(1, o.getIdAdresse());
            requeteParam.executeUpdate();
            return true;
        }catch(SQLException e){return false;}
    }

    @Override
    public List<Adresse> findAll() {
        try{
            List<Adresse> liste = new ArrayList();
            String requete = "SELECT * FROM `Adresse`";
            PreparedStatement requeteParam = cnx.prepareStatement(requete);
            
            ResultSet rs = requeteParam.executeQuery();
            while (rs.next()){
                Adresse temp = new Adresse();
                temp.setIdAdresse(rs.getString("ID_Adresse"));
                temp.setNumeroCivique(rs.getString("NUMERO_CIVIQUE"));
                temp.setRue(rs.getString("RUE"));
                temp.setBureau(rs.getString("BUREAU"));
                temp.setVille(rs.getString("VILLE"));
                temp.setCodePostal(rs.getString("CODE_POSTAL"));
                temp.setProvince(rs.getString("PROVINCE"));
                temp.setPays(rs.getString("PAYS"));
                temp.setTel(rs.getString("TEL"));

                liste.add(temp);
            }
            return liste;
        }catch(SQLException e){return null;}
    }
}