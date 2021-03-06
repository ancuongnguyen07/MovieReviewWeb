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
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Long
 */
@Embeddable
public class QuanlyPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "USERNAME")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "MANV")
    private String manv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NGAYGIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngaygio;

    public QuanlyPK() {
    }

    public QuanlyPK(String username, String manv, Date ngaygio) {
        this.username = username;
        this.manv = manv;
        this.ngaygio = ngaygio;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public Date getNgaygio() {
        return ngaygio;
    }

    public void setNgaygio(Date ngaygio) {
        this.ngaygio = ngaygio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        hash += (manv != null ? manv.hashCode() : 0);
        hash += (ngaygio != null ? ngaygio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QuanlyPK)) {
            return false;
        }
        QuanlyPK other = (QuanlyPK) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        if ((this.manv == null && other.manv != null) || (this.manv != null && !this.manv.equals(other.manv))) {
            return false;
        }
        if ((this.ngaygio == null && other.ngaygio != null) || (this.ngaygio != null && !this.ngaygio.equals(other.ngaygio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.QuanlyPK[ username=" + username + ", manv=" + manv + ", ngaygio=" + ngaygio + " ]";
    }
    
}
