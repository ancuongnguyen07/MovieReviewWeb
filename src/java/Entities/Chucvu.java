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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Long
 */
@Entity
@Table(name = "CHUCVU")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chucvu.findAll", query = "SELECT c FROM Chucvu c"),
    @NamedQuery(name = "Chucvu.findByMachucvu", query = "SELECT c FROM Chucvu c WHERE c.machucvu = :machucvu"),
    @NamedQuery(name = "Chucvu.findByVitri", query = "SELECT c FROM Chucvu c WHERE c.vitri = :vitri")})
public class Chucvu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "MACHUCVU")
    private String machucvu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "VITRI")
    private String vitri;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "machucvu")
    private List<Nhanvien> nhanvienList;

    public Chucvu() {
    }

    public Chucvu(String machucvu) {
        this.machucvu = machucvu;
    }

    public Chucvu(String machucvu, String vitri) {
        this.machucvu = machucvu;
        this.vitri = vitri;
    }

    public String getMachucvu() {
        return machucvu;
    }

    public void setMachucvu(String machucvu) {
        this.machucvu = machucvu;
    }

    public String getVitri() {
        return vitri;
    }

    public void setVitri(String vitri) {
        this.vitri = vitri;
    }

    @XmlTransient
    public List<Nhanvien> getNhanvienList() {
        return nhanvienList;
    }

    public void setNhanvienList(List<Nhanvien> nhanvienList) {
        this.nhanvienList = nhanvienList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (machucvu != null ? machucvu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chucvu)) {
            return false;
        }
        Chucvu other = (Chucvu) object;
        if ((this.machucvu == null && other.machucvu != null) || (this.machucvu != null && !this.machucvu.equals(other.machucvu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Chucvu[ machucvu=" + machucvu + " ]";
    }
    
}
