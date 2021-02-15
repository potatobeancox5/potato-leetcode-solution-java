package com.potato.study.leetcodecn.p00841.t001;

import com.google.common.collect.Lists;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 841. 钥匙和房间
 *
 * 有 N 个房间，开始时你位于 0 号房间。每个房间有不同的号码：0，1，2，...，N-1，并且房间里可能有一些钥匙能使你进入下一个房间。

 在形式上，对于每个房间 i 都有一个钥匙列表 rooms[i]，每个钥匙 rooms[i][j] 由 [0,1，...，N-1] 中的一个整数表示，其中 N = rooms.length。 钥匙 rooms[i][j] = v 可以打开编号为 v 的房间。

 最初，除 0 号房间外的其余所有房间都被锁住。

 你可以自由地在房间之间来回走动。

 如果能进入每个房间返回 true，否则返回 false。

 示例 1：

 输入: [[1],[2],[3],[]]
 输出: true
 解释:
 我们从 0 号房间开始，拿到钥匙 1。
 之后我们去 1 号房间，拿到钥匙 2。
 然后我们去 2 号房间，拿到钥匙 3。
 最后我们去了 3 号房间。
 由于我们能够进入每个房间，我们返回 true。
 示例 2：

 输入：[[1,3],[3,0,1],[2],[0]]
 输出：false
 解释：我们不能进入 2 号房间。
 提示：

 1 <= rooms.length <= 1000
 0 <= rooms[i].length <= 1000
 所有房间中的钥匙数量总计不超过 3000。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/keys-and-rooms
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * bfs 遍历
     * visited i 记录是不是去过这个房间
     * 手中钥匙 放入 queue 中，每次弄一个出来 访问这个房间并收集钥匙
     * 知道队空
     * 比较是不是去过所有房间 visited
     * @param rooms
     * @return
     */
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        Queue<Integer> keys = new LinkedList<>();
        List<Integer> list = rooms.get(0);
        keys.addAll(list);
        visited[0] = true;
        while (!keys.isEmpty()) {
            Integer key = keys.poll();
            if (visited[key]) {
                continue;
            }
            visited[key] = true;
            list = rooms.get(key);
            keys.addAll(list);
        }
        // get result
        for (boolean visit : visited) {
            if (!visit) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(Lists.newArrayList(1));
        rooms.add(Lists.newArrayList(2));
        rooms.add(Lists.newArrayList(3));
        rooms.add(Lists.newArrayList());
        boolean res = solution.canVisitAllRooms(rooms);
        System.out.println(res);
        Assert.assertEquals(true, res);


        rooms = new ArrayList<>();
        rooms.add(Lists.newArrayList(1, 3));
        rooms.add(Lists.newArrayList(3, 0, 1));
        rooms.add(Lists.newArrayList(2));
        rooms.add(Lists.newArrayList(0));
        res = solution.canVisitAllRooms(rooms);
        System.out.println(res);
        Assert.assertEquals(false, res);
    }
}
