package expense_tracker_backend.expense_tracker.controller;

import expense_tracker_backend.expense_tracker.model.User;
import expense_tracker_backend.expense_tracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User register(User user) {
        return userService.register(user);
    }
}