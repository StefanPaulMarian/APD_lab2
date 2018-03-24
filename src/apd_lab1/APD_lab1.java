
package apd_lab1;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;


public class APD_lab1 {
    private static LinkedList<Integer> coada = new LinkedList<Integer>();
    private static Semaphore semaforliber, semaforplin;
    public static void main(String[] args) {
       semaforliber = new Semaphore(10);
       semaforplin = new Semaphore(10);
       Thread thread1 = new ProducatorThread(coada, semaforliber ,semaforplin);
       Thread thread2 = new ConsumatorThread(coada, semaforliber , semaforplin);
       thread1.start();
       thread2.start();
       try{
        thread1.join();
        thread2.join();
       }
       catch(Exception e){
           System.out.print(e);
       }
       
    }
    
}
