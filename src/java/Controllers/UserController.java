/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.Khangia;
import Services.KhangiaService;
import java.io.File;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Long
 */
@Controller
@RequestMapping("/user/")
public class UserController {
    @Autowired
    SessionFactory factory;
    @Autowired
    ServletContext context;

    @Autowired
    KhangiaService ks;

    
    //----------------------------SIGNUP NEW MEMBERS
    @RequestMapping(value = "access",params = "signup")
    public String signup(ModelMap model){
        model.addAttribute("user", new Khangia());
        return "user/signup/signupForm";
    }
    
    @RequestMapping(value = "validate",method = RequestMethod.POST)
    public String validate(ModelMap model, @Validated @ModelAttribute("user") Khangia user,
                            BindingResult error, @RequestParam("confirmPass") String cpass, HttpSession session){
        Khangia x=ks.findById(user.getUsername());
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
                user.setTrangthai(true);
                ks.add(user);
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
    
    @RequestMapping(value="editForm/{username}")
    public String editInfo(ModelMap model,@PathVariable("username") String un){
        model.addAttribute("user", ks.findById(un));
        return "user/edit/editForm";
    }
    
    @RequestMapping("edit")
    public String edit(@Validated @ModelAttribute("user") Khangia u,BindingResult errors,
                        ModelMap model,HttpSession session,@RequestParam("confirmPass") String cpass){
        if (errors.hasErrors() || !cpass.equals(u.getPassword()) || cpass.isBlank()){
            model.addAttribute("mess", "loi validate");
            if (!cpass.equals(u.getPassword())) model.addAttribute("errorMess", "Nhap khong dung password ơ tren");
            if (cpass.isBlank()) model.addAttribute("errorMess", "Khong duoc de trong");
            //System.out.println(errors.getFieldError().toString());
            return "user/edit/editForm";
        }
        Khangia temp=ks.findById(u.getUsername());
        if (!temp.getPassword().equals(u.getPassword())){
            session.removeAttribute("username");
        }
        ks.update(u);
        return "redirect:/welcome.htm";
    }
}
