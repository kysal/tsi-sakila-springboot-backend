package UIElements.theSoftwareInstitute.User;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserController {

    private final UserRepository repo;

    UserController(UserRepository userRepository) {
        this.repo = userRepository;
    }

}
