package soquetsudp;
import java.net.*;
import java.io.*;
public class ClientUDP {
  // Los argumentos proporcionan el mensaje y el nombre del servidor
  public static void main(String args[]) {
    int puerto = 6789;
    try {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      // bandera del while. mientras verdadero
      boolean flag=true;
      do {
        System.out.print("Introduzca un numero para su factorial: ");
        String numero = br.readLine();
        // Construimos un datagrama para enviar el mensaje al servidor
        if (numero.equals("0"))flag=false;
        DatagramSocket socketUDP = new DatagramSocket();
        byte[] mensaje = numero.getBytes();
        InetAddress hostServidor = InetAddress.getByName("localhost");
        int puertoServidor = puerto;
        DatagramPacket peticion =
          new DatagramPacket(mensaje, numero.length(), hostServidor,
                             puertoServidor);
        // Enviamos el datagrama
        socketUDP.send(peticion);
        // Construimos el DatagramPacket que contendrĂ¡ la respuesta
        byte[] bufer = new byte[1000];
        DatagramPacket respuesta =
          new DatagramPacket(bufer, bufer.length);
        // Leemos una respuesta del DatagramSocket
        socketUDP.receive(respuesta);
        // Enviamos la respuesta del servidor a la salida estandar
        System.out.println("Factorial de "+numero+" es: "+ new String(respuesta.getData()));
        // Cerramos el socket
        socketUDP.close();
      } while (flag);
    } catch (SocketException e) {
      System.out.println("Socket: " + e.getMessage());
    } catch (IOException e) {
      System.out.println("IO: " + e.getMessage());
    }
  }
}
