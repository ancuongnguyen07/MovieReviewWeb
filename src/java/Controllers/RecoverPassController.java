/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Beans.KhangiaUE;
import Entities.Khangia;
import Services.KhangiaService;
import Services.PassService;
import Services.Xmailer;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Long
 */
@Controller
@RequestMapping("password")
public class RecoverPassController {
    @Autowired
    SessionFactory factory;
    @Autowired
    Xmailer mailer;
    @Autowired
    KhangiaService ks;
    
    
    private final String mailFrom="MyWeb";
    private final String subject="Password Recovery";
    private final int lengthOfPass=10;
    
    @RequestMapping(value = "recover/form",method = RequestMethod.GET)
    public String recoverForm(ModelMap model){
        model.addAttribute("user", new Khangia());
        return "user/login/forgetPass/forgetPassForm";
    }
    
    @Transactional
    @RequestMapping(value = "recover/form",method = RequestMethod.POST)
    public String validateRP(ModelMap model,@Validated @ModelAttribute("user") KhangiaUE u,
                            BindingResult errors){
        
        PassService ps=new PassService();
        Khangia user=ks.findById(u.getUsername()); // chuyen sang entity Khangia
        if(errors.hasErrors() || user==null || !u.getEmail().equals(user.getEmail())){
            if (user==null) model.addAttribute("nonExistUser", "Usename khong ton tai!!!");
            else model.addAttribute("nonExistEmail", "Email khong dung voi email da dang ky");
            return "user/login/forgetPass/forgetPassForm";
        }
        String newPass;
        do{
            newPass=ps.generateRandomPass(this.lengthOfPass);
        }while(newPass.equals(user.getPassword()));
        user.setPassword(newPass);
        try {
            ks.update(user);       
        } catch (Exception e) {
            model.addAttribute("message", "Khong the cap nhat pass moi!!!");
            model.addAttribute("user", new Khangia());
            return "user/login/forgetPass/forgetPassForm";
        }
        
        try{
            String body="Chao "+user.getUsername()+",\nDay la mat khau moi cua ban: "+newPass;
            mailer.send(this.mailFrom, user.getEmail(), this.subject, body);
        }catch(Exception e){
            model.addAttribute("message", "Khong the gui mail");
            model.addAttribute("user", new Khangia());
            return "user/login/forgetPass/forgetPassForm";
        }
        return "user/login/forgetPass/successForm";
    }
    
    
}
