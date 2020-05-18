/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Long
 */
@Entity
@Table(name = "KHANGIA")
@NamedQueries({
    @NamedQuery(name = "Khangia.findAll", query = "SELECT k FROM Khangia k")})
public class Khangia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "USERNAME")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "HO")
    private String ho;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TEN")
    private String ten;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "TRANGTHAI")
    private boolean trangthai;
    @JoinTable(name = "YEUTHICH", joinColumns = {
        @JoinColumn(name = "USERNAME", referencedColumnName = "USERNAME")}, inverseJoinColumns = {
        @JoinColumn(name = "MAPHIM", referencedColumnName = "MAPHIM")})
    @ManyToMany
    private List<Phim> phimList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "khangia")
    private List<Quanly> quanlyList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Binhluan> binhluanList;

    public Khangia() {
    }

    public Khangia(String username) {
        this.username = username;
    }

    public Khangia(String username, String ho, String ten, String email, String password) {
        this.username = username;
        this.ho = ho;
        this.ten = ten;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(boolean trangthai) {
        this.trangthai = trangthai;
    }

    public List<Phim> getPhimList() {
        return phimList;
    }

    public void setPhimList(List<Phim> phimList) {
        this.phimList = phimList;
    }

    public List<Quanly> getQuanlyList() {
        return quanlyList;
    }

    public void setQuanlyList(List<Quanly> quanlyList) {
        this.quanlyList = quanlyList;
    }

    public List<Binhluan> getBinhluanList() {
        return binhluanList;
    }

    public void setBinhluanList(List<Binhluan> binhluanList) {
        this.binhluanList = binhluanList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Khangia)) {
            return false;
        }
        Khangia other = (Khangia) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Khangia[ username=" + username + " ]";
    }
    
}
