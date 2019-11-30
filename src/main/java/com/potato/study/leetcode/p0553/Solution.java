package com.potato.study.leetcode.p0553;


import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 *        553. Optimal Division
 * 
 *         Given a list of positive integers, the adjacent integers will perform the float division. For example, [2,3,4] -> 2 / 3 / 4.

However, you can add any number of parenthesis at any position to change the priority of operations. You should find out how to add parenthesis to get the maximum result, and return the corresponding expression in string format. Your expression should NOT contain redundant parenthesis.

Example:
Input: [1000,100,10,2]
Output: "1000/(100/10/2)"
Explanation:
1000/(100/10/2) = 1000/((100/10)/2) = 200
However, the bold parenthesis in "1000/((100/10)/2)" are redundant,
since they don't influence the operation priority. So you should return "1000/(100/10/2)".

Other cases:
1000/(100/10)/2 = 50
1000/(100/(10/2)) = 50
1000/100/10/2 = 0.5
1000/100/(10/2) = 2
Note:

The length of the input array is [1, 10].
Elements in the given array will be in range [2, 1000].
There is only one optimal division for each test case.

 * 
 * 
 *         思路：
 *
 *         553. Optimal Division

入参数：int[] nums，每一个数字 可以表示成 nums0 / nums1/ nums2
可以在任何位置添加括号，计算算式最大值 能得到多少

https://blog.csdn.net/wyh476901857/article/details/70194941

A / b / c / d 可以转换成 （通过添加括号） a * c * d / b 也就是说 除了第二个 其他的都求乘积


 *
 */
public class Solution {

    public String optimalDivision(int[] nums) {


        if (nums.length == 1) {
            return String.valueOf(nums[0]);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(nums[0]);
        if (nums.length == 2) {
            sb.append('/').append(nums[1]);
            return sb.toString();
        }

        sb.append('/').append("(");
        for (int i = 1; i < nums.length; i++) {
            sb.append(nums[i]);
            if (i != nums.length - 1) {
                sb.append("/");
            }
        }
        sb.append(")");
        return sb.toString();
    }


	
	
	public static void main(String[] args) {
		Solution solution = new Solution();

        int[] nums = {1000,100,10,2};

        String result = solution.optimalDivision(nums);
        System.out.println(result);
        Assert.assertEquals("1000/(100/10/2)", result);

    }
}
