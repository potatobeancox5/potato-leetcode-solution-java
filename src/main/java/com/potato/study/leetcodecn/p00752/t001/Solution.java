package com.potato.study.leetcodecn.p00752.t001;

import org.junit.Assert;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 752. 打开转盘锁
 *
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。

 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。

 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。

 字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。

  

 示例 1:

 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 输出：6
 解释：
 可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
 注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
 因为当拨动到 "0102" 时这个锁就会被锁定。
 示例 2:

 输入: deadends = ["8888"], target = "0009"
 输出：1
 解释：
 把最后一位反向旋转一次即可 "0000" -> "0009"。
 示例 3:

 输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
 输出：-1
 解释：
 无法旋转到目标数字且不被锁定。
 示例 4:

 输入: deadends = ["0000"], target = "8888"
 输出：-1
  

 提示：

 死亡列表 deadends 的长度范围为 [1, 500]。
 目标数字 target 不会在 deadends 之中。
 每个 deadends 和 target 中的字符串的数字会在 10,000 个可能的情况 '0000' 到 '9999' 中产生。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/open-the-lock
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 使用 bfs的 思想
     * 初始 为 0000 ，
     * 类似层序遍历
     * 每层的元素 出队时 判断 相邻的 4 * 2 是不是 锁死 或者访问过的，都不是的话 入队，
     * 如果碰到了 target 就直接返回 当前的次数
     * 需要使用一个 visited 记录 当前这个组合有没有被入队过，set 直接存 string
     * @param deadends
     * @param target
     * @return
     */
    public int openLock(String[] deadends, String target) {
        if (null == target) {
            return -1;
        }
        // 初始化 lock set
        Set<String> lockSet = new HashSet<>();
        if (null != deadends) {
            for (String lock : deadends) {
                lockSet.add(lock);
            }
        }
        if (lockSet.contains(target) || lockSet.contains("0000")) {
            return -1;
        }
        if (target.equals("0000")) {
            return 0;
        }
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add("0000");
        visited.add("0000");
        int step = 1;
        while (!queue.isEmpty()) {
            // the size of this layer
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                String current = queue.poll();
                // 相邻的元素
                char[] chars = current.toCharArray();
                // 生成 8 个新字符串
                for (int j = 0; j < 4; j++) {
                    if (chars[j] == '0') {
                        chars[j] += 1;
                        String target1 = new String(chars);
                        if (target.equals(target1)) {
                            return step;
                        }
                        // 访问过 过着 锁定 这个结果不能用了
                        if (!visited.contains(target1) && !lockSet.contains(target1)) {
                            queue.add(target1);
                            visited.add(target1);
                        }
                        chars[j] = '9';
                        String target2 = new String(chars);
                        if (target.equals(target2)) {
                            return step;
                        }
                        if (!visited.contains(target2) && !lockSet.contains(target2)) {
                            queue.add(target2);
                            visited.add(target2);
                        }
                    } else if (chars[j] == '9') {
                        chars[j] -= 1;
                        String target1 = new String(chars);
                        if (target.equals(target1)) {
                            return step;
                        }
                        // 访问过 过着 锁定 这个结果不能用了
                        if (!visited.contains(target1) && !lockSet.contains(target1)) {
                            queue.add(target1);
                            visited.add(target1);
                        }
                        chars[j] = '0';
                        String target2 = new String(chars);
                        if (target.equals(target2)) {
                            return step;
                        }
                        if (!visited.contains(target2) && !lockSet.contains(target2)) {
                            queue.add(target2);
                            visited.add(target2);
                        }
                    } else {
                        chars[j] += 1;
                        String target1 = new String(chars);
                        if (target.equals(target1)) {
                            return step;
                        }
                        // 访问过 过着 锁定 这个结果不能用了
                        if (!visited.contains(target1) && !lockSet.contains(target1)) {
                            queue.add(target1);
                            visited.add(target1);
                        }
                        chars[j] -= 2;
                        String target2 = new String(chars);
                        if (target.equals(target2)) {
                            return step;
                        }
                        if (!visited.contains(target2) && !lockSet.contains(target2)) {
                            queue.add(target2);
                            visited.add(target2);
                        }
                    }
                    // 恢复原始
                    chars = current.toCharArray();
                }
            }
            step++;
        }
        // 都已经完了 都没找到 直接返回 找不到
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] deadends = new String[] {"0201","0101","0102","1212","2002"};
        String target = "0202";
        int step = solution.openLock(deadends, target);
        System.out.println(step);
        Assert.assertEquals(6, step);


        deadends = new String[] {"8888"};
        target = "0009";
        step = solution.openLock(deadends, target);
        System.out.println(step);
        Assert.assertEquals(1, step);


        deadends = new String[] {"0000"};
        target = "8888";
        step = solution.openLock(deadends, target);
        System.out.println(step);
        Assert.assertEquals(-1, step);

    }
}
