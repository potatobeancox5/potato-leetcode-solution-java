package com.potato.study.leetcode.p0824;

/**
 * 
 * @author liuzhao11
 * 
 * 	824. Goat Latin
 *  
 *         A sentence S is given, composed of words separated by spaces. Each word consists of lowercase and uppercase letters only.

We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)

The rules of Goat Latin are as follows:

If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
For example, the word 'apple' becomes 'applema'.

If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
For example, the word "goat" becomes "oatgma".

Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
Return the final sentence representing the conversion from S to Goat Latin.



Example 1:

Input: "I speak Goat Latin"
Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
Example 2:

Input: "The quick brown fox jumped over the lazy dog"
Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"


Notes:

S contains only uppercase, lowercase and spaces. Exactly one space between each word.
1 <= S.length <= 150.
 *         
 *         思路：
 *
 * 
 */
public class Solution {

    public String toGoatLatin(String s) {
        StringBuilder sb = new StringBuilder();
        String[] stParts = s.split(" ");

        for (int i = 0; i < stParts.length; i++) {
            if (isStartWithVowel(stParts[i])) {
                sb.append(stParts[i]);
            } else if (isStartedWithNotVowel(stParts[i])) {
                sb.append(stParts[i].substring(1));
                sb.append(stParts[i].substring(0, 1));
            } else {
                sb.append(stParts[i]);
            }

            sb.append("ma");

            for (int j = 0; j <= i; j++) {
                sb.append("a");
            }
            sb.append(" ");
        }

        if (sb.length() != 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    private boolean isStartWithVowel(String word) {
        boolean isStartedWithVowel = false;

        switch (word.charAt(0)) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
                return true;

            default:
        }
        return false;
    }

    private boolean isStartedWithNotVowel(String word) {
        switch (word.charAt(0)) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
                return false;
            default:
        }
        return true;
    }



	public static void main(String[] args) {
		Solution solution = new Solution();
		String s = "I speak Goat Latin";

        String res = solution.toGoatLatin(s);
        System.out.println(res);
    }
}
