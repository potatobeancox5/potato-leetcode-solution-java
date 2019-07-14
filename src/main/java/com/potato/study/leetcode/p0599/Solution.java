package com.potato.study.leetcode.p0599;


import java.util.*;

/**
 * 
 * @author liuzhao11
 * 
 *         599. Minimum Index Sum of Two Lists
 * 
 *        Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.

You need to help them find out their common interest with the least list index sum. If there is a choice tie between answers, output all of them with no order requirement. You could assume there always exists an answer.

Example 1:
Input:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
Output: ["Shogun"]
Explanation: The only restaurant they both like is "Shogun".
Example 2:
Input:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["KFC", "Shogun", "Burger King"]
Output: ["Shogun"]
Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).
Note:
The length of both lists will be in the range of [1, 1000].
The length of strings in both lists will be in the range of [1, 30].
The index is starting from 0 to the list length minus 1.
No duplicates in both lists.
 * 
 * 
 *         思路：
 *
 *       
 *          
 */
public class Solution {

    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> res2IndexMap = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            res2IndexMap.put(list1[i], i);
        }

        List<SameRestaurant> resultList = new ArrayList<>();

        for (int i = 0; i < list2.length; i++) {
            String res = list2[i];
            if (res2IndexMap.containsKey(res)) {
                resultList.add(new SameRestaurant(res, res2IndexMap.get(res) + i));
            }
        }

        SameRestaurant[] sameRestaurantArr = new SameRestaurant[resultList.size()];
        sameRestaurantArr = resultList.toArray(sameRestaurantArr);
        Arrays.sort(sameRestaurantArr, new Comparator<SameRestaurant>() {
            @Override
            public int compare(SameRestaurant o1, SameRestaurant o2) {
                return o1.indexSum - o2.indexSum;
            }
        });
        int minIndex =  sameRestaurantArr[0].indexSum;
        List<String> list = new ArrayList<>();
        for (SameRestaurant restaurant : sameRestaurantArr) {
            if (restaurant.indexSum > minIndex) {
                break;
            } else {
                list.add(restaurant.name);
            }
        }
        String[] strArr = new String[list.size()];
        return list.toArray(strArr);
    }

    class SameRestaurant {
        private String name;
        private int indexSum;

        public SameRestaurant() {
        }

        public SameRestaurant(String name, int indexSum) {
            this.name = name;
            this.indexSum = indexSum;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


    public static void main(String[] args) {
		Solution solution = new Solution();

//        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
//        String[] list2 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};

//        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
//        String[] list2 = {"KFC", "Shogun", "Burger King"};

        String[] list1 = {"Shogun","Tapioca Express","Burger King","KFC"};
        String[] list2 = {"KFC","Burger King","Tapioca Express","Shogun"};

        String[] restaurant = solution.findRestaurant(list1, list2);
        System.out.println(Arrays.toString(restaurant));
    }
}
