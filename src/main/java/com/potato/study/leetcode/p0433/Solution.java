package com.potato.study.leetcode.p0433;

import org.junit.Assert;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author liuzhao11
 * 
 *   433. Minimum Genetic Mutation
 * 
 *   A gene string can be represented by an 8-character long string, with choices from "A", "C", "G", "T".

Suppose we need to investigate about a mutation (mutation from "start" to "end"), where ONE mutation is defined as ONE single character changed in the gene string.

For example, "AACCGGTT" -> "AACCGGTA" is 1 mutation.

Also, there is a given gene "bank", which records all the valid gene mutations. A gene must be in the bank to make it a valid gene string.

Now, given 3 things - start, end, bank, your task is to determine what is the minimum number of mutations needed to mutate from "start" to "end". If there is no such a mutation, return -1.

Note:

Starting point is assumed to be valid, so it might not be included in the bank.
If multiple mutations are needed, all mutations during in the sequence must be valid.
You may assume start and end string is not the same.

 * 			
 *     思路：
 *
 *     433. Minimum Genetic Mutation
给一个start 字符串和end 字符串 每次改变一个字母 且改变后字符串必须位于bank中
求最小需要几步

https://blog.csdn.net/felonny/article/details/62237591

图的广度搜索
startset 存每次的开始寻找点

endset 存每次的终止点（目标点）

visitset 存已经访问过的点

while start非空
 	选择startset 遍历其中每一个word
 	对于每一个word 依次更换每个位置的字符
 		如果更换后 word 在endset中，那么 计数 直接返回count + 1
 		如果更换后 word 在 bank 中但没在target 中，将其放到 visit 中和 tmp 中 ，然后每次遍历玩一个word 更换startSet 至缓存startSet
https://blog.csdn.net/felonny/article/details/62237591
 *     
 * 			
 * 	
 */	
public class Solution {

	public int minMutation(String start, String end, String[] bank) {

		Set<String> startSet = new HashSet<>();
		Set<String> endSet = new HashSet<>();

		Set<String> visitedSet = new HashSet<>();
		Set<String> bankSet = new HashSet<>(Arrays.asList(bank));

		if (!bankSet.contains(end)) {
			return -1;
		}

		startSet.add(start);
		endSet.add(end);

		char[] exchangeChar = {'A', 'C', 'G', 'T'};

		int stepCount = 0;

		while (!startSet.isEmpty() && !endSet.isEmpty()) {
			// 选择startset 遍历其中每一个word
			if (endSet.size() < startSet.size()) {
				Set<String> exchange = endSet;
				endSet = startSet;
				startSet = exchange;
			}
			// 遍历startset其中每一个word
			Set<String> tmpStartSet = new HashSet<>();
			for (String startWord : startSet) {
				char[] startWordCharArray = startWord.toCharArray();
				for (int i = 0; i < startWordCharArray.length; i++) {
					// change char
					for (int j = 0; j < exchangeChar.length; j++) {
						char tmpCh = startWordCharArray[i];
						startWordCharArray[i] = exchangeChar[j];
						// new word
						String nextWord = new String(startWordCharArray);
						if (endSet.contains(nextWord)) {
							return stepCount + 1;
						}
						if (!visitedSet.contains(nextWord) && bankSet.contains(nextWord)) {
							tmpStartSet.add(nextWord);
							visitedSet.add(nextWord);
						}
						// 还原字符
						startWordCharArray[i] = tmpCh;
					}

				}

			}
			stepCount++;
			startSet = tmpStartSet;
		}
		return -1;
	}
	
	
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		String start = "AACCGGTT";
		String end = "AACCGGTA";
		String[] bank = {"AACCGGTA"};
		int count = solution.minMutation(start, end, bank);
		System.out.println(count);
		Assert.assertEquals(1, count);


		start = "AACCGGTT";
		end = "AAACGGTA";
		String[] bank1 = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};
		count = solution.minMutation(start, end, bank1);
		System.out.println(count);
		Assert.assertEquals(2, count);

		start = "AAAAACCC";
		end = "AACCCCCC";
		String[] bank2 = {"AAAACCCC", "AAACCCCC", "AACCCCCC"};
		count = solution.minMutation(start, end, bank2);
		System.out.println(count);
		Assert.assertEquals(3, count);


		start = "AACCGGTT";
		end = "AACCGGTA";
		String[] bank3 = {"AAAACCCC", "AAACCCCC", "AACCCCCC"};
		count = solution.minMutation(start, end, bank3);
		System.out.println(count);
		Assert.assertEquals(-1, count);
	}
}
