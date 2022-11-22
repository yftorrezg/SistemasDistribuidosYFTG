package ahorcadotcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClienteTCP {

  public static void main(String[] args) {
    int port = 5011;
    // TO_SERVER -- guia
    Scanner input = new Scanner(System.in);
    try {
      String opcion;
      char letra;
      boolean inicio = true;
 
      do {

        Socket client = new Socket("localhost", port); // server localhost, port 5010.
        // + envia al servidor el mensaje
        PrintStream toServer = new PrintStream(client.getOutputStream());
        // + recibe del servidor el mensaje
        BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));

        // Inicio del juego
        if (inicio) {
          System.out.println("Quiere comenzar el juego del ahoracado? [S/N]");
          // convertir a mayuscula
          opcion = input.next().toUpperCase();
          // Comenzar el Juego
          if (opcion.equals("S")) {
            inicio = false;
            toServer.println(opcion); // envia al servidor la opcion
            String palabra = fromServer.readLine(); // +recibe la longitud de la palabra del servidor l.48
            System.out.println("La palabra que le toco es de: " + palabra + " Letras");
          } else {
            // Opcion para salir del juego
            System.out.println("Quiere Salir? [F/N]");
            opcion = input.next().toUpperCase();

            if (opcion.equals("F")) { // finalizar el juego --> F 
              toServer.println("F"); // finalizar el juego --> F
              break;
            } else
              System.out.println("Juegue cuando este listo!");
          }
        } else {
          // Envio de letras y recibo de respuestas
          System.out.println("Ingrese una Letra: ");
          letra = input.next().charAt(0); // captura la letra
          toServer.println(letra); // envia la letra al servidor
          String response = fromServer.readLine(); // 
          // System.out.println(response); // muestra el mensaje recibido
          if (response.charAt(0) == 'F') { 
            System.out.println(response); 
            inicio = true;
          } else
            System.out.println(response); 
        }
        client.close();
      } while (true);

    } catch (IOException e) {  // error de conexion
      System.out.println(e.getMessage()); 
    }
    input.close();
  }
}
