package org.example;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CustomClass {
    private String name;

    public CustomClass(String name) {
        this.name = name;
    }

    public void greet() {
        System.out.println("Hello, my name is " + name + "!");
    }

    public int add(int x, int y) {
        return x + y;
    }

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
        CustomClass obj = new CustomClass("John");

        Method[] methods = obj.getClass().getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName() + ": " + method.getReturnType().getSimpleName());
        }

        String methodName = "add";
        try {
            Method method = obj.getClass().getDeclaredMethod(methodName, int.class, int.class);
            int result = (int) method.invoke(obj, 2, 3);
            System.out.println("Result of invoking " + methodName + ": " + result);
        } catch (NoSuchMethodException e) {
            System.out.println("Method " + methodName + " not found.");
        }
    }
}
