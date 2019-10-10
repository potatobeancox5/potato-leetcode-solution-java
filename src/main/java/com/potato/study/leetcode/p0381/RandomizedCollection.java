package com.potato.study.leetcode.p0381;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

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
 *
 *
 */
public class RandomizedCollection {

    private List<Integer> list;
    private Map<Integer, List<Integer>> keyIndexMap;
    private Random random;
    // 存放目前list 中空闲的index
    private Set<Integer> gapSet;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        list = new ArrayList<>();
        keyIndexMap = new HashMap<>();
        random = new Random();
        gapSet = new HashSet<>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if (!keyIndexMap.containsKey(val)) {
            int newIndex = list.size();
            list.add(val);
            List<Integer> indexList = new ArrayList<>();
            indexList.add(newIndex);
            keyIndexMap.put(val, indexList);
            return true;
        } else {
            int newIndex = list.size();
            list.add(val);
            List<Integer> indexList = keyIndexMap.get(val);
            indexList.add(newIndex);
            return false;
        }
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (keyIndexMap.containsKey(val)) {
            List<Integer> indexList = keyIndexMap.get(val);
            if (indexList.size() > 1) {
                Integer removeIndex = indexList.remove(indexList.size() - 1);
                gapSet.add(removeIndex);
            } else {
                keyIndexMap.remove(val);
                gapSet.add(indexList.get(0));
            }
            return true;
        }
        return false;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        int nextIndex = random.nextInt(list.size());
        while (gapSet.contains(nextIndex)) {
            nextIndex = random.nextInt(list.size());
        }
        return list.get(nextIndex);
    }
	
	
	public static void main(String[] args) { }
}

