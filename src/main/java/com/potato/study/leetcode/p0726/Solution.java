package com.potato.study.leetcode.p0726;

import org.junit.Assert;

import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

/**
 * 
 * @author liuzhao11
 * 
 * 	726. Number of Atoms
 *  
 *         Given a chemical formula (given as a string), return the count of each atom.

An atomic element always starts with an uppercase character, then zero or more lowercase letters, representing the name.

1 or more digits representing the count of that element may follow if the count is greater than 1. If the count is 1, no digits will follow. For example, H2O and H2O2 are possible, but H1O2 is impossible.

Two formulas concatenated together produce another formula. For example, H2O2He3Mg4 is also a formula.

A formula placed in parentheses, and a count (optionally added) is also a formula. For example, (H2O2) and (H2O2)3 are formulas.

Given a formula, output the count of all elements as a string in the following form: the first name (in sorted order), followed by its count (if that count is more than 1), followed by the second name (in sorted order), followed by its count (if that count is more than 1), and so on.

Example 1:
Input:
formula = "H2O"
Output: "H2O"
Explanation:
The count of elements are {'H': 2, 'O': 1}.
Example 2:
Input:
formula = "Mg(OH)2"
Output: "H2MgO2"
Explanation:
The count of elements are {'H': 2, 'Mg': 1, 'O': 2}.
Example 3:
Input:
formula = "K4(ON(SO3)2)2"
Output: "K4N2O14S4"
Explanation:
The count of elements are {'K': 4, 'N': 2, 'O': 14, 'S': 4}.
Note:

All atom names consist of lowercase letters, except for the first character which is uppercase.
The length of formula will be in the range [1, 1000].
formula will only consist of letters, digits, and round parentheses, and is a valid formula as defined in the problem.
 *         
 *         思路：
 *
 *         https://www.jianshu.com/p/201e7aed7c05
 *
 * 
 */
public class Solution {

    public String countOfAtoms(String formula) {
        // stack 存储当前 key：元素 value：元素个数
        Stack<Map<String, Integer>> stack = new Stack<>();
        // 记录当前次数 缓存
        Map<String, Integer> curMap = new TreeMap<>();
        // 遍历表达式
        int index = 0;
        while (index < formula.length()) {
            char ch = formula.charAt(index);
            if (ch == '(') {
                stack.push(curMap);
                // 新建一个 curmap
                curMap = new TreeMap<>();
                index++;
            } else if (ch == ')') {
                // merge the map
                Map<String, Integer> thisCurrentMap = curMap;
                curMap = stack.pop();
                index++;
                // 获取 ）之后的数字
                int numStart = index;
                while (index < formula.length() && Character.isDigit(formula.charAt(index))) {
                    index++;
                }
                int num = 1;
                if (numStart < index) {
                    num = Integer.parseInt(formula.substring(numStart, index));
                }
                // 对于 thisCurrentMap 进行复制
                for (String element : thisCurrentMap.keySet()) {
                    int curCount = thisCurrentMap.get(element) * num;
                    Integer alreadyCount = curMap.get(element);
                    if (null == alreadyCount) {
                        curMap.put(element, curCount);
                    } else {
                        curMap.put(element, curCount + alreadyCount);
                    }
                }

            } else {
                // 正常的数字和字母 找到 字母的结束
                int start = index;
                index++;
                while (index < formula.length() && Character.isLowerCase(formula.charAt(index))) {
                    index++;
                }
                // 截取元素
                String element = formula.substring(start, index);
                // get the num
                int numStart = index;
                int num = 1;
                while (index < formula.length() && Character.isDigit(formula.charAt(index))) {
                    index++;
                }
                if (numStart < index) {
                    num = Integer.parseInt(formula.substring(numStart, index));
                }
                curMap.put(element, curMap.getOrDefault(element, 0) + num);
            }
        }
        // 将 当前的结果出栈 组装成一个字符串
        return this.buildResult(curMap);
    }


    /**
     * 构造返回字符串
     * @param map treeMap 有序
     * @return
     */
    private String buildResult (Map<String, Integer> map) {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            Integer count = entry.getValue();
            if (count == 1) {
                builder.append(entry.getKey());
                continue;
            }
            builder.append(entry.getKey()).append(count);
        }
        return builder.toString();
    }
	

	
	public static void main(String[] args) {
		Solution solution = new Solution();

        String formula = "H2O";
        String s = solution.countOfAtoms(formula);
        System.out.println(s);
        Assert.assertEquals("H2O", s);


        formula = "Mg(OH)2";
        s = solution.countOfAtoms(formula);
        System.out.println(s);
        Assert.assertEquals("H2MgO2", s);


        formula = "H11He49NO35B7N46Li20";
        s = solution.countOfAtoms(formula);
        System.out.println(s);
        Assert.assertEquals("B7H11He49Li20N47O35", s);
    }
}
