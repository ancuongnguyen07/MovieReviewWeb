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
@Table(name = "BINHLUAN")
@NamedQueries({
    @NamedQuery(name = "Binhluan.findAll", query = "SELECT b FROM Binhluan b")})
public class Binhluan implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BinhluanPK binhluanPK;
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
    @Column(name = "DUYET")
    private boolean duyet;
    @JoinColumn(name = "USERNAME", referencedColumnName = "USERNAME", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Khangia khangia;
    @JoinColumn(name = "MANV", referencedColumnName = "MANV")
    @ManyToOne
    private Nhanvien manv;
    @JoinColumn(name = "MAPHIM", referencedColumnName = "MAPHIM", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Phim phim;

    public Binhluan() {
    }

    public Binhluan(BinhluanPK binhluanPK) {
        this.binhluanPK = binhluanPK;
    }

    public Binhluan(BinhluanPK binhluanPK, String noidung, double diem, boolean duyet) {
        this.binhluanPK = binhluanPK;
        this.noidung = noidung;
        this.diem = diem;
        this.duyet = duyet;
    }

    public Binhluan(String maphim, String username, Date ngaygio) {
        this.binhluanPK = new BinhluanPK(maphim, username, ngaygio);
    }

    public BinhluanPK getBinhluanPK() {
        return binhluanPK;
    }

    public void setBinhluanPK(BinhluanPK binhluanPK) {
        this.binhluanPK = binhluanPK;
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

    public boolean getDuyet() {
        return duyet;
    }

    public void setDuyet(boolean duyet) {
        this.duyet = duyet;
    }

    public Khangia getKhangia() {
        return khangia;
    }

    public void setKhangia(Khangia khangia) {
        this.khangia = khangia;
    }

    public Nhanvien getManv() {
        return manv;
    }

    public void setManv(Nhanvien manv) {
        this.manv = manv;
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
        hash += (binhluanPK != null ? binhluanPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Binhluan)) {
            return false;
        }
        Binhluan other = (Binhluan) object;
        if ((this.binhluanPK == null && other.binhluanPK != null) || (this.binhluanPK != null && !this.binhluanPK.equals(other.binhluanPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Binhluan[ binhluanPK=" + binhluanPK + " ]";
    }
    
}
