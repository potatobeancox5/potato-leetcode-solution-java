package com.potato.study.leetcode.p0541;

/**
 * 
 * @author liuzhao11
 * 
 *         541. Reverse String II
 * 
 *         Given a string and an integer k, you need to reverse the first k
 *         characters for every 2k characters counting from the start of the
 *         string. If there are less than k characters left, reverse all of
 *         them. If there are less than 2k but greater than or equal to k
 *         characters, then reverse the first k characters and left the other as
 *         original. Example: Input: s = "abcdefg", k = 2 Output: "bacdfeg"
 *         Restrictions: The string consists of lower English letters only.
 *         Length of the given string and k will in the range [1, 10000]
 * 
 * 
 *         思路： 交换前k 个 0- k-1 2k~ 3k-1 ... 
 *         // 计算需要正常交换几次 有n个k 需要交换 （n+1） / 2 次
 *          //余数r 若n为奇数 不动了 //若n为偶数 交换最后的r个数
 *          
 *          直接对0 - k-1 倒序遍历 使用StringBuilder 添加
 *       
 *          
 */
public class Solution {
	
	public String reverseStr(String s, int k) {
		if(null == s || s.length() <= 1 || k <= 1) {
			return s;
		}
        // 计算需要正常交换几次 有n个k 需要交换 （n+1） / 2 次
		int n = s.length() / k;
		int switchTime = (n + 1) / 2;
		//交换前n个k
		char[] arr = s.toCharArray();
		for(int i = 0 ; i < switchTime ; i++) {
//			2 * i * k ~ 2 * i * k + (k - 1);
			int prefix = 2 * i * k;
			for(int j = 0 ; j < k / 2 ; j++) {
				char tmp = arr[prefix + j];
				arr[prefix + j] = arr[prefix + k - 1 - j];
				arr[prefix + k - 1 - j] = tmp;
			}
		}
		// 余数r  若n为奇数 不动了 
		int r = s.length() % k;
		if(n % 2 == 0) {
			//若n为偶数 交换最后的r个数
			int prefix = n * k;
			for(int j = 0 ; j < r / 2 ; j++) {
				char tmp = arr[prefix + j];
				arr[prefix + j] = arr[prefix + r - 1 - j];
				arr[prefix + r - 1 - j] = tmp;
			}
		}
		return new String(arr);
    }
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		String newStr = solution.reverseStr("abcdefgh", 3);
		System.out.println(newStr);
	}
}
