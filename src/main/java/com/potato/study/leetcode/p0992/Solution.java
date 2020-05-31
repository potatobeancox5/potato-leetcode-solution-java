package com.potato.study.leetcode.p0992;


import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author liuzhao11
 * 
 * 	  991. Broken Calculator
 *  
 *         On a broken calculator that has a number showing on its display, we can perform two operations:

Double: Multiply the number on the display by 2, or;
Decrement: Subtract 1 from the number on the display.
Initially, the calculator is displaying the number X.

Return the minimum number of operations needed to display the number Y.



Example 1:

Input: X = 2, Y = 3
Output: 2
Explanation: Use double operation and then decrement operation {2 -> 4 -> 3}.
Example 2:

Input: X = 5, Y = 8
Output: 2
Explanation: Use decrement and then double {5 -> 4 -> 8}.
Example 3:

Input: X = 3, Y = 10
Output: 3
Explanation:  Use double, decrement and double {3 -> 6 -> 5 -> 10}.
Example 4:

Input: X = 1024, Y = 1
Output: 1023
Explanation: Use decrement operations 1023 times.


Note:

1 <= X <= 10^9
1 <= Y <= 10^9
 *         
 *         思路：
 *              https://leetcode-cn.com/problems/subarrays-with-k-different-integers/solution/k-ge-bu-tong-zheng-shu-de-zi-shu-zu-by-leetcode/
 *
 */
public class Solution {

    public int subarraysWithKDistinct(int[] arr, int kk) {
        Window window1 = new Window();
        Window window2 = new Window();
        int ans = 0, left1 = 0, left2 = 0;

        for (int right = 0; right < arr.length; ++right) {
            int x = arr[right];
            window1.add(x);
            window2.add(x);

            while (window1.different() > kk) {
                window1.remove(arr[left1++]);
            }
            while (window2.different() >= kk) {
                window2.remove(arr[left2++]);
            }
            ans += left2 - left1;
        }
        return ans;
    }
    class Window {
        private Map<Integer, Integer> count;
        private int nonzero;

        public Window() {
            count = new HashMap<>();
            nonzero = 0;
        }

        public void add(int x) {
            count.put(x, count.getOrDefault(x, 0) + 1);
            if (count.get(x) == 1) {
                nonzero++;
            }
        }

        public void remove(int x) {
            count.put(x, count.get(x) - 1);
            if (count.get(x) == 0) {
                nonzero--;
            }
        }

        public int different() {
            return nonzero;
        }
    }

}
