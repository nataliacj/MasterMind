package mastermind2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Natalia
 */
public class MasterMind2 {
    
    public static final int MAX_INTENTOS = 10;
    private Combinacion ganadora;
    private ArrayList<Combinacion> intentos;
    
    public MasterMind2() {
        this.ganadora = new CombinacionAleatoria();
        this.intentos = new ArrayList<Combinacion>();
        
        this.iniciarTurno(1);
    }
    
    public void iniciarTurno(int turno) {
        //System.out.println(this.ganadora);
        System.out.println("\nIntroduzca el " + turno + "º intento:");
        
        Combinacion combinacion = new Combinacion(this.getColores());
        this.intentos.add(combinacion);
        
        System.out.println ("\n* * * *\n--------------");
        
        for (int i=0; i<this.intentos.size(); i++) {
            this.imprimirIntento(i);
        }
        
        boolean esGanadora = this.ganadora.isGanadora(combinacion);
        
        if (!esGanadora && !this.isFin()) {
            this.iniciarTurno(++turno);
        }
        else {
            if (!esGanadora) {
                System.out.println("\n!!! HAS PERDIDO !!!");
            }
        }
    }
    
    public boolean isFin() {
        return this.intentos.size() >= MAX_INTENTOS;
    }

    public void imprimirIntento(int i) {
        Combinacion combinacion = this.intentos.get(i);
        int colocados = this.ganadora.getColocados(combinacion);
        int aciertos = this.ganadora.getAciertos(combinacion);
        boolean esGanadora = this.ganadora.isGanadora(combinacion);
        
        System.out.println(i + ".- " + combinacion + 
            "  " + aciertos + " acierto(-s) con " +
            colocados + " colocado(-s)" +
            (esGanadora? " !!! GANADOR !!!": ""));
    }
    
    public char[] getColores() {
        char[] colores = new char[4];
        Scanner teclado = new Scanner(System.in);

        for (int i=0; i<4; i++) {
            System.out.print("Posición " + (i+1) + "ª: ");
            colores[i] = teclado.nextLine().trim().toUpperCase().charAt(0);   
        }
        
        return colores;
    }
    
    public static void main (String[] args) {
        new MasterMind2();
    }
}