package com.potato.study.leetcode.p0386;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 *       386. Lexicographical Numbers
 * 
 *      Given an integer n, return 1 - n in lexicographical order.

For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].

Please optimize your algorithm to use less time and space. The input size may be as large as 5,000,000.
 *         
 *         思路：
 *         https://blog.csdn.net/cloudox_/article/details/70224397
1、如果一个数乘以十以后没有超过n，那它后面紧挨着的应该是它的十倍，比如1,10,100。
2、如果不满足1，那就应该是直接加一，比如n为13的时候，前一个数为12，120超过了n，那接着的应该是13。但是这里要注意如果前一个数的个位已经是9或者是它就是n了，那就不能加一了，比如 n = 25，前一个数为19，下一个数应该为2而不是19+1=20。25的下一个也没有26了。
3、如果不满足2，比如19后面应该接2而不是20，这时候应该将19除以10再加一，比如n=500，399的下一个应该是4，那就是除以十，个位还是9，继续除以10，得到3，加一得到4。
 *
 *         
 */
public class Solution {

    public List<Integer> lexicalOrder(int n) {

        List<Integer> res = new ArrayList<>();
        if (0 == n) {
            return  res;
        }
        int currentNum = 1;
        res.add(1);
        while (res.size() < n) {
            if (currentNum * 10 <= n) {
                currentNum *= 10;
            } else if (currentNum % 10 != 9 && currentNum + 1 <= n) {
                currentNum += 1;
            } else {
                while (currentNum % 10 == 9) {
                    currentNum /= 10;
                }
                currentNum++;
            }
            if (currentNum <=n) {
                res.add(currentNum);
            }
        }
        return res;
    }
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
        int n = 13;
        List<Integer> list = solution.lexicalOrder(n);
        System.out.println(list);
	}
}

