package com.potato.study.leetcodecn.p00914.t001;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public boolean hasGroupsSizeX(int[] deck) {
        if (null == deck || deck.length == 0) {
            return true;
        }
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : deck) {
            Integer count = countMap.getOrDefault(num, 0);
            count++;
            countMap.put(num, count);
        }
        // 遍历 比较能够构成
        List<Integer> countList = new ArrayList<>(countMap.values());
        int target = countList.get(0);
        if (target == 1) {
            return false;
        }
        for (int i = 1; i < countList.size(); i++) {
            if (countList.get(i) != target) {
                return false;
            }
        }
        return true;
    }

//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        int[] arr = new int[] {4,2,5,7};
//        int[] ints = solution.sortArrayByParityII(arr);
//        System.out.println(Arrays.toString(ints)); // [4,5,2,7]
//
//
//        arr = new int[] {2,0,3,4,1,3};
//        ints = solution.sortArrayByParityII(arr);
//        System.out.println(Arrays.toString(ints)); // [2,3,0,1,4,3]
//    }


}
