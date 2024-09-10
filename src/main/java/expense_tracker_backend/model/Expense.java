package expense_tracker_backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "expenses")
@Getter
@Setter
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column
    private ExpenseType type;

    @Column
    private Date datePaid;

    @Column
    private Double amount;

    @Column
    private String details;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Override
    public int hashCode() {
        return Objects.hash(id, type, datePaid, amount, details);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Expense expense = (Expense) o;
        return id.equals(expense.id) && type.equals(expense.type) && datePaid.equals(expense.datePaid)
                && amount.equals(expense.amount) && details.equals(expense.details);
    }

    @Override
    public String toString() {
        return "[Expense: Id=" + id + ", " + "Type=" + type + ", " + "DatePaid=" + datePaid + ", "
                + "Amount=" + amount + ", " + "Details=" + details + "]";

    }
}
