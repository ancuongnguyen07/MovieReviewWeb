/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Phim;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Long
 */

public class SearchService {
    public List<Phim> listFilm(String hql,SessionFactory factory){
        Session se=factory.openSession();
        Query query=se.createQuery(hql);
        List<Phim> list=query.list();  
        se.close();
        return list;
    }
    
}
