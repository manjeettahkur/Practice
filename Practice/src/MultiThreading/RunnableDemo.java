package MultiThreading;

/**
 * Created by laxminarayanvarma on 27/8/16.
 */
public class RunnableDemo implements Runnable {


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        System.out.println("Runnable Demo");
    }


}
