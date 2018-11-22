/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stageo.dao;

import com.stageo.beans.Message;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/* ==== INFO ====

 * @author maxime chausse
 * date : 22 novembre 2018
 * cour : Hypermedia II
 * College Rosemont
*/
public class MessageDAO extends Dao<Message>{
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
            Message message = new Message();
            if(rs.next()){
                message.setIdMessage(rs.getString("ID_MESSAGE"));
                message.setTitre(rs.getString("TITRE"));
                message.setMessage(rs.getString("MESSAGE"));
                message.setVu(Short.valueOf(rs.getString("VU")));
                message.setDate(rs.getDate("DATE"));
                message.setHeure(rs.getDate("HEURE"));
                message.setIdExpediteur(rs.getString("ID_EXPEDITEUR"));
                return message;
            }
            return null;
        }catch(SQLException e){return new Message(""+e);}
    }
    
    @Override
    public boolean create(Message x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Message x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Message x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Message> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
