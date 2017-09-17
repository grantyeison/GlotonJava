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
public class CalificacionPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "cal_id")
    private int calId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "tbl__Caracteristicas_Plato_tbl_Restaurante_res_Nit")
    private String tblCaracteristicasPlatotblRestauranteresNit;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "tbl__Caracteristicas_Plato_tbl_Plato_nom_Nombre")
    private String tblCaracteristicasPlatotblPlatonomNombre;

    public CalificacionPK() {
    }

    public CalificacionPK(int calId, String tblCaracteristicasPlatotblRestauranteresNit, String tblCaracteristicasPlatotblPlatonomNombre) {
        this.calId = calId;
        this.tblCaracteristicasPlatotblRestauranteresNit = tblCaracteristicasPlatotblRestauranteresNit;
        this.tblCaracteristicasPlatotblPlatonomNombre = tblCaracteristicasPlatotblPlatonomNombre;
    }

    public int getCalId() {
        return calId;
    }

    public void setCalId(int calId) {
        this.calId = calId;
    }

    public String getTblCaracteristicasPlatotblRestauranteresNit() {
        return tblCaracteristicasPlatotblRestauranteresNit;
    }

    public void setTblCaracteristicasPlatotblRestauranteresNit(String tblCaracteristicasPlatotblRestauranteresNit) {
        this.tblCaracteristicasPlatotblRestauranteresNit = tblCaracteristicasPlatotblRestauranteresNit;
    }

    public String getTblCaracteristicasPlatotblPlatonomNombre() {
        return tblCaracteristicasPlatotblPlatonomNombre;
    }

    public void setTblCaracteristicasPlatotblPlatonomNombre(String tblCaracteristicasPlatotblPlatonomNombre) {
        this.tblCaracteristicasPlatotblPlatonomNombre = tblCaracteristicasPlatotblPlatonomNombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) calId;
        hash += (tblCaracteristicasPlatotblRestauranteresNit != null ? tblCaracteristicasPlatotblRestauranteresNit.hashCode() : 0);
        hash += (tblCaracteristicasPlatotblPlatonomNombre != null ? tblCaracteristicasPlatotblPlatonomNombre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CalificacionPK)) {
            return false;
        }
        CalificacionPK other = (CalificacionPK) object;
        if (this.calId != other.calId) {
            return false;
        }
        if ((this.tblCaracteristicasPlatotblRestauranteresNit == null && other.tblCaracteristicasPlatotblRestauranteresNit != null) || (this.tblCaracteristicasPlatotblRestauranteresNit != null && !this.tblCaracteristicasPlatotblRestauranteresNit.equals(other.tblCaracteristicasPlatotblRestauranteresNit))) {
            return false;
        }
        if ((this.tblCaracteristicasPlatotblPlatonomNombre == null && other.tblCaracteristicasPlatotblPlatonomNombre != null) || (this.tblCaracteristicasPlatotblPlatonomNombre != null && !this.tblCaracteristicasPlatotblPlatonomNombre.equals(other.tblCaracteristicasPlatotblPlatonomNombre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.CalificacionPK[ calId=" + calId + ", tblCaracteristicasPlatotblRestauranteresNit=" + tblCaracteristicasPlatotblRestauranteresNit + ", tblCaracteristicasPlatotblPlatonomNombre=" + tblCaracteristicasPlatotblPlatonomNombre + " ]";
    }
    
}
