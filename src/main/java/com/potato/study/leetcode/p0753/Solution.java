package com.potato.study.leetcode.p0753;

import org.junit.Assert;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author liuzhao11
 * 
 * 	753. Cracking the Safe
 *  
 *         There is a box protected by a password. The password is a sequence of n digits where each digit can be one of the first k digits 0, 1, ..., k-1.

While entering a password, the last n digits entered will automatically be matched against the correct password.

For example, assuming the correct password is "345", if you type "012345", the box will open because the correct password matches the suffix of the entered password.

Return any password of minimum length that is guaranteed to open the box at some point of entering it.



Example 1:

Input: n = 1, k = 2
Output: "01"
Note: "10" will be accepted too.
Example 2:

Input: n = 2, k = 2
Output: "00110"
Note: "01100", "10011", "11001" will be accepted too.


Note:

n will be in the range [1, 4].
k will be in the range [1, 10].
k^n will be at most 4096.


 *   解题思路：
 *
 * 
 */
public class Solution {


    /**
     * 发起方法
     * @param n
     * @param k
     * @return
     */
    public String crackSafe(int n, int k) {
        Set<String> visitedSet = new HashSet<>();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            result.append('0');
        }
        visitedSet.add(result.toString());

        int totalNum = (int) Math.pow(k, n);
        this.dfsCrackSafe(visitedSet, result, n, k, totalNum);
        return result.toString();
    }

    /**
     *  每次保证前缀都是一致的 只对最后一个字段进行遍历 比较
     * @param visitedSet    已经尝试过的密码 set
     * @param result        最终得到的结果集
     * @param totalNum      总共需要尝试的密码种类数
     * @return
     */
    private boolean dfsCrackSafe(Set<String> visitedSet, StringBuilder result, int n, int k, int totalNum) {

        // 0 是否满足终止递归条件
        if (totalNum == visitedSet.size()) {
            return true;
        }
        // 1 拿到之前已经确定的字符串
        int length = result.length();
        String prefix = result.substring(length - n + 1);
        // 2 遍历 k 拼装最终的密码
        for (int i = 0; i < k; i++) {
            String password = prefix + i;
            // 3 遍历中递归 判断是否可以得到解 不能的话 递归进行删除
            if (visitedSet.contains(password)) {
                continue;
            }
            visitedSet.add(password);
            result.append(i);
            if (dfsCrackSafe(visitedSet, result, n, k, totalNum) ) {
                return true;
            } else {
                visitedSet.remove(password);
                result.deleteCharAt(result.length() - 1);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int n = 1;
        int k = 2;
        String word = solution.crackSafe(n, k);
        System.out.println("count:" + word);
        Assert.assertEquals("01", word);

        n = 2;
        k = 2;
        word = solution.crackSafe(n, k);
        System.out.println("count:" + word);
        Assert.assertEquals("00110", word);
    }
}
