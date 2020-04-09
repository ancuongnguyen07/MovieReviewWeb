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
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Long
 */
@Entity
@Table(name = "KHANGIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Khangia.findAll", query = "SELECT k FROM Khangia k"),
    @NamedQuery(name = "Khangia.findByUsername", query = "SELECT k FROM Khangia k WHERE k.username = :username"),
    @NamedQuery(name = "Khangia.findByHo", query = "SELECT k FROM Khangia k WHERE k.ho = :ho"),
    @NamedQuery(name = "Khangia.findByTen", query = "SELECT k FROM Khangia k WHERE k.ten = :ten"),
    @NamedQuery(name = "Khangia.findByEmail", query = "SELECT k FROM Khangia k WHERE k.email = :email"),
    @NamedQuery(name = "Khangia.findByGioitinh", query = "SELECT k FROM Khangia k WHERE k.gioitinh = :gioitinh"),
    @NamedQuery(name = "Khangia.findBySdt", query = "SELECT k FROM Khangia k WHERE k.sdt = :sdt"),
    @NamedQuery(name = "Khangia.findByPassword", query = "SELECT k FROM Khangia k WHERE k.password = :password")})
public class Khangia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "USERNAME")
    @NotBlank(message = "Khong duoc de trong")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "HO")
    @NotBlank(message = "Khong duoc de trong")
    private String ho;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TEN")
    @NotBlank(message = "Khong duoc de trong")
    private String ten;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "EMAIL")
    @Email(message = "Khong dung dinh dang email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "GIOITINH")
    private boolean gioitinh;
    @Size(max = 15)
    @Column(name = "SDT")
    @NotBlank(message = "khong duoc de trong!!!")
    @Pattern(regexp = "0[0-9]{9}",message = "Khong dung dinh dang sdt")
    private String sdt;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PASSWORD")
    @NotBlank(message = "Khong duoc de trong")
    private String password;
    @JoinTable(name = "YEUTHICH", joinColumns = {
        @JoinColumn(name = "USERNAME", referencedColumnName = "USERNAME")}, inverseJoinColumns = {
        @JoinColumn(name = "MAPHIM", referencedColumnName = "MAPHIM")})
    @ManyToMany
    private List<Phim> phimList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "khangia")
    private List<Quanly> quanlyList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "khangia")
    private List<Binhluan> binhluanList;

    public Khangia() {
    }

    public Khangia(String username) {
        this.username = username;
    }

    public Khangia(String username, String ho, String ten, String email, boolean gioitinh, String password) {
        this.username = username;
        this.ho = ho;
        this.ten = ten;
        this.email = email;
        this.gioitinh = gioitinh;
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

    public boolean getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(boolean gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public List<Phim> getPhimList() {
        return phimList;
    }

    public void setPhimList(List<Phim> phimList) {
        this.phimList = phimList;
    }

    @XmlTransient
    public List<Quanly> getQuanlyList() {
        return quanlyList;
    }

    public void setQuanlyList(List<Quanly> quanlyList) {
        this.quanlyList = quanlyList;
    }

    @XmlTransient
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
