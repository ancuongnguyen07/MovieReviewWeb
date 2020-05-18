/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Binhluan;
import Entities.Phim;
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
public class AdminBlService {
    @Autowired
    SessionFactory factory;
    @Autowired
    BlService bs;
    
    public boolean duyetBl(Integer id){
        Session se=factory.openSession();
        Transaction t=se.beginTransaction();
        try {
            Binhluan temp=(Binhluan) se.get(Binhluan.class, id);
            temp.setDuyet(true);
            bs.updatePhim_Bl(temp.getPhim().getMaphim(), temp);
            se.update(temp);
            t.commit();
        } catch (Exception e) {
            t.rollback();
            return false;
        }finally{
            se.close();
        }
        return true;
    }
    
    public boolean xoaBl(Integer id){
        Session se=factory.openSession();
        Transaction t=se.beginTransaction();
        try{
            Binhluan temp=(Binhluan) se.get(Binhluan.class, id);
            if(temp.getDuyet()) bs.updatePhim_deleteBl(temp.getPhim().getMaphim(), temp);
            se.delete(temp);
            t.commit();
        }catch(Exception e){
            t.rollback();
            return false;
        }finally{
            se.close();
        }
        return true;
    }
}
