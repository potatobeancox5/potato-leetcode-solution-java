package com.potato.study.leetcode.p0705;

/**
 * 
 * @author liuzhao11
 * 
 * 	705. Design HashSet
 *
705. Design HashSet
Easy

148

39

Favorite

Share
Design a HashSet without using any built-in hash table libraries.

To be specific, your design should include these functions:

add(value): Insert a value into the HashSet.
contains(value) : Return whether the value exists in the HashSet or not.
remove(value): Remove a value in the HashSet. If the value does not exist in the HashSet, do nothing.

Example:

MyHashSet hashSet = new MyHashSet();
hashSet.add(1);
hashSet.add(2);
hashSet.contains(1);    // returns true
hashSet.contains(3);    // returns false (not found)
hashSet.add(2);
hashSet.contains(2);    // returns true
hashSet.remove(2);
hashSet.contains(2);    // returns false (already removed)

Note:

All values will be in the range of [0, 1000000].
The number of operations will be in the range of [1, 10000].
Please do not use the built-in HashSet library.
 *         
 *         题目解释：
 *          直接申请一个数组 用key 作为index
 *         
 *
 *
 * 
 */
public class MyHashSet {

    private int[] arr;

    public MyHashSet() {
        arr = new int[1000001];
        // 全部初始化为-1；
        for (int i = 0; i < arr.length; i++) {
            arr[i] = -1;
        }
    }

    public void add(int key) {
        arr[key] = key;
    }

    public void remove(int key) {
        arr[key] = -1;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        if (arr[key] >= 0) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {

        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);
        hashSet.add(2);
        hashSet.contains(1);    // returns true
        hashSet.contains(3);    // returns false (not found)
        hashSet.add(2);
        hashSet.contains(2);    // returns true
        hashSet.remove(2);
        hashSet.contains(2);    // returns false (already removed)
    }
}

