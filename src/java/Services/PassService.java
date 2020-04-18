/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Khangia;
import java.util.Random;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Long
 */
@Transactional
public class PassService {
    
    public String generateRandomPass(int length){
        Random rd=new Random();
        String result="";
        for (int i=0;i<length;i++){
            int x=33+rd.nextInt(94); // [33,126]
            result+=(char)x; 
        }
        return result;
    }
    
    
    
}
