import java.net.*;
import java.io.*;
import java.util.Scanner;


public class ServidorTCP{
	
static Socket cliente;

static ServerSocket servidor;

public static void main(String[] args) throws IOException {

    Scanner teclado = new Scanner(System.in);
    System.out.println("Host port: ");
    int port= teclado.nextInt();
    
    servidor = new ServerSocket(port);
    System.out.println("Server listening on " + port);      
    cliente = servidor.accept();
    System.out.println("Client " + cliente.getInetAddress().getHostAddress() + " connected on " + port); 
Thread t = new Thread(new Runnable() {
public void run() {
try { 
Scanner entrada = new Scanner(cliente.getInputStream());
while(entrada.hasNextLine()){
String text = entrada.nextLine();
if(text.equals("[q]")) {
break;
}
System.out.println(text);
}
entrada.close();
cliente.close();
servidor.close();
} catch(Exception e) {

  	}
  }
});
t.start();
Thread t1 = new Thread(new Runnable() {
public void run() {
try { 
PrintStream saida = new PrintStream(cliente.getOutputStream());
while (teclado.hasNextLine()) {
String palavra = teclado.nextLine();
if(palavra.equals("[q]")) {
//saida.println(“Client disconnected”);
saida.println(palavra);
break;
} else {
saida.println(teclado.nextLine());
}
}
servidor.close();
cliente.close();
} catch(Exception e) {

  	}
  }
});
t1.start();
// servidor.close();
}
}