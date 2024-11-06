package expense_tracker_backend.expense_tracker.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String username;

    @Column
    private String email;

    @Column
    private String password;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private Set<Expense> expenses = new HashSet<>();

    @Override
    public int hashCode() {
        return Objects.hash(id, username, email, password, expenses);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return id.equals(user.id) && username.equals(user.username) && email.equals(user.email)
                && password.equals(user.password) && expenses.equals(user.expenses);
    }

    @Override
    public String toString() {
        return "[User: Id=" + id + ", " + "Username=" + username + ", " + "Email=" + email + "]";
    }
}
