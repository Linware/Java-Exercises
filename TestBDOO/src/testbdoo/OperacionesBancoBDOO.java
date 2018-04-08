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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

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
    
    
    public void eliminarCuenta(String numeroCuenta, String propietario,Double saldo){
        ObjectSet result = db.queryByExample(new CuentasBancarias(numeroCuenta, propietario,saldo));
        System.out.println(result.size());
        while (result.hasNext()) {
            CuentasBancarias found = (CuentasBancarias) result.next();
            db.delete(found);
            System.out.println("Objeto borrado " + found);
        }
        ObjectSet result2 = db.queryByExample(Propietarios.class);
        System.out.println(result.size());
        while (result.hasNext()) {
            Propietarios propietarioTemporal= (Propietarios)result.next();
            if (propietarioTemporal.getDni()==propietario){
                Propietarios found = (Propietarios) result.next();
                db.delete(found);
                System.out.println("Objeto borrado " + found);   
            }
        }
        
        this.obtenerTodasLasCuentas();
    }
    

    //a. Insertar una cuenta bancaria nueva en la Base de Datos. Como una cuenta bancaria tiene un propietario, también tendrá que insertar el propietario correspondiente.

    
    public void insertarCuenta(CuentasBancarias s){
        db.store(s);
    }
    
    public void modificarDatosPropietario(String nombre,String primerApellido, String segundoApellido) {
        ObjectSet result = db.queryByExample(new Propietarios(nombre, primerApellido,segundoApellido));
        while (result.hasNext()) {
            Propietarios found = (Propietarios) result.next();
            found.setNombre("Manolo");
            found.setPrimerApellido("Diaz");
            found.setSegundoApellido("Arias");
            db.store(found);
            System.out.println("Los datos ahora son: " + found);
        }
    }
    
    public void obtenerCuentaPorId(String cuenta){
        ObjectSet result = db.queryByExample(CuentasBancarias.class);
        boolean existe=false;
        while (result.hasNext()) {
            CuentasBancarias cuentatemporal= (CuentasBancarias)result.next();
            
            if(cuentatemporal.getNumeroCuenta()==cuenta ){
            System.out.println("Cuenta encontrada: "+cuentatemporal);
            existe=true;
            }     
        }
        if (existe!=true){
            System.out.println("Identificador NO VALIDO");
        }
    
    }
    
    public void cambiarNumeroSecreto(String dni){
        ObjectSet result = db.queryByExample(new Propietarios(dni));
        while (result.hasNext()) {
            Propietarios found = (Propietarios) result.next();
            found.setNumeroSecreto("777777");
            db.store(found);
            System.out.println("Los datos ahora son: " + found);
        }
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
    
    public void insertarOperacion(Date fecha, String idCuenta, char tipoEvento, Double saldo){
            Operaciones operacion =new Operaciones(fecha,idCuenta,tipoEvento,saldo);
            db.store(operacion);
    }
    
    public void listarCuentasEnNumerosRojos(){
        
        ObjectSet result = db.queryByExample(CuentasBancarias.class);
        System.out.println(result.size());
        while (result.hasNext()) {   
            CuentasBancarias cuentatemporal= (CuentasBancarias)result.next();
            
            if(cuentatemporal.getSaldo()<0 ){
            System.out.println("Cuenta encontrada: "+cuentatemporal);
            }     
        }

        }
    
    public void obtenerTodasOperacionesPorCuenta(String cuenta){
        ObjectSet result = db.queryByExample(Operaciones.class);
        boolean existe=false;
        while (result.hasNext()) {
            Operaciones cuentatemporal= (Operaciones)result.next();
            
            if(cuentatemporal.getNumeroCuenta()==cuenta ){
            System.out.println("Operacion encontrada: "+cuentatemporal);
            existe=true;
            }     
        }
        if (existe!=true){
            System.out.println("Identificador NO VALIDO");
        }
    }
    
    public void borrarTodo(){
        ObjectSet resultOperaciones = db.queryByExample(Operaciones.class);
        
        while (resultOperaciones.hasNext()) {
            db.delete(resultOperaciones);
        }
        
        ObjectSet resultPropietarios = db.queryByExample(Propietarios.class);
        
        while (resultPropietarios.hasNext()) {
            db.delete(resultPropietarios);
        }
        ObjectSet resultHistorial = db.queryByExample(Historial.class);
        
        while (resultHistorial.hasNext()) {
            db.delete(resultHistorial);
        }
        ObjectSet resultCuentasBancarias = db.queryByExample(CuentasBancarias.class);
        
        while (resultCuentasBancarias.hasNext()) {
            db.delete(resultCuentasBancarias);
        }
    }
    
    public void rankingNumerosRojos(){
        ObjectSet result = db.queryByExample(CuentasBancarias.class);
        ArrayList<CuentasBancarias> arrayCuentas=new ArrayList<CuentasBancarias>();
        while (result.hasNext()) {   
            CuentasBancarias cuentatemporal= (CuentasBancarias)result.next();
            
            if(cuentatemporal.getSaldo()<0 ){
            arrayCuentas.add(cuentatemporal);
            }     
        }
        
        System.out.println(arrayCuentas);
    }
            
            
    public static Date parseDate(String date) {
     try {
         return new SimpleDateFormat("yyyy-MM-dd").parse(date);
     } catch (ParseException e) {
         return null;
     }
  }
    
    public static int esEntero(){
        Scanner sc= new Scanner(System.in);
        boolean salida=false;
        int opcion=0;
        while(salida!=true)
        try {
            System.out.println("Escoja una opción");
            String text=sc.next();
            opcion=Integer.parseInt(text);
            salida=true;
        } catch (NumberFormatException e) {
            System.out.println("Escoja un numero entero para continuar");
            salida=false;
        } 
            return opcion;
    }
    
}


