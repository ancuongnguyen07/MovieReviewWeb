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
public class CapnhatPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "MANV")
    private String manv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "MAPHIM")
    private String maphim;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NGAYGIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngaygio;

    public CapnhatPK() {
    }

    public CapnhatPK(String manv, String maphim, Date ngaygio) {
        this.manv = manv;
        this.maphim = maphim;
        this.ngaygio = ngaygio;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getMaphim() {
        return maphim;
    }

    public void setMaphim(String maphim) {
        this.maphim = maphim;
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
        hash += (manv != null ? manv.hashCode() : 0);
        hash += (maphim != null ? maphim.hashCode() : 0);
        hash += (ngaygio != null ? ngaygio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CapnhatPK)) {
            return false;
        }
        CapnhatPK other = (CapnhatPK) object;
        if ((this.manv == null && other.manv != null) || (this.manv != null && !this.manv.equals(other.manv))) {
            return false;
        }
        if ((this.maphim == null && other.maphim != null) || (this.maphim != null && !this.maphim.equals(other.maphim))) {
            return false;
        }
        if ((this.ngaygio == null && other.ngaygio != null) || (this.ngaygio != null && !this.ngaygio.equals(other.ngaygio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.CapnhatPK[ manv=" + manv + ", maphim=" + maphim + ", ngaygio=" + ngaygio + " ]";
    }
    
}
