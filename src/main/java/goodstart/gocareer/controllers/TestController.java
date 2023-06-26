package goodstart.gocareer.controllers;

import goodstart.gocareer.models.Test;
import goodstart.gocareer.repositories.TestRepository;
import goodstart.gocareer.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/gocareer/v1")
public class TestController {
    @Autowired
    private TestService testService;
    private final TestRepository testRepository;

    public TestController(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @Transactional(readOnly = true)
    @GetMapping("/tests")
    public ResponseEntity<List<Test>> getAllTest(){
        return new ResponseEntity<List<Test>>(this.testRepository.findAll(), HttpStatus.OK);
    }

    @Transactional
    @PostMapping("/tests")
    public ResponseEntity<Test> newTest(Test test){
        return new ResponseEntity<>(testService.createNewTest(test),HttpStatus.CREATED);
    }
}
