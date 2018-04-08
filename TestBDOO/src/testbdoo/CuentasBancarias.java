
package testbdoo;


public class CuentasBancarias {
     private String numeroCuenta;
     private String propietario;
     private Double saldo;

    public CuentasBancarias(String numeroCuenta, String propietario, Double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.propietario = propietario;
        this.saldo = saldo;
    }
     
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "CuentasBancarias{" + "numeroCuenta=" + numeroCuenta + ", propietario=" + propietario + ", saldo=" + saldo + '}';
    }
     
     
}
