package org.example.Lab_5;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamTask {
    public static void main(String[] args) {

        int n = 10;
        if(args.length > 0){
            try{
                n = Integer.parseInt(args[0]);
            }catch (Exception e){
                System.out.println("can't parser int from " + args[0]);
                e.printStackTrace();
            }
        }

        List<DateEntity> dateEntityList = generateDataEntityList(n);
        System.out.println("List of date Entity list");
        System.out.println(dateEntityList);

        System.out.println("Sorted date Entity list");
        System.out.println(dateEntityList.stream().sorted().collect(Collectors.toList()));

        System.out.println("filter to random date in date Entity list");
        System.out.println(dateEntityList.stream().filter(date -> {return LocalDate.parse(date.getDate()).compareTo(LocalDate.parse("2019-11-11")) > 0;}).collect(Collectors.toList()));

        System.out.println("map in date Entity list");
        System.out.println(dateEntityList.stream().map(DateEntity::getEvent).collect(Collectors.toList()));
    }
    public static List<DateEntity> generateDataEntityList(int n){
        Random random = new Random();
        List<DateEntity> dateEntityList = new ArrayList<>();

        IntStream.range(1, n).forEach(i->{

            DateEntity dateEntity = new DateEntity();
            dateEntity.setEvent("Event " + UUID.randomUUID().toString().substring(0,8));

            int year = random.nextInt(2022 - 2000 + 1) + 2000;
            int month = random.nextInt(12) + 1;
            int day = random.nextInt(LocalDate.of(year, month, 1).lengthOfMonth()) + 1;
            LocalDate randomDate = LocalDate.of(year, month, day);
            String formattedRandomDate = randomDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            dateEntity.setDate(formattedRandomDate);

            List<String> guestsList = new ArrayList<String>();

            int guests = random.nextInt(15);
            for(int j = 0; i <= guests; i ++ ){
                guestsList.add("" + UUID.randomUUID().toString().substring(1, 12));
            }

            dateEntity.setGuests(guestsList);
            dateEntityList.add(dateEntity);
        });
        return dateEntityList;
    }
}
