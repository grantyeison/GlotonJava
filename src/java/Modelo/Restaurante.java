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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tbl_restaurante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Restaurante.findAll", query = "SELECT r FROM Restaurante r")
    , @NamedQuery(name = "Restaurante.findByResNit", query = "SELECT r FROM Restaurante r WHERE r.resNit = :resNit")
    , @NamedQuery(name = "Restaurante.findByResNombre", query = "SELECT r FROM Restaurante r WHERE r.resNombre = :resNombre")
    , @NamedQuery(name = "Restaurante.findByResDireccion", query = "SELECT r FROM Restaurante r WHERE r.resDireccion = :resDireccion")
    , @NamedQuery(name = "Restaurante.findByResTelefono", query = "SELECT r FROM Restaurante r WHERE r.resTelefono = :resTelefono")
    , @NamedQuery(name = "Restaurante.findByResLogo", query = "SELECT r FROM Restaurante r WHERE r.resLogo = :resLogo")
    , @NamedQuery(name = "Restaurante.findByResEstado", query = "SELECT r FROM Restaurante r WHERE r.resEstado = :resEstado")
    , @NamedQuery(name = "Restaurante.findByResLatitud", query = "SELECT r FROM Restaurante r WHERE r.resLatitud = :resLatitud")
    , @NamedQuery(name = "Restaurante.findByTesLongitud", query = "SELECT r FROM Restaurante r WHERE r.tesLongitud = :tesLongitud")})
public class Restaurante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "res_Nit")
    private String resNit;
    @Size(max = 1000)
    @Column(name = "res_Nombre")
    private String resNombre;
    @Size(max = 1000)
    @Column(name = "res_Direccion")
    private String resDireccion;
    @Size(max = 250)
    @Column(name = "res_Telefono")
    private String resTelefono;
    @Size(max = 1000)
    @Column(name = "res_Logo")
    private String resLogo;
    @Size(max = 45)
    @Column(name = "res_Estado")
    private String resEstado;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "res_Latitud")
    private Float resLatitud;
    @Column(name = "tes_Longitud")
    private Float tesLongitud;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "restaurante")
    private List<CaracteristicasPlato> caracteristicasPlatoList;
    @JoinColumn(name = "tbl_Usuario_due_id", referencedColumnName = "due_id")
    @ManyToOne(optional = false)
    private Usuario tblUsuariodueid;

    public Restaurante() {
    }

    public Restaurante(String resNit) {
        this.resNit = resNit;
    }

    public String getResNit() {
        return resNit;
    }

    public void setResNit(String resNit) {
        this.resNit = resNit;
    }

    public String getResNombre() {
        return resNombre;
    }

    public void setResNombre(String resNombre) {
        this.resNombre = resNombre;
    }

    public String getResDireccion() {
        return resDireccion;
    }

    public void setResDireccion(String resDireccion) {
        this.resDireccion = resDireccion;
    }

    public String getResTelefono() {
        return resTelefono;
    }

    public void setResTelefono(String resTelefono) {
        this.resTelefono = resTelefono;
    }

    public String getResLogo() {
        return resLogo;
    }

    public void setResLogo(String resLogo) {
        this.resLogo = resLogo;
    }

    public String getResEstado() {
        return resEstado;
    }

    public void setResEstado(String resEstado) {
        this.resEstado = resEstado;
    }

    public Float getResLatitud() {
        return resLatitud;
    }

    public void setResLatitud(Float resLatitud) {
        this.resLatitud = resLatitud;
    }

    public Float getTesLongitud() {
        return tesLongitud;
    }

    public void setTesLongitud(Float tesLongitud) {
        this.tesLongitud = tesLongitud;
    }

    @XmlTransient
    public List<CaracteristicasPlato> getCaracteristicasPlatoList() {
        return caracteristicasPlatoList;
    }

    public void setCaracteristicasPlatoList(List<CaracteristicasPlato> caracteristicasPlatoList) {
        this.caracteristicasPlatoList = caracteristicasPlatoList;
    }

    public Usuario getTblUsuariodueid() {
        return tblUsuariodueid;
    }

    public void setTblUsuariodueid(Usuario tblUsuariodueid) {
        this.tblUsuariodueid = tblUsuariodueid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (resNit != null ? resNit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Restaurante)) {
            return false;
        }
        Restaurante other = (Restaurante) object;
        if ((this.resNit == null && other.resNit != null) || (this.resNit != null && !this.resNit.equals(other.resNit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Restaurante[ resNit=" + resNit + " ]";
    }
    
}
