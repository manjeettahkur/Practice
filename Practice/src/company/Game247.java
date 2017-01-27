package company;

import java.util.Scanner;

/**
 * Created by laxminarayanvarma on 3/1/17.
 */

public class Game247 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        String line = null;
        while(!(line = sc.nextLine()).isEmpty()) {
            String[] values = line.split(" ");
            int x = Integer.parseInt(values[0]);
            int y = Integer.parseInt(values[1]);
            System.out.println(x + " " +y);
        }

    }

    public static void someThing(int x){}
}

