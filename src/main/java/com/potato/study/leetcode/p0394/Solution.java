package com.potato.study.leetcode.p0394;

import org.junit.Assert;

import java.util.Stack;

/**
 * 
 * @author liuzhao11
 * 
 *       394. Decode String
 * 
 *     Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

Examples:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 *         
 *         思路：
 *         用一个stack 存 当前的数字
用一个stack 存 当前的字符串
StringBuilder sb
Int cnt 当前没有配置的【 个数
遍历 字符串s 当前字符 ch
if ch is num  或者 字母
sb.append ch
else if ch == [
num =  sb 生产当前数字 数字stack 进展
清空sb
cnt++
else if ch == ]
sb 缓存的当前字符串 字符串入栈 tmp
数字stack 出 个数
数字与 tmp组装 成串
// 清空sb
cnt—
if cnt 》 0
字符串stack pop 拿到父亲节点的str 与 tmp拼接 再入栈
 *
 * https://www.jianshu.com/p/36d70207f5f9
 *
 * 新思路
 * for e ch
 *  1. 如果是数字的话 直接从这个位置一直往后找，知道不是数字的位置，然后将数字如stack
 *  2. 如果是字母的话 直接将这个位置加入当前字母缓存 sb 中
 *  3. if 是 【  将之前的res如 stack 重置 sb
 *  4. if 是 】 从  stack 中取出父节点 （如果有的话），然后numStack pop 获取循环次数，拼接完， 使用res保存
 *
 *
 *         
 */
public class Solution {

    public String decodeString(String s) {
        Stack<Integer> timesStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int num = ch - '0';
                while (Character.isDigit(s.charAt(i + 1))) {
                    num *= 10;
                    num += (s.charAt(++i) - '0');
                }
                // insert to stack 空串也会进去的吧
                timesStack.push(num);
            } else if (Character.isAlphabetic(ch)) {
                result.append(ch);
            } else if ('[' == ch) {
                stringStack.push(result.toString());
                result = new StringBuilder();
            } else if (']' == ch) {
                StringBuilder tmp = new StringBuilder();
                tmp.append(stringStack.pop());
                int time = timesStack.pop();
                for (int j = 0; j < time; j++) {
                    tmp.append(result.toString());
                }
                result = tmp;
            }
        }
        return result.toString();
    }


//    public String decodeString(String s) {
//        if (null == s || s.length() == 0) {
//            return "";
//        }
////        用一个stack 存 当前的数字
//        Stack<Integer> timesStack = new Stack<>();
////        用一个stack 存 当前的字符串
//        Stack<String> stringStack = new Stack<>();
////        StringBuilder sb 缓存每次遍历到的字符串或者 数字
//        StringBuilder sb = new StringBuilder();
//        StringBuilder sbNum = new StringBuilder();
////        Int cnt 当前没有配置的【 个数
//        int cnt = 0;
////        遍历 字符串s 当前字符 ch
//        for (char ch : s.toCharArray()) {
//            // 数字和字母判断分开进行因为可能存在交叉
//            if (Character.isDigit(ch)) {
//                sbNum.append(ch);
//            } else if (Character.isAlphabetic(ch)) {
//                sb.append(ch);
//            } else if (ch == '[') {
////        num =  sb 生产当前数字 数字stack 进展
//                int time = Integer.parseInt(sb.toString());
//                timesStack.push(time);
////                清空sb
//                sb = new StringBuilder();
//                cnt++;
//
//            } else if (ch == ']') {
////        sb 缓存的当前字符串生成 tmp
//                String tmpStr = sb.toString();
//                if ("".equals(tmpStr)) {
//                    tmpStr = stringStack.pop();
//                }
////        数字stack 出 个数
//                String newString = "";
//                // 如果当前没有time就不需要pop
//                if (stringStack.size() <= timesStack.size()) {
//                    int time = timesStack.pop();
////        数字与 tmp组装 成串
//                    for (int i = 0; i < time; i++) {
//                        newString += tmpStr;
//                    }
//                } else {
//                    String fatherString = stringStack.pop();
//                    newString = fatherString + newString;
//                }
////        // 清空sb
//                sb = new StringBuilder();
////        cnt—
//                cnt--;
//                if (cnt > 0) {
////        字符串stack pop 拿到父亲节点的str 与 tmp拼接
//                    String fatherString = stringStack.pop();
//                    newString = fatherString + newString;
//                }
//                // 再入栈
//                stringStack.push(newString);
//            }
//        }
//        // 拼接栈中的字符串合集
//        StringBuilder result = new StringBuilder();
//        while (!stringStack.isEmpty()) {
//            String partString = stringStack.pop();
//            result.insert(0, partString);
//        }
//        // 最后一个字符串没有插入的情况
//        if (sb.length() > 0) {
//            result.append(sb);
//        }
//        return result.toString();
//    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
        String s = "3[a]2[bc]";
        String res = solution.decodeString(s);
		System.out.println(res);
        Assert.assertEquals("aaabcbc", res);

        s = "3[a2[c]]";
        res = solution.decodeString(s);
        System.out.println(res);
        Assert.assertEquals("accaccacc", res);

        s = "2[abc]3[cd]ef";
        res = solution.decodeString(s);
        System.out.println(res);
        Assert.assertEquals("abcabccdcdcdef", res);

        s = "3[a]2[b4[F]c]";
        res = solution.decodeString(s);
        System.out.println(res);
        Assert.assertEquals("aaabFFFFcbFFFFc", res);

        s = "100[leetcode]";
        res = solution.decodeString(s);
        System.out.println(res);
//        Assert.assertEquals("aaabFFFFcbFFFFc", res);
    }
}

