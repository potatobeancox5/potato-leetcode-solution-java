package com.potato.study.leetcode.p0677;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author liuzhao11
 * 
 *         677. Map Sum Pairs
 * 
 *         Implement a MapSum class with insert, and sum methods.

For the method insert, you'll be given a pair of (string, integer).
The string represents the key and the integer represents the value.
If the key already existed, then the original key-value pair will be overridden to the new one.

For the method sum, you'll be given a string representing the prefix, and you need to return the sum of all the pairs' value whose key starts with the prefix.

Example 1:
Input: insert("apple", 3), Output: Null
Input: sum("ap"), Output: 3
Input: insert("app", 2), Output: Null
Input: sum("ap"), Output: 5*
 *
 *
 *         思路：
 *
 *         https://blog.csdn.net/u014688145/article/details/78057116
 *
 *         构造一种数据结构 insert 插入 key和value
 *         sum 时 给出 前缀 计算前缀所涉及到的所有值的sum
 *
 *         插入时直接插入
 *
 *         获取时全量获取比较
 *
 */
public class MapSum {

    private Map<String, Integer> map;

    /** Initialize your data structure here. */
    public MapSum() {
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        map.put(key, val);
    }

    public int sum(String prefix) {
        int res = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getKey().startsWith(prefix)) {
                res += entry.getValue();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MapSum mapSum = new MapSum();

        mapSum.insert("apple", 3);
        int value = mapSum.sum("ap");// 3
        System.out.println(value);
        Assert.assertEquals(3, value);

        mapSum.insert("app", 2);
        value = mapSum.sum("ap");// 5
        System.out.println(value);
        Assert.assertEquals(5, value);

    }
}
