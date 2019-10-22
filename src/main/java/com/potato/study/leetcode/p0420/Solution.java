package com.potato.study.leetcode.p0420;

/**
 * 
 * @author liuzhao11
 * 
 *         420. Strong Password Checker
 * 
 *         A password is considered strong if below conditions are all met:

It has at least 6 characters and at most 20 characters.
It must contain at least one lowercase letter, at least one uppercase letter, and at least one digit.
It must NOT contain three repeating characters in a row ("...aaa..." is weak, but "...aa...a..." is strong, assuming other conditions are met).
Write a function strongPasswordChecker(s), that takes a string s as input, and return the MINIMUM change required to make s a strong password. If s is already strong, return 0.

Insertion, deletion or replace of any one character are all considered as one change.
 * 
 * 
 *         思路：
 *         https://blog.csdn.net/sinat_17451213/article/details/53767238
 *
 *         1. 记录当前password 状态 是否有大小写 是否有数字
 *         2. 遍历password 记录当前 字符和pre字符是否相同，相同count++
 *              若连续次数超过3，则将其替换字母，使得其连续字母个数不超过3的操作数为 3 - 1 ，4  -1 ，5 -1 ，6 -2
 *
 *            遍历过程中判断是否有大小写 数字 计算连续超过3次的有多少 替换需要多少个数字 change，删除需要多少个数字 delete
 *
 *         3. exchangeForType 需要增加类型的操作数
 *            n 长度
 *              长度 大于20 需要进行删除
 *                  计算需要删除的字符 n - 20
 *                  之前获取了 需要删除的字符串
 *                  if(remain<=nums[0]){
                    ans-=remain;
                    }
                    else if((remain-nums[0])<=2*nums[1])
                    ans-=nums[0]+(remain-nums[0])/2;
                    else
                    ans-=nums[0]+nums[1]+(remain-nums[0]-nums[1]*2)/3;

                    return remain+Math.max(ans,lose);
 *
 *              长度 小于等于20 可能需要增加字符：（6-n） 可能需要替换字符 exchangeForType 种 与 change 中的最大值
 *
 *
 * 
 */
public class Solution {

    public int strongPasswordChecker(String s) {

        if (s.length() < 2) {
            return 6 - s.length();
        }

        // 记录目前有多少个字符需要进行操作
        int needToOprateCount = 0;
        // 记录是否满足有 大小写和 数字的条件
        boolean hasLower = false;
        boolean hasUpper = false;
        boolean hasNumber = false;
        // 记录连续字符串的个数 0 代表 连续 是3的被数的删除1个，余数为1的需要删除2个，余数为2的需要删除3个。
        int[] successiveCount = new int[3];
        // 连续数字的计数器
        int simpleSuccessiveCount = 1;
        // 使用空格标记第0个字符
        char preCh = ' ';
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (preCh == ch) {
                simpleSuccessiveCount++;
            } else {
                // 计算种类数
                if (Character.isDigit(ch)) {
                    hasNumber = true;
                } else if (Character.isLowerCase(ch)) {
                    hasLower = true;
                } else if (Character.isUpperCase(ch)) {
                    hasUpper = true;
                }

                // 出现了终端
                if (simpleSuccessiveCount >= 3) {
                    successiveCount[simpleSuccessiveCount % 3]++;
                    // 如果采用替换的方法需要进行的操作
                    needToOprateCount += simpleSuccessiveCount/3;
                }
                simpleSuccessiveCount = 1;
                preCh = ch;
            }
        }
        // deal with the last
        if (simpleSuccessiveCount >= 3) {
            successiveCount[simpleSuccessiveCount % 3]++;
            // 如果采用替换的方法需要进行的操作
            needToOprateCount += simpleSuccessiveCount/3;
        }
        // 需要通过增加字符或者更换字符 补全的字符种类书
        int needToAddType = (hasLower?0:1) + (hasUpper?0:1) +(hasNumber?0:1);

        if (s.length() > 20) {

            int moreNum = s.length() - 20;
            if (moreNum <= successiveCount[0]) {
                needToOprateCount -= moreNum;
            } else if((moreNum - successiveCount[0]) <= 2 * successiveCount[1]) {
                needToOprateCount -= successiveCount[0] + (moreNum - successiveCount[0])/2;
            } else {
                needToOprateCount -= successiveCount[0] + successiveCount[1] + (moreNum - successiveCount[0]- successiveCount[1]*2)/3;
            }
            return moreNum + Math.max(needToOprateCount,needToAddType);

        } else {
            // 所有的操作都是增加 即可 需要补全的字符数字 与 needToAddType
            return Math.max(Math.max(needToAddType, needToOprateCount), 6 - s.length());
        }
    }
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();

		String s = "aaa111";
        int count = solution.strongPasswordChecker(s);
        System.out.println(count);

    }
}
