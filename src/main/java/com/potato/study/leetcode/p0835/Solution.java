package com.potato.study.leetcode.p0835;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author liuzhao11
 * 
 * 	835. Image Overlap
 *  
 *         Two images A and B are given, represented as binary, square matrices of the same size.  (A binary matrix has only 0s and 1s as values.)

We translate one image however we choose (sliding it left, right, up, or down any number of units), and place it on top of the other image.  After, the overlap of this translation is the number of positions that have a 1 in both images.

(Note also that a translation does not include any kind of rotation.)

What is the largest possible overlap?

Example 1:

Input: A = [[1,1,0],
[0,1,0],
[0,1,0]]
B = [[0,0,0],
[0,1,1],
[0,0,1]]
Output: 3
Explanation: We slide A to right by 1 unit and down by 1 unit.
Notes:

1 <= A.length = A[0].length = B.length = B[0].length <= 30
0 <= A[i][j], B[i][j] <= 1
 *         
 *         思路：
 *
 *         https://www.cnblogs.com/grandyang/p/10355589.html
 *
 *         我们还可以换一种思路，由于只有值为1的地方才有可能重叠，所以我们只关心A和B中值为1的地方，将其坐标位置分别存入两个数组 listA 和 listB 中。由于对于A和B中的任意两个1的位置，肯定有一种方法能将A平移到B，平移的方法就是横向平移其横坐标之差，竖向平移其纵坐标之差。由于其是一一对应关系，所以只要是横纵坐标差相同的两对儿位置，一定是在同一次平移上。那么我们就需要一个 HashMap 来建立坐标差值和其出现次数之间的映射，为了降维，将横纵坐标之差转为字符串，然后中加上个横杠分隔开，这样只要组成了相同的字符串，那么一定就是在同一个平移上，计数器自增1。最后在 HashMap 中找到最大的值即可，参见代码如下：
 *
 *         https://www.cnblogs.com/ruruozhenhao/p/10669690.html
 *
 *         统计 ab 中 zy 坐标差 dx-dy 相同的1的个数 选择最多的那个就是答案
 *         https://www.cnblogs.com/ruruozhenhao/p/10669690.html
 *
 * 
 */
public class Solution {

    public int largestOverlap(int[][] a, int[][] b) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] == 1) {
                    for (int k = 0; k < b.length; k++) {
                        for (int l = 0; l < b[0].length; l++) {
                            if (b[k][l] == 1) {
                                String key = (i - k) + "-" + (j - l);
                                Integer count = map.getOrDefault(key, 0);
                                map.put(key, count + 1);
                            }
                        }
                    }
                }
            }
        }
        // 遍历 map 找到计数最多的那个
        int max = 0;
        for (int count : map.values()) {
            max = Math.max(max, count);
        }
        return max;
    }


	public static void main(String[] args) {
		Solution solution = new Solution();
        int[][] a = new int[][]{{1,1,0}, {0,1,0}, {0,1,0}};
        int[][] b = new int[][]{{0,0,0}, {0,1,1}, {0,0,1}};
        int result = solution.largestOverlap(a, b);
        System.out.println(result);
        Assert.assertEquals(3, result);
    }
}
