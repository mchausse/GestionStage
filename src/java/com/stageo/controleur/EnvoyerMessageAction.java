package com.stageo.controleur;

import com.stageo.beans.Utilisateur;
import com.stageo.dao.UtilisateurDAO;
import java.util.ArrayList;
import java.util.List;

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
        
        // Creer et envoyer le message
        
        return "messagerie";
    }
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
