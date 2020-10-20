package com.example.demo.juc;

public class Reordering {
    public static void main(String[] args) {
        int x;
        int y;
        x = 1;
        try {
            x = 2;
            y = 0 / 0;
        } catch (Exception e) {

        } finally {
            System.out.println("x = " + x);
        }

    }

}
