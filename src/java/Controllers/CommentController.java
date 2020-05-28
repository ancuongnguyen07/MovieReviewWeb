/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.Binhluan;

import Entities.Khangia;
import Entities.Phim;
import Services.BlService;
import java.util.Date;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Long
 */
@Controller
@RequestMapping("user/comment")
public class CommentController {
    @Autowired
    BlService sevice;
    @Autowired
    SessionFactory factory;
    
    @RequestMapping(value = "{maphim}",method = RequestMethod.POST)
    public String comment(@Validated @ModelAttribute("bl") Binhluan comment,BindingResult error,
                            ModelMap model,@PathVariable("maphim") String maphim,HttpSession session){
        if (error.hasFieldErrors("diem") || error.hasFieldErrors("noidung")){
            model.addAttribute("mess", "Con loi!!!!"); 
        }
        else{
            Session se=factory.openSession();
            comment.setDuyet(false);
            comment.setPhim((Phim)se.get(Phim.class, maphim));
            comment.setNgaygio(new Date());
            comment.setUser((Khangia)session.getAttribute("username"));
            se.close();
            sevice.saveBl(comment);
            //sevice.updatePhim_Bl(maphim, comment);
        }
        return "redirect:/movies/"+maphim+".htm";
    }
}
