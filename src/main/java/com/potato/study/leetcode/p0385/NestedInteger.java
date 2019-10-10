package com.potato.study.leetcode.p0385;

import java.util.ArrayList;
import java.util.List;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedInteger {
    // Constructor initializes an empty nested list.
//    public NestedInteger();

    private int value;
    private List<NestedInteger> list = new ArrayList<>();
    private boolean isNum = false;

    public NestedInteger() {}
    public NestedInteger(int value) {
        this.value = value;
        isNum = true;
    }
    public boolean isInteger() {
        return false;
    }
    public Integer getInteger() {
        if (isNum) {
            return value;
        }
        return null;
    }
    public void setInteger(int value) {
        this.value = value;
        isNum = true;
    }

    public void add(NestedInteger ni) {
        list.add(ni);
    }

    public List<NestedInteger> getList() {
        return list;
    }


    @Override
    public String toString() {
        return "NestedInteger{" +
                "value=" + value +
                ", list=" + list +
                ", isNum=" + isNum +
                '}';
    }
}