/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primerparcial_yftg_astc;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class CotizadorTCP { // SERVIDOR TCP
    public static void main(String[] args) {
        int port = 5002; // ! puerto del TCP
        do{
            try {
                ServerSocket server = new ServerSocket(port);
                System.out.println("\nServidor CotizadorTCP listo");
                Socket client;
                PrintStream toClient;
                client = server.accept(); // conexion 
                BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream())); // el lector
                System.out.println("Cliente se conecto");
                String cadena = fromClient.readLine();
                System.out.println("La fecha recibida es " + cadena);
                toClient = new PrintStream(client.getOutputStream());
                String respuesta = "7";
                toClient.println(respuesta);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }while (true);
    }
}

