package com.potato.study.leetcodecn.p00210.t001;

/**
 * 211. 添加与搜索单词 - 数据结构设计
 *
 * 请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。

 实现词典类 WordDictionary ：

 WordDictionary() 初始化词典对象
 void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
 bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回  false 。word 中可能包含一些 '.' ，每个 . 都可以表示任何一个字母。
  

 示例：

 输入：
 ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
 [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
 输出：
 [null,null,null,null,false,true,true,true]

 解释：
 WordDictionary wordDictionary = new WordDictionary();
 wordDictionary.addWord("bad");
 wordDictionary.addWord("dad");
 wordDictionary.addWord("mad");
 wordDictionary.search("pad"); // return False
 wordDictionary.search("bad"); // return True
 wordDictionary.search(".ad"); // return True
 wordDictionary.search("b.."); // return True
  

 提示：

 1 <= word.length <= 500
 addWord 中的 word 由小写英文字母组成
 search 中的 word 由 '.' 或小写英文字母组成
 最多调用 50000 次 addWord 和 search

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/design-add-and-search-words-data-structure
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class WordDictionary {

    private WordDictionaryNode head;

    /** Initialize your data structure here. */
    public WordDictionary() {
        this.head = new WordDictionaryNode();
        head.next = new WordDictionaryNode[26];
    }

    public void addWord(String word) {
        head.addWord(word);
    }

    public boolean search(String word) {
        return head.search(word);
    }



    class WordDictionaryNode {

        // 当前字母
        public char ch;

        // 下一个字母
        public WordDictionaryNode[] next;


        public boolean isEndNode;


        /**
         * 将 word 插入 当前树
         * @param word
         */
        public void addWord(String word) {
            WordDictionaryNode node = this;
            WordDictionaryNode[] next = node.next;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (next == null) {
                    next = new WordDictionaryNode[26];
                }
                // 是否存在
                int index = ch - 'a';
                if (next[index] == null) {
                    next[index] = new WordDictionaryNode();
                    next[index].ch = ch;
                    next[index].next = new WordDictionaryNode[26];
                }
                node = next[index];
                next = node.next;
                // 最后一个点
                if (i == word.length() - 1) {
                    node.isEndNode = true;
                }
            }
        }

        /**
         * 查找
         * @param word
         * @return
         */
        public boolean search(String word) {
            WordDictionaryNode node = this;
            WordDictionaryNode[] next = node.next;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (next == null) {
                    return false;
                }
                // 处理 .
                if ('.' == ch) {

                } else {
                    // 是否存在
                    int index = ch - 'a';
                    if (next[index] == null) {
                        return false;
                    }
                    node = next[index];
                    next = node.next;
                }
            }
            return node.isEndNode;
        }
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad"));// return False
        System.out.println(wordDictionary.search("bad"));// return True
        System.out.println(wordDictionary.search(".ad"));// return True
        System.out.println(wordDictionary.search("b.."));// return True

    }


}
