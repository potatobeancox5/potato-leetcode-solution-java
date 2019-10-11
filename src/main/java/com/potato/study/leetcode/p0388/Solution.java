package com.potato.study.leetcode.p0388;

import org.junit.Assert;

import java.util.Stack;

/**
 * 
 * @author liuzhao11
 * 
 *       388. Longest Absolute File Path
 * 
 *      Suppose we abstract our file system by a string in the following manner:

The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:

dir
subdir1
subdir2
file.ext
The directory dir contains an empty sub-directory subdir1 and a sub-directory subdir2 containing a file file.ext.

The string "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" represents:

dir
subdir1
file1.ext
subsubdir1
subdir2
subsubdir2
file2.ext
The directory dir contains two sub-directories subdir1 and subdir2. subdir1 contains a file file1.ext and an empty second-level sub-directory subsubdir1. subdir2 contains a second-level sub-directory subsubdir2 containing a file file2.ext.

We are interested in finding the longest (number of characters) absolute path to a file within our file system. For example, in the second example above, the longest absolute path is "dir/subdir2/subsubdir2/file2.ext", and its length is 32 (not including the double quotes).

Given a string representing the file system in the above format, return the length of the longest absolute path to file in the abstracted file system. If there is no file in the system, return 0.

Note:
The name of a file contains at least a . and an extension.
The name of a directory or sub-directory will not contain a ..
Time complexity required: O(n) where n is the size of the input string.

Notice that a/aa/aaa/file1.txt is not the longest file path, if there is another path aaaaaaaaaaaaaaaaaaaaa/sth.png.
 *         
 *         思路：
 *         题目 含义 给一个字符串 找到其中路径最长的字符串的长度
 *         https://segmentfault.com/a/1190000016899082?utm_medium=referral&utm_source=tuicool
 *
 *         遍历input字符串 使用 stack记录之前目录的长度
 *         首先将字符串按照 \n split
 *          for str in split
 *              找到当前 str 中 \t的个数 n
 *              if 当前是文件
 *                  max 计算当前路径大小
 *              if n == stack个数 说明 当前文件在stack的同一级  将新路径push
 *              else if n < stack个数 需要一直stack pop到 小于n ，然后push当前路径进去
 *              else if n > stack 个数 异常情况
 *
 *          返回最长
 *
 *
 *         
 */
public class Solution {

    public int lengthLongestPath(String input) {
        if (null == input || "".equals(input)) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        String[] split = input.split("\n");
        int max = 0;
        for (String eachPath : split) {
            // 计算当前目录位于第几级
            int level = eachPath.lastIndexOf("\t") + 1;
            // 处理目录到合适的场景
            while (stack.size() > level + 1) {
                stack.pop();
            }
            int len = stack.peek() + eachPath.length() -level + 1;
            stack.push(len);
            if (eachPath.contains(".")) {
                max = Math.max(max, len - 1);
            }
        }
        return max;
    }


    public static void main(String[] args) {
		Solution solution = new Solution();
		String input = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
		int index = solution.lengthLongestPath(input);
		System.out.println(index);
        Assert.assertEquals(20, index);
    }
}

