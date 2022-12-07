package UIElements.theSoftwareInstitute.User;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;


import java.rmi.ServerException;

@RequestMapping("/user")
@RestController
public class UserController {

    private final UserRepository repo;


    UserController(UserRepository userRepository) {
        this.repo = userRepository;
    }

    @GetMapping("")
    public @ResponseBody Iterable<User> getAllUsers() { return repo.findAll(); }

    @GetMapping("/userId/{userId}")
    public @ResponseBody User getUserById(@PathVariable(value = "userId") Integer userId) {
        return repo.findById(userId).orElseThrow(() -> new ResourceAccessException("No user found"));
    }

    @GetMapping("/username/{username}")
    public @ResponseBody User getUserByUsername(@PathVariable(value = "username") String username) {
        return repo.findByUsername(username);
    }

    @PostMapping(value = "/register",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<User> createUser(@RequestBody User newUser) throws ServerException {
        // INSERT VALIDATION
        if (repo.findByUsername(newUser.getUsername()) == null) {

            User user = repo.save(newUser);
            if (user == null) throw new ServerException("Server failed");
            else return new ResponseEntity<>(user, HttpStatus.CREATED);
        } else return new ResponseEntity<>(null, HttpStatus.CONFLICT);
    }


//    @PostMapping("/authenticate")



}
