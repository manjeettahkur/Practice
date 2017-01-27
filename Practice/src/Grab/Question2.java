package Grab;

/**
 * Created by laxminarayanvarma on 19/11/16.
 */
public class Question2 {

    public static void main(String[] args) {
        int a[] = {1,2,4};
        System.out.println(solver(a,0));


    }
    public static int solve(int [] a,int idx,int p){
        if(idx<a.length) {
            if (p == 2) {
                return p + Math.min(solve(a, idx + 1, 2), Math.min(solve(a, idx + 1, 7), solve(a, idx + 1, 25)));
            }
            else if(p == 7) {
                int temp = idx;
                while(((temp+1) < a.length)&&(a[temp+1] - a[idx] <= 7)){
                    temp++;
                }
                return p + Math.min(solve(a, temp + 1, 2), Math.min(solve(a, temp + 1, 7), solve(a, temp + 1, 25)));
            }
            else {
                int temp = idx;
                while(((temp+1) < a.length)&&(a[temp+1] - a[idx] <= 30)){
                    temp++;
                }
                return p + Math.min(solve(a, temp + 1, 2), Math.min(solve(a, temp + 1, 7), solve(a, temp + 1, 25)));
            }
        }
        return 0;
    }

    public static int solver(int [] a,int idx){
        if(a.length<22) {
            return Math.min(solve(a, idx, 2), Math.min(solve(a, idx, 7), solve(a, idx, 25)));
        }
        return 25;
    }
}
