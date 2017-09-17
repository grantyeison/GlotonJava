/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Apollo
 */
@Embeddable
public class PlatoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "nom_Nombre")
    private String nomNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "tbl_Categoria_cat_Nombre")
    private String tblCategoriacatNombre;

    public PlatoPK() {
    }

    public PlatoPK(String nomNombre, String tblCategoriacatNombre) {
        this.nomNombre = nomNombre;
        this.tblCategoriacatNombre = tblCategoriacatNombre;
    }

    public String getNomNombre() {
        return nomNombre;
    }

    public void setNomNombre(String nomNombre) {
        this.nomNombre = nomNombre;
    }

    public String getTblCategoriacatNombre() {
        return tblCategoriacatNombre;
    }

    public void setTblCategoriacatNombre(String tblCategoriacatNombre) {
        this.tblCategoriacatNombre = tblCategoriacatNombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nomNombre != null ? nomNombre.hashCode() : 0);
        hash += (tblCategoriacatNombre != null ? tblCategoriacatNombre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlatoPK)) {
            return false;
        }
        PlatoPK other = (PlatoPK) object;
        if ((this.nomNombre == null && other.nomNombre != null) || (this.nomNombre != null && !this.nomNombre.equals(other.nomNombre))) {
            return false;
        }
        if ((this.tblCategoriacatNombre == null && other.tblCategoriacatNombre != null) || (this.tblCategoriacatNombre != null && !this.tblCategoriacatNombre.equals(other.tblCategoriacatNombre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.PlatoPK[ nomNombre=" + nomNombre + ", tblCategoriacatNombre=" + tblCategoriacatNombre + " ]";
    }
    
}
