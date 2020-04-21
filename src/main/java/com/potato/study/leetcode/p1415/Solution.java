package com.potato.study.leetcode.p1415;


import org.junit.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 * 	1415. The k-th Lexicographical String of All Happy Strings of Length n
 *  
 *
A happy string is a string that:

consists only of letters of the set ['a', 'b', 'c'].
s[i] != s[i + 1] for all values of i from 1 to s.length - 1 (string is 1-indexed).
For example, strings "abc", "ac", "b" and "abcbabcbcb" are all happy strings and strings "aa", "baa" and "ababbc" are not happy strings.

Given two integers n and k, consider a list of all happy strings of length n sorted in lexicographical order.

Return the kth string of this list or return an empty string if there are less than k happy strings of length n.



Example 1:

Input: n = 1, k = 3
Output: "c"
Explanation: The list ["a", "b", "c"] contains all happy strings of length 1. The third string is "c".
Example 2:

Input: n = 1, k = 4
Output: ""
Explanation: There are only 3 happy strings of length 1.
Example 3:

Input: n = 3, k = 9
Output: "cab"
Explanation: There are 12 different happy string of length 3 ["aba", "abc", "aca", "acb", "bab", "bac", "bca", "bcb",
"cab", "cac", "cba", "cbc"]. You will find the 9th string = "cab"
Example 4:

Input: n = 2, k = 7
Output: ""
Example 5:

Input: n = 10, k = 100
Output: "abacbabacb"


Constraints:

1 <= n <= 10
1 <= k <= 100
 *         
 *         思路：
 *
 *
 *          https://leetcode-cn.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/solution/hui-su-by-mufanlee/
 *
 *
 *
 */
public class Solution {


    public String getHappyString(int n, int k) {

        List<String> list = new ArrayList<>();

        backtracking("a", n-1, list);
        backtracking("b", n-1, list);
        backtracking("c", n-1, list);


        if (list.size() < k) {
            return "";
        }
        Collections.sort(list);
        return list.get(k-1);
    }

    private void backtracking(String s, int k, List<String> res) {
        // 判断 k 是不是已经超过了index限制
        if (k < 0 || (s.length() > 1 && s.charAt(s.length() - 1) == s.charAt(s.length() - 2))) {
            return;
        }

        if (k == 0) {
            res.add(s);
            return;
        }
        backtracking(s + 'a', k-1, res);
        backtracking(s + 'b', k-1, res);
        backtracking(s + 'c', k-1, res);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int n = 1;
        int k = 3;
        String res = solution.getHappyString(n, k);
        System.out.println(res);
        Assert.assertEquals("c", res);

        n = 1;
        k = 4;
        res = solution.getHappyString(n, k);
        System.out.println(res);
        Assert.assertEquals("", res);

        n = 3;
        k = 9;
        res = solution.getHappyString(n, k);
        System.out.println(res);
        Assert.assertEquals("cab", res);

        n = 2;
        k = 7;
        res = solution.getHappyString(n, k);
        System.out.println(res);
        Assert.assertEquals("", res);

        n = 10;
        k = 100;
        res = solution.getHappyString(n, k);
        System.out.println(res);
        Assert.assertEquals("abacbabacb", res);
    }
}
