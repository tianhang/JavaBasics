package com.company;

import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Properties;

public class Main {

    public static void main(String[] args)throws Exception {
	    //java.lang.String
        String str = "tianhang";
        //get java.lang.Class object
        Class cls1 = str.getClass();
        Class cls2 = String.class;
        Class cls3 = Class.forName("java.lang.String");

        //System.out.println(cls1 == cls2);//true
        //System.out.println(cls1 == cls3);//true

        //java.lang.reflect
        //反射就是把java类中的各种成分映射成相应的java类

        //1 Class --> Constructor --> object
        Constructor constructor = String.class.getConstructor(StringBuffer.class);
        String str2 = (String)constructor.newInstance(new StringBuffer("123"));

        Constructor[] constructors = Class.forName("java.lang.String").getConstructors();
        // no parameters constructor
        String str3 = (String)Class.forName("java.lang.String").newInstance();

        //System.out.println("str3:"+str3);

        //2 Fields

        ReflectPoint point = new ReflectPoint(3,5);
        Field[] fds = point.getClass().getDeclaredFields();

        Field yfd = point.getClass().getDeclaredField("y");
        yfd.setAccessible(true);// set access for private property
        System.out.println(yfd.get(point));

        for(Field f:fds){
            f.setAccessible(true);
            if(f.getType() == int.class){
                f.set(point,8);
            }
        }
        System.out.println(point.getX()+"--"+point.getY());

        //3 methods
        Method msd = point.getClass().getMethod("add",int.class);
        Method msd2 = point.getClass().getMethod("run");
        System.out.println(msd.invoke(point,3));
        System.out.println(msd2.invoke(null));//static method, pass null

        //TestMain.main(new String[]{"hello","world"});

        Method method = TestMain.class.getMethod("main",String[].class);
        //method.invoke(null,new Object[]{new String[]{"tian","hang"}});

        method.invoke(null,(Object)new String[]{"tian","hang"});

        System.out.println(point.getClass().getClass());

        int[] a = new int[]{1,2,3};
        String[] strArr = new String[]{"hello","tianahng"};

        //Object[] o = (Object[]) a;
        System.out.println(Arrays.asList(a));
        System.out.println(Arrays.asList(strArr));

        Object[] oArr = new Object[]{"11",22,90.00};
        System.out.println(oArr[0].getClass().getName());
        System.out.println(oArr[1].getClass().getName());
        System.out.println(oArr[2].getClass().getName());

        InputStream ips = Main.class.getClassLoader().getResourceAsStream("com/company/config.properties");
        Properties props = new Properties();
        props.load(ips);
        ips.close();

        System.out.println(props.get("name"));
    }
}
