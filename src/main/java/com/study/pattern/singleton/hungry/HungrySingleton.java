package com.study.pattern.singleton.hungry;

/**
 * 饿汉式
 * 在类加载时立即初始化，在单例类首次加载时就创建实例
 * 优点：没有锁，效率高，线程安全
 * 缺点：浪费内存空间
 */
public class HungrySingleton {
    //final保证该常量无法通过反射机制将其覆盖
    private static final HungrySingleton HUNGRY_SIGLETON = new HungrySingleton();

    private HungrySingleton(){}

    public static HungrySingleton getInstance(){
        return HUNGRY_SIGLETON;
    }

}
