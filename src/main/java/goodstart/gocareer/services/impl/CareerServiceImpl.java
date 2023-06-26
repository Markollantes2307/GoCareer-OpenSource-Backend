package goodstart.gocareer.services.impl;

import goodstart.gocareer.models.Career;
import goodstart.gocareer.repositories.CareerRepository;
import goodstart.gocareer.services.CareerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CareerServiceImpl implements CareerService {
    @Autowired
    private CareerRepository careerRepository;
    @Override
    public Career createCareer(Career career) {
        return careerRepository.save(career);
    }
}
