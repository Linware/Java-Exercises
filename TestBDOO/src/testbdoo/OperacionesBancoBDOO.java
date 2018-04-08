package testbdoo;

import com.db4o.Db4o;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class OperacionesBancoBDOO {
    
    private ObjectContainer db;
    
    public OperacionesBancoBDOO(){
    db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "datos_bancarios");
    }
    
    public void guardarObjeto(Propietarios p) {
    db.store(p);
    System.out.println("Objeto guardado " + p);
    }
    
    public void guardarCuenta(CuentasBancarias p) {
    db.store(p);
    System.out.println("Objeto guardado " + p);
    }
    
    public void guardarHistorial(Historial p) {
    db.store(p);
    System.out.println("Objeto guardado " + p);
    }
    
    public void cerrar() {
        db.close();
    }
    
    public void obtenerTodosLosPropietarios() {
        ObjectSet result = db.queryByExample(Propietarios.class);
        System.out.println(result.size());
        while (result.hasNext()) {
            System.out.println(result.next());
        }
    }
    
    public void obtenerTodasLasCuentas() {
        ObjectSet result = db.queryByExample(CuentasBancarias.class);
        System.out.println(result.size());
        while (result.hasNext()) {
            System.out.println(result.next());
        }
    }
    

    //a. Insertar una cuenta bancaria nueva en la Base de Datos. Como una cuenta bancaria tiene un propietario, también tendrá que insertar el propietario correspondiente.

    
    public void insertarCuenta(CuentasBancarias s){
        db.store(s);
    }
    
    public void actualizarCuenta(String numeroCuenta,String propietario,Double saldo) {
        ObjectSet result = db.queryByExample(new CuentasBancarias(numeroCuenta, propietario,saldo));
        System.out.println(result.size());
        while (result.hasNext()) {
            CuentasBancarias found = (CuentasBancarias) result.next();
            found.setNumeroCuenta("0000000");
            found.setPropietario("UsuarioPruebas");
            found.setSaldo(500.0);
            db.store(found);
            System.out.println("Los datos ahora son: " + found);
        }
        this.obtenerTodasLasCuentas();
    }
    
    

   //b. Validar la entrada de un propietario (usuario y número secreto).
    
    public void validarUsuario(String user,String pass){
        ObjectSet result = db.queryByExample(Propietarios.class);
        boolean existe=false;
        while (result.hasNext()) {
            Propietarios propietarioTemporal= (Propietarios)result.next();
            
            if(propietarioTemporal.getUsuario()==user && propietarioTemporal.getNumeroSecreto()== pass){
            System.out.println("El usuario y contraseña existen");
            existe=true;
            }     
        }
        if (existe!=true){
            System.out.println("Usuario o contraseña NO VALIDOS");
        }
    }
            
            
                    /*
c. Modificar los datos de un propietario existente (nombre, primer apellido, segundo apellido).
d. Cambiar el número secreto de un propietario existente.
e. Eliminar una cuenta bancaria. También eliminará el propietario asociado.
    a. Obtener un objeto Operación Bancaria a partir de su ID.
b. Obtener la lista de todas las Operaciones Bancarias.
c. Insertar una operación bancaria a partir de un objeto de la clase Operación Bancaria definido adecuadamente según los campos que presenta. Una operación bancaria podrá ser un ingreso o extracción que realice un propietario sobre su cuenta bancaria.
d. Obtener las operaciones bancarias que han generado números rojos.
    e. Obtener todas las operaciones bancarias para una cuenta bancaria en concreto.
    a. Insertar los eventos mediante sendos métodos.
b. Obtener la fecha-hora del último inicio de sesión para un propietario en concreto.
c. Obtener el ranking de las cuentas bancarias que están en números rojos (la que tiene una cantidad mayor primero).
d. Obtener la posición dentro del ranking de una cuenta bancaria en concreto.
    */

/*
    public void obtenerPilotos(Piloto p) {
        ObjectSet result = db.queryByExample(p);
        System.out.println(result.size());
        while (result.hasNext()) {
            System.out.println(result.next());
        }
    }

    public void obtenerTodosLosPilotos() {
        ObjectSet result = db.queryByExample(Piloto.class);
        System.out.println(result.size());
        while (result.hasNext()) {
            System.out.println(result.next());
        }

    }

    public void buscarPilotosPorNombre(String nombre) {
        Piloto prototipo = new Piloto(nombre, 0);
        ObjectSet result = db.queryByExample(prototipo);
        System.out.println(result.size());
        while (result.hasNext()) {
            System.out.println(result.next());
        }
    }

    public void buscarPilotosPorPuntos(int puntos) {
        Piloto prototipo = new Piloto(null, puntos);
        ObjectSet result = db.queryByExample(prototipo);
        System.out.println(result.size());
        while (result.hasNext()) {
            System.out.println(result.next());
        }
    }


    public void eliminarPiloto(String nombre, int puntos){
        ObjectSet result = db.queryByExample(new Piloto(nombre, puntos));
        System.out.println(result.size());
        while (result.hasNext()) {
            Piloto found = (Piloto) result.next();
            //found.addPoints(11);
            db.delete(found);
            System.out.println("Objeto borrado " + found);
        }
        this.obtenerTodosLosPilotos();
    }
*/
    public static Date parseDate(String date) {
     try {
         return new SimpleDateFormat("yyyy-MM-dd").parse(date);
     } catch (ParseException e) {
         return null;
     }
  }
}


