package com.potato.study.leetcode.p1007;


/**
 * 
 * @author liuzhao11
 * 
 * 	1007. Minimum Domino Rotations For Equal Row
 *  
 *         In a row of dominoes, A[i] and B[i] represent the top and bottom halves of the i-th domino.  (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)

We may rotate the i-th domino, so that A[i] and B[i] swap values.

Return the minimum number of rotations so that all the values in A are the same, or all the values in B are the same.

If it cannot be done, return -1.



Example 1:



Input: A = [2,1,2,4,2,2], B = [5,2,6,2,3,2]
Output: 2
Explanation:
The first figure represents the dominoes as given by A and B: before we do any rotations.
If we rotate the second and fourth dominoes, we can make every value in the top row equal to 2, as indicated by the second figure.
Example 2:

Input: A = [3,5,1,2,3], B = [3,6,3,3,4]
Output: -1
Explanation:
In this case, it is not possible to rotate the dominoes to make one row of values equal.


Note:

1 <= A[i], B[i] <= 6
2 <= A.length == B.length <= 20000
 *         
 *         思路：
 *
 *         https://leetcode-cn.com/problems/minimum-domino-rotations-for-equal-row/solution/lian-xu-chai-xiang-tong-de-shu-zi-by-leetcode/
 *
 */
public class Solution {

    private int check(int x, int[] a, int[] b, int n) {
        // how many rotations should be done
        // to have all elements in A equal to x
        // and to have all elements in B equal to x
        int rotationsA = 0, rotationsB = 0;
        for (int i = 0; i < n; i++) {
            // rotations coudn't be done
            if (a[i] != x && b[i] != x) {
                // A[i] != x and B[i] == x
                return -1;
            } else if (a[i] != x) {
                // A[i] == x and B[i] != x
                rotationsA++;
            } else if (b[i] != x) {
                rotationsB++;
            }
        }
        // min number of rotations to have all
        // elements equal to x in A or B
        return Math.min(rotationsA, rotationsB);
    }

    public int minDominoRotations(int[] arr, int[] brr) {
        int n = arr.length;
        int rotations = check(arr[0], brr, arr, n);
        // If one could make all elements in A or B equal to A[0]
        if (rotations != -1 || arr[0] == brr[0]) {
            // If one could make all elements in A or B equal to B[0]
            return rotations;
        } else {
            return check(brr[0], brr, arr, n);
        }
    }
}
