package com.study.pattern.singleton.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 容器式单例
 *
 * 优点：便于管理
 * 缺点：线程不安全
 */
public class ContainerSingleton {
    private ContainerSingleton(){}

    private static Map<String, Object> instance = new ConcurrentHashMap<String, Object>();

    public static Object getInstance(String className){
        synchronized (instance){ // 由于方法线程不安全，使用synchronized保证线程安全，有损性能
            if(!instance.containsKey(className)){
                Object object = null;
                try{
                    object = Class.forName(className).newInstance();
                    instance.put(className, object);
                } catch (Exception e){
                    e.printStackTrace();
                }
                return object;
            } else {
                return instance.get(className);
            }
        }
    }

}
