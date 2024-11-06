package expense_tracker_backend.expense_tracker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {
    @GetMapping("/hello")
    public String greetings() {
        return "Hello";
    }
    @GetMapping("/")
    public String greetings2() {
        return "Hello world!";
    }
}
