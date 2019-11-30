package com.potato.study.leetcode.p0547;

/**
 * 
 * @author liuzhao11
 * 
 *         547. Friend Circles
 * 
 *         There are N students in a class. Some of them are friends, while some are not. Their friendship is transitive in nature. For example, if A is a direct friend of B, and B is a direct friend of C, then A is an indirect friend of C. And we defined a friend circle is a group of students who are direct or indirect friends.

Given a N*N matrix M representing the friend relationship between students in the class. If M[i][j] = 1, then the ith and jth students are direct friends with each other, otherwise not. And you have to output the total number of friend circles among all the students.

Example 1:
Input:
[[1,1,0],
[1,1,0],
[0,0,1]]
Output: 2
Explanation:The 0th and 1st students are direct friends, so they are in a friend circle.
The 2nd student himself is in a friend circle. So return 2.
Example 2:
Input:
[[1,1,0],
[1,1,1],
[0,1,1]]
Output: 1
Explanation:The 0th and 1st students are direct friends, the 1st and 2nd students are direct friends,
so the 0th and 2nd students are indirect friends. All of them are in the same friend circle, so return 1.
Note:
N is in range [1,200].
M[i][i] = 1 for all students.
If M[i][j] = 1, then M[j][i] = 1.
 * 
 * 
 *         思路：
 *
 *          547. Friend Circles

矩阵m ij=1 代表 ij是朋友

求一共有多少个朋友圈

用list set 存每个朋友圈都有谁

遍历点
fori 0 n-1
for j 0 n-1
if m ij等于1
while k 找到第一个包含ij的set
遍历其他set 包含ij 就 remove 然后合并


https://blog.csdn.net/Ellie_/article/details/76220678

dfs i行没有visited的数字 在matrix矩阵中

for j 0 n-1
if ！visited j 且 matrix ij =1
修改visited j
递推 dfs j visitrd matrix


主函数

fori 0 n-1
如果 非visoted i
dfs i visited matrix
cpunt++
end for
 *       
 *          
 */
public class Solution {

    public int findCircleNum(int[][] m) {
        // 人数
        int n = m.length;
        // 0 没有访问 1 已经访问
        int[] visited = new int[n];

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] != 1) {
                dfs(visited, i, m);
                count++;
            }
        }
        return count;
    }


    /**
     *
     * @param visited   标记是否已经访问
     * @param i     当前访问的人index
     * @param m     关系矩阵
     */
    private void dfs(int[] visited, int i, int[][] m) {
        visited[i] = 1;
        for (int j = 0; j < m.length; j++) {
            if (m[i][j] == 1 && visited[j] == 0) {
                dfs(visited, j, m);
            }
        }
    }
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
        int[][] m = {};
		int diameter = solution.findCircleNum(m);
		System.out.println(diameter);
	}
}
