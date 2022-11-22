package ejercicioParcial.ejercicioParcial;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ISegip extends Remote {
     RespuestaSegip verificarDatos(String ci, String nombres, String apellidos) throws RemoteException;
}
