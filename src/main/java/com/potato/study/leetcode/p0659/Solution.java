package com.potato.study.leetcode.p0659;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 
 * @author liuzhao11
 * 
 *         659. Split Array into Consecutive Subsequences
 * 
 *         Given an array nums sorted in ascending order, return true if and only if you can split it into 1 or more subsequences such that each subsequence consists of consecutive integers and has length at least 3.



Example 1:

Input: [1,2,3,3,4,5]
Output: True
Explanation:
You can split them into two consecutive subsequences :
1, 2, 3
3, 4, 5

Example 2:

Input: [1,2,3,3,4,4,5,5]
Output: True
Explanation:
You can split them into two consecutive subsequences :
1, 2, 3, 4, 5
3, 4, 5

Example 3:

Input: [1,2,3,4,4,5]
Output: False


Constraints:

1 <= nums.length <= 10000



思路：
 *  给定一个已经按照升序排列的数组

如果这个数组中 可以被分解成任意3个元素以上的部分 那么返回true
如果有任意不能的 返回false



https://blog.csdn.net/fuxuemingzhu/article/details/82185011




https://www.jianshu.com/p/b910737af4dc

 *  先遍历数组得到每个num出现的frequency。
对于每个num来说，要么将它append到已经成型的sequence中，要么以它为起点开辟一个新的长度为3的sequence。如果两者皆不可行，则返回false。
 *
 *
 *  使用 Map key : 已key结尾的组  value : 优先队列存储已key结尾的组的个数
 *  https://blog.csdn.net/sunday0904/article/details/78174122
 */
public class Solution {

    public boolean isPossible(int[] nums) {

        Map<Integer, PriorityQueue<Integer>> lastNum2ArrayLengthMap = new HashMap<>();
        // 1. 遍历 nums 对于每个 num
        for (int num : nums) {
            // 2. 获取 以 num-1 结尾的优先队列 个数
            PriorityQueue<Integer> queue = getQueueByLastElement(num - 1, lastNum2ArrayLengthMap);
            // 3. 如果没有的话 计算成1 有的话 pop 最小的那个 然后 增加之后加入 以num结尾的队列里
            PriorityQueue<Integer> curQueue = getQueueByLastElement(num, lastNum2ArrayLengthMap);
            if (queue.size() == 0) {
                curQueue.add(1);
            } else {
                Integer minLen = queue.poll();
                curQueue.add(minLen + 1);
            }
        }

        // 4. 最终遍历map 找到如果存在少于 3 的元素 返回false
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : lastNum2ArrayLengthMap.entrySet()) {
            PriorityQueue<Integer> lenQueue = entry.getValue();
            for (Integer len : lenQueue) {
                if (len < 3) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 获取 以 lastElement 结尾的元组长度
     * @param lastElement
     */
    private PriorityQueue<Integer> getQueueByLastElement(int lastElement,
                                                         Map<Integer, PriorityQueue<Integer>> lastNum2ArrayLengthMap) {

        PriorityQueue<Integer> queue = lastNum2ArrayLengthMap.get(lastElement);
        if (queue == null) {
            queue = new PriorityQueue<>();
            lastNum2ArrayLengthMap.put(lastElement, queue);
        }
        return queue;
    }

	
	public static void main(String[] args) {
		Solution solution = new Solution();

        int[] nums = {1,2,3,3,4,5};

        boolean result = solution.isPossible(nums);
        System.out.println(result);
        Assert.assertEquals(true, result);


        int[] nums1 = {1,2,3,3,4,4,5,5};
        result = solution.isPossible(nums1);
        System.out.println(result);
        Assert.assertEquals(true, result);


        int[] nums2 = {1,2,3,4,4,5};
        result = solution.isPossible(nums2);
        System.out.println(result);
        Assert.assertEquals(false, result);


    }
}
