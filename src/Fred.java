import java.util.concurrent.Semaphore;

public class Fred implements Runnable {
    Semaphore sem1;
    Semaphore sem2;
    Height h;

    public Fred(Semaphore sema, Semaphore semb, Height height){
        this.sem1 = sema;
        this.sem2 = semb;
        this.h = height;
    }
    public void run() {
        int counter = 0;
        while(counter < 10){
            try{
                sem1.acquire();
                while(h.fheight < 7){
                    System.out.println("Fred's Height: " + h.fheight + " Wilma's Height: " + h.wheight);

                    h.fheight += 1;
                    h.wheight -= 1;



                    Thread.sleep(1);
                }
                sem2.release();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            counter++;
        }
    }
}
