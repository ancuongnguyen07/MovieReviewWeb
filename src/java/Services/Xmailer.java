/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

/**
 *
 * @author Long
 */
@Service("mailer")
public class Xmailer {
    @Autowired
    JavaMailSender mailer;
    
    public void send(String from,String to,String subject,String body){
        try{
            MimeMessage mail=mailer.createMimeMessage();
            MimeMessageHelper helper=new MimeMessageHelper(mail);
        
            helper.setFrom(from, from);
            helper.setTo(to);
            helper.setReplyTo(from, from);
            helper.setSubject(subject);
            helper.setText(body);
            
            mailer.send(mail);            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
    }
}
