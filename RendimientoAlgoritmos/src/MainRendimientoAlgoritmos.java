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

		String textoPrueba="Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet ut et voluptates repudiandae sint et molestiae non recusandae. Itaque earum rerum hic tenetur a sapiente delectus, ut aut reiciendis voluptatibus maiores alias consequatur aut perferendis doloribus asperiores repellat.Limita al norte con Alemania, al oeste con Francia, al sur con Italia y al este con Austria y Liechtenstein. Se caracteriza diplomáticamente por su política de relaciones exteriores neutral, sin haber participado activamente en ningún conflicto internacional desde 1815. Suiza es la sede de varias organizaciones internacionales, como la Organización Mundial del Movimiento Scout, la Cruz Roja, la Organización Mundial del Comercio, la Unión Postal Universal, así como una de las dos oficinas de la ONU en Europa, además de ser sede de la FIFA, máximo organismo del fútbol a escala mundial, y de la UEFA, mayor ente del fútbol europeo; también es sede del COI, máximo organismo encargado de la realización de los Juegos Olímpicos y de la FIDE, máximo organismo del ajedrez en el ámbito mundial.\r\n" + 
				"\r\n" + 
				"Suiza es una confederación multilingüe y cuenta con cuatro idiomas oficiales: alemán, francés, italiano y romanche. La fecha de su creación como Estado se fijó el 1 de agosto de 1291 de acuerdo con la tradición. Debido a este motivo, cada año se celebra la fiesta nacional el 1 de agosto.\r\n" + 
				"\r\n" + 
				"A través de numerosos ensayos, ha estudiado el texto, los aspectos de su lenguaje, morfología, orígenes y mecanismos constitutivos. En los tres tomos de Figures (1966-1972), que le consagran, explora los distintos aspectos de una verdadera ciencia de la narrativa que él denomina «Narratología». También trata sobre el problema de la clasificación de los géneros literarios en Introduction à l'architexte (1979), y sobre las relaciones de los textos con ellos mismos y con los demás textos, la llamada intertextualidad, en Palimpsestes, la littérature au second degré (Palimpsestos, la literatura en segundo grado), 1982. Con Seuils (1987), Genette se interesa por el entorno del texto en forma de libro y todo lo que lo acompaña y hace existir en tanto que objeto accesible o paratexto: así pues, se centra en la presentación editorial y los diversos textos de comentario.\r\n" + 
				"\r\n" + 
				"En otros aspectos —como el político—, Genette es miembro del grupo Socialismo o barbarie. Su influjo internacional no ha sido tan grande como otras figuras del estructuralismo; y su obra, se discute académicamente más bien en antologías o en escritos que analizan categorías literarias. Pero el conjunto de los libros de Genette ha conocido un éxito llamativo, porque ha sabido encontrar un tono particular, mezcla de duda y saber, de erudición y humor, y sin excluir nunca profundidad de análisis e intención crítica.\r\n" + 
				"\r\n" + 
				"En su abecedario irónico de 2006, \"Bardadrac\" (palabra inventada por una amiga suya para designar el revoltijo de su bolso) incorpora de todo: reflexiones sobre la sociedad y sus estereotipos; recuerdos de infancia y juventud (comprometida en política); evocación de grandes figuras intelectuales, como Roland Barthes o Jorge Luis Borges; ciudades, ríos, mujeres, música de todo tipo; consideraciones sobre literatura y lenguaje, sobre todo en sus codificaciones más difundidas y distorsionadas.\r\n" + 
				"\r\n" + 
				"Sus libros han sido publicados, en París, por las Éditions du Seuil.";
		
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
			
			//System.out.println("Creación de la clave pública y privada");
			KeyPairGenerator keyGen=KeyPairGenerator.getInstance("RSA");
			keyGen.initialize(2048);
			KeyPair clavesRSA=keyGen.generateKeyPair();
			
			PrivateKey clavePrivada=clavesRSA.getPrivate();
			PublicKey clavePublica=clavesRSA.getPublic();
			//System.out.println("Clave pública: "+ clavePublica);
			//System.out.println("Clave privada: "+ clavePrivada);
			
			for(int i=0;i<pedazos;i++) {
				try {			
					if(contadorPedazos+244<texto.length) {
						String textoPrueba2=textoPrueba.substring(contadorPedazos,(contadorPedazos+244));
						contadorPedazos+=244;
						
						byte mensaje[] = textoPrueba2.getBytes();
						
						cifrador=Cipher.getInstance("RSA");
						cifrador.init(Cipher.ENCRYPT_MODE, clavePublica);
						//System.out.println("Cifrar con clave pública el texto: "+new String(mensaje));
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
