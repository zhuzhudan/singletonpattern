package com.study.pattern.singleton.register;

/**
 * 枚举单例（反编译后，通过静态代码块中赋值，饿汉式单例的实现）
 *
 * 优点：线程安全，从JDK层面防止了序列化攻击和反射攻击
 */
public enum EnumSingleton {
    INSTANCE;

    public static EnumSingleton getInstance(){
        return INSTANCE;
    }
}
