package com.potato.study.leetcodecn.p00821.t001;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * 821. 字符的最短距离
 *
 * 给定一个字符串 S 和一个字符 C。返回一个代表字符串 S 中每个字符到字符串 S 中的字符 C 的最短距离的数组。

  

 示例：

 输入：S = "loveleetcode", C = 'e'
 输出：[3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
  

 提示：

 字符串 S 的长度范围为 [1, 10000]。
 C 是一个单字符，且保证是字符串 S 里的字符。
 S 和 C 中的所有字母均为小写字母。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/shortest-distance-to-a-character
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     *
     * https://blog.csdn.net/Mercuriooo/article/details/100406505
     * SortedSet 使用方法
     * 1. 遍历 s 找到 每次 c出现的下标 使用 SortedSet 保存下标
     * 2. 遍历 s 找到 第一个大于index 下表的e 的first SortedSet tailSet(fromElement):子集,由大于fromElement的元素组成
     * @param s
     * @param c
     * @return
     */
    public int[] shortestToChar(String s, char c) {
        if (null == s || "".equals(s)) {
            return new int[]{};
        }
        // 默认升序
        SortedSet<Integer> sortedSet = new TreeSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                sortedSet.add(i);
            }
        }
        int[] res = new int[s.length()];
        Arrays.fill(res, Integer.MAX_VALUE);
        for (int i = 0; i < res.length; i++) {
            SortedSet<Integer> tailSet = sortedSet.tailSet(i);
            if (!tailSet.isEmpty()) {
                Integer target1 = tailSet.first();
                // 求距离
                res[i] = Math.abs(target1 - i);
            }

            SortedSet<Integer> headSet = sortedSet.headSet(i);
            if (!headSet.isEmpty()) {
                Integer target2 = headSet.last();
                res[i] = Math.min(res[i], Math.abs(target2 - i));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "loveleetcode";
        char c = 'e';
        int[] ints = solution.shortestToChar(s, c);
        // [3,2,1,0,1,0,0,1,2,2,1,0]
        // [3,2,1,0,1,0,0,1,2,2,1,0]
        System.out.println(Arrays.toString(ints));
    }
}
