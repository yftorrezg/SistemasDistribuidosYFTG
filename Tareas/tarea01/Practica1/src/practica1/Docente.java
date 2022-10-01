package practica1;
/**
 * @author fer
 */
class Docente {
    private String nombre;
    private String apellido;
    private int ci;
    public Docente(String nombre, String apellido, int ci) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.ci = ci;
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
    public int getCi() {
        return ci;
    }
    public void setCi(int ci) {
        this.ci = ci;
    }
    public void mostrarDocente() {
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Apellido: " + this.apellido);
        System.out.println("CI: " + this.ci);
        System.out.println(" ");
    }
}
