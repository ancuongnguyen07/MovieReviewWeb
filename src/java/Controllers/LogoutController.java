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
    @RequestMapping("home")
    public String home(HttpSession session){
        session.setAttribute("loggedin", false);
        session.removeAttribute("username");
        return "redirect:/welcome.htm";
    }
}
