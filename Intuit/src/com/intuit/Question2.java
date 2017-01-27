package com.intuit;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by laxminarayanvarma on 29/11/16.
 */
public class Question2 {
    public static void main(String[] args) throws IOException {

        String line;
        int counts = 0;
        BufferedReader br=new BufferedReader(new FileReader("input2.txt"));
        while((line=br.readLine())!=null)
        {
            if(line.contains("/*"))
            {
                if(line.contains("/*") && line.contains("*/")){
                    counts++;
                    if (line.contains("//"))
                        counts++;
                }
                else{
                    while((line=br.readLine())!=null)
                    {
                        if(line.contains("*/") && !line.contains("/*")){
                            counts++;
                            break;
                        }
                    }
                }
            }
            else if(line.startsWith("//"))
                counts++;

            else if(line.contains("\"")){
                if (line.contains(";"))
                    counts++;
                else{
                    while((line=br.readLine())!=null){
                        if( line.contains("\"") && line.contains(";")){
                            counts++;
                            break;
                        }
                    }
                }
                String [] arr = line.split(";");
                for(int i = 1;i<arr.length;i++){
                    if(arr[i].contains("//"))
                        counts++;
                }
            }
        }
        br.close();
        System.out.println("Total matches = "+counts);
    }
}