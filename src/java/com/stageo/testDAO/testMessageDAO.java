/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stageo.testDAO;

import com.stageo.beans.Message;
import com.stageo.dao.MessageDAO;
import com.stageo.singleton.Connexion;

/**
 *
 * @author mchausse
 */
public class testMessageDAO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Initialisation
        MessageDAO messageDAO = new MessageDAO(Connexion.getInstance());
        Message message, message2;
        
        // Trouver le message par le id
        System.out.println();
        System.out.println(">> messageDAO.findById(\"0\")");
        message = messageDAO.findById("0");
        System.out.println("Message 0 : "+message.getTitre());
        
        // Trouver le message par l'objet
        System.out.println();
        System.out.println(">> messageDAO.find(message2)");
        message2 = messageDAO.find(message);
        System.out.println("Message2 0 : "+message.getTitre());
    }
    
}
