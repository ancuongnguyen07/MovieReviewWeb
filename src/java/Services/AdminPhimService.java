/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Phim;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Long
 */
@Service
@Transactional
public class AdminPhimService {
    @Autowired
    SessionFactory factory;
    @Autowired
    ServletContext context;
    
    final static String POSTERPATH="/resources/images/";
    final static String PLOTPATH="/resources/text/";
    
    public void deletePhim(String id)
    {
        Session se=factory.openSession();
        Transaction t=se.beginTransaction();
        try {
            se.delete((Phim)se.get(Phim.class, id));
            t.commit();
        } catch (Exception e) {
            t.rollback();
        }finally{
            se.close();
        }
        
    }
  
	
    public void savePhim(Phim phim,MultipartFile photo,MultipartFile content)
    {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            String maphim=phim.getMaphim();
            phim.setMaphim(maphim.toUpperCase());
            phim.setTen(phim.getTen().toUpperCase());
            phim.setDienvien(phim.getDienvien().toUpperCase());
            phim.setDaodien(phim.getDaodien().toUpperCase());
            phim.setTheloai(phim.getTheloai().toUpperCase());
            phim.setLuotbl(0);
            makePosterFile(maphim, photo);
            phim.setPoster(photo.getOriginalFilename());
            makePlotFile(maphim, content);
            phim.setMaphim(maphim);
            phim.setTomtat(content.getOriginalFilename());
            session.save(phim);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
        finally {
            session.close();
        }
    }
    
    public boolean updatePhim(Phim phim,MultipartFile photo,MultipartFile textFile){
        Session se=factory.openSession();
        Transaction t=se.beginTransaction();
        String maphim=phim.getMaphim();
        try {
            Phim x=(Phim) se.get(Phim.class, maphim);
            x.setTen(phim.getTen().toUpperCase());
            x.setDaodien(phim.getDaodien().toUpperCase());
            x.setDiem(phim.getDiem());
            x.setGioihandotuoi(phim.getGioihandotuoi());
            x.setDienvien(phim.getDienvien().toUpperCase());
            x.setNgaychieu(phim.getNgaychieu());
            //poster
            if (!photo.isEmpty()){
                createPosterFile(POSTERPATH+maphim, photo);
                x.setPoster(photo.getOriginalFilename());}
            
            //tomtat
            if (!textFile.isEmpty()){
                createPlotFile(PLOTPATH+maphim, textFile);
                x.setTomtat(textFile.getOriginalFilename());}
            
            x.setTrailer(phim.getTrailer());
            x.setTheloai(phim.getTheloai().toUpperCase());
            x.setThoiluong(phim.getThoiluong());
            se.update(x);
            t.commit();
            
        } catch (Exception e) {
            t.rollback();
            return false;
        }finally{
            se.close();
        }
        return true;
    }
    
    public void createPosterFile(String path,MultipartFile photo) throws IOException{
        String photoPath=context.getRealPath(path+"/"+photo.getOriginalFilename());
        String p=context.getContextPath();
        photo.transferTo(new File(photoPath));
    }
    
    public void makePosterFile(String maphim,MultipartFile poster) throws IOException{
        String folderPosterFakePath=POSTERPATH+maphim;
        String folderPosterPath=context.getRealPath(folderPosterFakePath);
        File folderPoster=new File(folderPosterPath);
        folderPoster.mkdir();

        createPosterFile(folderPosterFakePath, poster);
    }
    
    public void createPlotFile(String path,MultipartFile textFile) throws IOException{
        String plotPath=context.getRealPath(path+"/"+textFile.getOriginalFilename());
        String p=context.getContextPath();
        textFile.transferTo(new File(plotPath));
    }
    
    public void makePlotFile(String maphim,MultipartFile textFile) throws IOException{
        String folderPlotFakePath=PLOTPATH+maphim;
        String folderPlotPath=context.getRealPath(folderPlotFakePath);
        File folderPlot=new File(folderPlotPath);
        folderPlot.mkdir();

        createPlotFile(folderPlotFakePath, textFile);
    }
}
