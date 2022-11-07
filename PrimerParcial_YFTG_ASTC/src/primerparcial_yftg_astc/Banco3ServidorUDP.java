/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primerparcial_yftg_astc;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Banco3ServidorUDP {
    public static void main(String args[]) {
        int port = 6789; // ! puerto del UDP
        try {
            DatagramSocket socketUDP = new DatagramSocket(port);
            byte[] bufer = new byte[3000]; // buffer de recepcion
            System.out.println("\nServidor Banco3 UDP listo");
            while (true) {
                // Construimos el DatagramPacket para recibir peticiones
                DatagramPacket peticion = new DatagramPacket(bufer, bufer.length);
                // Leemos una petición del DatagramSocket
                socketUDP.receive(peticion);
                System.out.print("Datagrama recibido del host: "+ peticion.getAddress());
                System.out.println("Desde el puerto remoto: "+ peticion.getPort());
                String cadena = new String(peticion.getData());
                // int valor = Integer.valueOf(cadena.trim());
                String[] datos = cadena.split(":");
                String desea = datos[0]; // retirar o abonar
                String id = datos[1]; // idCLiente = 2
                String monto = datos[2]; 
                boolean resp = Accion(desea,id, monto );
                String response = String.valueOf(resp);
                byte[] mensaje = response.getBytes();
                DatagramPacket respuesta = new DatagramPacket(mensaje, response.length(),
                        peticion.getAddress(), peticion.getPort());
                // Enviamos la respuesta, que es un eco
                socketUDP.send(respuesta);
            }
        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        }
    }

    // Probar con 2 de retirar y mayor a 50 
    public static boolean Accion(String accion, String id, String monto) {
        if (id.equals("2")) {
            return true;
        } else if (id.equals("2") && accion.equals("retirar") && Integer.valueOf(monto) <= 55) {
            return true;
        
        } else {
            return false;
        }
    }
}
