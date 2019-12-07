package com.potato.study.leetcode.p0591;

import org.junit.Assert;

import java.util.Stack;

/**
 * 
 * @author liuzhao11
 * 
 *         591. Tag Validator
 * 
 *         Given a string representing a code snippet, you need to implement a tag validator to parse the code and return whether it is valid. A code snippet is valid if all the following rules hold:

The code must be wrapped in a valid closed tag. Otherwise, the code is invalid.
A closed tag (not necessarily valid) has exactly the following format : <TAG_NAME>TAG_CONTENT</TAG_NAME>. Among them, <TAG_NAME> is the start tag, and </TAG_NAME> is the end tag. The TAG_NAME in start and end tags should be the same. A closed tag is valid if and only if the TAG_NAME and TAG_CONTENT are valid.
A valid TAG_NAME only contain upper-case letters, and has length in range [1,9]. Otherwise, the TAG_NAME is invalid.
A valid TAG_CONTENT may contain other valid closed tags, cdata and any characters (see note1) EXCEPT unmatched <, unmatched start and end tag, and unmatched or closed tags with invalid TAG_NAME. Otherwise, the TAG_CONTENT is invalid.
A start tag is unmatched if no end tag exists with the same TAG_NAME, and vice versa. However, you also need to consider the issue of unbalanced when tags are nested.
A < is unmatched if you cannot find a subsequent >. And when you find a < or </, all the subsequent characters until the next > should be parsed as TAG_NAME (not necessarily valid).
The cdata has the following format : <![CDATA[CDATA_CONTENT]]>. The range of CDATA_CONTENT is defined as the characters between <![CDATA[ and the first subsequent ]]>.
CDATA_CONTENT may contain any characters. The function of cdata is to forbid the validator to parse CDATA_CONTENT, so even it has some characters that can be parsed as tag (no matter valid or invalid), you should treat it as regular characters.
Valid Code Examples:
Input: "<DIV>This is the first line <![CDATA[<div>]]></DIV>"

Output: True

Explanation:

The code is wrapped in a closed tag : <DIV> and </DIV>.

The TAG_NAME is valid, the TAG_CONTENT consists of some characters and cdata.

Although CDATA_CONTENT has unmatched start tag with invalid TAG_NAME, it should be considered as plain text, not parsed as tag.

So TAG_CONTENT is valid, and then the code is valid. Thus return true.


Input: "<DIV>>>  ![cdata[]] <![CDATA[<div>]>]]>]]>>]</DIV>"

Output: True

Explanation:

We first separate the code into : start_tag|tag_content|end_tag.

start_tag -> "<DIV>"

end_tag -> "</DIV>"

tag_content could also be separated into : text1|cdata|text2.

text1 -> ">>  ![cdata[]] "

cdata -> "<![CDATA[<div>]>]]>", where the CDATA_CONTENT is "<div>]>"

text2 -> "]]>>]"


The reason why start_tag is NOT "<DIV>>>" is because of the rule 6.
The reason why cdata is NOT "<![CDATA[<div>]>]]>]]>" is because of the rule 7.
Invalid Code Examples:
Input: "<A>  <B> </A>   </B>"
Output: False
Explanation: Unbalanced. If "<A>" is closed, then "<B>" must be unmatched, and vice versa.

Input: "<DIV>  div tag is not closed  <DIV>"
Output: False

Input: "<DIV>  unmatched <  </DIV>"
Output: False

Input: "<DIV> closed tags with invalid tag name  <b>123</b> </DIV>"
Output: False

Input: "<DIV> unmatched tags with invalid tag name  </1234567890> and <CDATA[[]]>  </DIV>"
Output: False

Input: "<DIV>  unmatched start tag <B>  and unmatched end tag </C>  </DIV>"
Output: False
Note:
For simplicity, you could assume the input code (including the any characters mentioned above) only contain letters, digits, '<','>','/','!','[',']' and ' '.
 * 
 * 
 *         思路：
 *         591. Tag Validator


https://blog.csdn.net/familyshizhouna/article/details/100142462

方法3


https://www.cnblogs.com/ruruozhenhao/p/10755712.html
 *      实现一个 tag 校验器
 *      校验tag是否满足下面条件：
 *
 *       
 *          
 */
public class Solution {

    public boolean isValid(String code) {
        // 用一个栈保存 目前 上一个该匹配的 开始tag
        Stack<String> tagStack = new Stack<>();
        // 遍历code 
        for (int i = 0; i < code.length(); i++) {
            // 开始时直接就是内容le false
            if (i > 0 && tagStack.isEmpty()) {
                return false;
            }
            if (i + 9 < code.length() && "<![CDATA[".equals(code.substring(i, i + 9))) {
                // 判断是不是CDATA区
                int j = code.indexOf("]]>", i);
                // 判断cdata区是否关闭
                if (j < 0) {
                    return false;
                }
                i = j + 2;
            } else if (i + 2 < code.length() && "</".equals(code.substring(i, i+2))) {
                // 判断是不是有结束符号的开始字符
                int j = code.indexOf(">", i);
                if (j < 0) {
                    return false;
                }
                // </ 除了上面字符都一致
                if (tagStack.isEmpty() || !tagStack.pop().equals(code.substring(i+2, j))) {
                    return false;
                }
                i = j;
            } else if (i+1 < code.length() && "<".equals(code.substring(i, i+1))) {
                // 判断是不是开始tag
                int j = code.indexOf(">", i);
                if (j < 0) {
                    return false;
                }
                String s = code.substring(i + 1, j);
                if (s.length() <= 0 || s.length() > 9) {
                    return false;
                }
                for (char c: s.toCharArray()) {
                    if (!Character.isUpperCase(c)) {
                        return false;
                    }
                }
                tagStack.push(s);
                i = j;
            }
        }
        return tagStack.isEmpty();
    }


    public static void main(String[] args) {
		Solution solution = new Solution();
        String code = "";
        boolean res = solution.isValid(code);
        System.out.println(res);
        Assert.assertEquals(false, res);
    }
}
