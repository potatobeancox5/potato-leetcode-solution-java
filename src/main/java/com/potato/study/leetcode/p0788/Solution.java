package com.potato.study.leetcode.p0788;

/**
 * 
 * @author liuzhao11
 * 
 * 	788. Rotated Digits
 *  
 *        X is a good number if after rotating each digit individually by 180 degrees, we get a valid number that is different from X.  Each digit must be rotated - we cannot choose to leave it alone.

A number is valid if each digit remains a digit after rotation. 0, 1, and 8 rotate to themselves; 2 and 5 rotate to each other; 6 and 9 rotate to each other, and the rest of the numbers do not rotate to any other number and become invalid.

Now given a positive number N, how many numbers X from 1 to N are good?

Example:
Input: 10
Output: 4
Explanation:
There are four good numbers in the range [1, 10] : 2, 5, 6, 9.
Note that 1 and 10 are not good numbers, since they remain unchanged after rotating.
Note:

N  will be in range [1, 10000].

 *
 *
 *   解题思路：
 *   788. Rotated Digits

初步整理
3 4 7 只要存在就不行

1 8 0 单独存在也不行

https://www.jianshu.com/p/817978e687ea

for i n
isgood ciunt++


bool isgood n
isdoog =false
判断每个位置
if 2569
isgood true
if 3 4 7
break

retuen n《=0& isgood
 * 
 */
public class Solution {

    public int rotatedDigits(int n) {
        int goodCount = 0;
        for (int i = 1; i <= n; i++) {
            if (isGoodNum(i)) {
                goodCount++;
            }
        }
        return goodCount;
    }


    /**
     * 判断n 是否满足上述规则
     * @param num
     * @return
     */
    private boolean isGoodNum(int num) {
        if (num == 0) {
            return false;
        }
        boolean isGood = false;
        while(num > 0) {
            int k = num % 10;
            if (k == 2 || k == 5 || k == 6 || k == 9) {
                isGood = true;
            } else if (k == 3 || k == 4 || k == 7) {
                break;
            }
            num /= 10;
        }
        if (isGood && num == 0) {
            return true;
        }
        return false;
    }

	
	public static void main(String[] args) {
		Solution solution = new Solution();
        int n = 10;
        int toeplitzMatrix = solution.rotatedDigits(n);
        System.out.println(toeplitzMatrix);
    }
}
