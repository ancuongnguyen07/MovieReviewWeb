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
    SessionFactory factory;
    
    private int totalRecords;
    private int recordsShow;
    private int totalPages;
    private List<Phim> moviesList;
    
    @RequestMapping()
    public String search(@RequestParam("keySearch") String key,HttpSession session,
                        ModelMap model){
        session.removeAttribute("error");
        if (key.isBlank()){
            session.setAttribute("error", "Ban chua nhap ky tu!!!");
            return "redirect:/welcome.htm";
        }
        SearchService ss=new SearchService();
        String hql="FROM Phim p where p.ten LIKE '%"+key+"%'";
        this.moviesList=ss.listFilm(hql, factory);
        this.totalRecords=this.moviesList.size();
        if (this.totalRecords==0){
            model.addAttribute("emptyError","Khong tim thay ket qua!!!");
            return "movie/searchResults";
        }
        this.recordsShow=2; // default value
        if (this.totalRecords%this.recordsShow==0){
            this.totalPages=this.totalRecords/this.recordsShow;
        }
        else this.totalPages=this.totalRecords/this.recordsShow+1;
        session.setAttribute("moviesList", this.moviesList);
    
        return "redirect:search/"+key+"/1.htm";
    }
    
    @RequestMapping("{key}/{numPage}")
    public String resultPages(@PathVariable("key") String key,@PathVariable("numPage") int numPage,
                            ModelMap model,HttpSession session){
        model.addAttribute("numPage", numPage);
        model.addAttribute("totalPages", this.totalPages);
        int start=(numPage-1)*this.recordsShow;
        int end=start+recordsShow-1;
        model.addAttribute("start", start);
        model.addAttribute("end", end);
        model.addAttribute("key", key);
        return "movie/searchResults";
    }
    
    @ModelAttribute("pagesList")
    public List<Integer> list(HttpSession session){
        List<Integer> list = new ArrayList<>();
        for (int i=1;i<=this.totalPages;i++){
            list.add(i);
        }
        return list;
    }
}
