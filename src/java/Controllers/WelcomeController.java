/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.Phim;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Long
 */
@Transactional
@Controller
@RequestMapping("welcome")
public class WelcomeController {
    @Autowired
    SessionFactory factory;
    
    @RequestMapping() 
    public String index(ModelMap model){
        Session se=factory.getCurrentSession();
        // Chi chon lua n phim de trinh chieu khong chon het
        String hql="FROM Phim p ORDER BY p.ngaychieu DESC";
        Query query=se.createQuery(hql);
        List<Phim> list=query.list();
        model.addAttribute("movies", list);
        model.addAttribute("message", "12345");
        return "index";
    }
}
