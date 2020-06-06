package com.potato.study.leetcode.p1449;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author liuzhao11
 * 
 * 	1449. Form Largest Integer With Digits That Add up to Target
 *  
 *
Given an array of integers cost and an integer target. Return the maximum integer you can paint under the following rules:

The cost of painting a digit (i+1) is given by cost[i] (0 indexed).
The total cost used must be equal to target.
Integer does not have digits 0.
Since the answer may be too large, return it as string.

If there is no way to paint any integer given the condition, return "0".



Example 1:

Input: cost = [4,3,2,5,6,7,2,5,5], target = 9
Output: "7772"
Explanation:  The cost to paint the digit '7' is 2, and the digit '2' is 3. Then cost("7772") = 2*3+ 3*1 = 9. You could also paint "977", but "7772" is the largest number.
Digit    cost
1  ->   4
2  ->   3
3  ->   2
4  ->   5
5  ->   6
6  ->   7
7  ->   2
8  ->   5
9  ->   5
Example 2:

Input: cost = [7,6,5,5,5,6,8,7,8], target = 12
Output: "85"
Explanation: The cost to paint the digit '8' is 7, and the digit '5' is 5. Then cost("85") = 7 + 5 = 12.
Example 3:

Input: cost = [2,4,6,2,4,6,4,4,4], target = 5
Output: "0"
Explanation: It's not possible to paint any integer with total cost equal to target.
Example 4:

Input: cost = [6,10,15,40,40,40,40,40,40], target = 47
Output: "32211"


Constraints:

cost.length == 9
1 <= cost[i] <= 5000
1 <= target <= 5000
 *         
 *
 *
 *
 *  思路：
 *
 *
 */
public class Solution {



    public String largestNumber(int[] cost, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < cost.length; i++) {
            map.put(cost[i], i + 1);
        }
        String[] dp = new String[target + 1];
        Arrays.fill(dp, "-1");
        dp[0] = "0";
        for (int coin : map.keySet()) {
            for (int i = coin; i < target + 1; i++) {
                dp[i] = max(dp[i], maxString(dp[i - coin], String.valueOf(map.get(coin))));
            }
        }
        return dp[target].equals("-1") ? "0" : dp[target];
    }

    private String maxString(String s, String num) {
        if (s.equals("-1")) return "-1";
        if (s.equals("0")) return num;
        char[] c = s.toCharArray();
        int index = binarySearch(c, num.charAt(0));
        String ans = "";
        if (index < 0) {
            index = -(index + 1);
        }
        ans += new String(c, 0, index);
        ans += num;
        ans += new String(c, index, c.length - index);
        return ans;
    }

    private int binarySearch(char[] c, char target) {

        int left = 0;
        int right = c.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            char mVal = c[mid];
            if (mVal < target) {
                right = mid - 1;
            } else if (mVal > target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -(left + 1);
    }

    private String max(String s, String s1) {
        if (s1.equals("-1")) {
            return s;
        }
        if (s.equals("-1")) {
            return s1;
        }
        if (s.length() != s1.length()) {
            return s.length() > s1.length() ? s : s1;
        }
        int len = s.length();
        int i = 0;
        while (i < len) {
            if (s.charAt(i) > s1.charAt(i)) {
                return s;
            } else if (s.charAt(i) < s1.charAt(i)) {
                return s1;
            } else {
                i++;
            }
        }
        return s;
    }
}
