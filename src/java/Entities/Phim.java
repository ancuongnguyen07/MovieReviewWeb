/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "PHIM")
@NamedQueries({
    @NamedQuery(name = "Phim.findAll", query = "SELECT p FROM Phim p")})
public class Phim implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "MAPHIM")
    private String maphim;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TEN")
    private String ten;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DIENVIEN")
    private String dienvien;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DAODIEN")
    private String daodien;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NGAYCHIEU")
    @Temporal(TemporalType.DATE)
    private Date ngaychieu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "THOILUONG")
    private int thoiluong;
    @Basic(optional = false)
    @NotNull
    @Column(name = "GIOIHANDOTUOI")
    private int gioihandotuoi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DIEM")
    private double diem;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TRAILER")
    private String trailer;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "POSTER")
    private String poster;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TOMTAT")
    private String tomtat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "THELOAI")
    private String theloai;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LUOTBL")
    private int luotbl;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "phim")
    private List<Capnhat> capnhatList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "phim")
    private List<Binhluan> binhluanList;

    public Phim() {
    }

    public Phim(String maphim) {
        this.maphim = maphim;
    }

    public Phim(String maphim, String ten, String dienvien, String daodien, Date ngaychieu, int thoiluong, int gioihandotuoi, double diem, String trailer, String poster, String tomtat, String theloai, int luotbl) {
        this.maphim = maphim;
        this.ten = ten;
        this.dienvien = dienvien;
        this.daodien = daodien;
        this.ngaychieu = ngaychieu;
        this.thoiluong = thoiluong;
        this.gioihandotuoi = gioihandotuoi;
        this.diem = diem;
        this.trailer = trailer;
        this.poster = poster;
        this.tomtat = tomtat;
        this.theloai = theloai;
        this.luotbl = luotbl;
    }

    public String getMaphim() {
        return maphim;
    }

    public void setMaphim(String maphim) {
        this.maphim = maphim;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDienvien() {
        return dienvien;
    }

    public void setDienvien(String dienvien) {
        this.dienvien = dienvien;
    }

    public String getDaodien() {
        return daodien;
    }

    public void setDaodien(String daodien) {
        this.daodien = daodien;
    }

    public Date getNgaychieu() {
        return ngaychieu;
    }

    public void setNgaychieu(Date ngaychieu) {
        this.ngaychieu = ngaychieu;
    }

    public int getThoiluong() {
        return thoiluong;
    }

    public void setThoiluong(int thoiluong) {
        this.thoiluong = thoiluong;
    }

    public int getGioihandotuoi() {
        return gioihandotuoi;
    }

    public void setGioihandotuoi(int gioihandotuoi) {
        this.gioihandotuoi = gioihandotuoi;
    }

    public double getDiem() {
        return diem;
    }

    public void setDiem(double diem) {
        this.diem = diem;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getTomtat() {
        return tomtat;
    }

    public void setTomtat(String tomtat) {
        this.tomtat = tomtat;
    }

    public String getTheloai() {
        return theloai;
    }

    public void setTheloai(String theloai) {
        this.theloai = theloai;
    }

    public int getLuotbl() {
        return luotbl;
    }

    public void setLuotbl(int luotbl) {
        this.luotbl = luotbl;
    }

    public List<Capnhat> getCapnhatList() {
        return capnhatList;
    }

    public void setCapnhatList(List<Capnhat> capnhatList) {
        this.capnhatList = capnhatList;
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
        hash += (maphim != null ? maphim.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Phim)) {
            return false;
        }
        Phim other = (Phim) object;
        if ((this.maphim == null && other.maphim != null) || (this.maphim != null && !this.maphim.equals(other.maphim))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Phim[ maphim=" + maphim + " ]";
    }
    
}
