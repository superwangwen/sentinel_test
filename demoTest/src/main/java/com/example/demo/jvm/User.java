package com.example.demo.jvm;

/**
 * @author ww
 * @date 2020/6/11 14:33
 * @vsersion 1.0
 */
public class User {

    private int id;

    private String name;

    public User() {

    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sout() {
        System.out.println("---------自定义加载器读取----------");
    }


}
