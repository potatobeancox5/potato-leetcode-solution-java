package com.potato.study.leetcode.p0508;

import com.potato.study.leetcode.domain.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author liuzhao11
 * 
 *        508. Most Frequent Subtree Sum
 * 
 *         Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself). So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.

Examples 1
Input:

5
/  \
2   -3
return [2, -3, 4], since all the values happen only once, return all of them in any order.
Examples 2
Input:

5
/  \
2   -5
return [2], since 2 happens twice, however -5 only occur once.
Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.

 * 
 *         题目含义：
 *
 *         思路：
 *         https://www.cnblogs.com/grandyang/p/6481682.html
 *
 *         508. Most Frequent Subtree Sum

计算出现频率最高的子树和
int maxCount
set maxKey

递归求子树和
count root
int sum 等于val
如果有 left child
如果有 right child
sum 放到map中计数
如果数量大于maxCount
更改set和maxcount计数
 *
 *
 *          
 */
public class Solution {

    /**
     * 当前结果出现的最多次数
     */
    private int maxCount;
    /**
     * 出现最多次数的结果 sum 存在的set
     */
    private Set<Integer> maxKeySet;
    /**
     * 结果出现的次数map
     */
    private Map<Integer, Integer> keyAppearCountMap;


    public int[] findFrequentTreeSum(TreeNode root) {
        maxKeySet = new HashSet<>();
        keyAppearCountMap = new HashMap<>();
        dfsAndGetTheValue(root);

        List<Integer> res = new ArrayList<>(maxKeySet);

        int[] resArr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resArr[i] = res.get(i);
        }

        return resArr;
    }

    private int dfsAndGetTheValue(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int sum = root.val;
        int left = dfsAndGetTheValue(root.left);
        int right = dfsAndGetTheValue(root.right);
        sum += (left + right);
        Integer count = keyAppearCountMap.get(sum);
        if (count == null) {
            keyAppearCountMap.put(sum, 1);
            count = 1;
        } else {
            keyAppearCountMap.put(sum, count + 1);
            count++;
        }
        // 判断最大值并调整
        if (count == maxCount) {
            maxKeySet.add(sum);
        } else if (count > maxCount) {
            maxKeySet.clear();
            maxKeySet.add(sum);
            maxCount = count;
        }
        return sum;
    }

	public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(-5);

        root.left = left;
        root.right = right;

        int[] sum = solution.findFrequentTreeSum(root);
        System.out.println(Arrays.toString(sum));

    }
}
