/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ej3;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author fer
 */
public class Ej3 {

    public static void main(String[] args) {
        conect c = new conect();
        Scanner sc = new Scanner(System.in);
        int num;
        //datos de alumno
        String nombre;
        String apellido;
        String CI;
        String Cu;
        String CiBuscar;
        String consulta;
        int materia;

        do {
            System.out.println("1 Insertar");
            System.out.println("2 Eliminar");
            System.out.println("3 Mostrar");
            System.out.println("4 Modificar");
            System.out.println("5 salir");

            num = sc.nextInt();

            switch (num) {
                case 1:

                    System.out.println("Introduzca su nombre");
                    nombre = sc.next();
                    System.out.println("Introduzca su apellido");
                    apellido = sc.next();
                    System.out.println("Introduzca su Ci");
                    CI = sc.next();
                    System.out.println("Introduzca su Cu");
                    Cu = sc.next();

                    consulta = "insert into alumno(nombre,apellido,ci,cu) values (?,?,?,?)";

                    try {
                        CallableStatement cs = c.conectt().prepareCall(consulta);

                        cs.setString(1, nombre);

                        cs.setString(2, apellido);

                        cs.setString(3, CI);

                        cs.setString(4, Cu);

                        cs.execute();

                    } catch (Exception e) {
                        System.out.println("Error no se pudo conectar a la base" + e);
                    }
                    break;

                case 2:
                    System.out.println("Ingrese el Ci");
                    CiBuscar = sc.next();
                    consulta = "delete from alumno where alumno.ci=?";
                    try {
                        CallableStatement cs = c.conectt().prepareCall(consulta);

                        cs.setString(1, CiBuscar);
                        cs.execute();

                        System.out.println("Exitoso eliminado bien");
                    } catch (Exception e) {
                        System.out.println("Error no se pudo conectar a la base" + e);

                    }
                    break;
                case 3:
                    String sql = "";
                    sql = "select * from alumno;";
                    Statement st;

                    try {
                        st = c.conectt().createStatement();

                        ResultSet rs = st.executeQuery(sql);

                        while (rs.next()) {
                            System.out.println("ID:" + rs.getString(1) + " Nombre: " + rs.getString(2)
                                    + " Apellido: " + rs.getString(3) + " Ci:" + rs.getString(4) + " CU:" + rs.getString(5));

                        }
                    } catch (Exception e) {
                        System.out.println("Error no se pudo conectar a la base" + e);

                    }

                    break;
                case 4:

                    System.out.println("Ingrese el Ci");
                    CiBuscar = sc.next();

                    System.out.println("Introduzca su nombre");
                    nombre = sc.next();
                    System.out.println("Introduzca su apellido");
                    apellido = sc.next();
                    System.out.println("Introduzca su Ci");
                    CI = sc.next();
                    System.out.println("Introduzca su Cu");
                    Cu = sc.next();

                    consulta = "UPDATE alumno SET nombre=?, apellido=?, ci=?, cu=? where ci=?";

                    try {
                        CallableStatement cs = c.conectt().prepareCall(consulta);

                        cs.setString(1, nombre);
                        cs.setString(2, apellido);
                        cs.setString(3, CI);
                        cs.setString(4, Cu);
                        cs.setString(5, CiBuscar);

                        cs.execute();

                        System.out.println("Datos actualizados correctamente");
                    } catch (Exception e) {
                        System.out.println("No se pudo actualizar los datos");

                    }

                    break;

                default:
                    System.out.println("Numero del 1 al 4");
            }

        } while (num != 5);
        sc.close();

    }
}
