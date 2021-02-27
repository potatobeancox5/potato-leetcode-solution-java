package com.potato.study.leetcodecn.p00093.t001;


import java.util.ArrayList;
import java.util.List;

/**
 * 93. 复原 IP 地址
 *
 * 给定一个只包含数字的字符串，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。

 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。

 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。

  

 示例 1：

 输入：s = "25525511135"
 输出：["255.255.11.135","255.255.111.35"]
 示例 2：

 输入：s = "0000"
 输出：["0.0.0.0"]
 示例 3：

 输入：s = "1111"
 输出：["1.1.1.1"]
 示例 4：

 输入：s = "010010"
 输出：["0.10.0.10","0.100.1.0"]
 示例 5：

 输入：s = "101023"
 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
  

 提示：

 0 <= s.length <= 3000
 s 仅由数字组成

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/restore-ip-addresses
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * dps 生成 有效ip 每个 段在 0 - 255 以内
     * @param s
     * @return
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        dfs(s, result, new ArrayList<>(), 0);
        return result;
    }

    /**
     *
     * @param s
     * @param result      有效的ip 结果集合
     * @param current     当前已经有的ip
     * @param index       下一个需要遍历的 位置
     */
    private void dfs(String s, List<String> result, List<Integer> current, int index) {
        // 达到终止条件了 终止
        if (current.size() == 4) {
            if (index == s.length()) {
                result.add(getIpFromNum(current));
            }
            // 不能构成合理的ip
            return;
        }
        // 从index 开始 依次 试一下3 中情况
        for (int i = 1; i <= 3; i++) {
            if (index + i > s.length()) {
                break;
            }

            if (i > 1 && s.charAt(index) == '0') {
                break;
            }
            // 获取 当前位置数字
            int num = Integer.parseInt(s.substring(index, index + i));
            if (num > 255) {
                continue;
            }
            // 新生成一个结果集合 加入新增的数字
            List<Integer> next = new ArrayList<>(current);
            next.add(num);
            dfs(s, result, next, index + i);
        }

    }

    /**
     *
     * @param current
     * @return
     */
    private String getIpFromNum(List<Integer> current) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            builder.append(current.get(i));
            if (i != 3) {
                builder.append(".");
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "25525511135";
        List<String> list = solution.restoreIpAddresses(s);
        // ["255.255.11.135","255.255.111.35"]
        System.out.println(list);

        s = "0000";
        list = solution.restoreIpAddresses(s);
        // "0.0.0.0"
        System.out.println(list);

        s = "010010";
        list = solution.restoreIpAddresses(s);
        // ["0.10.0.10","0.100.1.0"]
        System.out.println(list);
    }

}
