/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package soquetstcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author fer
 */
public class ServidorTCP {

    public static void main(String[] args) {
        int port = 5002;

        try {
            // server
            ServerSocket server = new ServerSocket(port);
            System.out.println("Se inicio el servidor con éxito");
            Socket client;
            PrintStream toClient;
            client = server.accept(); // conexion
            BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream())); // el lector
            System.out.println("Cliente se conecto");
            // System.out.println(fromClient.readLine());
            // CAMBIOS AL CODIGO
            String cadena = fromClient.readLine();
            String cadenaInvertida = invertirString(cadena);
            toClient = new PrintStream(client.getOutputStream());
            toClient.println(cadenaInvertida);
            System.out.println("Cliente se conecto");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    static String invertirString(String cadena) {
        String aux = "";
        if (cadena == null) {
            return "Cadena erronea";
        }
        for (int i = cadena.length() - 1; i >= 0; i--) {
            aux += cadena.charAt(i);
        }

        return aux;
    }

}
