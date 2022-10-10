package soquetstcpmultihilo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import jdk.internal.org.objectweb.asm.commons.StaticInitMerger;

class ClientHandler extends Thread {

    DateFormat fordate = new SimpleDateFormat("yyyy/MM/dd");
    DateFormat fortime = new SimpleDateFormat("hh:mm:ss");

    final DataInputStream dis;
    final DataOutputStream dos;
    final Socket s;

    String cadena = "";
    int contador=0;

    // Constructor
    public ClientHandler(Socket s, DataInputStream dis, DataOutputStream dos) {
        this.s = s;
        this.dis = dis;
        this.dos = dos;
    }

    @Override
    public void run() {
        String received;
        String toreturn;
        while (true) {
            try {
                // Ask user what he wants
                dos.writeUTF("Ingrese dos numero por coma..\n"
                        + "Escibir Exit para terminar la conneccion.");
                // receive the answer from client
                received = dis.readUTF();
                if (received.equals("Exit")) {
                    System.out.println("Client " + this.s + " sends exit...");
                    System.out.println("Closing this connection.");
                    System.out.println("\nContador: " + String.valueOf(contador));
                    this.s.close();
                    System.out.println("Connection closed");
                    break;
                }else{
                   
                
                
                }
                 String[] parts = received.split(",");
                
                int num1 =Integer.parseInt( parts[0]); // 2
                int num2 = Integer.parseInt(parts[1]); // 3
                int resultado = num1+num2;
                contador++;
                dos.writeUTF(String.valueOf(resultado)  );
     
                //String cadena = "2,3";
                
                
                // creating Date object
                //Date date = new Date();
                // write on output stream based on the
                // answer from the client
                /*switch (received) {
                    case "Date":
                        toreturn = fordate.format(date);
                        dos.writeUTF(toreturn);
                        break;

                    case "Suma":
                        String cadena = "2,3";
                        String[] parts = cadena.split(",");
                        int num1 =Integer.parseInt( parts[0]); // 2
                        int num2 = Integer.parseInt(parts[1]); // 3
                        int resultado = num1+num2;
                        
                        dos.writeUTF(String.valueOf(resultado) );
                        
                        break;

                    case "Time":
                        toreturn = fortime.format(date);
                        dos.writeUTF(toreturn);
                        break;
                    default:
                        dos.writeUTF("Invalid input");
                        break;
                }*/
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try { // closing resources
            this.dis.close();
            this.dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
