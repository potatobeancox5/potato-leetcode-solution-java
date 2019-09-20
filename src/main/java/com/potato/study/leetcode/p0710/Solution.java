package com.potato.study.leetcode.p0710;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * 
 * @author liuzhao11
 * 
 * 	710. Random Pick with Blacklist
 *  
 *         Given a blacklist B containing unique integers from [0, N),
 *         write a function to return a uniform random integer from [0, N) which is NOT in B.

Optimize it such that it minimizes the call to system’s Math.random().

Note:

1 <= N <= 1000000000
0 <= B.length < min(100000, N)
[0, N) does NOT include N. See interval notation.
Example 1:

Input:
["Solution","pick","pick","pick"]
[[1,[]],[],[],[]]
Output: [null,0,0,0]
Example 2:

Input:
["Solution","pick","pick","pick"]
[[2,[]],[],[],[]]
Output: [null,1,1,1]
Example 3:

Input:
["Solution","pick","pick","pick"]
[[3,[1]],[],[],[]]
Output: [null,0,0,2]
Example 4:

Input:
["Solution","pick","pick","pick"]
[[4,[2]],[],[],[]]
Output: [null,1,3,1]
Explanation of Input Syntax:

The input is two lists: the subroutines called and their arguments.
Solution's constructor has two arguments, N and the blacklist B. pick has no arguments.
Arguments are always wrapped with a list, even if there aren't any.
 *         
 *         思路：
 *          建立一个 map 映射 [0, N - black.size ) 到 白名单的映射
 *         
 *
 *
 * 
 */
public class Solution {

    /**
     * 白名单，key 是数字index ，value是对应的值
     */
    private Set<Integer> blackSet  = new HashSet<>();

    private Random random = new Random();

    private int n;

    public Solution(int n, int[] blacklist) {
        this.n = n;
        // 弄一个black set
        if (null != blacklist) {
            for (int blackNum : blacklist) {
                blackSet.add(blackNum);
            }
        }
    }

    public int pick() {
        // 每次生成一个随机数 然后从map中取
        int nextNum = random.nextInt(n);
        while (blackSet.contains(nextNum)) {
            nextNum = random.nextInt(n);
        }
        return nextNum;
    }
	

	
	public static void main(String[] args) {

        int n = 3;
        int[] blacklist = {2};

		Solution solution = new Solution(n, blacklist);

        for (int i = 0; i < 10; i++) {
            System.out.println(solution.pick());
        }

    }
}
