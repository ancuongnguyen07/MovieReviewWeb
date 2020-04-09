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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Long
 */
@Entity
@Table(name = "BINHLUAN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Binhluan.findAll", query = "SELECT b FROM Binhluan b"),
    @NamedQuery(name = "Binhluan.findByMaphim", query = "SELECT b FROM Binhluan b WHERE b.binhluanPK.maphim = :maphim"),
    @NamedQuery(name = "Binhluan.findByUsername", query = "SELECT b FROM Binhluan b WHERE b.binhluanPK.username = :username"),
    @NamedQuery(name = "Binhluan.findByManv", query = "SELECT b FROM Binhluan b WHERE b.binhluanPK.manv = :manv"),
    @NamedQuery(name = "Binhluan.findByNoidung", query = "SELECT b FROM Binhluan b WHERE b.noidung = :noidung"),
    @NamedQuery(name = "Binhluan.findByDiem", query = "SELECT b FROM Binhluan b WHERE b.diem = :diem"),
    @NamedQuery(name = "Binhluan.findByLuotlike", query = "SELECT b FROM Binhluan b WHERE b.luotlike = :luotlike"),
    @NamedQuery(name = "Binhluan.findByNgaygio", query = "SELECT b FROM Binhluan b WHERE b.binhluanPK.ngaygio = :ngaygio")})
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
    @Column(name = "LUOTLIKE")
    private int luotlike;
    @JoinColumn(name = "USERNAME", referencedColumnName = "USERNAME", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Khangia khangia;
    @JoinColumn(name = "MANV", referencedColumnName = "MANV", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Nhanvien nhanvien;
    @JoinColumn(name = "MAPHIM", referencedColumnName = "MAPHIM", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Phim phim;

    public Binhluan() {
    }

    public Binhluan(BinhluanPK binhluanPK) {
        this.binhluanPK = binhluanPK;
    }

    public Binhluan(BinhluanPK binhluanPK, String noidung, double diem, int luotlike) {
        this.binhluanPK = binhluanPK;
        this.noidung = noidung;
        this.diem = diem;
        this.luotlike = luotlike;
    }

    public Binhluan(String maphim, String username, String manv, Date ngaygio) {
        this.binhluanPK = new BinhluanPK(maphim, username, manv, ngaygio);
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

    public int getLuotlike() {
        return luotlike;
    }

    public void setLuotlike(int luotlike) {
        this.luotlike = luotlike;
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
