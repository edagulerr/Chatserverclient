package socketapp;
 
import java.io.*;
import java.net.*;
 
public class server {
 
     public static void main(String[] args) throws IOException {
          String clientGelen;
          ServerSocket serverSocket = null;
          Socket clientSocket = null;
 
          int sayi;
 
          try {
               //*Server 7755 portundan Client'� dinliyor *//
               serverSocket = new ServerSocket(8080);
          } catch (Exception e) {
               System.out.println("Port Hatas�!");
          }
          System.out.println("SERVER BA�LANTI ���N HAZIR...");
          //* Ba�lant� sa�lamadan program bir alt sat�rdaki kod par�as�na ge�mez (accept) *//
          clientSocket = serverSocket.accept();
 
          //* Client'a veri g�nderimi i�in kulland���m�z PrintWriter nesnesi olu�turulur *//
          PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
 
          //* Client'dan gelen verileri tutan BufferedReader nesnesi olu�turulur *//
          BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
 
          while((clientGelen = in.readLine()) != null) {
               System.out.println("Client'dan gelen veri = " + clientGelen);
               sayi = Integer.valueOf(clientGelen);
               out.println(sayi*sayi);
          }
          out.close();
          in.close();
          clientSocket.close();
          serverSocket.close();
     }
}