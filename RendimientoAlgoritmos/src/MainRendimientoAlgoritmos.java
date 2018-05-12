import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class MainRendimientoAlgoritmos {

	public static void main(String[] args) {

		String textoPrueba="Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet ut et voluptates repudiandae sint et molestiae non recusandae. Itaque earum rerum hic tenetur a sapiente delectus, ut aut reiciendis voluptatibus maiores alias consequatur aut perferendis doloribus asperiores repellat.Limita al norte con Alemania, al oeste con Francia, al sur con Italia y al este con Austria y Liechtenstein. Se caracteriza diplom�ticamente por su pol�tica de relaciones exteriores neutral, sin haber participado activamente en ning�n conflicto internacional desde 1815. Suiza es la sede de varias organizaciones internacionales, como la Organizaci�n Mundial del Movimiento Scout, la Cruz Roja, la Organizaci�n Mundial del Comercio, la Uni�n Postal Universal, as� como una de las dos oficinas de la ONU en Europa, adem�s de ser sede de la FIFA, m�ximo organismo del f�tbol a escala mundial, y de la UEFA, mayor ente del f�tbol europeo; tambi�n es sede del COI, m�ximo organismo encargado de la realizaci�n de los Juegos Ol�mpicos y de la FIDE, m�ximo organismo del ajedrez en el �mbito mundial.\r\n" + 
				"\r\n" + 
				"Suiza es una confederaci�n multiling�e y cuenta con cuatro idiomas oficiales: alem�n, franc�s, italiano y romanche. La fecha de su creaci�n como Estado se fij� el 1 de agosto de 1291 de acuerdo con la tradici�n. Debido a este motivo, cada a�o se celebra la fiesta nacional el 1 de agosto.\r\n" + 
				"\r\n" + 
				"A trav�s de numerosos ensayos, ha estudiado el texto, los aspectos de su lenguaje, morfolog�a, or�genes y mecanismos constitutivos. En los tres tomos de Figures (1966-1972), que le consagran, explora los distintos aspectos de una verdadera ciencia de la narrativa que �l denomina �Narratolog�a�. Tambi�n trata sobre el problema de la clasificaci�n de los g�neros literarios en Introduction � l'architexte (1979), y sobre las relaciones de los textos con ellos mismos y con los dem�s textos, la llamada intertextualidad, en Palimpsestes, la litt�rature au second degr� (Palimpsestos, la literatura en segundo grado), 1982. Con Seuils (1987), Genette se interesa por el entorno del texto en forma de libro y todo lo que lo acompa�a y hace existir en tanto que objeto accesible o paratexto: as� pues, se centra en la presentaci�n editorial y los diversos textos de comentario.\r\n" + 
				"\r\n" + 
				"En otros aspectos �como el pol�tico�, Genette es miembro del grupo Socialismo o barbarie. Su influjo internacional no ha sido tan grande como otras figuras del estructuralismo; y su obra, se discute acad�micamente m�s bien en antolog�as o en escritos que analizan categor�as literarias. Pero el conjunto de los libros de Genette ha conocido un �xito llamativo, porque ha sabido encontrar un tono particular, mezcla de duda y saber, de erudici�n y humor, y sin excluir nunca profundidad de an�lisis e intenci�n cr�tica.\r\n" + 
				"\r\n" + 
				"En su abecedario ir�nico de 2006, \"Bardadrac\" (palabra inventada por una amiga suya para designar el revoltijo de su bolso) incorpora de todo: reflexiones sobre la sociedad y sus estereotipos; recuerdos de infancia y juventud (comprometida en pol�tica); evocaci�n de grandes figuras intelectuales, como Roland Barthes o Jorge Luis Borges; ciudades, r�os, mujeres, m�sica de todo tipo; consideraciones sobre literatura y lenguaje, sobre todo en sus codificaciones m�s difundidas y distorsionadas.\r\n" + 
				"\r\n" + 
				"Sus libros han sido publicados, en Par�s, por las �ditions du Seuil.";
		
		byte texto[] = null;
		int pedazos=0;
		Cipher cifrador = null;
		byte[] mensajeCifrado = null;
		int contadorPedazos=0;
		double tiempoTotalAES=0.0;

		//Probamos con AES		
		
		try {
			KeyGenerator kg=KeyGenerator.getInstance("AES");
			kg.init(128);
			SecretKey clave= kg.generateKey();

			Cipher c=Cipher.getInstance("AES");
			c.init(Cipher.ENCRYPT_MODE, clave);
			
			texto = textoPrueba.getBytes();
			
			double tiempoAES=System.nanoTime();
			byte textoCifrado[]=c.doFinal(texto);
			tiempoTotalAES= System.nanoTime()-tiempoAES;
			//System.out.println("Encriptado: "+new String(textoCifrado));
			
			/*
			c.init(Cipher.DECRYPT_MODE, clave);
			byte desencriptado[]=c.doFinal(textoCifrado);
			System.out.println("Desencriptado: "+new String(desencriptado));
			*/
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("El tiempo para el algoritmo AES es de: "+tiempoTotalAES);
		
		//Probamos con RSA
		
		double tiempoDES=0.0;
		double tiempoParcialDES=0.0;
		
		try {
			if(texto.length>245) {
				
				pedazos=(int) Math.ceil(texto.length/245);
				
			}
			
			//System.out.println("Creaci�n de la clave p�blica y privada");
			KeyPairGenerator keyGen=KeyPairGenerator.getInstance("RSA");
			keyGen.initialize(2048);
			KeyPair clavesRSA=keyGen.generateKeyPair();
			
			PrivateKey clavePrivada=clavesRSA.getPrivate();
			PublicKey clavePublica=clavesRSA.getPublic();
			//System.out.println("Clave p�blica: "+ clavePublica);
			//System.out.println("Clave privada: "+ clavePrivada);
			
			for(int i=0;i<pedazos;i++) {
				try {			
					if(contadorPedazos+244<texto.length) {
						String textoPrueba2=textoPrueba.substring(contadorPedazos,(contadorPedazos+244));
						contadorPedazos+=244;
						
						byte mensaje[] = textoPrueba2.getBytes();
						
						cifrador=Cipher.getInstance("RSA");
						cifrador.init(Cipher.ENCRYPT_MODE, clavePublica);
						//System.out.println("Cifrar con clave p�blica el texto: "+new String(mensaje));
						mensajeCifrado=cifrador.doFinal(mensaje);
						if(tiempoParcialDES==0) {
						tiempoParcialDES=System.nanoTime();
						}else {
						double diferencia=System.nanoTime()-tiempoParcialDES;
						tiempoParcialDES+=diferencia;
						}
						//System.out.println("Texto CIFRADO: "+new String(mensajeCifrado));		
					}
				}catch(Exception e) {
					System.out.println("No hay mas texto");}
				}
			
			double tiempoTotalDES=System.nanoTime()-tiempoParcialDES;
			System.out.println("El tiempo total para el algoritmo DES es de: "+tiempoTotalDES);
			
				
/*
			
			cifrador.init(Cipher.DECRYPT_MODE,clavePrivada);
			System.out.println("Descifrar con la clave privada");
			
			byte[] mensajeDescifrado=cifrador.doFinal(mensajeCifrado);
			System.out.println("Texto DESCIFRADO: "+ new String(mensajeDescifrado));
			*/
				
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		//Probamos con TripleDES

		try {
        final MessageDigest md = MessageDigest.getInstance("md5");
        final byte[] digestOfPassword = md.digest("HG58YZ3CR9"
                .getBytes("utf-8"));
        final byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
        for (int j = 0, k = 16; j < 8;) {
            keyBytes[k++] = keyBytes[j++];
        }

        final SecretKey key = new SecretKeySpec(keyBytes, "DESede");
        final IvParameterSpec iv = new IvParameterSpec(new byte[8]);
        final Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key, iv);

        final byte[] plainTextBytes = textoPrueba.getBytes("utf-8");
        double tiempoParcialTRIPLEDES=System.nanoTime();
        final byte[] cipherText = cipher.doFinal(plainTextBytes);
        double tiempoTotalTRIPLEDES=System.nanoTime()-tiempoParcialTRIPLEDES;
        System.out.println("El tiempo total para el algoritmo DES es de: "+tiempoTotalTRIPLEDES);
		}catch(Exception e) {
			System.out.println("Algo ha ido mal");
		}
		
		
		
        
		
		
	}

}
