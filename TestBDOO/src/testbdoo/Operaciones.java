
package testbdoo;

import java.util.Date;

public class Operaciones {
    
     private Date fechaHora;
     private String numeroCuenta;
     private char tipoOperacion;
     private double cantidad;

    public Operaciones(Date fechaHora, String numeroCuenta, char tipoOperacion, double cantidad) {
        this.fechaHora = fechaHora;
        this.numeroCuenta = numeroCuenta;
        this.tipoOperacion = tipoOperacion;
        this.cantidad = cantidad;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public char getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(char tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Operaciones{" + "fechaHora=" + fechaHora + ", numeroCuenta=" + numeroCuenta + ", tipoOperacion=" + tipoOperacion + ", cantidad=" + cantidad + '}';
    }
    
    
}
