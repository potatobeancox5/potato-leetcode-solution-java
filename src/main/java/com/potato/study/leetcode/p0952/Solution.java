package com.potato.study.leetcode.p0952;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author liuzhao11
 * 
 * 	952. Largest Component Size by Common Factor
 *  
 *       Given a non-empty array of unique positive integers A, consider the following graph:

There are A.length nodes, labelled A[0] to A[A.length - 1];
There is an edge between A[i] and A[j] if and only if A[i] and A[j] share a common factor greater than 1.
Return the size of the largest connected component in the graph.



Example 1:

Input: [4,6,15,35]
Output: 4

Example 2:

Input: [20,50,9,63]
Output: 2

Example 3:

Input: [2,3,6,7,4,12,21,39]
Output: 8

Note:

1 <= A.length <= 20000
1 <= A[i] <= 100000
 *         
 *         题目含义：
 *          按公因数计算最大组件大小
 *          是否连通是按照是否有公因数 判定的
 *
 *         思路：
 *
 *          https://leetcode-cn.com/problems/largest-component-size-by-common-factor/solution/an-gong-yin-shu-ji-suan-zui-da-zu-jian-da-xiao-by-/
 *
 *          提取数组 AA 中每个数的质因数，对每个质因数建立索引。接着，用并查集把 AA 中的质因数合并起来。最后计算每个集合的大小。
 *
 * 
 */
public class Solution {

    public int largestComponentSize(int[] arr) {

        int n = arr.length;

        // factored[i] = a list of unique prime factors of A[i]
        List<Integer>[] factored = new ArrayList[n];
        for (int i = 0; i < n; ++i) {
            factored[i] = new ArrayList<>();
            int d = 2;
            int x = arr[i];
            while (d * d <= x) {
                if (x % d == 0) {
                    while (x % d == 0) {
                        x /= d;
                    }
                    factored[i].add(d);
                }
                d++;
            }

            if (x > 1 || factored[i].isEmpty())
                factored[i].add(x);
        }

        // primesL : a list of all primes that occur in factored
        Set<Integer> primes = new HashSet<>();
        for (List<Integer> facs: factored)
            for (int x: facs) {
                primes.add(x);
            }

        int[] primesL = new int[primes.size()];
        int t = 0;
        for (int x: primes) {
            primesL[t++] = x;
        }

        // primeToIndex.get(v) == i  iff  primes[i] = v
        Map<Integer, Integer> primeToIndex = new HashMap<>();
        for (int i = 0; i < primesL.length; ++i)
            primeToIndex.put(primesL[i], i);

        UnionFind dsu = new UnionFind(primesL.length);
        for (List<Integer> facs: factored) {
            for (int x: facs) {
                dsu.union(primeToIndex.get(facs.get(0)), primeToIndex.get(x));
            }
        }

        int[] count = new int[primesL.length];
        for (List<Integer> facs: factored) {
            count[dsu.find(primeToIndex.get(facs.get(0)))]++;
        }

        int ans = 0;
        for (int x: count) {
            if (x > ans) {
                ans = x;
            }
        }
        return ans;
    }


    class UnionFind {
        int[] parent;
        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; ++i) {
                parent[i] = i;
            }
        }
        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        public void union(int x, int y) {
            parent[find(x)] = find(y);
        }
    }


    public static void main(String[] args) {
		Solution solution = new Solution();

        int[] arr = new int[]{4,6,15,35};
        int res = solution.largestComponentSize(arr);
        System.out.println(res);
        Assert.assertEquals(4, res);
    }
}
