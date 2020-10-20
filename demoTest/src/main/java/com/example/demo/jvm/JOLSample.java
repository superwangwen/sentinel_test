package com.example.demo.jvm;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.openjdk.jol.info.ClassLayout;

/**
 * @author ww
 * @date 2020/6/15 11:29
 * @vsersion 1.0
 */
public class JOLSample {

    //启用指针压缩:­XX:+UseCompressedOops(默认开启)，禁止指针压缩:­XX:­UseCompressedOops
    public static void main(String[] args) {
        ClassLayout layout = ClassLayout.parseInstance(new Object());
        System.out.println(layout.toPrintable());
        System.out.println();

        ClassLayout layout1 = ClassLayout.parseInstance(new int[]{});
        System.out.println(layout1.toPrintable());
        System.out.println();

        ClassLayout layout2 = ClassLayout.parseInstance(new A());
        System.out.println(layout2.toPrintable());
        System.out.println();
    }

    public static class A {
        int id; //4b
        String name; //4b
        byte b; //1b
        Object o; //4b
    }

}
