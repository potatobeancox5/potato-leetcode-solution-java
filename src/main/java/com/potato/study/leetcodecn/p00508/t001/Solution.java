package com.potato.study.leetcodecn.p00508.t001;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.potato.study.leetcode.domain.TreeNode;

/**
 * 508. 出现次数最多的子树元素和
 *
 * 给你一个二叉树的根结点，请你找出出现次数最多的子树元素和。一个结点的「子树元素和」定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。
 *
 * 你需要返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。
 *
 *  
 *
 * 示例 1：
 * 输入:
 *
 *   5
 *  /  \
 * 2   -3
 * 返回 [2, -3, 4]，所有的值均只出现一次，以任意顺序返回所有值。
 *
 * 示例 2：
 * 输入：
 *
 *   5
 *  /  \
 * 2   -5
 * 返回 [2]，只有 2 出现两次，-5 只出现 1 次。
 *
 *  
 *
 * 提示： 假设任意子树元素和均可以用 32 位有符号整数表示。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/most-frequent-subtree-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {


    /**
     * 后续遍历求和
     * 先序遍历计数
     * @param root
     * @return
     */
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> countMap = new HashMap<>();
        getAppearMap(root, countMap);
        // 遍历 map 获取最大出现次数 并反向生成 次数 list的 结构
        int maxTime = 0;
        Map<Integer, List<Integer>> resultMap = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            maxTime = Math.max(maxTime, entry.getValue());

            List<Integer> orDefault = resultMap.getOrDefault(entry.getValue(), new ArrayList<>());
            orDefault.add(entry.getKey());
            resultMap.put(entry.getValue(), orDefault);
        }
        List<Integer> list = resultMap.get(maxTime);
        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }


    /**
     * 后续遍历求和 & 计数
     * @param root
     * @param countMap
     */
    private void getAppearMap(TreeNode root, Map<Integer, Integer> countMap) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            getAppearMap(root.left, countMap);
            root.val += root.left.val;
        }
        if (root.right != null) {
            getAppearMap(root.right, countMap);
            root.val += root.right.val;
        }
        Integer count = countMap.getOrDefault(root.val, 0);
        count++;
        countMap.put(root.val, count);
    }

    public static void main(String[] args) {
//        Solution solution = new Solution();
//        int num = 28;
//        boolean res = solution.checkPerfectNumber(num);
//        System.out.println(res);
//        Assert.assertEquals(true, res);
//
//
//        num = 6;
//        res = solution.checkPerfectNumber(num);
//        System.out.println(res);
//        Assert.assertEquals(true, res);
//
//        num = 2;
//        res = solution.checkPerfectNumber(num);
//        System.out.println(res);
//        Assert.assertEquals(false, res);
    }

}
