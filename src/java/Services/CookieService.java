/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Long
 */
public class CookieService {
    public Cookie find(String id,HttpServletRequest request){
        Cookie[] list=request.getCookies();
        for (Cookie c:list){
            if (c.getName().equals(id)) return c;
        }
        return null;
    }
}
