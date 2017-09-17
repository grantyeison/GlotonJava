/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

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
 * @author Apollo
 */
@Entity
@Table(name = "tbl_categoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categoria.findAll", query = "SELECT c FROM Categoria c")
    , @NamedQuery(name = "Categoria.findByCatNombre", query = "SELECT c FROM Categoria c WHERE c.catNombre = :catNombre")
    , @NamedQuery(name = "Categoria.findByCatImagen", query = "SELECT c FROM Categoria c WHERE c.catImagen = :catImagen")
    , @NamedQuery(name = "Categoria.findByCatEstado", query = "SELECT c FROM Categoria c WHERE c.catEstado = :catEstado")})
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "cat_Nombre")
    private String catNombre;
    @Size(max = 250)
    @Column(name = "cat_Imagen")
    private String catImagen;
    @Size(max = 45)
    @Column(name = "cat_Estado")
    private String catEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoria")
    private List<Plato> platoList;

    public Categoria() {
    }

    public Categoria(String catNombre) {
        this.catNombre = catNombre;
    }

    public String getCatNombre() {
        return catNombre;
    }

    public void setCatNombre(String catNombre) {
        this.catNombre = catNombre;
    }

    public String getCatImagen() {
        return catImagen;
    }

    public void setCatImagen(String catImagen) {
        this.catImagen = catImagen;
    }

    public String getCatEstado() {
        return catEstado;
    }

    public void setCatEstado(String catEstado) {
        this.catEstado = catEstado;
    }

    @XmlTransient
    public List<Plato> getPlatoList() {
        return platoList;
    }

    public void setPlatoList(List<Plato> platoList) {
        this.platoList = platoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (catNombre != null ? catNombre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) object;
        if ((this.catNombre == null && other.catNombre != null) || (this.catNombre != null && !this.catNombre.equals(other.catNombre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Categoria[ catNombre=" + catNombre + " ]";
    }
    
}
