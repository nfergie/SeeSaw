import java.util.concurrent.Semaphore;

public class Wilma implements Runnable{
    Semaphore sem1;
    Semaphore sem2;
    Height h;

    public Wilma(Semaphore sema, Semaphore semb, Height heights){
        this.sem1 = sema;
        this.sem2 = semb;
        this.h = heights;
    }
    public void run() {
        int counter = 0;
        while(counter < 10){
            try{
                sem2.acquire();
                while(h.wheight < 7){
                    System.out.println("Fred's Height: " + h.fheight + " Wilma's Height: " + h.wheight);

                    h.fheight -= 1.5;
                    h.wheight += 1.5;



                    Thread.sleep(1000);
                }
                sem1.release();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            counter++;
        }
    }

}
