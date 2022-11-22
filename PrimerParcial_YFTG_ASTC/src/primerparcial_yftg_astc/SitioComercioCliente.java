/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package primerparcial_yftg_astc;

/**
 *
 * @author LENOVO
 */

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SitioComercioCliente {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String idCliente, idVendedor;
        float monto;
        /*
         * Menu
         * Idcliente    1       3       4       2
         * Banco        1       1       2       3
         * Saldo        455     300     40      50
         */
        System.out.println("\n************* MENU  *************\n");
        System.out.println("IDClient\t1\t3\t4\t2");
        System.out.println("BANCO\t\t1\t1\t2\t3");
        System.out.println("SALDO\t\t455\t300\t40\t50");
        char opcion = 's';
        try {
            do {
                IPlataformaIntercambio op = (IPlataformaIntercambio) Naming.lookup("//127.0.0.1/PIntercambio");

                System.out.println("\nIntroduzca el IdCliente: ");
                idCliente = sc.nextLine();
                // id del vendedor seria el mismo q del cliente
                System.out.println("ID del vendedor seria el mismo q del cliente");
                System.out.println("idVendedor = " + idCliente);
                // consultar banco y saldos
                if (idCliente.equals("1")) {
                    System.out.println("\nBanco1\tSaldo = 455");
                } else if (idCliente.equals("3")) {
                    System.out.println("\nBanco1\tSaldo = 300");
                } else if (idCliente.equals("4")) {
                    System.out.println("\nBanco2\tSaldo = 40");
                } else if (idCliente.equals("2")) {
                    System.out.println("\nBanco3\tSaldo = 50");
                } else {
                    System.out.println("Lo siento, el idCliente no existe");
                }

                idVendedor = idCliente;
                System.out.println("Introduzca monto a retirar o abonar: ");
                monto = sc.nextFloat();
                boolean flag = op.realizarTransaccion(idCliente, idVendedor, monto, "bs");
                System.out.println(flag);

                if (flag == true) {
                    System.out.println("Transaccion realizado con exito");
                } else {
                    System.out.println("NO se pudo realizar su transaccion");
                }
                sc.nextLine();
                System.out.println("\nDesea continuar S/N");
                opcion = sc.nextLine().charAt(0);
            } while (opcion != 'n' || opcion != 'N');
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(SitioComercioCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
