package ahorcadotcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTCP {

  public static void main(String[] args) {
    int port = 5011;
    // TO_CLIENT -- guia

    try {
      ServerSocket server = new ServerSocket(port); // server localhost, port 5010
      System.out.println("Se inicio el servidor con exito");

      Socket client;
      PrintStream toClient;
      Ahorcado ahorcado = new Ahorcado();
      String cadena = "";

      while (true) {
        // conexion
        client = server.accept(); // ESPERA a que se conecte un cliente

        // + recibe del cliente el mensaje
        BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
        // + envia al cliente el mensaje
        toClient = new PrintStream(client.getOutputStream());

        // System.out.println("Cliente se conecto");
        cadena = fromClient.readLine(); // lee la opcion del cliente OPCION
        System.out.println(cadena); // muestra el mensaje recibido

        // Termina la ejecucuion del Servidor
        if (cadena.equals("F")) { // finalizar el juego --> F
          System.out.println("El juego ha finalizado");
          System.out.println("SERVIDOR TERMINO LA EJECUCION");
          client.close();
          
          break;
        }

        if (cadena.equals("S")) {
          // Instancia cada vez que vuelva a jugar para generar una palabra distinta
          ahorcado = new Ahorcado();
          toClient.println(ahorcado.getPalabra().length()); // +envia la longitud de la palabra al cliente l.37
        } else {
          // Verifica si la letra se encuentra o no
          ahorcado.verificarLetra(cadena.charAt(0));

          // Da un formato legible al cliente
          String palabraForm = "";
          for (int i = 0; i < ahorcado.getPalabraFormada().length(); i++)
            palabraForm += ahorcado.getPalabraFormada().charAt(i) + " ";  

          // Envia el estado al cliente
          if (ahorcado.getVida() > 0) {
            if (ahorcado.gana())
              toClient.println("Felicidades gano! la palabra es: " + ahorcado.getPalabra());
            else
              toClient.println(palabraForm + "\t" + "vidas: " + ahorcado.getVida());
          } else
            toClient.println("Ups.. Perdiste! la palabra era: " + ahorcado.getPalabra());

        }
        System.out.println("Cliente se conecto");
      }
      server.close();
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }
}
