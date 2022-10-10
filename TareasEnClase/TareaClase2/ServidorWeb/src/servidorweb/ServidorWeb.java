package servidorweb;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
/**
 *
 * @author Fer
 */
public class ServidorWeb {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int port = 80;
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Se inicio el servidor");
            Socket client;
            PrintStream toClient;
            // se conecta el cliente
            client = server.accept(); //conexion
            BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream())); // el lector
            System.out.println("Cliente se conecto");
            String a = fromClient.readLine();
            // lee todo loque le envia el cliente 
            while (a.length() > 0) {
                System.out.println(a);
                a = fromClient.readLine();
            }
            toClient = new PrintStream(client.getOutputStream());
            toClient.println("HTTP/1.1 200 OK");
            toClient.println("Date: Mon, 01 Jun 2009 17:19:57 GMT");
            toClient.println("Server: Apache/2.0.63 (Unix) mod_ssl/2.0.63 ...");
            toClient.println("X-Powered-By: PHP/5.2.8");
            toClient.println("X-Pingback: http://moleseyhill.com/blog/ /xmlrpc.php");
            toClient.println("Keep-Alive: timeout=15, max=100");
            toClient.println("Connection: Keep-Alive");
            toClient.println("Transfer-Encoding: chunked");
            toClient.println("Content-Type: text/html; charset=UTF-8");
            toClient.println("");
            toClient.println("2475");
            toClient.println("<!DOCTYPE html>");
            toClient.println("<html lang='en'>");
            toClient.println("<head>");
            toClient.println("<meta charset='UTF - 8'>");  
            toClient.println("<meta http-equiv='X - UA - Compatible' content='IE = edge'>");  
            toClient.println("<meta name='viewport' content='width = device - width, initial - scale = 1.0'>");  
            toClient.println("<title>Document</title>");
            toClient.println("</head>");
            toClient.println("<body>");
            toClient.println("<h1>hola mundo</h1>");  
            toClient.println("</body>");
            toClient.println("</html>");
            //toClient.println("Codigo");
            //split en java
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
