package taskosaurus.authorization.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import taskosaurus.authorization.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
}