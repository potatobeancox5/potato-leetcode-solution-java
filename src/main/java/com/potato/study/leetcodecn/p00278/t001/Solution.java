package com.potato.study.leetcodecn.p00278.t001;

/**
 * 278. 第一个错误的版本
 *
 * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。

 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。

 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。

 示例:

 给定 n = 5，并且 version = 4 是第一个错误的版本。

 调用 isBadVersion(3) -> false
 调用 isBadVersion(5) -> true
 调用 isBadVersion(4) -> true

 所以，4 是第一个错误的版本。 

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/first-bad-version
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution extends VersionControl {

    /**
     * 二分法查找
     * @param n
     * @return
     */
    public int firstBadVersion(int n) {
        long left = 1;
        long right = n;
        long target = -1;
        while (left <= right) {
            long mid = (left + right) / 2;
            boolean isBad = isBadVersion((int)mid);
            if (isBad) {
                // 已经坏了，往前找
                right = mid - 1;
                target = mid;
            } else {
                // 没坏呢 使劲往后找
                left = mid + 1;
            }
        }
        return (int)target;
    }
}

class VersionControl {
    public boolean isBadVersion(int version) {
        return false;
    }
}
