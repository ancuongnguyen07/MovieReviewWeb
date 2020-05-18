/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Binhluan;
import Entities.Khangia;
import Entities.Phim;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Long
 */

@Service
public class SearchService {
    @Autowired
    SessionFactory factory;
    
    public List<Phim> listFilm(String hql,SessionFactory factory){
        Session se=factory.openSession();
        Query query=se.createQuery(hql);
        List<Phim> list=query.list();  
        se.close();
        return list;
    }
    
    public List<Phim> listFilmMax(String hql,int maxRecords,SessionFactory factory){
        Session se=factory.openSession();
        Query query=se.createQuery(hql);
        query.setMaxResults(maxRecords);
        List<Phim> list=query.list();  
        se.close();
        return list;
    }
    
    public List<Khangia> listUser(String hql,SessionFactory factory){
        Session se=factory.openSession();
        Query query=se.createQuery(hql);
        List<Khangia> list=query.list();  
        se.close();
        return list;
    }
    
    public List<Binhluan> loadList(String hql,SessionFactory factory){
        Session se=factory.openSession();
        Query query=se.createQuery(hql);
        List<Binhluan> listBl=query.list();
        se.close();
        return listBl;
    }
}
