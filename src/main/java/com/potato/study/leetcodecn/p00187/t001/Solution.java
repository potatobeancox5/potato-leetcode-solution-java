package com.potato.study.leetcodecn.p00187.t001;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 187. 重复的DNA序列
 *
 * 所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，例如："ACGAATTCCG"。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。

 编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。

  

 示例 1：

 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 输出：["AAAAACCCCC","CCCCCAAAAA"]
 示例 2：

 输入：s = "AAAAAAAAAAAAA"
 输出：["AAAAAAAAAA"]
  

 提示：

 0 <= s.length <= 105
 s[i] 为 'A'、'C'、'G' 或 'T'

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/repeated-dna-sequences
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 遍历 从 0 - s.len - 10 开始遍历，没十个字段串放到set中，
     * 出现超过一次的记录到set中
     * 最后 通过一个list 存储
     * @param s
     * @return
     */
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> subSet = new HashSet<>();
        Set<String> resultSet = new HashSet<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String sub = s.substring(i, i + 10);
            // 不是第一次出现 可以作为返回了
            if (subSet.contains(sub)) {
                resultSet.add(sub);
                continue;
            }
            // 第一次数显记录下来
            subSet.add(sub);
        }
        List<String> result = new ArrayList<>(resultSet);
        return result;
    }

    public static void main(String[] args) {

    }
}
