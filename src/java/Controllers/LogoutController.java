/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Long
 */
@Controller
@RequestMapping("/logout/")
public class LogoutController {
    @RequestMapping("user")
    public String user(HttpSession session){
        session.removeAttribute("username");
        return "redirect:/welcome.htm";
    }
    
    @RequestMapping("admin")
    public String admin(HttpSession session){
        session.removeAttribute("adminID");
        return "redirect:/login/admin/form.htm";
    }
}
