import java.util.Scanner;

public class Cadena {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Por favor introduzca una cadena/frase: ");
    String cadena = input.nextLine();

    String cadenaInvertida = "";
    System.out.println("\n La cadena/frase introducida es: " + cadena);

    for (int i = cadena.length() - 1; i >= 0; i--) {
      cadenaInvertida += cadena.charAt(i);
    }

    System.out.println("\nCadena Invertida: " + String.valueOf(cadenaInvertida));
    input.close();
  }
}
