package com.potato.study.leetcode.domain;

/**
 * 数据结构并查集，能够查询 两个元素是不是在同一个结合中，或者对两个元素进行合并
 */
public class UnionFind {
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