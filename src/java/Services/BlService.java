/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Binhluan;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Long
 */
public class BlService {
    public List<Binhluan> loadList(String hql,SessionFactory factory){
        Session se=factory.getCurrentSession();
        Query query=se.createQuery(hql);
        List<Binhluan> listBl=query.list();
        return listBl;
    }
}
