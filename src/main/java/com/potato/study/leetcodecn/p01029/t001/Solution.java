package com.potato.study.leetcodecn.p01029.t001;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

import com.potato.study.leetcode.domain.TreeNode;

/**
 * 1029. 两地调度
 *
 * 公司计划面试 2n 人。给你一个数组 costs ，其中 costs[i] = [aCosti, bCosti] 。第 i 人飞往 a 市的费用为 aCosti ，飞往 b 市的费用为 bCosti 。
 *
 * 返回将每个人都飞到 a 、b 中某座城市的最低费用，要求每个城市都有 n 人抵达。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：costs = [[10,20],[30,200],[400,50],[30,20]]
 * 输出：110
 * 解释：
 * 第一个人去 a 市，费用为 10。
 * 第二个人去 a 市，费用为 30。
 * 第三个人去 b 市，费用为 50。
 * 第四个人去 b 市，费用为 20。
 *
 * 最低总费用为 10 + 30 + 50 + 20 = 110，每个城市都有一半的人在面试。
 * 示例 2：
 *
 * 输入：costs = [[259,770],[448,54],[926,667],[184,139],[840,118],[577,469]]
 * 输出：1859
 * 示例 3：
 *
 * 输入：costs = [[515,563],[451,713],[537,709],[343,819],[855,779],[457,60],[650,359],[631,42]]
 * 输出：3086
 *  
 *
 * 提示：
 *
 * 2 * n == costs.length
 * 2 <= costs.length <= 100
 * costs.length 为偶数
 * 1 <= aCosti, bCosti <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-city-scheduling
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {


    // 1029
    public int twoCitySchedCost(int[][] costs) {
        // 找到 costs 中 0 - 1 最小的 n 个 这n个人往a地方飞
        PriorityQueue<Integer> indexHeap = new PriorityQueue<>(
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return Integer.compare(costs[o1][0]-costs[o1][1], costs[o2][0]-costs[o2][1]);
                    }
                }
        );
        // 将多有人 按照往b地飞，求总的cost
        for (int i = 0; i < costs.length; i++) {
            indexHeap.add(i);
        }
        int total = 0;
        for (int i = 0; i < costs.length; i++) {
            Integer index = indexHeap.poll();
            if (i < costs.length / 2) {
                total += costs[index][0];
            } else {
                total += costs[index][1];
            }
        }
        return total;
    }


//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        String input = "1-2--3--4-5--6--7";
//        TreeNode treeNode = solution.recoverFromPreorder(input);
//        int i= 1;
//    }
}
