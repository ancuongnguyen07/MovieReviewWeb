/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author Long
 */
public class UserLoggerInterceptors extends HandlerInterceptorAdapter{
    @Override
    public boolean preHandle(HttpServletRequest request,HttpServletResponse response,
                            Object handler) throws Exception{
        HttpSession session=request.getSession();
        if (session.getAttribute("username")==null){
            response.sendRedirect(request.getContextPath()+"/login/form.htm");
            return false;
        }
        return true;
    }
    
}
