package com.vrind.reactive;

import java.io.IOException;

public class Exercise2 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux() and ReactiveSources.userFlux()

        // Print all numbers in the ReactiveSources.intNumbersFlux stream
        // TODO: Write code heres
        ReactiveSources.intNumbersFlux()
                .subscribe(element -> System.out.println(element));

        // Print all users in the ReactiveSources.userFlux stream
        // TODO: Write code here
        ReactiveSources.userFlux().subscribe(element -> System.out.println(element.getFirstName()));

        System.out.println("Press a key to end. This is here to wait for the event to happen.");
        System.in.read();
    }

}
