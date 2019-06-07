package com.potato.study.leetcode.p0307;


/**
 * 
 * @author Administrator
 *
 *         307. Range Sum Query - Mutable
 *         
 *          
 *        Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

The update(i, val) function modifies nums by updating the element at index i to val.

Example:

Given nums = [1, 3, 5]

sumRange(0, 2) -> 9
update(1, 2)
sumRange(0, 2) -> 8
Note:

The array is only modifiable by the update function.
You may assume the number of calls to update and sumRange function is distributed evenly.
 *         
 *         
 *         
 *         题目含义：
 *              给定一种数据结构，支持更新和求和
 *         思路：
 *              https://www.cnblogs.com/yrbbest/p/5056739.html
 *              线段树，每个线段树保存这个段的start， end， sum ， left， right
 *              左孩子是 从 left 到mid 右孩子 从 mid + 1 到 right
 *              每次更新都要使用递归进行更新，直到最终的那个节点
 *
 */
public class NumArray {

    private SegmentTreeNode root;

    /**
     * 创建线段树
     * @param nums
     */
    public NumArray(int[] nums) {
        this.root = buildSegmentTreeNode(nums, 0, nums.length - 1);
    }

    /**
     * 递归创建线段树
     * @param nums
     * @return
     */
    private SegmentTreeNode buildSegmentTreeNode(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        SegmentTreeNode segmentTreeNode = new SegmentTreeNode();
        segmentTreeNode.start = start;
        segmentTreeNode.end = end;

        if (start == end) {
            segmentTreeNode.sum = nums[start];
        } else {
            int mid = (start + end) / 2;
            segmentTreeNode.left = buildSegmentTreeNode(nums, start, mid);
            segmentTreeNode.right = buildSegmentTreeNode(nums, mid + 1, end);
            segmentTreeNode.sum = segmentTreeNode.left.sum + segmentTreeNode.right.sum;
        }
        return segmentTreeNode;
    }

    public void update(int i, int val) {
        update(root, i, val);
    }

    private void update(SegmentTreeNode root, int i, int val) {
        if (i == root.start && i == root.end) {
            root.sum = val;
            return;
        }
        int mid = (root.start + root.end) / 2;
        if (i <= mid) {
            // 位于左子树
            update(root.left, i, val);
        } else {
            // 位于右子树
            update(root.right, i, val);
        }
        root.sum = root.left.sum + root.right.sum;
    }


    public int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }

    private int sumRange(SegmentTreeNode root, int i, int j) {
        if (root == null) {
            return 0;
        }
        if (i < root.start) {
            i = root.start;
        }
        if (j > root.end) {
            j = root.end;
        }
        if (i == root.start && j == root.end) {
            return root.sum;
        } else {
            int mid = (root.start + root.end) / 2;
            if (j <= mid) {
                return sumRange(root.left, i, j);
            } else if (i > mid) {
                return sumRange(root.right, i, j);
            } else {
                return sumRange(root.left, i, mid) + sumRange(root.right, mid + 1, j);
            }
        }
    }


    class SegmentTreeNode {
        public int start;
        public int end;
        public int sum;
        public SegmentTreeNode left;
        public SegmentTreeNode right;
    }


    public static void main(String[] args) {

//        int[] num = {1, 3, 5};
//
//        NumArray numArray = new NumArray(num);
//        int i = numArray.sumRange(0, 2); // 9
//        System.out.println(i);
//
//        numArray.update(1, 2);
//
//        int j = numArray.sumRange(0, 2); // 8
//        System.out.println(j);

        int[] num = {9, -8};

        NumArray numArray = new NumArray(num);
        numArray.update(0, 3);


        int i = numArray.sumRange(1, 1);
        System.out.println(i);

//        numArray.update(1, 2);
//
//        int j = numArray.sumRange(0, 2); // 8
//        System.out.println(j);





    }
}
