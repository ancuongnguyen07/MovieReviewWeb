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

import java.util.List;
import javax.servlet.ServletContext;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

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
    @Autowired
    SearchService ss;
    
    private long totalRecords;
    final int RECORDSHOW=5;
    //final int ROWS=2;
    private long totalPages;
  
    @RequestMapping("phim")
    public String getAdminPhim(ModelMap model)
    {
        this.totalRecords=ss.countTotalRecords("SELECT count(p.maphim) FROM Phim p");
        if (this.totalRecords%this.RECORDSHOW==0){
            this.totalPages=this.totalRecords/this.RECORDSHOW;
        }
        else this.totalPages=this.totalRecords/this.RECORDSHOW+1;
        return "redirect:/admin/phim/1.htm";
    }
    
    @RequestMapping("phim/{numPage}")
    public String listPhimPagination(ModelMap model,@PathVariable("numPage") int numPage){
        model.addAttribute("numPage", numPage);
        model.addAttribute("totalPages", this.totalPages);
        int start=(numPage-1)*this.RECORDSHOW;
        model.addAttribute("phimListAdmin", ss.listFilm("FROM Phim", start, this.RECORDSHOW));
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
            
            //System.out.println(movie.getTen());
            return "admin/phim/adminPhimForm";
        }
        if (ps.isExist(movie.getMaphim(), factory)){
            model.addAttribute("dupMaphim", "Ma phim da ton tai!!!");
            return "admin/phim/adminPhimForm";
        }
        else{
            try {
                System.out.println("hihi");
                adService.savePhim(movie,photo,content);     
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
    @RequestMapping("phim/update")
    public String updatePhimmm(@Validated @ModelAttribute("phim") Phim movie,
            BindingResult errors,ModelMap model,
            @RequestParam(value = "picture",required = false) MultipartFile poster,
            @RequestParam(value = "content",required = false) MultipartFile textFile){
        if (errors.hasFieldErrors("ten") || errors.hasFieldErrors("dienvien") || errors.hasFieldErrors("daodien")
            || errors.hasFieldErrors("ngaychieu") || errors.hasFieldErrors("gioihandotuoi") || errors.hasFieldErrors("thoiluong")
            || errors.hasFieldErrors("diem") || errors.hasFieldErrors("theloai") || errors.hasFieldErrors("trailer")){
            model.addAttribute("mess","loi validate");
            System.out.println(errors.getFieldError().toString());
        }
        else{
            if(adService.updatePhim(movie,poster,textFile)) model.addAttribute("mess", "thanh cong");
            else model.addAttribute("mess", "that bai");
        }
        
        return "redirect:/admin/phim.htm";
    }
}
