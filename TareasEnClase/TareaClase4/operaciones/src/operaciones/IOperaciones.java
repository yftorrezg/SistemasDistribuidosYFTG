package operaciones;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IOperaciones extends Remote { // interface remota
    public void anotar(int a, int b) throws RemoteException; // metodo remoto

    public int sumar() throws RemoteException;

    public int restar() throws RemoteException;

    public boolean salir() throws RemoteException;
    // throws RemoteException: es una excepcion que se lanza cuando ocurre un error
    // en el servidor
}

/*
 * interface: es un contrato que se firma entre el cliente y el servidor
 * - los métodos de la interface deben lanzar RemoteException.
 * - los métodos de la interface deben ser públicos y abstractos (no se
 * especifica)
 * - sirve para la herencia múltiple
 * - no se puede instanciar
 * - en ves de utilizar la palabra reservada class se utiliza la palabra
 * reservada interface. usa implements en ves de extends.
 */