package com.potato.study.leetcodecn.p00109.t001;

import com.potato.study.leetcode.domain.ListNode;
import com.potato.study.leetcode.domain.TreeNode;
import com.potato.study.leetcode.util.ListNodeUtil;
import com.potato.study.leetcode.util.TreePrintUtil;

/**
 * 109. 有序链表转换二叉搜索树
 *
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。

 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。

 示例:

 给定的有序链表： [-10, -3, 0, 5, 9],

 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：

 0
 / \
 -3   9
 /   /
 -10  5

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 还是采用递归的方式吧 但每次选择开始位置都挺难受的
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        // head 里边是一个数组 咋整 哨兵 快慢指针
        ListNode newNhead = new ListNode(-1);
        newNhead.next = head;
        ListNode fast = newNhead;
        ListNode slow = newNhead;
        // fast 走2 步数 slow 走1步
        ListNode slowPre = null;
        while (fast != null) {
            fast = fast.next;
            slowPre = slow;
            slow = slow.next;
            if (fast != null) {
                fast = fast.next;
            }
        }
        // slow 是根
        TreeNode root = new TreeNode(slow.val);
        // 处理 链表 slow 之前那个店 指向 null
        slowPre.next = null;
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-10,-3,0,5,9};
        ListNode head = ListNodeUtil.intArrayToListNode(nums);
        TreeNode node = solution.sortedListToBST(head);
        TreePrintUtil.pirnt(node);
    }
}
