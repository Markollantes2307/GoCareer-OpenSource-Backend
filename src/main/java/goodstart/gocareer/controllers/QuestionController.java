package goodstart.gocareer.controllers;

import goodstart.gocareer.models.Question;
import goodstart.gocareer.models.Test;
import goodstart.gocareer.repositories.QuestionRepository;
import goodstart.gocareer.services.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/gocareer/v1")
public class QuestionController {
    private final QuestionRepository questionRepository;

    public QuestionController(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Transactional(readOnly = true)
    @GetMapping("/questions")
    public ResponseEntity<List<Question>> getQuestionsForTestByTitle(@RequestParam(name = "title") String title){
        return new ResponseEntity<List<Question>>(this.questionRepository.getQuestionsByTestTitle(title), HttpStatus.OK);
    }
}
