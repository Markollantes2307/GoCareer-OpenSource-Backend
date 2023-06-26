package goodstart.gocareer.services.impl;

import goodstart.gocareer.models.User;
import goodstart.gocareer.repositories.UserRepository;
import goodstart.gocareer.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }
}
