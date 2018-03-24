package apd_lab1;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;

/**
 *
 * @author PoLson
 */
public class ProducatorThread extends Thread 
{
     private Generator generator;
     private LinkedList<Integer> coada;
     private static Semaphore semaforliber, semaforplin;

     ProducatorThread(LinkedList<Integer> coada, Semaphore semaforliber , Semaphore semaforplin ){
            this.coada = coada;
            generator = new Generator(10);
            ProducatorThread.semaforliber = semaforliber;
            ProducatorThread.semaforplin = semaforplin;
     }
     public void run(){
         while(true){
             int element = (int) generator.next();
             semaforliber.acquireUninterruptibly(1);
              try {
                 sleep(100);
             } catch (Exception e) {
                 System.out.print(e);
             }
             synchronized(coada){
                 if(coada.size() < 10)
                 {
                     coada.add(element);
                 }
             }
            semaforplin.release(1);
            for(int i=0;i<coada.size(); i++){
                System.out.print(coada.get(i)+" ");
             }
             System.out.print("\n");
             
            
         }
     }
}
