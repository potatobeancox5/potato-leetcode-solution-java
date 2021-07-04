package com.potato.study.leetcodecn.p00825.t001;

import org.junit.Assert;

import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * 825. 适龄的朋友
 *
 * 人们会互相发送好友请求，现在给定一个包含有他们年龄的数组，ages[i] 表示第 i 个人的年龄。

 当满足以下任一条件时，A 不能给 B（A、B不为同一人）发送好友请求：

 age[B] <= 0.5 * age[A] + 7
 age[B] > age[A]
 age[B] > 100 && age[A] < 100
 否则，A 可以给 B 发送好友请求。

 注意如果 A 向 B 发出了请求，不等于 B 也一定会向 A 发出请求。而且，人们不会给自己发送好友请求。 

 求总共会发出多少份好友请求?

  

 示例 1：

 输入：[16,16]
 输出：2
 解释：二人可以互发好友申请。
 示例 2：

 输入：[16,17,18]
 输出：2
 解释：好友请求可产生于 17 -> 16, 18 -> 17.
 示例 3：

 输入：[20,30,100,110,120]
 输出：3
 解释：好友请求可产生于 110 -> 100, 120 -> 110, 120 -> 100.
  

 提示：

 1 <= ages.length <= 20000
 1 <= ages[i] <= 120

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/friends-of-appropriate-ages
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     *
     * https://leetcode-cn.com/problems/friends-of-appropriate-ages/solution/gua-ling-de-peng-you-by-leetcode/
     * 利用 1 <= ages[i] <= 120 进行优化
     * 将年龄进行计数
     * 遍历 计数数组
     *  如果满足 条件 （index 之间）
     *  那么就有 数组value乘积可以， 如果 遍历的两个 index 相同 还得减一下 因为 自己不能和自己成为朋友
     * @param ages
     * @return
     */
    public int numFriendRequests(int[] ages) {

        int[] count = new int[121];
        for (int age : ages) {
            count[age]++;
        }
        int friendNum = 0;
        for (int i = 0; i < 121; i++) {
            for (int j = 0; j < 121; j++) {
                if (j <= 0.5 * i + 7) {
                    continue;
                }
                if (j > i) {
                    continue;
                }
                if (j > 100 && i < 100) {
                    continue;
                }
                // 计数
                if (i == j) {
                    friendNum += count[i] * (count[i]-1);
                } else {
                    friendNum += count[i] * count[j];
                }

            }
        }
        return friendNum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[] {
                16,16
        };
        int i = solution.numFriendRequests(nums);
        System.out.println(i);
        Assert.assertEquals(2, i);

        nums = new int[] {
                16,17,18
        };
        i = solution.numFriendRequests(nums);
        System.out.println(i);
        Assert.assertEquals(2, i);
    }
}
