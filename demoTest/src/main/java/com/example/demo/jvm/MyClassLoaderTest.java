package com.example.demo.jvm;

import java.io.FileInputStream;
import java.io.Serializable;
import java.lang.reflect.Method;

/**
 * 自定义类加载器,实现双亲委派机制
 * 1.继承ClassLoader类
 * 2.实现findClass()方法
 */
public class MyClassLoaderTest {
    static class MyClassLoader extends ClassLoader {
        private String classPath;

        public MyClassLoader(String classPath) {
            this.classPath = classPath;
        }

        private byte[] loadByte(String name) throws Exception {
            name = name.replace(".", "/");
            FileInputStream fis = new FileInputStream(classPath + "/" + name + ".class");
            int len = fis.available();
            byte[] data = new byte[len];
            fis.read(data);
            fis.close();
            return data;
        }

        protected Class<?> findClass(String name) throws ClassNotFoundException {
            try {
                byte[] data = loadByte(name);
                return defineClass(name, data, 0, data.length);
            } catch (Exception e) {
                e.printStackTrace();
                throw new ClassNotFoundException();
            }
        }

        protected Class<?> loadClass(String name, boolean resolve)
                throws ClassNotFoundException {
            synchronized (getClassLoadingLock(name)) {
                // First, check if the class has already been loaded
                Class<?> c = findLoadedClass(name);
                if (c == null) {
                    long t0 = System.nanoTime();
                    if (!name.startsWith("com.example.demo.jvm")) {
                        c = this.getParent().loadClass(name);
                    } else {
                        c = this.findClass(name);
                    }
                    // If still not found, then invoke findClass in order
                    // to find the class.
                    long t1 = System.nanoTime();

                    // this is the defining class loader; record the stats
                    sun.misc.PerfCounter.getParentDelegationTime().addTime(t1 - t0);
                    sun.misc.PerfCounter.getFindClassTime().addElapsedTimeFrom(t1);
                    sun.misc.PerfCounter.getFindClasses().increment();
                }
                if (resolve) {
                    resolveClass(c);
                }
                return c;
            }
        }
    }

    //初始化自定义类加载器,会先初始化父类ClassLoader,其中会把自定义类加载器的父加载器
    //设置为应用程序类加载器AppClassLoader
    //自定义加载的类的路径要和target下项目的包路径保持一致
    public static void main(String[] args) throws Exception {
        MyClassLoader myClassLoader = new MyClassLoader("D:/test");
        //d盘创建 com/example/demo/java/lang 几级目录,将String.class丢入目录
        Class clazz = myClassLoader.loadClass("com.example.demo.jvm.User1");
//        Class clazz = myClassLoader.loadClass("java.lang.String");

        Object obj = clazz.newInstance();
        Method method = clazz.getDeclaredMethod("sout", null);
        method.invoke(obj, null);
        System.out.println(clazz.getClassLoader().getClass().getName());
    }
}
