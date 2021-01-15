package com.potato.study.leetcodecn.p01302.t001;


import com.potato.study.leetcode.domain.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1313. 解压缩编码列表
 *
 * 给你一个以行程长度编码压缩的整数列表 nums 。

 考虑每对相邻的两个元素 [freq, val] = [nums[2*i], nums[2*i+1]] （其中 i >= 0 ），每一对都表示解压后子列表中有 freq 个值为 val 的元素，你需要从左到右连接所有子列表以生成解压后的列表。

 请你返回解压后的列表。

  

 示例：

 输入：nums = [1,2,3,4]
 输出：[2,4,4,4]
 解释：第一对 [1,2] 代表着 2 的出现频次为 1，所以生成数组 [2]。
 第二对 [3,4] 代表着 4 的出现频次为 3，所以生成数组 [4,4,4]。
 最后将它们串联到一起 [2] + [4,4,4] = [2,4,4,4]。
 示例 2：

 输入：nums = [1,1,2,3]
 输出：[1,3,3]
  

 提示：

 2 <= nums.length <= 100
 nums.length % 2 == 0
 1 <= nums[i] <= 100

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/decompress-run-length-encoded-list
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 层序遍历 每次计算每层的值直接返回
     * @param root
     * @return
     */
    public int deepestLeavesSum(TreeNode root) {
        int currentLayerTotal = 0;
        if (null == root) {
            return currentLayerTotal;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            currentLayerTotal = 0;
            int currentLayerNum = queue.size();
            for (int i = 0; i < currentLayerNum; i++) {
                TreeNode currentNode = queue.poll();
                currentLayerTotal += currentNode.val;
                // 孩子们入队
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
        }
        return currentLayerTotal;
    }

//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        int[] nums = new int[]{1,1,2,3};
//        int[] res = solution.deepestLeavesSum(nums);
//        // [1,3,3]
//        System.out.println(Arrays.toString(res));
//    }
}
