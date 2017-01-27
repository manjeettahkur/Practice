package Threads;

/**
 * Created by laxminarayanvarma on 23/12/16.
 */
public class OddNumGenerator implements Runnable {
    private NumberPrinter q;
    private int max;

    public OddNumGenerator(NumberPrinter q, int max) {
        this.q = q;
        this.max = max;
    }

    @Override
    public void run() {
        for (int i = 1; i < max; i = i + 2) {
            try {
                q.printOdd(i);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
