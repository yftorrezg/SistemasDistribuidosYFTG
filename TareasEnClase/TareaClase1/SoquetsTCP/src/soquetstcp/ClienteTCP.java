/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package soquetstcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author fer
 */
public class ClienteTCP {
    public static void main(String[] args) {
        // TODO code application logic here
        int port = 5002;
        Scanner sc = new Scanner(System.in);
        System.out.println("Por favor introduzca una cadena/frase: ");
        String cadena = sc.next();
        System.out.println("\n La cadena/frase introducida es: " + cadena);
        String aux = "";

        try {
            Socket client = new Socket("localhost", port);
            PrintStream toServer = new PrintStream(client.getOutputStream());
            BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
            toServer.println(cadena);
            String result = fromServer.readLine();
            System.out.println("\nCadena Invertida: " + result);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
