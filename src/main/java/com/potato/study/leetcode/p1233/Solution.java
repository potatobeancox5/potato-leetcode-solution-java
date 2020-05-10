package com.potato.study.leetcode.p1233;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 * 	1233. Remove Sub-Folders from the Filesystem
 *  
 *      Given a list of folders, remove all sub-folders in those folders and return in any order the folders after removing.

If a folder[i] is located within another folder[j], it is called a sub-folder of it.

The format of a path is one or more concatenated strings of the form: / followed by one or more lowercase English letters. For example, /leetcode and /leetcode/problems are valid paths while an empty string and / are not.



Example 1:

Input: folder = ["/a","/a/b","/c/d","/c/d/e","/c/f"]
Output: ["/a","/c/d","/c/f"]
Explanation: Folders "/a/b/" is a subfolder of "/a" and "/c/d/e" is inside of folder "/c/d" in our filesystem.
Example 2:

Input: folder = ["/a","/a/b/c","/a/b/d"]
Output: ["/a"]
Explanation: Folders "/a/b/c" and "/a/b/d/" will be removed because they are subfolders of "/a".
Example 3:

Input: folder = ["/a/b/c","/a/b/ca","/a/b/d"]
Output: ["/a/b/c","/a/b/ca","/a/b/d"]


Constraints:

1 <= folder.length <= 4 * 10^4
2 <= folder[i].length <= 100
folder[i] contains only lowercase letters and '/'
folder[i] always starts with character '/'
Each folder name is unique.
 *         
 *
 *
 *         思路：
 *
 *          1233. Remove Sub-Folders from the Filesystem

https://leetcode-cn.com/problems/remove-sub-folders-from-the-filesystem/solution/javaxian-pai-xu-ran-hou-cha-kan-shi-fou-shi-gong-g
 *
 *      先排序，然后查看是否是公共前缀，是则继续往后遍历，否则add到resList
 *
 */
public class Solution {

    public List<String> removeSubfolders(String[] folder) {
        // 排序
        Arrays.sort(folder);
        // 依次 找 当前记录前缀和 当前path startwith 看是不是前缀 不是的话 说明是 target
        List<String> result = new ArrayList<>();
        String prefix = folder[0];
        for (int i = 1; i < folder.length; i++) {
            if (folder[i].startsWith(prefix) && folder[i].charAt(prefix.length()) == '/') {
                continue;
            } else {
                result.add(prefix);
                prefix = folder[i];
            }
        }
        result.add(prefix);
        return result;
    }
	
	public static void main(String[] args) {
    }

}
