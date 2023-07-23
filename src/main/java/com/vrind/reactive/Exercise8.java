package io.javabrains.reactiveworkshop;

import com.vrind.reactive.ReactiveSources;
import reactor.core.publisher.Flux;

import java.io.IOException;

public class Exercise8 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFluxWithException()

        // Print values from intNumbersFluxWithException and print a message when error happens
        ReactiveSources.intNumbersFluxWithException()
                .subscribe(num -> System.out.println(num),
                        err -> System.out.println("An error happened"));

        ReactiveSources.intNumbersFluxWithException()
                .doOnError(err -> System.out.println("Error!!! " + err.getMessage() ))
                .subscribe(System.out::println);

        // Print values from intNumbersFluxWithException and continue on errors
        ReactiveSources.intNumbersFluxWithException()
                .onErrorContinue((err,item) -> System.out.println("Error!!! " + err.getMessage() ))
                .subscribe(System.out::println);

        // Print values from intNumbersFluxWithException and when errors
        // happen, replace with a fallback sequence of -1 and -2
        ReactiveSources.intNumbersFluxWithException()
                .onErrorResume(e -> Flux.just(-1,-2))
                .subscribe(System.out::println);

        System.out.println("Press a key to end");
        System.in.read();
    }

}
