import java.rmi.*;
import java.rmi.server.*;

public class BancoImpl extends UnicastRemoteObject implements Banco  { 
 
	public static double capitalTotal=0;

    public BancoImpl() throws RemoteException {
		super();
		}
 
	public double cuotaMensual(double capital, double interes, double plazo){
        System.out.println("Calculando cuota...");
        //http://yirepa.es/calculo-cuota-frances.html
       	double plazos = plazo * 12.00;
        double interesMes = interes / 100/12;
		double calculo=(1-Math.pow(1+interesMes,-plazos));
        return ((capital * interesMes)/calculo);
}

	@Override
	public double ingresar(double capital) throws RemoteException {
		System.out.println("Preparando ingreso...");
		capitalTotal+=capital;
		System.out.println("Ingreso de "+capital+ " euros.Saldo actual "+capitalTotal);
		return capitalTotal;
	}

	@Override
	public double retirar(double capital) throws RemoteException {
		System.out.println("Preparando retirada...");
		capitalTotal-=capital;
		System.out.println("Reintegro de "+capital+ " euros.Saldo actual "+capitalTotal);
		return capitalTotal;
	}

	@Override
	public void mostrarSaldo() throws RemoteException {
		System.out.println("Su saldo actual es de: "+capitalTotal);
	}

	@Override
	public void cerrarConexion() throws RemoteException {
		 System.exit(0);
		
	} 
}
