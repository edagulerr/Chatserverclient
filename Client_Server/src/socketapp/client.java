package socketapp;
 
import java.io.*;
import java.net.*;
 
public class client {
 
     public static void main(String[] args) throws IOException {
          islem();
     }
 
     public static void islem() throws UnknownHostException, IOException {
          Socket socket = null;
          PrintWriter out = null;
          BufferedReader in = null;
          String deger;
          try {
               //* server 'a localhost ve 7755 portu �zerinden ba�lant� sa�lan�yor *//
               socket = new Socket("10.0.0.4", 8080);
          } catch (Exception e) {
               System.out.println("Port Hatas�!");
          }
        //* Server'a veri g�nderimi i�in kulland���m�z PrintWriter nesnesi olu�turduk *//
          out = new PrintWriter(socket.getOutputStream(), true);
 
          //* Server'dan gelen verileri tutan BufferedReader nesnesi olu�turulur *//
          in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
 
          System.out.println("Server'a g�nderilecek say�s� giriniz:");
 
          //* G�nderilecek say�n�n giri�i yap�l�yor *//
          BufferedReader data = new BufferedReader(new InputStreamReader(System.in));
 
          while((deger = data.readLine()) != null) {
               out.println(deger);
               System.out.println("Server'dan gelen sonu� = " + in.readLine());
               System.out.println("Server'a g�nderilecek says� giriniz");
          }
          out.close();
          in.close();
          data.close();
          socket.close();
     }
}