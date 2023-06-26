package goodstart.gocareer.controllers;

import goodstart.gocareer.models.Psychologist;
import goodstart.gocareer.repositories.PsychologistRepository;
import goodstart.gocareer.services.PsychologistService;
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
public class PsychologistController {
    @Autowired
    private PsychologistService psychologistService;
    private final PsychologistRepository psychologistRepository;

    public PsychologistController(PsychologistRepository psychologistRepository) {
        this.psychologistRepository=psychologistRepository;
    }

    @Transactional(readOnly = true)
    @GetMapping("/psychologists")
    public ResponseEntity<List<Psychologist>> getAllPsychologists(){
        return new ResponseEntity<List<Psychologist>>(this.psychologistRepository.findAll(), HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    @GetMapping("/psychologists/findByName")
    public ResponseEntity<List<Psychologist>> getPsychologistByName(@RequestParam(name = "name") String name){
        return new ResponseEntity<List<Psychologist>>(this.psychologistRepository.getPsychologistByName(name), HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    @GetMapping("/psychologists/findBySpecialty")
    public ResponseEntity<List<Psychologist>> getPsychologistBySpecialty(@RequestParam(name = "specialty") String specialty){
        return new ResponseEntity<List<Psychologist>>(this.psychologistRepository.getPsychologistBySpecialty(specialty), HttpStatus.OK);
    }
}
