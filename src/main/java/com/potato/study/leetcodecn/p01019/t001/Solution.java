package com.potato.study.leetcodecn.p01019.t001;

import com.potato.study.leetcode.domain.ListNode;
import com.potato.study.leetcode.util.ListNodeUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 1019. 链表中的下一个更大节点
 *
 * 给出一个以头节点 head 作为第一个节点的链表。链表中的节点分别编号为：node_1, node_2, node_3, ... 。

 每个节点都可能有下一个更大值（next larger value）：对于 node_i，如果其 next_larger(node_i) 是 node_j.val，那么就有 j > i 且  node_j.val > node_i.val，而 j 是可能的选项中最小的那个。如果不存在这样的 j，那么下一个更大值为 0 。

 返回整数答案数组 answer，其中 answer[i] = next_larger(node_{i+1}) 。

 注意：在下面的示例中，诸如 [2,1,5] 这样的输入（不是输出）是链表的序列化表示，其头节点的值为 2，第二个节点值为 1，第三个节点值为 5 。

  

 示例 1：

 输入：[2,1,5]
 输出：[5,5,0]
 示例 2：

 输入：[2,7,4,3,5]
 输出：[7,0,5,5,0]
 示例 3：

 输入：[1,7,5,1,9,2,5,1]
 输出：[7,9,9,9,0,5,0,0]
  

 提示：

 对于链表中的每个节点，1 <= node.val <= 10^9
 给定列表的长度在 [0, 10000] 范围内

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/next-greater-node-in-linked-list
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * stack 存还没搞定的点信息 包括当前点值 直接存节点吧
     使用map 记录 node 对应index 的关系

     遍历数组 如果当前点比栈顶大 依次设置栈顶对应位置的值u
     * @param head
     * @return
     */
    public int[] nextLargerNodes(ListNode head) {
        if (null == head) {
            return new int[0];
        }
        // stack 存还没搞定的点信息 包括当前点值 直接存节点吧
        Stack<ListNode> todoStack = new Stack<>();
        // 使用map 记录 node 对应index 的关系
        Map<ListNode, Integer> node2IndexMap = new HashMap<>();
        ListNode p = head;
        int index = 0;
        // 存最终的结果 key 是index， value 是结果
        Map<Integer, Integer> map = new HashMap<>();
        while (p != null) {
            if (todoStack.isEmpty()) {
                todoStack.add(p);
            } else {
                // todoStack 有值 看下能不能生成结果
                while (todoStack.size() > 0 && todoStack.peek().val < p.val) {
                    ListNode node = todoStack.pop();
                    map.put(node2IndexMap.get(node), p.val);
                }
                todoStack.add(p);
            }
            node2IndexMap.put(p, index);
            p = p.next;
            index++;
        }
        // generate result
        int[] result = new int[index];
        for (int i = 0; i < result.length; i++) {
            result[i] = map.getOrDefault(i, 0);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = ListNodeUtil.arrayStringToListNode("[2,1,5]");
        int[] nums = solution.nextLargerNodes(head);
        // [5,5,0]
        System.out.println(Arrays.toString(nums));
    }
}
