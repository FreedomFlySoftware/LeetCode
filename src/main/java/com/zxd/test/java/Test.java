package com.zxd.test.java;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        long start0 = System.currentTimeMillis();
        List<Integer> list0 = new ArrayList<>(10000000);
        for (int i = 0; i < 10000000; i++){
            list0.add(i);
         }
        System.out.println("耗时:"+(System.currentTimeMillis() - start0));
        long start1 = System.currentTimeMillis();
        List<Integer> list1 = new ArrayList<>(10000000);
        for (int i = 0; i < 10000000; i++){
            list1.add(i);
        }
        System.out.println("耗时:"+(System.currentTimeMillis() - start1));
    }
}
