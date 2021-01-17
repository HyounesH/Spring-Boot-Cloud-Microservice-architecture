package ma.yh.quickstart.microservices.userservice.service;

import lombok.extern.slf4j.Slf4j;
import ma.yh.quickstart.microservices.userservice.model.User;
import ma.yh.quickstart.microservices.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        log.info("inside save method of UserService class");
        return userRepository.save(user);
    }


    public Optional<User> findUserById(Long userId) {
        return userRepository.findById(userId);
    }
}
