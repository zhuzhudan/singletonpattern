package com.study.pattern.singleton.threadlocal;

/**
 * ThreadLocal 跨线程不唯一
 *
 * 优点：单线程内部是唯一的
 * 缺点：不能保证在跨线程下唯一
 */
public class ThreadLocalSingleton {
    private ThreadLocalSingleton(){}

    private static final ThreadLocal<ThreadLocalSingleton> threadLocalInstance = new ThreadLocal<ThreadLocalSingleton>(){
        @Override
        protected ThreadLocalSingleton initialValue() {
            return new ThreadLocalSingleton();
        }
    };

    public static ThreadLocalSingleton getInstance(){
        return threadLocalInstance.get();
    }
}
