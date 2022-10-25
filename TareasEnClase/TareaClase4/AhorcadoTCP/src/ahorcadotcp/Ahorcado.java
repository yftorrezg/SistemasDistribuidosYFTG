package ahorcadotcp;

import java.util.Scanner;

/**
 *
 * @author fer 
 */
public class Ahorcado {
    Scanner input = new Scanner(System.in);

    private String palabras[] = { "hola", "barcelona", "sucre", "bolivia",
            "sistemas", "distribuidos", "arquitectura", "computadores", "torrez", "fernando" }; /* creamos nuestro ahorcado de 7 niveles de vida*/
    private String palabra; 
    private String palabraFormada = ""; 
    private int vida; 

    public Ahorcado() { 
        this.palabra = this.palabras[(int) (Math.random() * 9)]; // asignamos la palabra que va a adivinar el rival. aleatoriamete entre 0 y 9.
        this.vida = 7; 
        this.palabraFormada = palabraInicial();
    }

    // palabra inicial con guiones bajos de = tamaño que la palabra a adivinar
    public String palabraInicial() {
        for (int i = 0; i < this.palabra.length(); i++)
            this.palabraFormada += "_"; // inicializamos los espacios de la palabra a adivinar
        return this.palabraFormada;
    }

    public void verificarLetra(char letra) {
        boolean acerto = false;
        // recorremos letra por letra de la palabra a buscar.
        for (int i = 0; i < this.palabra.length(); i++)
            //+verificamos LETRA POR LETRA si hay coincidencia con la introducida.
            if (this.palabra.charAt(i) == letra) { 
                acerto = true;
                // substring:  devuelve una subcadena de la cadena original, empezando en el índice especificado y terminando en el índice especificado. 
                // substring(0, i) devuelve la subcadena desde el índice 0 hasta el índice i-1.
                // substring(i+1) devuelve la subcadena desde el índice i+1 hasta el final de la cadena.
                this.palabraFormada = this.palabraFormada.substring(0, i) + letra + this.palabraFormada.substring(i + 1);
                //+si acerto, reemplazamos el espacio por la letra acertada.
            }
        if (!acerto) // si no acerto, restamos una vida.
            this.vida--;
    }

    public boolean gana() {
        return this.palabra.equals(this.palabraFormada) ? true : false; // si la palabra a adivinar es igual a la palabra formada, gana.
    }

    public boolean pierde() {
        return this.vida == 0 ? true : false; // si la vida es igual a 0, pierde.
    }
    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public String getPalabraFormada() {
        return palabraFormada;
    }

    public void setPalabraFormada(String palabraFormada) {
        this.palabraFormada = palabraFormada;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

}
