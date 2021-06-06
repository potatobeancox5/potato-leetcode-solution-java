package com.potato.study.leetcodecn.p01079.t001;

import java.util.Set;

/**
 * 1079. 活字印刷
 *
 * 你有一套活字字模 tiles，其中每个字模上都刻有一个字母 tiles[i]。返回你可以印出的非空字母序列的数目。
 *
 * 注意：本题中，每个活字字模只能使用一次。
 *
 *  
 *
 * 示例 1：
 *
 * 输入："AAB"
 * 输出：8
 * 解释：可能的序列为 "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA"。
 * 示例 2：
 *
 * 输入："AAABBC"
 * 输出：188
 *  
 *
 * 提示：
 *
 * 1 <= tiles.length <= 7
 * tiles 由大写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-tile-possibilities
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 其实是一种 全排列
     * https://leetcode-cn.com/problems/letter-tile-possibilities/solution/hui-su-suan-fa-python-dai-ma-by-liweiwei1419/
     *
     * 通过 这个题目 开始 搞一下回溯
     * 1. 将tile 计数 成一个 count 数组
     * 2. dfs 每次 从 count 中 找一个位置 -1，然后 递归往下 找 每次-1的时候 进行计数 因为 是一种选择了
     *  每次 -1的过程 就可以看成 这个位置的一种选择
     * 使用回溯
     * @param tiles
     * @return
     */
    public int numTilePossibilities(String tiles) {
        // 统计单词中 每个字母出现的次数
        int[] count = new int[26];
        // tiles 由大写英文字母组成
        for (char ch : tiles.toCharArray()) {
            count[ch - 'A']++;
        }
        // dfs 搞这个频次数组
        dfs(count);
        return this.allCount;
    }

    /**
     * 回溯解法
     * @param count
     */
    private void dfs(int[] count) {
        // 如果当前 数组没有任何一个 count 大于 1了，那就是 都搞完了
        int allCount = 0;
        for (int cc : count) {
            allCount += cc;
        }
        if (allCount == 0) {
            return;
        }
        for (int i = 0; i < 26; i++) {
            // 否则 从 a - z 开始遍历 每次选择一个 字母，然后 count -- ，减完之后 在找里边的其他可能
            if (count[i] == 0) {
                continue;
            }
            count[i]--;
            this.allCount++;
            dfs(count);
            // 本次减晚了 加回来
            count[i]++;
        }
    }

    private int allCount = 0;


}
