package com.potato.study.leetcode.p0655;

import com.potato.study.leetcode.domain.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 *         655. Print Binary Tree
 * 
 *         Print a binary tree in an m*n 2D string array following these rules:

The row number m should be equal to the height of the given binary tree.
The column number n should always be an odd number.
The root node's value (in string format) should be put in the exactly middle of the first row it can be put. The column and the row where the root node belongs will separate the rest space into two parts (left-bottom part and right-bottom part). You should print the left subtree in the left-bottom part and print the right subtree in the right-bottom part. The left-bottom part and the right-bottom part should have the same size. Even if one subtree is none while the other is not, you don't need to print anything for the none subtree but still need to leave the space as large as that for the other subtree. However, if two subtrees are none, then you don't need to leave space for both of them.
Each unused space should contain an empty string "".
Print the subtrees following the same rules.
Example 1:
Input:
1
/
2
Output:
[["", "1", ""],
["2", "", ""]]
Example 2:
Input:
1
/ \
2   3
\
4
Output:
[["", "", "", "1", "", "", ""],
["", "2", "", "", "", "3", ""],
["", "", "4", "", "", "", ""]]
Example 3:
Input:
1
/ \
2   5
/
3
/
4
Output:

[["",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""]
["",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""]
["",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]
["4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]]
Note: The height of binary tree is in the range of [1, 10].
 * 
 *         思路：
 *
 *         https://blog.csdn.net/zxzxzx0119/article/details/82049332
 *
 */
public class Solution {

    public List<List<String>> printTree(TreeNode root) {

        // 1. 获取这个树的高度和宽度
        int height = getHeight(root);
        // 宽度等于 2的h次幂 -1
        int width = (1 << height) - 1;

        // 2. 构建结果数组 空的
        List<String> blankList = new ArrayList<>(width);
        for (int i = 0; i < width; i++) {
            blankList.add("");
        }

        List<List<String>> resultList = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            resultList.add(new ArrayList<>(blankList));
        }

        // 3. 递归将 root 节点的 val 放到该放的位置
        fillNumPosition(root, 0, width - 1, 0, resultList);
        return resultList;
    }


    /**
     * 填充结果集合 将制定数字 填充到指定位置
     * @param root          当前需要进行处理的节点
     * @param leftIndex     当前树的左边
     * @param rightIndex    当前树的右边（宽度）
     * @param level         当前节点层数
     * @param resultList    结果集合
     */
    private void fillNumPosition(TreeNode root, int leftIndex, int rightIndex,
                                 int level, List<List<String>> resultList) {
        if (null == root) {
            return;
        }
        // 放到指定位置 line 中间
        int mid = (leftIndex + rightIndex) / 2;
        List<String> levelResultList = resultList.get(level);
        levelResultList.set(mid, "" + root.val);
        // 处理左子树
        fillNumPosition(root.left, leftIndex, mid - 1, level + 1, resultList);
        // 处理右子树
        fillNumPosition(root.right, mid + 1, rightIndex, level + 1, resultList);
    }


    /**
     * 获取当前树的高度
     * @param root
     * @return
     */
    private int getHeight(TreeNode root) {
        if (null == root) {
            return 0;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

	
	public static void main(String[] args) {

        Solution solution = new Solution();

        TreeNode root = null;
        List<List<String>> lists = solution.printTree(root);
        System.out.println(lists);
    }
}
