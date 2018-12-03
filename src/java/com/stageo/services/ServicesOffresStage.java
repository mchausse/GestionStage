/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stageo.services;

import com.stageo.beans.Critere;
import com.stageo.beans.OffreStage;
import com.stageo.dao.OffreStageDAO;
import com.stageo.singleton.Connexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* ==== INFO ====

 * @author maxime chausse
 * date : 29 novembre 2018
 * cour : Hypermedia II
 * College Rosemont
*/
public class ServicesOffresStage {
    private final Connection CNX = Connexion.getInstance();
    
    public List<OffreStage> findAllSelonCritere(ArrayList<Critere> listeC) {
        try{
            // Init le compteneur pour les stages
            List<OffreStage> liste = new ArrayList();
            
            //Verifier les stage pour chaque critere
            for(Critere c : listeC){
                String requete = "SELECT * \n" +
                                 "FROM OFFRESTAGE\n" +
                                 "WHERE ID_OFFRE IN(\n" +
                                 "	SELECT ID_OFFRE FROM offrestagecritere WHERE ID_CRITERE =(\n" +
                                 "    	SELECT ID_CRITERE FROM CRITERE WHERE ID_CRITERE = ?\n" +
                                 "    )\n" +
                                 ")\n" +
                                 "ORDER BY OFFRESTAGE.DATE DESC";
                PreparedStatement requeteParam = CNX.prepareStatement(requete); 

                requeteParam.setString(1, c.getIdCritere());
                ResultSet rs = requeteParam.executeQuery();

                while(rs.next()){
                    OffreStage o = new OffreStage();
                    o.setIdOffre(rs.getString("ID_OFFRE"));
                    o.setTitre(rs.getString("TITRE"));
                    o.setDescription(rs.getString("DESCRIPTION"));
                    o.setDateDebut(rs.getDate("DATE_DEBUT")); 
                    o.setDateFin(rs.getDate("DATE_FIN")); 
                    o.setDureeEnJours(rs.getInt("DUREE_EN_JOURS")); 
                    o.setRemunere(rs.getInt("REMUNERE")==1);
                    o.setLienWeb(rs.getString("LIEN_WEB"));                
                    o.setLienDocument(rs.getBinaryStream("LIEN_DOCUMENT"));
                    o.setDate(rs.getDate("DATE"));
                    o.setNbVues(rs.getInt("NB_VUES"));
                    o.setActive(rs.getInt("ACTIVE")==1);
                    o.setIdEmployeur(rs.getString("ID_EMPLOYEUR"));
                    if(!liste.contains(o))liste.add(o);
                }
            }
            // A la fin on retourne la liste de stage trouvee
            return liste;
        }
        catch(SQLException e){
             Logger.getLogger(OffreStageDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
}
