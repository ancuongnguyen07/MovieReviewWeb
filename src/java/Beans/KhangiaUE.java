/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;
// tao ra de dung validate (phan recover pass) vi khi dung entity Khangia
// Yeu cau phai nhap het tat ca cac field trong khi tinh huong nay chi can

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

// 2 field la username va email
/**
 *
 * @author Long
 */
public class KhangiaUE {
    
    @NotBlank(message = "Khong duoc de trong")
    private String username;
    @NotBlank(message = "Khong duoc de trong")
    @Email(message = "Khong dung dinh dang email")
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
