
package testbdoo;


public class Propietarios {
    
     private String dni;
     private String usuario;
     private String nombre;
     private String primerApellido;
     private String segundoApellido;
     private String numeroSecreto;

    public Propietarios(String dni, String usuario, String nombre, String primerApellido, String segundoApellido, String numeroSecreto) {
        this.dni = dni;
        this.usuario = usuario;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.numeroSecreto = numeroSecreto;
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

    @Override
    public String toString() {
        return "Propietarios{" + "dni=" + dni + ", usuario=" + usuario + ", nombre=" + nombre + ", primerApellido=" + primerApellido + ", segundoApellido=" + segundoApellido + ", numeroSecreto=" + numeroSecreto + '}';
    }
    
    
     
     
}
