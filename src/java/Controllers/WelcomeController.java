/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.Phim;
import Services.FileServices;
import Services.SearchService;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Long
 */
@Transactional
@Controller
@RequestMapping("welcome")
public class WelcomeController {
    @Autowired
    SessionFactory factory;
    @Autowired
    SearchService ss;
    @Autowired
    FileServices fs;
    @Autowired
    ServletContext context;
    
    @RequestMapping() 
    public String index(ModelMap model) throws IOException{
        String noibat="FROM Phim p ORDER BY p.diem DESC";

        List<Phim> noibatList=ss.listFilm(noibat, 4);
        model.addAttribute("noibat", noibatList);
        String filePath=context.getRealPath("/resources/text/"+noibatList.get(0).getMaphim()+"/"+noibatList.get(0).getTomtat());
        model.addAttribute("noibatPlot", fs.readTextFile(filePath).substring(0, 200));
        String dangchieu="FROM Phim p WHERE p.ngaychieu<=current_date() ORDER BY p.ngaychieu DESC";
        model.addAttribute("dangchieu", ss.listFilm(dangchieu, 3));
        String sapchieu="FROM Phim p WHERE p.ngaychieu>current_date() ORDER BY p.ngaychieu";
        model.addAttribute("sapchieu", ss.listFilm(sapchieu, 3));
        String hot="FROM Phim p ORDER BY p.luotbl DESC";
        model.addAttribute("hot", ss.listFilm(hot, 3));
        return "index";
    }
}
