package test;

/**
 * Created by laxminarayanvarma on 30/12/16.
 */
public class Question2 {

    public static void main(String [] args){
      char arr[] = {'a','b','c','e'};
        String str = "123ae45cb5634b1234e234c4b5a";
        System.out.println(smallest(str,arr));
    }
    static String smallest(String s,char []a){

        int[] count = new int[256];
        int[] substr = new int[256];
        boolean[] str2=new boolean[256];

        int i=0,j=0,m=0,sum=a.length;
        for(i=0;i<a.length;i++){
            count[a[i]]++;
            str2[a[i]]=true;
        }
        i=0;
        while(str2[s.charAt(i)]!=true){
            i++;
        }

        j=i;

        while(sum!=0&&j<s.length()){
            if(count[s.charAt(j)]!=0){
                sum--;
                count[s.charAt(j)]--;
            }
            if(str2[s.charAt(j)]){
                substr[s.charAt(j)]++;
            }
            if(sum==0){
                break;
            }
            j++;

        }
        if(j==s.length()){
            return "";
        }
        m=j-i+1;

        for(int k=0;k<a.length;k++){
            count[a[k]]++;
            str2[a[k]]=true;
        }
      //  System.out.println(s.substring(i,m+i));
        j++;
        String result = s.substring(i,m+i);
        while(j<s.length()){

            if(str2[s.charAt(j)]){
                substr[s.charAt(j)]++;
            }
            if(s.charAt(j)==s.charAt(i)){
                substr[s.charAt(i)]--;
                i++;
                while(str2[s.charAt(i)]!=true||substr[s.charAt(i)]>count[s.charAt(i)]){

                    if(str2[s.charAt(i)]){
                        substr[s.charAt(i)]--;
                    }
                    i++;
                }
            }
            if(j-i+1<m){
                m=j-i+1;
                result = s.substring(i,m+i);
            }
            j++;
        }
         return result;
    }
}
