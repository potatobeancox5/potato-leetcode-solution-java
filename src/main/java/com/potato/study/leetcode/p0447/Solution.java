package com.potato.study.leetcode.p0447;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author liuzhao11
 * 
 *   447. Number of Boomerangs
 * 
 *    Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).

Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).

Example:
Input:
[[0,0],[1,0],[2,0]]

Output:
2

Explanation:
The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
 * 			
 *     思路：求；两个点的简单距离 x - y = x - k 个数
 *         建立一个map 《int , int》 key 记录距离 value 记录 
 *         这个距离的 达到这个距离的点的组合数 
 * 			遍历 点数组 两层循环 极端 没两个点之间的距离 然后 将结果放到 map 中			
 * 			
 * 	
 */	
public class Solution {
	
	public int numberOfBoomerangs(int[][] points) {
        if(null == points || points.length <= 1) {
        	return 0;
        }
        //前两个循环固定点
        Map<Integer, Integer> timesMap = new HashMap<Integer, Integer>();
        int numOfBoomerangs = 0;
        for(int i = 0 ; i < points.length ; i++) {
        	for(int j = 0 ; j < points.length ; j++) {
        		if(j == i) {
        			continue;
        		}
        		int x = points[i][0] - points[j][0];
        		int y = points[i][1] - points[j][1];
        		int dis = x * x + y * y;
        		if(!timesMap.containsKey(dis)) {
        			timesMap.put(dis, 1);
        		} else {
        			timesMap.put(dis, timesMap.get(dis) + 1);
        		}
        	}
        	// 对于同一个起始点进行比较 计算总数
        	for ( int dis : timesMap.keySet()) {
    			if(timesMap.get(dis) >= 2) {
    				numOfBoomerangs += aNumber(timesMap.get(dis));
    			}
    		}
        	//比较玩清空 map
        	timesMap.clear();
        }
        return numOfBoomerangs;
    }
	
	/**
	 * 求从base中取2个数 有排列 取法
	 * @param base		一共有多少个数
	 * @param num		选择数的数量
	 * @return
	 */
	private int aNumber(int base) {
		if(base < 2) {
			return 1;
		}
		return base * (base - 1);
	}
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] points = {{0,0},{1,0},{2,0}};
		int num = solution.numberOfBoomerangs(points);
		System.out.println(num);
	}
}
