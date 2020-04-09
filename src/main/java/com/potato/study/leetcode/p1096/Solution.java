package com.potato.study.leetcode.p1096;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * 
 * @author liuzhao11
 * 
 * 	1096. Brace Expansion II
 *  
 *       Under a grammar given below, strings can represent a set of lowercase words.  Let's use R(expr) to denote the set of words the expression represents.

Grammar can best be understood through simple examples:

Single letters represent a singleton set containing that word.
R("a") = {"a"}
R("w") = {"w"}
When we take a comma delimited list of 2 or more expressions, we take the union of possibilities.
R("{a,b,c}") = {"a","b","c"}
R("{{a,b},{b,c}}") = {"a","b","c"} (notice the final set only contains each word at most once)
When we concatenate two expressions, we take the set of possible concatenations between two words where the first word comes from the first expression and the second word comes from the second expression.
R("{a,b}{c,d}") = {"ac","ad","bc","bd"}
R("a{b,c}{d,e}f{g,h}") = {"abdfg", "abdfh", "abefg", "abefh", "acdfg", "acdfh", "acefg", "acefh"}
Formally, the 3 rules for our grammar:

For every lowercase letter x, we have R(x) = {x}
For expressions e_1, e_2, ... , e_k with k >= 2, we have R({e_1,e_2,...}) = R(e_1) ∪ R(e_2) ∪ ...
For expressions e_1 and e_2, we have R(e_1 + e_2) = {a + b for (a, b) in R(e_1) × R(e_2)}, where + denotes concatenation, and × denotes the cartesian product.
Given an expression representing a set of words under the given grammar, return the sorted list of words that the expression represents.



Example 1:

Input: "{a,b}{c,{d,e}}"
Output: ["ac","ad","ae","bc","bd","be"]
Example 2:

Input: "{{a,z},a{b,c},{ab,z}}"
Output: ["a","ab","ac","z"]
Explanation: Each distinct word is written only once in the final answer.
 *         
 *
 *
 *
 *         思路：
 *         https://leetcode.com/problems/brace-expansion-ii/discuss/458182/Short-and-clean-Java-recursive
 *
 *         https://leetcode.com/problems/brace-expansion-ii/discuss/561990/Java-Solution-With-2-Stacks-13ms
 *
 *
 *
 */
public class Solution {

    public List<String> braceExpansionII(String expression) {
        // 两个stack 一个笛卡尔积 一个并集 并初始化
        Stack<Set<String>> productStack = new Stack<>();
        Stack<Set<String>> unionStack = new Stack<>();
        // 遍历表达式
        Set<String> set = new HashSet<>();
        set.add("");
        productStack.add(set);
        unionStack.add(new HashSet<>());

        for (char ch : expression.toCharArray()) {
            if ('{' == ch) {
                Set<String> tmp = new HashSet<>();
                tmp.add("");
                productStack.push(new HashSet<>(tmp));
                unionStack.push(new HashSet<>());
            } else if ('}' == ch) {
                unionStack.push(union(unionStack.pop(), productStack.pop()));
                productStack.push(product(productStack.pop(), unionStack.pop()));
            } else if (',' == ch) {
                Set<String> tmp = new HashSet<>();
                tmp.add("");
                unionStack.push(union(unionStack.pop(), productStack.pop()));
                productStack.push(tmp);
            } else {
                Set<String> tmp = new HashSet<>();
                tmp.add("" + ch);
                productStack.push(product(productStack.pop(), tmp));

            }
        }
        List<String> res = new ArrayList<>(productStack.pop());
        Collections.sort(res);
        return res;
    }

    /**
     * 求两个结合的 并集合
     * @param a
     * @param b
     * @return
     */
    private Set<String> union(Set<String> a , Set<String> b) {
        Set<String> set = new HashSet<>(a);
        set.addAll(b);
        return set;
    }

    /**
     * 求两个集合字符串的笛卡尔积
     * @param a
     * @param b
     * @return
     */
    private Set<String> product(Set<String> a , Set<String> b) {
        Set<String> set = new HashSet<>();
        for (String aa : a) {
            for (String bb : b) {
                set.add(aa + bb);
            }
        }
        return set;
    }


	public static void main(String[] args) {
		Solution solution = new Solution();

        String expression = "{a,b}{c,{d,e}}";
        List<String> list = solution.braceExpansionII(expression);
        System.out.println(list); // ["ac","ad","ae","bc","bd","be"]

        expression = "{{a,z},a{b,c},{ab,z}}";
        list = solution.braceExpansionII(expression);
        System.out.println(list); // ["a","ab","ac","z"]
    }
}
