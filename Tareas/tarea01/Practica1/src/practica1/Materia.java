package practica1;
/**
 * @author fer
 */
class Materia {
    private String nombre;;
    private String sigla;
    private Docente docente;
    public Materia(String nombre, String sigla, Docente docente) {
        this.nombre = nombre;
        this.sigla = sigla;
        this.docente = docente;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getSigla() {
        return sigla;
    }
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
    public Docente getDocente() {
        return docente;
    }
    public void setDocente(Docente docente) {
        this.docente = docente;
    }    
}
