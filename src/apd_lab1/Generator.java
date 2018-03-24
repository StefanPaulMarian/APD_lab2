
 package apd_lab1;
import  java.util.Random ;

/**
 *
 * @author PoLson
 */
public class Generator {
   
    private Random randomGenerator;
    private int max;
    
    Generator(int valueofmax){
        randomGenerator= new Random();
        max=valueofmax;
    }
    public float next() {
        int x=randomGenerator.nextInt(max);
        return (float)x;
    }
}
