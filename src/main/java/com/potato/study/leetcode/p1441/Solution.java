package com.potato.study.leetcode.p1441;


import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 * 	1441. Build an Array With Stack Operations
 *  
 *
Given an array target and an integer n. In each iteration, you will read a number from  list = {1,2,3..., n}.

Build the target array using the following operations:

Push: Read a new element from the beginning list, and push it in the array.
Pop: delete the last element of the array.
If the target array is already built, stop reading more elements.
You are guaranteed that the target array is strictly increasing, only containing numbers between 1 to n inclusive.

Return the operations to build the target array.

You are guaranteed that the answer is unique.



Example 1:

Input: target = [1,3], n = 3
Output: ["Push","Push","Pop","Push"]
Explanation:
Read number 1 and automatically push in the array -> [1]
Read number 2 and automatically push in the array then Pop it -> [1]
Read number 3 and automatically push in the array -> [1,3]
Example 2:

Input: target = [1,2,3], n = 3
Output: ["Push","Push","Push"]
Example 3:

Input: target = [1,2], n = 4
Output: ["Push","Push"]
Explanation: You only need to read the first 2 numbers and stop.
Example 4:

Input: target = [2,3,4], n = 4
Output: ["Push","Pop","Push","Push","Push"]


Constraints:

1 <= target.length <= 100
1 <= target[i] <= 100
1 <= n <= 100
target is strictly increasing.
 *         
 *
 *
 *
 *  思路：
 *      https://leetcode-cn.com/problems/build-an-array-with-stack-operations/solution/dan-ci-xun-huan-bian-li-jie-jue-fang-an-by-murong-/
 *
 *
 *
 *
 */
public class Solution {


    /**
     * 遍历 i- n 比较 i target[j] 如果i 小 说明 ipush pop了 相等 说明push
     * @param target
     * @param n
     * @return
     */
    public List<String> buildArray(int[] target, int n) {
        int index = 0;
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i < target[index]) {
                res.add("Push");
                res.add("Pop");
            } else {
                res.add("Push");
                index++;
                if (index == target.length) {
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] target = new int[]{1,3};
        int n = 3;
        List<String> res = solution.buildArray(target, n);
        System.out.println(res); // "Push","Push","Pop","Push"

    }
}
