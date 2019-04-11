import java.util.concurrent.Semaphore;

public class SeeSaw {
    public static void main(String args[]){

        Height heights = new Height();

        Semaphore sem1 = new Semaphore(1);
        Semaphore sem2 = new Semaphore(1);

        try{
            sem2.acquire();
            System.out.println("Fred's Height: " + heights.fheight + " Wilma's Height: " + heights.wheight);
            Thread.sleep(1000);

            Wilma w = new Wilma(sem1, sem2, heights);
            Fred f = new Fred(sem1, sem2, heights);

            Thread tw = new Thread(w);
            Thread tf = new Thread(f);

            tw.start();
            tf.start();

            tw.join();
            tf.join();

        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
