package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.swing.text.html.Option;
import java.util.Optional;

public class GetController {
    @GetMapping("greeting")
    public String sayHello(
            @RequestParam(required = false, defaultValue = "Hello") String say,
            @RequestParam(required = false, defaultValue = "NONAME") String to
    ) {
        return say + ' ' + to;
    }

    @GetMapping(
            value = {
                    "/greeting1/{say}/{to}",
                    "/greeting1/{say}",
                    "/greeting1/{to}",
                    "/greeting1",
            }
    )
    public String sayHello(
            @PathVariable Optional<String> say,
            @PathVariable Optional<String> to
            ) {
        String Say = say.isPresent() ? say.get(): "Hello";
        String To = to.isPresent() ? say.get(): "NONAME";
        return Say + ' ' + To;
    }
}
