
package testbdoo;

import java.util.Date;

public class Historial {
    
    private char tipoEvento;
    private Date fechaHora;
    private String numeroCuenta;

    public Historial(char tipoEvento, Date fechaHora, String numeroCuenta) {
        this.tipoEvento = tipoEvento;
        this.fechaHora = fechaHora;
        this.numeroCuenta = numeroCuenta;
    }
    
    

    public char getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(char tipoEvento) {
        this.tipoEvento = tipoEvento;
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

    @Override
    public String toString() {
        return "Historial{" + "tipoEvento=" + tipoEvento + ", fechaHora=" + fechaHora + ", numeroCuenta=" + numeroCuenta + '}';
    }
    
    
    
}
