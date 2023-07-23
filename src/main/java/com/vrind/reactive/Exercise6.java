package com.vrind.reactive;

import java.io.IOException;
import java.time.Duration;

public class Exercise6 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.unresponsiveFlux() and ReactiveSources.unresponsiveMono()

        // Get the value from the Mono into a String variable but give up after 5 seconds
        ReactiveSources.unresponsiveMono()
                .log()
                .take(Duration.ofSeconds(5))
                .subscribe(System.out::println);

        // Get the value from unresponsiveFlux into a String list but give up after 5 seconds
        // Come back and do this when you've learnt about operators!
        ReactiveSources.unresponsiveFlux()
                .take(Duration.ofSeconds(5))
                .log()
                .subscribe(System.out::println);

        System.out.println("Press a key to end");
        System.in.read();
    }

}