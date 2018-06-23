package com.potato.study.leetcode.p0133;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import com.potato.study.leetcode.domain.UndirectedGraphNode;

/**
 * 
 * @author liuzhao11
 * 
 *      133. Clone Graph
 *         
 *    Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


OJ's undirected graph serialization:
Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/
 *         
 *         思路：
 *         使用一个map纪录 当前已经存在的节点
 *         类似bfs进行简历图
 *         遇到圈怎么半 使用一个set 纪录当前已经 便利过的节点 的value
 *        
 * 
 */
public class Solution {
	
	
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {

		if(node == null) {
			return null;
		}
		// bfs
		Queue<UndirectedGraphNode> queue = new LinkedList<>();
		Set<Integer> set = new HashSet<>();// 防止重复便利
		queue.add(node);
		set.add(node.label);
		// 新创建的节点
		UndirectedGraphNode head = new UndirectedGraphNode(node.label);
		Map<Integer, UndirectedGraphNode> map = new HashMap<>();
		map.put(head.label, head);
		while(!queue.isEmpty()) {
			// 业务逻辑 创建新的节点 或者获取之前创建的节点 一般来说都是创建过的节点
			UndirectedGraphNode cur = queue.poll();
			UndirectedGraphNode newNode = map.get(cur.label);
			if(cur.neighbors != null && cur.neighbors.size() > 0) {
				for (UndirectedGraphNode ne : cur.neighbors) {
					if(!set.contains(ne.label)) {
						queue.add(ne);
						set.add(ne.label);
					}
					// 业务逻辑 链接新建的节点和他们的邻居 没有邻居创建邻居并链接
					if(!map.containsKey(ne.label)) {
						UndirectedGraphNode newNe = new UndirectedGraphNode(ne.label);
						map.put(newNe.label, newNe);
						if(newNode.neighbors == null) {
							newNode.neighbors = new ArrayList<>();
						}
						newNode.neighbors.add(newNe);
					} else {
						newNode.neighbors.add(map.get(ne.label));
					}
				}
			}
		}
		return head;
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		UndirectedGraphNode head = new UndirectedGraphNode(0);
		UndirectedGraphNode node1 = new UndirectedGraphNode(1);
		UndirectedGraphNode node2 = new UndirectedGraphNode(2);
		head.neighbors = new ArrayList<>();
		head.neighbors.add(node1);
		node1.neighbors.add(node2);
		node2.neighbors.add(node2);
		Solution solution = new Solution();
		solution.cloneGraph(head);
		
	}
}
