package com.potato.study.leetcodecn.p00501.t001;


import com.potato.study.leetcode.domain.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 501. 二叉搜索树中的众数
 *
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。

 假定 BST 有如下定义：

 结点左子树中所含结点的值小于等于当前结点的值
 结点右子树中所含结点的值大于等于当前结点的值
 左子树和右子树都是二叉搜索树
 例如：
 给定 BST [1,null,2,2],

 1
 \
 2
 /
 2
 返回[2].

 提示：如果众数超过1个，不需考虑输出顺序

 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）



 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/find-mode-in-binary-search-tree
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 使用一个 map 递归记录 val的出现 次数
     * 最后 统计的时候 返回记录罪多的数
     * @param root
     * @return
     */
    public int[] findMode(TreeNode root) {
        if (null == root) {
            return new int[0];
        }
        Map<Integer, Integer> countMap = new HashMap<>();
        findMode(root, countMap);
        // 将map 放入队列中 大根堆里
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            priorityQueue.add(new int[]{entry.getKey(), entry.getValue()});
        }
        int maxTimes = priorityQueue.peek()[1];
        List<Integer> list = new ArrayList<>();
        while (!priorityQueue.isEmpty() && priorityQueue.peek()[1] == maxTimes) {
            int[] poll = priorityQueue.poll();
            list.add(poll[0]);
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    /**
     * 记录当前数字出现次数，递归记录其他数组
     * @param root
     * @param countMap
     */
    private void findMode(TreeNode root, Map<Integer, Integer> countMap) {
        if (null == root) {
            return;
        }
        Integer count = countMap.getOrDefault(root.val, 0);
        count++;
        countMap.put(root.val, count);
        // 递归搞下
        findMode(root.left, countMap);
        findMode(root.right, countMap);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
//        root.right = new TreeNode(2);
//        root.right.left= new TreeNode(2);

        int[] mode = solution.findMode(root);
        System.out.println(Arrays.toString(mode));
    }

}
