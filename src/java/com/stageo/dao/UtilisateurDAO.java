/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stageo.dao;

import com.stageo.beans.Utilisateur;
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
public class UtilisateurDAO extends Dao<Utilisateur>{
    public UtilisateurDAO(){super(Connexion.getInstance());}
    
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
                temp.setTypeUtilisateur(rs.getString("TYPE_UTILISATEUR"));
                temp.setMotDePasse(rs.getString("MOT_DE_PASSE"));
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
                temp.setTypeUtilisateur(rs.getString("TYPE_UTILISATEUR"));
                temp.setMotDePasse(rs.getString("MOT_DE_PASSE"));
                return temp;
            }
            return null;
        }catch(SQLException e){return new Utilisateur(""+e);} //Pour voir l'erreur
    }
    public Utilisateur findByEmail(String email) {
        try{
            String requete = "SELECT * FROM utilisateur WHERE COURRIEL=?";
            PreparedStatement requeteParam = cnx.prepareStatement(requete);
            requeteParam.setString(1, email);
            ResultSet rs = requeteParam.executeQuery();
            
            if(rs.next()){
                Utilisateur temp = new Utilisateur();
                temp.setIdUtilisateur(rs.getString("ID_UTILISATEUR"));
                temp.setCourriel(rs.getString("COURRIEL"));
                temp.setNom(rs.getString("NOM"));
                temp.setPrenom(rs.getString("PRENOM"));
                temp.setTypeUtilisateur(rs.getString("TYPE_UTILISATEUR"));
                temp.setMotDePasse(rs.getString("MOT_DE_PASSE"));
                return temp;
            }
            return null;
        }catch(SQLException e){return new Utilisateur(""+e);} //Pour voir l'erreur
    }
    @Override
    public boolean create(Utilisateur o) {
        try{
            String requete = "INSERT INTO `utilisateur`"
                    + "(`ID_UTILISATEUR`, `COURRIEL`, `MOT_DE_PASSE`, `NOM`, `PRENOM`, `TYPE_UTILISATEUR`) "
                    + "VALUES (?,?,?,?,?,?)";
            PreparedStatement requeteParam = cnx.prepareStatement(requete);
            
            requeteParam.setString(1, o.getIdUtilisateur());
            requeteParam.setString(2, o.getCourriel());
            requeteParam.setString(3, o.getMotDePasse());
            requeteParam.setString(4, o.getNom());
            requeteParam.setString(5, o.getPrenom());
            requeteParam.setString(6, o.getTypeUtilisateur());
            
            requeteParam.executeUpdate();
            return true;
        }catch(SQLException e){return true;}
    }

    @Override
    public boolean update(Utilisateur o) {
        try{
        String requete = "UPDATE `utilisateur` "
                + "SET `ID_UTILISATEUR` = ?, `COURRIEL` = ?, `MOT_DE_PASSE` = ?, `NOM` = ?, `PRENOM` = ?, `TYPE_UTILISATEUR` = ? "
                + "WHERE `utilisateur`.`ID_UTILISATEUR` = ?";
        PreparedStatement requeteParam = cnx.prepareStatement(requete);
        
        requeteParam.setString(1, o.getIdUtilisateur());
        requeteParam.setString(2, o.getCourriel());
        requeteParam.setString(3, o.getMotDePasse());
        requeteParam.setString(4, o.getNom());
        requeteParam.setString(5, o.getPrenom());
        requeteParam.setString(6, o.getTypeUtilisateur());
        requeteParam.setString(7, o.getIdUtilisateur());
        
        requeteParam.executeUpdate();
        return true;
        }catch(SQLException e){return false;}
    }

    @Override
    public boolean delete(Utilisateur o) {
        try{
            String requete = "DELETE FROM `utilisateur` WHERE `utilisateur`.`ID_UTILISATEUR` = ?";
            PreparedStatement requeteParam = cnx.prepareStatement(requete);
            
            requeteParam.setString(1, o.getIdUtilisateur());
            requeteParam.executeUpdate();
            return true;
        }catch(SQLException e){return false;}
    }

    @Override
    public List<Utilisateur> findAll() {
        try{
            List<Utilisateur> liste = new ArrayList();
            String requete = "SELECT * FROM `utilisateur`";
            PreparedStatement requeteParam = cnx.prepareStatement(requete);
            
            ResultSet rs = requeteParam.executeQuery();
            while (rs.next()){
                Utilisateur temp = new Utilisateur();
                temp.setIdUtilisateur(rs.getString("ID_UTILISATEUR"));
                temp.setCourriel(rs.getString("COURRIEL"));
                temp.setNom(rs.getString("NOM"));
                temp.setPrenom(rs.getString("PRENOM"));
                temp.setTypeUtilisateur(rs.getString("PRENOM"));
                temp.setTypeUtilisateur(rs.getString("TYPE_UTILISATEUR"));
                liste.add(temp);
            }
            return liste;
        }catch(SQLException e){return null;}
    }
}
