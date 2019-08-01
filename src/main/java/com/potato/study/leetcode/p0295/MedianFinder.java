package com.potato.study.leetcode.p0295;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
 * @author liuzhao11
 *
 * 295. Find Median from Data Stream
 * 
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

For example,
[2,3,4], the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.


Example:

addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3)
findMedian() -> 2


Follow up:

If all integer numbers from the stream are between 0 and 100, how would you optimize it?
If 99% of all integer numbers from the stream are between 0 and 100, how would you optimize it?*
* 
* 思路：
 *
 * 295. Find Median from Data Stream

https://www.jianshu.com/p/43215858de12

两个堆

一个小根堆存放大的数字 一个大根堆存放小于mid的数字

add 时 为了 保证初始态 maxsize 》=minsize
先往小根堆放 max 此时max比min多1或者2
max选出最小的 放到min中 此时 max 少1或者相等
如果max 小于min时 说明min中加了个数
为了保证min数比mid小 pop最大的 放入max


每次求中间数
奇数时 从maxpop，size偶数 分别pop 然后求ave
**
*
 */
public class MedianFinder {

    /** initialize your data structure here. */
    // 小根堆
    private PriorityQueue<Integer> biggerThanMidQueue;
    // 大根堆
    private PriorityQueue<Integer> smallerThanMidQueue;
    // 保证 biggerThanMidQueue 大于 等于 smallerThanMidQueue 且 不能大多于1


    public MedianFinder() {
        biggerThanMidQueue = new PriorityQueue<>();
        smallerThanMidQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
    }

    public void addNum(int num) {
        biggerThanMidQueue.add(num);
        // 放了之后 b > s 多1 或者2 这种情况，洗一下small
        smallerThanMidQueue.add(biggerThanMidQueue.poll());
        if (biggerThanMidQueue.size() < smallerThanMidQueue.size()) {
            biggerThanMidQueue.add(smallerThanMidQueue.poll());
        }
    }

    public double findMedian() {
        int len = biggerThanMidQueue.size() + smallerThanMidQueue.size();
        if (len % 2 == 1) {
            return biggerThanMidQueue.peek();
        } else {
            return (1.0 * biggerThanMidQueue.peek() + smallerThanMidQueue.peek()) / 2.0;
        }
    }


    public static void main(String[] args) {
//        MedianFinder medianFinder = new MedianFinder();
    }
}
