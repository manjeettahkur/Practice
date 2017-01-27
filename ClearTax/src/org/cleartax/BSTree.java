package org.cleartax;

/**
 * Created by laxminarayanvarma on 17/9/16.
 */
public class BSTree {
    public BSTnode insert(BSTnode root ,int id,String details){
        BSTnode newNode = new BSTnode(id,details);
        if(root==null){
            root = newNode;
            return root;
        }
        BSTnode current = root;
        BSTnode parent = null;
        while(true){
            parent = current;
            if(id<current.schemeNo){
                current = current.left;
                if(current==null){
                    parent.left = newNode;
                    return root;
                }
            }else{
                current = current.right;
                if(current==null){
                    parent.right = newNode;
                    return root;
                }
            }
        }
    }

    public String find(BSTnode root ,int id){
        BSTnode current = root;
        while(current!=null){
            if(current.schemeNo==id){
                return current.details;
            }else if(current.schemeNo>id){
                current = current.left;
            }else{
                current = current.right;
            }
        }
        return current.details;
    }

}
