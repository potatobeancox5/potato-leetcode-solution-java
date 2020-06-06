package com.potato.study.leetcode.p1262;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 * 	1262. Greatest Sum Divisible by Three
 *  
 *
Given an array nums of integers, we need to find the maximum possible sum of elements of the array such that it is divisible by three.



Example 1:

Input: nums = [3,6,5,1,8]
Output: 18
Explanation: Pick numbers 3, 6, 1 and 8 their sum is 18 (maximum sum divisible by 3).
Example 2:

Input: nums = [4]
Output: 0
Explanation: Since 4 is not divisible by 3, do not pick any number.
Example 3:

Input: nums = [1,2,3,4,4]
Output: 12
Explanation: Pick numbers 1, 3, 4 and 4 their sum is 12 (maximum sum divisible by 3).


Constraints:

1 <= nums.length <= 4 * 10^4
1 <= nums[i] <= 10^4
 *         
 *         思路：
 *      https://leetcode-cn.com/problems/greatest-sum-divisible-by-three/solution/java-shu-xue-fang-fa-jian-dan-yi-dong-by-copyreadm/
 *

 *
 */
public class Solution {

    public int maxSumDivThree(int[] nums) {
        List<Integer> one = new ArrayList<>(); // 存放 mod3=1 的数
        List<Integer> two = new ArrayList<>(); // 存放 mod3=2 的数

        int sum = 0;
        for (int e : nums) {
            if (e % 3 == 1) {
                one.add(e);
            }
            if (e % 3 == 2) {
                two.add(e);
            }
            sum += e;
        }

        Collections.sort(one);
        Collections.sort(two);

        int res = sum % 3, ans = 0;

        if (res == 0) {
            return sum;
        }

        if (res == 1) {
            //剔除一个满足mod3==1的数， 或两个满足mod3==2的数
            if (two.size() >= 2) {
                ans = Math.max(ans, sum-two.get(0)-two.get(1));
            }
            if (one.size() >= 1) {
                ans = Math.max(ans, sum-one.get(0));
            }
        } else if (res == 2) {
            //剔除一个满足mod3==2的数， 或两个满足mod3==1的数
            if (two.size() > 0) {
                ans = Math.max(ans, sum-two.get(0));
            }
            if (one.size() >= 2) {
                ans = Math.max(ans, sum-one.get(0)-one.get(1));
            }
        }
        return ans;
    }

}
