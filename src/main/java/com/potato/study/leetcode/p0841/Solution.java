package com.potato.study.leetcode.p0841;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * 
 * @author liuzhao11
 * 
 * 	841. Keys and Rooms
 *  
 *         There are N rooms and you start in room 0.  Each room has a distinct number in 0, 1, 2, ..., N-1, and each room may have some keys to access the next room.

Formally, each room i has a list of keys rooms[i], and each key rooms[i][j] is an integer in [0, 1, ..., N-1] where N = rooms.length.  A key rooms[i][j] = v opens the room with number v.

Initially, all the rooms start locked (except for room 0).

You can walk back and forth between rooms freely.

Return true if and only if you can enter every room.

Example 1:

Input: [[1],[2],[3],[]]
Output: true
Explanation:
We start in room 0, and pick up key 1.
We then go to room 1, and pick up key 2.
We then go to room 2, and pick up key 3.
We then go to room 3.  Since we were able to go to every room, we return true.
Example 2:

Input: [[1,3],[3,0,1],[2],[0]]
Output: false
Explanation: We can't enter the room with number 2.
Note:

1 <= rooms.length <= 1000
0 <= rooms[i].length <= 1000
The number of keys in all rooms combined is at most 3000.
 *         
 *         思路：
 *         https://blog.csdn.net/lym940928/article/details/81461863
            一个set保存已经走过的屋子，
            另一个栈 用来保存当前怎么过去的
            从0号房间走一遍 记录哪个房间没有走过
 * 
 */
public class Solution {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (null == rooms || rooms.size() == 0) {
            return false;
        }
        Stack<Integer> hasKeyRoom = new Stack<>();
        hasKeyRoom.addAll(rooms.get(0));
        Set<Integer> hasVisitedRoom = new HashSet<>();
        hasVisitedRoom.add(0);
        while (!hasKeyRoom.isEmpty()) {
            while (!hasKeyRoom.isEmpty() && hasVisitedRoom.contains(hasKeyRoom.peek())) {
                hasKeyRoom.pop();
            }
            if (hasKeyRoom.isEmpty()) {
                break;
            }
            Integer key = hasKeyRoom.pop();
            hasVisitedRoom.add(key);
            List<Integer> hasKeyList = rooms.get(key);
            for (int keyRoom : hasKeyList) {
                if (hasVisitedRoom.contains(keyRoom)) {
                    continue;
                } else {
//                    hasVisitedRoom.add(keyRoom);
                    hasKeyRoom.add(keyRoom);
                }
            }
        }
        if (hasVisitedRoom.size() < rooms.size()) {
            return false;
        }
        return true;
    }


	public static void main(String[] args) {
		Solution solution = new Solution();
        List<List<Integer>> rooms = new ArrayList<>();
        List<Integer> key1 = new ArrayList<>();
        key1.add(1);
        List<Integer> key2 = new ArrayList<>();
        key2.add(2);
        List<Integer> key3 = new ArrayList<>();
        key3.add(3);

        rooms.add(key1);
        rooms.add(key2);
        rooms.add(key3);
        rooms.add(new ArrayList<>());

        boolean res = solution.canVisitAllRooms(rooms);
        System.out.println(res);
    }
}
