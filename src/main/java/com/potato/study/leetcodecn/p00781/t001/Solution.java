package com.potato.study.leetcodecn.p00781.t001;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.potato.study.leetcode.domain.TreeNode;

/**
 * 781. 森林中的兔子
 *
 * 森林中，每个兔子都有颜色。其中一些兔子（可能是全部）告诉你还有多少其他的兔子和自己有相同的颜色。我们将这些回答放在 answers 数组里。
 *
 * 返回森林中兔子的最少数量。
 *
 * 示例:
 * 输入: answers = [1, 1, 2]
 * 输出: 5
 * 解释:
 * 两只回答了 "1" 的兔子可能有相同的颜色，设为红色。
 * 之后回答了 "2" 的兔子不会是红色，否则他们的回答会相互矛盾。
 * 设回答了 "2" 的兔子为蓝色。
 * 此外，森林中还应有另外 2 只蓝色兔子的回答没有包含在数组中。
 * 因此森林中兔子的最少数量是 5: 3 只回答的和 2 只没有回答的。
 *
 * 输入: answers = [10, 10, 10]
 * 输出: 11
 *
 * 输入: answers = []
 * 输出: 0
 * 说明:
 *
 * answers 的长度最大为1000。
 * answers[i] 是在 [0, 999] 范围内的整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rabbits-in-forest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 781
     *
     * https://leetcode-cn.com/problems/rabbits-in-forest/
     *
     * 遍历每个兔子的话
     *
     * 计算一下他们属于哪个圈子 圈子的余量是否充足 不充足 重新开一个圈子
     *
     * 圈子中人数
     * 已确认数量
     *
     * map key 圈子人数 还没ok的圈子
     *
     * count 计数
     * @param answers
     * @return
     */
    public int numRabbits(int[] answers) {
        // key 某种颜色兔子 的个数， list 有一种可能
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int num : answers) {
            num++;
            List<Integer> groupList = map.getOrDefault(num, new ArrayList<>());
            map.put(num, groupList);
            if (groupList.size() == 0) {
                // 创建一个新的颜色
                groupList.add(1);
                continue;
            }
            // 看看能不能放到之前的数组礼拜呢
            for (int i = 0; i < groupList.size(); i++) {
                Integer group = groupList.get(i);
                if (group < num) {
                    group++;
                    groupList.set(i, group);
                    break;
                }
                // 如果当前是最后一个了 需要再增加一个 否则 直接用之前的就行了
                if (i == groupList.size() - 1) {
                    groupList.add(1);
                    break;
                }
            }
        }
        // 计算最终有多少个兔子
        int total = 0;
        for (Map.Entry<Integer, List<Integer>> entry: map.entrySet()) {
            total += (entry.getKey() * entry.getValue().size());
        }
        return total;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] answers = new int[] {
                1, 1, 2
        };
        int i = solution.numRabbits(answers);
        System.out.println(i);
        Assert.assertEquals(5, i);

        answers = new int[] {
                10, 10, 10
        };
        i = solution.numRabbits(answers);
        System.out.println(i);
        Assert.assertEquals(11, i);

        answers = new int[] {
                2,1,2,2,2,2,2,2,1,1
        };
        i = solution.numRabbits(answers);
        System.out.println(i);
        Assert.assertEquals(13, i);
    }
}
