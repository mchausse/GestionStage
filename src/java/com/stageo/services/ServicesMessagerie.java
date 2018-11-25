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
            String requete = "INSERT INTO UTILISATEURMESSAGE (ID_MESSAGE, ID_DESTINATAIRE, LU) VALUES (?, ?, ?)";
            PreparedStatement requeteParam = CNX.prepareStatement(requete);
            
            requeteParam.setString(1, idMessage);
            requeteParam.setString(2, idDestinataire);
            requeteParam.setString(3, "0");
            
            requeteParam.executeUpdate();
            return true;
        }catch(SQLException e){
            System.out.println(e);
            return false;
        }
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
    
    
    // Aller chercher tous les message d'un utilisateur
    public List<Message> messagesRecus(String idUtilisateur){
        MessageDAO messageDAO = new MessageDAO(CNX);
        List messages = new ArrayList<>();
        String requete = "SELECT * FROM UTILISATEURMESSAGE WHERE ID_DESTINATAIRE = ?";
        
        try{
            PreparedStatement requeteParam = CNX.prepareStatement(requete);
            requeteParam.setString(1, idUtilisateur);
            
            // Aller chercher le id de chaque message
            ResultSet rs = requeteParam.executeQuery();
            
            // Aller chercher les messages celon leurs id et les mettres dans une liste
            while (rs.next()){
                messages.add(messageDAO.findById(rs.getString("ID_MESSAGE")));
            }
            return messages;
        }catch(SQLException e){return null;}
    }
    public List<Message> messagesRecus(Utilisateur u){return messagesRecus(u.getIdUtilisateur());}

    
    // Aller chercher tous les message d'un utilisateur qui sont non lus
    public List<Message> messagesRecusNonLus(String idUtilisateur){
        MessageDAO messageDAO = new MessageDAO(CNX);
        List messages = new ArrayList<>();
        String requete = "SELECT * FROM UTILISATEURMESSAGE WHERE ID_DESTINATAIRE = ? AND LU = 0";
        
        try{
            PreparedStatement requeteParam = CNX.prepareStatement(requete);
            requeteParam.setString(1, idUtilisateur);
            
            // Aller chercher le id de chaque message
            ResultSet rs = requeteParam.executeQuery();
            
            // Aller chercher les messages celon leurs id et les mettres dans une liste
            while (rs.next()){
                messages.add(messageDAO.findById(rs.getString("ID_MESSAGE")));
            }
            return messages;
        }catch(SQLException e){return null;}
    }
    public List<Message> messagesRecusNonLus(Utilisateur u){return messagesRecusNonLus(u.getIdUtilisateur());}
    
    
    // Aller chercher tous les message d'un utilisateur qui sont lus
    public List<Message> messagesRecusLus(String idUtilisateur){
        MessageDAO messageDAO = new MessageDAO(CNX);
        List messages = new ArrayList<>();
        String requete = "SELECT * FROM UTILISATEURMESSAGE WHERE ID_DESTINATAIRE = ? AND LU = 1";
        
        try{
            PreparedStatement requeteParam = CNX.prepareStatement(requete);
            requeteParam.setString(1, idUtilisateur);
            
            // Aller chercher le id de chaque message
            ResultSet rs = requeteParam.executeQuery();
            
            // Aller chercher les messages celon leurs id et les mettres dans une liste
            while (rs.next()){
                messages.add(messageDAO.findById(rs.getString("ID_MESSAGE")));
            }
            return messages;
        }catch(SQLException e){return null;}
    }
    public List<Message> messagesRecusLus(Utilisateur u){return messagesRecusLus(u.getIdUtilisateur());}
    
    
    // Aller chercher tous les message que un utilisateur a envoyer
    public List<Message> messagesEnvoyes(String idUtilisateur){
        List messages = new ArrayList<>();
        String requete = "SELECT * FROM MESSAGE WHERE ID_EXPEDITEUR = ?";
        
        try{
            PreparedStatement requeteParam = CNX.prepareStatement(requete);
            requeteParam.setString(1, idUtilisateur);
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
                messages.add(message);
            }
            return messages;
        }catch(SQLException e){return null;}
    }
    public List<Message> messagesEnvoyes(Utilisateur u){return messagesEnvoyes(u.getIdUtilisateur());}
    
    
    // Retourner le nombre de message non-lu
    public int nbMessagesNonLus(String idUtilisateur){
        String requete = "SELECT COUNT(ID_MESSAGE) "
                        + "AS nbMessage "
                        + "FROM UTILISATEURMESSAGE "
                        + "WHERE ID_DESTINATAIRE = ? AND LU = 0";
        try{
            PreparedStatement requeteParam = CNX.prepareStatement(requete);
            requeteParam.setString(1, idUtilisateur);
            ResultSet rs = requeteParam.executeQuery();
            
            if(rs.next())return rs.getInt("nbMessage");
            return -1;
        }catch(SQLException e){return -1;}
    }
    public int nbMessagesNonLus(Utilisateur utilisateur){return nbMessagesNonLus(utilisateur.getIdUtilisateur());}
    
    
    public List<String> listeOrdoneTypePrenomNomEmail(){
        List<String> liste = new ArrayList<>();
        
        try{
            String requete = "SELECT utilisateur.TYPE_UTILISATEUR, utilisateur.NOM, utilisateur.PRENOM, utilisateur.COURRIEL "
                            + "FROM UTILISATEUR "
                            + "ORDER BY utilisateur.TYPE_UTILISATEUR, utilisateur.NOM, utilisateur.PRENOM ";
            
            PreparedStatement requeteParam = CNX.prepareStatement(requete);
            
            ResultSet rs = requeteParam.executeQuery();
            while (rs.next())
                liste.add(rs.getString("TYPE_UTILISATEUR")+","+rs.getString("NOM")+","+rs.getString("PRENOM")+","+rs.getString("COURRIEL"));
            return liste;
        }catch(SQLException e){return null;}
    }
    public String getEmailFromParentheses(String s){return (s.split("\\(")[1]).split("\\)")[0];}
}