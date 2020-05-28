/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.Phim;
import java.io.File;
import javax.servlet.ServletContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Long
 */
@Transactional
@Controller
@RequestMapping("movieMGR")
public class MovieMGRController {
    @Autowired
    ServletContext context;
    @Autowired
    SessionFactory factory;
    
    @RequestMapping("form")
    public String form(ModelMap model){
        model.addAttribute("movie", new Phim());
        return "movieMG/addMovie";
    }
    
    @RequestMapping("add")
    public String addMovie(ModelMap model,@ModelAttribute("movie") Phim movie,
                            @RequestParam("pic") MultipartFile photo){
        Session se=factory.openSession();
        Transaction t=se.beginTransaction();
        try {
            String folderFakePath="/resources/images/"+movie.getMaphim();
            String folderPath=context.getRealPath(folderFakePath);
            File folder=new File(folderPath);
            String status=(folder.mkdir())?"true":"false";
            
            String photoPath=context.getRealPath(folderFakePath+"/"+photo.getOriginalFilename());
            String p=context.getContextPath();
            photo.transferTo(new File(photoPath));
            movie.setPoster(photo.getOriginalFilename());
            se.save(movie);
            t.commit();
            model.addAttribute("mess", "successfully!");
            //model.addAttribute("photoPath", p);
        } catch (Exception e) {
            t.rollback();
            model.addAttribute("mess", "Failed");
        }finally{
            se.close();
        }
        return "user/signup/success";
    }
}