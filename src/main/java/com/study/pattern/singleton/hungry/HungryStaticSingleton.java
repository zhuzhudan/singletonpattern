package com.study.pattern.singleton.hungry;

/**
 * 饿汉式-直接初始化静态成员
 * 在静态代码块中初始化静态变量，与HungrySingleton效果一样
 *
 * 优点：没有锁，效率高，线程安全
 * 缺点：浪费内存空间
 */
public class HungryStaticSingleton {
    //final保证该常量无法通过反射机制将其覆盖
    private static final HungryStaticSingleton HUNGRY_STATIC_SINGLETON;
    static {
        HUNGRY_STATIC_SINGLETON = new HungryStaticSingleton();
    }

    private HungryStaticSingleton(){}

    public static HungryStaticSingleton getInstance(){
        return HUNGRY_STATIC_SINGLETON;
    }
}
