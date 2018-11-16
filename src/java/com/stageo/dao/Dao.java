package com.stageo.dao;

import java.sql.Connection;
import java.util.List;

/* ==== INFO ====

 * @author maxime chausse
 * date : 16 novembre 2018
 * cour : Hypermedia II
 * College Rosemont
*/
public abstract class Dao<T> {
	protected Connection cnx;

        public Dao(Connection cnx) {
            super();
            this.cnx = cnx;
	}
	
	public Connection getCnx() {return cnx;}

	public void setCnx(Connection cnx) {this.cnx = cnx;}

	public abstract boolean create(T x);
	public abstract T findById(String id);
        public abstract T find(T o);
	public abstract boolean update(T x);
	public abstract boolean delete(T x);
	public abstract List<T> findAll();
}
