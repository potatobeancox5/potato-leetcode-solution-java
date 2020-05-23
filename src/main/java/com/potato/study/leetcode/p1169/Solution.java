package com.potato.study.leetcode.p1169;


import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 * 	1169. Invalid Transactions
 *  
 *       A transaction is possibly invalid if:

the amount exceeds $1000, or;
if it occurs within (and including) 60 minutes of another transaction with the same name in a different city.
Each transaction string transactions[i] consists of comma separated values representing the name, time (in minutes), amount, and city of the transaction.

Given a list of transactions, return a list of transactions that are possibly invalid.  You may return the answer in any order.



Example 1:

Input: transactions = ["alice,20,800,mtv","alice,50,100,beijing"]
Output: ["alice,20,800,mtv","alice,50,100,beijing"]
Explanation: The first transaction is invalid because the second transaction occurs within a difference of 60 minutes, have the same name and is in a different city. Similarly the second one is invalid too.
Example 2:

Input: transactions = ["alice,20,800,mtv","alice,50,1200,mtv"]
Output: ["alice,50,1200,mtv"]
Example 3:

Input: transactions = ["alice,20,800,mtv","bob,50,1200,mtv"]
Output: ["bob,50,1200,mtv"]


Constraints:

transactions.length <= 1000
Each transactions[i] takes the form "{name},{time},{amount},{city}"
Each {name} and {city} consist of lowercase English letters, and have lengths between 1 and 10.
Each {time} consist of digits, and represent an integer between 0 and 1000.
Each {amount} consist of digits, and represent an integer between 0 and 2000.

Note:

1 <= matrix.length <= 300
1 <= matrix[i].length <= 300
All matrix[i].length's are equal
matrix[i][j] is 0 or 1
 *         
 *
 *
 *
 *         思路：
 *         https://www.cnblogs.com/keepAC/p/11623860.html
 *
 *         https://leetcode-cn.com/problems/flip-columns-for-maximum-number-of-equal-rows/solution/xun-zhao-ju-you-xiang-tong-de-te-zheng-de-xing-de-/
 *
 *
 *
 */
public class Solution {

    public List<String> invalidTransactions(String[] transactions) {
        Transaction[] trans = new Transaction[transactions.length];
        int index = 0;
        for(String tran : transactions){
            String[] strings = tran.split(",");
            trans[index++] = new Transaction(strings[0],Integer.parseInt(strings[1]),
                    Integer.parseInt(strings[2]),strings[3]);
        }
        List<String> list = new ArrayList<>();
        // 遍历交易
        for(int i=0;i < trans.length;i++){
            // 超过 1000
            if(trans[i].money>1000) {
                list.add(transactions[i]);
            } else{
                // 名称一致 交易时间 小于 60 minu 城市不同
                for(int j=0;j<trans.length;j++){
                    if(i!=j && trans[j].name.equals(trans[i].name)
                            && !trans[j].city.equals(trans[i].city)
                            && Math.abs(trans[j].time - trans[i].time) <= 60){
                        list.add(transactions[i]);
                        break;
                    }
                }
            }
        }
        return list;
    }

    class Transaction{
        public String name;
        public Integer time;
        public Integer money;
        public String city;

        public Transaction(String name, Integer time, Integer money, String city) {
            this.name = name;
            this.time = time;
            this.money = money;
            this.city = city;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] transactions = {"alice,20,800,mtv","alice,50,100,beijing"};
        List<String> res = solution.invalidTransactions(transactions);
        System.out.println(res);
    }
}
