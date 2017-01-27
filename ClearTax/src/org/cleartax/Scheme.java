package org.cleartax;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by laxminarayanvarma on 17/9/16.
 */
public class Scheme {

    String schemeName;
    Map<String , List<String>> mutualFunds;

    public Scheme(String schemeName){
        this.schemeName = schemeName;
        this.mutualFunds = new HashMap<String, List<String>>();
    }

    public void printAllScheme(){
        System.out.println();
        Iterator<Map.Entry<String,List<String>>> ite = this.mutualFunds.entrySet().iterator();

        while(ite.hasNext()){
            Map.Entry pair = (Map.Entry)ite.next();
          //  System.out.println("Fund Name : "+pair.getKey());
            List<String> ll = (List<String>) pair.getValue();
            for(String sc : ll){
                String [] arr = sc.split(";");
                System.out.println(arr[3] + "  " + arr[4]);
            }
        }
    }
}
