package com.study.pattern.singleton;

import com.study.pattern.singleton.hungry.HungrySingletonOptimization;
import com.study.pattern.singleton.lazy.*;
import com.study.pattern.singleton.register.ContainerSingleton;
import com.study.pattern.singleton.register.EnumSingleton;
import com.study.pattern.singleton.threadlocal.ThreadLocalSingleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Test {
    public static void main(String[] args) {
        //测试反射攻击，通过反射创建多个实例
//        try{
//            //进行破坏
////            Class<?> clazz = HungrySingletonOptimization.class;
//            Class<?> clazz = LazyDCLSingletonOptimization.class;
//
//            //通过反射拿到私有的构造方法
//            Constructor c = clazz.getDeclaredConstructor(null);
//            c.setAccessible(true);
//
//            //初始化
//            Object o1 = c.newInstance();
//            Object o2 = c.newInstance();

//            System.out.println(o1 == o2);
//        }catch (Exception e){
//            e.printStackTrace();
//        }

//        EnumSingleton singleton1 = null;
//        EnumSingleton singleton2 = EnumSingleton.getInstance();
//        //测试序列化和反序列化攻击
//        FileOutputStream fileOutputStream = null;
//        try{
//            fileOutputStream = new FileOutputStream("SeriableTest.obj");
//            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
//            objectOutputStream.writeObject(singleton2);
//            objectOutputStream.flush();
//            objectOutputStream.close();
//
//            FileInputStream inputStream = new FileInputStream("SeriableTest.obj");
//            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
//            singleton1 = (EnumSingleton)objectInputStream.readObject();
//            objectInputStream.close();
//
//            System.out.println(singleton1);
//            System.out.println(singleton2);
//            System.out.println(singleton1 == singleton2);
//        } catch (Exception e){
//            e.printStackTrace();
//        }

        //测试多线程是否安全
        int threadNum = 5;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(threadNum);
        for (int i = 0; i < threadNum; i++) {
            new Thread(new Worker(cyclicBarrier)).start();
        }
    }

    static class Worker implements Runnable {
        CyclicBarrier cyclicBarrier;

        public Worker(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            try {
                cyclicBarrier.await();
//                try {
//                    //进行破坏
//                    Class<?> clazz = LazyDCLSingletonOptimization.class;
//
//                    //通过反射拿到私有的构造方法
//                    Constructor c = clazz.getDeclaredConstructor(null);
//                    c.setAccessible(true);
//
//                    //初始化
//                    Object o1 = c.newInstance();
//                    System.out.println(Thread.currentThread().getName() + ":"
//                            + o1);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                System.out.println(Thread.currentThread().getName()+":"+HungrySingletonOptimization.getInstance());
//                System.out.println(Thread.currentThread().getName() + ":"
//                        + LazyInnerClassSingleton.getInstance());
//                System.out.println(Thread.currentThread().getName()+":"+ContainerSingleton.getInstance("com.study.pattern.singleton.Pojo"));
                System.out.println(Thread.currentThread().getName()+":"+ThreadLocalSingleton.getInstance());
                System.out.println(Thread.currentThread().getName()+":"+ThreadLocalSingleton.getInstance());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
