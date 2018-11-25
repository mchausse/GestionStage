package com.stageo.testDAO;

import com.stageo.beans.Employeur;
import com.stageo.dao.EmployeurDAO;

/* ==== INFO ====

 * @author maxime chausse
 * date : 23 novembre 2018
 * cour : Hypermedia II
 * College Rosemont
*/
public class testEmployeurDAO {
    public static void main(String[] args) {
        EmployeurDAO employeurDAO = new EmployeurDAO();
        Employeur employeur;
        
        employeur = employeurDAO.findById("09dbbbc7-f095-4b5d-8457-c05c923c7f85");
        System.out.println(employeur);
        
        System.out.println(employeur.getIdCompagnie());
    }
    
}
