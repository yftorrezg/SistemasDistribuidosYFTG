/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primerparcial_yftg_astc;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PlataformaIntercambio extends UnicastRemoteObject implements IPlataformaIntercambio {

    public PlataformaIntercambio() throws RemoteException {
        super();
    }

    @Override
    public boolean realizarTransaccion(String idCliente, String idVendedor, float monto, String moneda)
            throws RemoteException {
        int puerto = 6789; // ! puerto del UDP
        int port = 5002; // ! puerto del TCP
        boolean transaccion = false;
        int opcion = Integer.valueOf(idCliente);
        Scanner sc = new Scanner(System.in);

        try {

            switch (opcion) {
                case 1: // + probar con 500
                    // ! RMI
                    IBanco1 banco1 = (IBanco1) Naming.lookup("//127.0.0.1/Banco1"); 
                    System.out.println("Quiere retirar o abonar?\n 1.Abonar \n 2.Retirar");
                    String accion = sc.nextLine();
                    if (accion.equals("1")) {
                        transaccion = banco1.abonar(idCliente, monto);
                        System.out.println(banco1.abonar(idCliente, monto));
                    } else if (accion.equals("2")) {
                        transaccion = banco1.retirar(idCliente, monto);
                        // transaccion=banco1.retirar(idCliente, monto);
                        System.out.println(banco1.retirar(idCliente, monto));
                    }
                    break;
                case 2:
                /*
                    ENUNCIADO:
                    Elbanco3 es un servidor UDP que se envia el protocolo
                    ! OPREACION:IDCLIENTE:MONTO 
                    y devuelve el resultado verdadero falso
                 */
                    // ! SOKETS UDP
                    String dato = "";
                    String ip = "localhost";
                    DatagramSocket socketUDP = new DatagramSocket();
                    InetAddress hostServidor = InetAddress.getByName(ip);

                    System.out.println("Quiere retirar o abonar?\n 1.Abonar \n 2.Retirar");
                    accion = sc.nextLine();
                    // ! OPREACION:IDCLIENTE:MONTO
                    if (accion.equals("1")) {
                        dato = "abonar"+":"+idCliente + ":" + monto; //! separacion de la cadena
                    } else {
                        dato = "retirar"+":"+idCliente + ":" + monto; // ! separacion de la cadena
                    }

                    byte[] datobanco3 = dato.getBytes();
                    // Construimos un datagrama para enviar el mensaje al servidor
                    DatagramPacket peticion = new DatagramPacket(datobanco3, dato.length(), hostServidor,
                            puerto);

                    // Enviamos el datagrama
                    socketUDP.send(peticion);

                    // Construimos el DatagramPacket que contendrá la respuesta
                    byte[] bufer = new byte[1000];
                    DatagramPacket respuesta = new DatagramPacket(bufer, bufer.length);
                    socketUDP.receive(respuesta);
                    
                    String dato2 = new String(respuesta.getData()).trim();
                    if (dato2.equals("true")) {
                        transaccion = true;
                    } else {
                        transaccion = false;
                    }
                    System.out.println(transaccion);
                    break;
                case 3:
                    // ! RMI
                    IBanco1 aux = (IBanco1) Naming.lookup("//127.0.0.1/Banco1"); // usamos aux xk similiar al caso 1
                    System.out.println("Quiere retirar o abonar?\n 1.Abonar \n 2.Retirar");
                    accion = sc.nextLine();
                    if (accion.equals("1")) {
                        transaccion = aux.abonar(idCliente, monto);
                        System.out.println(aux.abonar(idCliente, monto));
                    } else if (accion.equals("2")) {
                        transaccion = aux.retirar(idCliente, monto);
                        System.out.println(aux.retirar(idCliente, monto));
                    }
                    break;

                case 4:
                    // ! RMI

                    IBanco2 banco2 = (IBanco2) Naming.lookup("//127.0.0.1/Banco2");
                    System.out.println("Quiere retirar o abonar?\n 1.Abonar \n 2.Retirar");
                    accion = sc.nextLine();
                    if (accion.equals("1")) {
                        transaccion = banco2.abonar(idCliente, monto);
                        System.out.println(banco2.abonar(idCliente, monto));
                    } else if (accion.equals("2")) {
                        transaccion = banco2.retirar(idCliente, monto);
                        System.out.println(banco2.retirar(idCliente, monto));
                    }

                    break;
                default:
                    break; 

            }
            // RMI

            // ! Sokects TCP
            Socket client = new Socket("localhost", port);
            PrintStream toServer = new PrintStream(client.getOutputStream());
            BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String fecha = "03/11/2022";
            toServer.println(fecha);
            String result = fromServer.readLine();

            System.out.println(result); // + IMPRIME EL 7

        } catch (NotBoundException | IOException ex) {
            Logger.getLogger(PlataformaIntercambio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return transaccion;

    }

}

