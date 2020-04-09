/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Khangia;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;

/**
 *
 * @author Long
 */
@Transactional
public class KhangiaService {
    
    public void add(Khangia user,SessionFactory factory){
        ModelMap model=new ModelMap();
        Session se= factory.openSession();
        Transaction t=se.beginTransaction();
        try {            
            se.save(user);
            t.commit();
            model.addAttribute("message", "Add successfully!!!");
        } catch (Exception e) {
            model.addAttribute("message", "Failed to add!!!!");
            t.rollback();
        }finally{
            se.close();
        }
    }
    
    public void delete(Khangia user,SessionFactory factory){
        Session se=factory.openSession();
        Transaction t=se.beginTransaction();
        try {          
            se.delete(user);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        }finally{
            se.close();
        }
    }
    
    public Khangia find(Khangia user,SessionFactory factory){
        Session se=factory.openSession();
        return (Khangia) se.get(Khangia.class, user.getUsername());
    }
    
    public Khangia findById(String id,SessionFactory factory){
        Session se=factory.openSession();
        return (Khangia) se.get(Khangia.class, id);
    }
    //--------------------------UPDATE
}
