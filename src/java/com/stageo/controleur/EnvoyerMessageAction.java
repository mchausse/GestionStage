package com.stageo.controleur;

import com.stageo.beans.Message;
import com.stageo.beans.Utilisateur;
import com.stageo.dao.UtilisateurDAO;
import com.stageo.services.ServicesMessagerie; 
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/* ==== INFO ====

 * @author maxime chausse
 * date : 24 novembre 2018
 * cour : Hypermedia II
 * College Rosemont
*/
public class EnvoyerMessageAction extends AbstractAction{
    List<Utilisateur> destinataires;
    
    @Override
    public String execute() {
        // Necessaire pour toujours a l'onglet de creation de message
        request.setAttribute("enCreation", true);
        
        // Retourner l'utilisateur a l'inscription si il n'est pas connecter
        if(request.getSession().getAttribute("utilisateur") == null)
            return "inscription";
        
        // Verifier que les champs sont remplis
        if(!ChampsValides()){
            // Remettre les informations dans les champs
            request.setAttribute("titreMessage",request.getParameter("titreMessage"));
            request.setAttribute("texteMessage",request.getParameter("texteMessage"));
            if(request.getAttribute("listeUtilisateur") == null)request.setAttribute("listeUtilisateur",request.getParameter("listeUtilisateur"));
            return "messagerie";
        }
        
        
        // Cree le message
        Message message = new Message();
        message.setIdMessage(UUID.randomUUID().toString());
        message.setTitre(request.getParameter("titreMessage"));
        message.setMessage(request.getParameter("texteMessage"));
        message.setDate(new Date());
        message.setHeure(new Date());
        message.setVu((short)0);
        // Aller chercher le id par la variable de session qui est caster en Utilisateur
        message.setIdExpediteur(((Utilisateur)request.getSession().getAttribute("utilisateur")).getIdUtilisateur());
        
        // Envoyer le message
        boolean envoi = false;
        ServicesMessagerie servicesMessagerie = new ServicesMessagerie();
        for(Utilisateur destinataire : destinataires){
            envoi = servicesMessagerie.envoyerNouveauMessage(message, destinataire);
            if(!envoi) request.setAttribute("erreurEnvoi","Une erreure est survenue lors de l'envoi");
        }
        
        if(!envoi){
            // Remettre les informations dans les champs
            request.setAttribute("titreMessage",request.getParameter("titreMessage"));
            request.setAttribute("texteMessage",request.getParameter("texteMessage"));
        }
        else {
            request.removeAttribute("enCreation");
            request.setAttribute("messageEnvoye",true);
        }
        
        return "messagerie";
    }
    
    
    
    // Fonction qui effectue les verifications necessaire au formulaires
    // et qui cree la liste des destinataires
    private boolean ChampsValides(){
        boolean valide = true;
        
        // Champs du titre non-null ou vide ou juste espace
        if(request.getParameter("titreMessage") == null || "".equals(request.getParameter("titreMessage").trim())){
            request.setAttribute("erreurTitre","Titre invalide");
            valide = false;
        }
        
        // Champs du message non-null ou vide ou juste espace
        if(request.getParameter("texteMessage") == null || "".equals(request.getParameter("texteMessage").trim())){
            request.setAttribute("erreurTexte","Message invalide");
            valide = false;
        }
        
        // Valider que au moins une addresse est ete entree
        if(request.getParameter("listeUtilisateur") == null || "".equals(request.getParameter("listeUtilisateur").trim())){
            request.setAttribute("erreurDestinataire","Un utilisateur minimum doit être selectionné");
            valide = false;
        }
        else{
            // Trouver si toutes les adresses entrer sont valides
            UtilisateurDAO utilisateurDAO = new UtilisateurDAO();
            destinataires = new ArrayList<>();
            String adressesInvalides = "";
            
            // Verifier chaques adresse en splitant le string des adresses
            for(String adresse : request.getParameter("listeUtilisateur").trim().split(";")){
                if(adresse.contains("@") && adresse.contains(".")){
                    // Verifier que l'adresse existe
                    Utilisateur temp = utilisateurDAO.findByEmail((adresse.split("\\(")[1]).split("\\)")[0]); // Separe l'adresse par les parentheses
                    // si oui on lajoute dans la liste des destinataires
                    if(temp != null){
                        // Ajouter le user juste si il nest pas deja la 
                        if(!destinataires.contains(temp))destinataires.add(temp);
                    }
                    else{
                        // Si non on invalide le formulaire et on ajoute laddrese aux invalides
                        if(valide)valide = false;
                        adressesInvalides += adresse;
                    }
                }
                else{
                    if(valide)valide = false;
                    // Une adresse est la, mais invalide
                    adressesInvalides += adresse;
                }
            }
            // Lui redonner la liste des utilisateur
            request.setAttribute("listeUtilisateur",request.getParameter("listeUtilisateur").trim());
            // Donner le message d'erreur
            if(!"".equals(adressesInvalides))request.setAttribute("erreurDestinataire","Utilisateur(s) invalide(s): "+adressesInvalides);
        }
        return valide;
    }
}
