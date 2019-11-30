package com.potato.study.leetcode.p0556;


import org.junit.Assert;

import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 *        556. Next Greater Element III
 * 
 *         Given a positive 32-bit integer n, you need to find the smallest 32-bit integer which has exactly the same digits existing in the integer n and is greater in value than n. If no such positive 32-bit integer exists, you need to return -1.

Example 1:

Input: 12
Output: 21


Example 2:

Input: 21
Output: -1*
 * 
 *         思路：
 *
 *         556. Next Greater Element III


给一个数字 n，找到 最小的，比n大的 数字，其中每个位置的数字都与b相同

134256876
13425768

从个位依次往前找数字，出现当前数字比之前的数字最大值小的时候，获取比最小的 比cur大的数字，其他数字进行排序（升序排序），


每个位置都是用 0-9 的数字计数器进行计数

tmp = n
while tmp > 0
cur = tmp % 10
Tmp /= 10
count[cur] ++
flag = false // 标记是否比他大
firstNum = -1；
for i cur + 1 , 9
if count I 》 0
flag = true
firstNum = I；
beadk
if flag
瓶装tmp的尾数
 *
 *
 *https://blog.csdn.net/fuxuemingzhu/article/details/82113731
 *
 *https://leetcode.com/problems/next-greater-element-iii/discuss/101824/Simple-Java-solution-(4ms)-with-explanation.%E4%BD%9C%E8%80%85%EF%BC%9A%E4%BA%91%E7%AB%AF%E6%BC%AB%E6%AD%A5_b5aa%E9%93%BE%E6%8E%A5%EF%BC%9Ahttps://www.jianshu.com/p/9527e6edd1c1%E6%9D%A5%E6%BA%90%EF%BC%9A%E7%AE%80%E4%B9%A6%E8%91%97%E4%BD%9C%E6%9D%83%E5%BD%92%E4%BD%9C%E8%80%85%E6%89%80%E6%9C%89%E3%80%82%E5%95%86%E4%B8%9A%E8%BD%AC%E8%BD%BD%E8%AF%B7%E8%81%94%E7%B3%BB%E4%BD%9C%E8%80%85%E8%8E%B7%E5%BE%97%E6%8E%88%E6%9D%83%EF%BC%8C%E9%9D%9E%E5%95%86%E4%B8%9A%E8%BD%AC%E8%BD%BD%E8%AF%B7%E6%B3%A8%E6%98%8E%E5%87%BA%E5%A4%84%E3%80%82
 */
public class Solution {

    public int nextGreaterElement(int n) {
        String s = String.valueOf(n);
        int i;
        for (i = s.length() - 2; i >= 0; i--) {
            if (s.charAt(i) < s.charAt(i+1)) {
                break;
            }
        }
        if (i < 0) {
            return -1;
        }
        // i 就是要替换的位置 找到 i之后大于i中最小的数字
        int minMaxIndex = -1;
        for (int j = i+1; j < s.length(); j++) {
            if (s.charAt(j) > s.charAt(i) && (minMaxIndex == -1 || s.charAt(j) < s.charAt(minMaxIndex))) {
                minMaxIndex = j;
            }
        }
        // 替换 i 和 minMax  对其他字符进行重新排序
        char[] charArray = s.toCharArray();
        char tmp = charArray[i];
        charArray[i] = charArray[minMaxIndex];
        charArray[minMaxIndex] = tmp;

        Arrays.sort(charArray, i+1, charArray.length);

        String numStr = new String(charArray);

        try {
            int res = Integer.parseInt(numStr);
            return res;
        } catch (Exception e) {
        }
        return -1;
    }


	
	
	public static void main(String[] args) {
		Solution solution = new Solution();

		int n = 12;
        int result = solution.nextGreaterElement(n);
        System.out.println(result);
        Assert.assertEquals(21, result);

        n = 21;
        result = solution.nextGreaterElement(n);
        System.out.println(result);
        Assert.assertEquals(-1, result);


        n = 1999999999;
        result = solution.nextGreaterElement(n);
        System.out.println(result);
        Assert.assertEquals(-1, result);

    }
}
