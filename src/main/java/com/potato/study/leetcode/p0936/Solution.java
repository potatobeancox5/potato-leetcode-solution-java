package com.potato.study.leetcode.p0936;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 * 
 * @author liuzhao11
 * 
 * 	936. Stamping The Sequence
 *  
 *      You want to form a target string of lowercase letters.

At the beginning, your sequence is target.length '?' marks.  You also have a stamp of lowercase letters.

On each turn, you may place the stamp over the sequence, and replace every letter in the sequence with the corresponding letter from the stamp.  You can make up to 10 * target.length turns.

For example, if the initial sequence is "?????", and your stamp is "abc",  then you may make "abc??", "?abc?", "??abc" in the first turn.  (Note that the stamp must be fully contained in the boundaries of the sequence in order to stamp.)

If the sequence is possible to stamp, then return an array of the index of the left-most letter being stamped at each turn.  If the sequence is not possible to stamp, return an empty array.

For example, if the sequence is "ababc", and the stamp is "abc", then we could return the answer [0, 2], corresponding to the moves "?????" -> "abc??" -> "ababc".

Also, if the sequence is possible to stamp, it is guaranteed it is possible to stamp within 10 * target.length moves.  Any answers specifying more than this number of moves will not be accepted.



Example 1:

Input: stamp = "abc", target = "ababc"
Output: [0,2]
([1,0,2] would also be accepted as an answer, as well as some other answers.)
Example 2:

Input: stamp = "abca", target = "aabcaca"
Output: [3,0,1]


Note:

1 <= stamp.length <= target.length <= 1000
stamp and target only contain lowercase letters.
 *         
 *         题目含义：
 *
 *
 *         思路：
 *         https://leetcode-cn.com/problems/stamping-the-sequence/solution/chuo-yin-xu-lie-by-leetcode/
 *
 * 
 */
public class Solution {

    public int[] movesToStamp(String stamp, String target) {
        int mmm = stamp.length(), nnn = target.length();
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] done = new boolean[nnn];
        Stack<Integer> ans = new Stack();
        List<Node> arrayList = new ArrayList<>();

        for (int i = 0; i <= nnn-mmm; ++i) {
            // For each window [i, i+M), A[i] will contain
            // info on what needs to change before we can
            // reverse stamp at this window.

            Set<Integer> made = new HashSet<>();
            Set<Integer> todo = new HashSet<>();
            for (int j = 0; j < mmm; ++j) {
                if (target.charAt(i+j) == stamp.charAt(j)) {
                    made.add(i+j);
                } else {
                    todo.add(i+j);
                }
            }
            arrayList.add(new Node(made, todo));
            // If we can reverse stamp at i immediately,
            // enqueue letters from this window.
            if (todo.isEmpty()) {
                ans.push(i);
                for (int j = i; j < i + mmm; ++j) if (!done[j]) {
                    queue.add(j);
                    done[j] = true;
                }
            }
        }

        // For each enqueued letter (position),
        while (!queue.isEmpty()) {
            int i = queue.poll();

            // For each window that is potentially affected,
            // j: start of window
            for (int j = Math.max(0, i-mmm+1); j <= Math.min(nnn-mmm, i); ++j) {
                if (arrayList.get(j).todo.contains(i)) {  // This window is affected
                    arrayList.get(j).todo.remove(i);
                    if (arrayList.get(j).todo.isEmpty()) {
                        ans.push(j);
                        for (int m: arrayList.get(j).made) if (!done[m]) {
                            queue.add(m);
                            done[m] = true;
                        }
                    }
                }
            }
        }

        for (boolean b: done) {
            if (!b) return new int[0];
        }

        int[] ret = new int[ans.size()];
        int t = 0;
        while (!ans.isEmpty()) {
            ret[t++] = ans.pop();
        }

        return ret;
    }

    class Node {
        Set<Integer> made, todo;
        Node(Set<Integer> m, Set<Integer> t) {
            made = m;
            todo = t;
        }
    }
}
