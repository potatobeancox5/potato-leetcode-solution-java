package com.potato.study.leetcode.p1039;


/**
 * 
 * @author liuzhao11
 * 
 * 	1039. Minimum Score Triangulation of Polygon
 *  
 *        Given N, consider a convex N-sided polygon with vertices labelled A[0], A[i], ..., A[N-1] in clockwise order.

Suppose you triangulate the polygon into N-2 triangles.  For each triangle, the value of that triangle is the product of the labels of the vertices, and the total score of the triangulation is the sum of these values over all N-2 triangles in the triangulation.

Return the smallest possible total score that you can achieve with some triangulation of the polygon.



Example 1:

Input: [1,2,3]
Output: 6
Explanation: The polygon is already triangulated, and the score of the only triangle is 6.
Example 2:



Input: [3,7,4,5]
Output: 144
Explanation: There are two triangulations, with possible scores: 3*7*5 + 4*5*7 = 245, or 3*4*5 + 3*4*7 = 144.  The minimum score is 144.
Example 3:

Input: [1,3,1,4,1,5]
Output: 13
Explanation: The minimum score triangulation has score 1*1*3 + 1*1*4 + 1*1*5 + 1*1*1 = 13.


Note:

3 <= A.length <= 50
1 <= A[i] <= 100
 *         
 *
 *         题目含义：
 *
 *
 *         思路：
 *          https://leetcode-cn.com/problems/minimum-score-triangulation-of-polygon/solution/zhi-xing-yong-shi-1-ms-zai-suo-you-java-ti-jia-187/
 *
 *
 */
public class Solution {


    public int minScoreTriangulation(int[] arr) {
        if(arr.length < 4){
            return arr[0] * arr[1] * arr[2];
        }else if(arr.length < 5){
            return Math.min(arr[0] * arr[2] *(arr[1] + arr[3]), arr[1]*arr[3]*(arr[0]+arr[2]));
        }
        //记录最小的4个顶点的数组并初始化
        int[] stack = new int[4];
        stack[0] = 0;
        stack[1] = 1;
        stack[2] = 2;
        stack[3] = 3;

        sort(arr,stack);

        //获取最小的4个顶点，由于4较小，没有使用小顶堆
        for(int i=4;i<arr.length;i++){
            if(arr[i] < arr[stack[0]]){
                stack[3] = stack[2];
                stack[2] = stack[1];
                stack[1] = stack[0];
                stack[0] = i;
            }else if(arr[i] < arr[stack[1]]){
                stack[3] = stack[2];
                stack[2] = stack[1];
                stack[1] = i;
            }else if(arr[i] < arr[stack[2]]){
                stack[3] = stack[2];
                stack[2] = i;
            }else if(arr[i] < arr[stack[3]]){
                stack[3] = i;
            }
        }


        if(Math.abs(stack[0] - stack[1]) != 1 && Math.abs(stack[0] - stack[1]) != (arr.length - 1)){
            //第1小和第2小的顶点不相邻
            return calcByIndex(arr,stack[0],stack[1]);
        }else if(Math.abs(stack[0] - stack[2]) != 1  && Math.abs(stack[0] - stack[2]) != (arr.length - 1)){
            //第1小和第3小的顶点不相邻
            return calcByIndex(arr,stack[0],stack[2]);
        }else{
            if(arr[stack[0]] == arr[stack[1]]){
                //第1小的顶点和第2小的顶点一样大
                return calcByIndex(arr,stack[1],stack[2]);
            }else{
                //第1、2、3小的顶点相邻，且最小顶点在中间，这是最坏的情况，此时有2种可能。
                return Math.min(calcByIndex(arr,stack[1],stack[2]),calcByIndex(arr,stack[0],stack[3]));
            }
        }
    }

    //按指定边切分为两个小的多边形
    private int calcByIndex(int[] arr, int a, int b){
        int minIndex = Math.min(a,b);
        int maxIndex = a + b - minIndex;

        int[] left = new int[(maxIndex-minIndex)+1];
        int[] right = new int[arr.length + 2 - left.length];
        System.arraycopy(arr,minIndex,left,0,left.length);
        System.arraycopy(arr,maxIndex,right,0,arr.length - maxIndex);
        System.arraycopy(arr,0,right,arr.length-maxIndex,minIndex + 1);

        return minScoreTriangulation(left) + minScoreTriangulation(right);
    }

    private void sort(int[] arr,int[] index){
        int len = index.length;
        for(int i=0;i<len-1;i++){
            for(int j=i+1;j<len;j++){
                if(arr[index[i]] > arr[index[j]]){
                    swap(index,i,j);
                }
            }
        }
    }

    private void swap(int[] arr,int a,int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

}
