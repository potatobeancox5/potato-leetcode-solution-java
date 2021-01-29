package com.potato.study.leetcodecn.p00551.t001;


/**
 * 551. 学生出勤记录 I
 *
 * 给定一个字符串来代表一个学生的出勤记录，这个记录仅包含以下三个字符：

 'A' : Absent，缺勤
 'L' : Late，迟到
 'P' : Present，到场
 如果一个学生的出勤记录中不超过一个'A'(缺勤)并且不超过两个连续的'L'(迟到),那么这个学生会被奖赏。

 你需要根据这个学生的出勤记录判断他是否会被奖赏。

 示例 1:

 输入: "PPALLP"
 输出: True
 示例 2:

 输入: "PPALLL"
 输出: False

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/student-attendance-record-i
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     *
     * @param s
     * @return
     */
    public boolean checkRecord(String s) {
        if (null == s || s.length() == 0) {
            return true;
        }
        char[] charArray = s.toCharArray();
        int count = 0;
        int successiveLateCount = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == 'A') {
                count++;
            } else if (charArray[i] == 'L') {
                if (i != 0 && charArray[i-1] == 'L') {
                    successiveLateCount++;
                } else {
                    successiveLateCount = 1;
                }
            }
            if (count > 1) {
                return false;
            }
            if (successiveLateCount > 2) {
                return false;
            }
        }
        return true;
    }

//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        String s = solution.reverseWords("Let's take LeetCode contest");
//        System.out.println(s);
//        Assert.assertEquals("s'teL ekat edoCteeL tsetnoc", s);
//    }

}
