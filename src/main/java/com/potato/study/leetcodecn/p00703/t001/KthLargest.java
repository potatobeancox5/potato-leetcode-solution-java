package com.potato.study.leetcodecn.p00703.t001;

import org.junit.Assert;

import java.util.PriorityQueue;

/**
 * 703. 数据流中的第 K 大元素
 *
 * 设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。

 请实现 KthLargest 类：

 KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
 int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。
  

 示例：

 输入：
 ["KthLargest", "add", "add", "add", "add", "add"]
 [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
 输出：
 [null, 4, 5, 5, 8, 8]

 解释：
 KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
 kthLargest.add(3);   // return 4
 kthLargest.add(5);   // return 5
 kthLargest.add(10);  // return 5
 kthLargest.add(9);   // return 8
 kthLargest.add(4);   // return 8
  

 提示：
 1 <= k <= 104
 0 <= nums.length <= 104
 -104 <= nums[i] <= 104
 -104 <= val <= 104
 最多调用 add 方法 104 次
 题目数据保证，在查找第 k 大元素时，数组中至少有 k 个元素

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/kth-largest-element-in-a-stream
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class KthLargest {

    private PriorityQueue<Integer> priorityQueue;
    private int k;

    /**
     * 用一个小根堆 存目前为止 的最大的k个元素
     * @param k
     * @param nums
     */
    public KthLargest(int k, int[] nums) {
        // 默认小根堆
        this.priorityQueue = new PriorityQueue<>();
        this.k = k;
        for (int i = 0; i < nums.length; i++) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(nums[i]);
                continue;
            }
            if (priorityQueue.peek() < nums[i]) {
                priorityQueue.add(nums[i]);
                priorityQueue.poll();
            }
        }
    }

    public int add(int val) {

        if (priorityQueue.size() < k) {
            priorityQueue.add(val);
        } else if (priorityQueue.peek() < val) {
            priorityQueue.add(val);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }

        if (priorityQueue.size() == k) {
            return priorityQueue.peek();
        }
        return -1;
    }

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        int add = kthLargest.add(3);
        System.out.println(add);
        Assert.assertEquals(4, add);

        add = kthLargest.add(5);
        System.out.println(add);
        Assert.assertEquals(5, add);


        add = kthLargest.add(10);
        System.out.println(add);
        Assert.assertEquals(5, add);


        add = kthLargest.add(9);
        System.out.println(add);
        Assert.assertEquals(8, add);


        add = kthLargest.add(4);
        System.out.println(add);
        Assert.assertEquals(8, add);


        // ["KthLargest","add","add","add","add","add"]
//[[1,[]],[-3],[-2],[-4],[0],[4]]

    }
}