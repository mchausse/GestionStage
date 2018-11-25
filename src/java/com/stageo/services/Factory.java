/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stageo.services;

import com.stageo.beans.Message;
import java.sql.Date;
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
// NON_FONCTIONNEL
public abstract class Factory {
    // ====================================================
    // -------------------- MESSAGE -----------------------
    // ---- Construire un Message a partir d'un rs
    public static Message getMessage(ResultSet rs) throws SQLException{
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
    }
    
    // ---- Construire une liste de Message a partir d'un rs
    public static List<Message> getMessages(ResultSet rs) throws SQLException{
        List<Message> messages = new ArrayList<>();
        if(rs.next()) messages.add(getMessage(rs));
        return messages;
    }
}
