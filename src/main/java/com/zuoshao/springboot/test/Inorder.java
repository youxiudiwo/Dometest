package com.zuoshao.springboot.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


class TreeNode {
    Integer val;
    TreeNode left;
    TreeNode right;
    TreeNode(Integer x) { val = x; }

    //增加左节点
    public void addleft(Integer val){
        TreeNode leftchild = new TreeNode(val);
        this.left = leftchild;
    }

    //增加右节点
    public void addrighe(Integer val){
        TreeNode rightchild = new TreeNode(val);
        this.right = rightchild;
    }

    @Override
    public String toString(){
        return this.val==null?"":this.val.toString();
    }

}

public class Inorder {
//
//    public List< Integer > inorderTraversal() {
//
//
//        return ;
//    }

    private static void visitNode(TreeNode node) {
        System.out.print(node.val + "\t");
    }


    public static void midOrderTravel(TreeNode root) {
        if (root == null) {
            return;
        }
        midOrderTravel(root.left);
        visitNode(root);
        midOrderTravel(root.right);
    }
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.addleft(2);
        treeNode.addrighe(3);
        treeNode.left.addleft(4);
        treeNode.left.addrighe(5);
        System.out.println(treeNode.toString());

        Inorder.midOrderTravel(treeNode);
        LinkedList<Integer> integers = new LinkedList<>();
        List<Integer> helper = helper(treeNode, integers);
        System.out.println(helper);

    }

    public static List<Integer> helper(TreeNode root, List<Integer> res) {
        if (root != null) {
            if (root.left != null) {
                helper(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) {
                helper(root.right, res);
            }
        }
        return res;
    }
}
