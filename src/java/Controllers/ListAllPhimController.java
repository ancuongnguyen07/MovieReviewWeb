/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.Phim;
import Services.SearchService;
import java.util.List;
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
@RequestMapping("all")
public class ListAllPhimController {
    @Autowired
    SearchService ss;
    
    private long totalRecords;
    final int RECORDSHOW=6;
    final int ROWS=2;
    private long totalPages;
    
    @RequestMapping()
    public String loadPhim(){
        String countHql="SELECT count(p.maphim) FROM Phim p";
        this.totalRecords=ss.countTotalRecords(countHql);
        //System.out.println(totalRecords+"");
        if (this.totalRecords%this.RECORDSHOW==0){
            this.totalPages=this.totalRecords/this.RECORDSHOW;
        }
        else this.totalPages=this.totalRecords/this.RECORDSHOW+1;
        return "redirect:all/1.htm";
    }
    
    @RequestMapping("{numPage}")
    public String resultPages(ModelMap model,@PathVariable("numPage") int numPage){
        model.addAttribute("numPage", numPage);
        model.addAttribute("totalPages", this.totalPages);
        int start=(numPage-1)*this.RECORDSHOW;
        int itemsInRow=RECORDSHOW/ROWS;
        model.addAttribute("itemsInRow",itemsInRow);
        long numOfRows;
        if (start>=totalRecords) numOfRows=0;
        else {
            long temp=(totalRecords-start);
            if(temp>itemsInRow) numOfRows=ROWS;
            else numOfRows=1;
        }
        model.addAttribute("numOfRows", numOfRows);
        String hql="FROM Phim";
        model.addAttribute("moviesList",ss.listFilm(hql, start, RECORDSHOW));
        return "movie/AllList";
    }
}
