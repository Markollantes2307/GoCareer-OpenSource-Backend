package goodstart.gocareer.services.impl;

import goodstart.gocareer.models.Specialist;
import goodstart.gocareer.repositories.SpecialistRepository;
import goodstart.gocareer.services.SpecialistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpecialistServiceImpl implements SpecialistService {
    @Autowired
    private SpecialistRepository specialistRepository;

    @Override
    public Specialist createPsychologist(Specialist psycho) {
        return specialistRepository.save(psycho);
    }
}
