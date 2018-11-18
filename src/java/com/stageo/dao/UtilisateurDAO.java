/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stageo.dao;

import com.stageo.beans.Utilisateur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabri
 */
public class UtilisateurDAO extends Dao<Utilisateur>{
     public UtilisateurDAO(Connection c) {
        super(c);
    }
    
    @Override
    public Utilisateur find(Utilisateur o) {
        try{
            String requete = "SELECT * FROM utilisateur WHERE ID=?";
            PreparedStatement requeteParam = cnx.prepareStatement(requete);
            requeteParam.setString(1, o.getIdUtilisateur());
            ResultSet rs = requeteParam.executeQuery();
            
            if(rs.next()){
                Utilisateur temp = new Utilisateur();
                temp.setIdUtilisateur(rs.getString("ID_UTILISATEUR"));
                temp.setCourriel(rs.getString("COURRIEL"));
                temp.setNom(rs.getString("NOM"));
                temp.setPrenom(rs.getString("PRENOM"));
                temp.setTypeUtilisateur("TYPE_UTILISATEUR");
                return temp;
            }
            return null;
        }catch(SQLException e){return new Utilisateur(""+e);} //Pour voir l'erreur
    }

    @Override
    public Utilisateur findById(String id) {
        try{
            String requete = "SELECT * FROM utilisateur WHERE ID_UTILISATEUR=?";
            PreparedStatement requeteParam = cnx.prepareStatement(requete);
            requeteParam.setString(1, id);
            ResultSet rs = requeteParam.executeQuery();
            
            if(rs.next()){
                Utilisateur temp = new Utilisateur();
                temp.setIdUtilisateur(rs.getString("ID_UTILISATEUR"));
                temp.setCourriel(rs.getString("COURRIEL"));
                temp.setNom(rs.getString("NOM"));
                temp.setPrenom(rs.getString("PRENOM"));
                temp.setTypeUtilisateur("TYPE_UTILISATEUR");
                return temp;
            }
            return null;
        }catch(SQLException e){return new Utilisateur(""+e);} //Pour voir l'erreur
    }
    
    @Override
    public boolean create(Utilisateur o) {
        try{
            String requete = "INSERT INTO utilisateur (ID_UTILISATEUR, COURRIEL, MOT_DE_PASSE, NOM, PRENOM, TYPE_UTILISATEUR) " +
                                "VALUES (?, ?, ?, ?, ?, ?);";
            PreparedStatement requeteParam = cnx.prepareStatement(requete);
            
            requeteParam.setString(1, o.getIdUtilisateur());
            requeteParam.setString(2, o.getCourriel());
            requeteParam.setString(3, o.getMotDePasse());
            requeteParam.setString(4, o.getNom());
            requeteParam.setString(5, o.getPrenom());
            requeteParam.setString(6, o.getTypeUtilisateur());
            
            requeteParam.executeUpdate();
            return true;
        }catch(SQLException e){return false;}
    }

    @Override
    public boolean update(Utilisateur o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Utilisateur o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Utilisateur> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
