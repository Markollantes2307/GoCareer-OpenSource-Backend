package goodstart.gocareer.repositories;

import goodstart.gocareer.models.Psychologist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PsychologistRepository extends JpaRepository<Psychologist,Long> {
    List<Psychologist> getPsychologistByName(String name);
    List<Psychologist> getPsychologistBySpecialty(String speciality);
}
