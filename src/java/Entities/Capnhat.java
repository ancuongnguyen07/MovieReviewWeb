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
@Table(name = "CAPNHAT")
@NamedQueries({
    @NamedQuery(name = "Capnhat.findAll", query = "SELECT c FROM Capnhat c")})
public class Capnhat implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CapnhatPK capnhatPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "NOIDUNG")
    private String noidung;
    @JoinColumn(name = "MANV", referencedColumnName = "MANV", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Nhanvien nhanvien;
    @JoinColumn(name = "MAPHIM", referencedColumnName = "MAPHIM", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Phim phim;

    public Capnhat() {
    }

    public Capnhat(CapnhatPK capnhatPK) {
        this.capnhatPK = capnhatPK;
    }

    public Capnhat(CapnhatPK capnhatPK, String noidung) {
        this.capnhatPK = capnhatPK;
        this.noidung = noidung;
    }

    public Capnhat(String manv, String maphim, Date ngaygio) {
        this.capnhatPK = new CapnhatPK(manv, maphim, ngaygio);
    }

    public CapnhatPK getCapnhatPK() {
        return capnhatPK;
    }

    public void setCapnhatPK(CapnhatPK capnhatPK) {
        this.capnhatPK = capnhatPK;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public Nhanvien getNhanvien() {
        return nhanvien;
    }

    public void setNhanvien(Nhanvien nhanvien) {
        this.nhanvien = nhanvien;
    }

    public Phim getPhim() {
        return phim;
    }

    public void setPhim(Phim phim) {
        this.phim = phim;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (capnhatPK != null ? capnhatPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Capnhat)) {
            return false;
        }
        Capnhat other = (Capnhat) object;
        if ((this.capnhatPK == null && other.capnhatPK != null) || (this.capnhatPK != null && !this.capnhatPK.equals(other.capnhatPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Capnhat[ capnhatPK=" + capnhatPK + " ]";
    }
    
}
