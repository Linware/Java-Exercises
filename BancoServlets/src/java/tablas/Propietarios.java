/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablas;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
 * @author Disai
 */
@Entity
@Table(name = "propietarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Propietarios.findAll", query = "SELECT p FROM Propietarios p")
    , @NamedQuery(name = "Propietarios.findByDni", query = "SELECT p FROM Propietarios p WHERE p.dni = :dni")
    , @NamedQuery(name = "Propietarios.findByUsuario", query = "SELECT p FROM Propietarios p WHERE p.usuario = :usuario")
    , @NamedQuery(name = "Propietarios.findByNombre", query = "SELECT p FROM Propietarios p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Propietarios.findByPrimerApellido", query = "SELECT p FROM Propietarios p WHERE p.primerApellido = :primerApellido")
    , @NamedQuery(name = "Propietarios.findBySegundoApellido", query = "SELECT p FROM Propietarios p WHERE p.segundoApellido = :segundoApellido")
    , @NamedQuery(name = "Propietarios.findByNumeroSecreto", query = "SELECT p FROM Propietarios p WHERE p.numeroSecreto = :numeroSecreto")
    , @NamedQuery(name = "Propietarios.ValidarUsuario", query = "SELECT p FROM Propietarios p WHERE p.usuario = :usuario AND p.numeroSecreto = :numeroSecreto")})
public class Propietarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "dni")
    private String dni;
    @Size(max = 64)
    @Column(name = "usuario")
    private String usuario;
    @Size(max = 32)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 32)
    @Column(name = "primer_apellido")
    private String primerApellido;
    @Size(max = 32)
    @Column(name = "segundo_apellido")
    private String segundoApellido;
    @Size(max = 6)
    @Column(name = "numero_secreto")
    private String numeroSecreto;
    @OneToMany(mappedBy = "propietario")
    private Collection<Cuentasbancarias> cuentasbancariasCollection;

    public Propietarios() {
    }

    public Propietarios(String dni) {
        this.dni = dni;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getNumeroSecreto() {
        return numeroSecreto;
    }

    public void setNumeroSecreto(String numeroSecreto) {
        this.numeroSecreto = numeroSecreto;
    }

    @XmlTransient
    public Collection<Cuentasbancarias> getCuentasbancariasCollection() {
        return cuentasbancariasCollection;
    }

    public void setCuentasbancariasCollection(Collection<Cuentasbancarias> cuentasbancariasCollection) {
        this.cuentasbancariasCollection = cuentasbancariasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dni != null ? dni.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Propietarios)) {
            return false;
        }
        Propietarios other = (Propietarios) object;
        if ((this.dni == null && other.dni != null) || (this.dni != null && !this.dni.equals(other.dni))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return usuario+"[ dni=" + dni + " ]";
    }
    
}
