package com.potato.study.leetcode.p1316;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 * 	1316. Distinct Echo Substrings
 *  
 *
Return the number of distinct non-empty substrings of text that can be written as the concatenation of some string with itself (i.e. it can be written as a + a where a is some string).



Example 1:

Input: text = "abcabcabc"
Output: 3
Explanation: The 3 substrings are "abcabc", "bcabca" and "cabcab".
Example 2:

Input: text = "leetcodeleetcode"
Output: 2
Explanation: The 2 substrings are "ee" and "leetcodeleetcode".


Constraints:

1 <= text.length <= 2000
text has only lowercase English letters.
 *         
 *         思路：
 *
 *
 *          https://leetcode-cn.com/problems/distinct-echo-substrings/solution/java-hash-by-levyjeng/
 *
 *
 *
 */
public class Solution {

    static int mod = 1000000009;
    int[] powMod;

    int hash(int h, int start, int end, String s) {
        int remove = start - 1;
        int add = end;

        h = (int) ((h - ((1L * powMod[add - remove - 1] * (s.charAt(remove) - 'a') % mod)) + mod) % mod);

        h = (int) (h * 26L % mod);
        h = (h + s.charAt(add) - 'a') % mod;
        return h;
    }


    public int distinctEchoSubstrings(String text) {
        int len = text.length();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        powMod = new int[len];
        int temp = 1;
        int res = 0;
        powMod[0] = 1;
        for (int i = 1; i < len; i++) {
            temp = (int) (temp * 26L % mod);
            powMod[i] = temp;
        }
        for (int l = 1; l <= len; l++) {
            map.clear();

            //i==0
            int hash = 0;
            for (int k = 0; k < l; k++) {
                hash = (int) (hash * 26L % mod);
                hash = (hash + (text.charAt(k) - 'a')) % mod;

            }
            map.put(hash, new ArrayList<>());
            map.get(hash).add(0);
            for (int i = 1; i + l <= len; i++) {
                hash = hash(hash, i, i + l - 1, text);
                if (!map.containsKey(hash)) {
                    map.put(hash, new ArrayList<>());
                }
                map.get(hash).add(i);

            }
            for (Iterator<Integer> it = map.keySet().iterator(); it.hasNext(); ) {
                List<Integer> list = map.get(it.next());
                if(list.size()==1){
                    continue;
                }
                for (int x : list) {
                    if (Collections.binarySearch(list, x + l) >= 0) {
                        res++;
                        break;
                    }
                }

            }
        }
        return res;
    }

}
