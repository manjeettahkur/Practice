package MultiThreading;

/**
 * Created by laxminarayanvarma on 27/8/16.
 */
public class RunnableDemoMain {
    public static void main(String [] args){
        RunnableDemo runner = new RunnableDemo();
        Thread t1 = new Thread(runner,"demoThreadName");
        t1.start();

    }
}
