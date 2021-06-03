package com.potato.study.leetcodecn.p00914.t001;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.junit.Assert;

/**
 * 914. 卡牌分组
 *
 * 给定一副牌，每张牌上都写着一个整数。

 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：

 每组都有 X 张牌。
 组内所有的牌上都写着相同的整数。
 仅当你可选的 X >= 2 时返回 true。

  

 示例 1：

 输入：[1,2,3,4,4,3,2,1]
 输出：true
 解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
 示例 2：

 输入：[1,1,1,2,2,2,3,3]
 输出：false
 解释：没有满足要求的分组。
 示例 3：

 输入：[1]
 输出：false
 解释：没有满足要求的分组。
 示例 4：

 输入：[1,1]
 输出：true
 解释：可行的分组是 [1,1]
 示例 5：

 输入：[1,1,2,2,2,2]
 输出：true
 解释：可行的分组是 [1,1]，[2,2]，[2,2]

 提示：

 1 <= deck.length <= 10000
 0 <= deck[i] < 10000

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/x-of-a-kind-in-a-deck-of-cards
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * map 计数 找到最小的那个count —— min 看一下 其他的count 是不是都是 他的倍数
     * @param deck
     * @return
     */
    public boolean hasGroupsSizeX(int[] deck) {
        if (null == deck || deck.length == 0) {
            return true;
        }
        Map<Integer, Integer> countMap = new HashMap<>();
        int maxCount = Integer.MIN_VALUE;
        for (int num : deck) {
            Integer count = countMap.getOrDefault(num, 0);
            count++;
            countMap.put(num, count);
            maxCount = Math.max(maxCount, count);
        }
        List<Integer> countList = new ArrayList<>(countMap.values());
        if (0 == countList.size()) {
            return false;
        }
        // 找到最小的 count 求他的因数 然后判定 每个因数 是不是其他count 的因数 （找到整个数组的公因数）
        boolean[] isPrime = new boolean[maxCount+1];
        Arrays.fill(isPrime, true);
        for (int i = 2; i <= maxCount; i++) {
            if (isPrime[i]) {
                // 遍历 countList 看看 是不是都能 整除
                boolean isValid = true;
                for (int val : countList) {
                    if (val % i != 0) {
                        isValid = false;
                    }
                }
                // 已经有了可以整除的
                if (isValid) {
                    return isValid;
                }
                // i * i 开始设置非素数
                for (int j = i; j * i <= maxCount; j++) {
                    isPrime[j * i] = false;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[] {1,2,3,4,4,3,2,1};
        boolean res = solution.hasGroupsSizeX(arr);
        System.out.println(res); // [4,5,2,7]
        Assert.assertEquals(true, res);

        arr = new int[] {1,1,1,2,2,2,3,3};
        res = solution.hasGroupsSizeX(arr);
        System.out.println(res); // [4,5,2,7]
        Assert.assertEquals(false, res);
    }


}
