package com.potato.study.leetcode.p0870;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * @author liuzhao11
 *
 * 870. Advantage Shuffle
 *
 *
 * Given two arrays A and B of equal size, the advantage of A with respect to B is the number of indices i for which A[i] > B[i].

Return any permutation of A that maximizes its advantage with respect to B.



Example 1:

Input: A = [2,7,11,15], B = [1,10,4,11]
Output: [2,11,7,15]
Example 2:

Input: A = [12,24,8,32], B = [13,25,32,11]
Output: [24,32,8,12]


Note:

1 <= A.length = B.length <= 10000
0 <= A[i] <= 10^9
0 <= B[i] <= 10^9
 *
 *
 * 题目含义：
 *
 * 思路：
https://leetcode-cn.com/problems/advantage-shuffle/solution/java-qing-xi-ti-jie-by-jachindu2018/
 *
 */
public class Solution {

    public int[] advantageCount(int[] a, int[] b) {
        Arrays.sort(a);

        LinkedList<Node> list = new LinkedList<>();
        for(int i = 0; i < b.length; i++){
            list.add(new Node(b[i], i));
        }
        // 给b 排序
        Collections.sort(list, new Comparator<Node>(){
            public int compare(Node n1, Node n2){
                return n1.val - n2.val;
            }
        });

        int[] res = new int[b.length];

        for(int i = 0; i < a.length; i++){
            if(a[i] > list.getFirst().val){
                // ai 比 bi 大 那么直接将其放在最后即可
                res[list.removeFirst().index] = a[i];
            }else{
                // a i 比 bi 小 直接放到结果中
                res[list.removeLast().index] = a[i];
            }
        }
        return res;
    }

    class Node {
        public int val;
        public int index;

        public Node(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }


    public static void main(String[] args) {
		Solution solution = new Solution();

        int[] a = new int[]{2,7,11,15};
        int[] b = new int[]{1,10,4,11};
        int[] res = solution.advantageCount(a, b);
        System.out.println(Arrays.toString(res));

    }
}
