/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stageo.testDAO;

import com.stageo.beans.Message;
import com.stageo.dao.MessageDAO;
import com.stageo.singleton.Connexion;
import java.util.List;

/* ==== INFO ====

 * @author maxime chausse
 * date : 22 novembre 2018
 * cour : Hypermedia II
 * College Rosemont
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
        
        // Cree un message
        System.out.println();
        System.out.println(">> messageDAO.create(message3)");
        Message message3 = messageDAO.find(message);
        message3.setIdMessage("1");
        message3.setTitre("Salut");
        message3.setMessage("Je sui sle message de test de la classe testMessageDAO");
        boolean suc = messageDAO.create(message3);
        System.out.println("Creation de message3 : "+suc);
        
        // Update un message
        System.out.println();
        System.out.println(">> messageDAO.update(message3)");
        message3.setTitre("Bonjours");
        messageDAO.update(message3);
        Message message4 = messageDAO.find(message3);
        System.out.println("Message4 0 : "+message4.getTitre());
        
        
        // Supprimer un message par l'objet
        System.out.println();
        System.out.println(">> messageDAO.delete(message3)");
        suc = messageDAO.delete(message3);
        System.out.println("Suppression de message3 : "+suc);
        
        // Supprimer un message le id
        System.out.println();
        System.out.println(">> messageDAO.delete(2)");
        suc = messageDAO.delete(message4);
        System.out.println("Suppression de message3 : "+suc);
        
        // Find all les messages
        System.out.println();
        System.out.println(">> messageDAO.findAll()");
        List messages = messageDAO.findAll();
        System.out.print("liste de message : ");
        messages.forEach((m) -> {
            System.out.println((Message)m);
        });
        
        // Find all les messages
        System.out.println();
        System.out.println(">> messageDAO.findAll()");
        List messages2 = messageDAO.findAllById("0");
        System.out.print("liste de message : ");
        messages.forEach((m) -> {
            System.out.println((Message)m);
        });
        
    }
    
}
