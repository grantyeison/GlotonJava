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
public class CaracteristicasPlatoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "tbl_Restaurante_res_Nit")
    private String tblRestauranteresNit;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "tbl_Plato_nom_Nombre")
    private String tblPlatonomNombre;

    public CaracteristicasPlatoPK() {
    }

    public CaracteristicasPlatoPK(String tblRestauranteresNit, String tblPlatonomNombre) {
        this.tblRestauranteresNit = tblRestauranteresNit;
        this.tblPlatonomNombre = tblPlatonomNombre;
    }

    public String getTblRestauranteresNit() {
        return tblRestauranteresNit;
    }

    public void setTblRestauranteresNit(String tblRestauranteresNit) {
        this.tblRestauranteresNit = tblRestauranteresNit;
    }

    public String getTblPlatonomNombre() {
        return tblPlatonomNombre;
    }

    public void setTblPlatonomNombre(String tblPlatonomNombre) {
        this.tblPlatonomNombre = tblPlatonomNombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tblRestauranteresNit != null ? tblRestauranteresNit.hashCode() : 0);
        hash += (tblPlatonomNombre != null ? tblPlatonomNombre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CaracteristicasPlatoPK)) {
            return false;
        }
        CaracteristicasPlatoPK other = (CaracteristicasPlatoPK) object;
        if ((this.tblRestauranteresNit == null && other.tblRestauranteresNit != null) || (this.tblRestauranteresNit != null && !this.tblRestauranteresNit.equals(other.tblRestauranteresNit))) {
            return false;
        }
        if ((this.tblPlatonomNombre == null && other.tblPlatonomNombre != null) || (this.tblPlatonomNombre != null && !this.tblPlatonomNombre.equals(other.tblPlatonomNombre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.CaracteristicasPlatoPK[ tblRestauranteresNit=" + tblRestauranteresNit + ", tblPlatonomNombre=" + tblPlatonomNombre + " ]";
    }
    
}
