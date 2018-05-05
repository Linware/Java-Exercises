import java.rmi.registry.Registry; 
import java.rmi.registry.LocateRegistry; 
import java.rmi.RemoteException; 
import java.rmi.server.UnicastRemoteObject; 

public class ServidorBanco  { 
           
      public static void main(String args[]) throws RemoteException{ 
      try { 
        
         // Creamos el registro
         Registry registry = LocateRegistry.createRegistry(9000); 
         // Instanciamos la implementación de la classe.
         Banco obj = new BancoImpl(); 
         // Exportamos el objeto de la classe implementada. 
         registry.rebind("Banco", obj);  
         
         System.err.println("Servidor Bancario en linea ...."); 
      } catch (Exception e) { 
         System.err.println("Error de Servidor: " + e.toString()); 
         e.printStackTrace(); 
      } 
   } 
} 

