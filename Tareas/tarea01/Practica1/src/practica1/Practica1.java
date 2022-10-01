package practica1;

import java.util.Scanner;
/**
 * @author fer
 */
public class Practica1 {
    public static void fibonacci() {
        Scanner entrada = new Scanner(System.in);
        int n;
        int a = 0, b = 1;
        // 1 fibonacci de un numero N
        System.out.println("Introduzca el numero N:");
        n = entrada.nextInt();
        System.out.println("Fibonacci Series " + n + " terms:");
        // algoritmo
        for (int i = 1; i <= n; ++i) {
            System.out.print(a + ", ");

            // siguiente termino
            int nextTerm = a + b;
            a = b;
            b = nextTerm;
        }
    }

    public static void main(String[] args) {
        // Ejercicio 1
        System.out.println("FIBONACCI");

        fibonacci();
        System.out.println("");
        System.out.println("");
        
        // Ejercicio 2

        Docente docenteJorge = new Docente("Jorge", "Perez", 111);
        Docente docenteLeo = new Docente("Messi", "leo", 000);

        Materia materia1 = new Materia("Algebra", "MAT100", docenteLeo);
        Materia materia2 = new Materia("Calculo", "MAT101", docenteJorge);

        Alumno alumno1 = new Alumno("Fer", "Torrez", 222, "111-324");

        alumno1.agregarMateria(materia1);
        alumno1.agregarMateria(materia2);

        alumno1.mostrarMaterias();
    }

}
