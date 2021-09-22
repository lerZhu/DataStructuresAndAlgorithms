package com.lei.solution;

import java.util.*;

/**
 * @author zhulei
 * @create 2021-05-01 21:59
 */
public class RandomizedSetDemo {
    public static void main(String[] args) {
        // 初始化一个空的集合。
        RandomizedSet randomSet = new RandomizedSet();

        // 向集合中插入 1 。返回 true 表示 1 被成功地插入。
        boolean insert = randomSet.insert(1);
        System.out.println(insert);

        // 返回 false ，表示集合中不存在 2 。
        boolean remove = randomSet.remove(2);
        System.out.println(remove);

        // 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
        insert = randomSet.insert(2);
        System.out.println(insert);

        // getRandom 应随机返回 1 或 2 。
        int random = randomSet.getRandom();
        System.out.println(random);

        // 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
        remove = randomSet.remove(1);
        System.out.println(remove);

        // 2 已在集合中，所以返回 false 。
        insert = randomSet.insert(2);
        System.out.println(insert);

        // 由于 2 是集合中唯一的数字，getRandom 总是返回 2 。
        random = randomSet.getRandom();
        System.out.println(random);

    }
}

class RandomizedSet {

    Set<Integer> set;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        set = new HashSet<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        return set.add(val);
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        return set.remove(val);
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        Random random = new Random();
        int index = random.nextInt(set.size());
        int temp = 0;
        for (Integer integer : set) {
            if (index == temp) {
                return integer;
            }
            temp++;
        }
        return -1;
    }
}