package com.example.demo.jvm;

/**
 * @author ww
 * @date 2020/6/13 12:04
 * @vsersion 1.0
 */
public class StackOverflowTest {

    static int count = 0;

    static void redo(){
        count++;
        redo();
    }

    public static void main(String[] args) {
        try{
            redo();
        }catch(Throwable t){
            t.printStackTrace();
            System.out.println(count);
        }
    }
}
