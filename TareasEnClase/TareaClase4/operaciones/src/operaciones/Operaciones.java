package operaciones;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Operaciones extends UnicastRemoteObject implements IOperaciones {
    // atributos a y b
    private int a;
    private int b;

    public Operaciones() throws RemoteException {
        super(); // constructor de la clase padre
    }

    @Override 
    public void anotar(int a, int b) throws RemoteException {
        this.a = a;
        this.b = b;
    }

    @Override 
    public int sumar() throws RemoteException {
        return this.a + this.b;
    }

    @Override
    public int restar() throws RemoteException {
        return this.a - this.b;
    }

    @Override
    public boolean salir() throws RemoteException {
        return false;
    }
}
