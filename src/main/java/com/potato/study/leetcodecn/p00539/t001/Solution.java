package com.potato.study.leetcodecn.p00539.t001;


import com.potato.study.leetcode.domain.TreeNode;

/**
 * 539. 最小时间差
 *
 * 给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。

  

 示例 1：

 输入：timePoints = ["23:59","00:00"]
 输出：1
 示例 2：

 输入：timePoints = ["00:00","23:59","00:00"]
 输出：0
  

 提示：

 2 <= timePoints <= 2 * 104
 timePoints[i] 格式为 "HH:MM"


 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/minimum-time-difference
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    private TreeNode lastNode;
    /**
     * 右子树 根 左子树
     * @param root
     * @return
     */
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return root;
        }
        convertBST(root.right);
        if (lastNode != null) {
            root.val += lastNode.val;
        }
        lastNode = root;
        convertBST(root.left);
        return root;
    }



//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        String a = "1+1i";
//        String b = "1+1i";
//        String s = solution.complexNumberMultiply(a, b);
//        System.out.println(s);
//        Assert.assertEquals("0+2i", s);
//
//        a = "1+-1i";
//        b = "1+-1i";
//        s = solution.complexNumberMultiply(a, b);
//        System.out.println(s);
//        Assert.assertEquals("0+-2i", s);
//    }

}
