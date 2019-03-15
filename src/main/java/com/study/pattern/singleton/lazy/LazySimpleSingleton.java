package com.study.pattern.singleton.lazy;

/**
 * 懒汉式：被外部方法调用，才会创建实例
 * 锁定方法
 *
 * 优点：线程安全，懒加载（用到时才加载）节省内存
 * 缺点：使用synchronized会产生性能问题，线程数量较多时，CPU分配压力上升，会导致大量线程出现阻塞
 */
public class LazySimpleSingleton {
    private static LazySimpleSingleton lazySimpleSingleton = null;

    private LazySimpleSingleton(){}

    //如果不加synchronized，多线程下会创建多个实例
    public synchronized static LazySimpleSingleton getInstance(){
        if(lazySimpleSingleton == null){
            lazySimpleSingleton = new LazySimpleSingleton();
        }
        return lazySimpleSingleton;
    }
}
