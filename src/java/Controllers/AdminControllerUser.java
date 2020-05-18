/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.Khangia;
import Services.AdminUserService;

import Services.SearchService;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Long
 */
@Controller
@RequestMapping("admin")
public class AdminControllerUser {
  
    @Autowired
    SessionFactory factory;
    @Autowired
    AdminUserService aus;
    @Autowired
    SearchService ss;
    
    private long totalRecords;
    final int RECORDSHOW=5;
    //final int ROWS=2;
    private long totalPages;
    
    @RequestMapping("user")
    public String getAdminPhim(ModelMap model,HttpSession session)
    {
        this.totalRecords=ss.countTotalRecords("SELECT count(u.username) FROM Khangia u");
        if (this.totalRecords%this.RECORDSHOW==0){
            this.totalPages=this.totalRecords/this.RECORDSHOW;
        }
        else this.totalPages=this.totalRecords/this.RECORDSHOW+1;
        
        return "redirect:/admin/user/1.htm";
    }
    
    @RequestMapping("user/{numPage}")
    public String listUserPagination(@PathVariable("numPage") int numPage,ModelMap model){
        model.addAttribute("numPage", numPage);
        model.addAttribute("totalPages", this.totalPages);

        int start=(numPage-1)*this.RECORDSHOW;
        model.addAttribute("userListAdmin", ss.listUser("FROM Khangia", start, RECORDSHOW));
        return "admin/user/adminUser";
    }
    
    @RequestMapping("user/block/{username}")
    public String blockUser(@PathVariable("username") String un,ModelMap model){
        if (aus.blockUser(un)) model.addAttribute("mess", "block thanh cong");
        else model.addAttribute("mess", "block that bai");
        
        return "redirect:/admin/user.htm";
    }
    
    @RequestMapping("user/unblock/{username}")
    public String unblockUser(@PathVariable("username") String un,ModelMap model){
        if (aus.unblockUser(un)) model.addAttribute("mess", "unblock thanh cong");
        else model.addAttribute("mess", "unblock that bai");
        
        return "redirect:/admin/user.htm";
    }
}
