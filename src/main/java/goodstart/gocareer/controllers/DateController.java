package goodstart.gocareer.controllers;

import goodstart.gocareer.models.Career;
import goodstart.gocareer.models.Date;
import goodstart.gocareer.repositories.DateRepository;
import goodstart.gocareer.services.DateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gocareer/v1")
public class DateController {
    @Autowired
    private DateService dateService;
    private final DateRepository dateRepository;

    public DateController(DateRepository dateRepository){
        this.dateRepository=dateRepository;
    }

    @Transactional(readOnly = true)
    @GetMapping("/dates")
    public ResponseEntity<List<Date>> getAllDates(){
        return new ResponseEntity<List<Date>>(this.dateRepository.findAll(), HttpStatus.OK);
    }

    @Transactional
    @PostMapping("/dates")
    public ResponseEntity<Date> createNewDate(@RequestBody Date date){
        return new ResponseEntity<>(dateService.createDate(date),HttpStatus.CREATED);
    }
}
