/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.Khangia;
import Entities.Nhanvien;
import Services.CookieService;
import Services.KhangiaService;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Long
 */
@Controller
@RequestMapping("/login/")
public class LoginController {
    @Autowired
    SessionFactory factory;
    
    final private int maxAge=60*60*24; // max age of cookies
    
    @RequestMapping(value = "form",method = RequestMethod.GET)
    public String form(ModelMap model){
        model.addAttribute("message", "Hello cac ban!!!");
        return "user/login/loginForm";
    }
    
    @RequestMapping(value = "form",method = RequestMethod.POST)
    public String form(ModelMap model,HttpServletRequest request,HttpSession session,@RequestParam("password") String pa,
                        @RequestParam("username") String un,HttpServletResponse response){
        KhangiaService service=new KhangiaService();
        Khangia x=service.findById(un, factory);
        if (x==null || !x.getPassword().equals(pa) || un.isBlank() || pa.isBlank()){
            model.addAttribute("message", "Con loi!!!");
            if (pa.isBlank()) model.addAttribute("paError", "Khong duoc de trong");
            if (un.isBlank()) model.addAttribute("unError", "Khong duoc de trong");
            else if (x==null) model.addAttribute("unError", "username khong ton tai");
            else if (x!=null) model.addAttribute("paError", "Sai mat khau");
            return "user/login/loginForm";
        }
        // luc nay user==x, username va password trung khop
        session.setAttribute("username", x.getUsername());// luu username vao session
        // check remember to me
        if (request.getParameter("chkremember")!=null){
            // luu username va password vao cookie
            Cookie uname=new Cookie("username", x.getUsername());
            Cookie pass=new Cookie("password", x.getPassword());
            uname.setMaxAge(maxAge);
            pass.setMaxAge(maxAge);
            response.addCookie(pass);
            response.addCookie(uname);
        }
        else{
            // xoa cookie
            Cookie[] list=request.getCookies();
            for (Cookie c:list){
                if (c.getName().equals("username") || c.getName().equals("password")){
                    c.setMaxAge(0);
                    response.addCookie(c);
                }
            }
        }
        return "redirect:/welcome.htm";
    }
    
    @RequestMapping(value = "admin/form",method = RequestMethod.GET)
    public String adminForm(){
        return "user/login/adminLoginForm";
    }
    
    @RequestMapping(value = "admin/form",method = RequestMethod.POST)
    public String adminForm(ModelMap model,@RequestParam("manv") String id,
                            @RequestParam("password") String pa,HttpServletRequest request,
                            HttpSession session,HttpServletResponse response){
        Session se=factory.openSession();
        Nhanvien x=(Nhanvien) se.get(Nhanvien.class,id);
        if (x==null || !x.getPassword().equals(pa) || id.isBlank() || pa.isBlank()){
            model.addAttribute("message", "Con loi!!!");
            if (pa.isBlank()) model.addAttribute("paError", "Khong duoc de trong");
            if (id.isBlank()) model.addAttribute("unError", "Khong duoc de trong");
            else if (x==null) model.addAttribute("unError", "ID khong ton tai");
            else if (x!=null) model.addAttribute("paError", "Sai mat khau");
            return "user/login/loginForm";
        }
        // luc nay user==x, username va password trung khop
        session.setAttribute("adminID", x.getManv());// luu username vao session
        // check remember to me
        if (request.getParameter("chkremember")!=null){
            // luu username va password vao cookie
            Cookie uname=new Cookie("adminID", x.getManv());
            Cookie pass=new Cookie("passwordAdmin", x.getPassword());
            uname.setMaxAge(maxAge);
            pass.setMaxAge(maxAge);
            response.addCookie(pass);
            response.addCookie(uname);
        }
        else{
            // xoa cookie
            Cookie[] list=request.getCookies();
            for (Cookie c:list){
                if (c.getName().equals("adminID") || c.getName().equals("passwordAdmin")){
                    c.setMaxAge(0);
                    response.addCookie(c);
                }
            }
        }
        return "aaa";
    }
}
