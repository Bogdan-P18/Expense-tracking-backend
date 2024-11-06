package expense_tracker_backend.expense_tracker.controller;

import expense_tracker_backend.expense_tracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExpenseController {
    @Autowired
    private ExpenseRepository expenseRepository;
}
