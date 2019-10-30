package com.potato.study.leetcode.p0449;

import com.potato.study.leetcode.domain.TreeNode;

import java.util.ArrayList;
import java.util.List;


/**
 * 
 * @author liuzhao11
 * 
 *   449. Serialize and Deserialize BST
 * 
 *     Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary search tree can be serialized to a string and this string can be deserialized to the original tree structure.

The encoded string should be as compact as possible.

Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 * 
 *         思路：
 *
 *         序列化 root sb
sb append rootval append 空格
序列化 rootleft sb
序列化 rooright sb

序列化主方法返回sb tostr

反序列化 str listindex 只有一个 low high
    val 等于 index对应
    如果不在low high里 include 返回null
    new节点
    如果index 是最后str 直接返回结点
    list 重置0  index +1
    否则
    if 下个点小于val
    结点left = 反序列化 str list low val
    if 下个点大于va
    结点 right = 反 str list val high
 *
 * https://blog.csdn.net/u011604052/article/details/54744452
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append(root.val).append(" ");
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("".equals(data)) {
            return null;
        }
        String[] split = data.split(" ");
        if (null == split || split.length == 0) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        list.add(0);
        int low = Integer.MIN_VALUE;
        int high = Integer.MAX_VALUE;
        return deserialize(split, list, low, high);
    }

    /**
     *
     * @param dataPart  数据实体
     * @param list      当前遍历到的index
     * @param low       低位  当前数据必须要 现在在low和high之间
     * @param high      高位  当前数据必须要 现在在low和high之间
     * @return
     */
    private TreeNode deserialize(String[] dataPart, List<Integer> list, int low, int high) {
//        反序列化 str listindex 只有一个 low high
//        val 等于 index对应
        int index = list.get(0);
        int val = Integer.parseInt(dataPart[index]);
//        如果不在low high里 include 返回null
        if (low > val || val > high) {
            return null;
        }
//        new节点
        TreeNode root = new TreeNode(val);
//        如果index 是最后str 直接返回结点
        if (index == dataPart.length - 1) {
            return root;
        }
//        list 重置0  index +1
        list.set(0, index + 1);
//        if 下个点小于val
        if (Integer.parseInt(dataPart[list.get(0)]) <= val) {
            root.left = deserialize(dataPart, list, low, val);
        }
//                结点left = 反序列化 str list low val
//        if 下个点大于va
        if (Integer.parseInt(dataPart[list.get(0)]) >= val) {
            root.right = deserialize(dataPart, list, val, high);
        }
//        结点 right = 反 str list val high
        return root;
    }


    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode node = new TreeNode(2);
        node.left = new TreeNode(1);
        node.right = new TreeNode(3);
        String serialize = codec.serialize(node);
        System.out.println(serialize);
        TreeNode deserialize = codec.deserialize(serialize);
    }
}
