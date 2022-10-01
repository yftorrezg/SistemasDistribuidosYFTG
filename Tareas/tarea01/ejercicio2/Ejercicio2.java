/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio2;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author fer
 */
public class Ejercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // lista de alumnoss
        ArrayList<Alumno> listaalumno = new ArrayList<Alumno>();

        Docente cmb = new Docente("Carlos", "123456");
        Materia sis258 = new Materia("SistemasDistribuidos", "sis258", cmb);
        Materia sis256 = new Materia("Desarrollo", "sis256", cmb);

        Materia[] soloSis258 = new Materia[1];
        soloSis258[0] = sis258;
        Materia[] soloSis256 = new Materia[1];
        soloSis256[0] = sis256;

        Materia[] ambas = new Materia[2];
        ambas[0] = sis256;
        ambas[1] = sis258;

        String nombre;
        String apellido = "";
        String ci = "";
        String cu = "";

        Scanner sc = new Scanner(System.in);
        int numero;
        int opc;
        do {
            System.out.println("1. Insertar: ");
            System.out.println("2. Eliminar: ");
            System.out.println("3. Mostrar: ");
            System.out.println("4. Salir");
            System.out.println("Elige una opcion: ");
            numero = sc.nextInt();
            switch (numero) {
                case 1: {
                    System.out.println("Introduzca su nombre: ");
                    nombre = sc.next();
                    System.out.println("Introduzca su apellido: ");
                    apellido = sc.next();
                    System.out.println("Introduzca su ci: ");
                    ci = sc.next();
                    System.out.println("Introduzca su cu: ");
                    cu = sc.next();
                    System.out.println("1. Solo Sis258");
                    System.out.println("2. Solo Sis256");
                    System.out.println("3. Ambas materias");
                    System.out.println("Elija una opcion: ");
                    opc = sc.nextInt();
                    Alumno alm = null;
                    switch (opc) {
                        case 1: {
                            alm = new Alumno(nombre, apellido, ci, cu, soloSis258);
                            break;
                        }
                        case 2: {
                            alm = new Alumno(nombre, apellido, ci, cu, soloSis256);
                            break;
                        }
                        case 3: {
                            alm = new Alumno(nombre, apellido, ci, cu, ambas);
                            break;
                        }
                    }
                    listaalumno.add(alm);
                    break;
                }
                case 2: {
                    
                    System.out.println("Introduza cu: ");
                    String ciBuscar = sc.next();
                    /*
                    int contador=0;
                    do{
                        if (listaalumno.get(contador).getCu()== cuBuscar) {
                            listaalumno.remove(0);
                        }
                        contador++;
                    }while(contador<listaalumno.size());*/
                    /*
                    while(contador<listaalumno.size()){
                        if (listaalumno.get(contador).getCu()== cuBuscar) {
                            listaalumno.remove(0);
                        }
                        contador++;
                    }*/
                    
                    for(int i=0; i<listaalumno.size(); i++) {
                        // System.out.println("CI: " + listaalumno.get(i).getCi());getCi
                        if (listaalumno.get(i).getCi().equals(ciBuscar)) {
                            listaalumno.remove(i);
                        }
                        
                    }

                    break;
                }
                case 3: {
                    for (Alumno aux : listaalumno) {
                        System.out.println(aux);
                    }
                    break;
                } 
                
                default:
                    break;
            }
        } while (numero != 4);
    }

}
