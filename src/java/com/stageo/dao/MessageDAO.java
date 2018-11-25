/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stageo.dao;

import com.stageo.beans.Message;
import com.stageo.singleton.Connexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* ==== INFO ====

 * @author maxime chausse
 * date : 22 novembre 2018
 * cour : Hypermedia II
 * College Rosemont
*/
public class MessageDAO extends Dao<Message>{
    public MessageDAO(){super(Connexion.getInstance());}
    public MessageDAO(Connection c) {super(c);}
    
    @Override
    public Message find(Message o) {return findById(o.getIdMessage());}

    @Override
    public Message findById(String id) {
        try{
            String req = "SELECT * FROM MESSAGE WHERE ID_MESSAGE=?";
            PreparedStatement reqParam = cnx.prepareStatement(req);
            reqParam.setString(1, id);
            ResultSet rs = reqParam.executeQuery();
            if(rs.next()){
                Message message = new Message();
                message.setIdMessage(rs.getString("ID_MESSAGE"));
                message.setTitre(rs.getString("TITRE"));
                message.setMessage(rs.getString("MESSAGE"));
                message.setVu(Short.valueOf(rs.getString("VU")));
                message.setDate(rs.getDate("DATE"));
                message.setHeure(rs.getTime("HEURE"));
                message.setIdExpediteur(rs.getString("ID_EXPEDITEUR"));
                return message;
            }
            return null;
        }catch(SQLException e){return new Message(""+e);}
    }
    
    @Override
    public boolean create(Message m) {
        try{
            String req = "INSERT INTO MESSAGE (ID_MESSAGE, TITRE, MESSAGE, VU, DATE, HEURE, ID_EXPEDITEUR) "
                            + "VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement reqParam = cnx.prepareStatement(req);
            
            reqParam.setString(1, m.getIdMessage());
            reqParam.setString(2, m.getTitre());
            reqParam.setString(3, m.getMessage());
            reqParam.setShort(4, m.getVu());
            reqParam.setDate(5, new java.sql.Date(m.getDate().getTime()));
            reqParam.setTime(6, new java.sql.Time(m.getHeure().getTime()));
            reqParam.setString(7, m.getIdExpediteur());
            reqParam.executeUpdate();
            return true;
        }catch(SQLException e){
            System.out.println(e);
            return false;
        }
    }

    @Override
    public boolean update(Message m) {
        try{
            String requete = "UPDATE MESSAGE "
                            + "SET ID_MESSAGE = ?, TITRE = ?, MESSAGE = ?, VU = ?, DATE = ?, HEURE = ?, ID_EXPEDITEUR = ?"
                            + "WHERE MESSAGE.ID_MESSAGE = ?";
            PreparedStatement reqParam = cnx.prepareStatement(requete);

            reqParam.setString(1, m.getIdMessage());
            reqParam.setString(2, m.getTitre());
            reqParam.setString(3, m.getMessage());
            reqParam.setShort(4, m.getVu());
            reqParam.setString(5, m.getDate().toString());
            reqParam.setString(6, m.getHeure().toString());
            reqParam.setString(7, m.getIdExpediteur());
            reqParam.executeUpdate();
            return true;
        }catch(SQLException e){return false;}
    }

    public boolean delete(String id){
        try{
            String requete = "DELETE FROM MESSAGE WHERE MESSAGE.ID_MESSAGE = ?";
            PreparedStatement requeteParam = cnx.prepareStatement(requete);
            requeteParam.setString(1, id);
            requeteParam.executeUpdate();
            return true;
        }catch(SQLException e){return false;}
    }
    @Override
    public boolean delete(Message x) {return delete(x.getIdMessage());}

    @Override
    public List<Message> findAll() {
        try{
            List<Message> liste = new ArrayList();
            String requete = "SELECT * FROM MESSAGE";
            PreparedStatement requeteParam = cnx.prepareStatement(requete);
            
            ResultSet rs = requeteParam.executeQuery();
            while (rs.next()){
                Message message = new Message();
                message.setIdMessage(rs.getString("ID_MESSAGE"));
                message.setTitre(rs.getString("TITRE"));
                message.setMessage(rs.getString("MESSAGE"));
                message.setVu(Short.valueOf(rs.getString("VU")));
                message.setDate(rs.getDate("DATE"));
                message.setHeure(rs.getTime("HEURE"));
                message.setIdExpediteur(rs.getString("ID_EXPEDITEUR"));
                liste.add(message);
            }
            return liste;
        }catch(SQLException e){return null;}
    }
    
    public List<Message> findAllByIdExpediteur(String id) {
        try{
            List<Message> liste = new ArrayList();
            String requete = "SELECT * FROM MESSAGE WHERE MESSAGE.ID_EXPEDITEUR = ?";
            PreparedStatement requeteParam = cnx.prepareStatement(requete);
            
            requeteParam.setString(1, id);
            
            ResultSet rs = requeteParam.executeQuery();
            while (rs.next()){
                Message message = new Message();
                message.setIdMessage(rs.getString("ID_MESSAGE"));
                message.setTitre(rs.getString("TITRE"));
                message.setMessage(rs.getString("MESSAGE"));
                message.setVu(Short.valueOf(rs.getString("VU")));
                message.setDate(rs.getDate("DATE"));
                message.setHeure(rs.getTime("HEURE"));
                message.setIdExpediteur(rs.getString("ID_EXPEDITEUR"));
                liste.add(message);
            }
            return liste;
        }catch(SQLException e){return null;}
    }
}
