package com.potato.study.leetcodecn.p00401.t001;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * 401. 二进制手表
 *
 * 二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。每个 LED 代表一个 0 或 1，最低位在右侧。
 *
 * 例如，下面的二进制手表读取 "3:25" 。
 *
 *
 * （图源：WikiMedia - Binary clock samui moon.jpg ，许可协议：Attribution-ShareAlike 3.0 Unported (CC BY-SA 3.0) ）
 *
 * 给你一个整数 turnedOn ，表示当前亮着的 LED 的数量，返回二进制手表可以表示的所有可能时间。你可以 按任意顺序 返回答案。
 *
 * 小时不会以零开头：
 *
 * 例如，"01:00" 是无效的时间，正确的写法应该是 "1:00" 。
 * 分钟必须由两位数组成，可能会以零开头：
 *
 * 例如，"10:2" 是无效的时间，正确的写法应该是 "10:02" 。
 *  
 *
 * 示例 1：
 *
 * 输入：turnedOn = 1
 * 输出：["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]
 * 示例 2：
 *
 * 输入：turnedOn = 9
 * 输出：[]
 *  
 *
 * 提示：
 *
 * 0 <= turnedOn <= 10
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-watch
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {


    /**
     * 反向枚举
     * 按照数字枚举 然后 获取数字中有多少个1的位置 进行 计算和
     * @param turnedOn
     * @return
     */
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i <= 11; i++) {
            for (int j = 0; j <= 59; j++) {
                int oneBitCount = getOneBitCount(i, j);
                // 数量相等生成结果
                if (oneBitCount == turnedOn) {
                    StringBuilder builder = new StringBuilder();
                    builder.append(i);
                    builder.append(":");
                    if (j < 10) {
                        builder.append(0).append(j);
                    } else {
                        builder.append(j);
                    }
                    result.add(builder.toString());
                }
            }
        }
        return result;
    }

    /**
     * 获取ij 中 bit 为1的数量和
     * @param i
     * @param j
     * @return
     */
    private int getOneBitCount(int i, int j) {
        int count = 0;
        while (i != 0) {
            if ((i & 1) == 1) {
                count++;
            }
            i >>>= 1;
        }
        while (j != 0) {
            if ((j & 1) == 1) {
                count++;
            }
            j >>>= 1;
        }
        return count;
    }
}
