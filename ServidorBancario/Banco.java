import java.rmi.Remote; 
import java.rmi.RemoteException;  
public interface Banco extends Remote { 
    public double cuotaMensual(double capital, double interes, double plazo)throws RemoteException; 
    
    public double ingresar(double capital)throws RemoteException;
    
    public double retirar(double capital) throws RemoteException;
    
    public void mostrarSaldo() throws RemoteException;
    
    public void cerrarConexion() throws RemoteException;       	
       
} 

