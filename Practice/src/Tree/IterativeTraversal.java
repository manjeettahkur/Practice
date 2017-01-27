package Tree;

import java.util.Stack;

/**
 * Created by laxminarayanvarma on 7/12/16.
 */
public class IterativeTraversal {
    static Node root;
    public static void main(String []args) {
        IterativeTraversal bt = new IterativeTraversal();
        bt.createTree(4);
        bt.createTree(2);
        bt.createTree(3);
        bt.createTree(1);
        bt.createTree(7);
        bt.createTree(6);
        bt.inOrder(root);
        bt.iterativeInOrder(root);
    }

    public void inOrder(Node node){
        if(node == null)
            return;
        inOrder(node.left);
        System.out.println(node.data);
        inOrder(node.right);
    }

    public void iterativeInOrder(Node node){
        if(node == null)
            return;


        Stack<Node> s = new Stack<>();
        s.push(node);
        Node current = node;

        while(!s.empty()){
            while(current != null){
                if (current.left != null)
                    s.push(current.left);
                current = current.left;
            }
            current = null;

            Node x = s.pop();
            System.out.println(x.data);
            if(x.right != null){
                s.push(x.right);
                current = x.right;
            }
        }
    }
    public void createTree(int data){
        Node newNode = new Node(data);
        Node temp ;
        Node parent = root;
        if(root == null) {
            root = newNode;
            return;
        }else{
            temp = root;
            while(temp != null){
                parent = temp;
                if(temp.data > data){
                    temp = temp.left;
                }else {
                    temp = temp.right;
                }
            }
        }
        if(parent.data > data)
            parent.left = newNode;
        else{
            parent.right = newNode;
        }
    }
}
