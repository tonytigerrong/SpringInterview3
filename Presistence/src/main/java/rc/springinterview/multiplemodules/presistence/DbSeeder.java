//package rc.springinterview.multiplemodules.presistence;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//import rc.springinterview.multiplemodules.models.Role;
//import rc.springinterview.multiplemodules.models.User;
//import rc.springinterview.multiplemodules.service.UserService;
//import rc.springinterview.multiplemodules.service.UserServiceImpl;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class DbSeeder implements CommandLineRunner {
//    private UserRepo userRepo;
//    @Qualifier("userServiceImpl")
//    @Autowired
//    private UserService userService;
//    public DbSeeder(UserRepo userRepo) {
//        this.userRepo = userRepo;
//    }
////    public DbSeeder(UserService userService) { this.userServiceImpl = (UserServiceImpl) userService;}
//    public void run(String... args) throws Exception {
//        Role role1 = new Role("ROLE1");
//        Role role2 = new Role("ROLE2");
//        List<Role> roles = new ArrayList<>();
//        roles.add(role1); roles.add(role2);
//        User user1 = new User();
//        user1.setUsername("username1"); user1.setPassword("password1");
//        user1.setRoles(roles);
//        User user2 = new User();
//        user2.setUsername("username2"); user2.setPassword("password2");
//        user2.setRoles(roles);
//        List<User> users = new ArrayList<>();
//        users.add(user1); users.add(user2);
////        role1.setUsers(users);
////        role2.setUsers(users);
////        this.userRepo.saveAll(users);
//        this.userService.saveAll(users);
//    }
//}
