package com.potato.study.leetcode.p0721;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/**
 * 
 * @author liuzhao11
 * 
 * 	721. Accounts Merge
 *  
 *        Given a list accounts, each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name, and the rest of the elements are emails representing emails of the account.

Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some email that is common to both accounts. Note that even if two accounts have the same name, they may belong to different people as people could have the same name. A person can have any number of accounts initially, but all of their accounts definitely have the same name.

After merging the accounts, return the accounts in the following format: the first element of each account is the name, and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.

Example 1:
Input:
accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
Explanation:
The first and third John's are the same person as they have the common email "johnsmith@mail.com".
The second John and Mary are different people as none of their email addresses are used by other accounts.
We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'],
['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
Note:

The length of accounts will be in the range [1, 1000].
The length of accounts[i] will be in the range [1, 10].
The length of accounts[i][j] will be in the range [1, 30].
 *         
 *         思路：
 *
 *          合并账号 拥有同一个email 的两个用户是一个人
 *
 *          https://www.cnblogs.com/immiao0319/p/9140114.html
 *
 *
 *          采用并查集合
 *
 *
 * 
 */
public class Solution {


    /**
     *
     * @param accounts key:用户名 value:该用户名对应的email
     * @return
     */
    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        // 0 构造结果集和初始条件判断 blank input
        List<List<String>> res = new ArrayList<>();
        if (null == accounts || accounts.size() == 0) {
            return res;
        }
        // 1 init 3 * map owners each email 对应的用户名
        Map<String, String> email2OwnerMap = new HashMap<>();
        // 1.1 parent key 是 email value 是他们的父节点 最开始父节点为本身
        Map<String, String> email2ParentMap = new HashMap<>();

        for (List<String> accountInfo : accounts) {
            String name = accountInfo.get(0);
            // 遍历 email
            for (int i = 1; i < accountInfo.size(); i++) {

                String email = accountInfo.get(i);

                email2OwnerMap.put(email, name);
                email2ParentMap.put(email, email);
            }
        }

        // 2 更新 email 父 map 防止从父的子 需要每个节点 都重新 find 一下

        for (List<String> accountInfo : accounts) {

            String parentBaseEmail = this.find(accountInfo.get(1), email2ParentMap);

            for (int i = 2; i < accountInfo.size(); i++) {
                String baseEmail = this.find(accountInfo.get(i), email2ParentMap);
                email2ParentMap.put(baseEmail, parentBaseEmail);
            }
        }


        //  unions HashMap<String, TreeSet<String>> key 是email的父节点， value 是他对应的孩子 遍历时需要进行更新
        Map<String, TreeSet<String>> emailUnionMap = new HashMap<>();

        for (List<String> accountInfo : accounts) {

            String parentEmail = this.find(accountInfo.get(1), email2ParentMap);
            TreeSet<String> emailMap = emailUnionMap.getOrDefault(parentEmail, new TreeSet<>());
            for (int i = 1; i < accountInfo.size(); i++) {
                emailMap.add(accountInfo.get(i));
            }

            emailUnionMap.put(parentEmail, emailMap);
        }


        // 3 处理结果
        for (String parentEmail : emailUnionMap.keySet()) {
            // 生成 email 列表
            List<String> emailList = new ArrayList<>(emailUnionMap.get(parentEmail));
            // 插入名字
            String ownerName = email2OwnerMap.get(parentEmail);
            emailList.add(0, ownerName);

            res.add(emailList);
        }
        return res;
    }


    /**
     * 递归查找uion 中 key 为 target 对应的
     * @param target
     * @param union
     * @return
     */
    private String find(String target, Map<String, String> union) {
        String parent = union.get(target);
        // 达到最终点
        if (parent.equals(target)) {
            return target;
        }
        // 没有达到 最终点 递归查找
        return find(parent, union);
    }
	

	
	public static void main(String[] args) {
		Solution solution = new Solution();
        List<List<String>> accounts = new ArrayList<>();

//        List<String> account1 = Arrays.asList(new String[]{"John","johnsmith@mail.com","john_newyork@mail.com"});
//        List<String> account2 = Arrays.asList(new String[]{"John","johnsmith@mail.com","john00@mail.com"});
//        List<String> account3 = Arrays.asList(new String[]{"Mary","mary@mail.com"});
//        List<String> account4 = Arrays.asList(new String[]{"John","johnnybravo@mail.com"});

//        accounts.add(account1);
//        accounts.add(account2);
//        accounts.add(account3);
//        accounts.add(account4);


        List<String> account1 = Arrays.asList(new String[]{"Gabe","Gabe0@m.co","Gabe3@m.co","Gabe2@m.co"});
        List<String> account2 = Arrays.asList(new String[]{"Gabe","Gabe3@m.co","Gabe4@m.co","Gabe2@m.co"});

        accounts.add(account1);
        accounts.add(account2);

         List<List<String>> list = solution.accountsMerge(accounts);
        System.out.println(list);
    }
}
