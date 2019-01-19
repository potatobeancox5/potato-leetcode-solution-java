package com.potato.study.leetcode.p0535;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author liuzhao11
 * 
 *         535. Encode and Decode TinyURL
 * 
 *        Note: This is a companion problem to the System Design problem: Design TinyURL.
TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk.

Design the encode and decode methods for the TinyURL service. There is no restriction on how your encode/decode algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.
 * 
 * 
 *         思路：
 *         竟然是利用hashcode和缓存
 */
public class Codec {

    private static Map<String, String> code2Url = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String prefix = "http://tinyurl.com/";
        String code = "" + longUrl.hashCode();
        code2Url.put(code, longUrl);
        return prefix + code;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String code = shortUrl.substring(19);
        return code2Url.get(code);
    }
	
	public static void main(String[] args) {

	}
}
