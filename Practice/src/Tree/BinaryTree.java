package Tree;

/**
 * Created by laxminarayanvarma on 29/8/16.
 */
public class BinaryTree {
    TreeNode root;

    public static void main(String []args){
        BinaryTree bt = new BinaryTree();
        bt.createTree(4);
        bt.createTree(3);
        bt.createTree(6);
        bt.createTree(2);
        bt.createTree(5);
        //bt.createTree(1);
        bt.createTree(7);
        bt.printTree();
        System.out.println("Level order");
        bt.levelOrder();
    }

    public void createTree(int data){
        TreeNode newNode = new TreeNode(data);
        TreeNode temp ;
        TreeNode parent = root;
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
    public void printTree(){
        System.out.println("Printing In order");
        inOrder(root);
        System.out.println();
        System.out.println("Printing Pre order");
        preOrder(root);
        System.out.println();
        System.out.println("Printing Post order");
        postOrder(root);
    }
    public void inOrder(TreeNode node){
           if(node == null) {
               return;
           }else {
               inOrder(node.left);
               System.out.print(node.data + " ");
               inOrder(node.right);
           }
    }
    public void preOrder(TreeNode node){
        if(node == null) {
            return;
        }else {
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }
    public void postOrder(TreeNode node){
        if(node == null) {
            return;
        }else {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data + " ");
        }
    }

    public void levelOrder(){
        TreeNode [] array = new TreeNode[50];


        array[0] = root;
        int index = 0;
        int i = 0;
        while(array[index] != null){
            System.out.println(array[index].data);
            if(array[index].left != null)
            array[++i] = array[index].left;
            if(array[index].right != null)
            array[++i] = array[index].right;

            index++;
        }
    }

}