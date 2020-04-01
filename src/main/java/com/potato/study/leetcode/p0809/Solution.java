package com.potato.study.leetcode.p0809;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	809. Expressive Words
 *  
 *         Sometimes people repeat letters to represent extra feeling, such as "hello" -> "heeellooo", "hi" -> "hiiii".  In these strings like "heeellooo", we have groups of adjacent letters that are all the same:  "h", "eee", "ll", "ooo".

For some given string S, a query word is stretchy if it can be made to be equal to S by any number of applications of the following extension operation: choose a group consisting of characters c, and add some number of characters c to the group so that the size of the group is 3 or more.

For example, starting with "hello", we could do an extension on the group "o" to get "hellooo", but we cannot get "helloo" since the group "oo" has size less than 3.  Also, we could do another extension like "ll" -> "lllll" to get "helllllooo".  If S = "helllllooo", then the query word "hello" would be stretchy because of these two extension operations: query = "hello" -> "hellooo" -> "helllllooo" = S.

Given a list of query words, return the number of words that are stretchy.



Example:
Input:
S = "heeellooo"
words = ["hello", "hi", "helo"]
Output: 1
Explanation:
We can extend "e" and "o" in the word "hello" to get "heeellooo".
We can't extend "helo" to get "heeellooo" because the group "ll" is not size 3 or more.


Notes:

0 <= len(S) <= 100.
0 <= len(words) <= 100.
0 <= len(words[i]) <= 100.
S and all words in words consist only of lowercase letters

 *         
 *         思路：
 *
 *         https://blog.csdn.net/tiefanhe/article/details/80166041
 *
 *
 * 
 */
public class Solution {

    public int expressiveWords(String s, String[] words) {

        // 遍历 words
        int count = 0;
        for (int t = 0; t < words.length; t++) {
            // word > s continue
            if (words[t].length() > s.length()) {
                continue;
            }
            int i = 0;
            int j = 0;
            // 比较 word 单词 i 和 s单词j 相等 i ++ j++
            while (j < s.length()) {
                // i 不到结尾 可以移动 到了 就不能移动了
                if (i < words[t].length() && words[t].charAt(i) == s.charAt(j)) {
                    i++;
                    j++;
                } else if (j > 0 && j + 1 < s.length() && s.charAt(j) == s.charAt(j-1) && s.charAt(j) == s.charAt(j+1)) {
                    // 不等 判断 下 s 的j和j-1 是不是相同 相同 比较 j+ 1 再相同 说明是感叹词 j+2;
                    j += 2;
                } else if (!(j > 1 && s.charAt(j) == s.charAt(j-1) && s.charAt(j-2) == s.charAt(j))) {
                    // 不等且，与之前的 j-1 j-2 有一个不同 说明不是感叹词 那么这个单词就不是感叹词了
                    break;
                } else {
                    j++;
                }
            }

            // ij 到达终点 说明 是其中的一个词
            if (i == words[t].length() && j == s.length()) {
                count++;
            }
        }
        return count;
    }

	public static void main(String[] args) {
		Solution solution = new Solution();

        String s = "heeellooo";
        String[] words = new String[]{"hello", "hi", "helo"};
        int result = solution.expressiveWords(s, words);
        System.out.println(result);
        Assert.assertEquals(1, result);


        s = "zzzzzyyyyy";
        words = new String[]{"zzyy","zy","zyy"};
        result = solution.expressiveWords(s, words);
        System.out.println(result);
        Assert.assertEquals(3, result);
    }
}
