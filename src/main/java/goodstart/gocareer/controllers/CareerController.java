package goodstart.gocareer.controllers;

import goodstart.gocareer.models.Career;
import goodstart.gocareer.repositories.CareerRepository;
import goodstart.gocareer.services.CareerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gocareer/v1")
public class CareerController {
    @Autowired
    private CareerService careerService;
    private final CareerRepository careerRepository;

    public CareerController(CareerRepository careerRepository){
        this.careerRepository=careerRepository;
    }

    @Transactional(readOnly = true)
    @GetMapping("/careers")
    public ResponseEntity<List<Career>> getAllCareers(){
        return new ResponseEntity<List<Career>>(this.careerRepository.findAll(), HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    @GetMapping("/careers/filterByName")
    public ResponseEntity<List<Career>> getCareersByName(@RequestParam(name = "name") String name){
        return new ResponseEntity<List<Career>>(this.careerRepository.getCareerByName(name),HttpStatus.OK);
    }

    @Transactional
    @PostMapping("/careers")
    public ResponseEntity<Career> postNewCareer(@RequestBody Career career){
        validateCareer(career);
        return new ResponseEntity<>(careerService.createCareer(career),HttpStatus.CREATED);
    }

    private void validateCareer(Career career){

    }
}
