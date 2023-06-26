package goodstart.gocareer.repositories;

import goodstart.gocareer.models.Career;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CareerRepository extends JpaRepository<Career,Long> {
    List<Career> getCareerByName(String name);
}
