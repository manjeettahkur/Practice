package company;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by laxminarayanvarma on 23/1/17.
 */
public class QueueTest {

    public static void main(String [] args){
        Queue<String> q = new LinkedList<>();

        q.add("test");
        q.add("test1");
        q.add("test2");
        System.out.println(q.size());
        System.out.println(q.remove());
        System.out.println(q.size());
    }
}
