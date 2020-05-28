/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.Binhluan;
import Entities.Phim;
import Services.BlService;
import Services.FileServices;
import Services.SearchService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Long
 */
@Transactional
@Controller
@RequestMapping("/movies/")
public class MovieController {
    @Autowired
    SessionFactory factory;
    @Autowired
    ServletContext context;
    @Autowired
    SearchService ss;
    
    @RequestMapping("{maphim}")
    public String xxx(@PathVariable("maphim") String maphim,
                        @RequestParam(value = "score",required = false) Double score,
                        HttpServletRequest request,HttpSession session, ModelMap model){
        Session se=factory.openSession();
        Phim movie=(Phim) se.get(Phim.class, maphim);
        
        // hien noi dung tom tat
        //String filePath="E:\\Java\\WEB\\Demo\\MovieReviewWeb\\web\\resources\\text\\"+maphim+"\\tomtat1.txt";  
        String filePath=context.getRealPath("/resources/text/"+movie.getMaphim()+"/"+movie.getTomtat());
        FileServices fs=new FileServices();
        try {
            model.addAttribute("plot", fs.readTextFile(filePath));
        } catch (IOException ex) {
            Logger.getLogger(MovieController.class.getName()).log(Level.SEVERE, null, ex);
        }
        model.addAttribute("movie", movie);
        
        // load danh sach binh luan
        String hql="FROM Binhluan bl WHERE bl.phim.maphim='"+maphim+           
                    "' AND bl.duyet=true ORDER BY bl.ngaygio DESC";
        model.addAttribute("listBl", ss.listBl(hql));
        model.addAttribute("bl", new Binhluan());
        //session.setAttribute("maphim", maphim);
        return "movie/info";
    }
    
    // hien danh sach diem 
    @ModelAttribute("scoreList")
    public List<Double> sl(){
        List<Double> list=new ArrayList<>();
        for (double i=0;i<=10;i+=0.5) list.add(i);
        return list;
    }
    
    
}
