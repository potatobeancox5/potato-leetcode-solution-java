package com.potato.study.leetcode.p0810;


import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	810. Chalkboard XOR Game
 *  
 *         We are given non-negative integers nums[i] which are written on a chalkboard.  Alice and Bob take turns erasing exactly one number from the chalkboard, with Alice starting first.  If erasing a number causes the bitwise XOR of all the elements of the chalkboard to become 0, then that player loses.  (Also, we'll say the bitwise XOR of one element is that element itself, and the bitwise XOR of no elements is 0.)

Also, if any player starts their turn with the bitwise XOR of all the elements of the chalkboard equal to 0, then that player wins.

Return True if and only if Alice wins the game, assuming both players play optimally.

Example:
Input: nums = [1, 1, 2]
Output: false
Explanation:
Alice has two choices: erase 1 or erase 2.
If she erases 1, the nums array becomes [1, 2]. The bitwise XOR of all the elements of the chalkboard is 1 XOR 2 = 3. Now Bob can remove any element he wants, because Alice will be the one to erase the last element and she will lose.
If Alice erases 2 first, now nums becomes [1, 1]. The bitwise XOR of all the elements of the chalkboard is 1 XOR 1 = 0. Alice will lose.

Notes:

1 <= N <= 1000.
0 <= nums[i] <= 2^16.
 *         
 *         思路：
 *
 *         https://blog.csdn.net/laputafallen/article/details/79777254
 *
 *         1.所有元素异或不为0.由于两个选手走法都是最优的，因此它们不会移除使剩下元素异或为0的元素，所以当元素个数
            为偶数时，alice总可以移除元素
            为奇数时，bob总可以移除元素
            2.所有元素异或为0.alice直接胜利
 *
 * 
 */
public class Solution {

    public boolean xorGame(int[] nums) {
        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            res ^= nums[i];
        }

        if (res == 0) {
            return true;
        }

        if (nums.length % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

	public static void main(String[] args) {
		Solution solution = new Solution();
        int[] nums = new int[]{1, 1, 2};
        boolean res = solution.xorGame(nums);
        System.out.println(res);
        Assert.assertEquals(false, res);
    }
}
