/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.Khangia;

import Services.SearchService;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
    @RequestMapping("user")
    public String getAdminPhim(ModelMap model)
    {
        SearchService searchService = new SearchService();
        List<Khangia> list = searchService.listUser("From Khangia",factory);
        //System.out.println(list);
        model.addAttribute("list",list);
        return "admin/user/adminUser";
        
    }
}
