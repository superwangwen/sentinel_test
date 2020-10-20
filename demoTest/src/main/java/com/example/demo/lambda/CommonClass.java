package com.example.demo.lambda;

public class CommonClass implements InterfaceTest {

    public CommonClass() {

    }

    //想要使用lambda通过new普通类实现接口方法的实现需要写此含接口的构造器
    public CommonClass(InterfaceTest interfaceTest) {

    }

    public void ccc() {
        System.out.println("cccc");
    }


    @Override
    public void aaa() {
        System.out.println("普通类从接口继承");
    }
}
