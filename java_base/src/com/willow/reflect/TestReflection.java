package com.willow.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestReflection {




    public static void main(String arg[]) {

        Class<?>[] classes = TestReflection.class.getClasses();
        System.out.println("c" + classes);
        try {
            Class<?> aClass = Class.forName("com.willow.reflect.TestReflection");
            Method[] declaredMethods = aClass.getDeclaredMethods();
            for (int i = 0; i < declaredMethods.length; i++) {
                System.out.println("Method   :"+declaredMethods[i] );
                System.out.println("return    :"+declaredMethods[i].getReturnType());
                System.out.println("Annotation    :"+declaredMethods[i].getAnnotations());
            }
            Field[] declaredFields = aClass.getDeclaredFields();
            for (int i = 0; i < declaredFields.length; i++) {
                System.out.println("Field    :"+declaredFields[i]);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        Class clazz =User.class;
        Field[] fields = clazz.getFields();//返回所有的字段
    }

    public Integer id;
    public String name;
    public Double money;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}
