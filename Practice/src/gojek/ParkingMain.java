package gojek;

import gojek.Actions.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by laxminarayanvarma on 9/11/16.
 */
public class ParkingMain {
    CarParking carparkingLot = null;
    Action action;
    public static void main(String[] args) {
        BufferedReader br = null;
        ParkingMain main = new ParkingMain();

        if(args.length > 0) {
            try {
                String currentLine;
                br = new BufferedReader(new FileReader(args[0]));

                while ((currentLine = br.readLine()) != null) {
                   main.processInput(currentLine);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (br != null) br.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }else{
            Scanner sc = new Scanner(System.in);
            String input;
            while(true){
                input = sc.nextLine();
                if(input.contains("quit")){
                    break;
                }else{
                    main.processInput(input);
                }
            }
            sc.close();
        }
    }
    public void processInput(String input){
        if (input.contains("create_parking_lot")) {
            String[] sp = input.split(" ");
            int max = Integer.parseInt(sp[1]);
            carparkingLot = CarParking.getInstance(max);
            System.out.println();
        } else {
            action = getAction(input);
            if (action != null)
                action.process(carparkingLot);
            System.out.println();
        }
    }

    public Action getAction(String input) {
        Action action = null;
        String[] sp = input.split(" ");
        if (sp[0].equals("park")) {
            action = new ParkAction(sp[1], sp[2]);
        } else if (sp[0].equals("leave")) {
            action = new LeaveAction(Integer.parseInt(sp[1]));
        } else if (sp[0].equals("status")) {
            action = new StatusAction();
        } else if (sp[0].equals("registration_numbers_for_cars_with_colour")) {
            action = new RNoByColourAction(sp[1]);
        } else if (sp[0].equals("slot_numbers_for_cars_with_colour")) {
            action = new SlotNoByColourAction(sp[1]);
        } else if (sp[0].equals("slot_number_for_registration_number")) {
             action = new SlotNoByRNoAction(sp[1]);
        } else {
            System.out.println("invalid input");
        }
        return action;
    }
}
