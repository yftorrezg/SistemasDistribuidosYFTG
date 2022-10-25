package primoudp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class PrimoUDP {

    public static void main(String args[]) {
        int port = 6789;
        try {
            DatagramSocket socketUDP = new DatagramSocket(port);
            byte[] bufer = new byte[1000];
            System.out.println(" Servidor iniciado con exito");
            while (true) {
                // Construimos el DatagramPacket para recibir peticiones
                DatagramPacket peticion
                        = new DatagramPacket(bufer, bufer.length);
                // Leemos una petición del DatagramSocket
                socketUDP.receive(peticion);
                System.out.print("Datagrama recibido del host: "
                        + peticion.getAddress());
                System.out.println(" desde el puerto remoto: "
                        + peticion.getPort());
                String cadena = new String(peticion.getData());
                int valor = Integer.valueOf(cadena.trim());
                System.out.println(" valor enviado: " + valor);
                // Construimos el DatagramPacket para enviar la respuesta
                // factorial
                boolean primo = true;
                for (int i = 2; i < valor; i++) {
                    if (valor % i == 0) {
                        primo = false;
                    }
                }

                String resp;
                if (primo) {
                    resp = "Si es primo";
                } else {
                    resp = "No es primo";
                }
                String response = String.valueOf(resp);
                byte[] mensaje = response.getBytes();
                DatagramPacket respuesta
                        = new DatagramPacket(mensaje, response.length(),
                                peticion.getAddress(), peticion.getPort());
                // Enviamos la respuesta, que es un eco
                socketUDP.send(respuesta);
                // CERRAR SOCQUET
                if (valor == 0) {
                    System.out.println("Cerrando el socket servidor");
                    socketUDP.close();
                }
            }
        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        }
    }
}
