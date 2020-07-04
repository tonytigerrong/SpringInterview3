package rc.springinterview.multiplemodules.controller;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan(value = "rc.springinterview.multiplemodules.*")
@EnableJpaRepositories(value="rc.springinterview.multiplemodules.*")
@EntityScan("rc.springinterview.multiplemodules.*")
public class ApplicationDemo {
    public static void main(String[] args){
        SpringApplication.run(ApplicationDemo.class);
    }
}
