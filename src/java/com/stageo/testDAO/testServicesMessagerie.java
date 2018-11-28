package com.stageo.testDAO;

import com.stageo.beans.Message;
import com.stageo.beans.Utilisateur;
import com.stageo.dao.MessageDAO;
import com.stageo.dao.UtilisateurDAO;
import com.stageo.services.ServicesMessages;
import com.stageo.singleton.Connexion;
import java.util.List;

/* ==== INFO ====

 * @author maxime chausse
 * date : 22 novembre 2018
 * cour : Hypermedia II
 * College Rosemont
*/
public class testServicesMessagerie {
    public static void main(String[] args) {
        ServicesMessages servicesMessagerie = new ServicesMessages();
        MessageDAO messageDAO = new MessageDAO(Connexion.getInstance());
        UtilisateurDAO utilisateurDAO = new UtilisateurDAO(Connexion.getInstance());
        
        // Trouver l'utilisateur
        System.out.println();
        Utilisateur u = utilisateurDAO.findById("08826f75-778a-4267-b385-9a7777e3eaf1");
        System.out.println("Utilisateur "+u.getPrenom());
        
        // Trouver les messages
        System.out.println();
        List<Message> messages = servicesMessagerie.messagesRecus(u.getIdUtilisateur());
        
        for(int i=0;i<messages.size();i++)
            System.out.println(messages.size()+"Message "+i+": "+messages.get(i).getTitre());
        
        // Trouver le nombre de message non lus
        System.out.println("Nombre de messages non lus : "+servicesMessagerie.nbMessagesNonLus(u.getIdUtilisateur()));
        
    }
    
}
