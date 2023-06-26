package goodstart.gocareer.repositories;

import goodstart.gocareer.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question,Long> {
    List<Question> getQuestionsByTestTitle(String title);
}
