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
@Table(name = "tbl_plato")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Plato.findAll", query = "SELECT p FROM Plato p")
    , @NamedQuery(name = "Plato.findByNomNombre", query = "SELECT p FROM Plato p WHERE p.platoPK.nomNombre = :nomNombre")
    , @NamedQuery(name = "Plato.findByNomImagen", query = "SELECT p FROM Plato p WHERE p.nomImagen = :nomImagen")
    , @NamedQuery(name = "Plato.findByNomEstado", query = "SELECT p FROM Plato p WHERE p.nomEstado = :nomEstado")
    , @NamedQuery(name = "Plato.findByTblCategoriacatNombre", query = "SELECT p FROM Plato p WHERE p.platoPK.tblCategoriacatNombre = :tblCategoriacatNombre")})
public class Plato implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PlatoPK platoPK;
    @Size(max = 250)
    @Column(name = "nom_Imagen")
    private String nomImagen;
    @Size(max = 45)
    @Column(name = "nom_Estado")
    private String nomEstado;
    @JoinColumn(name = "tbl_Categoria_cat_Nombre", referencedColumnName = "cat_Nombre", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Categoria categoria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "plato")
    private List<CaracteristicasPlato> caracteristicasPlatoList;

    public Plato() {
    }

    public Plato(PlatoPK platoPK) {
        this.platoPK = platoPK;
    }

    public Plato(String nomNombre, String tblCategoriacatNombre) {
        this.platoPK = new PlatoPK(nomNombre, tblCategoriacatNombre);
    }

    public PlatoPK getPlatoPK() {
        return platoPK;
    }

    public void setPlatoPK(PlatoPK platoPK) {
        this.platoPK = platoPK;
    }

    public String getNomImagen() {
        return nomImagen;
    }

    public void setNomImagen(String nomImagen) {
        this.nomImagen = nomImagen;
    }

    public String getNomEstado() {
        return nomEstado;
    }

    public void setNomEstado(String nomEstado) {
        this.nomEstado = nomEstado;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @XmlTransient
    public List<CaracteristicasPlato> getCaracteristicasPlatoList() {
        return caracteristicasPlatoList;
    }

    public void setCaracteristicasPlatoList(List<CaracteristicasPlato> caracteristicasPlatoList) {
        this.caracteristicasPlatoList = caracteristicasPlatoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (platoPK != null ? platoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Plato)) {
            return false;
        }
        Plato other = (Plato) object;
        if ((this.platoPK == null && other.platoPK != null) || (this.platoPK != null && !this.platoPK.equals(other.platoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Plato[ platoPK=" + platoPK + " ]";
    }
    
}
