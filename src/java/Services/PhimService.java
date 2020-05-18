/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Phim;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Long
 */
@Service
public class PhimService {
    
    public Phim findById(String maphim,SessionFactory factory){
        Session se=factory.getCurrentSession();
        return (Phim) se.get(Phim.class, maphim);
    }
    
    public boolean isExist(String maphim,SessionFactory factory){
        return findById(maphim,factory)!=null;
    }
    
}
