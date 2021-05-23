package com.potato.study.leetcodecn.p01013.t001;

import org.junit.Assert;

/**
 * 1013. 将数组分成和相等的三个部分
 *
 * 给你一个整数数组 A，只有可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。

 形式上，如果可以找出索引 i+1 < j 且满足 A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1] 就可以将数组三等分。

  

 示例 1：

 输入：[0,2,1,-6,6,-7,9,1,2,0,1]
 输出：true
 解释：0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
 示例 2：

 输入：[0,2,1,-6,6,7,9,-1,2,0,1]
 输出：false
 示例 3：

 输入：[3,3,6,5,-2,2,5,1,-9,4]
 输出：true
 解释：3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
  

 提示：

 3 <= A.length <= 50000
 -10^4 <= A[i] <= 10^4

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/partition-array-into-three-parts-with-equal-sum
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 按照顺序切分
     * @param arr
     * @return
     */
    public boolean canThreePartsEqualSum(int[] arr) {
        long sum = 0;
        for (int element : arr) {
            sum += element;
        }
        if (sum != sum / 3 * 3) {
            return false;
        }
        long average = sum / 3;
        int count = 0;
        long currentLoopSum = 0;

        for (int i = 0; i < arr.length; i++) {
            currentLoopSum += arr[i];
            if (currentLoopSum == average) {
                count++;
                currentLoopSum = 0;
            }
            if (count == 2 && i != arr.length - 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{0,2,1,-6,6,-7,9,1,2,0,1};
        boolean res = solution.canThreePartsEqualSum(arr);
        System.out.println(res);
        Assert.assertEquals(true, res);

        arr = new int[]{0,2,1,-6,6,7,9,-1,2,0,1};
        res = solution.canThreePartsEqualSum(arr);
        System.out.println(res);
        Assert.assertEquals(false, res);

        arr = new int[]{3,3,6,5,-2,2,5,1,-9,4};
        res = solution.canThreePartsEqualSum(arr);
        System.out.println(res);
        Assert.assertEquals(true, res);

        arr = new int[]{10,-10,10,-10,10,-10,10,-10};
        res = solution.canThreePartsEqualSum(arr);
        System.out.println(res);
        Assert.assertEquals(true, res);

        arr = new int[]{1,-1,1,-1};
        res = solution.canThreePartsEqualSum(arr);
        System.out.println(res);
        Assert.assertEquals(false, res);
    }
}
