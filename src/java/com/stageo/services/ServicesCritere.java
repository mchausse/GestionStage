 package com.stageo.services;

import com.stageo.beans.Critere;
import com.stageo.beans.Utilisateur;
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
public class ServicesCritere {
    private final Connection CNX = Connexion.getInstance();
    
    public List<Critere> findAllCriteresOffre(String idU){
        List<Critere> criteres = new ArrayList<>();
        
        String requete =    "SELECT * " +
                            "FROM critere " +
                            "WHERE ID_CRITERE IN (" +
                                "SELECT ID_CRITERE " +
                                "FROM offrestagecritere " +
                                "WHERE offrestagecritere.ID_OFFRE = ?" +
                            ");";
        
        try{
            PreparedStatement requeteParam = CNX.prepareStatement(requete);
            requeteParam.setString(1, idU);
            System.out.println(requeteParam);
            // Aller chercher le id de chaque critere
            ResultSet rs = requeteParam.executeQuery();
            
            // Aller chercher les criteres celon leurs id et les mettres dans une liste
            while (rs.next()){
                Critere temp = new Critere();
                temp.setIdCritere(rs.getString("ID_CRITERE"));
                temp.setNom(rs.getString("NOM"));
                criteres.add(temp);
            }
            return criteres;
        }catch(SQLException e){return null;}
    }
}
