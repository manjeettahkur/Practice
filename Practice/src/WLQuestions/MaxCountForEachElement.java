package WLQuestions;

/**
 * Created by laxminarayanvarma on 27/9/16.
 */
public class MaxCountForEachElement {
    static Node root = null;
    public static int max(int a,int b){
        return (a > b)? a : b;
    }
    public static int size(Node node){
        if(node == null)
            return 0;
        return node.size;
    }
    public static int height(Node node){
        if(node == null)
            return 0;
        return node.height;
    }
    public static void printArray(int arr[] ){
        for(int x: arr)
            System.out.print(x+" ");
        System.out.println();
    }
    public static void main(String[]args){
        int arr[] = {10, 6, 15, 20, 30, 5, 7};
        int count[] = new int[arr.length];
        constructCountArray(arr,count);
        printArray(arr);
        printArray(count);
    }

    public static void constructCountArray(int arr[] ,int count[]){
        for (int x :count ) {
            x = 0;
        }
        for (int i = arr.length-1; i >= 0; i--)
        {
            root = insert(root, arr[i], count,i);
        }
    }

    public static Node insert(Node node,int data,int count[],int index){
        if (node == null)
            return(new Node(data));

        if (data < node.data)
            node.left  = insert(node.left, data, count,index);
        else
        {
            node.right = insert(node.right, data, count,index);
            count[index] +=  size(node.left) + 1;
        }

        node.height = max(height(node.left), height(node.right)) + 1;
        node.size   = size(node.left) + size(node.right) + 1;

        int balance = getBalance(node);
        // Left Left Case
        if (balance > 1 && data < node.left.data)
            return rightRotate(node);

        // Right Right Case
        if (balance < -1 && data > node.right.data)
            return leftRotate(node);

        // Left Right Case
        if (balance > 1 && data > node.left.data)
        {
            node.left =  leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && data < node.right.data)
        {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    public static int getBalance(Node node){
        if (node == null)
            return 0;
        return height(node.left) - height(node.right);
    }

    public static Node rightRotate(Node y){
        Node x = y.left;
        Node T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = max(height(y.left), height(y.right))+1;
        x.height = max(height(x.left), height(x.right))+1;

        // Update sizes
        y.size = size(y.left) + size(y.right) + 1;
        x.size = size(x.left) + size(x.right) + 1;

        // Return new root
        return x;
    }
    public static Node leftRotate(Node x){
        Node y = x.right;
        Node T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        //  Update heights
        x.height = max(height(x.left), height(x.right))+1;
        y.height = max(height(y.left), height(y.right))+1;

        // Update sizes
        x.size = size(x.left) + size(x.right) + 1;
        y.size = size(y.left) + size(y.right) + 1;

        // Return new root
        return y;
    }

}

class Node{
    int data;
    Node left;
    Node right;
    int height;
    int size;

    public Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
        this.height = 1;
        this.size = 1;
    }
}


