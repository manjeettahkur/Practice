package Questions;

/**
 * Created by laxminarayanvarma on 9/9/16.
 *
 *http://www.geeksforgeeks.org/fiberlink-maas360-interview-experience-set-5-online-round/
 */
public class TicketCounterPrice {

    public static void main(String[] args){
        int array[]= {2,4,3,4,1,2};
        int noOfTickets = 7;
        int currentTicketPrice = 0;
        int currentMaxIndex = -1;
        int totalSum = 0;
        System.out.println("Max price possible for this collection is :");
        while(noOfTickets > 0){
            currentMaxIndex = getMaxIndex(array);
            currentTicketPrice = array[currentMaxIndex];
            array[currentMaxIndex] -= 1;
            System.out.print(currentTicketPrice + " ");
            totalSum += currentTicketPrice;
            noOfTickets--;
        }
        System.out.println();
        System.out.println("Max sum possible is : " + totalSum);
    }
    public static int getMaxIndex(int []array){
        int index = -1;
        int max = 0;
        int i = 0;
        for(int arrVal : array){
            if(arrVal > max) {
                max = arrVal;
                index = i;
            }
            i++;
        }
        return index;
    }

}
