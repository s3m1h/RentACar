package kodlama.io.rentACar.dataAccess.abstracts;

import kodlama.io.rentACar.entities.concrete.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
}
