/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package primerparcial_yftg_astc;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IBanco2 extends Remote {
    boolean retirar(String idCliente, float monto) throws RemoteException;
    boolean abonar(String idCliente, float monto) throws RemoteException;
}