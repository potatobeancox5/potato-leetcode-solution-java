package com.potato.study.leetcode.p0636;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * 
 * @author liuzhao11
 * 
 *         636. Exclusive Time of Functions
 * 
 *         On a single threaded CPU, we execute some functions.  Each function has a unique id between 0 and N-1.

We store logs in timestamp order that describe when a function is entered or exited.

Each log is a string with this format: "{function_id}:{"start" | "end"}:{timestamp}".  For example, "0:start:3" means the function with id 0 started at the beginning of timestamp 3.  "1:end:2" means the function with id 1 ended at the end of timestamp 2.

A function's exclusive time is the number of units of time spent in this function.  Note that this does not include any recursive calls to child functions.

The CPU is single threaded which means that only one function is being executed at a given time unit.

Return the exclusive time of each function, sorted by their function id.



Example 1:



Input:
n = 2
logs = ["0:start:0","1:start:2","1:end:5","0:end:6"]
Output: [3, 4]
Explanation:
Function 0 starts at the beginning of time 0, then it executes 2 units of time and reaches the end of time 1.
Now function 1 starts at the beginning of time 2, executes 4 units of time and ends at time 5.
Function 0 is running again at the beginning of time 6, and also ends at the end of time 6, thus executing for 1 unit of time.
So function 0 spends 2 + 1 = 3 units of total time executing, and function 1 spends 4 units of total time executing.


Note:

1 <= n <= 100
Two functions won't start or end at the same time.
Functions will always log when they exit.
 * 
 *         思路：
 *
 *         636. Exclusive Time of Functions

https://www.jianshu.com/p/8962e8b4c3ba

思想 用一个map 记录时间

prev 记录上一个时刻

stack 记录 上一个id

for e str 解析出id 和和开始结束
id  isStart  time 时刻
if isstart
if stack 非空
stack pop 出 上个id
map put id value + time _prev

更新time =prev
stack add id
else
stackpop
map put
prev 等于 time +1


遍历map 组装arr 返回


https://www.jianshu.com/p/8962e8b4c3ba
 */
public class Solution {


    public int[] exclusiveTime(int n, List<String> logs) {

        Map<Integer, Long> costTimeMap = new HashMap<>();
        Stack<Integer> idStack = new Stack<>();

        // "0:start:0"
        int curTime = 0;
        for (String log : logs) {
            String[] split = log.split(":");
            int id = Integer.parseInt(split[0]);
            String type = split[1];
            int time = Integer.parseInt(split[2]);

            if (idStack.isEmpty() && type.equals("start")) {
                idStack.push(id);
                curTime = time;
            } else if (type.equals("start")) {
                int lastId = idStack.peek();
                Long costTime = costTimeMap.get(lastId);
                if (null == costTime) {
                    costTimeMap.put(lastId, (long)time - curTime);
                } else {
                    costTimeMap.put(lastId, costTime + time - curTime);
                }
                idStack.push(id);
                curTime = time;
            } else if (type.equals("end")) {
                int thisId = idStack.pop();
                Long costTime = costTimeMap.get(thisId);
                if (null == costTime) {
                    costTimeMap.put(thisId, (long)time - curTime + 1);
                } else {
                    costTimeMap.put(thisId, costTime + time - curTime + 1);
                }
                curTime = time + 1;
            }
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            Long costTime = costTimeMap.get(i);
            res[i] = (int)costTime.longValue();
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int n = 2;
        List<String> logs = new ArrayList<>();
        logs.add("0:start:0");
        logs.add("1:start:2");
        logs.add("1:end:5");
        logs.add("0:end:6");

        int[] nums = solution.exclusiveTime(n, logs);
        System.out.println(Arrays.toString(nums)); // 3, 4
    }
}
