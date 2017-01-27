package Magnitude;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by laxminarayanvarma on 11/12/16.
 */
public class Main {
    public static void main(String [] args){
        String currentLine;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("input.csv"));
            while ((currentLine = br.readLine()) != null) {

            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
