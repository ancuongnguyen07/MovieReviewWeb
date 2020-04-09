/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.Binhluan;
import Entities.Phim;
import Services.FileServices;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
      
    @RequestMapping("validate")
    public String validate(ModelMap model){
        
        return "";
    }
    
    
    @RequestMapping("{maphim}")
    public String xxx(@PathVariable("maphim") String maphim,
                        @RequestParam(value = "score",required = false) Double score,
                        HttpServletRequest request,HttpSession session, ModelMap model){
        Session se=factory.openSession();
        Transaction t=se.beginTransaction();
        Phim movie=(Phim) se.get(Phim.class, maphim);
        
        // hien noi dung tom tat
        String filePath="E:\\Java\\WEB\\Demo\\MovieReviewWeb\\web\\resources\\text\\"+maphim+"\\tomtat1.txt";        
        FileServices fs=new FileServices();
        try {
            model.addAttribute("plot", fs.readTextFile(filePath));
        } catch (IOException ex) {
            Logger.getLogger(MovieController.class.getName()).log(Level.SEVERE, null, ex);
        }
        model.addAttribute("movie", movie);
                
        model.addAttribute("bl", new Binhluan());
        
        // load danh sach binh luan
        String hql="SELECT diem,noidung FROM Binhluan bl WHERE bl.binhluanPK.maphim='"+maphim+
                    "' ORDER BY bl.binhluanPK.ngaygio DESC";
        Query query=se.createQuery(hql);
        List<Binhluan> listBl=query.list();
        model.addAttribute("listBl", listBl);
        session.setAttribute("maphim", maphim);
        return "movie/info";
    }
    
    @ModelAttribute("scoreList")
    public List<Double> sl(){
        List<Double> list=new ArrayList<>();
        for (double i=0;i<=10;i+=0.5) list.add(i);
        return list;
    }
}