package Threads;

/**
 * Created by laxminarayanvarma on 23/12/16.
 */
public class NumberPrinter {

    private boolean isEvenNumPrinted = true;

    public void printOdd(int number) throws InterruptedException {
        synchronized (this) {
            if (!isEvenNumPrinted)
                wait();

            System.out.println(number);
            isEvenNumPrinted = false;
            notify();
        }
    }

    public void printEven(int number) throws InterruptedException {
        synchronized (this) {
            if (isEvenNumPrinted)
                wait();

            System.out.println(number);
            isEvenNumPrinted = true;
            notify();
        }
    }
}
