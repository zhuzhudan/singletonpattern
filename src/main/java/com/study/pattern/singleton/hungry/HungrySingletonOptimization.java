package com.study.pattern.singleton.hungry;

import java.io.Serializable;

/**
 * 优化后的饿汉式
 * 此方法防止反射攻击
 *
 * 优点：没有锁，效率高，线程安全，防止反射攻击，防止反序列化攻击
 * 缺点：浪费内存空间
 */
public class HungrySingletonOptimization implements Serializable {
    private static final HungrySingletonOptimization HUNGRY_SINGLETON_OPTIMIZATION;
    static {
        HUNGRY_SINGLETON_OPTIMIZATION = new HungrySingletonOptimization();
    }
    private HungrySingletonOptimization(){
        if(HUNGRY_SINGLETON_OPTIMIZATION != null){
            throw new RuntimeException("不允许创建多个实例");
        }
    }

    public static HungrySingletonOptimization getInstance(){
        return HUNGRY_SINGLETON_OPTIMIZATION;
    }

    //重写readResolve()方法，只不过是覆盖了反序列化出来的对象，防止反序列化攻击
    //还是创建了两次，发生在JVM层面，相对来说比较安全
    //之前反序列化出来的对象会被GC回收
    private  Object readResolve(){
        return  HUNGRY_SINGLETON_OPTIMIZATION;
    }
}
