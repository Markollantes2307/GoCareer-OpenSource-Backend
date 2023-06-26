package goodstart.gocareer.repositories;

import goodstart.gocareer.models.Date;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DateRepository extends JpaRepository<Date,Long> {
}
