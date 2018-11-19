/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stageo.dao;

import com.stageo.beans.Etudiant;
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
public class EtudiantDAO extends Dao<Etudiant>{
     public EtudiantDAO(Connection c) {
        super(c);
    }
    
    @Override
    public Etudiant find(Etudiant o) {
        try{
            String requete = "SELECT * FROM Etudiant WHERE ID_Etudiant=?";
            PreparedStatement requeteParam = cnx.prepareStatement(requete);
            requeteParam.setString(1, o.getIdEtudiant());
            ResultSet rs = requeteParam.executeQuery();
            
            if(rs.next()){
                Etudiant temp = new Etudiant();
                temp.setIdEtudiant(rs.getString("ID_Etudiant"));
                temp.setStatutRecherche(rs.getString("STATUT_RECHERCHE"));
                return temp;
            }
            return null;
        }catch(SQLException e){return new Etudiant(""+e);} //Pour voir l'erreur
    }

    @Override
    public Etudiant findById(String id) {
        try{
            String requete = "SELECT * FROM Etudiant WHERE ID_Etudiant=?";
            PreparedStatement requeteParam = cnx.prepareStatement(requete);
            requeteParam.setString(1, id);
            ResultSet rs = requeteParam.executeQuery();
            
            if(rs.next()){
                Etudiant temp = new Etudiant();
                temp.setIdEtudiant(rs.getString("ID_Etudiant"));
                temp.setStatutRecherche(rs.getString("STATUT_RECHERCHE"));
                return temp;
            }
            return null;
        }catch(SQLException e){return new Etudiant(""+e);} //Pour voir l'erreur
    }
    @Override
    public boolean create(Etudiant o) {
        try{
            String requete = "INSERT INTO `etudiant` (`ID_ETUDIANT`, `STATUT_RECHERCHE`) VALUES (?, ?)";
            PreparedStatement requeteParam = cnx.prepareStatement(requete);
            
            requeteParam.setString(1, o.getIdEtudiant());
            requeteParam.setString(2, o.getStatutRecherche());
            requeteParam.executeUpdate();
            return true;
        }catch(SQLException e){return true;}
    }

    @Override
    public boolean update(Etudiant o) {
        try{
        String requete = "UPDATE `Etudiant` "
                + "SET `ID_Etudiant` = ?, `STATUT_RECHERCHE` = ? "
                + "WHERE `Etudiant`.`ID_Etudiant` = ?";
        PreparedStatement requeteParam = cnx.prepareStatement(requete);
        
        requeteParam.setString(1, o.getIdEtudiant());
        requeteParam.setString(1, o.getStatutRecherche());
        requeteParam.executeUpdate();
        return true;
        }catch(SQLException e){return false;}
    }

    @Override
    public boolean delete(Etudiant o) {
        try{
            String requete = "DELETE FROM `Etudiant` WHERE `Etudiant`.`ID_Etudiant` = ?";
            PreparedStatement requeteParam = cnx.prepareStatement(requete);
            
            requeteParam.setString(1, o.getIdEtudiant());
            requeteParam.executeUpdate();
            return true;
        }catch(SQLException e){return false;}
    }

    @Override
    public List<Etudiant> findAll() {
        try{
            List<Etudiant> liste = new ArrayList();
            String requete = "SELECT * FROM `Etudiant`";
            PreparedStatement requeteParam = cnx.prepareStatement(requete);
            
            ResultSet rs = requeteParam.executeQuery();
            while (rs.next()){
                Etudiant temp = new Etudiant();
                temp.setIdEtudiant(rs.getString("ID_Etudiant"));
                temp.setStatutRecherche(rs.getString("STATUT_RECHERCHE"));
                liste.add(temp);
            }
            return liste;
        }catch(SQLException e){return null;}
    }
}