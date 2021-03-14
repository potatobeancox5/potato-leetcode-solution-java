package com.potato.study.leetcodecn.p00068.t001;


import com.google.common.collect.Lists;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * 68. 文本左右对齐
 *
 * 给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。

 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。

 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。

 文本的最后一行应为左对齐，且单词之间不插入额外的空格。

 说明:

 单词是指由非空格字符组成的字符序列。
 每个单词的长度大于 0，小于等于 maxWidth。
 输入单词数组 words 至少包含一个单词。
 示例:

 输入:
 words = ["This", "is", "an", "example", "of", "text", "justification."]
 maxWidth = 16
 输出:
 [
    "This    is    an",
    "example  of text",
    "justification.  "
 ]
 示例 2:

 输入:
 words = ["What","must","be","acknowledgment","shall","be"]
 maxWidth = 16
 输出:
 [
   "What   must   be",
   "acknowledgment  ",
   "shall be        "
 ]
 解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
      因为最后一行应为左对齐，而不是左右两端对齐。
 第二行同样为左对齐，这是因为这行只包含一个单词。
 示例 3:

 输入:
 words = ["Science","is","what","we","understand","well","enough","to","explain",
          "to","a","computer.","Art","is","everything","else","we","do"]
 maxWidth = 20
 输出:
 [
   "Science  is  what we",
 "understand      well",
   "enough to explain to",
   "a  computer.  Art is",
   "everything  else  we",
   "do                  "
 ]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/text-justification
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 先组成一个二维列表，然后拼装
     * @param words
     * @param maxWidth
     * @return
     */
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<List<String>> result = new ArrayList<>();
        // 当前每行的长度
        List<Integer> lineLen = new ArrayList<>();
        // 遍历单词 将同一行的单词 放在一起 需要计算一个空格的间隔
        for (String word : words) {
            if (result.size() == 0) {
                // 如果当前 result 空的话 直接 new 一个队并放进去
                List<String> list = new ArrayList<>();
                list.add(word);
                lineLen.add(word.length());
                result.add(list);
            } else {
                // 不是第一行 判断当前最后一个 list 是否可以装下 word
                List<String> list = result.get(result.size() - 1);
                Integer len = lineLen.get(result.size() - 1);
                if (len + 1 + word.length() <= maxWidth) {
                    // 可以装下 直接装
                    list.add(word);
                    // 加一个空格
                    len += (1 + word.length());
                    lineLen.set(result.size() - 1, len);
                } else {
                    // 不能就另起一个 新的list 装
                    List<String> newlist = new ArrayList<>();
                    newlist.add(word);
                    lineLen.add(word.length());
                    result.add(newlist);
                }
            }
        }
        // 调整 result
        List<String> lineStr = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            // 最后一行直接拼
            if (i == result.size() - 1) {
                StringBuilder builder = new StringBuilder();
                List<String> list = result.get(i);
                for (String word : list) {
                    builder.append(word);
                    if (builder.length() < maxWidth) {
                        builder.append(" ");
                    }
                }
                // 往最后补充空格
                builder.append(getBlank(maxWidth - builder.length()));
                lineStr.add(builder.toString());
                continue;
            }
            int len = lineLen.get(i);
            // 计算还需要加多少个空格
            int blankNum = maxWidth - len;
            // 计算 每个空间还要加多少个空格
            List<String> list = result.get(i);
            int eachBlankNum = blankNum;
            int needAddOneBlankNum = 0;
            if (list.size() > 1) {
                needAddOneBlankNum = blankNum % (list.size() - 1);
                eachBlankNum = blankNum / (list.size() - 1);
            }
            StringBuilder builder = new StringBuilder();
            for (String word : list) {
                if (builder.length() == 0) {
                    builder.append(word);
                } else {
                    // 先加空格 再加单词
                    int thisBlankNum = eachBlankNum;
                    if (needAddOneBlankNum > 0) {
                        thisBlankNum += 1;
                        needAddOneBlankNum -= 1;
                    }
                    // + 1 是因为之前已经算了2个单词之前的空格了
                    if (blankNum >= thisBlankNum) {
                        builder.append(getBlank(thisBlankNum + 1));
                        blankNum -= thisBlankNum;
                    } else {
                        builder.append(getBlank(blankNum + 1));
                        blankNum = 0;
                    }
                    builder.append(word);
                }
            }
            // 只有一个单词的处理
            if (list.size() == 1) {
                builder.append(getBlank(maxWidth - builder.length()));
            }
            lineStr.add(builder.toString());
        }
        return lineStr;
    }


    /**
     * 生成 指定 个数的空格
     * @param num
     * @return
     */
    private String getBlank (int num) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < num; i++) {
            builder.append(" ");
        }
        return builder.toString();
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] words = new String[]{
                "This", "is", "an", "example", "of", "text", "justification.","newwwjksjkf"
        };
        int maxWidth = 16;
        List<String> list = solution.fullJustify(words, maxWidth);
        System.out.println(list);


        maxWidth = 25;
        words = new String[]{
                "so","fine","That","all","the","newwwjksjkf"
        };
        list = solution.fullJustify(words, maxWidth);
        System.out.println(list);
        Assert.assertEquals(Lists.newArrayList("so   fine  That  all  the","newwwjksjkf              "), list);
    }
    // ["Give  me  my  Romeo; and,","when  he  shall die, Take","him  and  cut  him out in","little stars, And he will","make  the  face of heaven","so   fine   That  all the","world  will  be  in  love","with  night  And  pay  no","worship   to   the garish","sun.                     "]
    // ["Give  me  my  Romeo; and,","when  he  shall die, Take","him  and  cut  him out in","little stars, And he will","make  the  face of heaven","so   fine  That  all  the","world  will  be  in  love","with  night  And  pay  no","worship   to  the  garish","sun.                     "]
}
