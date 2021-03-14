package com.potato.study.leetcodecn.p00179.t001;

import org.junit.Assert;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 179. 最大数
 *
 * 给定一组非负整数 nums，重新排列它们每个数字的顺序（每个数字不可拆分）使之组成一个最大的整数。

 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。

  

 示例 1：

 输入：nums = [10,2]
 输出："210"
 示例 2：

 输入：nums = [3,30,34,5,9]
 输出："9534330"
 示例 3：

 输入：nums = [1]
 输出："1"
 示例 4：

 输入：nums = [10]
 输出："10"
  

 提示：

 1 <= nums.length <= 100
 0 <= nums[i] <= 109

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/largest-number
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    /**
     * 排序 按照 第一个数字的大小排序，倒序，然后 按照第二位置，如果第二位为空 可以认为第二位等同于第一位置
     * @param nums
     * @return
     */
    public String largestNumber(int[] nums) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String numStr1 = String.valueOf(o1);
                String numStr2 = String.valueOf(o2);
                // 位数相同
                if (numStr1.length() == numStr2.length()) {
                    // 按照首位 往后 各个位置比较
                    return compareStr(numStr2, numStr1);
                }
                // 位数不相同 拼接到一起比较
                String str1 = numStr1 + numStr2;
                String str2 = numStr2 + numStr1;
                return compareStr(str2, str1);
            }

            /**
             * 比较两个字符串 str1 放在前边返回-1
             * @param str1
             * @param str2
             * @return
             */
            private int compareStr(String str1, String str2) {
                for (int i = 0; i < str1.length(); i++) {
                    if (str1.charAt(i) < str2.charAt(i)) {
                        return -1;
                    } else if (str1.charAt(i) > str2.charAt(i)) {
                        return 1;
                    } else {
                        // same
                        continue;
                    }
                }
                return 0;
            }
        });
        for (int num : nums) {
            priorityQueue.add(num);
        }
        StringBuilder builder = new StringBuilder();
        while (!priorityQueue.isEmpty()) {
            builder.append(priorityQueue.poll());
        }
        // 去掉先导0
        int index = 0;
        while (index < builder.length() && builder.charAt(index) == '0') {
            index++;
        }
        if (index == builder.length()) {
            return "0";
        }
        if (index > 0) {
            return builder.substring(index);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] n = new int[] {10,2};
        String num = solution.largestNumber(n);
        System.out.println(num);
        Assert.assertEquals("210", num);

        n = new int[] {3,30,34,5,9};
        num = solution.largestNumber(n);
        System.out.println(num);
        Assert.assertEquals("9534330", num);

        n = new int[] {0, 0};
        num = solution.largestNumber(n);
        System.out.println(num);
        Assert.assertEquals("0", num);
    }
}
