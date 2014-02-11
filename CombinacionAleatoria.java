package mastermind2;

/**
 *
 * @author Natalia
 */
public class CombinacionAleatoria extends Combinacion {
    
    private static final char[] COLORES = {'V', 'N', 'B', 'A', 'R', 'M'};
    
    public CombinacionAleatoria() {
        super(getColorAleatorio(), getColorAleatorio(), getColorAleatorio(), getColorAleatorio());
    }
    
    private static char getColorAleatorio() {
        return COLORES[(int)(Math.random()*6)];
    }
}