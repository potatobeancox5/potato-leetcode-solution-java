package com.potato.study.leetcode.p1418;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * 
 * @author liuzhao11
 * 
 * 	1418. Display Table of Food Orders in a Restaurant
 *  
 *
Given the array orders, which represents the orders that customers have done in a restaurant. More specifically orders[i]=[customerNamei,tableNumberi,foodItemi] where customerNamei is the name of the customer, tableNumberi is the table customer sit at, and foodItemi is the item customer orders.

Return the restaurant's “display table”. The “display table” is a table whose row entries denote how many of each food item each table ordered. The first column is the table number and the remaining columns correspond to each food item in alphabetical order. The first row should be a header whose first column is “Table”, followed by the names of the food items. Note that the customer names are not part of the table. Additionally, the rows should be sorted in numerically increasing order.



Example 1:

Input: orders = [["David","3","Ceviche"],["Corina","10","Beef Burrito"],["David","3","Fried Chicken"],["Carla","5","Water"],["Carla","5","Ceviche"],["Rous","3","Ceviche"]]
Output: [["Table","Beef Burrito","Ceviche","Fried Chicken","Water"],["3","0","2","1","0"],["5","0","1","0","1"],["10","1","0","0","0"]]
Explanation:
The displaying table looks like:
Table,Beef Burrito,Ceviche,Fried Chicken,Water
3    ,0           ,2      ,1            ,0
5    ,0           ,1      ,0            ,1
10   ,1           ,0      ,0            ,0
For the table 3: David orders "Ceviche" and "Fried Chicken", and Rous orders "Ceviche".
For the table 5: Carla orders "Water" and "Ceviche".
For the table 10: Corina orders "Beef Burrito".
Example 2:

Input: orders = [["James","12","Fried Chicken"],["Ratesh","12","Fried Chicken"],["Amadeus","12","Fried Chicken"],["Adam","1","Canadian Waffles"],["Brianna","1","Canadian Waffles"]]
Output: [["Table","Canadian Waffles","Fried Chicken"],["1","2","0"],["12","0","3"]]
Explanation:
For the table 1: Adam and Brianna order "Canadian Waffles".
For the table 12: James, Ratesh and Amadeus order "Fried Chicken".
Example 3:

Input: orders = [["Laura","2","Bean Burrito"],["Jhon","2","Beef Burrito"],["Melissa","2","Soda"]]
Output: [["Table","Bean Burrito","Beef Burrito","Soda"],["2","1","1","1"]]


Constraints:

1 <= orders.length <= 5 * 10^4
orders[i].length == 3
1 <= customerNamei.length, foodItemi.length <= 20
customerNamei and foodItemi consist of lowercase and uppercase English letters and the space character.
tableNumberi is a valid integer between 1 and 500.
 *         
 *         思路：
 *          https://leetcode-cn.com/problems/display-table-of-food-orders-in-a-restaurant/solution/tong-su-yi-dong-javashi-xian-by-bigpotato-3/
 *
 *          存储订单信息 tableId -> {foodName -> foodCount} (treemap)，记录所有菜品名(set)
构造每桌每个菜品数量
构造title
 *
 *
 *
 *
 */
public class Solution {


    public List<List<String>> displayTable(List<List<String>> orders) {
        // tableId -> {foodName -> foodCount} (treemap) id升序
        TreeMap<String, Map<String, Integer>> tableFoodMap = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.parseInt(o1) - Integer.parseInt(o2);
            }
        });
        Set<String> foodNameSet = new HashSet<>();
        // 遍历 订单
        for (List<String> order :orders) {
            String tableId = order.get(1);
            String foodName = order.get(2);

            foodNameSet.add(foodName);
            // 每桌点了啥菜品
            if (tableFoodMap.containsKey(tableId)) {
                Map<String, Integer> foodCountMap = tableFoodMap.get(tableId);
                foodCountMap.put(foodName, foodCountMap.getOrDefault(foodName, 0) + 1);
            } else {
                Map<String, Integer> foodCountMap = new HashMap<>();
                foodCountMap.put(foodName, 1);
                tableFoodMap.put(tableId, foodCountMap);
            }
        }

        //菜品名称按照字母序排序
        List<String> orderedFoodNames = new ArrayList<>(foodNameSet);
        orderedFoodNames.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        List<List<String>> showMenus = new ArrayList<>();
        //构造每桌每个菜品数量
        for (Map.Entry<String, Map<String, Integer>> entry : tableFoodMap.entrySet()) {
            String tableId = entry.getKey();
            List<String> showMenu = new ArrayList<>();
            showMenu.add(tableId);
            for (String foodName : orderedFoodNames) {
                showMenu.add(entry.getValue().getOrDefault(foodName, 0) + "");
            }
            showMenus.add(showMenu);
        }
        //构造标题
        orderedFoodNames.add(0, "Table");
        List<List<String>> res = new ArrayList<>();
        res.add(orderedFoodNames);
        res.addAll(showMenus);


        return res;
    }

    public static void main(String[] args) {
    }
}
