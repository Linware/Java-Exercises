import java.util.Random;
class Lista {
	private int plazas[];
	private int plazasTotales;
	private int vacios;
	Random aleatorio = new Random();
	Lista (int n){
		plazasTotales=n;
		plazas = new int[n];
		for (int i=0; i<plazasTotales; i++) {
			plazas[i] = 0;
		}
		vacios = plazasTotales;
	}
	synchronized public int poner(int hilo) throws 	InterruptedException {

		int posicion=0;
		while (vacios == 0) {
			System.out.println(hilo + " esperando");
			wait();
		}

		while (plazas[posicion] != 0) {
			posicion++;
		}
		plazas[posicion] = hilo;
		vacios--;
		return posicion;
	}
	synchronized public void calcular(int hilo) throws 	InterruptedException  {

		while (vacios > 0) {
			System.out.println("--- Servicio parking en espera ----");
			wait();
		}

		for (int i=0; i<plazasTotales; i++) {
			plazas[i] = 0;
		}
		vacios = plazasTotales;
		imprimir();
		notify();
	}
	public void imprimir() {
		System.out.print("Valores: ");
		for (int i=0; i<plazasTotales; i++) {
			System.out.print("[" + plazas[i] + "]" );
		}
		System.out.println("");
	}
}

class EntrarCoche extends Thread {
	private int delay = (int)(Math.random() * 1000);
	private int id;
	private Lista l1;
	EntrarCoche (int id, Lista listanum) {
		this.id = id;
		this.l1 = listanum;
	}

	public void run() {
		try {
			int delayEspera=(int)new Random().nextInt(delay);
			Thread.sleep(delayEspera);
			int numero = l1.poner(id);
			System.out.println("El tiempo de espera es de "+delayEspera+" milisegundos");
			System.out.println("Coche " + id + " ha aparcado en la plaza " + (numero+1));
			l1.imprimir();
			l1.calcular(id);
			Thread.sleep(new  Random().nextInt(delay));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
}
public class ParkingCoches {
	private static final int numPlazas=5;
	private static final int numhilos=5;
	
	public static void main(String[] args) {
		
		System.out.println("El parking esta vacio");
	
		//Inicializar el array
		Lista l = new Lista(numPlazas);

		EntrarCoche hilos[] = new EntrarCoche[numhilos];
		for (int i= 0; i < numhilos; i++){
			hilos[i]= new EntrarCoche(i+1, l);
			hilos[i].start();
		}
		try {
			for (int i= 0; i < numhilos; i++){
				hilos[i].join();
			}
		} catch (InterruptedException ex) {
			System.out.println("Error en hilo principal.");
		}
	}
}

