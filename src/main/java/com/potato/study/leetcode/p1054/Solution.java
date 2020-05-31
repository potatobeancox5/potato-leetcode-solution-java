package com.potato.study.leetcode.p1054;


import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 
 * @author liuzhao11
 * 
 * 	1054. Distant Barcodes
 *  
 *        In a warehouse, there is a row of barcodes, where the i-th barcode is barcodes[i].

Rearrange the barcodes so that no two adjacent barcodes are equal.  You may return any answer, and it is guaranteed an answer exists.



Example 1:

Input: [1,1,1,2,2,2]
Output: [2,1,2,1,2,1]
Example 2:

Input: [1,1,1,1,2,2,3,3]
Output: [1,3,1,3,2,1,2,1]


Note:

1 <= barcodes.length <= 10000
1 <= barcodes[i] <= 10000
 *         
 *
 *       题目含义：
 *
 *          https://leetcode-cn.com/problems/distant-barcodes/solution/tan-xin-dui-by-ha-qi-lou-ku/
 *
 */
public class Solution {


    public int[] rearrangeBarcodes(int[] barcodes) {
        if(barcodes == null || barcodes.length < 2) {
            return barcodes;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : barcodes) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        //大顶堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        for(int i : map.keySet()) {
            maxHeap.add(i);
        }
        int[] res = new int[barcodes.length];
        int idx = 0;
        while(maxHeap.size() > 1) {
            int a = maxHeap.poll();
            int b = maxHeap.poll();
            res[idx++] = a;
            res[idx++] = b;
            int freqA = map.get(a);
            int freqB = map.get(b);
            if(freqA > 1) {
                map.put(a, freqA - 1);
                maxHeap.add(a);
            }
            if(freqB > 1) {
                map.put(b, freqB - 1);
                maxHeap.add(b);
            }
        }
        //收尾
        if(maxHeap.size() > 0) {
            res[idx] = maxHeap.poll();
        }
        return res;
    }
}
