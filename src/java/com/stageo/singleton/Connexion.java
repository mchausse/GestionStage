package com.stageo.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/* ==== INFO ====

 * @author maxime chausse
 * date : 16 novembre 2018
 * cour : Hypermedia II
 * College Rosemont
*/
public class Connexion {
    private static Connection cnx;
<<<<<<< HEAD
    private static String   url = "jdbc:mysql://localhost/stageo?user=root&password=root&serverTimezone=EST",
=======
    private static String   url = "jdbc:mysql://localhost/stageo?user=root&password=&serverTimezone=EST",
>>>>>>> d869feadcb609a40f044255facb8e0d9b8a6b182
                            user = "", 
                            password="";
    
    public static Connection getInstance(){
        if (cnx == null)
            try {
                if (user.equals(""))cnx = DriverManager.getConnection(url);
                else cnx = DriverManager.getConnection(url,user,password);
            } catch (SQLException e) {e.printStackTrace();}
        return cnx;
    }

    public static void reinit(){
        cnx = null;
    }
    public static void close(){
        try {
            if (cnx!=null)cnx.close();
        } catch (SQLException e) {e.printStackTrace();}
    }
    public static String getUrl() {
        return url;
    }
    public static void setUrl(String url) {
        Connexion.url = url;
    }
    public static String getUser() {
        return user;
    }
    public static void setUser(String user) {
        Connexion.user = user;
    }
    public static void setPassword(String password) {
        Connexion.password = password;
    } 
}
