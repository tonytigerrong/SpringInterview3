package rc.springinterview.multiplemodules.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import rc.springinterview.multiplemodules.models.Role;
import rc.springinterview.multiplemodules.models.User;
import rc.springinterview.multiplemodules.presistence.UserRepo;
import rc.springinterview.multiplemodules.service.UserServiceImpl;
import rc.springinterview.multiplemodules.utils.MyUserDetails;

import java.util.Arrays;
import java.util.List;


@SpringBootApplication
@ComponentScan(value = "rc.springinterview.multiplemodules.*")
@EnableJpaRepositories(value="rc.springinterview.multiplemodules.*")
@EntityScan("rc.springinterview.multiplemodules.*")
public class ApplicationDemo {
    public static void main(String[] args){
        SpringApplication.run(ApplicationDemo.class);
    }
    /**
     * @Autowried method will execute when loading the spring boot application
     * Once we add user, accessing the following url for taking a token
     *   POST / Params : client_id/secret/scope/grant_type/username/password
     *      http://localhost:8080/oauth/token?client_id=my_trusted_client&secret=secret&scope=read&grant_type=password&username=username1&password=password1
     */
    @Autowired
    public void authenticationManager(AuthenticationManagerBuilder builder,
                                      UserServiceImpl userService) throws Exception {
        // Create a User for login
        if(userService.count()==0){
            User user = new User("username1","password1",Arrays.asList(
                    new Role("USER")
            ));
            userService.save(user);
        }
        // set UserDetailService implementation of AuthenticationManagerBuilder
        builder.userDetailsService(new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return new MyUserDetails(userService.findByUsername(username));
                ////////////////////////////////
//                User user = userService.findByUsername(username);
//                if(user == null){
//                    throw new UsernameNotFoundException("Invalid username or password.");
//                }
//                return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority());
                ////////////////////////////////
            }
//            private List getAuthority() {
//                return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
//            }
        });
    }

}
