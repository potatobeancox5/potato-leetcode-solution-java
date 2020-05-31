package com.potato.study.leetcode.p1093;


/**
 * 
 * @author liuzhao11
 * 
 * 	1093. Statistics from a Large Sample
 *  
 *       We sampled integers between 0 and 255, and stored the results in an array count:  count[k] is the number of integers we sampled equal to k.

Return the minimum, maximum, mean, median, and mode of the sample respectively, as an array of floating point numbers.  The mode is guaranteed to be unique.

(Recall that the median of a sample is:

The middle element, if the elements of the sample were sorted and the number of elements is odd;
The average of the middle two elements, if the elements of the sample were sorted and the number of elements is even.)


Example 1:

Input: count = [0,1,3,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
Output: [1.00000,3.00000,2.37500,2.50000,3.00000]
Example 2:

Input: count = [0,4,3,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
Output: [1.00000,4.00000,2.18182,2.00000,1.00000]


Constraints:

count.length == 256
1 <= sum(count) <= 10^9
The mode of the sample that count represents is unique.
Answers within 10^-5 of the true value will be accepted as correct.
 *         
 *
 *
 *
 *         思路：
 *
 *
 */
public class Solution {

    private double getMedian(int[] count, int cnt) {
        int c = 0;
        boolean even = (cnt % 2 == 0);
        int half = cnt / 2;

        for(int i = 0; i < 256; i++) {
            if (count[i] > 0) {
                c += count[i];
                if (c == half) {
                    if (even) {
                        for(int j = i + 1; j < 256; j++) {
                            if (count[j] > 0) {
                                return (j + i) / (double)2;
                            }
                        }

                    } else {
                        for(int j = i + 1; j < 256; j++) {
                            if (count[j] > 0) {
                                return (double) j;
                            }
                        }
                    }
                } else if (c > half) {
                    return (double) i;
                }
            }
        }
        return (double) 0;
    }

    public double[] sampleStats(int[] count) {
        int min = -1;
        int max = -1;
        int cnt = 0;
        long sum = 0;
        int mode = -1;
        int modeC = 0;
        for(int i = 0; i < 256; i++) {
            if (count[i] > 0) {
                if (min == -1) {
                    min = i;
                }

                if (i > max) {
                    max = i;
                }

                cnt += (count[i]);
                sum += (long)(count[i] * i);

                if (count[i] > modeC) {
                    modeC = count[i];
                    mode = i;
                }
            }
        }

        double[] res = new double[5];
        res[0] = (double) min;
        res[1] = (double) max;
        res[2] = (double) sum / (cnt);
        res[3] = getMedian(count, cnt);
        res[4] = (double) mode;

        return res;
    }

}
