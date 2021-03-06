package com.potato.study.leetcode.p1172;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 
 * @author liuzhao11
 * 
 * 	1172. Dinner Plate Stacks
 *  
 *
You have an infinite number of stacks arranged in a row and numbered (left to right) from 0, each of the stacks has the same maximum capacity.

Implement the DinnerPlates class:

DinnerPlates(int capacity) Initializes the object with the maximum capacity of the stacks.
void push(int val) pushes the given positive integer val into the leftmost stack with size less than capacity.
int pop() returns the value at the top of the rightmost non-empty stack and removes it from that stack, and returns -1 if all stacks are empty.
int popAtStack(int index) returns the value at the top of the stack with the given index and removes it from that stack, and returns -1 if the stack with that given index is empty.
Example:

Input:
["DinnerPlates","push","push","push","push","push","popAtStack","push","push","popAtStack","popAtStack","pop","pop","pop","pop","pop"]
[[2],[1],[2],[3],[4],[5],[0],[20],[21],[0],[2],[],[],[],[],[]]
Output:
[null,null,null,null,null,null,2,null,null,20,21,5,4,3,1,-1]

Explanation:
DinnerPlates D = DinnerPlates(2);  // Initialize with capacity = 2
D.push(1);
D.push(2);
D.push(3);
D.push(4);
D.push(5);         // The stacks are now:  2  4
1  3  5
﹈ ﹈ ﹈
D.popAtStack(0);   // Returns 2.  The stacks are now:     4
1  3  5
﹈ ﹈ ﹈
D.push(20);        // The stacks are now: 20  4
1  3  5
﹈ ﹈ ﹈
D.push(21);        // The stacks are now: 20  4 21
1  3  5
﹈ ﹈ ﹈
D.popAtStack(0);   // Returns 20.  The stacks are now:     4 21
1  3  5
﹈ ﹈ ﹈
D.popAtStack(2);   // Returns 21.  The stacks are now:     4
1  3  5
﹈ ﹈ ﹈
D.pop()            // Returns 5.  The stacks are now:      4
1  3
﹈ ﹈
D.pop()            // Returns 4.  The stacks are now:   1  3
﹈ ﹈
D.pop()            // Returns 3.  The stacks are now:   1
﹈
D.pop()            // Returns 1.  There are no stacks.
D.pop()            // Returns -1.  There are still no stacks.


Constraints:

1 <= capacity <= 20000
1 <= val <= 20000
0 <= index <= 100000
At most 200000 calls will be made to push, pop, and popAtStack.
 *         
 *         思路：
 *
 *          https://leetcode-cn.com/problems/dinner-plate-stacks/solution/java-hashmap-shuang-zhi-zhen-jie-fa-by-don-vito-co/
 *
 *
 */
public class DinnerPlates {

    private Map<Integer, Stack<Integer>> map;
    private int head;
    private int last;
    private int size;
    private int cap;
    public DinnerPlates(int capacity) {
        this.cap = capacity;
        this.head = 0;
        this.last = 0;
        this.size = 0;
        this.map = new HashMap<>();
    }

    public void push(int val) {
        while (map.containsKey(head) && map.get(head).size() == cap) {
            head ++;
        }
        if (!map.containsKey(head)) {
            map.put(head, new Stack<>());
        }
        map.get(head).push(val);
        last = Math.max(last, head);
        size ++;
    }

    public int pop() {
        if (size == 0) {
            return -1;
        }
        while (last > 0 && map.get(last).isEmpty()) {
            last --;
        }
        size --;
        head = Math.min(head, last);
        return map.get(last).pop();
    }

    public int popAtStack(int index) {
        if (!map.containsKey(index) || map.get(index).isEmpty()) {
            return -1;
        }
        size --;
        head = Math.min(head, index);
        return map.get(index).pop();
    }

}
