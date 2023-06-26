package goodstart.gocareer.repositories;

import goodstart.gocareer.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
