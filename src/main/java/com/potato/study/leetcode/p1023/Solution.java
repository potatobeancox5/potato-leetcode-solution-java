package com.potato.study.leetcode.p1023;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * 
 * @author liuzhao11
 * 
 * 	1023. Camelcase Matching
 *  
 *         A query word matches a given pattern if we can insert lowercase letters to the pattern word so that it equals the query. (We may insert each character at any position, and may insert 0 characters.)

Given a list of queries, and a pattern, return an answer list of booleans, where answer[i] is true if and only if queries[i] matches the pattern.



Example 1:

Input: queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FB"
Output: [true,false,true,true,false]
Explanation:
"FooBar" can be generated like this "F" + "oo" + "B" + "ar".
"FootBall" can be generated like this "F" + "oot" + "B" + "all".
"FrameBuffer" can be generated like this "F" + "rame" + "B" + "uffer".
Example 2:

Input: queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBa"
Output: [true,false,true,false,false]
Explanation:
"FooBar" can be generated like this "Fo" + "o" + "Ba" + "r".
"FootBall" can be generated like this "Fo" + "ot" + "Ba" + "ll".
Example 3:

Input: queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBaT"
Output: [false,true,false,false,false]
Explanation:
"FooBarTest" can be generated like this "Fo" + "o" + "Ba" + "r" + "T" + "est".


Note:

1 <= queries.length <= 100
1 <= queries[i].length <= 100
1 <= pattern.length <= 100
All strings consists only of lower and upper case English letters.
 *         
 *         思路：
 *
 *      https://leetcode-cn.com/problems/camelcase-matching/solution/java-zheng-ze-bao-li-po-jie-by-kenzhaoyihui/
 *
 */
public class Solution {

    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> list = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        for (int i=0; i<pattern.length(); i++) {
            str.append(String.valueOf(pattern.charAt(i)));
            str.append("[a-z]*");
        }
        String regex = "[a-z]*" + str.toString() + "$";


        for (int i=0; i<queries.length;i++) {
            Pattern pattern1 = Pattern.compile(regex);
            list.add(pattern1.matcher(queries[i]).lookingAt());
        }
        return list;
    }
}
