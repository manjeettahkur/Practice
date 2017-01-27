package Threads;

/**
 * Created by laxminarayanvarma on 23/12/16.
 */
public class EvenOddMain {
    public static void main(String[] args) {
        int maxNumber = 10;

        NumberPrinter printer = new NumberPrinter();
        new Thread(new EvenNumGenerator(printer, maxNumber)).start();
        new Thread(new OddNumGenerator(printer, maxNumber)).start();
    }
}
