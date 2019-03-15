package com.study.pattern.singleton.lazy;

/**
 * 防止反射攻击的静态内部类
 *
 * 优点：由于没有使用synchronized，性能较高，节约内存，线程安全
 */
public class LazyInnerClassSingletonOptimization {
    private LazyInnerClassSingletonOptimization(){
        //防止反射攻击
        if(LazyHolder.LAZY_INSTANCE != null){
            throw new RuntimeException("不能初始化两个实例");
        }
    }

    public static final LazyInnerClassSingletonOptimization getInstace(){
        return LazyHolder.LAZY_INSTANCE;
    }

    private static class LazyHolder{
        private static final LazyInnerClassSingletonOptimization LAZY_INSTANCE = new LazyInnerClassSingletonOptimization();
    }
}
