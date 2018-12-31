package com.potato.study.leetcode.p0165;

/**
 * 
 * @author liuzhao11
 * 
 *      165. Compare Version Numbers
 *         
 *          
 *   Compare two version numbers version1 and version2.
If version1 > version2 return 1; if version1 < version2 return -1;otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Example 1:

Input: version1 = "0.1", version2 = "1.1"
Output: -1
Example 2:

Input: version1 = "1.0.1", version2 = "1"
Output: 1
Example 3:

Input: version1 = "7.5.2.4", version2 = "7.5.3"
Output: -1

 *
 *      题目需求:
 *			比较两个版本数
 *
 * 		解题思路：
 *
 *
 */
public class Solution {

	public int compareVersion(String version1, String version2) {
		String[] versionPart1 = version1.split("\\.");
		String[] versionPart2 = version2.split("\\.");
		for (int i = 0; i < versionPart1.length && i < versionPart2.length; i++) {
			if(Integer.parseInt(versionPart1[i]) == Integer.parseInt(versionPart2[i])) {
				continue;
			} else {
				int num = Integer.parseInt(versionPart1[i]) - Integer.parseInt(versionPart2[i]);
				if(num > 0) {
				    return 1;
                } else if (num < 0) {
				    return -1;
                }
			}
		}
		if(versionPart2.length > versionPart1.length) {
		    for(int i = versionPart1.length ; i < versionPart2.length ; i++) {
		        if(Integer.parseInt(versionPart2[i]) > 0) {
                    return -1;
                }
            }
		} else if (versionPart2.length < versionPart1.length) {
		    for(int i = versionPart2.length ; i < versionPart1.length; i++) {
		        if(Integer.parseInt(versionPart1[i]) > 0) {
                    return 1;
                }
            }
		}
		return 0;
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		String v1 = "1.0";
		String v2 = "1";

		int result = solution.compareVersion(v1, v2);
		System.out.println(result);
	}

}
