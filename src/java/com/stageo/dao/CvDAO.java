/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stageo.dao;

import com.stageo.beans.Cv;
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
public class CvDAO extends Dao<Cv>{
    public CvDAO(){
        super(Connexion.getInstance());
    } 
    
    public CvDAO(Connection c) {
        super(c);
    }
    
    @Override
    public Cv find(Cv o) {
        try{
            String requete = "SELECT * FROM `cv` WHERE ID_CV=?";
            PreparedStatement requeteParam = cnx.prepareStatement(requete);
            requeteParam.setString(1, o.getIdCv());
            ResultSet rs = requeteParam.executeQuery();
            
            if(rs.next()){
                Cv temp = new Cv();
                temp.setIdCv(rs.getString("ID_CV"));
                temp.setFichier(rs.getBinaryStream("FICHIER"));
                temp.setLien(rs.getString("LIEN"));
                temp.setLangue(rs.getString("LANGUE"));
                temp.setNbVues(rs.getInt("NB_VUES"));
                temp.setIdEtudiant(rs.getString("ID_ETUDIANT"));
                temp.setDate(rs.getDate("DATE"));
                return temp;
            }
            return null;
        }catch(SQLException e){return new Cv(""+e);} //Pour voir l'erreur
    }
    @Override
    public Cv findById(String id) {
        try{
            String requete = "SELECT * FROM cv WHERE ID_CV=?";
            PreparedStatement requeteParam = cnx.prepareStatement(requete);
            requeteParam.setString(1, id);
            ResultSet rs = requeteParam.executeQuery();
            
            if(rs.next()){
                Cv temp = new Cv();
                temp.setIdCv(rs.getString("ID_CV"));
                temp.setFichier(rs.getBinaryStream("FICHIER"));
                temp.setLien(rs.getString("LIEN"));
                temp.setLangue(rs.getString("LANGUE"));
                temp.setNbVues(rs.getInt("NB_VUES"));
                temp.setIdEtudiant(rs.getString("ID_ETUDIANT"));
                temp.setDate(rs.getDate("DATE"));
                return temp;
            }
            return null;
        }catch(SQLException e){return new Cv(""+e);} //Pour voir l'erreur
    }
    @Override
    public boolean create(Cv o) {
        try{
            String requete = "INSERT INTO `cv` "
                    + "(`ID_CV`, `FICHIER`, `LIEN`, `LANGUE`, `NB_VUES`, `ID_ETUDIANT`, `DATE`) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement requeteParam = cnx.prepareStatement(requete);

            requeteParam.setString(1, o.getIdCv());
            requeteParam.setBinaryStream(2, o.getFichier());
            requeteParam.setString(3, o.getLien());
            requeteParam.setString(4, o.getLangue());
            requeteParam.setInt(5, o.getNbVues());
            requeteParam.setString(6, o.getIdEtudiant());
            requeteParam.setDate(7, (Date) o.getDate());
            requeteParam.executeUpdate();
            return true;
        }catch(SQLException e){return false;}
    }
    
    @Override
    public boolean update(Cv o) {
        try{
            String requete = "UPDATE `cv` "
                    + "SET `ID_CV` = ?, `LIEN` = ?, `FICHIER` = ?"
                    + "`LANGUE` = ?, `NB_VUES` = ?, `ID_ETUDIANT` = ?, "
                    + "`DATE` = ?";
            PreparedStatement requeteParam = cnx.prepareStatement(requete);

            requeteParam.setString(1, o.getIdCv());
            requeteParam.setBinaryStream(2, o.getFichier());
            requeteParam.setString(3, o.getLien());
            requeteParam.setString(4, o.getLangue());
            requeteParam.setInt(5, o.getNbVues());
            requeteParam.setString(6, o.getIdEtudiant());
            requeteParam.setDate(7, (Date) o.getDate());
            requeteParam.executeUpdate();
            return true;
        }catch(SQLException e){return false;}
    }
    @Override
    public boolean delete(Cv o) {
        try{
            String requete = "DELETE FROM `cv` WHERE `ID_CV` = ?";
            PreparedStatement requeteParam = cnx.prepareStatement(requete);
            
            requeteParam.setString(1,o.getIdCv());
            requeteParam.executeUpdate();
            return true;
        }catch(SQLException e){return false;}
    }
    @Override
    public List<Cv> findAll() {
        try{
            List<Cv> liste = new ArrayList();
            String requete = "SELECT * FROM `cv`";
            PreparedStatement requeteParam = cnx.prepareStatement(requete);
            
            ResultSet rs = requeteParam.executeQuery();
            while (rs.next()){
                Cv temp = new Cv();
                temp.setIdCv(rs.getString("ID_CV"));
                temp.setFichier(rs.getBinaryStream("FICHIER"));
                temp.setLien(rs.getString("LIEN"));
                temp.setLangue(rs.getString("LANGUE"));
                temp.setNbVues(rs.getInt("NB_VUES"));
                temp.setIdEtudiant(rs.getString("ID_ETUDIANT"));
                temp.setDate(rs.getDate("DATE"));

                liste.add(temp);
            }
            return liste;
        }catch(SQLException e){return null;}
    }
    public List<Cv> findAllByIdEtudiant(String id) {
        try{
            List<Cv> liste = new ArrayList();
            String requete = "SELECT * FROM `cv` WHERE ID_ETUDIANT=?";
            PreparedStatement requeteParam = cnx.prepareStatement(requete);
            requeteParam.setString(1, id);
            
            ResultSet rs = requeteParam.executeQuery();
            while (rs.next()){
                Cv temp = new Cv();
                temp.setIdCv(rs.getString("ID_CV"));
                temp.setFichier(rs.getBinaryStream("FICHIER"));
                temp.setLien(rs.getString("LIEN"));
                temp.setLangue(rs.getString("LANGUE"));
                temp.setNbVues(rs.getInt("NB_VUES"));
                temp.setIdEtudiant(rs.getString("ID_ETUDIANT"));
                temp.setDate(rs.getDate("DATE"));

                liste.add(temp);
            }
            return liste;
        }catch(SQLException e){return null;}
    }
}
