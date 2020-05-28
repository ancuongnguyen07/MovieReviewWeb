/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Long
 */
@Entity
@Table(name = "BINHLUAN")
@NamedQueries({
    @NamedQuery(name = "Binhluan.findAll", query = "SELECT b FROM Binhluan b")})
public class Binhluan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOIDUNG")
    private String noidung;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DIEM")
    private double diem;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NGAYGIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngaygio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DUYET")
    private boolean duyet;
    @JoinColumn(name = "USERNAME", referencedColumnName = "USERNAME")
    @ManyToOne(optional = false)
    private Khangia user;
    @JoinColumn(name = "MANV", referencedColumnName = "MANV")
    @ManyToOne
    private Nhanvien nv;
    @JoinColumn(name = "MAPHIM", referencedColumnName = "MAPHIM")
    @ManyToOne(optional = false)
    private Phim phim;

    public Binhluan() {
    }

    public Binhluan(Integer id) {
        this.id = id;
    }

    public Binhluan(Integer id, String noidung, double diem, Date ngaygio, boolean duyet) {
        this.id = id;
        this.noidung = noidung;
        this.diem = diem;
        this.ngaygio = ngaygio;
        this.duyet = duyet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public double getDiem() {
        return diem;
    }

    public void setDiem(double diem) {
        this.diem = diem;
    }

    public Date getNgaygio() {
        return ngaygio;
    }

    public void setNgaygio(Date ngaygio) {
        this.ngaygio = ngaygio;
    }

    public boolean getDuyet() {
        return duyet;
    }

    public void setDuyet(boolean duyet) {
        this.duyet = duyet;
    }

    public Khangia getUser() {
        return user;
    }

    public void setUser(Khangia username) {
        this.user = username;
    }

    public Nhanvien getNv() {
        return nv;
    }

    public void setNv(Nhanvien manv) {
        this.nv = manv;
    }

    public Phim getPhim() {
        return phim;
    }

    public void setPhim(Phim maphim) {
        this.phim = maphim;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Binhluan)) {
            return false;
        }
        Binhluan other = (Binhluan) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Binhluan[ id=" + id + " ]";
    }
    
}
