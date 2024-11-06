package expense_tracker_backend.expense_tracker.service;

import expense_tracker_backend.expense_tracker.exceptions.UserNotFoundException;
import expense_tracker_backend.expense_tracker.model.User;
import expense_tracker_backend.expense_tracker.model.UserPrincipal;
import expense_tracker_backend.expense_tracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            User user = userRepository.findByUsername(username)
                    .orElseThrow(() -> new UserNotFoundException("No user with this username found!"));
            return new UserPrincipal(user);
        } catch (UserNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
