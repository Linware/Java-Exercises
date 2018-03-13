import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Minuto 37:16

class Tabla{
	private int contador=1;

	synchronized void CalcularTabla(int numero) {
		System.out.println("Tabla del "+numero);
		while(contador<=10) {
			System.out.println(numero+"*"+contador+" = "+numero*contador);
			contador++;
		}
	}
}

class Mostrar implements Runnable{
	int valorRecogido;
	Tabla tabla;
	Thread t;
	
	public Mostrar(Tabla targ,int valor) {
		tabla=targ;
		valorRecogido=valor;
		t=new Thread(this);
		t.start();
	}
	@Override
	public void run() {
		tabla.CalcularTabla(valorRecogido);		
	}
	
}

public class Tablas {

	public static void main(String[] args) {

		boolean salida=false;
		int valorEntero=0;
		int contador=0;
		int valor1=0;
		int valor2=0;
		int valor3=0;

		while(contador<3) {
			salida=false;
			System.out.println("Introduzca el "+(contador+1)+" º numero,por favor");
			try {
				BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
				
			    String sc1= br.readLine();
			    
			    while(salida==false){
			        
			    try{
			    	valorEntero=Integer.parseInt(sc1);
			        System.out.println("El valor introducido es: " +valorEntero);
			        salida=true;
			        
			    }catch(Exception e){
			        System.out.println("Valor no valido,por favor introduzca un double");
			        sc1=br.readLine();
			    }}

			}catch(IOException e) {
				System.out.println("Error: "+e.getMessage());
			}
			if(contador==0) {valor1=valorEntero;}
			if(contador==1) {valor2=valorEntero;}
			if(contador==2) {valor3=valorEntero;}
			contador++;
			
		}
			System.out.println("Resultado de la aplicación");
			Tabla tabla=new Tabla();
			Mostrar tab1=new Mostrar(tabla,valor1);
			Mostrar tab2=new Mostrar(tabla,valor2);
			Mostrar tab3=new Mostrar(tabla,valor3);
			
			try {
				tab1.t.join();
				tab2.t.join();
				tab3.t.join();
			}catch(Exception e){
				System.out.println("Error en la ordenación");
			}
			
	}

}
