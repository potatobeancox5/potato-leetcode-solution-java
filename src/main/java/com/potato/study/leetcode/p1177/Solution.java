package com.potato.study.leetcode.p1177;


import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 * 	1177. Can Make Palindrome from Substring
 *  
 *
Given a string s, we make queries on substrings of s.

For each query queries[i] = [left, right, k], we may rearrange the substring s[left], ..., s[right], and then choose up to k of them to replace with any lowercase English letter.

If the substring is possible to be a palindrome string after the operations above, the result of the query is true. Otherwise, the result is false.

Return an array answer[], where answer[i] is the result of the i-th query queries[i].

Note that: Each letter is counted individually for replacement so if for example s[left..right] = "aaa", and k = 2, we can only replace two of the letters.  (Also, note that the initial string s is never modified by any query.)



Example :

Input: s = "abcda", queries = [[3,3,0],[1,2,0],[0,3,1],[0,3,2],[0,4,1]]
Output: [true,false,false,true,true]
Explanation:
queries[0] : substring = "d", is palidrome.
queries[1] : substring = "bc", is not palidrome.
queries[2] : substring = "abcd", is not palidrome after replacing only 1 character.
queries[3] : substring = "abcd", could be changed to "abba" which is palidrome. Also this can be changed to "baab" first rearrange it "bacd" then replace "cd" with "ab".
queries[4] : substring = "abcda", could be changed to "abcba" which is palidrome.


Constraints:

1 <= s.length, queries.length <= 10^5
0 <= queries[i][0] <= queries[i][1] < s.length
0 <= queries[i][2] <= s.length
s only contains lowercase English letters.
 *         
 *         思路：
 *
 *          https://leetcode-cn.com/problems/can-make-palindrome-from-substring/solution/2jin-zhi-biao-shi-zi-mu-shu-liang-qi-ou-xing-by-yi/
 *          因为可以任意重排，那么我们只需要求出奇数的个数 c ，因为偶数必定能够构成回文串，即左右各一个即可
 *
 */
public class Solution {

    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> result = new ArrayList<>();
        int cur = 0;
        // 标记数组
        int[] states = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            cur ^= (1 << (s.charAt(i) - 'a'));
            states[i] = cur;
        }
        // 遍历 查询数组
        for (int i = 0; i < queries.length; i++) {
            int ostate = queries[i][0] > 0 ? states[queries[i][0] - 1] : 0;
            int state = ostate ^ states[queries[i][1]];
            int cnt = 0;
            while (state != 0) {
                if ((state & 1) == 1) {
                    cnt++;
                }
                state >>= 1;
            }
            result.add(cnt / 2 <= queries[i][2]);
        }
        return result;
    }
	
	public static void main(String[] args) {
//		Solution solution = new Solution();
    }
}
