package goodstart.gocareer.repositories;

import goodstart.gocareer.models.Specialist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpecialistRepository extends JpaRepository<Specialist,Long> {
    List<Specialist> getPsychologistByName(String name);
    List<Specialist> getPsychologistBySpecialty(String speciality);
}
