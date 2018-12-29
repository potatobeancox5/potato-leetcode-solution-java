package com.potato.study.leetcode.p0278;

/**
 * 
 * @author liuzhao11
 * 
 *
278. First Bad Version
You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.

Example:

Given n = 5, and version = 4 is the first bad version.

call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true

Then 4 is the first bad version.
        题目含义：
            给一个数字n 找到第一个不好的数字

* 		思路：
 * 	        二分法查找
 *
 *
* 
 */
public class Solution extends VersionControl {

    public Solution(int bad) {
        super(bad);
    }


    public int firstBadVersion(int n) {
        int left = 0;
        int right = n;
        while (left < right) {
//            int mid = (left + right) / 2; // 会溢出
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                if (right == mid) {
                    return mid;
                }
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
	
	
    public static void main(String[] args) {
        Solution solution = new Solution(1702766719);
        int n = 2126753390;
//        1702766719
        int result = solution.firstBadVersion(n);
        System.out.println("result: " + result);
    }
}

class VersionControl { //

    private int bad;

    public VersionControl () {
    }

    public VersionControl(int bad) {
        this.bad = bad;
    }

    public boolean isBadVersion(int version) {
        return version >= bad;
    }
}