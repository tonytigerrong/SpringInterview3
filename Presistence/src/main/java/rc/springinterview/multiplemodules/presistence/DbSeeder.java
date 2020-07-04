package rc.springinterview.multiplemodules.presistence;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import rc.springinterview.multiplemodules.models.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class DbSeeder implements CommandLineRunner {
    private UserRepo userRepo;

    public DbSeeder(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public void run(String... args) throws Exception {
        User user1 = new User(); user1.setAge(11); user1.setFirstName("firstname1"); user1.setLastName("lastname1");
        User user2 = new User(); user2.setAge(12); user2.setFirstName("firstname2"); user2.setLastName("lastname2");
        List<User> users = new ArrayList<>();
        users.add(user1); users.add(user2);
        this.userRepo.saveAll(users);
    }
}
