package com.potato.study.leetcode.p0648;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author liuzhao11
 * 
 *         648. Replace Words
 * 
 *         In English, we have a concept called root, which can be followed by some other words to form another longer word - let's call this word successor. For example, the root an, followed by other, which can form another word another.

Now, given a dictionary consisting of many roots and a sentence. You need to replace all the successor in the sentence with the root forming it. If a successor has many roots can form it, replace it with the root with the shortest length.

You need to output the sentence after the replacement.

Example 1:

Input: dict = ["cat", "bat", "rat"]
sentence = "the cattle was rattled by the battery"
Output: "the cat was rat by the bat"


Note:

The input will only have lower-case letters.
1 <= dict words number <= 1000
1 <= sentence words number <= 1000
1 <= root length <= 100
1 <= sentence words length <= 1000
 *         思路：
 *
 *         648. Replace Words

https://www.cnblogs.com/jimmycheng/p/10743586.html

给的前缀放到set中

句子按照空格split

for eword
fori 1 word len
substr 是否在set 在的话替换word
break
sb append word 空格

删除最后一个空格并返回
 *
 */
public class Solution {


	public String replaceWords(List<String> dict, String sentence) {

		StringBuilder builder = new StringBuilder();

		Set<String> prefixSet = new HashSet<>(dict);

		String[] words = sentence.split(" ");
		for (String word : words) {
			for (int i = 1; i <= word.length(); i++) {
				String substring = word.substring(0, i);
				if (prefixSet.contains(substring)) {
					word = substring;
					break;
				}
			}
			builder.append(word).append(" ");
		}
		if (builder.charAt(builder.length() - 1) == ' ') {
			builder.deleteCharAt(builder.length() - 1);
		}
		return builder.toString();
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();

		List<String> dict = new ArrayList<>();
		dict.add("cat");
		dict.add("bat");
		dict.add("rat");
		String sentence = "the cattle was rattled by the battery";

		String word = solution.replaceWords(dict, sentence);
		System.out.println(word);
		Assert.assertEquals("the cat was rat by the bat", word);
	}
}
