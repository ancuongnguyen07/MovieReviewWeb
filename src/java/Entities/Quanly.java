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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Long
 */
@Entity
@Table(name = "QUANLY")
@NamedQueries({
    @NamedQuery(name = "Quanly.findAll", query = "SELECT q FROM Quanly q")})
public class Quanly implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected QuanlyPK quanlyPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "NOIDUNG")
    private String noidung;
    @JoinColumn(name = "USERNAME", referencedColumnName = "USERNAME", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Khangia khangia;
    @JoinColumn(name = "MANV", referencedColumnName = "MANV", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Nhanvien nhanvien;

    public Quanly() {
    }

    public Quanly(QuanlyPK quanlyPK) {
        this.quanlyPK = quanlyPK;
    }

    public Quanly(QuanlyPK quanlyPK, String noidung) {
        this.quanlyPK = quanlyPK;
        this.noidung = noidung;
    }

    public Quanly(String username, String manv, Date ngaygio) {
        this.quanlyPK = new QuanlyPK(username, manv, ngaygio);
    }

    public QuanlyPK getQuanlyPK() {
        return quanlyPK;
    }

    public void setQuanlyPK(QuanlyPK quanlyPK) {
        this.quanlyPK = quanlyPK;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public Khangia getKhangia() {
        return khangia;
    }

    public void setKhangia(Khangia khangia) {
        this.khangia = khangia;
    }

    public Nhanvien getNhanvien() {
        return nhanvien;
    }

    public void setNhanvien(Nhanvien nhanvien) {
        this.nhanvien = nhanvien;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (quanlyPK != null ? quanlyPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Quanly)) {
            return false;
        }
        Quanly other = (Quanly) object;
        if ((this.quanlyPK == null && other.quanlyPK != null) || (this.quanlyPK != null && !this.quanlyPK.equals(other.quanlyPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Quanly[ quanlyPK=" + quanlyPK + " ]";
    }
    
}
