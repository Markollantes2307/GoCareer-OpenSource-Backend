package goodstart.gocareer.controllers;

import goodstart.gocareer.exceptions.ValidationException;
import goodstart.gocareer.models.Career;
import goodstart.gocareer.models.User;
import goodstart.gocareer.repositories.UserRepository;
import goodstart.gocareer.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gocareer/v1")
public class UserController {
    @Autowired
    private UserService userService;
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<List<User>>(this.userRepository.findAll(), HttpStatus.OK);
    }

    @Transactional
    @PostMapping("/users")
    public ResponseEntity<User> createNewUser(@RequestBody User user){
        validateUser(user);
        return new ResponseEntity<>(userService.createUser(user),HttpStatus.CREATED);
    }

    private void validateUser(User user){
        if (user.getUsername().length()>20 || user.getUsername()==null || user.getUsername().trim().isEmpty()){
            throw new ValidationException("Username is not accepted, it must have 20 characters max");
        }
        if (user.getPassword().length()>10 || user.getUsername()==null || user.getUsername().trim().isEmpty()){
            throw new ValidationException("Password not accepted, it must have 10 different characters");
        }
    }
}
