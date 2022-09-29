package practica1;
import java.util.ArrayList;
/**
 * @author fer
 */
public class Alumno {
    private String nombres;
    private String apellidos;
    private String cu;
    private int ci;
    private ArrayList<Materia> materias = new ArrayList<Materia>();
    public Alumno(String nombres, String apellidos, int ci, String cu) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.cu = cu;
        this.ci = ci;
    }
    public String getNombres() {
        return nombres;
    }
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public int getCi() {
        return ci;
    }
    public void setCi(int ci) {
        this.ci = ci;
    }
    public String getCu() {
        return cu;
    }
    public void setCu(String cu) {
        this.cu = cu;
    }
    public ArrayList<Materia> getMaterias() {
        return materias;
    }
    public void setMaterias(ArrayList<Materia> materias) {
        this.materias = materias;
    }
    public void agregarMateria(Materia mtr) {
        materias.add(mtr);
    }
    public void eliminarMateria(String nombre) {
        for(int i=0; i<materias.size(); i++) {
            if(materias.get(i).getNombre() == nombre) {
                materias.remove(i);
            }
        }   
    }
    public void mostrarMaterias() {
        for(int i=0; i<materias.size(); i++) {
            System.out.println("Nombre Materia: " + materias.get(i).getNombre());
            System.out.println("Sigla Materia: " + materias.get(i).getSigla());
            materias.get(i).getDocente().mostrarDocente();
        }
    }
}
