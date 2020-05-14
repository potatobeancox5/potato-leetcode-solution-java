package com.potato.study.leetcode.p0851;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 * 	851. Loud and Rich
 *  
 *        In a group of N people (labelled 0, 1, 2, ..., N-1), each person has different amounts of money, and different levels of quietness.

For convenience, we'll call the person with label x, simply "person x".

We'll say that richer[i] = [x, y] if person x definitely has more money than person y.  Note that richer may only be a subset of valid observations.

Also, we'll say quiet[x] = q if person x has quietness q.

Now, return answer, where answer[x] = y if y is the least quiet person (that is, the person y with the smallest value of quiet[y]), among all people who definitely have equal to or more money than person x.



Example 1:

Input: richer = [[1,0],[2,1],[3,1],[3,7],[4,3],[5,3],[6,3]], quiet = [3,2,5,4,6,1,7,0]
Output: [5,5,2,5,4,5,6,7]
Explanation:
answer[0] = 5.
Person 5 has more money than 3, which has more money than 1, which has more money than 0.
The only person who is quieter (has lower quiet[x]) is person 7, but
it isn't clear if they have more money than person 0.

answer[7] = 7.
Among all people that definitely have equal to or more money than person 7
(which could be persons 3, 4, 5, 6, or 7), the person who is the quietest (has lower quiet[x])
is person 7.

The other answers can be filled out with similar reasoning.
Note:

1 <= quiet.length = N <= 500
0 <= quiet[i] < N, all quiet[i] are different.
0 <= richer.length <= N * (N-1) / 2
0 <= richer[i][j] < N
richer[i][0] != richer[i][1]
richer[i]'s are all different.
The observations in richer are all logically consistent.
 *         
 *
 *         题目含义：
 *
 *          851. Loud and Rich

题目含义
找到比x 富有的人中最安静的那个人

题解

https://leetcode-cn.com/problems/loud-and-rich/solution/xuan-nao-he-fu-you-by-leetcode

list【】构造 有向图

y比x富有 则构造 x到y 的有向图

1 构造list【】存储图
2 初始化结果数组 -1 fill
3 从点0开始查找 开始 dfs 找节点子数中最安静

dfs 返回 最安静点的index
当前节点操作
改当前节点状态
for each 下个点
int index = dfs  子节点
比较并记录最小值
 *
 *
 */
public class Solution {

    /**
     * 存图的数据结构 index 是节点号 每个元素代表元素邻接的点的index
     */
    private List<Integer>[] graph;

    /**
     * 存结果
     */
    private int[] answer;

    private int[] quiet;



    public int[] loudAndRich(int[][] richer, int[] quiet) {

        int num = quiet.length;
        this.quiet = quiet;
        this.graph = new List[num];
        answer = new int[num];
        // 0 对 graph 设置初值
        for (int i = 0; i < num; i++) {
            graph[i] = new ArrayList<>();
        }
        // 1 遍历 richer 向 graph 转化
        for (int[] rich : richer) {
            graph[rich[1]].add(rich[0]);
        }
        // 2 初始化 answer数组
        Arrays.fill(answer, -1);
        // 3 从每个节点开始 dfs 找到 比他富有的最安静的点 内部设置answer
        for (int i = 0; i < num; i++) {
            dfs(i);
        }
        // 4 返回 answer
        return answer;
    }

    /**
     * dfs 差早 比 i 有钱的人中最安静的人
     * @param i
     */
    private int dfs(int i) {

        // 已然确定 优化掉
        if (answer[i] != -1) {
            return answer[i];
        }
        answer[i] = i;
        // 遍历每一个位置
        for (int child: graph[i]) {
            int person = dfs(child);
            // 如果当前位置的安静程度比记录的answer 还安静那么记录
            if (quiet[person] < quiet[answer[i]]) {
                answer[i] = person;
            }
        }
        return answer[i];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] richer = new int[][]{{1,0},{2,1},{3,1},{3,7},{4,3},{5,3},{6,3}};
        int[] quiet = new int[]{3,2,5,4,6,1,7,0};

        int[] result = solution.loudAndRich(richer, quiet);
        System.out.println(Arrays.toString(result));

    }
}





