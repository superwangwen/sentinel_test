//package java.lang;
//
//public class String {
//
//    //沙箱安全机制
//    //父加载器会先加载自己的String.class,我们自定义的找到了父类加载的
//    //就不会再次加载,java自带的String类中没有main方法,所以会报错
//    public static void main(String[] args) {
//        System.out.println("my String class");
//    }
//
//    public void sout() {
//        System.out.println("我是自定义String的sout()方法");
//    }
//
//}
