package com.potato.study.leetcode.p0341;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 *         341. Flatten Nested List Iterator
 * 
 *         Given a nested list of integers, implement an iterator to flatten it.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:

Input: [[1,1],2,[1,1]]
Output: [1,1,2,1,1]
Explanation: By calling next repeatedly until hasNext returns false,
the order of elements returned by next should be: [1,1,2,1,1].
Example 2:

Input: [1,[4,[6]]]
Output: [1,4,6]
Explanation: By calling next repeatedly until hasNext returns false,
the order of elements returned by next should be: [1,4,6].
 * 
 *         思路：
 *        
 * 
 */



/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {


    private List<Integer> cache;
    private int nextIndex;

    /**
     * 递归遍历节点并打平数组
     * @param nestedList
     */
    public NestedIterator(List<NestedInteger> nestedList) {
        cache = new ArrayList<>();
        generateCache(nestedList, cache);
        nextIndex = 0;
    }


    private void generateCache(List<NestedInteger> nestedList, List<Integer> cache) {
        if (null == nestedList || nestedList.size() == 0) {
            return;
        }
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                cache.add(nestedInteger.getInteger());
            } else {
                generateCache(nestedInteger.getList(), cache);
            }
        }
    }

    @Override
    public Integer next() {
        return cache.get(nextIndex++);
    }

    @Override
    public boolean hasNext() {
        return nextIndex < cache.size();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
