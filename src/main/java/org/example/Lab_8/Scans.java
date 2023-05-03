package org.example.Lab_8;

import java.util.Scanner;

public class Scans {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getInfo(){
        return "Your name is " + getName() + "\nyour age is " + getAge();
    }
}
