
package apd_lab1;

import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.concurrent.Semaphore;
/**
 *
 * @author PoLson
 */
public class ConsumatorThread extends Thread{
    private LinkedList<Integer> coada;
    private static Semaphore semaforliber ,semaforplin;
    ConsumatorThread(LinkedList<Integer> coada, Semaphore semaforliber , Semaphore semaforplin){
         this.coada = coada;
         ConsumatorThread.semaforliber = semaforliber;
         ConsumatorThread.semaforplin = semaforplin;
    }
    public void run(){
         while(true){
              semaforplin.acquireUninterruptibly(1);
              synchronized(coada){
                 if(coada.size() > 0)
                 {
                     coada.remove();
                 }
                 for(int i=0;i<coada.size(); i++){
                     System.out.print(coada.get(i)+" ");
                 }
                 System.out.print("\n");  
             }
              semaforliber.release(1);
             try {
                 sleep(200);
             } catch (Exception e) {
                 System.out.print(e);
             }
         }
    }    
}
