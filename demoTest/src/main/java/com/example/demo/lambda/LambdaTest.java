package com.example.demo.lambda;


import org.testng.annotations.Test;

import java.util.Arrays;

public class LambdaTest {

    String[] arr = {"program", "creek", "is", "a", "java", "site"};

    private volatile String str = "11";

    @Test
    public void test1() {
        Arrays.sort(arr, (m, n) -> Integer.compare(m.length(), n.length()));
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test2() {
        new InterfaceTest() {
            @Override
            public void aaa() {
                System.out.println("a1");
            }
        }.aaa();
    }

    @Test
    public void test3() {
        InterfaceTest interfaceTest = (() -> System.out.println("--b1--"));
        interfaceTest.aaa();
    }

    @Test
    public void test4() {
        new CommonClass(new CommonClass() {
            @Override
            public void aaa() {
                System.out.println("--commo--");
            }
        });
    }

    @Test
    public void test5() {
        new CommonClass(() -> System.out.println("--test5--"));
    }

}
