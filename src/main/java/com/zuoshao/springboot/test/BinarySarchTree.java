//package com.zuoshao.springboot.test;
//
//
//import com.sun.org.apache.bcel.internal.generic.NEW;
//import sun.reflect.generics.tree.Tree;
//
//import java.util.ArrayList;
//import java.util.List;
//
//// * Definition for a binary tree node.
////class TreeNode {
////      int val;
////      TreeNode left;
////      TreeNode right;
////      TreeNode(int x) { val = x; }
////  }
//
//
////class TreeNode {
////
////    int key;
////
////    TreeNode left;
////
////    TreeNode right;
////
////
////    public TreeNode(int key) {
////        left = null;
////        right = null;
////        this.key = key;
////    }
////}
//
//public class BinarySarchTree {
////    TreeNode pre;
////    int min = Integer.MAX_VALUE;
////
////    public int minDiffInBST(TreeNode root) {
////        inorder(root);
////        return min;
////    }
////    public static void main(String[] args) {
//////        BinarySarchTree binarySarchTree = new BinarySarchTree();
//////        binarySarchTree.minDiffInBST();
////    }
////    public void inorder(TreeNode node) {
////        if (node == null)
////            return;
////        inorder(node.left);
////        if (pre != null) {
////            min = Math.min(min, node.val - pre.val);
////        }
////        pre = node;
////        inorder(node.right);
////        System.out.println(pre.val);
////    }
//
//    public static void main(String[] args) {
//        BinarySarchTree binarySarchTree = new BinarySarchTree();
//        List<TreeNode> tree = binarySarchTree.createTree();
////        for (TreeNode treeNode : tree) {
////            System.out.println(treeNode.key);
////        }
////
////    for (int nodeIndex = 0; nodeIndex < array.length;nodeIndex++) {
////        inOrderTraverse(new TreeNode(array[nodeIndex]));
////    }
//        for (TreeNode treeNode : tree) {
//            inOrderTraverse(treeNode);
//        }
//    }
//    //中序遍历,递归方式
//    public static void inOrderTraverse(TreeNode node){
//
//        if(node == null)
//            return;
//        inOrderTraverse(node.left);
//        System.out.print(node.key+" ");
//        inOrderTraverse(node.right);
//
//    }
//
//
//}
