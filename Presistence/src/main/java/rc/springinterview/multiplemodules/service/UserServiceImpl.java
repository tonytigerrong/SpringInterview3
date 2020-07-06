package rc.springinterview.multiplemodules.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import rc.springinterview.multiplemodules.models.User;
import rc.springinterview.multiplemodules.presistence.UserRepo;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        this.userRepo.save(user);
    }
    @Override
    public void saveAll(List<User> users){
        for(User user : users){
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        }
        this.userRepo.saveAll(users);
    }

    @Override
    public User findByUsername(String username) {
        return this.userRepo.findByUsername(username);
    }
    @Override
    public long count(){
        return this.userRepo.count();
    }
}
