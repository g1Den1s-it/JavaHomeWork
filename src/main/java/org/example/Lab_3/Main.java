package org.example;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //array 1
        System.out.println("Enter the size of array 1: ");
        int size1 = scanner.nextInt();
        int[] arr1 = new int[size1];
        System.out.println("Enter elements of array 1: ");
        for(int i = 0; i < size1; i++){
            arr1[i] = scanner.nextInt();
        }

        //array 2
        System.out.println("Enter the size of array 2: ");
        int size2 = scanner.nextInt();
        int[] arr2 = new int[size2];
        System.out.println("Enter elements of array 2: ");
        for(int i = 0; i < size2; i++){
            arr2[i] = scanner.nextInt();
        }

        List<Integer> intersectionList = new ArrayList<>();
        for (int i = 0; i < size1; i++) {
            for (int j = 0; j < size2; j++) {
                if (arr1[i] == arr2[j]) {
                    intersectionList.add(arr1[i]);
                    break;
                }
            }
        }
        Map<Integer, String> map = new HashMap<>();
        System.out.print("Intersection of the two arrays: ");
        for(int num : intersectionList){
            map.put(num, "value");
            System.out.print(num + "");
        }

        //Add a key-value pair to the map
        map.put(10, "new value");

        //Remove a key-value pair from the map
        map.remove(5);

        //Check if a key is in the map
        if (map.containsKey(3)) {
            System.out.println("\nThe map contains the key 3");
        } else {
            System.out.println("The map does not contain the key 3");
        }

        //Find the value associated with a given key
        System.out.println("The value associated with key 2 is: " + map.get(2));

        //Print all the keys and values in the map
        for(Map.Entry<Integer, String> entry : map.entrySet()){
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        //NumberFormatException
        String str = "hello";
        try {
            int num = Integer.parseInt(str);
            System.out.println(num);
        } catch (Exception e){
            System.out.println(e);
        }
    }
}