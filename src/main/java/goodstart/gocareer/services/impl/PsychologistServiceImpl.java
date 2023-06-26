package goodstart.gocareer.services.impl;

import goodstart.gocareer.models.Psychologist;
import goodstart.gocareer.repositories.PsychologistRepository;
import goodstart.gocareer.services.PsychologistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PsychologistServiceImpl implements PsychologistService {
    @Autowired
    private PsychologistRepository psychologistRepository;

    @Override
    public Psychologist createPsychologist(Psychologist psycho) {
        return psychologistRepository.save(psycho);
    }
}
