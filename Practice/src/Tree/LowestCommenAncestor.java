package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by laxminarayanvarma on 11/9/16.
 */
public class LowestCommenAncestor {
    static Node root;

    public static void main(String []args){
        LowestCommenAncestor bt = new LowestCommenAncestor();
        bt.createTree(4);
        bt.createTree(2);
        bt.createTree(3);
        bt.createTree(1);
        bt.createTree(7);
        bt.createTree(6);
        //bt.createTree(7);
        bt.inOrder(root);
        System.out.println();
        Node x = bt.lca(root,1,7);
        System.out.println(x.data);
    }
    public void inOrder(Node node){
        if(node == null) {
            return;
        }else {
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }
    public Node lca(Node root,int v1,int v2)
    {
        List<Node> v1Arr = new ArrayList<Node>();
        List<Node> v2Arr = new ArrayList<Node>();
        path(v1,v1Arr,root);
        path(v2,v2Arr,root);
        Node lca = v1Arr.get(0);
        int x = v1Arr.size() > v2Arr.size()? v2Arr.size():v1Arr.size();
        for(int i = 0;i<x;i++){
            if(v1Arr.get(i).data != v2Arr.get(i).data){
                lca = v1Arr.get(i-1);
            }
        }
        return lca;

    }
    public void path(int val,List<Node> arr,Node root){
        Node temp = root;
        int i = 0;
        while(temp.data != val){
            arr.add(temp);
            if(temp.data > val)
                temp = temp.left;
            else{
                temp = temp.right;
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
