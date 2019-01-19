package com.potato.study.leetcode.p0929;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author liuzhao11
 * 
 * 	929. Unique Email Addresses
 *  
 *       Every email consists of a local name and a domain name, separated by the @ sign.

For example, in alice@leetcode.com, alice is the local name, and leetcode.com is the domain name.

Besides lowercase letters, these emails may contain '.'s or '+'s.

If you add periods ('.') between some characters in the local name part of an email address, mail sent there will be forwarded to the same address without dots in the local name.  For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.  (Note that this rule does not apply for domain names.)

If you add a plus ('+') in the local name, everything after the first plus sign will be ignored. This allows certain emails to be filtered, for example m.y+name@email.com will be forwarded to my@email.com.  (Again, this rule does not apply for domain names.)

It is possible to use both of these rules at the same time.

Given a list of emails, we send one email to each address in the list.  How many different addresses actually receive mails?



Example 1:

Input: ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
Output: 2
Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails


Note:

1 <= emails[i].length <= 100
1 <= emails.length <= 100
Each emails[i] contains exactly one '@' character.
 *         
 *         题目含义：
 *            判断有多少个相同的email
 *         思路：
 *             @ 前后的两个part处理方法不同
 *             获取@前面的字段和@ 后边的字段
 *             前面的字段进行处理
 *             1.去掉. 办法是 按照. 分割 然后拼接部分
 *             2.按照+ 分割 切去后边的部分
 *
 *
 * 
 */
public class Solution {


    public int numUniqueEmails(String[] emails) {
        Set<String> emailSet = new HashSet<>();
        for (String email : emails) {
            emailSet.add(getFinalEmail(email));
        }
//        System.out.println(emailSet.toString());
        return emailSet.size();
    }

    /**
     * 构造最终的 email
     * @param email
     * @return
     */
    private String getFinalEmail(String email) {
        String[] split = email.split("@");
        String frontEmailPart = split[0];
        String endEmailPart = split[1];
//        1.去掉. 办法是 按照. 分割 然后拼接部分
        if (frontEmailPart.contains(".")) {
            String[] splitPart = frontEmailPart.split("\\.");
            StringBuilder sb = new StringBuilder();
            for (String frontPart : splitPart) {
                sb.append(frontPart);
            }
            frontEmailPart = sb.toString();
        }
//        2.按照+ 分割 切去后边的部分
        if (frontEmailPart.contains("+")) {
            String[] splitPart = frontEmailPart.split("\\+");
            frontEmailPart = splitPart[0];
        }
        return frontEmailPart + "@" + endEmailPart;
    }


    public static void main(String[] args) {
		Solution solution = new Solution();
//		String[] emails = {"test.email+alex@leetcode.com",
//                "test.e.mail+bob.cathy@leetcode.com",
//                "testemail+david@lee.tcode.com"};
		String[] emails = {"test.email+alex@leetcode.com"
                ,"test.e.mail+bob.cathy@leetcode.com",
                "testemail+david@lee.tcode.com"};
		int num = solution.numUniqueEmails(emails);
        System.out.println(num);
    }
}
