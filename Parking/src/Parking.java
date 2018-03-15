class Plazas {
  int totalPlazasLibres=5;
  int totalPlazasOcupadas=0;
  int n;
  
  public int getTotalPlazasOcupadas() {
	return totalPlazasOcupadas;
  }
  public void setTotalPlazasOcupadas(int totalPlazasOcupadas) {
	this.totalPlazasOcupadas = totalPlazasOcupadas;
  }

  boolean hayValores = false;
  synchronized int get() {
	 if(!hayValores)
      try {
    	     wait();
      } catch(InterruptedException e) {
        System.out.println("InterruptedException capturada");
      }
    System.out.println("Nº plazas libres: " + n);
    hayValores = false;
    notify();
    return n;
  }
  public int getTotalPlazas() {
	return totalPlazasLibres;
}
public void setTotalPlazas(int totalPlazas) {
	this.totalPlazasLibres = totalPlazas;
}
synchronized void put(int n) {
    if(hayValores)
      try {
        wait();
      } catch(InterruptedException e) {
        System.out.println("InterruptedException capturada");
      }
    this.n = n;
    hayValores = true;
    System.out.println("Entra un coche: " + n);
    notify();
  }
}
class Productor implements Runnable {
  Plazas q;
  Productor(Plazas q) {
    this.q = q;
    new Thread(this, "Plaza").start();
  }
  public void run() {
    int i = 0;
    for (int j = 1; j <= q.getTotalPlazas(); j++) {
      q.put(i++);
    }
  }
}
class Consumidor implements Runnable {
  Plazas q;
  Consumidor(Plazas q) {
    this.q = q;
    new Thread(this, "Coche").start();
  }
  public void run() {
	  for (int j = 1; j <= q.getTotalPlazas(); j++) {
      q.get();
    }
  }
}

public class Parking {

	public static void main(String[] args) {
	    Plazas q = new Plazas();
	    new Productor(q);
	    new Consumidor(q);
	}

}



