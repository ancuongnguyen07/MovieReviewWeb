/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.Phim;
import Services.AdminPhimService;
import Services.PhimService;
import Services.SearchService;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Long
 */
@Controller
@Transactional
@RequestMapping("admin")
public class AdminControllerPhim {

    @Autowired
    SessionFactory factory;
    @Autowired
    AdminPhimService adService;
    @Autowired
    ServletContext context;
    @Autowired
    PhimService ps;
  
    @RequestMapping("phim")
    public String getAdminPhim(ModelMap model)
    {
        SearchService searchService = new SearchService();
        List<Phim> list = searchService.listFilm("From Phim",factory);
        model.addAttribute("list",list);
        return "admin/phim/adminPhim";
        
    }
    
    @RequestMapping("phim/delete/{maphim}")
    public String deletePhim(ModelMap model,@PathVariable("maphim")String maphim,HttpServletResponse res) 
    {
            System.out.println(maphim);
            adService.deletePhim(maphim);
            return "redirect:/admin/phim.htm";
    }

    @RequestMapping(value = "phim/addForm",method = RequestMethod.GET)
    public String addPhimForm(ModelMap model){
        model.addAttribute("phim", new Phim());
        return "admin/phim/adminPhimForm";
    }
    
    
    @RequestMapping(value = "phim/addForm",method = RequestMethod.POST)
    public String addPhim(ModelMap model,@Validated @ModelAttribute("phim") Phim movie,
                            BindingResult errors,
                            @RequestParam(value = "pic",required = false) MultipartFile photo,
                            @RequestParam(value = "plot",required = false) MultipartFile content
                            ){
        if (errors.hasFieldErrors()|| photo.isEmpty() || content.isEmpty()){
            model.addAttribute("mess", "loi nhap lieu");
            if (photo.isEmpty()) model.addAttribute("posterMessage", "Chua tai poster");
            if (content.isEmpty()) model.addAttribute("tomtatMessage", "Chua tai tom tat");
            //String fieldError=errors.getFieldError().toString();
            
            System.out.println(movie.getTen());
            return "admin/phim/adminPhimForm";
        }
        if (ps.isExist(movie.getMaphim(), factory)){
            model.addAttribute("dupMaphim", "Ma phim da ton tai!!!");
            return "admin/phim/adminPhimForm";
        }
        else{
            try {
                System.out.println("hihi");
                String maphim=movie.getMaphim().toUpperCase();
                adService.makePosterFile(maphim, photo);
                movie.setPoster(photo.getOriginalFilename());
                adService.makePlotFile(maphim, content);
                movie.setMaphim(maphim);
                movie.setTomtat(content.getOriginalFilename());
                movie.setLuotbl(0);
                movie.setTen(movie.getTen().toUpperCase());
                movie.setDienvien(movie.getDienvien().toUpperCase());
                movie.setDaodien(movie.getDaodien().toUpperCase());
                movie.setTheloai(movie.getTheloai().toUpperCase());
                adService.savePhim(movie);     
            } catch (Exception e) {
                model.addAttribute("mess", "Them phim that bai!!!");
                return "admin/phim/adminPhimForm";
            }
        }    
        return "redirect:/admin/phim.htm";
    }
    
    @RequestMapping("phim/updateForm/{maphim}")
    public String updatePhimForm(ModelMap model,@PathVariable("maphim")String maphim) 
    {
            Session se=factory.getCurrentSession();
            model.addAttribute("phim", (Phim)se.get(Phim.class, maphim));
            return "admin/phim/adminUpdatePhimForm";
    }
    /*
    */
    @RequestMapping("phim/updateForm/update")
    public String updatePhimmm(@ModelAttribute("phim") Phim movie,ModelMap model,
            @RequestParam(value = "picture",required = false) MultipartFile poster,
            @RequestParam(value = "content",required = false) MultipartFile textFile){
        if(adService.updatePhim(movie,poster,textFile)) model.addAttribute("mess", "thanh cong");
        else model.addAttribute("mess", "that bai");
        return "redirect:/admin/phim.htm";
    }
}
