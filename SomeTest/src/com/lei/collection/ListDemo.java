package com.lei.collection;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author zhulei
 * @create 2021-04-22 22:36
 */
public class ListDemo {
    public static void main(String[] args) {

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(123);

        LinkedList<Integer> linkedList = new LinkedList<>();
        arrayList.add(0,111);

        for (Integer integer : arrayList) {
            System.out.println(integer);
        }

    }
}
