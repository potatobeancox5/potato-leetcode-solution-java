package com.potato.study.leetcode.p1386;


import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 * 	1386. Cinema Seat Allocation
 *  
 *
A cinema has n rows of seats, numbered from 1 to n and there are ten seats in each row, labelled from 1 to 10 as shown in the figure above.

Given the array reservedSeats containing the numbers of seats already reserved, for example, reservedSeats[i]=[3,8] means the seat located in row 3 and labelled with 8 is already reserved.

Return the maximum number of four-person families you can allocate on the cinema seats. A four-person family occupies fours seats in one row, that are next to each other. Seats across an aisle (such as [3,3] and [3,4]) are not considered to be next to each other, however, It is permissible for the four-person family to be separated by an aisle, but in that case, exactly two people have to sit on each side of the aisle.



Example 1:



Input: n = 3, reservedSeats = [[1,2],[1,3],[1,8],[2,6],[3,1],[3,10]]
Output: 4
Explanation: The figure above shows the optimal allocation for four families, where seats mark with blue are already reserved and contiguous seats mark with orange are for one family.
Example 2:

Input: n = 2, reservedSeats = [[2,1],[1,8],[2,6]]
Output: 2
Example 3:

Input: n = 4, reservedSeats = [[4,3],[1,4],[4,6],[1,7]]
Output: 4


Constraints:

1 <= n <= 10^9
1 <= reservedSeats.length <= min(10*n, 10^4)
reservedSeats[i].length == 2
1 <= reservedSeats[i][0] <= n
1 <= reservedSeats[i][1] <= 10
All reservedSeats[i] are distinct.
 *         
 *         思路：
 *          https://leetcode-cn.com/problems/cinema-seat-allocation/solution/wei-yun-suan-pan-duan-neng-fou-an-pai-by-thare_lam/s
 *
 *
 */
public class Solution {


    private int left = 0b0111100000;
    private int right = 0b0000011110;
    private int middle = 0b0001111000;

    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int res = 0;
        int row;
        Arrays.sort(reservedSeats, (o1, o2) -> o1[0] - o2[0]);
        for (int i = 1, x = 0; i <= n; ++i) {
            if (x == reservedSeats.length) {
                res += 2 * (n - i + 1);
                break;
            } else if (reservedSeats[x][0] != i) {
                res += 2;
            } else {
                row = 0;
                while (x < reservedSeats.length && reservedSeats[x][0] == i) {
                    row |= (1 << (10 - reservedSeats[x++][1]));
                }
                if ((row & left) == 0) {
                    ++res;
                }
                if ((row & right) == 0) {
                    ++res;
                }
                if ((row & left) != 0 && (row & right) != 0 && (row & middle) == 0) {
                    ++res;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
    }
}
