package rc.springinterview.multiplemodules.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import rc.springinterview.multiplemodules.models.User;
import rc.springinterview.multiplemodules.presistence.UserRepo;

import java.util.List;

@RestController
public class UserController {

    private UserRepo userRepo;

    public UserController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        List<User> users = this.userRepo.findAll();
        return users;
    }
}
