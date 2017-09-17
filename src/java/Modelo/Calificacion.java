/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Apollo
 */
@Entity
@Table(name = "tbl_calificacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calificacion.findAll", query = "SELECT c FROM Calificacion c")
    , @NamedQuery(name = "Calificacion.findByCalId", query = "SELECT c FROM Calificacion c WHERE c.calificacionPK.calId = :calId")
    , @NamedQuery(name = "Calificacion.findByCalPuntuacion", query = "SELECT c FROM Calificacion c WHERE c.calPuntuacion = :calPuntuacion")
    , @NamedQuery(name = "Calificacion.findByTblCaracteristicasPlatotblRestauranteresNit", query = "SELECT c FROM Calificacion c WHERE c.calificacionPK.tblCaracteristicasPlatotblRestauranteresNit = :tblCaracteristicasPlatotblRestauranteresNit")
    , @NamedQuery(name = "Calificacion.findByTblCaracteristicasPlatotblPlatonomNombre", query = "SELECT c FROM Calificacion c WHERE c.calificacionPK.tblCaracteristicasPlatotblPlatonomNombre = :tblCaracteristicasPlatotblPlatonomNombre")
    , @NamedQuery(name = "Calificacion.findByCalUsuario", query = "SELECT c FROM Calificacion c WHERE c.calUsuario = :calUsuario")})
public class Calificacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CalificacionPK calificacionPK;
    @Column(name = "cal_puntuacion")
    private Integer calPuntuacion;
    @Size(max = 250)
    @Column(name = "cal_usuario")
    private String calUsuario;
    @JoinColumns({
        @JoinColumn(name = "tbl__Caracteristicas_Plato_tbl_Restaurante_res_Nit", referencedColumnName = "tbl_Restaurante_res_Nit", insertable = false, updatable = false)
        , @JoinColumn(name = "tbl__Caracteristicas_Plato_tbl_Plato_nom_Nombre", referencedColumnName = "tbl_Plato_nom_Nombre", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private CaracteristicasPlato caracteristicasPlato;

    public Calificacion() {
    }

    public Calificacion(CalificacionPK calificacionPK) {
        this.calificacionPK = calificacionPK;
    }

    public Calificacion(int calId, String tblCaracteristicasPlatotblRestauranteresNit, String tblCaracteristicasPlatotblPlatonomNombre) {
        this.calificacionPK = new CalificacionPK(calId, tblCaracteristicasPlatotblRestauranteresNit, tblCaracteristicasPlatotblPlatonomNombre);
    }

    public CalificacionPK getCalificacionPK() {
        return calificacionPK;
    }

    public void setCalificacionPK(CalificacionPK calificacionPK) {
        this.calificacionPK = calificacionPK;
    }

    public Integer getCalPuntuacion() {
        return calPuntuacion;
    }

    public void setCalPuntuacion(Integer calPuntuacion) {
        this.calPuntuacion = calPuntuacion;
    }

    public String getCalUsuario() {
        return calUsuario;
    }

    public void setCalUsuario(String calUsuario) {
        this.calUsuario = calUsuario;
    }

    public CaracteristicasPlato getCaracteristicasPlato() {
        return caracteristicasPlato;
    }

    public void setCaracteristicasPlato(CaracteristicasPlato caracteristicasPlato) {
        this.caracteristicasPlato = caracteristicasPlato;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (calificacionPK != null ? calificacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Calificacion)) {
            return false;
        }
        Calificacion other = (Calificacion) object;
        if ((this.calificacionPK == null && other.calificacionPK != null) || (this.calificacionPK != null && !this.calificacionPK.equals(other.calificacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Calificacion[ calificacionPK=" + calificacionPK + " ]";
    }
    
}
