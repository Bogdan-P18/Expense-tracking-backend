package expense_tracker_backend.expense_tracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"expense_tracker_backend.expense_tracker.model",
		"expense_tracker_backend.expense_tracker.repository",
		"expense_tracker_backend.expense_tracker.service",
		"expense_tracker_backend.expense_tracker.controller"})
public class ExpenseTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpenseTrackerApplication.class, args);
	}

}
