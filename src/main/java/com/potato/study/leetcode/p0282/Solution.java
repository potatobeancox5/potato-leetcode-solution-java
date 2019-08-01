package com.potato.study.leetcode.p0282;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 * 
 * 282. Expression Add Operators
Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.

Example 1:

Input: num = "123", target = 6
Output: ["1+2+3", "1*2*3"]
Example 2:

Input: num = "232", target = 8
Output: ["2*3+2", "2+3*2"]
Example 3:

Input: num = "105", target = 5
Output: ["1*0+5","10-5"]
Example 4:

Input: num = "00", target = 0
Output: ["0+0", "0-0", "0*0"]
Example 5:

Input: num = "3456237490", target = 9191
Output: []
* 		思路：
 * 	    https://blog.csdn.net/wdlsjdl2/article/details/51859706
 *
 * 	    282 表达式

https://blog.csdn.net/mine_song/article/details/71024333

getRxpression
参数   target   currentresult  原表达式
当前表达式   currentIndex presum 总结果集合 当前结果
presum 为本次运算之前的和的值

if target == currentresult 且 currentIndex== 原表达式len
总结果add 当前表达式
//选择字符串进行运算
for i=currentIndex    i《字符串len
currentNum = poi- i+1

先导0 只能搞一次
if  currentindex =='0' 且 i不等于currentindex
return

if currentindex ==0
递归调用  target currentresult + curNum



else
递归调用 参数
target currentresult + curNum  num
当前表达式 + currentNum  i+1 当前结果 + currentNum



https://blog.csdn.net/mine_song/article/details/71024333
* 
 */
public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> resList = new ArrayList<>();
        getExpression(target, 0, num, "", 0, 0, resList);
        return resList;
    }

    /**
     * 回溯法 查找字符串 并生成结果记录
     * @param target                目标数字
     * @param currentResult         当前计算结果
     * @param num                   字符串
     * @param currentExpression     本次运算之前生成的字符串
     * @param currentIndex          当前的index
     * @param preRes                本次运算之前的结果
     * @param resList               最终返回结果
     */
    private void getExpression(long target, long currentResult, String num, String currentExpression,
                               long currentIndex, long preRes, List<String> resList) {

        if (target == currentResult && currentIndex == num.length()) {
            resList.add(currentExpression);
            return;
        }
        // 选择字符串进行运算
        for (long i = currentIndex; i < num.length(); i++) {
            //  先导0 就不用搞了
            if (currentIndex != i && num.charAt((int)currentIndex) == '0') {
                return;
            }
            long curNum = Long.valueOf(num.substring((int)currentIndex, (int)i + 1));

            if (currentIndex == 0) {
                getExpression(target, curNum, num, currentExpression + curNum,
                        i + 1, curNum, resList);
            } else {
                getExpression(target, currentResult + curNum, num,
                        currentExpression + "+" + curNum,
                        i + 1, curNum, resList);
                getExpression(target, currentResult - curNum, num,
                        currentExpression + "-" + curNum,
                        i + 1, -curNum, resList);
                getExpression(target, currentResult -preRes + preRes * curNum, num,
                        currentExpression + "*" +curNum,
                        i + 1, preRes * curNum, resList);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        String num = "123";
//        int target = 6;

//        String num = "232";
//        int target = 8;

//        String num = "105";
//        int target = 5;

//        String num = "00";
//        int target = 0;

        String num = "3456237490";
        int target = 9191;
        List<String> list = solution.addOperators(num, target);
        System.out.println(list);
    }
}
