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
 * @author Disai
 */
@Entity
@Table(name = "cuentasbancarias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cuentasbancarias.findAll", query = "SELECT c FROM Cuentasbancarias c")
    , @NamedQuery(name = "Cuentasbancarias.findByNumeroCuenta", query = "SELECT c FROM Cuentasbancarias c WHERE c.numeroCuenta = :numeroCuenta")
    , @NamedQuery(name = "Cuentasbancarias.findBySaldo", query = "SELECT c FROM Cuentasbancarias c WHERE c.saldo = :saldo")})
public class Cuentasbancarias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "numero_cuenta")
    private String numeroCuenta;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "saldo")
    private Double saldo;
    @OneToMany(mappedBy = "numeroCuenta")
    private Collection<Historial> historialCollection;
    @JoinColumn(name = "propietario", referencedColumnName = "dni")
    @ManyToOne
    private Propietarios propietario;

    public Cuentasbancarias() {
    }

    public Cuentasbancarias(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public Cuentasbancarias(String numeroCuenta, Double saldoDouble, String propietario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    @XmlTransient
    public Collection<Historial> getHistorialCollection() {
        return historialCollection;
    }

    public void setHistorialCollection(Collection<Historial> historialCollection) {
        this.historialCollection = historialCollection;
    }

    public Propietarios getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietarios propietario) {
        this.propietario = propietario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroCuenta != null ? numeroCuenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuentasbancarias)) {
            return false;
        }
        Cuentasbancarias other = (Cuentasbancarias) object;
        if ((this.numeroCuenta == null && other.numeroCuenta != null) || (this.numeroCuenta != null && !this.numeroCuenta.equals(other.numeroCuenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tablas.Cuentasbancarias[ numeroCuenta=" + numeroCuenta + " ]";
    }

    public Cuentasbancarias(String numeroCuenta, Double saldo, Propietarios propietario) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.propietario = propietario;
    }
    
    
    
}
