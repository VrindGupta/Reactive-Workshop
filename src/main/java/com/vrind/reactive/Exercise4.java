package com.vrind.reactive;

import java.io.IOException;
import java.util.Optional;

public class Exercise4 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono()

        // Print the value from intNumberMono when it emits
        // TODO: Write code here
        ReactiveSources.intNumberMono().subscribe(System.out::println);

        // Get the value from the Mono into an integer variable
        // TODO: Write code here
        Integer integer = ReactiveSources.intNumberMono().block();
        System.out.println("Integer from Mono: " + integer);

        Optional<Integer> optionalInteger = ReactiveSources.intNumberMono().blockOptional();
        System.out.println("Optional Integer from Mono: " + integer);

        //Get the value from the Mono into an User variable
        User user = ReactiveSources.userMono().block();
        System.out.println("User from Mono: " + user);

        System.out.println("Press a key to end");
        System.in.read();
    }

}
