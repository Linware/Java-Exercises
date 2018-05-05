import java.rmi.registry.LocateRegistry; 
import java.rmi.registry.Registry; 
import java.text.*;
import java.util.ArrayList;
import java.util.Scanner; 

public class ClienteBanco {  
   private ClienteBanco() {}  
   public static boolean salida=false;
   public static void main(String[] args) {  
      try {  
         // Obtenemos el registro
         Registry registry = LocateRegistry.getRegistry("localhost",9000); 
         // Buscamos en el registro el objeto remoto.
         Banco obj = (Banco) registry.lookup("Banco"); 
    
         while (salida!=true) {
        	 System.out.println("**********************");
        	 System.out.println("Elija una opción: ");
        	 System.out.println("Escriba \"i\" mas la cantidad deseada para realizar un ingreso.Ejemplo: [i 300]");
        	 System.out.println("Escriba \"r\" mas la cantidad deseada para realizar una retirada.Ejemplo: [r 300]");
        	 System.out.println("Escriba \"s\" para consultar su saldo.Ejemplo: [s]");
        	 System.out.println("Escriba \"f\" para cerrar la conexión con el servidor.Ejemplo: [f]");   	 
        	 System.out.println("**********************");
        	 
        	 Scanner sc=new Scanner(System.in);
        	 String respuesta=sc.nextLine();
        	 
        	 ArrayList<String> respuestaFinal = new ArrayList<String>();
        	 
        	 if(!respuesta.equals("s")) {
        		 String[] arrayRespuestaFinal=respuesta.split(" ");
        		 respuestaFinal.add(0, arrayRespuestaFinal[0]);
        		 respuestaFinal.add(1, arrayRespuestaFinal[1]);
        	 
        	 //Filtros ordenes
        	 if (respuestaFinal.size()>=2 || !respuestaFinal.equals("s")) {respuestaFinal.add("k");}
        	 
        	 try {
        		 double pruebaCantidad=Double.parseDouble(respuestaFinal.get(1));
        	 }catch(Exception e) {
        		 respuestaFinal.add("k");
        	 }
        	 }else {
        		 respuestaFinal.add("s");
        	 }
        	 //Selección en menu
        	 
        	 switch(respuestaFinal.get(0)){
        	 case "i":
        		 System.out.println("Has seleccionado la opción \'INGRESAR\' una cantidad de "+ respuestaFinal.get(1)+" euros");
        		 obj.ingresar(Double.parseDouble(respuestaFinal.get(1)));
        		 break;
        	 case "r":
        		 System.out.println("Has seleccionado la opción \'RETIRAR\' una cantidad de "+ respuestaFinal.get(1)+" euros");
        		 obj.retirar(Double.parseDouble(respuestaFinal.get(1)));
        		 break;
        	 case "s":
        		 System.out.println("Has seleccionado la opción \'VER SALDO\'");
        		 obj.mostrarSaldo();
        		 break;
        	 case "f":
        		 System.out.println("Has seleccionado la opción \'CERRAR CONEXIÓN\'");
        		 salida=true;
        		 break;
        	default:
        		System.out.println("Comando NO valido,por favor, pruebe otra vez");
        		 
        	 }
       	 
         }
         
		} catch (Exception e) {
         System.err.println("Client exception: " + e.toString()); 
         e.printStackTrace(); 
      } 
   } 
}

