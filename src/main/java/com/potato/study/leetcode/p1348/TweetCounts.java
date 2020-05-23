package com.potato.study.leetcode.p1348;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 
 * @author liuzhao11
 * 
 * 	1348. Tweet Counts Per Frequency
 *  
 *
Implement the class TweetCounts that supports two methods:

1. recordTweet(string tweetName, int time)

Stores the tweetName at the recorded time (in seconds).
2. getTweetCountsPerFrequency(string freq, string tweetName, int startTime, int endTime)

Returns the total number of occurrences for the given tweetName per minute, hour, or day (depending on freq) starting from the startTime (in seconds) and ending at the endTime (in seconds).
freq is always minute, hour or day, representing the time interval to get the total number of occurrences for the given tweetName.
The first time interval always starts from the startTime, so the time intervals are [startTime, startTime + delta*1>,  [startTime + delta*1, startTime + delta*2>, [startTime + delta*2, startTime + delta*3>, ... , [startTime + delta*i, min(startTime + delta*(i+1), endTime + 1)> for some non-negative number i and delta (which depends on freq).


Example:

Input
["TweetCounts","recordTweet","recordTweet","recordTweet","getTweetCountsPerFrequency","getTweetCountsPerFrequency","recordTweet","getTweetCountsPerFrequency"]
[[],["tweet3",0],["tweet3",60],["tweet3",10],["minute","tweet3",0,59],["minute","tweet3",0,60],["tweet3",120],["hour","tweet3",0,210]]

Output
[null,null,null,null,[2],[2,1],null,[4]]

Explanation
TweetCounts tweetCounts = new TweetCounts();
tweetCounts.recordTweet("tweet3", 0);
tweetCounts.recordTweet("tweet3", 60);
tweetCounts.recordTweet("tweet3", 10);                             // All tweets correspond to "tweet3" with recorded times at 0, 10 and 60.
tweetCounts.getTweetCountsPerFrequency("minute", "tweet3", 0, 59); // return [2]. The frequency is per minute (60 seconds), so there is one interval of time: 1) [0, 60> - > 2 tweets.
tweetCounts.getTweetCountsPerFrequency("minute", "tweet3", 0, 60); // return [2, 1]. The frequency is per minute (60 seconds), so there are two intervals of time: 1) [0, 60> - > 2 tweets, and 2) [60,61> - > 1 tweet.
tweetCounts.recordTweet("tweet3", 120);                            // All tweets correspond to "tweet3" with recorded times at 0, 10, 60 and 120.
tweetCounts.getTweetCountsPerFrequency("hour", "tweet3", 0, 210);  // return [4]. The frequency is per hour (3600 seconds), so there is one interval of time: 1) [0, 211> - > 4 tweets.


Constraints:

There will be at most 10000 operations considering both recordTweet and getTweetCountsPerFrequency.
0 <= time, startTime, endTime <= 10^9
0 <= endTime - startTime <= 10^4
 *         
 *         思路：
 *          https://leetcode-cn.com/problems/tweet-counts-per-frequency/solution/ordered-mapsi-xiang-yong-hu-tui-wen-shi-jian-tui-w/
 *
 *
 */
public class TweetCounts {

    // key 用户->推文时间->该时间推文发布数目
    private Map<String, TreeMap<Integer,Integer>> userTweetMap;

    public TweetCounts() {
        userTweetMap = new HashMap<>();
    }


    public void recordTweet(String tweetName, int time) {
        // 当前用户推文集合
        TreeMap<Integer, Integer> tweetMap = userTweetMap.computeIfAbsent(tweetName, k -> new TreeMap<>());
        // 推文时间记录，比之前次数多1
        tweetMap.put(time,tweetMap.getOrDefault(time,0) + 1);// 推文加入
    }

    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {

        List<Integer> res = new ArrayList<>();
        if (!userTweetMap.containsKey(tweetName)){
            res.add(0);
            return res;
        }
        int freqTime = 1;
        if ("minute".equals(freq)){
            freqTime = 60;
        }else if ("hour".equals(freq)){
            freqTime = 3600;
        }else if ("day".equals(freq)){
            freqTime = 86400;
        }
        // 用户的全部推文时间集合
        TreeMap<Integer,Integer> tweetMap = userTweetMap.get(tweetName);
        int start = startTime;
        int end = Math.min(start + freqTime,endTime + 1);
        while (start <= endTime){
            int count = 0;
            // 找到发文时间大于等于start的推文
            Map.Entry<Integer,Integer> entry = tweetMap.ceilingEntry(start);
            while (entry != null && entry.getKey() < end){
                count += entry.getValue();// 推文数累加
                // 找比当前大的推文时间
                entry = tweetMap.higherEntry(entry.getKey());
            }
            res.add(count);
            // 时间后移
            start = end;
            end = Math.min(end + freqTime,endTime + 1);
        }
        return res;
    }
}
