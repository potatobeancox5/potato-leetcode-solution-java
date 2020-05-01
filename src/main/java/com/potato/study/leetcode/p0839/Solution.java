package com.potato.study.leetcode.p0839;

import org.junit.Assert;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author liuzhao11
 * 
 * 	839. Similar String Groups
 *  
 *         Two strings X and Y are similar if we can swap two letters (in different positions) of X, so that it equals Y. Also two strings X and Y are similar if they are equal.

For example, "tars" and "rats" are similar (swapping at positions 0 and 2), and "rats" and "arts" are similar, but "star" is not similar to "tars", "rats", or "arts".

Together, these form two connected groups by similarity: {"tars", "rats", "arts"} and {"star"}.  Notice that "tars" and "arts" are in the same group even though they are not similar.  Formally, each group is such that a word is in the group if and only if it is similar to at least one other word in the group.

We are given a list A of strings.  Every string in A is an anagram of every other string in A.  How many groups are there?



Example 1:

Input: A = ["tars","rats","arts","star"]
Output: 2


Constraints:

1 <= A.length <= 2000
1 <= A[i].length <= 1000
A.length * A[i].length <= 20000
All words in A consist of lowercase letters only.
All words in A have the same length and are anagrams of each other.
The judging time limit has been increased for this question.
 *         
 *         思路：
 *          https://leetcode-cn.com/problems/similar-string-groups/solution/javaunion-find-mo-ban-hua-de-bing-cha-ji-jie-fa-by/
 * 
 */
public class Solution {

    public int numSimilarGroups(String[] arr) {
        // set 去重复用
        Set<String> set = new HashSet(Arrays.asList(arr));
        arr = set.toArray(new String[set.size()]);
        // 遍历 去重后数组 两两比较 如果 相似 那么 加入并查集合
        UnionFind unionFind = new UnionFind(arr.length);

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 1; j < arr.length; j++) {
                if (isSimalar(arr[i], arr[j])) {
                    unionFind.union(i, j);
                }
            }
        }

        return unionFind.rootSize;
    }

    private boolean isSimalar (String word1, String word2) {
        if (word1 == null && word2 == null) {
            return true;
        }
        if (word1.length() != word2.length()) {
            return false;
        }
        int diffCoount = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diffCoount++;
            }
        }
        return diffCoount <= 2;
    }

    /**
     * 通用并查集数据结构
     */
    class UnionFind {
        // index 节点的 祖先节点
        public int[] parent;
        // 集合大小
        public int rootSize;


        /**
         * 构造size大小的并查集
         * @param size
         */
        public UnionFind(int size) {
            parent = new int[size];
            rootSize = size;
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        /**
         * 将 p q 加入并查集
         * @param p
         * @param q
         */
        public void union(int p, int q) {
            // 找到 pq的父节点
            int rootPIndex = find(p);
            int rootQIndex = find(q);
            // 如果父亲节点不同 那么 设置 q的祖先节点的肤浅为p的祖先
            if (rootPIndex != rootQIndex) {
                parent[rootPIndex] = rootQIndex;
                rootSize--;
            }
        }

        /**
         * 找到 target 节点在并查集中的祖先
         * @param target
         * @return
         */
        public int find(int target) {
            int p = target;
            while (parent[p] != p) {
                p = parent[parent[p]];
            }
            return p;
        }

    }


	public static void main(String[] args) {
		Solution solution = new Solution();

        String[] a = new String[]{"tars","rats","arts","star"};
        int result = solution.numSimilarGroups(a);
        System.out.println(result);
        Assert.assertEquals(2, result);
    }
}
