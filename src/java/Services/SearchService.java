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
    
    public List<Phim> listFilm(String hql){
        Session se=factory.openSession();
        Query query=se.createQuery(hql);
        List<Phim> list=query.list();  
        se.close();
        return list;
    }
    
    public List<Phim> listFilm(String hql,int maxRecords){
        Session se=factory.openSession();
        Query query=se.createQuery(hql);
        query.setMaxResults(maxRecords);
        List<Phim> list=query.list();  
        se.close();
        return list;
    }
    
    public List<Phim> listFilm(String hql,int minRecords,int maxRecords){
        Session se=factory.openSession();
        Query query=se.createQuery(hql);
        query.setFirstResult(minRecords);
        query.setMaxResults(maxRecords);
        List<Phim> list=query.list();  
        se.close();
        return list;
    }
    
    public List<Khangia> listUser(String hql){
        Session se=factory.openSession();
        Query query=se.createQuery(hql);
        List<Khangia> list=query.list();  
        se.close();
        return list;
    }
    
    public List<Khangia> listUser(String hql,int maxRecords){
        Session se=factory.openSession();
        Query query=se.createQuery(hql);
        query.setMaxResults(maxRecords);
        List<Khangia> list=query.list();  
        se.close();
        return list;
    }
    
    public List<Khangia> listUser(String hql,int minRecords,int maxRecords){
        Session se=factory.openSession();
        Query query=se.createQuery(hql);
        query.setFirstResult(minRecords);
        query.setMaxResults(maxRecords);
        List<Khangia> list=query.list();  
        se.close();
        return list;
    }
    
    public List<Binhluan> listBl(String hql){
        Session se=factory.openSession();
        Query query=se.createQuery(hql);
        List<Binhluan> listBl=query.list();
        se.close();
        return listBl;
    }
    
    public List<Binhluan> listBl(String hql,int maxRecords){
        Session se=factory.openSession();
        Query query=se.createQuery(hql);
        query.setMaxResults(maxRecords);
        List<Binhluan> listBl=query.list();
        se.close();
        return listBl;
    }
    
    public List<Binhluan> listBl(String hql,int minRecords,int maxRecords){
        Session se=factory.openSession();
        Query query=se.createQuery(hql);
        query.setFirstResult(minRecords);
        query.setMaxResults(maxRecords);
        List<Binhluan> listBl=query.list();
        se.close();
        return listBl;
    }
    
    public long countTotalRecords(String hql){
        Session se=factory.openSession();
        Query query=se.createQuery(hql);
        return (long) query.uniqueResult();
    }
}
