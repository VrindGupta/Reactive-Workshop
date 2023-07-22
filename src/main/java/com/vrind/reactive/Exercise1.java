package com.vrind.reactive;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        // TODO: Write code here
        System.out.println("PRINT ALL NUMBERS");
        StreamSources.intNumbersStream().forEach(System.out::println);
        StreamSources.intNumbersStream().forEach(number -> System.out.println(number));

        // Print numbers from intNumbersStream that are less than 5
        // TODO: Write code here
        System.out.println("PRINT NUMBERS < 5");
        StreamSources.intNumbersStream()
                .filter(number -> number<5)
                .forEach(System.out::println);

        // Print the second and third numbers in intNumbersStream that's greater than 5
        // TODO: Write code here
        System.out.println("PRINT SECOND AND THIRD NUMBERS > 5");
        StreamSources.intNumbersStream()
                .filter(number -> number<5)
                .skip(1)
                .limit(2)
                .forEach(System.out::println);

        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        // TODO: Write code here
        System.out.println("PRINT FIRST NUMBER > 5 ELSE PRINT -1");
        Integer integer = StreamSources.intNumbersStream()
                .filter(number -> number>10)
                .findFirst()
                .orElse(-1);
        System.out.println(integer);

        // Print first names of all users in userStream
        // TODO: Write code here
        System.out.println("PRINT ALL USER'S FIRST NAME");
        StreamSources.userStream().forEach(user -> System.out.println(user.getFirstName()));

        // Print first names in userStream for users that have IDs from number stream
        // TODO: Write code here
        System.out.println("PRINT ALL USERS WITH ID FROM NUMBER STREAM");
        StreamSources.intNumbersStream()
                .flatMap(id -> StreamSources.userStream().filter(user -> user.getId() == id))
                .forEach(user -> System.out.println(user.getId()+ ":" +user.getFirstName()));

        System.out.println("ANOTHER WAY FOR THE ABOVE");
        StreamSources.userStream()
                .filter(user -> StreamSources.intNumbersStream()
                        .anyMatch(id -> id == user.getId()))
                .forEach(user -> System.out.println(user.getId()+ ":" +user.getFirstName()));
    }

}
