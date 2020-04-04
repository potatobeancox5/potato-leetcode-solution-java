package com.potato.study.leetcode.p1268;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

/**
 * 
 * @author liuzhao11
 * 
 * 	1268. Search Suggestions System
 *  
 *
Given an array of strings products and a string searchWord. We want to design a system that suggests at most three product names from products after each character of searchWord is typed. Suggested products should have common prefix with the searchWord. If there are more than three products with a common prefix return the three lexicographically minimums products.

Return list of lists of the suggested products after each character of searchWord is typed.



Example 1:

Input: products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
Output: [
["mobile","moneypot","monitor"],
["mobile","moneypot","monitor"],
["mouse","mousepad"],
["mouse","mousepad"],
["mouse","mousepad"]
]
Explanation: products sorted lexicographically = ["mobile","moneypot","monitor","mouse","mousepad"]
After typing m and mo all products match and we show user ["mobile","moneypot","monitor"]
After typing mou, mous and mouse the system suggests ["mouse","mousepad"]
Example 2:

Input: products = ["havana"], searchWord = "havana"
Output: [["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]
Example 3:

Input: products = ["bags","baggage","banner","box","cloths"], searchWord = "bags"
Output: [["baggage","bags","banner"],["baggage","bags","banner"],["baggage","bags"],["bags"]]
Example 4:

Input: products = ["havana"], searchWord = "tatiana"
Output: [[],[],[],[],[],[],[]]


Constraints:

1 <= products.length <= 1000
There are no repeated elements in products.
1 <= Σ products[i].length <= 2 * 10^4
All characters of products[i] are lower-case English letters.
1 <= searchWord.length <= 1000
All characters of searchWord are lower-case English letters.
 *         
 *         思路：
 *
 *          输入单词 每次输入字母都推荐推荐至多 3个单词
 *
 *
 *          https://www.cnblogs.com/Dylan-Java-NYC/p/12190154.html
 *
 *          利用 treemap 找到 key 的ceil 和floor 直接添加进去
 *
 */
public class Solution {

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        // 对 products 排序 默认字段需 并将其 插入 treemap中 为了之后利用index 做sublist
        Arrays.sort(products);
        List<String> productList = Arrays.asList(products);
        TreeMap<String, Integer>  wordIndexMap = new TreeMap<>();
        for (int i = 0; i < products.length; i++) {
            wordIndexMap.put(products[i], i);
        }
        // 对于每次输入的字符 创建一个新key 找到 ceilingKey 和 floorKey
        String key = "";
        List<List<String>> result = new ArrayList<>();
        for (char ch : searchWord.toCharArray()) {
            key += ch;
            String ceil = wordIndexMap.ceilingKey(key);
            String floor = wordIndexMap.floorKey(key + "~");
             if (ceil == null || floor == null) {
                break;
            }
            // 取 proToIndex.get(ceil) 到 Math.min(proToIndex.get(ceil) + 3, proToIndex.get(floor) + 1)
            List<String> list = productList.subList(wordIndexMap.get(ceil),
                    Math.min(wordIndexMap.get(ceil) + 3, wordIndexMap.get(floor) + 1));
            result.add(list);
        }
        // 构造结果 如果数量 不够 那就是有好多没有找到的传 返回 new list
        while (result.size() < searchWord.length()) {
            result.add(new ArrayList<>());
        }
        return result;
    }
	
	public static void main(String[] args) {
        Solution solution = new Solution();
        String[] products = new String[]{"mobile","mouse","moneypot","monitor","mousepad"};
        String searchWord = "mouse";
        List<List<String>> lists = solution.suggestedProducts(products, searchWord);
        System.out.println(lists);
    }
}
