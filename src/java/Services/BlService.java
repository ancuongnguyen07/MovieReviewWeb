/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Binhluan;
import Entities.Phim;
import java.util.List;
import org.hibernate.Query;
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
@Transactional
@Service
public class BlService {
    @Autowired
    SessionFactory factory;
    
    public void saveBl(Binhluan bl){
        Session se=factory.openSession();
        Transaction t=se.beginTransaction();
        try {
            se.save(bl);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        }finally{
            se.close();
        }
    }
    
    public void updatePhim_Bl(String maphim,Binhluan bl){
        Session se=factory.openSession();
        Transaction t=se.beginTransaction();
        try {
            Phim movie=(Phim) se.get(Phim.class, maphim);
            
            movie.setDiem(Math.round((movie.getDiem()*movie.getLuotbl()+bl.getDiem())*100/(movie.getLuotbl()+1))/100);
            movie.setLuotbl(movie.getLuotbl()+1);
            se.update(movie);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        }finally{
            se.close();
        }
    }
}
