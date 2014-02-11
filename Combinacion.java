package mastermind2;

/**
 *
 * @author Natalia
 */
public class Combinacion {
    private char[] colores;
    
    public Combinacion(char[] colores) {
        this.colores = colores;
    }

    public Combinacion(char a, char b, char c, char d) {
        this.colores = new char[4];
        this.colores[0] = a;
        this.colores[1] = b;
        this.colores[2] = c;
        this.colores[3] = d;
    }
    
    @Override
    public String toString() {
        String resultado = "";
        for (int i=0; i<this.colores.length; i++) {
            resultado += (this.colores[i] + " ");
        }
        return resultado;
    }
    
    public int getColor(int i) {
        return this.colores[i];
    }
    
    public int getColocados(Combinacion combinacion) {
        int coincidencias = 0;
        for (int i=0; i<this.colores.length; i++) {
            if (this.colores[i] == combinacion.getColor(i)) {
                coincidencias++;
            }
        }
        return coincidencias;
    }

    public int getAciertos(Combinacion combinacion) {
        int coincidencias = 0;
        for (int i=0; i<this.colores.length; i++) {
            for (int j=0; j<this.colores.length; j++) {
                if (this.colores[i] == combinacion.getColor(j)) {
                    coincidencias++;
                    break;
                }
            }
        }
        return coincidencias;
    }
    
    public boolean isGanadora(Combinacion combinacion) {
        return this.getColocados(combinacion) == 4;
    }
}