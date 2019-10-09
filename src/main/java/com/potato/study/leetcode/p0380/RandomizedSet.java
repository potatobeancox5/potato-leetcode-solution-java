package com.potato.study.leetcode.p0380;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 
 * @author liuzhao11
 * 
 *       380. Insert Delete GetRandom O(1)
 * 
 *      Design a data structure that supports all following operations in average O(1) time.

insert(val): Inserts an item val to the set if not already present.
remove(val): Removes an item val from the set if present.
getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
Example:

// Init an empty set.
RandomizedSet randomSet = new RandomizedSet();

// Inserts 1 to the set. Returns true as 1 was inserted successfully.
randomSet.insert(1);

// Returns false as 2 does not exist in the set.
randomSet.remove(2);

// Inserts 2 to the set, returns true. Set now contains [1,2].
randomSet.insert(2);

// getRandom should return either 1 or 2 randomly.
randomSet.getRandom();

// Removes 1 from the set, returns true. Set now contains [2].
randomSet.remove(1);

// 2 was already in the set, so return false.
randomSet.insert(2);

// Since 2 is the only number in the set, getRandom always return 2.
randomSet.getRandom();
 *         
 *         思路：
 *         https://www.cnblogs.com/reboot329/p/5894784.html
 *
 *         list 储存元素
 *         map key 是元素 value 是元素的存储位置
 *
 */
public class RandomizedSet {

    private List<Integer> list;
    private Map<Integer, Integer> keyIndexMap;
    private Random random;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        list = new ArrayList<>();
        keyIndexMap = new HashMap<>();
        random = new Random();

    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (!keyIndexMap.containsKey(val)) {
            int newIndex = list.size();
            list.add(val);
            keyIndexMap.put(val, newIndex);
            return true;
        }
        return false;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (keyIndexMap.containsKey(val)) {
            keyIndexMap.remove(val);
            return true;
        }
        return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int nextIndex = random.nextInt(list.size());
        Integer value = list.get(nextIndex);
        while (!keyIndexMap.containsKey(value)) {
            nextIndex = random.nextInt(list.size());
            value = list.get(nextIndex);
        }
        return value;
    }
	
	
	public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.insert(0);
        randomizedSet.insert(1);
        randomizedSet.remove(0);
        randomizedSet.insert(2);
        randomizedSet.remove(1);
        int random = randomizedSet.getRandom();
        System.out.println(random);
    }
}

