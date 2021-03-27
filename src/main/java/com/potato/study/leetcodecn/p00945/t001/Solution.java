package com.potato.study.leetcodecn.p00945.t001;

import org.junit.Assert;

/**
 * 945. 使数组唯一的最小增量
 *
 * 给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。

 返回使 A 中的每个值都是唯一的最少操作次数。

 示例 1:

 输入：[1,2,2]
 输出：1
 解释：经过一次 move 操作，数组将变为 [1, 2, 3]。
 示例 2:

 输入：[3,2,1,2,1,7]
 输出：6
 解释：经过 6 次 move 操作，数组将变为 [3, 4, 1, 2, 5, 7]。
 可以看出 5 次或 5 次以下的 move 操作是不能让数组的每个值唯一的。
 提示：

 0 <= A.length <= 40000
 0 <= A[i] < 40000

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/minimum-increment-to-make-array-unique
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 使用数组记录出现次数 800001个 防止都是 40000
     * 使用 step 记录出现次数
     * 遍历记录次数，
     *  如果出现了多次 记录多出现的次数 surplus 减去 step = step - surplus * 数字
     *  如果只出现一次 continue
     *  如果没有出现 检查下目前 surplus 是否为 0
     *      0 的话 continue
     *      非 0 的话 step += 当前数字
     *
     * @param arr
     * @return
     */
    public int minIncrementForUnique(int[] arr) {
        // 防止有 40000个 40000
        int[] count = new int[80001];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        int surplus = 0;
        int step = 0;
        for (int i = 0; i < 80001; i++) {
            if (count[i] > 1) {
                surplus += (count[i] - 1);
                step -= (count[i] - 1) * i;
            } else if (count[i] == 0) {
                if (surplus > 0) {
                    surplus--;
                    step += i;
                }
            }
        }
        return step;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[] {
                1,2,2
        };
        int res = solution.minIncrementForUnique(arr);
        System.out.println(res);
        Assert.assertEquals(1, res);


        arr = new int[] {
                3,2,1,2,1,7
        };
        res = solution.minIncrementForUnique(arr);
        System.out.println(res);
        Assert.assertEquals(6, res);
    }
}
