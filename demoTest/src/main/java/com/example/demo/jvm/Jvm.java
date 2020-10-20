package com.example.demo.jvm;

/**
 * @author ww
 * @date 2020/6/21 10:57
 * @vsersion 1.0
 */
public class Jvm {

    public static void main(String[] args) {
        long maxMemory = Runtime.getRuntime().maxMemory();
        long totalMemory = Runtime.getRuntime().totalMemory();

        System.out.println("虚拟机试图使用的最大内存是: " + maxMemory / (double) 1024 / 1024 + "MB");
        System.out.println("虚拟机总内存: " + totalMemory / (double) 1024 / 1024 + "MB");
        System.out.println(2048 / 1024 + 5632 / 1024);
    }
}
