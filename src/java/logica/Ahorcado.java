package logica;

import java.util.Random;

/**
 *
 * @author josei_000
 */
public class Ahorcado {

    Random aleatorio = new Random();
    private String[] palabras = {"CASCADA", "PERRO", "GUADALQUIVIR", "ESTERNOCLEIDOMASTOIDEO", "SOL", "MURCIELAGO", "ORDENADOR"};
    private String palabra;
    private String mensajeError;
    private int intentos;
    private char letra;//letra que seleccionamos     
    private boolean error;
    private String nombre;
    private String mensaje;
    private int cont;
    private int cont2;
    private boolean encontrado;//indica si la letra se ha encontrado o no.
    private boolean juego;//indica que el juego no se inicio
    private char[] letrasDichas;//array donde almacenamos las letras dichas
    private char[] letrasPalabra;//array con las letras de la palabra
    private char[] letrasAdivinadas;//array con las letras adivinadas
    //ya que el constructor por defecto no le he dado otro uso, lo usare para mostrar mensajes de error.

    public Ahorcado() {
        this.mensajeError = "";
        this.error = false;

    }
    //creamos un metodo para mostrar '*' en lugar de la palabra sustituyendo
    //los caracteres cuando se llama al metodo

    public void llenar(char[] guion) {
        int conta = 0;
        while (guion.length > conta) {
            guion[conta] = '*';
            conta++;
        }

    }

    /*creo un metodo para inicializar el juego el cual recoge el nivel, elige una palabra al azar
       *la convierte a caracteres, los almacena, introducimos en letras adivinadas los
       * cracteres de la palabra y los transformamos con el metodo llenar
     */
    public void inicializa(int nivel) {

        switch (nivel) {
            case 1:
                intentos = 8;
                break;
            case 2:
                intentos = 5;
                break;
            case 3:
                intentos = 3;
                break;
            case 4:
                intentos = 1;
                break;
        }

        //cogemos una palabra del array y la almacenamos en palabra
        this.palabra = palabras[aleatorio.nextInt(palabras.length)];
        //transformamos la palabra en un array de letras para luego poder compararlo.
        this.letrasPalabra = palabra.toCharArray();

        this.letrasAdivinadas = new char[letrasPalabra.length];
        this.letrasDichas = new char[intentos];
        llenar(letrasAdivinadas);

        this.nombre = "";
        this.mensaje = "";
        cont = 0;
        cont2 = intentos;
        juego = false;

    }

    public boolean compararPalabra(String palabra) {
        encontrado = false;
        if (palabra.equals(this.palabra)) {
            mensaje = "Has acertado, ganaste.";
            encontrado = true;
            this.letrasAdivinadas = palabra.toCharArray();
        } else {
            mensaje = "Has fallado, intentalo de nuevo.";
            encontrado = false;
            cont2--;
            cont++;
        }
        return encontrado;
    }

    //metodo para comprobar si las letras son correctas.
    public void compararLetra() {
        encontrado = false;

        for (int i = 0; i < letrasPalabra.length; i++) {
            if (letrasPalabra[i] == letra) {
                letrasAdivinadas[i] = letra;
                encontrado = true;
            }
        }
        if (encontrado == false) {
            letrasDichas[cont] = letra;
            cont2--;
            cont++;
        }

        //comprobamos si la palabra es igual al array de letras.      
        if (palabra.equals(String.valueOf(letrasAdivinadas))) {
            mensaje = "Has acertado, ganaste.";
            this.letrasAdivinadas = palabra.toCharArray();
            juego = false;
        }
        if (cont == intentos) {
            this.letrasAdivinadas = palabra.toCharArray();
            mensaje = "Lo siento no has sido lo suficientemente bueno, perdiste. La palabra es: " + palabra;
            juego = false;
        }
    }

    //comprueba que el valor introducido es un caracter valido y no un numero.
    public boolean isNumero(String numero) {
        try {
            double d = Double.parseDouble(numero);
        } catch (NumberFormatException a) {
            return false;
        }
        return true;
    }

    //indica si hay un error o no.
    public boolean isError() {
        return error;
    }

// getters y setters
    public int getCont2() {
        return cont2;
    }

    public int getCont() {
        return cont;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public String[] getPalabras() {
        return palabras;
    }

    public void setPalabras(String[] palabras) {
        this.palabras = palabras;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public int getIntentos() {
        return intentos;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }

    public char[] getLetrasdichas() {
        return letrasDichas;
    }

    public void setLetrasdichas(char[] letrasdichas) {
        this.letrasDichas = letrasdichas;
    }

    public char[] getPalalabra() {
        return letrasPalabra;
    }

    public void setPalabra(char[] pal) {
        this.letrasPalabra = pal;
    }

    public char[] getPalabraAdiv() {
        return letrasAdivinadas;
    }

    public void setP_adiv(char[] p_adiv) {
        this.letrasAdivinadas = p_adiv;
    }

    public boolean isCambios() {
        return encontrado;
    }

    public void setCambios(boolean cambios) {
        this.encontrado = cambios;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public boolean isJuego() {
        return juego;
    }

    public boolean getJuego() {
        return juego;
    }

    public void setJuego(boolean juego) {
        this.juego = juego;
    }

}
