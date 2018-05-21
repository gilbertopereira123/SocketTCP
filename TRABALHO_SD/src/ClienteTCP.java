
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClienteTCP {
	
	
	public static void main(String[] args) throws IOException {

	    Scanner teclado = new Scanner(System.in);
	    System.out.println("Host address:");
	    String host = teclado.nextLine();
	    System.out.println("Host port: ");
	    int port= teclado.nextInt();
	    
	        Socket cliente = new Socket(host, port);
	        System.out.println("Connection Established: "); 
	            
	        PrintStream saida = new PrintStream(cliente.getOutputStream()); 
	        while (teclado.hasNextLine()) {
	            saida.println(teclado.nextLine());
	        }
	            
	    }
	}


