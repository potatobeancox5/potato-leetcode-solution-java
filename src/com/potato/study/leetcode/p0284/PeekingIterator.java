package com.potato.study.leetcode.p0284;

import java.util.Iterator;

/**
 * 
 * @author liuzhao11
 * 
 * 
 * 284. Peeking Iterator
Given an Iterator class interface with methods: next() and hasNext(), design and implement a PeekingIterator that support the peek() operation -- it essentially peek() at the element that will be returned by the next call to next().

Example:

Assume that the iterator is initialized to the beginning of the list: [1,2,3].

Call next() gets you 1, the first element in the list.
Now you call peek() and it returns 2, the next element. Calling next() after that still return 2.
You call next() the final time and it returns 3, the last element.
Calling hasNext() after that should return false.
Follow up: How would you extend your design to be generic and work with all types, not just integer?
*
 *
 * 题目需求：
 *  利用java 提供迭代器 实现一个数据结构
 *  peek 显示当前第一个元素
 *  next 删除并显示下一个元素
 *  hasNext 是否存在下一个元素
 *
 * 思路：
*   记录标记位 hasPeek 每次调用peek 调用父类的next 保存next值 设置hasPeek = true
 */
 // Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
public class PeekingIterator implements Iterator<Integer> {

    private boolean hasPeek;

    private Integer peekNum;

    private Iterator<Integer> superIterator;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        hasPeek = false;
        this.superIterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (hasPeek) {
            return peekNum;
        } else {
            peekNum = superIterator.next();
            hasPeek = true;
            return peekNum;
        }
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (hasPeek) {
            hasPeek = false;
            return peekNum;
        } else {
            return superIterator.next();
        }
    }

    @Override
    public boolean hasNext() {
        if (hasPeek) {
            return true;
        } else {
            return superIterator.hasNext();
        }
    }
}
