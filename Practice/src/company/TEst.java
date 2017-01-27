package company;

/**
 * Created by laxminarayanvarma on 3/1/17.
 */
public final class TEst {
    class Inner{
        void te(){
            if(TEst.this.flag){
                sample();
            }
        }
    }

    private boolean flag = true;

    public void sample(){
        System.out.println("Sample");
    }

    public TEst(){
        (new Inner()).te();
    }

    public static void main(String args []){
        new TEst();
        try{

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
