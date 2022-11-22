/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primerparcial_yftg_astc;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/*
        * BANCO: 1   
        * Idcliente    1       3   
        * Saldo        455     300 
*/
public class Banco1 extends UnicastRemoteObject implements IBanco1 {
    public Banco1() throws RemoteException {
        super();
    }


    @Override
    public boolean retirar(String idCliente, float monto) {
        if (idCliente.equals("1") && monto <= 455) {
            return true;
        } else if (idCliente.equals("3") && monto <= 300) {
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public boolean abonar(String idCliente, float monto) {
        if ((idCliente.equals("1")) || (idCliente.equals("3"))) {
            return true;
        } else {
            return false;
        }
    }


/* 
    float SaldoCliente1 = 450;
    float SaldoCliente3 = 300;

    public boolean retirar1(String idCliente, float monto) {
        if (idCliente.equals("1") && monto <= 455) {
            SaldoCliente1 = SaldoCliente1 - monto;
            return true;
        } else if (idCliente.equals("3") && monto <= 300) {
            SaldoCliente3 -= monto;
            return true;
        } else {
            return false;
        }
    }
    public boolean abonar1(String idCliente, float monto) {
        if (idCliente.equals("1")) {
            SaldoCliente1 += monto;
            return true;
        } else if (idCliente.equals("3")) {
            SaldoCliente3 += monto;
            return true;
        } else {
            return false;
        }
    } */
}
