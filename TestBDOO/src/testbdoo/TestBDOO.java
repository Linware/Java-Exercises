/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testbdoo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import testbdoo.OperacionesBancoBDOO.*;
import static testbdoo.OperacionesBancoBDOO.parseDate;

public class TestBDOO {

    public static void main(String[] args) {
        
        boolean salir = false;
 //Guardaremos la opcion del usuario
       //OperacionesBancoBDOO.listaCuentas();
       
       OperacionesBancoBDOO db=new OperacionesBancoBDOO();
       
        Propietarios brian = new Propietarios("67854736C","BrianGoetzSaez","Brian", "Goetz","Saez", "557845");
        Propietarios jon = new Propietarios("67854123F","JonGalvezMurua","Jon", "Galvez","Murua", "093847");
        Propietarios samanta = new Propietarios("85744736J","SamantaSanchoVillar","Samanta", "Sancho","Villar", "938475");
        Propietarios roberto = new Propietarios("67111736Z","RobertoVaezMilan","Roberto", "Vaez","Milan", "443356");
        Propietarios galder = new Propietarios("33354746B","GalderBarcenaUrdul","Galder", "Barcena","Urdul", "847364");
        Propietarios oscar = new Propietarios("68573436C","OscarPaezMiraldo","Oscar", "Paez","Miraldo", "5837264");
            
        db.guardarObjeto(brian);
        db.guardarObjeto(jon);
        db.guardarObjeto(samanta);
        db.guardarObjeto(roberto);
        db.guardarObjeto(galder);
        db.guardarObjeto(oscar);
        
        CuentasBancarias cuenta1=new CuentasBancarias("012345","67854736C",3546.34);
        CuentasBancarias cuenta2=new CuentasBancarias("012764","67854736C",456.14);
        CuentasBancarias cuenta3=new CuentasBancarias("447756","67111736Z",3546.34);
        CuentasBancarias cuenta4=new CuentasBancarias("856895","68573436C",104.0);
        CuentasBancarias cuenta5=new CuentasBancarias("567334","85744736J",87995.12);
        CuentasBancarias cuenta6=new CuentasBancarias("768685","67111736Z",3546.34);
        CuentasBancarias cuenta7=new CuentasBancarias("354354","33354746B",456.14);
        CuentasBancarias cuenta8=new CuentasBancarias("908904","67111736Z",346.34);
        CuentasBancarias cuenta9=new CuentasBancarias("123131","67854123F",1567.0);
        CuentasBancarias cuenta10=new CuentasBancarias("125436","85744736J",87995.12);
        CuentasBancarias cuenta11=new CuentasBancarias("908904","67111736Z",-946.34);
        CuentasBancarias cuenta12=new CuentasBancarias("123131","67854123F",-157.0);
        CuentasBancarias cuenta13=new CuentasBancarias("125436","85744736J",-88.92);
        
        db.guardarCuenta(cuenta1);
        db.guardarCuenta(cuenta2);
        db.guardarCuenta(cuenta3);
        db.guardarCuenta(cuenta4);
        db.guardarCuenta(cuenta5);
        db.guardarCuenta(cuenta6);
        db.guardarCuenta(cuenta7);
        db.guardarCuenta(cuenta8);
        db.guardarCuenta(cuenta9);
        db.guardarCuenta(cuenta10);
        db.guardarCuenta(cuenta11);
        db.guardarCuenta(cuenta12);
        db.guardarCuenta(cuenta13);
        

        Date date1=parseDate("2014-02-14");
        Date date2=parseDate("2011-06-09");
        Date date3=parseDate("2013-11-12");
        Date date4=parseDate("2015-05-28");
        
        Historial historial1=new Historial('I',date1,"125436");
        Historial historial2=new Historial('E',date2,"768685");
        Historial historial3=new Historial('I',date3,"447756");
        Historial historial4=new Historial('R',date4,"768685");
        
        db.guardarHistorial(historial1);
        db.guardarHistorial(historial2);
        db.guardarHistorial(historial3);
        db.guardarHistorial(historial4);
                              
        //db.cerrar();
           
       while(!salir){
            
           System.out.println("*********************************************************************");
           System.out.println("*********************************************************************");
           System.out.println("Menu:");
           System.out.println("0. Ver todas las cuentas"); //
           System.out.println("1. Insertar cuenta nueva"); //
           System.out.println("2. Validar usuario y contraseña"); //
           System.out.println("3. Modificar datos propietario (nombre,primer apellido y segundo apellido)"); 
           System.out.println("4. Cambiar número secreto");
           System.out.println("5. Eliminar cuenta bancaria");    
           System.out.println("6. Obtener cuenta en base al ID");
           System.out.println("7. Listar todas las cuentas"); //
           System.out.println("8. Insertar operación con todos sus campos");
           System.out.println("9. Listar cuentas en números rojos");
           System.out.println("10. Obtener todas las operaciones de una cuenta");
           System.out.println("11. Obtener fecha-hora del último inicio de sesión de un usuario");
           System.out.println("12. Obtener ranking de las cuentas en números rojos");
           System.out.println("13. Obtener posición de una cuenta en el ranking de números rojos");     
           System.out.println("14. Borrar base de datos");     
           System.out.println("---------------------------------------------------------------------");
           System.out.println("Escribe una de las opciones");
           
            salir = false;      
            boolean valorValido=false;
            int opcion=0;
            
           while (valorValido!=true){
           try{         
               System.out.println("Escoge una opción: ");
               Scanner sn = new Scanner(System.in);
               opcion = sn.nextInt();
               valorValido=true;
           }catch(Exception e){
                System.out.println("Por favor introduce un valor entero");
           }
           }
           System.out.println("*********************************************************************");
           System.out.println("*********************************************************************");
           
            switch(opcion){
                case 0:
                    System.out.println("Mostrando todas las cuentas"); 
                    db.obtenerTodasLasCuentas();
                    break;
                case 1:
                    System.out.println("Cuenta insertada");
                    db.insertarCuenta(new CuentasBancarias("222222","67854736C",300.0)); 
                    break;
                case 2:
                    System.out.println("Validando usuario...");
                    db.validarUsuario("BrianGoetzSaez","557845"); 
                    break;
                case 3:
                    System.out.println("Modificando datos de propietario...");
                    db.modificarDatosPropietario("Jon","Galvez","Murua"); 
                    System.out.println("Datos modificados");
                    break;
                case 4:
                    System.out.println("Cambiando número secreto...");
                    db.cambiarNumeroSecreto("67854736C"); 
                    System.out.println("Numero cambiado");
                    break;
                case 5:
                     System.out.println("Eliminando cuenta...");
                    db.eliminarCuenta("447756", "67111736Z",3546.34);
                    System.out.println("Cuenta eliminada");
                    break;
                case 6:
                    System.out.println("Buscando cuenta por ID...");
                    db.obtenerCuentaPorId("012345"); 
                    break;
                case 7:
                    System.out.println("Mostrando cuentas...");
                    db.obtenerTodasLasCuentas();  
                    break;
                case 8:
                    System.out.println("Insertando operacion...");
                    Date dateTest=parseDate("2013-12-14");
                    System.out.println("Operacion insertada");
                    break;
                case 9:
                    System.out.println("Listando cuentas en numeros rojos...");
                    db.listarCuentasEnNumerosRojos(); 
                    break;

                case 10:
                    System.out.println("Obteniendo operaciones por cuenta...");
                    db.obtenerTodasOperacionesPorCuenta("125436"); 
                    break;
                case 11:
                    System.out.println("Obteniendo fecha-hora ultimo inicio de sesión...");
                    break;
                case 12:
                    System.out.println("Obteniendo ranking de numeros rojos...");
                    db.rankingNumerosRojos();
                    break;
                case 13:
                    System.out.println("Obteniendo posicion de cuenta en el ranking de numeros rojos...");
                    break;
                case 14:
                    System.out.println("Borrando todos los registros...");
                    db.borrarTodo();
                    break;

       }
            
       }
       

    }
    
}
