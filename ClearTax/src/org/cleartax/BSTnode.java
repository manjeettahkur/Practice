package org.cleartax;

/**
 * Created by laxminarayanvarma on 17/9/16.
 */
public class BSTnode {
    int schemeNo;
    String details;
    BSTnode left;
    BSTnode right;

    public BSTnode(int schemeNo,String details){
        this.schemeNo = schemeNo;
        this.details = details;
        this.left = null;
        this.right = null;
    }
}
