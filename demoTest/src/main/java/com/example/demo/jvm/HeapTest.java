package com.example.demo.jvm;

import java.util.ArrayList;

/**
 * @author ww
 * @date 2020/6/13 12:12
 * @vsersion 1.0
 */
public class HeapTest {

    byte[] a = new byte[1024 * 100];

    public static void main(String[] args) throws Exception {
        ArrayList<HeapTest> arrayList = new ArrayList();
        while (true) {
            arrayList.add(new HeapTest());
            Thread.sleep(10);
        }
    }
}
