package org.cleartax;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.*;
import java.util.*;

/**
 * Created by laxminarayanvarma on 17/9/16.
 */
public class Main {
    Map<String ,Scheme> schemeMap = new HashMap<String,Scheme>();
    BSTree tree = new BSTree();
    BSTnode root = null;

    public  static void main(String [] args) throws IOException {
        String thisLine = null;
        BufferedReader br = new BufferedReader(new FileReader("final.txt"));
        Main obj = new Main();
        String variableName = br.readLine();
        br.readLine();
        String chunk = "";
        boolean flag = false;
        while ((thisLine = br.readLine()) != null) {
           // System.out.println(thisLine);
            if(thisLine.contains("Ended Schemes") && flag){
                obj.procesScheme(chunk);
                chunk = "";
            }
            chunk += thisLine + "\n";
            flag = true;
        }
        obj.procesScheme(chunk);

        //Take input from  console
        //Input category
        //Input schemeCode
        Scanner sc = new Scanner(System.in);
        String scName = sc.nextLine();
        int scNo = sc.nextInt();
        sc.close();
        obj.printMap(scName);
        //Create BST for searching scheme code
        obj.populateBST();


        System.out.println("Scheme No we entered is : " + scNo);
        System.out.println("Details : ");
        obj.findFund(scNo);


    }

    //Process a category chunk
    public void procesScheme(String chunk){
       String schemeName = chunk.split("\n")[0];

        Scheme obj = new Scheme(schemeName);
        processFund(obj,chunk);
        schemeMap.put(schemeName,obj);

       // System.out.println(chunk);

    }

    public void processFund(Scheme obj,String chunk){
        String [] arr = chunk.split("\n");
        boolean flag = false;
        String fundName = null;
        for (int i = 1;i <arr.length;i++){
            if(arr[i].contains("Mutual Fund") && flag){
                fundName = arr[i];
                obj.mutualFunds.put(arr[i],new ArrayList<String>());
            }
            if(arr[i].length() > 0 && !arr[i].contains("Mutual Fund"))
               obj.mutualFunds.get(fundName).add(arr[i]);
            flag = true;
        }
    }
    public  void printMap(String name){
        /*Iterator<Map.Entry<String,Scheme>> ite = schemeMap.entrySet().iterator();

        while(ite.hasNext()){
            Map.Entry pair = (Map.Entry)ite.next();
            System.out.println(pair.getKey());
            Scheme obj = (Scheme) pair.getValue();
            obj.printAllScheme();
        }*/

        Scheme scheme = schemeMap.get(name);
        scheme.printAllScheme();
    }

    public void populateBST(){
        Iterator<Map.Entry<String,Scheme>> ite = schemeMap.entrySet().iterator();

        while(ite.hasNext()) {
            Map.Entry pair = (Map.Entry) ite.next();
            Scheme obj = (Scheme) pair.getValue();
            Iterator<Map.Entry<String,List<String>>> ite2 = obj.mutualFunds.entrySet().iterator();

            while(ite2.hasNext()){
                Map.Entry pair2 = (Map.Entry)ite2.next();
                //  System.out.println("Fund Name : "+pair.getKey());
                List<String> ll = (List<String>) pair2.getValue();

                for(String sc : ll){
                    String [] arr = sc.split(";");
                   root =  tree.insert(root,Integer.parseInt(arr[0]),sc);
                }
            }

        }
    }

    public void findFund(int scheNo){
        String s = tree.find(root,scheNo);
        System.out.println(s);
    }
    }





