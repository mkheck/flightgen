package com.thehecklers.flightgen;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;

@Controller
public class FlightController {
    private final FlightGenerator generator;

    public FlightController(FlightGenerator generator) {
        this.generator = generator;
    }

    @ResponseBody
    @GetMapping("/aircraft")
    public Flux<Aircraft> getCurrentAircraft() throws IOException {
        return Flux.range(1, 10)
                .map(i -> generator.generate())
                .log();
    }

    @MessageMapping("acstream")
    public Flux<Aircraft> getCurrentACStream(Mono<?> someMono) throws IOException {
        return someMono.doOnNext(mo -> System.out.println(mo))
                .thenMany(Flux.range(1, 10)
                        .map(i -> generator.generate()))
                .log();
    }
}
