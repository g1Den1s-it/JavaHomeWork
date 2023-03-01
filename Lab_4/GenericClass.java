package org.example;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class GenericClass {
    public static <T extends MyInterface> void callMethodOnInterface(T obj, String methodName) {
        try {
            Method method = obj.getClass().getMethod(methodName);
            method.invoke(obj);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyClass obj = new MyClass();
        callMethodOnInterface(obj, "foo");
    }
}

