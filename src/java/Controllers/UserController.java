/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.Khangia;
import Services.KhangiaService;
import javax.servlet.http.HttpSession;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Long
 */
@Controller
@RequestMapping("/user/")
public class UserController {
    @Autowired
    SessionFactory factory;
    
    //----------------------------SIGNUP NEW MEMBERS
    @RequestMapping(value = "access",params = "signup")
    public String signup(ModelMap model){
        model.addAttribute("user", new Khangia());
        return "user/signup/signupForm";
    }
    
    @RequestMapping(value = "validate",method = RequestMethod.POST)
    public String validate(ModelMap model, @Validated @ModelAttribute("user") Khangia user,
                            BindingResult error, @RequestParam("confirmPass") String cpass, HttpSession session){
        KhangiaService service=new KhangiaService();
        Khangia x=service.find(user,factory);
        if (error.hasErrors() || cpass.isBlank() 
            || !cpass.equals(user.getPassword()) || x!=null){
            model.addAttribute("message", "Con loi!!!");
            if (x!=null) model.addAttribute("dupUsername", "Username da ton tai!!!");
            if (cpass.isBlank()) model.addAttribute("errorMess", "Khong duoc bo trong!!!");
            else if (!cpass.equals(user.getPassword())) model.addAttribute("errorMess", "Chua trung khop voi Password!!!");
            return "user/signup/signupForm";
        }
        else {           
            try {
                service.add(user, factory);
                session.setAttribute("username", user.getUsername()); // luu username vao session
            } catch (Exception e) {
                model.addAttribute("message", "Failed to add");
                return "user/signup/signupForm";
            }
            return "user/signup/success";
        }
    }
        
    @RequestMapping(value = "access",params = "login")
    public String loginForm(){
        return "redirect:/login/form.htm";
    }
    
}
