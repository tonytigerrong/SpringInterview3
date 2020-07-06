package rc.springinterview.multiplemodules.service;

import rc.springinterview.multiplemodules.models.User;

import java.util.List;

public interface UserService {
    void save (User user);
    void saveAll(List<User> users);
    User findByUsername(String username);
    long count();
}
