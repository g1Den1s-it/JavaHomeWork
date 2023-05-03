package org.example.Lab_2;

import java.util.Scanner;

public class Main {
    private static String name;
    private static int age;
    private static Scanner scanner = new Scanner(System.in);
    public static String getName() {
        return name;
    }

    public static void setName() {
        System.out.print("Enter your name: ");
        name = scanner.nextLine();
    }

    public static void setAge() {
        System.out.print("Enter your age: ");
        age = scanner.nextInt();
    }

    public static int getAge() {
        return age;
    }

    public static void getInfo(){
        System.out.println("Your name is " + getName() + "\nyour age is " + getAge());
    }
    public static void main(String[] args) {

        setName();
        setAge();
        getInfo();
    }


}