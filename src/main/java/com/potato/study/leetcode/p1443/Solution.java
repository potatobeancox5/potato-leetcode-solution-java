package com.potato.study.leetcode.p1443;


import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 * 	1443. Minimum Time to Collect All Apples in a Tree
 *  
 *
Given an undirected tree consisting of n vertices numbered from 0 to n-1, which has some apples in their vertices. You spend 1 second to walk over one edge of the tree. Return the minimum time in seconds you have to spend in order to collect all apples in the tree starting at vertex 0 and coming back to this vertex.

The edges of the undirected tree are given in the array edges, where edges[i] = [fromi, toi] means that exists an edge connecting the vertices fromi and toi. Additionally, there is a boolean array hasApple, where hasApple[i] = true means that vertex i has an apple, otherwise, it does not have any apple.



Example 1:



Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,false,true,false,true,true,false]
Output: 8
Explanation: The figure above represents the given tree where red vertices have an apple. One optimal path to collect all apples is shown by the green arrows.
Example 2:



Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,false,true,false,false,true,false]
Output: 6
Explanation: The figure above represents the given tree where red vertices have an apple. One optimal path to collect all apples is shown by the green arrows.
Example 3:

Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,false,false,false,false,false,false]
Output: 0


Constraints:

1 <= n <= 10^5
edges.length == n-1
edges[i].length == 2
0 <= fromi, toi <= n-1
fromi < toi
hasApple.length == n
 *         
 *
 *
 *
 *  思路：
 *      https://leetcode-cn.com/problems/minimum-time-to-collect-all-apples-in-a-tree/solution/java5mszui-xin-ce-shi-yong-li-hou-xu-kao-lu-ji-x-2/
 *
 *
 *
 */
public class Solution {


    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        //记录节点的父节点编号
        int[] parent = new int[n];
        //记录节点是否被访问
        Boolean[] visit=new Boolean[n];
        for(int i=0;i<n;i++){
            visit[i] = false;
        }
        //以0为根节点初始化
        parent[0]=0;
        visit[0]=true;
        //记录被加入树的节点数量
        int buildnum=1;
        //构建树结构，首先找到以0为根的节点，加入树中，再将以这些节点为父节点的节点加入树中（不一定是先将0为根的节点全部加入后才加入其它节点，但不影响最后结果）
        while(buildnum<n){
            for(int[] edge:edges){
                if(visit[edge[0]]==true){
                    parent[edge[1]]=edge[0];
                    visit[edge[1]]=true;
                    buildnum++;
                } else if(visit[edge[1]]==true){
                    parent[edge[0]]=edge[1];
                    visit[edge[0]]=true;
                    buildnum++;
                }
            }
        }
        //重置是否被访问
        for(int i=1;i<n;i++){
            visit[i]=false;
        }
        //记录结果
        int res=0;
        //从有苹果的节点网上遍历，直到遍历到被访问过的节点为止，每次结果加2
        for(int i=0;i<n;i++){
            if(hasApple.get(i)==true){
                int now=i;
                while(visit[now]==false){
                    visit[now]=true;
                    now=parent[now];
                    res+=2;
                }
            }
        }
        return res;
    }
}
