/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.Phim;
import Services.SearchService;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Long
 */
@Controller
@RequestMapping("search")
public class SearchController {
    @Autowired
    SearchService ss;
    
    private long totalRecords;
    final int RECORDSHOW=6;
    final int ROWS=2;
    private long totalPages;
    
    @RequestMapping()
    public String search(@RequestParam("keySearch") String key,
                        ModelMap model){
        if (key.isBlank()){
            //session.setAttribute("error", "Ban chua nhap ky tu!!!");
            return "redirect:/welcome.htm";
        }
        
        String countHql="SELECT count(p.maphim) FROM Phim p WHERE p.ten LIKE'%"+key+"%'";
        this.totalRecords=ss.countTotalRecords(countHql);
        /*Session se=factory.openSession();

        this.moviesList=se.createQuery("FROM Phim p WHERE p.ten LIKE :name").setParameter("name", "%"+key+"%").list();
        se.close();*/
        if (this.totalRecords==0){
            model.addAttribute("emptyError","Không tìm thấy kết quả!!!");
            model.addAttribute("key", key);
            return "movie/searchResults";
        }
        if (this.totalRecords%this.RECORDSHOW==0){
            this.totalPages=this.totalRecords/this.RECORDSHOW;
        }
        else this.totalPages=this.totalRecords/this.RECORDSHOW+1;
        return "redirect:search/"+key+"/1.htm";
    }
    
    @RequestMapping("{key}/{numPage}")
    public String resultPages(@PathVariable("key") String key,@PathVariable("numPage") int numPage,
                            ModelMap model){
        model.addAttribute("numPage", numPage);
        model.addAttribute("totalPages", this.totalPages);
        int start=(numPage-1)*this.RECORDSHOW;
        int itemsInRow=RECORDSHOW/ROWS;
        model.addAttribute("itemsInRow", itemsInRow);
        model.addAttribute("key", key);
        long numOfRows;
        if (start>=totalRecords) numOfRows=0;
        else {
            long temp=(totalRecords-start);
            if(temp>itemsInRow) numOfRows=ROWS;
            else numOfRows=1;
        }
        model.addAttribute("numOfRows", numOfRows);
        String hql="FROM Phim p WHERE p.ten LIKE'%"+key+"%'";
        model.addAttribute("moviesList",ss.listFilm(hql, start, RECORDSHOW));
        return "movie/searchResults";
    }
    
    
}
