
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClienteTCP {
	
	
	public static void main(String[] args) throws IOException {

	    Scanner teclado = new Scanner(System.in);
	    System.out.println("Endereço do host:");
	    String host = teclado.nextLine();
	    System.out.println("Porta do host:");
	    int port= teclado.nextInt();
	    
	        Socket cliente = new Socket(host, port);
	        System.out.println("Conexão Estabilizada:"); 
	            
	        PrintStream saida = new PrintStream(cliente.getOutputStream()); 
	        while (teclado.hasNextLine()) {
	            saida.println(teclado.nextLine());
	        }
	            
	    }
	}


