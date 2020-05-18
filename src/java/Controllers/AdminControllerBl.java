/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.Binhluan;
import Services.AdminBlService;
import Services.BlService;
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
public class AdminControllerBl {
    @Autowired
    SessionFactory factory;
    @Autowired
    SearchService ss;
    @Autowired
    AdminBlService abs;
    
    private long totalRecords;
    final int RECORDSHOW=5;
    //final int ROWS=2;
    private long totalPages;

    
    @RequestMapping("bl")
    public String listBl(ModelMap model){
        this.totalRecords=ss.countTotalRecords("SELECT count(bl.id) FROM Binhluan bl WHERE bl.duyet=false");
        if (this.totalRecords%this.RECORDSHOW==0){
            this.totalPages=this.totalRecords/this.RECORDSHOW;
        }
        else this.totalPages=this.totalRecords/this.RECORDSHOW+1;
        System.out.println(this.totalRecords+"");
        return "redirect:/admin/bl/1.htm";
    }
    
    @RequestMapping("bl/{numPage}")
    public String listBlPagination(ModelMap model,@PathVariable("numPage") int numPage){
        model.addAttribute("numPage", numPage);
        model.addAttribute("totalPages", this.totalPages);
        int start=(numPage-1)*this.RECORDSHOW;
        model.addAttribute("blListAdmin", ss.listBl("FROM Binhluan bl WHERE bl.duyet=false", start, this.RECORDSHOW));
        return "admin/bl/adminBl";
    }
    
    @RequestMapping("bl/duyet/{blId}")
    public String duyetBl(@PathVariable("blId") Integer id,ModelMap model){
        if(abs.duyetBl(id)) model.addAttribute("mess", "Duyet thanh cong!!!");
        else model.addAttribute("mess", "Duyet that bai!!!");
        return "redirect:/admin/bl.htm";
    }
    
    @RequestMapping("bl/xoa/{blId}")
    public String xoaBl(@PathVariable("blId") Integer id,ModelMap model){
        if (abs.xoaBl(id)) model.addAttribute("mess", "Xoa thanh cong!!!");
        else model.addAttribute("mess", "Xoa that bai!!!");
        return "redirect:/admin/bl.htm";
    }
}
