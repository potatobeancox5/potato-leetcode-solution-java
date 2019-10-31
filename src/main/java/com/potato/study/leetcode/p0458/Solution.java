package com.potato.study.leetcode.p0458;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 *   458. Poor Pigs
 * 
 *      There are 1000 buckets, one and only one of them is poisonous, while the rest are filled with water. They all look identical. If a pig drinks the poison it will die within 15 minutes. What is the minimum amount of pigs you need to figure out which bucket is poisonous within one hour?

Answer this question, and write an algorithm for the general case.



General case:

If there are n buckets and a pig drinking poison will die within m minutes, how many pigs (x) you need to figure out the poisonous bucket within p minutes? There is exactly one bucket with poison.



Note:

A pig can be allowed to drink simultaneously on as many buckets as one would like, and the feeding takes no time.
After a pig has instantly finished drinking buckets, there has to be a cool down time of m minutes. During this time, only observation is allowed and no feedings at all.
Any given bucket can be sampled an infinite number of times (by an unlimited number of pigs).
 * 
 *         思路：
 *
 *         458. Poor Pigs

https://blog.csdn.net/wilschan0201/article/details/72519147

神仙题
一个猪 一小时可以试5桶水

两个猪 可以覆盖25

3个覆盖125

5^n= 水桶
求n

求没个猪能覆盖的次数 n= tets/time +1

tmp = n
count =1

while count 《 bucketsnum

if tmp 》=bucketsnum
return count
tmp * = n
count++
 *          
 *          
 * 			
 * 				
 */	
public class Solution {

    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        if (buckets == 1) {
            return 0;
        }
        int eachPigTryCount = minutesToTest / minutesToDie + 1;
        long tmp = eachPigTryCount;
        int count = 1;
        while (tmp < buckets) {
            tmp *= eachPigTryCount;
            count++;
        }
        return count;
    }
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
        int buckets = 1;
        int minutesToDie = 1;
        int minutesToTest = 1;
		int res = solution.poorPigs(buckets, minutesToDie, minutesToTest);
		System.out.println(res);
        Assert.assertEquals("", 0, res);


        buckets = 1000;
        minutesToDie = 15;
        minutesToTest = 60;
        res = solution.poorPigs(buckets, minutesToDie, minutesToTest);
        System.out.println(res);
        Assert.assertEquals("", 5, res);

    }
}
