package com.study.pattern.singleton.lazy;

/**
 * 防止反射攻击的双重检查锁
 *
 * 优点：单线程下可防止反射攻击
 * 缺点：存在竞争条件，多线程下不安全
 */
public class LazyDCLSingletonOptimization {
    private static volatile LazyDCLSingletonOptimization instance = null;
    private static boolean state = false;

    private LazyDCLSingletonOptimization(){
        if(LazyDCLSingletonOptimization.state){// 竞争条件，导致线程不安全，除非加锁
            throw new RuntimeException("不能创建两个实例");
        }
        LazyDCLSingletonOptimization.state = true;
    }

    public static LazyDCLSingletonOptimization getInstance(){
        if(instance == null){
            synchronized(LazyDCLSingletonOptimization.class){
                if(instance == null){
                    instance = new LazyDCLSingletonOptimization();
                }
            }
        }
        return instance;
    }
}
