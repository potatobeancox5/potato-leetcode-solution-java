package com.potato.study.leetcode.p1361;


/**
 * 
 * @author liuzhao11
 * 
 * 	1361. Validate Binary Tree Nodes
 *  
 *
ou have n binary tree nodes numbered from 0 to n - 1 where node i has two children leftChild[i] and rightChild[i], return true if and only if all the given nodes form exactly one valid binary tree.

If node i has no left child then leftChild[i] will equal -1, similarly for the right child.

Note that the nodes have no values and that we only use the node numbers in this problem.



Example 1:



Input: n = 4, leftChild = [1,-1,3,-1], rightChild = [2,-1,-1,-1]
Output: true
Example 2:



Input: n = 4, leftChild = [1,-1,3,-1], rightChild = [2,3,-1,-1]
Output: false
Example 3:



Input: n = 2, leftChild = [1,0], rightChild = [-1,-1]
Output: false
Example 4:



Input: n = 6, leftChild = [1,-1,-1,4,-1,-1], rightChild = [2,-1,-1,5,-1,-1]
Output: false


Constraints:

1 <= n <= 10^4
leftChild.length == rightChild.length == n
-1 <= leftChild[i], rightChild[i] <= n - 1
 *         
 *         思路：
 *
 *          https://leetcode-cn.com/problems/validate-binary-tree-nodes/solution/judgedai-ma-ji-caseyou-cuo-wu-ti-gong-lia-zheng-qu/
 *
 */
public class Solution {

    int[] leftChild, rightChild;
    boolean[] visited;
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        // 统计每个结点的父亲数：1. 若父亲数大于1则为false  2.若父亲数等于0的不是1个则为false
        int[] indegreeCnt = new int[n];
        for (int i = 0; i < n; i++) {
            if((leftChild[i] != -1 && ++indegreeCnt[leftChild[i]] > 1)
                    || (rightChild[i] != -1 && ++indegreeCnt[rightChild[i]] > 1)) {
                return false;
            }
        }
        int root = -1;
        for (int i = 0; i < n; i++){
            if (indegreeCnt[i] == 0) {
                if (root != -1) {
                    return false;
                }
                root = i;
            }
        }

        // 上面的判断可以解决单个连通域的树判断、及部分多连通域情况
        // 例如下面的情况无法判断，需要再判断连通域的个数。从root一遍dfs之后，若存在结点未被访问说明多个连通域。
        // 1 <--- 0 <--->  2， 4 --->3
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        visited = new boolean[n];
        dfs(root);
        for (boolean v: visited) {
            if (!v) {
                return false;
            }
        }
        return true;
    }

    private void dfs(int v) {
        if (v == -1) {
            return;
        }
        visited[v] = true;
        dfs(leftChild[v]);
        dfs(rightChild[v]);
    }
}
