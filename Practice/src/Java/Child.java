package Java;

/**
 * Created by laxminarayanvarma on 17/10/16.
 */
public class Child extends Parent{
    public void sayHello(){
        System.out.println("child hello");
    }
    public void sayMello(){
        System.out.println("Mello");
    }
    public static void main(String args[]){

        Parent p = new Child();
        p.sayHello();
    }
}
