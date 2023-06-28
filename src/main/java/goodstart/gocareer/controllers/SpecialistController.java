package goodstart.gocareer.controllers;

import goodstart.gocareer.models.Specialist;
import goodstart.gocareer.repositories.SpecialistRepository;
import goodstart.gocareer.services.SpecialistService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class SpecialistController {
    @Autowired
    private SpecialistService specialistService;
    private final SpecialistRepository specialistRepository;

    public SpecialistController(SpecialistRepository specialistRepository) {
        this.specialistRepository = specialistRepository;
    }

    @Transactional(readOnly = true)
    @GetMapping("/psychologists")
    public ResponseEntity<List<Specialist>> getAllPsychologists(){
        return new ResponseEntity<List<Specialist>>(this.specialistRepository.findAll(), HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    @GetMapping("/psychologists/findByName")
    public ResponseEntity<List<Specialist>> getPsychologistByName(@RequestParam(name = "name") String name){
        return new ResponseEntity<List<Specialist>>(this.specialistRepository.getPsychologistByName(name), HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    @GetMapping("/psychologists/findBySpecialty")
    public ResponseEntity<List<Specialist>> getPsychologistBySpecialty(@RequestParam(name = "specialty") String specialty){
        return new ResponseEntity<List<Specialist>>(this.specialistRepository.getPsychologistBySpecialty(specialty), HttpStatus.OK);
    }
}
