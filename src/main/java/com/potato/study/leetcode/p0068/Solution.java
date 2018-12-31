package com.potato.study.leetcode.p0068;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 *        68. Text Justification
 *        
 *        Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.

For example,
words: ["This", "is", "an", "example", "of", "text", "justification."]
 *         
 * 
 *         思路：贪婪法 输出单词 并要求对齐
 *         int startIndex（包含） = 0；
 *         int wordnum = 1；
 *         int letfSpace = maxWidth - [0].len  - 1;
 *         for int i = 0 ; i < work.len ; i++ 
 *      	遍历一遍数组words 目前i
 *      		若当前剩余字数（包含空格）  >= i 将 i 也加入当前的句子中
 *      			wordnum++;
 *      			letfSpace = letfSpace - [i].len - 1;
 *      		若当前剩余字数  < i 则将上一个句子完整生成 然后 将当前i计算入当前开始的字符串中
 *      `			将原来的word生成字符串
 *      			从startIndex 《=到 《 startIndex + wordnum 的单词 
 *      			每个单词间空格数等于 blankNum = (letfSpace + wordnum) / (wordNUm - 1)  
 *      			前 《 (letfSpace + wordnum) % (wordNUm - 1) 个 + 1空格
 *      			遍历word {
 *      				word【i】 +  
 *      			}
 *      			置换新的记录量
 *      			startIndex = i；
 *      			wordnum = 1
 *      			letfSpace = [i].len - startIndex - 1
 * 
 * 
 */
public class Solution {

	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> result = new ArrayList<>();
		if(words == null || words.length == 0) {
			result.add(generateBlank(maxWidth));
			return result;
		}
		int startIndex = 0;
		int wordnum = 1;
		int letfSpace = maxWidth - words[0].length() - 1;
		for (int i = 1; i < words.length; i++) {
			if(letfSpace >= words[i].length()) {
				wordnum++;
				letfSpace = letfSpace - words[i].length() - 1; //连至少有一个的空格也删除
			} else { // 装不下了
				if(wordnum == 1) {
					result.add(words[startIndex] + generateBlank(maxWidth - words[startIndex].length()));
				} else {					
					// 生成字符串结果
					int blankNum = (letfSpace + wordnum) / (wordnum - 1);
					String blankStr = generateBlank(blankNum);
					int blankMoreNum = (letfSpace + wordnum) % (wordnum - 1);
					StringBuilder builder = new StringBuilder();
					for (int j = 0 ; j < wordnum ; j++) {
						builder.append(words[startIndex + j]);
						if(j < blankMoreNum ) {
							builder.append(blankStr);
							builder.append(" ");
						} else if (j != wordnum - 1) {
							builder.append(blankStr);
						}
					}
					result.add(builder.toString());
				}
				// 置换新的记录量
				startIndex = i;
				wordnum = 1;
				letfSpace = maxWidth - words[i].length() - 1;
			}
		}
		// 处理最后的句子
		if(wordnum == 1) {
			result.add(words[startIndex] + generateBlank(maxWidth - words[startIndex].length()));
		} else {			
			// 生成字符串结果
			String blankStr = generateBlank(letfSpace);
			StringBuilder builder = new StringBuilder();
			for (int j = 0 ; j < wordnum ; j++) {
				builder.append(words[startIndex + j]);
				builder.append(" ");
			}
			builder.append(blankStr);
			result.add(builder.toString());
		}
		return result;
    }

	/**
	 * 生成n个空格
	 * @param n
	 * @return
	 */
	private String generateBlank(int n) {
		if(n <= 0) {
			return "";
		}
		StringBuilder builder = new StringBuilder();
		for(int i = 0 ; i < n ; i++) {
			builder.append(" ");
		}
		return builder.toString();
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
//		String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
//		String[] words = {"a", "b", "c", "d", "e"};
		String[] words = {"What","must","be","shall","be."};
//		int maxWidth = 16;
		int maxWidth = 12;
		List<String> result = solution.fullJustify(words, maxWidth);
		System.out.println(result);
		
	}
}
