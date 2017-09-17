/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Apollo
 */
@Entity
@Table(name = "tbl_promociones_combos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PromocionesCombos.findAll", query = "SELECT p FROM PromocionesCombos p")
    , @NamedQuery(name = "PromocionesCombos.findByPromoId", query = "SELECT p FROM PromocionesCombos p WHERE p.promoId = :promoId")
    , @NamedQuery(name = "PromocionesCombos.findByPromoPrecio", query = "SELECT p FROM PromocionesCombos p WHERE p.promoPrecio = :promoPrecio")
    , @NamedQuery(name = "PromocionesCombos.findByPromoDescripcion", query = "SELECT p FROM PromocionesCombos p WHERE p.promoDescripcion = :promoDescripcion")
    , @NamedQuery(name = "PromocionesCombos.findByPromoFecha", query = "SELECT p FROM PromocionesCombos p WHERE p.promoFecha = :promoFecha")
    , @NamedQuery(name = "PromocionesCombos.findByPromoDuracion", query = "SELECT p FROM PromocionesCombos p WHERE p.promoDuracion = :promoDuracion")})
public class PromocionesCombos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "promo_id")
    private Integer promoId;
    @Column(name = "promo_precio")
    private Integer promoPrecio;
    @Size(max = 10000)
    @Column(name = "promo_Descripcion")
    private String promoDescripcion;
    @Column(name = "promo_fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date promoFecha;
    @Column(name = "promo_duracion")
    private Integer promoDuracion;
    @OneToMany(mappedBy = "promocionesCombospromoid")
    private List<PromocionesCombosHasTblPlatoRestaurante> promocionesCombosHasTblPlatoRestauranteList;

    public PromocionesCombos() {
    }

    public PromocionesCombos(Integer promoId) {
        this.promoId = promoId;
    }

    public Integer getPromoId() {
        return promoId;
    }

    public void setPromoId(Integer promoId) {
        this.promoId = promoId;
    }

    public Integer getPromoPrecio() {
        return promoPrecio;
    }

    public void setPromoPrecio(Integer promoPrecio) {
        this.promoPrecio = promoPrecio;
    }

    public String getPromoDescripcion() {
        return promoDescripcion;
    }

    public void setPromoDescripcion(String promoDescripcion) {
        this.promoDescripcion = promoDescripcion;
    }

    public Date getPromoFecha() {
        return promoFecha;
    }

    public void setPromoFecha(Date promoFecha) {
        this.promoFecha = promoFecha;
    }

    public Integer getPromoDuracion() {
        return promoDuracion;
    }

    public void setPromoDuracion(Integer promoDuracion) {
        this.promoDuracion = promoDuracion;
    }

    @XmlTransient
    public List<PromocionesCombosHasTblPlatoRestaurante> getPromocionesCombosHasTblPlatoRestauranteList() {
        return promocionesCombosHasTblPlatoRestauranteList;
    }

    public void setPromocionesCombosHasTblPlatoRestauranteList(List<PromocionesCombosHasTblPlatoRestaurante> promocionesCombosHasTblPlatoRestauranteList) {
        this.promocionesCombosHasTblPlatoRestauranteList = promocionesCombosHasTblPlatoRestauranteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (promoId != null ? promoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PromocionesCombos)) {
            return false;
        }
        PromocionesCombos other = (PromocionesCombos) object;
        if ((this.promoId == null && other.promoId != null) || (this.promoId != null && !this.promoId.equals(other.promoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.PromocionesCombos[ promoId=" + promoId + " ]";
    }
    
}
