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
    SessionFactory factory;
    
    private int totalRecords;
    final int RECORDSHOW=6;
    final int ROWS=2;
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
        /*String hql="FROM Phim p where p.ten LIKE '%"+key+"%'";
        this.moviesList=ss.listFilm(hql,factory);*/
        Session se=factory.openSession();

        this.moviesList=se.createQuery("FROM Phim p WHERE p.ten LIKE :name").setParameter("name", "%"+key+"%").list();
        se.close();
        this.totalRecords=this.moviesList.size();
        if (this.totalRecords==0){
            model.addAttribute("emptyError","Không tìm thấy kết quả!!!");
            model.addAttribute("key", key);
            return "movie/searchResults";
        }
        //this.recordsShow=2; // default value
        if (this.totalRecords%this.RECORDSHOW==0){
            this.totalPages=this.totalRecords/this.RECORDSHOW;
        }
        else this.totalPages=this.totalRecords/this.RECORDSHOW+1;
        session.setAttribute("moviesList", this.moviesList);
        return "redirect:search/"+key+"/1.htm";
    }
    
    @RequestMapping("{key}/{numPage}")
    public String resultPages(@PathVariable("key") String key,@PathVariable("numPage") int numPage,
                            ModelMap model){
        model.addAttribute("numPage", numPage);
        model.addAttribute("totalPages", this.totalPages);
        model.addAttribute("totalRecords", totalRecords);
        int start=(numPage-1)*this.RECORDSHOW;
        int end=start+RECORDSHOW-1;
        model.addAttribute("start", start);
        model.addAttribute("itemsInRow", RECORDSHOW/ROWS);
        model.addAttribute("key", key);
        int numOfRows;
        if (start>totalRecords) numOfRows=0;
        else {
            numOfRows=(totalRecords-start)/(RECORDSHOW/ROWS);
            if ((totalRecords-start)%(RECORDSHOW/ROWS)>0) numOfRows+=1;
        }
        model.addAttribute("numOfRows", numOfRows);
        return "movie/searchResults";
    }
    
    
    private List<Integer> listRows(int numOfRows){
        List<Integer> list = new ArrayList<>();
        for (int i=1;i<=numOfRows;i++){
            list.add(i);
        }
        return list;
    }
}
