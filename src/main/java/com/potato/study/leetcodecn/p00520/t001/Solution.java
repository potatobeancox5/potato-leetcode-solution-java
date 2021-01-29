package com.potato.study.leetcodecn.p00520.t001;


import org.junit.Assert;

/**
 * 520. 检测大写字母
 *
 * 给定一个单词，你需要判断单词的大写使用是否正确。

 我们定义，在以下情况时，单词的大写用法是正确的：

 全部字母都是大写，比如"USA"。
 单词中所有字母都不是大写，比如"leetcode"。
 如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。
 否则，我们定义这个单词没有正确使用大写字母。

 示例 1:

 输入: "USA"
 输出: True
 示例 2:

 输入: "FlaG"
 输出: False
 注意: 输入是由大写和小写拉丁字母组成的非空单词。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/detect-capital
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     *
     * @param word
     * @return
     */
    public boolean detectCapitalUse(String word) {
        if (null == word || word.length() < 2) {
            return true;
        }
        // 根据前2个字母 先判断可能的类型
        char firstCap = word.charAt(0);
        char secondCap = word.charAt(1);
        boolean allLower = false;
        boolean firstUpper = false;
        boolean allUpper = false;
        if (Character.isLowerCase(firstCap)) {
            allLower = true;
            if (Character.isUpperCase(secondCap)) {
                return false;
            }
        } else if (Character.isUpperCase(firstCap) && Character.isLowerCase(secondCap)) {
            firstUpper = true;
        } else {
            allUpper = true;
        }
        for (int i = 2; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (allLower && Character.isUpperCase(ch)) {
                return false;
            }
            if (firstUpper && Character.isUpperCase(ch)) {
                return false;
            }
            if (allUpper && Character.isLowerCase(ch)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String word = "USA";
        boolean res = solution.detectCapitalUse(word);
        System.out.println(res);
        Assert.assertEquals(true, res);

        word = "FlaG";
        res = solution.detectCapitalUse(word);
        System.out.println(res);
        Assert.assertEquals(false, res);


        word = "mL";
        res = solution.detectCapitalUse(word);
        System.out.println(res);
        Assert.assertEquals(false, res);

    }

}
