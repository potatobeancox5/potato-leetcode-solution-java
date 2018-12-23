package com.potato.study.leetcode.p0187;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author liuzhao11
 * 
 *    187. Repeated DNA Sequences
 *         
 *          
 *   All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

Example:

Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"

Output: ["AAAAACCCCC", "CCCCCAAAAA"]



 *         思路： 
 *          ACGT 使用而二进制表示时最后三位不同，只取最后三位进行存储 比较 用int 数字存储每个序列
 *         
 *        
 */
public class Solution {

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> resultList = new ArrayList<>();
        if (null == s || s.length() <= 10) {
            return resultList;
        }
        int firstDna = this.convertDNA2Int(s.substring(0, 10));
        Map<Integer, Integer> dnaMap = new HashMap<>();
        dnaMap.put(firstDna, 1);
        int lastResult = firstDna;
        for (int i = 1; i < s.length() - 9; i++) {
            int currentResult = this.convertDNA2IntUesLastResult(s.charAt(i + 9), lastResult);
            if(dnaMap.containsKey(currentResult)) {
                int count = dnaMap.get(currentResult);
                if(count == 1) {
                    dnaMap.put(currentResult, count + 1);
                    resultList.add(s.substring(i, i + 10));
                }
                lastResult = currentResult;
            } else {
                dnaMap.put(currentResult, 1);
                lastResult = currentResult;
            }
        }
        return resultList;
    }


    /**
     * 将10个 dna字母转换成一个可以表示它的int 数字
     * @param dnaStr
     * @return
     */
    private int convertDNA2Int(String dnaStr) {
        int result = 0;
        for (char ch : dnaStr.toCharArray()) {
            int lastBits = ch & 0b111;
            result = result << 3;
            result += lastBits;
        }
        return result;
    }

    /**
     * 将上次生成的数字作移动3位
     * 去掉最高两位
     * 用ch替换最后三位
     * @param ch
     * @param lastResult
     * @return
     */
    private int convertDNA2IntUesLastResult (char ch, int lastResult) {
        int lastBits = ch & 0b111;
        int result = (lastResult << 3) & 0b111111111111111111111111111111;// 30个1
        return result + lastBits;
    }



	
	public static void main(String[] args) {
		Solution solution = new Solution();
		String dna = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
//		String dna = "AAAAAAAAAAAAAAA";
		List<String> result = solution.findRepeatedDnaSequences(dna);
        System.out.println(Arrays.toString(result.toArray()));
    }
}
