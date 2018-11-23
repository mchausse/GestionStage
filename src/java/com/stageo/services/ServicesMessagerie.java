/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stageo.services;

import com.stageo.beans.Message;
import com.stageo.beans.Utilisateur;
import com.stageo.dao.MessageDAO;
import com.stageo.singleton.Connexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/* ==== INFO ====

 * @author maxime chausse
 * date : 22 novembre 2018
 * cour : Hypermedia II
 * College Rosemont
*/
public class ServicesMessagerie {
    private final Connection CNX = Connexion.getInstance();
    
    // Cree un nouveau message et l'envoyer a un autre utilisateur
    public boolean envoyerNouveauMessage(Message message, String idDestinataire){
        // Cree le nouveau message
        MessageDAO messageDAO = new MessageDAO(CNX);
        messageDAO.create(message);

        // Cree le lien avec le nouveau message et le destinataire
        return envoyerMessage(message.getIdMessage(),idDestinataire);
    }
    public boolean envoyerNouveauMessage(Message message, Utilisateur destinataire){
        return envoyerNouveauMessage(message, destinataire.getIdUtilisateur());
    }
    
    // Faire le lien entre un message existant et un utilisateur existant
    public boolean envoyerMessage(String idMessage, String idDestinataire){
        try{
            // Cree le lien avec le nouveau message et le destinataire
            String requete = "INSERT INTO UTILISATEURMESSAGE (ID_MESSAGE, ID_DESTINATAIRE) VALUES (?, ?)";
            PreparedStatement requeteParam = CNX.prepareStatement(requete);
            
            requeteParam.setString(1, idMessage.getIdMessage());
            requeteParam.setString(2, idDestinataire);
            
            requeteParam.executeUpdate();
            return true;
        }catch(SQLException e){return false;}
    }
    public boolean envoyerMessage(Message message, Utilisateur destinataire){
        return envoyerMessage(message.getIdMessage(), destinataire.getIdUtilisateur());
    }
    public boolean envoyerMessage(String idMessage, Utilisateur destinataire){
        return envoyerMessage(idMessage, destinataire.getIdUtilisateur());
    }
    public boolean envoyerMessage(Message message, String idDestinataire){
        return envoyerMessage(message.getIdMessage(), idDestinataire);
    }
}