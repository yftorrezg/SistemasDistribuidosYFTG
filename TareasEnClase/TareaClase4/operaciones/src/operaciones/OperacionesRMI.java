package operaciones;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OperacionesRMI {
    /*
     * Desarrollar un programa utilizando la tecnología RMI en la cual el cliente
     * muestra las opciones ; 1.-introducir datos que introduce los valores de a y b
     * envía al método remoto anotar(a,b) para que se quede guardado para
     * posteriores operaciones la opción 2.sumar que llama al método remoto suma() y
     * muestra el resultado de sumar los valores almacenados en el servidor la
     * opción 3. que llama al método remoto restar() que muestra el resultado de la
     * resta los numero almacenados en el servidor y la opción 4 que termina la
     * sesión con el cliente
     */
    public static void main(String[] args) {
        boolean flag = true; // bandera para terminar la sesión
        IOperaciones operaciones;

        Scanner entrada = new Scanner(System.in);
        try {
            operaciones = (IOperaciones) Naming.lookup("rmi://localhost/Operaciones"); // instanciar un objeto remoto
            while (flag) {
                System.out.println("\n..:MENU OPERACIONES:..\n");
                System.out.print(
                        "1. Ingresar valores \n2. Sumar \n3. Restar \n4. Salir - Cerrar sesion \n\nIntroduzaca una opcion: ");

                int opcion = entrada.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.print("\nIntroduzca el primer numero: ");
                        int a = entrada.nextInt();
                        System.out.print("Introduzca el segundo numero: ");
                        int b = entrada.nextInt();
                        // llamar a anotar
                        operaciones.anotar(a, b);
                        break;
                    case 2:
                        // llamar a sumar
                        System.out.println("\nLa suma es: " + operaciones.sumar());
                        break;
                    case 3:
                        // llamar a restar
                        System.out.println("\nLa resta es: " + operaciones.restar());
                        break;
                    case 4:
                        // llamar a cerrarSesion
                        System.out.println("\nSesion cerrada");
                        if (operaciones.salir()) {
                            flag = false;
                        }
                }
                // entrada.close();
            }
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(OperacionesRMI.class.getName()).log(Level.SEVERE, null, ex);
        }
        entrada.close();
    }
}
