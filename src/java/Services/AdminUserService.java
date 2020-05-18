/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Khangia;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Long
 */
@Service
@Transactional
public class AdminUserService {
    @Autowired
    SessionFactory factory;
    @Autowired
    HttpSession session;
    
    public boolean blockUser(String username){
        Session se=factory.openSession();
        Transaction t=se.beginTransaction();
        try {
            Khangia x=(Khangia)se.get(Khangia.class, username);
            x.setTrangthai(false);
            session.setAttribute("blockedUser", true);
            se.update(x);
            t.commit();
        } catch (Exception e) {
            t.rollback();
            return false;
        }
        finally{
            se.close();
        }
        return true;
    }
    
    public boolean unblockUser(String username){
        Session se=factory.openSession();
        Transaction t=se.beginTransaction();
        try {
            Khangia x=(Khangia)se.get(Khangia.class, username);
            x.setTrangthai(true);
            session.setAttribute("blockedUser", false);
            se.update(x);
            t.commit();
        } catch (Exception e) {
            t.rollback();
            return false;
        }
        finally{
            se.close();
        }
        return true;
    } 
}
