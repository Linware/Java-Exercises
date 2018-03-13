import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Tabla{
	private int contador=1;

	void CalcularTabla(int numero) {
		System.out.println("Tabla del "+numero);
		while(contador<10) {
			System.out.println(numero+"*"+contador+" = "+numero*contador);
			contador++;
		}
	}
}

public class Tablas {

	public static void main(String[] args) {

		boolean salida=false;
		int valorEntero=0;
		System.out.println("Introduzca el primer numero,por favor");
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
			System.out.println("Resultado de la aplicación");
			Tabla tabla=new Tabla();
			tabla.CalcularTabla(valorEntero);
	}

}
