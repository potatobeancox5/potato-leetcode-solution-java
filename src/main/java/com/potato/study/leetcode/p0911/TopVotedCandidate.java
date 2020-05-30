package com.potato.study.leetcode.p0911;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author liuzhao11
 * 
 * 	911. Online Election
 *  
 *      In an election, the i-th vote was cast for persons[i] at time times[i].

Now, we would like to implement the following query function: TopVotedCandidate.q(int t) will return the number of the person that was leading the election at time t.

Votes cast at time t will count towards our query.  In the case of a tie, the most recent vote (among tied candidates) wins.



Example 1:

Input: ["TopVotedCandidate","q","q","q","q","q","q"], [[[0,1,1,0,0,1,0],[0,5,10,15,20,25,30]],[3],[12],[25],[15],[24],[8]]
Output: [null,0,1,1,0,0,1]
Explanation:
At time 3, the votes are [0], and 0 is leading.
At time 12, the votes are [0,1,1], and 1 is leading.
At time 25, the votes are [0,1,1,0,0,1], and 1 is leading (as ties go to the most recent vote.)
This continues for 3 more queries at time 15, 24, and 8.


Note:

1 <= persons.length = times.length <= 5000
0 <= persons[i] <= persons.length
times is a strictly increasing array with all elements in [0, 10^9].
TopVotedCandidate.q is called at most 10000 times per test case.
TopVotedCandidate.q(int t) is always called with t >= times[0].

 *         
 *         题目含义：
 *
 *         思路：
 *
 *
 *
 *
 */
public class TopVotedCandidate {

    class Vote {
        int person, time;
        Vote(int p, int t) {
            person = p;
            time = t;
        }
    }

    private List<Vote> list;

    public TopVotedCandidate(int[] persons, int[] times) {
        list = new ArrayList<>();
        Map<Integer, Integer> count = new HashMap<>();
        int leader = -1;  // current leader
        int m = 0;  // current number of votes for leader

        for (int i = 0; i < persons.length; ++i) {
            int p = persons[i], t = times[i];
            int c = count.getOrDefault(p, 0) + 1;
            count.put(p, c);

            if (c >= m) {
                if (p != leader) {  // lead change
                    leader = p;
                    list.add(new Vote(leader, t));
                }

                if (c > m) {
                    m = c;
                }
            }
        }
    }


    public int q(int t) {
        int lo = 1, hi = list.size();
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (list.get(mi).time <= t) {
                lo = mi + 1;
            } else {
                hi = mi;
            }
        }
        return list.get(lo - 1).person;
    }
}


