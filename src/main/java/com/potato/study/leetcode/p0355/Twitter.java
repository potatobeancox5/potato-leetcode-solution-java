package com.potato.study.leetcode.p0355;

import org.junit.Assert;

import java.util.*;

/**
 * 
 * @author liuzhao11
 * 
 *       355. Design Twitter
 * 
 *      Design a simplified version of Twitter where users can post tweets, follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed. Your design should support the following methods:

postTweet(userId, tweetId): Compose a new tweet.
getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
follow(followerId, followeeId): Follower follows a followee.
unfollow(followerId, followeeId): Follower unfollows a followee.
Example:

Twitter twitter = new Twitter();

// User 1 posts a new tweet (id = 5).
twitter.postTweet(1, 5);

// User 1's news feed should return a list with 1 tweet id -> [5].
twitter.getNewsFeed(1);

// User 1 follows user 2.
twitter.follow(1, 2);

// User 2 posts a new tweet (id = 6).
twitter.postTweet(2, 6);

// User 1's news feed should return a list with 2 tweet ids -> [6, 5].
// Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
twitter.getNewsFeed(1);

// User 1 unfollows user 2.
twitter.unfollow(1, 2);

// User 1's news feed should return a list with 1 tweet id -> [5],
// since user 1 is no longer following user 2.
twitter.getNewsFeed(1);
 *         
 *         思路：
 *         355. Design Twitter

https://cloud.tencent.com/developer/article/1405260

考察数据结构设计能力

user属性
id  用户id
tweet 最新推特 （链表形式）
关注用户set

系统有一个hashmap key是用户id value 是用户实体

tweet 属性
id
message string
创建时间戳
next 指向下一个消息 比这个消息旧

获取消息采用优先队列 每次pop时候加入pop元素denext
 *        
 */
public class Twitter {

    class User {
        public int id;
        public Message msg;
        public Set<Integer> attentionUserIds;

        public User(int id, Message msg) {
            this.id = id;
            this.msg = msg;
            this.attentionUserIds = new HashSet<>();
        }
    }

    /**
     * 消息对象
     */
    class Message {
        public int id;
//        public String msg;
        public long timeStamp;
        // 指向下一个消息
        public Message next;

        public Message(int id, long timeStamp) {
            this.id = id;
//            this.msg = msg;
            this.timeStamp = timeStamp;
        }
    }

//    private int userGenerateId = 0;

    private long currentTime = 0;

    private Map<Integer, User> userId2UserMap;

    /** Initialize your data structure here. */
    public Twitter() {
        this.userId2UserMap = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        User user = userId2UserMap.get(userId);
        Message message = new Message(tweetId, currentTime++);
        if (null == user) {
            user = new User(userId, message);
            userId2UserMap.put(userId, user);
        } else {
            message.next = user.msg;
            user.msg = message;
        }
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        User user = userId2UserMap.get(userId);
        if (null == user) {
            user = new User(userId, null);
            userId2UserMap.put(userId, user);
        }
        Set<Integer> attentionUserIds = user.attentionUserIds;
        // 小根堆 先放所有关注啊用户的信息
        PriorityQueue<Message> priorityQueue = new PriorityQueue<>(new Comparator<Message>() {
            @Override
            public int compare(Message o1, Message o2) {
                return (int)(o2.timeStamp - o1.timeStamp);
            }
        });
        if (null != attentionUserIds) {
            for (int uid : attentionUserIds) {
                User attention = userId2UserMap.get(uid);
                if (attention.msg != null) {
                    priorityQueue.add(attention.msg);
                }
            }
        }
        if (user.msg != null) {
            priorityQueue.add(user.msg);
        }
        List<Integer> res = new ArrayList<>();
        while (!priorityQueue.isEmpty() && res.size() < 10) {
            Message newMsg = priorityQueue.poll();
            res.add(newMsg.id);
            if (newMsg.next != null) {
                priorityQueue.add(newMsg.next);
            }
        }
        return res;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        User follower = userId2UserMap.get(followerId);
        if (null == follower) {
            follower = new User(followerId, null);
            userId2UserMap.put(followerId, follower);
        }
        if (followerId == followeeId) {
            return;
        }
        User followee = userId2UserMap.get(followeeId);
        if (null == followee) {
            followee = new User(followeeId, null);
            userId2UserMap.put(followeeId, followee);
        }
        if (!follower.attentionUserIds.contains(followeeId)) {
            follower.attentionUserIds.add(followeeId);
        }
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        User follower = userId2UserMap.get(followerId);
        if (null == follower) {
            follower = new User(followerId, null);
            userId2UserMap.put(followerId, follower);
        }
        User followee = userId2UserMap.get(followeeId);
        if (null == followee) {
            followee = new User(followeeId, null);
            userId2UserMap.put(followeeId, followee);
        }
        if (follower.attentionUserIds.contains(followeeId)) {
            follower.attentionUserIds.remove(followeeId);
        }
    }
	
	public static void main(String[] args) {
//["Twitter","postTweet","getNewsFeed","follow","postTweet","getNewsFeed","unfollow","getNewsFeed"]
//[[],        [1,5],       [1],         [1,2],    [2,6],        [1],        [1,2],     [1]]
        Twitter twitter = new Twitter();
        twitter.postTweet(1,5);
        System.out.println(twitter.getNewsFeed(1));
        twitter.follow(1,2);
        twitter.postTweet(2,6);
        System.out.println(twitter.getNewsFeed(1));
        twitter.unfollow(1, 2);
        System.out.println(twitter.getNewsFeed(1));

    }
}
