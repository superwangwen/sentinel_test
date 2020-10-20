package com.example.demo.jvm;

/**
 * @author ww
 * @date 2020/6/15 14:19
 * @vsersion 1.0
 */
public class AlloOnStack {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            alloc();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    private static void alloc() {
        User user = new User();
        user.setId(1);
        user.setName("ww");
    }

}
