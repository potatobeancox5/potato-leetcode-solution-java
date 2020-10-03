package com.potato.study.leetcodecn.p0023.t001;


import com.potato.study.leetcode.domain.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 23. 合并K个升序链表
 *
 * 给你一个链表数组，每个链表都已经按升序排列。

 请你将所有链表合并到一个升序链表中，返回合并后的链表。

  

 示例 1：

 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 输出：[1,1,2,3,4,4,5,6]
 解释：链表数组如下：
 [
 1->4->5,
 1->3->4,
 2->6
 ]
 将它们合并到一个有序链表中得到。
 1->1->2->3->4->4->5->6
 示例 2：

 输入：lists = []
 输出：[]
 示例 3：

 输入：lists = [[]]
 输出：[]
  

 提示：

 k == lists.length
 0 <= k <= 10^4
 0 <= lists[i].length <= 500
 -10^4 <= lists[i][j] <= 10^4
 lists[i] 按 升序 排列
 lists[i].length 的总和不超过 10^4

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 维护一个 K大小的小顶堆
     * 每次 删除 对顶 放到新生成的链表中，同时 获取其后继节点 将其放入堆中
     * 如果某一个 链表被遍历完 那么 堆的大小会-1
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {

        if (null == lists || lists.length == 0){
            return null;
        }

        // 初始化 小顶堆
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (int i = 0; i < lists.length; i++) {
            if (null == lists[i]) {
                continue;
            }
            minHeap.add(lists[i]);
        }
        // 每次 删除 对顶 放到新生成的链表中，同时 获取其后继节点 将其放入堆中
        ListNode head = new ListNode(-1);
        ListNode p = head;
        while (!minHeap.isEmpty()) {
            // 当前最小的节点
            ListNode node = minHeap.poll();
            ListNode next = node.next;
            if (null != next) {
                minHeap.add(next);
            }
            // 链接
            p.next = node;
            p = node;
            node.next = null;
        }
        return head.next;
    }

    public static void main(String[] args) {
//        Solution solution = new Solution();
//        solution.mergeKLists();
    }
}
