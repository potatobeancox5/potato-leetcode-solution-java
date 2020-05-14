package com.potato.study.leetcode.p0855;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 * 	855. Exam Room
 *  
 *         In an exam room, there are N seats in a single row, numbered 0, 1, 2, ..., N-1.

When a student enters the room, they must sit in the seat that maximizes the distance to the closest person.  If there are multiple such seats, they sit in the seat with the lowest number.  (Also, if no one is in the room, then the student sits at seat number 0.)

Return a class ExamRoom(int N) that exposes two functions: ExamRoom.seat() returning an int representing what seat the student sat in, and ExamRoom.leave(int p) representing that the student in seat number p now leaves the room.  It is guaranteed that any calls to ExamRoom.leave(p) have a student sitting in seat p.



Example 1:

Input: ["ExamRoom","seat","seat","seat","seat","leave","seat"], [[10],[],[],[],[],[4],[]]
Output: [null,0,9,4,2,null,5]
Explanation:
ExamRoom(10) -> null
seat() -> 0, no one is in the room, then the student sits at seat number 0.
seat() -> 9, the student sits at the last seat number 9.
seat() -> 4, the student sits at the last seat number 4.
seat() -> 2, the student sits at the last seat number 2.
leave(4) -> null
seat() -> 5, the student sits at the last seat number 5.
​​​​​​​

Note:

1 <= N <= 10^9
ExamRoom.seat() and ExamRoom.leave() will be called at most 10^4 times across all test cases.
Calls to ExamRoom.leave(p) are guaranteed to have a student currently sitting in seat number p.
 *         
 *
 *         题目含义：
 *
 *         思路：
 *         每次都做到最远的位置
 *         https://leetcode-cn.com/problems/exam-room/solution/java-arraylistjie-fa-by-don-vito-corleone/
 *         直接使用arraylist
 *
 *
 */
public class ExamRoom {

    private int n;
    private List<Integer> seatList;

    public ExamRoom(int n) {
        this.n = n;
        seatList = new ArrayList<>();
    }

    /**
     * 下一个人 坐在了什么位置
     * @return
     */
    public int seat() {
        // 没有人做 坐在最左边
        if (seatList.size() == 0) {
            seatList.add(0);
            return 0;
        }
        // 获取 左边的位置 和 最右边位置 到 n - 1 中最大的那个 左边可能有人走
        int d = Math.max(seatList.get(0) - 0, n - 1 - seatList.get(seatList.size() - 1));
        // 遍历每个位置 找到两个位置中间 的最大位置
        for (int i = 0; i < seatList.size() - 1; i ++) {
            d = Math.max(d, (seatList.get(i + 1) - seatList.get(i)) / 2);
        }
        // 如果计算出来 0 位置设置
        if (d == seatList.get(0)) {
            seatList.add(0, 0);
            return 0;
        }
        // 找到究竟应该放哪。。。。
        for (int i = 0; i < seatList.size() - 1; i ++) {
            if (d == (seatList.get(i + 1) - seatList.get(i)) / 2) {
                seatList.add(i + 1, (seatList.get(i + 1) + seatList.get(i)) / 2);
                return seatList.get(i + 1);
            }
        }
        seatList.add(n - 1);
        return n - 1;

    }

    /**
     * 遍历 list 删除
     * @param p
     */
    public void leave(int p) {
        for (int i = 0; i < seatList.size(); i++) {
            if (seatList.get(i) == p) {
                seatList.remove(i);
                return;
            }
        }
    }
}
