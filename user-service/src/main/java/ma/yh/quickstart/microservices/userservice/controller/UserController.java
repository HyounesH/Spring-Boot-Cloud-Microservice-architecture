package ma.yh.quickstart.microservices.userservice.controller;

import lombok.extern.slf4j.Slf4j;
import ma.yh.quickstart.microservices.userservice.VO.Department;
import ma.yh.quickstart.microservices.userservice.VO.ResponseTemplateVO;
import ma.yh.quickstart.microservices.userservice.model.User;
import ma.yh.quickstart.microservices.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/save")
    public ResponseEntity<User> save(@RequestBody User user) {
        log.info("Inside save method of UserController class");
        return ResponseEntity.ok(userService.save(user));
    }

    @GetMapping("/findById/{userId}")
    public ResponseEntity<ResponseTemplateVO> findById(@PathVariable("userId") Long userId) {
        Optional<User> user = userService.findUserById(userId);
        if (user.isPresent()) {
            Department department = restTemplate.getForObject(String.format("http://department-service/departments//findById/%d", user.get().getDepartmentId()),
                    Department.class);
            return ResponseEntity.ok(ResponseTemplateVO.of(user.get(), department));
        }
        return ResponseEntity.ok(ResponseTemplateVO.of(user.get(), null));
    }

}
