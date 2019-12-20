package com.potato.study.leetcode.p0699;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 * 699. Falling Squares
 *  
 *        On an infinite number line (x-axis), we drop given squares in the order they are given.

The i-th square dropped (positions[i] = (left, side_length)) is a square with the left-most point being positions[i][0] and sidelength positions[i][1].

The square is dropped with the bottom edge parallel to the number line, and from a higher height than all currently landed squares. We wait for each square to stick before dropping the next.

The squares are infinitely sticky on their bottom edge, and will remain fixed to any positive length surface they touch (either the number line or another square). Squares dropped adjacent to each other will not stick together prematurely.


Return a list ans of heights. Each height ans[i] represents the current highest height of any square we have dropped, after dropping squares represented by positions[0], positions[1], ..., positions[i].

Example 1:

Input: [[1, 2], [2, 3], [6, 1]]
Output: [2, 5, 5]
Explanation:
After the first drop of positions[0] = [1, 2]: _aa _aa ------- The maximum height of any square is 2.

After the second drop of positions[1] = [2, 3]: __aaa __aaa __aaa _aa__ _aa__ -------------- The maximum height of any square is 5. The larger square stays on top of the smaller square despite where its center of gravity is, because squares are infinitely sticky on their bottom edge.

After the third drop of positions[1] = [6, 1]: __aaa __aaa __aaa _aa _aa___a -------------- The maximum height of any square is still 5. Thus, we return an answer of [2, 5, 5].




Example 2:

Input: [[100, 100], [200, 100]]
Output: [100, 100]
Explanation: Adjacent squares don't get stuck prematurely - only their bottom edge can stick to surfaces.


Note:

1 <= positions.length <= 1000.
1 <= positions[i][0] <= 10^8.
1 <= positions[i][1] <= 10^6.

 *         题目解释：
 *          https://blog.csdn.net/u013007900/article/details/81065441
 *
 *          常规想发1
 *
 *
 *
 *
 *
 * 
 */
public class Solution {


    class Interval {
        // start index
        public int start;
        // end index
        public int end;
        // height
        public int height;

        public Interval(int start, int end, int height) {
            this.start = start;
            this.end = end;
            this.height = height;
        }
    }

    public List<Integer> fallingSquares(int[][] positions) {
        // 对每个position 根据之前inteval 求height
        List<Integer> result = new ArrayList<>(positions.length);
        int height = 0;
        List<Interval> hasFalledInterval = new ArrayList<>();
        for (int i = 0; i < positions.length; i++) {
            // 创建 interval
            Interval current = new Interval(positions[i][0],
                    positions[i][0] + positions[i][1] - 1, positions[i][1]);
            // 调用字函数 找到最大height
            height = Math.max(height, getHeight(hasFalledInterval, current));
            // 加入 结果
            result.add(height);

        }
        return result;
    }

    /**
     * 每次落下一个方块，计算落下之后最高位置的高度
     * @param hasFalledInterval
     * @param current
     * @return
     */
    private int getHeight(List<Interval> hasFalledInterval, Interval current) {
        // 遍历每个方块， 找到最大点
        int preHeight = 0;
        for (Interval pre : hasFalledInterval) {
            if (pre.end < current.start || current.end < pre.start) {
                continue;
            }
            preHeight = Math.max(preHeight, pre.height);
        }
        current.height += preHeight;
        hasFalledInterval.add(current);
        return current.height;
    }

	public static void main(String[] args) {
		Solution solution = new Solution();
        int[][] positions = {{1, 2}, {2, 3}, {6, 1}};
        List<Integer> list = solution.fallingSquares(positions);
        System.out.println(list); // 2, 5, 5
    }
}
