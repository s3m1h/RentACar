package kodlama.io.rentACar.dataAccess.abstracts;

import kodlama.io.rentACar.entities.concrete.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
