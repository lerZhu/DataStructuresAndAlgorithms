package com.lei.solution;

import java.security.interfaces.ECKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhulei
 * @create 2021-04-24 23:27
 */
public class FirstUniqChar {
    public static void main(String[] args) {
        String s = "loveleetcode";
        int i = firstUniqChar(s);
        System.out.println(i);
    }

    public static int firstUniqChar(String s) {

        Map<Character,Integer> map = new HashMap<>();
        List<Character> list = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == null) {
                map.put(s.charAt(i),1);
            }else {
                int count = map.get(s.charAt(i));
                map.put(s.charAt(i),++count);
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                list.add(entry.getKey());
            }
        }
        if (list.size() == 0) {
            return -1;
        }else {
            index = s.indexOf(list.get(0));
            for (int i = 0; i < list.size(); i++) {
                index = (index < s.indexOf(list.get(i))) ? index : s.indexOf(list.get(i));
            }
        }
        return index;
    }
}
