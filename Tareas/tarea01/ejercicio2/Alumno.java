/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2;

/**
 *
 * @author fer
 */
public class Alumno {

    // nombre, apellido, cu, ci
    private String nombre;
    private String apellido;
    private String ci;
    private String cu;
    private Materia[] materias;
    // constructor

    public Alumno(String nombre, String apellido, String ci, String cu, Materia[] materias) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.ci = ci;
        this.cu = cu;
        this.materias = materias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getCu() {
        return cu;
    }

    public void setCu(String cu) {
        this.cu = cu;
    }

    public Materia[] getMaterias() {
        return materias;
    }

    public void setMaterias(Materia[] materias) {
        this.materias = materias;
    }

    @Override
    public String toString() {
        String cadena = " ";
        for (Materia aux : materias) {
            cadena += aux.getNombre()+ " ";
        }
        return "Alumno{" + "nombre=" + nombre + ", apellido=" + apellido + ", ci=" + ci + ", cu=" + cu + ", materias=" + cadena + '}';
    }

}
