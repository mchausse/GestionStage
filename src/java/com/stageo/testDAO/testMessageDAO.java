/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stageo.testDAO;

import com.stageo.beans.Message;
import com.stageo.dao.MessageDAO;
import com.stageo.singleton.Connexion;
import java.sql.Connection;

/**
 *
 * @author mchausse
 */
public class testMessageDAO {

    public static void main(String[] args) {
        Connection con = new Connexion().getInstance();
        System.out.println("Connexion cree");
        MessageDAO mDao = new MessageDAO(con);
        System.out.println("Dao avec la connexion cree");
        Message m = new Message();
        System.out.println("message initialiser");
        
        
    }
    
}
