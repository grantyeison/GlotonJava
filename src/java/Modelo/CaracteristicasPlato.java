/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Apollo
 */
@Entity
@Table(name = "tbl__caracteristicas_plato")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CaracteristicasPlato.findAll", query = "SELECT c FROM CaracteristicasPlato c")
    , @NamedQuery(name = "CaracteristicasPlato.findByPlatIngredientes", query = "SELECT c FROM CaracteristicasPlato c WHERE c.platIngredientes = :platIngredientes")
    , @NamedQuery(name = "CaracteristicasPlato.findByPlatDescripcion", query = "SELECT c FROM CaracteristicasPlato c WHERE c.platDescripcion = :platDescripcion")
    , @NamedQuery(name = "CaracteristicasPlato.findByPlatPrecio", query = "SELECT c FROM CaracteristicasPlato c WHERE c.platPrecio = :platPrecio")
    , @NamedQuery(name = "CaracteristicasPlato.findByPlatEstado", query = "SELECT c FROM CaracteristicasPlato c WHERE c.platEstado = :platEstado")
    , @NamedQuery(name = "CaracteristicasPlato.findByTblRestauranteresNit", query = "SELECT c FROM CaracteristicasPlato c WHERE c.caracteristicasPlatoPK.tblRestauranteresNit = :tblRestauranteresNit")
    , @NamedQuery(name = "CaracteristicasPlato.findByTblPlatonomNombre", query = "SELECT c FROM CaracteristicasPlato c WHERE c.caracteristicasPlatoPK.tblPlatonomNombre = :tblPlatonomNombre")})
public class CaracteristicasPlato implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CaracteristicasPlatoPK caracteristicasPlatoPK;
    @Size(max = 10000)
    @Column(name = "plat_Ingredientes")
    private String platIngredientes;
    @Size(max = 10000)
    @Column(name = "plat_Descripcion")
    private String platDescripcion;
    @Column(name = "plat_Precio")
    private Integer platPrecio;
    @Size(max = 45)
    @Column(name = "plat_Estado")
    private String platEstado;
    @ManyToMany(mappedBy = "caracteristicasPlatoList")
    private List<PromocionesCombos> promocionesCombosList;
    @JoinColumn(name = "tbl_Restaurante_res_Nit", referencedColumnName = "res_Nit", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Restaurante restaurante;
    @JoinColumn(name = "tbl_Plato_nom_Nombre", referencedColumnName = "nom_Nombre", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Plato plato;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "caracteristicasPlato")
    private List<Calificacion> calificacionList;

    public CaracteristicasPlato() {
    }

    public CaracteristicasPlato(CaracteristicasPlatoPK caracteristicasPlatoPK) {
        this.caracteristicasPlatoPK = caracteristicasPlatoPK;
    }

    public CaracteristicasPlato(String tblRestauranteresNit, String tblPlatonomNombre) {
        this.caracteristicasPlatoPK = new CaracteristicasPlatoPK(tblRestauranteresNit, tblPlatonomNombre);
    }

    public CaracteristicasPlatoPK getCaracteristicasPlatoPK() {
        return caracteristicasPlatoPK;
    }

    public void setCaracteristicasPlatoPK(CaracteristicasPlatoPK caracteristicasPlatoPK) {
        this.caracteristicasPlatoPK = caracteristicasPlatoPK;
    }

    public String getPlatIngredientes() {
        return platIngredientes;
    }

    public void setPlatIngredientes(String platIngredientes) {
        this.platIngredientes = platIngredientes;
    }

    public String getPlatDescripcion() {
        return platDescripcion;
    }

    public void setPlatDescripcion(String platDescripcion) {
        this.platDescripcion = platDescripcion;
    }

    public Integer getPlatPrecio() {
        return platPrecio;
    }

    public void setPlatPrecio(Integer platPrecio) {
        this.platPrecio = platPrecio;
    }

    public String getPlatEstado() {
        return platEstado;
    }

    public void setPlatEstado(String platEstado) {
        this.platEstado = platEstado;
    }

    @XmlTransient
    public List<PromocionesCombos> getPromocionesCombosList() {
        return promocionesCombosList;
    }

    public void setPromocionesCombosList(List<PromocionesCombos> promocionesCombosList) {
        this.promocionesCombosList = promocionesCombosList;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public Plato getPlato() {
        return plato;
    }

    public void setPlato(Plato plato) {
        this.plato = plato;
    }

    @XmlTransient
    public List<Calificacion> getCalificacionList() {
        return calificacionList;
    }

    public void setCalificacionList(List<Calificacion> calificacionList) {
        this.calificacionList = calificacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (caracteristicasPlatoPK != null ? caracteristicasPlatoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CaracteristicasPlato)) {
            return false;
        }
        CaracteristicasPlato other = (CaracteristicasPlato) object;
        if ((this.caracteristicasPlatoPK == null && other.caracteristicasPlatoPK != null) || (this.caracteristicasPlatoPK != null && !this.caracteristicasPlatoPK.equals(other.caracteristicasPlatoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.CaracteristicasPlato[ caracteristicasPlatoPK=" + caracteristicasPlatoPK + " ]";
    }
    
}
