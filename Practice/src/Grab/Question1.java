package Grab;

/**
 * Created by laxminarayanvarma on 19/11/16.
 */
public class Question1 {

    public static void main(String[] args) {
        solution("10:00", "13:21");
        solution("09:42", "11:42");
        solution("00:00", "23:42");
    }

    public static int solution(String E, String L){
        String[] arrE = E.split(":");
        String[] arrL = L.split(":");

        int hdiff = Integer.parseInt(arrL[0]) - Integer.parseInt(arrE[0]);
        int mdiff = Integer.parseInt(arrL[1]) - Integer.parseInt(arrE[1]);

        if(mdiff<0){
            mdiff = mdiff + 60;
            hdiff = hdiff - 1;
        }
        int pcost = 2;

        if(hdiff > 0){
            pcost += 3;
            pcost += 4*(hdiff-1);
            if(mdiff>0)
                pcost += 4;
        } else {
            if(mdiff>0)
                pcost += 3;
        }

        //System.out.println(hdiff + ":" + mdiff);
        System.out.println(pcost);
        return pcost;
    }
}
