/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Apollo
 */
@Entity
@Table(name = "tbl_promociones_combos_has_tbl_plato_restaurante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PromocionesCombosHasTblPlatoRestaurante.findAll", query = "SELECT p FROM PromocionesCombosHasTblPlatoRestaurante p")
    , @NamedQuery(name = "PromocionesCombosHasTblPlatoRestaurante.findById", query = "SELECT p FROM PromocionesCombosHasTblPlatoRestaurante p WHERE p.id = :id")})
public class PromocionesCombosHasTblPlatoRestaurante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "Promociones_Combos_promo_id", referencedColumnName = "promo_id")
    @ManyToOne
    private PromocionesCombos promocionesCombospromoid;
    @JoinColumn(name = "tbl_Plato_Restaurante_plat_Id", referencedColumnName = "plat_Id")
    @ManyToOne
    private PlatoRestaurante tblPlatoRestauranteplatId;

    public PromocionesCombosHasTblPlatoRestaurante() {
    }

    public PromocionesCombosHasTblPlatoRestaurante(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PromocionesCombos getPromocionesCombospromoid() {
        return promocionesCombospromoid;
    }

    public void setPromocionesCombospromoid(PromocionesCombos promocionesCombospromoid) {
        this.promocionesCombospromoid = promocionesCombospromoid;
    }

    public PlatoRestaurante getTblPlatoRestauranteplatId() {
        return tblPlatoRestauranteplatId;
    }

    public void setTblPlatoRestauranteplatId(PlatoRestaurante tblPlatoRestauranteplatId) {
        this.tblPlatoRestauranteplatId = tblPlatoRestauranteplatId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PromocionesCombosHasTblPlatoRestaurante)) {
            return false;
        }
        PromocionesCombosHasTblPlatoRestaurante other = (PromocionesCombosHasTblPlatoRestaurante) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.PromocionesCombosHasTblPlatoRestaurante[ id=" + id + " ]";
    }
    
}
