package com.lei.solution;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author zhulei
 * @create 2021-05-05 22:07
 */
public class IsValid {
    public static void main(String[] args) {
        String s = "(){}[]";
        IsValid isValid = new IsValid();
        System.out.println(isValid.isValid(s));
    }

    private static final Map<Character,Character> map = new HashMap<Character,Character>(){{
        put('{','}');
        put('[',']');
        put('(',')');
        put('?','?');
    }};

    public boolean isValid(String s) {
        if (s.length() > 0 && !map.containsKey(s.charAt(0)))
            return false;
        Stack<Character> stack = new Stack<Character>(){
            {
                add('?');
            }
        };
        for (char c : s.toCharArray()) {
            if (map.containsKey(c))
                stack.push(c);
            else if (map.get(stack.pop()) != c)
                return false;
        }
        return stack.size() == 1;
    }
}
