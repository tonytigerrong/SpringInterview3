package rc.springinterview.multiplemodules.presistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rc.springinterview.multiplemodules.models.User;
@Repository
public interface UserRepo extends JpaRepository<User, Long> {
}
