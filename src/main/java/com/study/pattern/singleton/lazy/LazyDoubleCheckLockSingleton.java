package com.study.pattern.singleton.lazy;

/**
 * 懒汉式
 * 双重检查锁
 *
 * 优点：线程安全，懒加载（用到时才加载）节省内存，锁住代码块比锁方法性能有所提升
 * 缺点：使用synchronized
 */
public class LazyDoubleCheckLockSingleton {
    //volatile可保证变量的对内存的可见性，有序性
    //可见性：强制变量赋值时，会同步刷新回主内存；强制变量的读取，会从主内存中重新加载
    //有序性：防止指令重排序，保证变量读写的有序性
    private volatile static LazyDoubleCheckLockSingleton lazyDoubleCheckLockSingleton = null;

    private LazyDoubleCheckLockSingleton(){}

    public static LazyDoubleCheckLockSingleton getInstance(){
        if(lazyDoubleCheckLockSingleton == null){ // 可进入方法
            synchronized (LazyDoubleCheckLockSingleton.class){
                if(lazyDoubleCheckLockSingleton == null){ // 防止多次初始化
                    lazyDoubleCheckLockSingleton = new LazyDoubleCheckLockSingleton();
                }
            }
        }
        return lazyDoubleCheckLockSingleton;
    }
}
