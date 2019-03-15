package com.study.pattern.singleton.lazy;

/**
 * 懒汉式
 * 静态内部类
 *
 * 优点：由于没有使用synchronized，性能较高，节约内存，线程安全
 * 缺点：反射攻击
 */
public class LazyInnerClassSingleton {
    private LazyInnerClassSingleton(){}

    //只有调用此方法时，内部类地逻辑才会执行，懒汉式单例
    public static final LazyInnerClassSingleton getInstance(){
        return LazyHolder.LAZY_INSTANCE;
    }

    //LazyHolder里的逻辑需要等到外部方法调用时才会执行
    //巧妙利用了内部类的特性，完美地避免了线程安全问题
    private static class LazyHolder{
        private static final LazyInnerClassSingleton LAZY_INSTANCE = new LazyInnerClassSingleton();
    }
}
