/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stageo.dao;

import com.stageo.beans.Etudiant;
import com.stageo.beans.Etudiantcritere;
import com.stageo.beans.EtudiantcriterePK;
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
public class EtudiantCritereDAO extends Dao<Etudiantcritere> {
    public EtudiantCritereDAO(){
        super(Connexion.getInstance());
    }
    public EtudiantCritereDAO(Connection cnx) {
        super(cnx);
    }

    @Override
    public boolean create(Etudiantcritere x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Etudiantcritere findById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public List<Etudiantcritere> findByIdCritere(String id) {
        try{
            List<Etudiantcritere> liste = new ArrayList();
            String requete = "SELECT * FROM `etudiantcritere` WHERE `ID_CRITERE` = ?";
            PreparedStatement requeteParam = cnx.prepareStatement(requete); 
            
            requeteParam.setString(1, id);
            ResultSet rs = requeteParam.executeQuery();
            while(rs.next()){
                Etudiantcritere e = new Etudiantcritere();
                e.setEtudiantcriterePK(new EtudiantcriterePK(rs.getString("ID_ETUDIANT"), rs.getString("ID_CRITERE")));
                liste.add(e);
            }
            return liste;
        }
        catch(SQLException e){
             Logger.getLogger(EtudiantCritereDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
    
    public List<Etudiantcritere> findByIdEtudiant(String id) {
         try{
            List<Etudiantcritere> liste = new ArrayList();
            String requete = "SELECT * FROM `etudiantcritere` WHERE `ID_ETUDIANT` = ?";
            PreparedStatement requeteParam = cnx.prepareStatement(requete); 
            
            requeteParam.setString(1, id);
            ResultSet rs = requeteParam.executeQuery();
            while(rs.next()){
                Etudiantcritere e = new Etudiantcritere();
                e.setEtudiantcriterePK(new EtudiantcriterePK(rs.getString("ID_ETUDIANT"), rs.getString("ID_CRITERE")));
                liste.add(e);
            }
            return liste;
        }
        catch(SQLException e){
             Logger.getLogger(EtudiantCritereDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
    @Override
    public Etudiantcritere find(Etudiantcritere o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Etudiantcritere x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Etudiantcritere x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Etudiantcritere> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}
