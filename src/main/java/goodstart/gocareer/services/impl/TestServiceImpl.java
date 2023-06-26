package goodstart.gocareer.services.impl;

import goodstart.gocareer.models.Test;
import goodstart.gocareer.repositories.TestRepository;
import goodstart.gocareer.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestRepository testRepository;
    @Override
    public Test createNewTest(Test test) {
        return testRepository.save(test);
    }
}
