package com.potato.study.leetcode.p1146;


import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * 
 * @author liuzhao11
 * 
 * 	1146. Snapshot Array
 *  
 *
 * Implement a SnapshotArray that supports the following interface:

SnapshotArray(int length) initializes an array-like data structure with the given length.  Initially, each element equals 0.
void set(index, val) sets the element at the given index to be equal to val.
int snap() takes a snapshot of the array and returns the snap_id: the total number of times we called snap() minus 1.
int get(index, snap_id) returns the value at the given index, at the time we took the snapshot with the given snap_id


Example 1:

Input: ["SnapshotArray","set","snap","set","get"]
[[3],[0,5],[],[0,6],[0,0]]
Output: [null,null,0,null,5]
Explanation:
SnapshotArray snapshotArr = new SnapshotArray(3); // set the length to be 3
snapshotArr.set(0,5);  // Set array[0] = 5
snapshotArr.snap();  // Take a snapshot, return snap_id = 0
snapshotArr.set(0,6);
snapshotArr.get(0,0);  // Get the value of array[0] with snap_id = 0, return 5


Constraints:

1 <= length <= 50000
At most 50000 calls will be made to set, snap, and get.
0 <= index < length
0 <= snap_id < (the total number of times we call snap())
0 <= val <= 10^9
 *         
 *      思路：
 *          https://leetcode-cn.com/problems/snapshot-array/solution/java-shi-yong-treemapzhi-xu-ji-xing-dai-ma-by-forz/ *
 */
public class SnapshotArray {

    private List<TreeMap<Integer, Integer>> arr = new ArrayList<>();
    private int snap = 0;
    public SnapshotArray(int length) {
        for (int i=0; i<length; i++) {
            arr.add(new TreeMap<>());
        }
    }

    public void set(int index, int val) {
        TreeMap<Integer, Integer> tm = arr.get(index);
        tm.put(snap, val);
    }

    public int snap() {
        return snap++;
    }

    public int get(int index, int snap_id) {
        TreeMap<Integer, Integer> tm = arr.get(index);
        Integer key = tm.floorKey(snap_id);
        return key == null ? 0 : tm.get(key);
    }
}
