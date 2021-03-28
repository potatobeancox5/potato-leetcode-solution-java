package com.potato.study.leetcodecn.p00341.t001;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 341. 扁平化嵌套列表迭代器
 *
 * 给你一个嵌套的整型列表。请你设计一个迭代器，使其能够遍历这个整型列表中的所有整数。

 列表中的每一项或者为一个整数，或者是另一个列表。其中列表的元素也可能是整数或是其他列表。

  

 示例 1:

 输入: [[1,1],2,[1,1]]
 输出: [1,1,2,1,1]
 解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,1,2,1,1]。
 示例 2:

 输入: [1,[4,[6]]]
 输出: [1,4,6]
 解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,4,6]。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/flatten-nested-list-iterator
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class NestedIterator implements Iterator<Integer> {

    private List<Integer> list;

    private int index;
    /**
     * 用栈 逻辑太复杂 直接用链表吧
     * @param nestedList
     */
    public NestedIterator(List<NestedInteger> nestedList) {
        this.list = new ArrayList<>();
        index = 0;
        // 遍历 nestedList 生成list
        Stack<NestedInteger> stack = new Stack<>();
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.add(nestedList.get(i));
        }
        while (!stack.isEmpty()) {
            NestedInteger pop = stack.pop();
            if (pop.isInteger()) {
                list.add(pop.getInteger());
            } else {
                if (null != pop.getList()) {
                    for (int i = pop.getList().size() - 1; i >= 0; i--) {
                        stack.add(pop.getList().get(i));
                    }
                }
            }
        }
    }

    // [[1,1],2,[1,1]]
    @Override
    public Integer next() {
        return list.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }

    public static void main(String[] args) {

        // [[1,1],2,[1,1]]
        List<NestedInteger> nestedList = new LinkedList<>();
        NestedIntegerImpl nestedInteger1 = new NestedIntegerImpl();
        List<NestedInteger> child1 = new LinkedList<>();
        NestedIntegerImpl nestedInteger4 = new NestedIntegerImpl();
        nestedInteger4.setVal(1);
        child1.add(nestedInteger4);
        NestedIntegerImpl nestedInteger5 = new NestedIntegerImpl();
        nestedInteger5.setVal(1);
        child1.add(nestedInteger5);
        nestedInteger1.setChild(child1);


        NestedIntegerImpl nestedInteger2 = new NestedIntegerImpl();
        nestedInteger2.setVal(2);

        NestedIntegerImpl nestedInteger3 = new NestedIntegerImpl();
        List<NestedInteger> child3 = new LinkedList<>();
        NestedIntegerImpl nestedInteger6 = new NestedIntegerImpl();
        nestedInteger6.setVal(1);
        child3.add(nestedInteger6);
        NestedIntegerImpl nestedInteger7 = new NestedIntegerImpl();
        nestedInteger7.setVal(1);
        child3.add(nestedInteger7);
        nestedInteger3.setChild(child3);



        nestedList.add(nestedInteger1);
        nestedList.add(nestedInteger2);
        nestedList.add(nestedInteger3);

        NestedIterator nestedIterator = new NestedIterator(nestedList);
        while (nestedIterator.hasNext()) {
            System.out.println(nestedIterator.next());
        }


        // [[]]
        List<NestedInteger> nestedListkk = new LinkedList<>();
        NestedInteger nestedIntegerkkk = new NestedIntegerImpl();
        nestedListkk.add(nestedIntegerkkk);

        nestedIterator = new NestedIterator(nestedListkk);
        while (nestedIterator.hasNext()) {
            System.out.println(nestedIterator.next());
        }
    }
}

interface NestedInteger {

    boolean isInteger();

    Integer getInteger();

    List<NestedInteger> getList();

}

class NestedIntegerImpl implements NestedInteger {

    private Integer val;

    private List<NestedInteger> child;


    @Override
    public boolean isInteger() {
        return child == null;
    }

    @Override
    public Integer getInteger() {
        return val;
    }

    @Override
    public List<NestedInteger> getList() {
        return child;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public List<NestedInteger> getChild() {
        return child;
    }

    public void setChild(List<NestedInteger> child) {
        this.child = child;
    }
}

