/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primerparcial_yftg_astc;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
// import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Banco2ServidorRMI {
    public static void main(String[] args) {
        try {
            Banco2 banco2; // ? R: es el objeto remoto que se va a registrar en el servidor RMI
            banco2 = new Banco2(); // ? R: se crea el objeto remoto
            Naming.bind("Banco2", banco2); // ? R: se registra el objeto remoto en el servidor RMI
           /*  
           Registry registro = java.rmi.registry.LocateRegistry.createRegistry(1098);
            registro.bind("Banco2", new Banco2()); 
            */
            System.out.println("\nServidor Banco 2 listo");
            
       /*
        * // +no da
        * } catch (RemoteException | AlreadyBoundException ex) {
        * Logger.getLogger(Banco2ServidorRMI.class.getName()).log(Level.SEVERE, null,
        * ex);
        * }
        */

        } catch (RemoteException | AlreadyBoundException | MalformedURLException ex) {
            Logger.getLogger(Banco2ServidorRMI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

