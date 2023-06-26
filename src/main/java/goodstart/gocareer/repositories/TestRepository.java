package goodstart.gocareer.repositories;

import goodstart.gocareer.models.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test,Long> {
}
