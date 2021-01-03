package com.potato.study.algorthmic.skeleton;

import org.junit.Test;

import java.util.Random;

/**
 * 算法骨架 —— 蓄水池抽样算法
 * https://www.yuque.com/potatobeancox/ddxd8f/davepm
 */
public class ReservoirSampling {

    /**
     * 蓄水池采样的算法骨架
     */
    @Test
    public void test () {
        // 1 输入超大的数组 input[] ，从 input 中采样 m个数据，要求 样本被采样到的概率是 m/input.length
        int n = 1000;
        int[] input = new int[n];
        int m = 10;
        int[] sample = new int[m];
        Random random = new Random();
        // 2 声明一个 m大小的数组，对应 index 小于 m的情况直接插入，index大于m时，的i radom （0， i），随机数小于m进行替换，否则下一个
        for (int i = 0; i < n; i++) {
            if (i < m) {
                sample[i] = input[i];
            } else {
                // 随机获取 0 - i 索引 between 0 (inclusive) and the specified value (exclusive)
                int d = random.nextInt(i + 1);
                // 小于 m 可以交换 否则 放弃了
                if (d < m) {
                    sample[d] = input[i];
                }
            }

        }
        // 3 业务逻辑， 一般是 从m 中 随机取出来一个数字
        int index = random.nextInt(m);
        System.out.println(sample[index]);
    }
}
