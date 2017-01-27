package com.intuit;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by laxminarayanvarma on 29/11/16.
 */
public class Question3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input3.txt"));
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the no of lines to print : ");
        int n = in.nextInt();

        String line;
        LinkedList<String> tailLines = new LinkedList<String>();
        while ((line = br.readLine()) != null) {
            tailLines.add(line);
            if ( tailLines.size() > n)
                tailLines.remove(0);
        }        for(String str : tailLines){
            System.out.println(str);
        }
    }
}