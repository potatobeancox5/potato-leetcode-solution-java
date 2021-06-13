package com.potato.study.leetcodecn.p00406.t001;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.potato.study.leetcode.domain.TreeNode;

/**
 * 406. 根据身高重建队列
 *
 * 假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。

 请你重新构造并返回输入数组 people 所表示的队列。返回的队列应该格式化为数组 queue ，其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。

  

 示例 1：

 输入：people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
 输出：[[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
 解释：
 编号为 0 的人身高为 5 ，没有身高更高或者相同的人排在他前面。
 编号为 1 的人身高为 7 ，没有身高更高或者相同的人排在他前面。
 编号为 2 的人身高为 5 ，有 2 个身高更高或者相同的人排在他前面，即编号为 0 和 1 的人。
 编号为 3 的人身高为 6 ，有 1 个身高更高或者相同的人排在他前面，即编号为 1 的人。
 编号为 4 的人身高为 4 ，有 4 个身高更高或者相同的人排在他前面，即编号为 0、1、2、3 的人。
 编号为 5 的人身高为 7 ，有 1 个身高更高或者相同的人排在他前面，即编号为 1 的人。
 因此 [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]] 是重新构造后的队列。
 示例 2：

 输入：people = [[6,0],[5,0],[4,0],[3,2],[2,2],[1,4]]
 输出：[[4,0],[5,0],[2,2],[3,2],[1,4],[6,0]]
  

 提示：

 1 <= people.length <= 2000
 0 <= hi <= 106
 0 <= ki < people.length
 题目数据确保队列可以被重建

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/queue-reconstruction-by-height
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 优先级队列 按照身高排序 降序 排列 然后
     * 排序规则，先按照 hi 降序排列 然后按照 ki 升序排列，
     * 遍历排列后的数组，然后 依次遍历，将遍历到的按照 方法哦 ki 位置 如果该位置没有 就直接放到对位，已经有的需要移动之后的
     * @param people
     * @return
     */
    public int[][] reconstructQueue(int[][] people) {
        // 优先级队列 按照身高排序 降序 排列 然后
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 身高降序
                if (o1[0] != o2[0]) {
                    return Integer.compare(o2[0], o1[0]);
                }
                return Integer.compare(o1[1], o2[1]);
            }
        });
        // 依次遍历，将遍历到的按照 方法哦 ki 位置 如果该位置没有 就直接放到对位，已经有的需要移动之后的
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < people.length; i++) {
            int[] person = people[i];
            if (person[1] >= list.size()) {
                list.add(person);
            } else {
                list.add(person[1], person);
            }
        }
        // list -> array
        int[][] res = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
