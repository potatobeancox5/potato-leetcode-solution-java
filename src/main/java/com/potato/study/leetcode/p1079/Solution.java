package com.potato.study.leetcode.p1079;


/**
 * 
 * @author liuzhao11
 * 
 * 	1079. Letter Tile Possibilities
 *  
 *       You have a set of tiles, where each tile has one letter tiles[i] printed on it.  Return the number of possible non-empty sequences of letters you can make.



Example 1:

Input: "AAB"
Output: 8
Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".
Example 2:

Input: "AAABBC"
Output: 188


Note:

1 <= tiles.length <= 7
tiles consists of uppercase English letters.
 *         
 *
 *
 *
 *         思路：
 *          先统计个数
 *          dfs 遍历统计数组 每次选择一个字符
 *          然后 递归遍历
 *          加回来之前减去的那个计数
 *
 *          https://www.cnblogs.com/hwd9654/p/11008562.html
 *
 */
public class Solution {

    public int numTilePossibilities(String tiles) {
        if (null == tiles || "".equals(tiles)) {
            return 0;
        }
        // 统计出现的次数 都是大写字母
        int[] counts = new int[26];
        for (char ch : tiles.toCharArray()) {
            counts[ch - 'A']++;
        }
        // 递归统计次数
        return dfs(counts);
    }


    private int dfs(int[] counts) {
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            if (counts[i] == 0) {
                continue;
            }
            sum++;
            counts[i]--;
            sum += dfs(counts);
            counts[i]++;
        }
        return sum;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
//        String tiles = "AAB";
        String tiles = "AAABBC";
        int num = solution.numTilePossibilities(tiles);
        System.out.println(num);
    }
}
